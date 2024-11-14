package edu.eloy.SenhorDeLosAnillos.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import edu.eloy.SenhorDeLosAnillos.entities.Artefacto;
import edu.eloy.SenhorDeLosAnillos.services.iArtefactosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/artefactos")

public class artefactoController {

    @Autowired 
    iArtefactosService artefactosService;

    @GetMapping("/all")
    public List<Artefacto> getArtefactos() {
        return artefactosService.getArtefactos();
    }

    @GetMapping("/{id}")
    public Artefacto getArtefactoPorId(@PathVariable("id") Integer idUrl) {
        return artefactosService.getArtefactoPorId(idUrl);
    }
    
    
}
