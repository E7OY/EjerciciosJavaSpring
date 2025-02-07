package edu.rico.alumnos.mvc.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;
import edu.rico.alumnos.mvc.services.IAlumnoService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/alumnos")
public class AlumnoController {

    @Autowired
    private IAlumnoService alumnoService;

    @GetMapping("/list")
    public String listarAlumnos(Model model) {
        List<Alumno> alumnos = alumnoService.getAlumnos();
        model.addAttribute("alumnos", alumnos);
        System.out.println("ALUMNOS => " + alumnos);
        return "alumnosindex";
    }

    @GetMapping("/form")
    public String desplegarFormulario() {
        return "alumnosform";
    }
    
    @PostMapping("/save")
    public String guardarAlumno(Alumno alumno) {
        alumnoService.saveAlumno(alumno);
        return "redirect:/alumnos/list";
    }
    
    @GetMapping("/detalle/{id}")
    public String detalleAlumno(@PathVariable("id") Long id,Model model) {
        model.addAttribute("generos", Genero.values());
        model.addAttribute("disposiciones", Disposicion.values());
        model.addAttribute("alumno", alumnoService.getAlumnoById(id));
        System.out.println("ALUMNO DETALLE => " + alumnoService.getAlumnoById(id));
        return "alumnodetalle";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAlumno(@PathVariable("id") Long id,Model model) {
        System.out.println("PROCEDEMOS A ELIMINAR AL ALUMNO: " + alumnoService.getAlumnoById(id));
        alumnoService.deleteAlumno(id);
        return "redirect:/alumnos/list";
    }

    
    @GetMapping("/{idAlumno}/asignatura/{idAsignatura}")
    public String eliminarAsignaturaDeAlumno(@PathVariable("idAlumno") Long idAlumno, @PathVariable("idAsignatura") Long idAsignatura ,Model model) {
        System.out.println("ASIGNATURAS DEL ALUMNO: " + alumnoService.getAlumnoById(idAlumno));
        alumnoService.deleteAsignaturaDeAlumno(idAlumno, idAsignatura);
        return "redirect:/alumnos/detalle/" + idAlumno;
    }


}