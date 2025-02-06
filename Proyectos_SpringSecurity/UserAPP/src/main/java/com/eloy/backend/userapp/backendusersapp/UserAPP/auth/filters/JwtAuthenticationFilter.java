package com.eloy.backend.userapp.backendusersapp.UserAPP.auth.filters;

import java.io.IOException;
import java.net.Authenticator;

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

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        User user = null;
        String username = null;
        String password = null;
        
        try {
            /*Recibimos un flujo de datos con el getInputStream 
             * Mediante el objectMapper cogemos los datos y los mapeamos
             * a un objeto de tipo User
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
         * Creamoe el token para dicho usuario y será lo que retorno el método.
         */
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password)
    
        return authenticationManager.authenticate(authToken);

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {

    }

    

    


}
