package edu.eloy.SenhorDeLosAnillos.services;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eloy.SenhorDeLosAnillos.entities.Artefacto;
import edu.eloy.SenhorDeLosAnillos.repositories.iArtefactoRepository;

@Service

public class artefactosService implements iArtefactosService {

    @Autowired
    iArtefactoRepository artefactosRepo;

    @Override
    public List<Artefacto> getArtefactos() {
        return artefactosRepo.findAll();
    }

    @Override
    public Artefacto getArtefactoPorId(Integer id) {
        Optional<Artefacto> op = artefactosRepo.findById((long)id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public void borrarArtefactoPorId(Integer id) {
        artefactosRepo.deleteById((long)id);
    }

}
