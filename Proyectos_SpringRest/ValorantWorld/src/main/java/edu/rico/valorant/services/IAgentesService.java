package edu.rico.valorant.services;

import java.util.List;

import edu.rico.valorant.entities.Agente;

public interface IAgentesService {

    public List<Agente> getAgentes();
    public Agente encuentraAgente(Integer id);
    public Agente guardarAgente(Agente agente);

}
