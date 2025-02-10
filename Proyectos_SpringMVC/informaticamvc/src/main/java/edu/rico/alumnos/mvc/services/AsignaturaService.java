package edu.rico.alumnos.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.Asignatura;
import edu.rico.alumnos.mvc.repositories.IAlumnoRepository;
import edu.rico.alumnos.mvc.repositories.IAsignaturasRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service

public class AsignaturaService implements IAsignaturaService {

    @Autowired
    IAsignaturasRepository asignaturasRepo;

    @Autowired
    IAlumnoRepository alumnosRepo;

    @Override
    public List<Asignatura> getAsignaturas() {
        return asignaturasRepo.findAll();
    }

    @Override
    public Asignatura saveAsignatura(Asignatura asignatura) {
        return asignaturasRepo.save(asignatura);
    }

    @Override
    public Asignatura updateAsignatura(Asignatura asignatura) {
        return asignaturasRepo.save(asignatura);
    }

    @Override
    public Asignatura getAsignaturaId(Long id) {
        return asignaturasRepo.findById(id).orElse(null);
    }
    
}
