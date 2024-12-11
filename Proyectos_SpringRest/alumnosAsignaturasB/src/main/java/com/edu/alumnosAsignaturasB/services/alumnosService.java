package com.edu.alumnosAsignaturasB.services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.alumnosAsignaturasB.entities.Alumno;
import com.edu.alumnosAsignaturasB.repositories.iAlumnosRepo;

@Service

public class alumnosService implements iAlumnosService {

    @Autowired
    iAlumnosRepo alumnosRepo;

    @Override
    public List<Alumno> getAlumnos() {
        return alumnosRepo.findAll();
    }

    @Override
    public Alumno getAlumnoId(Integer idUrl) {
        Optional<Alumno> op = alumnosRepo.findById(idUrl);
        if (!op.isPresent()) {
            System.out.println("No se encuentra un alumno con ese id!!");
            return null;
        } 
        return op.get();
    }

    @Override
    public void eliminarALumno(Integer idUrl) {
        alumnosRepo.deleteById(idUrl);
    }

    


}
