package edu.rico.alumnos.mvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rico.alumnos.mvc.services.AlumnosService;


@Controller    // DECORADOR DE SPRING MVC
@RequestMapping("/alumnos")

public class AlumnoController {

    @Autowired
    private AlumnosService alumnosService;

    @GetMapping("/list")
    public String listaAlumnos(Model model) {
        model.addAttribute("alumnos", alumnosService.getAlumnos());
        return "alumnosindex";
    }
    

}
