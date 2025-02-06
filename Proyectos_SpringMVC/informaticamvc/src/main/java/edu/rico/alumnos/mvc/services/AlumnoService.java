package edu.rico.alumnos.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.repositories.IAlumnoRepository;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;


    @Override
    public List<Alumno> getAlumnos() {
        
        return alumnoRepository.findAll();
    }


    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }


    @Override
    public Alumno getAlumnoById(Long id) {
        return alumnoRepository.findById(id).orElse(null);
    }


    @Override
    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }
	
}