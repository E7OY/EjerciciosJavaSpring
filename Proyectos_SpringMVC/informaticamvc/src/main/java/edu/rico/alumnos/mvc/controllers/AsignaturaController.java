package edu.rico.alumnos.mvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.rico.alumnos.mvc.entities.Asignatura;
import edu.rico.alumnos.mvc.services.IAlumnoService;
import edu.rico.alumnos.mvc.services.IAsignaturaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/asignaturas")

public class AsignaturaController {
    
    @Autowired
    IAsignaturaService asignaturaService;

    @Autowired
    IAlumnoService alumnoService;

    @GetMapping("/list")
    public String getAsignaturas(Model model) {
        List<Asignatura> asignaturas = asignaturaService.getAsignaturas();
        model.addAttribute("asignaturas", asignaturas);
        return "asignaturaslist";
    }

    @GetMapping("/form")
    public String desplegarFormulario() {
        return "asignaturasform";
    }

    @PostMapping("/save")
    public String guardarAsignatura(Asignatura asignatura) {
        System.out.println("ASIGNATURA GUARDADA: " + asignaturaService.saveAsignatura(asignatura));
        return "redirect:/asignaturas/list";
    }

    @GetMapping("/edit/{id}")
    public String updateAsignatura(@PathVariable("id") Long id, Model model) {
        Asignatura asignatura = asignaturaService.getAsignaturaId(id);
        model.addAttribute("asignatura", asignatura);
        return "asignaturasedit";
    }


}
