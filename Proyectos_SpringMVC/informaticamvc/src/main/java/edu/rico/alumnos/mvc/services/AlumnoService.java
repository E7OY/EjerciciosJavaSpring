package edu.rico.alumnos.mvc.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.Asignatura;
import edu.rico.alumnos.mvc.repositories.IAlumnoRepository;
import edu.rico.alumnos.mvc.repositories.IAsignaturasRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AlumnoService implements IAlumnoService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IAsignaturasRepository asignaturaRepository;


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


    @Override
    public void deleteAsignaturaDeAlumno(Long idAlumno, Long idAsignatura) {
        Alumno alumnoBd = alumnoRepository.findById(idAlumno).orElseThrow(() -> new EntityNotFoundException("Alumno no encontrado en la BD"));
        Asignatura asignaturaBd = asignaturaRepository.findById(idAsignatura).orElseThrow(() -> new EntityNotFoundException("Asignatura no encontrada en la BD"));
        alumnoBd.getAsignaturas().removeIf((asignatura) -> asignatura.getId().equals(asignaturaBd.getId()));
        System.out.println("ALUMNO CON ASIGNATURA ELIMINADA => " + alumnoBd);
        alumnoRepository.save(alumnoBd);
    }

}