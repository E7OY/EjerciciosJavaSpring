package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;

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


}
