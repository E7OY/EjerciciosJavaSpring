package edu.eloy.proyectoAlumnos.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import edu.eloy.proyectoAlumnos.entities.Alumno;
import edu.eloy.proyectoAlumnos.services.iAlumnosService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("alumnos")
public class AlumnoRest {

    @Autowired 
    iAlumnosService alumnosService;

    @GetMapping("/all")
    public List<Alumno> getAllAlumnos() {
        return alumnosService.getAlumnos();
    }

    @GetMapping("/{id}")
    public Alumno getAlumnoById(@PathVariable("id") Integer id) {
        return alumnosService.getAlumnoById(id);
    }

    @PostMapping("/crear")
    public Alumno crearAlumno(@RequestBody Alumno alumno) {
        return alumnosService.saveAlumno(alumno);
    }

    @PutMapping("/update")
    public Alumno updateAlumno(@RequestBody Alumno alumno) {
        return alumnosService.saveAlumno(alumno);
    }
    
    @DeleteMapping("/{id}")
    public void deleteAlumno(@PathVariable("id") Integer id){
        alumnosService.deleteAlumno(id);
    }

}
