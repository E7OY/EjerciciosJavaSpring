package edu.eloy.proyectoAlumnos.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.eloy.proyectoAlumnos.entities.Alumno;
import edu.eloy.proyectoAlumnos.entities.Matricula;
import edu.eloy.proyectoAlumnos.services.iAlumnosService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/alumnos")

public class AlumnoController {

    @Autowired
    iAlumnosService alumnosService;

    @GetMapping("/edades")
    public String getAlumnosByedad(Model model) {
        List<Alumno> alumnos = alumnosService.getAlumnosByEdad();
        Long numeroAlumnos = alumnosService.getNumberAlumnos();
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("numeroAlumnos", numeroAlumnos);
        return "alumnosjpa";
    }

    @GetMapping("/list")
    public String getAlumnos(Model model) {
        List<Alumno> alumnos = alumnosService.getAlumnos();
        model.addAttribute("alumnos", alumnos);
        return "alumnosList";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Integer id,Model model) {
        alumnosService.deleteAlumno(id);
        return "redirect:/alumnos/list";
    }

    @GetMapping("/alumnosListNotas")
    public String showAlumnosList(Model model) {
        List<Alumno> alumnos = alumnosService.getAlumnos();

        
        Map<Integer, Double> mediaNotas = new HashMap<>();

        for (Alumno alumno : alumnos) {
            List<Matricula> matriculas = alumno.getMatriculas();
            if (matriculas == null || matriculas.isEmpty()) {
                mediaNotas.put(alumno.getId(), 0.0);
            } else {
                double sum = 0.0;
                for (Matricula matricula : matriculas) {
                    sum += matricula.getNota().doubleValue();
                }
                mediaNotas.put(alumno.getId(), sum / matriculas.size());
            }
        }

        model.addAttribute("alumnos", alumnos);
        model.addAttribute("mediaNotas", mediaNotas);
        return "alumnosListNotas";
    }
    

}
