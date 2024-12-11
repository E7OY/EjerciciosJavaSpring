package com.edu.alumnosAsignaturas.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.alumnosAsignaturas.entities.Alumno;
import com.edu.alumnosAsignaturas.services.alumnosService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/alumnos")

public class alumnosController {

    @Autowired
    alumnosService alumnosService;

    @GetMapping("/{id}")
    public Alumno getAlumnosId(@PathVariable("id") Integer idUrl) {
        return alumnosService.getAlumnoId(idUrl);
    }
    
    @GetMapping("/all")
    public List<Alumno> getAlumnos() {
        return alumnosService.getAlumnos();
    }
    
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPorId(@PathVariable("id") Integer idUrl) {
        alumnosService.eliminarAlumnoId(idUrl);
    }
    
    @PutMapping("/update")
    public Alumno actualizarALumno(@RequestBody Alumno alumno) {
        return alumnosService.alumnoActualizar(alumno);
    }

    @PostMapping("/save")
    public Alumno guardarAlumno(@RequestBody Alumno alumno) {
        return alumnosService.alumnoGuardar(alumno);
    }
    


}
