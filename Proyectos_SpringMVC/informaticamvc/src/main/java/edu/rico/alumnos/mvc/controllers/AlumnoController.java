package edu.rico.alumnos.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.services.IAlumnosService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnosService alumnoService;

    @GetMapping("/list")
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.getAllAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnosindex";
    }

    @GetMapping("/form")
    public String desplegarFormulario() {
        return "alumnosform";
    }
    
    @PostMapping("/save")
    public String guardarAlumno(Alumno alumno) {
        System.out.println("ALUMNO GUARDADO => " + alumnoService.saveAlumno(alumno));
        return "redirect:/alumnos/list";
    }
    
    @GetMapping("/detalle/{id}")
    public String detalleAlumno(@PathVariable("id") Long id,Model model) {
        model.addAttribute("alumno", alumnoService.getAlumnoById(id));
        return "alumnodetalle";
    }

    
}