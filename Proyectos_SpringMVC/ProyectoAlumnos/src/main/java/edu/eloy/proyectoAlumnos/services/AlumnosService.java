package edu.eloy.proyectoAlumnos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.eloy.proyectoAlumnos.entities.Alumno;
import edu.eloy.proyectoAlumnos.entities.Matricula;
import edu.eloy.proyectoAlumnos.repositories.iAlumnosRepository;
import jakarta.transaction.Transactional;

@Service

public class AlumnosService implements iAlumnosService {

    @Autowired
    iAlumnosRepository alumnosRepo;

    @Override
    public List<Alumno> getAlumnosByEdad() {
        return alumnosRepo.findByEdadBetween(21, 24);
    }

    @Override
    public Long getNumberAlumnos() {
        return alumnosRepo.count();
    }

    @Override
    public List<Alumno> getAlumnos() {
        return alumnosRepo.findAll();
    }


    @Override
    @Transactional
    public void deleteAlumno(Integer id) {
        Optional<Alumno> op = alumnosRepo.findById(id);
        Alumno alumno = op.get();
        List<Matricula> matriculas = alumno.getMatriculas();
        if (matriculas != null) {
            for (Matricula matricula : matriculas) {
                matricula.setIdAlumno(null);
            }
        }
        alumnosRepo.delete(alumno);
    }

    @Override
    public Alumno getAlumnoById(Integer id) {
        Optional<Alumno> op  = alumnosRepo.findById(id);
        if(op.isPresent())  {
            return op.get();
        } else {
            return null;
        }
    }

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        return alumnosRepo.save(alumno);
    }

}
