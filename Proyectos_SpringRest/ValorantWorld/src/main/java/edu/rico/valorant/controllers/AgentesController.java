package edu.rico.valorant.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.rico.valorant.entities.Agente;
import edu.rico.valorant.services.IAgentesService;

@RestController
public class AgentesController {

    @Autowired
    IAgentesService agenteServ;

    @GetMapping("/agentes")
    public List<Agente> listarAgentes(){
        return agenteServ.getAgentes();
    }

    @GetMapping("/agentes/{id}")
    public Agente conseguirAgentePorId(@PathVariable("id") Integer id){
       return agenteServ.encuentraAgente(id);
    }

    @PostMapping("/agentes")
    public Agente guardarAgente(Agente agente){
        return agenteServ.guardarAgente(agente);
    }

}
