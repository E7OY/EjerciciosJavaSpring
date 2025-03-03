package com.eloy.backend.userapp.backendusersapp.UserAPP.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.eloy.backend.userapp.backendusersapp.UserAPP.auth.filters.JwtAuthenticationFilter;

@Configuration
public class SpringSecurityCofig {

    @Autowired
    AuthenticationConfiguration authenticationConfiguration;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //metodo para configurar la cadena de filtros de seguridad
    @SuppressWarnings("removal")
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests()
        /*todas las peticiones que coincidad  (requestMatchers) con peticiones GET a /users todo el mundo puede
        acceder a la vista (permiteALL)*/
        .requestMatchers(HttpMethod.GET, "/users").permitAll()
        /*Para que para cualquier otra peticion (anyRequest) el usuario deberá estar autenticado
        para acceder a la vista (authenticated)*/
        .anyRequest().authenticated()
        .and()
        .addFilter(new JwtAuthenticationFilter(authenticationConfiguration.getAuthenticationManager()))
        /*El metodo crsf se usa para evitar exploits o vulnerabilidades en los
        formularios.*/
        .csrf((config -> config.disable()))
        /* configuramos el sessionManagement para indicar que la aplicación no va a manejar sesiones STATELESS 
        es decir que no se va a manejar sesiones, por lo que no se va a guardar información del usuario
        */
        .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
        
    }

}
