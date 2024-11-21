package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.services.iPilotosService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/pilotos")

public class pilotoController {

    @Autowired
    iPilotosService pilotosService;

    @GetMapping("/all")
    public List<Piloto> getPilotos() {
        return pilotosService.getPilotos();
    }

    @GetMapping("/{id}")
    public Piloto getPilotoId(@PathVariable Piloto piloto) {
        return pilotosService.;
    }
    
    

}
