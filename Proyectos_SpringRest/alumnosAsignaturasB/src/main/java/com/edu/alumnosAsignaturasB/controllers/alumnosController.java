package com.edu.alumnosAsignaturasB.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.alumnosAsignaturasB.entities.Alumno;
import com.edu.alumnosAsignaturasB.services.alumnosService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/alumnos")

public class alumnosController {

    @Autowired
    alumnosService alumnosService;

    @GetMapping("/all")
    public List<Alumno> getAlumnos() {
        return alumnosService.getAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno getAlumnoId(@PathVariable Integer idUrl) {
        return alumnosService.getAlumnoId(idUrl);
    }

    @DeleteMapping("/{id}")
    public void eliminarALumno(@PathVariable("id") Integer idUrl) {
        alumnosService.eliminarALumno(idUrl);
    } 
    
    

}
