package edu.rico.alumnos.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.alumnos.mvc.entities.Asignatura;
import edu.rico.alumnos.mvc.repositories.IAsignaturasRepository;

@Service

public class AsignaturaService implements IAsignaturaService {

    @Autowired
    IAsignaturasRepository asignaturasRepo;

    @Override
    public List<Asignatura> getAsignaturas() {
        return asignaturasRepo.findAll();
    }
    
}
