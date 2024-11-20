package edu.eloy.SenhorDeLosAnillos.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import edu.eloy.SenhorDeLosAnillos.entities.Artefacto;
import edu.eloy.SenhorDeLosAnillos.services.iArtefactosService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/artefactos")

public class artefactoController {

    @Autowired 
    iArtefactosService artefactosService;

    //Obtener lista de todos los artefactos
    @GetMapping("/all")
    public List<Artefacto> getArtefactos() {
        return artefactosService.getArtefactos();
    }
    
    //Obtener objeto artefacto por su id
    @GetMapping("/{id}")
    public Artefacto getArtefactoPorId(@PathVariable("id") Integer idUrl) {
        return artefactosService.getArtefactoPorId(idUrl);
    }

    //Eliminar artefacto por id 
    @DeleteMapping("/{id}")
    public void borrarArtefactoPorId(@PathVariable("id") Integer idUrl) {
        artefactosService.borrarArtefactoPorId(idUrl);
    }

    //Guardar objeto artefacto 
    @PostMapping("/guardar")
    public Artefacto guardarArtefacto(@RequestBody Artefacto artefacto) {
        return artefactosService.guardarArtefacto(artefacto);
    }

    //Actualizar objeto artefacto
    @PutMapping("/actualizarartefacto")
    public Artefacto actualizArtefacto(@RequestBody Artefacto artefacto) {
        return artefactosService.actualizArtefacto(artefacto);
    }
}
