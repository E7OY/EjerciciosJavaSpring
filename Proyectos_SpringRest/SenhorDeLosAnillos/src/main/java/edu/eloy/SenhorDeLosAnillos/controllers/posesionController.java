package edu.eloy.SenhorDeLosAnillos.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import edu.eloy.SenhorDeLosAnillos.entities.Posesion;
import edu.eloy.SenhorDeLosAnillos.services.posesionesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/posesiones")

public class posesionController {

    @Autowired
    posesionesService posesionesService;


    @GetMapping("/all")
    public List<Posesion> getPosesiones() {
            return posesionesService.buscarPosesiones();
    }
    


}
