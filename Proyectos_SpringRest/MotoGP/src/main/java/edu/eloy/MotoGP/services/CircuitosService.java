package edu.eloy.MotoGP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eloy.MotoGP.entities.Circuito;
import edu.eloy.MotoGP.repositories.iCircuitosRepository;

@Service

public class CircuitosService implements iCircuitosService {

    @Autowired
    iCircuitosRepository circuitosRepo;

    @Override
    public List<Circuito> getAllCircuitos() {
        return circuitosRepo.findAll();
    }

    @Override
    public Circuito geCircuito(Integer idUrl) {
        Optional<Circuito> op = circuitosRepo.findById(idUrl);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public void deleteCiurcuito(Integer idUrl) {
        circuitosRepo.deleteById(idUrl);
    }

    @Override
    public Circuito updateCircuito(Circuito circuito) {
        return circuitosRepo.save(circuito);
    }

    @Override
    public Circuito saveCircuito(Circuito circuito) {
        return circuitosRepo.save(circuito);
    }

    

}
