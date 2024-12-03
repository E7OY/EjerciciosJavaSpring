package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.eloy.MotoGP.DTOs.PilotoDTO;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.services.iPilotosService;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<PilotoDTO> getPilotosdDtos() {
        return pilotosService.getPilotosDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PilotoDTO> getPilotoId(@PathVariable("id") Integer idUrl) {
        PilotoDTO pilotodto = pilotosService.getPilotoDTOId(idUrl);
        if (pilotodto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header("Objeto encontrado", "valores").body(pilotodto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarPiloto(@PathVariable("id") Integer idURl) {
        pilotosService.borrarPiloto(idURl);
        return ResponseEntity.noContent().build();
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
