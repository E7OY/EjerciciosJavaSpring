package edu.rico.alumnos.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.services.AlumnosService;
import org.springframework.web.bind.annotation.RequestParam;



@Controller    // DECORADOR DE SPRING MVC
@RequestMapping("/alumnos")

public class AlumnoController {

    @Autowired
    private AlumnosService alumnosService;

    @GetMapping("/list")
    public String listaAlumnos(Model model) {
        model.addAttribute("alumnos", alumnosService.getAllAlumnos());
        return "alumnosindex";
    }

    @GetMapping("/form")
    public String desplegarFormulario() {
        return "alumnosform";
    }
    
    @PostMapping("/save")
    public String guardarAlumno(Alumno alumno) {
        System.out.println("Aluno guardado: " + alumnosService.saveAlumno(alumno));
        return "redirect:/alumnos/list";  //redirect porque es un guardado y no nos devuelve una vista
    }
    

}
