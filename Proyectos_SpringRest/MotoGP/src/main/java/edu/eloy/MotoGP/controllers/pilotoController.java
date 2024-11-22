package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.services.iPilotosService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

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
    public Piloto getPilotoId(@PathVariable("id") Integer idUrl) {
        return pilotosService.getPilotoId(idUrl);
    }

    @DeleteMapping("/{id}")
    public void borrarPiloto(@PathVariable("id") Integer idURl) {
        pilotosService.borrarPiloto(idURl);
    }

    @PostMapping("/save")
    public Piloto savePiloto(@RequestBody Piloto piloto) {
        return pilotosService.savePiloto(piloto);
    }

    @PutMapping("/update")
    public Piloto updatePiloto(@RequestBody Piloto piloto) {
        return pilotosService.updatePiloto(piloto);
    }
}
