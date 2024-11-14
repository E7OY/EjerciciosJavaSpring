package edu.eloy.SenhorDeLosAnillos.controllers;

import org.springframework.web.bind.annotation.RestController;
import edu.eloy.SenhorDeLosAnillos.entities.Personaje;
import edu.eloy.SenhorDeLosAnillos.services.iPersonajesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/personajes")

public class personajesController {

    @Autowired
    iPersonajesService personajesService;

    //Para obtener personajes son peticiones get
    @GetMapping("/all")
    public List<Personaje> getPersonajes() {
        return personajesService.buscarPersonajes();
    }
    
    @GetMapping("/{id}")
    public Personaje getPersonajeId(@PathVariable("id") Integer idUrl) {
        return personajesService.buscarPersonajePorId(idUrl);
    }
    
    @DeleteMapping("/{id}")   //desde el navegador solo podemos mandar peticiones get, por lo que para las delete usamos postman
    public void borrarPersonaje(@PathVariable("id") Integer idUrl) {
        personajesService.borrarPersonaje(idUrl);
    }

    //Para añadir personajes son peticiones post
    @PostMapping("/guardar")
    public Personaje guardarPersonaje(@RequestBody Personaje personaje) {  //requestbody, en el postman escribimos desde la pestaña body el objeto
        return personajesService.guardarPersonaje(personaje);
    }
    

}
