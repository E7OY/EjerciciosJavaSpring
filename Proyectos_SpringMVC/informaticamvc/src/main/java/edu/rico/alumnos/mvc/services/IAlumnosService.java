package edu.rico.alumnos.mvc.services;

import java.util.List;

import edu.rico.alumnos.mvc.entities.Alumno;

public interface IAlumnosService {

    public List<Alumno> getAllAlumnos();
    public Alumno saveAlumno(Alumno alumno);
    public Alumno getAlumnoById(Long id);

}
