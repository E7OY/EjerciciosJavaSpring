package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.eloy.MotoGP.entities.Carrera;
import edu.eloy.MotoGP.services.CarrerasService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController

public class carreraController {

    @Autowired
    CarrerasService carrerasService;

    @GetMapping("/all")
    public List<Carrera> getAllCarreras() {
        return carrerasService.getAllCarreras();
    }

    @GetMapping("/{id}")
    public Carrera getCarrera(@RequestParam Integer idUrl) {
        return carrerasService.getCarrera(idUrl);
    }
    
    

}
