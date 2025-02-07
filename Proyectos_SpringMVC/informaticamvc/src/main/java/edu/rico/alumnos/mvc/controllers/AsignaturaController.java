package edu.rico.alumnos.mvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rico.alumnos.mvc.entities.Asignatura;
import edu.rico.alumnos.mvc.services.IAsignaturaService;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/asignaturas")

public class AsignaturaController {
    
    @Autowired
    IAsignaturaService asignaturaService;

    @GetMapping("/list")
    public String getAsignaturas(Model model) {
        List<Asignatura> asignaturas = asignaturaService.getAsignaturas();
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturaslist";
    }
    

}
