package edu.eloy.entornoServidor.SpringMvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import edu.eloy.entornoServidor.SpringMvc.model.Vacante;
import edu.eloy.entornoServidor.SpringMvc.services.iVacanteService;

@Controller

@RequestMapping("/vacantes")

public class VacantesController {

    @Autowired
    iVacanteService serviceVacantes;

    @GetMapping("/")
    public String mostrarHome(Model model) {
        List<Vacante> lista = serviceVacantes.buscarTodas();
        model.addAttribute("vacantes", lista);
        return "home";
    }
    
    @GetMapping("/view/{id}")  //generacion de URL dinamicas o URI template
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        Vacante vacante = serviceVacantes.buscarPorId(idVacante);
        System.out.println("Se encontró el objeto: " + vacante);
        model.addAttribute("vacante", vacante);
        return "vacantes/detalle";
    }

    //RequestParam con peticones get
    //mandamos al servidor la petición con la query string id=4 (/vacantes/delete?id=4), spring MVC lo parsea a entero y lo guarda en la variable idVacante
    @GetMapping("/delete")
    public String eliminar(@RequestParam("id") int idVacante, Model model) {
        System.out.println("Borrando vacante con id: " + idVacante);
        model.addAttribute("idVacanteHtml", idVacante);
        return "mensaje";
    }
    
    
}
