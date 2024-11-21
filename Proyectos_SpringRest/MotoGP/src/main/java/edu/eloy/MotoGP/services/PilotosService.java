package edu.eloy.MotoGP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.repositories.iPilotoRepository;

public class PilotosService implements iPilotosService {

    @Autowired
    iPilotoRepository pilotosRepo;

    @Override
    public List<Piloto> getPilotos() {
       return pilotosRepo.findAll();
    }

    @Override
    public Piloto getPilotoId(Integer idUrl) {
        Optional<Piloto> op = pilotosRepo.findById(idUrl);
        if (op.isPresent()) {
            return op.get();
        } else {
            return null;
        }

        
    }

    

}
