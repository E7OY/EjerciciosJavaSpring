package com.edu.alumnosAsignaturas.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.edu.alumnosAsignaturas.entities.Alumno;
import com.edu.alumnosAsignaturas.repositories.alumnosRepository;

@Service

public class alumnosService implements iAlumnosServices {

    @Autowired
    alumnosRepository alumnosRepo;

    @Override
    public Alumno getAlumnoId(Integer idUrl) {
        Optional<Alumno> op = alumnosRepo.findById(idUrl);
        if (op.isPresent()){
            return op.get();
        } else {
            return null;
        }   
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnosRepo.findAll();
    }

    @Override
    public void eliminarAlumnoId(Integer idUrl) {
        alumnosRepo.deleteById(idUrl);
    }

    @Override
    public Alumno alumnoActualizar(Alumno alumno) {
        return alumnosRepo.save(alumno);
    }

    @Override
    public Alumno alumnoGuardar(Alumno alumno) {
        return alumnosRepo.save(alumno);
    }

}
