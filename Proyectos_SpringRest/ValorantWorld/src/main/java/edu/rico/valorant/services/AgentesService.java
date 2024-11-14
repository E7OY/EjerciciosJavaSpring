package edu.rico.valorant.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.valorant.entities.Agente;
import edu.rico.valorant.repositories.IAgentesRepository;

@Service
public class AgentesService implements IAgentesService {

    @Autowired
    IAgentesRepository agentesRepo;

    @Override
    public List<Agente> getAgentes() {
      return agentesRepo.findAll();
    }

    @Override
    public Agente encuentraAgente(Integer id) {
        Optional<Agente> op = agentesRepo.findById((long) id);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

    @Override
    public Agente guardarAgente(Agente agente) {
        return agentesRepo.save(agente);
    }

}
