package com.eloy.backend.userapp.backendusersapp.UserAPP.auth.filters;

import java.io.IOException;
import java.net.Authenticator;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import org.apache.catalina.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*Archivo para configurar el filtrado del login que se realizará en un formulario en el frontend
 * y se nos enviará a un objeto JSON
  */

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        User user = null;
        String username = null;
        String password = null;
        
        try {
            /*Recibimos un flujo de datos con el getInputStream 
             *Mediante el objectMapper cogemos los datos y los mapeamos
             *a un objeto de tipo User
            */
            user = new ObjectMapper().readValue(request.getInputStream(), User.class);
            username = user.getUsername();
            password = user.getPassword();

            /*Mostramos en consola los datos que llegan en el InputStream*/
            logger.info("Username que llega en el InputStream: " + username);
            logger.info("Password que llega en el InputStream: " + password);

        } catch(StreamReadException e) {
            e.printStackTrace();
        } catch(DatabindException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }

        /*
         * Creamoe el token para dicho usuario y será lo que retorna el método.
         */
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
    
        /*El método authenticate hara toda la autenticacion verfiicando los datos
        contra una fuente de datos, en este caso la base de datos
         */
        return authenticationManager.authenticate(authToken);

    }

    /*Aquí manejamos en caso de que el intento de autenticación ha sido sido exitosa */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

                /*Almacenamos el username, que extraemos del objeto authResult invocando al metodo getPrincipal,
                (le estamos, dame el nombre de usuario que contiene el objeto resultante de la autenticación exitosa)
                 */
                String username = ((User) authResult.getPrincipal()).getUsername();
                String originalInput = "PALABRA_SECRETA." + username;
                /*codificamos el unput, que como es String y hay que codificar a bytes usamos getbytes() */
                String token = Base64.getEncoder().encodeToString(originalInput.getBytes());

                /*creamos la respuesta HTTP al usuario diciendo que está autenticado */
                response.addHeader("Authorization", "Bearer " + token);

                /*introducimos en el cuerpo "body" de la respuesta el token y el nombre de usuario
                 * usando un mapa con pares clave-valor
                 */
                Map<String, Object> body = new HashMap<>();
                body.put("token", token);
                body.put("message", String.format("Hola %S! has iniciado sesion con exito!", username));
                body.put("username", username);
                /*Metemos en la respuesta el body en forma de JSON mediante ObjectMapper y writeValueAsString */
                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setStatus(200);
                response.setContentType("application/json");

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

                /*introducimos en el cuerpo "body" de la respuesta el token y el nombre de usuario
                 * usando un mapa con pares clave-valor
                 */
                Map<String, Object> body = new HashMap<>();
                body.put("message", "Erroe en el login! username o password incorrectos");
                body.put("error", failed.getMessage());
                /*Metemos en la respuesta el body en forma de JSON mediante ObjectMapper y writeValueAsString */
                response.getWriter().write(new ObjectMapper().writeValueAsString(body));
                response.setStatus(401);
                response.setContentType("application/json");

    }

}
