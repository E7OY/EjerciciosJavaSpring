package edu.eloy.MotoGP.controllers;

import org.springframework.web.bind.annotation.RestController;

import edu.eloy.MotoGP.DTOs.CarreraDTO;
import edu.eloy.MotoGP.entities.Carrera;
import edu.eloy.MotoGP.services.CarrerasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController

public class carreraController {

    @Autowired
    CarrerasService carrerasService;

    @GetMapping("/all")
    public List<CarreraDTO> getAllCarrerasDtos() {
        return carrerasService.getAllCarrerasDtos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarreraDTO> getCarrera(@RequestParam Integer idUrl) {
        CarreraDTO carreraDTO = carrerasService.getCarreraDTO(idUrl);
        if (carreraDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().header("Objeto encontrado", "Valores").body(carreraDTO);
    }
    
    @PostMapping("/save")
    public ResponseEntity<Carrera> saveCarrera(@RequestBody Carrera carrera) {
        Carrera carreraGuardada = carrerasService.saveCarrera(carrera);
        return ResponseEntity.status(HttpStatus.CREATED).body(carreraGuardada);
    }

    @DeleteMapping("/delete")
    public void deleteCarrera(Integer idUrl) {
        carrerasService.deleteCarrera(idUrl);
    }

    @PutMapping("/update")
    public Carrera updateCarrera(@RequestBody Carrera carrera) {
        return carrerasService.updateCarrera(carrera);
    }
    

}
