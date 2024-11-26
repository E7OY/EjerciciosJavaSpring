package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;
import edu.eloy.MotoGP.entities.Circuito;
import edu.eloy.MotoGP.services.CircuitosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("circuitos")

public class CircuitoController {

    @Autowired
    CircuitosService circuitosService;

    @GetMapping("/all")
    public List<Circuito> getAllCircuitos() {
        return circuitosService.getAllCircuitos();
    }

    @GetMapping("/{id}")
    public Circuito getCircuito(@PathVariable("id") Integer idUrl) {
        return circuitosService.geCircuito(idUrl);
    }

    @DeleteMapping("/{id}")
    public void deleteCiurcuito(@PathVariable("id") Integer idUrl ){
        circuitosService.deleteCiurcuito(idUrl);
    }

    @PutMapping("/update")
    public Circuito updateCircuito(@RequestBody Circuito circuito) {
        return circuitosService.updateCircuito(circuito);
    }

    @PostMapping("/save")
    public Circuito saveCircuito(@RequestBody Circuito circuito) {
        return circuitosService.saveCircuito(circuito);
    }

    @GetMapping("/circuitonombre/{nombre}")
    public Circuito getCircuitoPorNombre(@PathVariable("nombre") String nombre) {
       return circuitosService.getCircuitoPorNombre(nombre);
    }
    
}
