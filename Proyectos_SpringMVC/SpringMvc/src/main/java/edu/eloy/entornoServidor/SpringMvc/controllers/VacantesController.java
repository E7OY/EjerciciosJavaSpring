package edu.eloy.entornoServidor.SpringMvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

@RequestMapping("/vacantes")

public class VacantesController {
    
    @GetMapping("/view/{id}")  //generacion de URL dinamicas o URI template
    public String verDetalle(@PathVariable("id") int idVacante, Model model) {
        System.out.println("idVacante: " + idVacante);
        model.addAttribute("idVacante", idVacante);
        return "vacantes/detalle";
    }
    
}
