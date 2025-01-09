package com.edu.eloy.EloyGarcia1Trim.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.eloy.EloyGarcia1Trim.entities.Taller;
import com.edu.eloy.EloyGarcia1Trim.repositories.iTallerRepository;

@Service

public class TallerService implements iTalleresService {

    @Autowired
    iTallerRepository talleresRepo;

    @Override
    public List<Taller> getTalleres(String nombre) {
        return talleresRepo.findByNombre(nombre);
    }

    


}
