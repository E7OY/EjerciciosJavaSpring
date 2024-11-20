package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.SenhorDeLosAnillos.entities.Posesion;
import edu.eloy.SenhorDeLosAnillos.repositories.iPosesionesRepo;

@Service

public class posesionesService implements iPosesionesService {

    @Autowired
    iPosesionesRepo posesionesRepo;

    @Override
    public List<Posesion> buscarPosesiones() {
        return posesionesRepo.findAll();
    }

    @Override
    public Posesion buscarPosesionPorId(Integer id) {
        Optional<Posesion> op = posesionesRepo.findById((long)id);
        if (op.isPresent()) {
            return op.get();
        }
        return null;
    }

    @Override
    public void borrarPosesionPorid(Integer id) {
        posesionesRepo.deleteById((long)id);
    }

    @Override
    public Posesion guardarPosesion(Posesion posesion) {
         return posesionesRepo.save(posesion);        
    }

    @Override
    public Posesion actualizarPosesion(Posesion posesion) {
        return posesionesRepo.save(posesion);
    }


}
