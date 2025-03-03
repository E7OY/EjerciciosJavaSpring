package com.eloy.backend.userapp.backendusersapp.UserAPP.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class JpaUserDetalisService implements UserDetailsService{


    /*este método recibe un nombre de usuario y devuelve si existe un objeto UserDetails, es decir, un
     * objeto que contendrá toda la info del usuario
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //si el username no es admin
        if (!username.equals("admin")) {
            throw new UsernameNotFoundException(String.format("El usuario %s no existe en el sistema", username));
        }

        //definimos la lista de authorities, cada role se define con un string que comienza por ROLE
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        //si el username es admin, devolvemos un objeto User que no será nuestro Entity
        return new User(
            username,  //el username
            "$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS", //el password
            true,  //el boolean "enabled" que define si está o no está activo,
            true,  //el boolean "accountNonExpired" que define si la cuenta está o no caducada,
            true,  //el boolean "credentialNonExpired" que define si las credenciales del usuario están o no caducadas,
            true,  //el boolean "accountNonLocked" que define si el usuario está bloqueado o no,
            authorities);  //la lista "authorities" que contendrá los distintos roles que podrá tener cada usuario.
            //como en el array authorities solo está el role "ROLE_USER" será este el rol definido para este objeto usuario.
    }

}
