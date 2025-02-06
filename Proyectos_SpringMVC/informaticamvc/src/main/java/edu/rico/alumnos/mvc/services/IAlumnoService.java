package edu.rico.alumnos.mvc.services;

import java.util.List;

import edu.rico.alumnos.mvc.entities.Alumno;

public interface IAlumnoService {

    public List<Alumno> getAlumnos();
    public Alumno saveAlumno(Alumno alumno);
    public Alumno getAlumnoById(Long id);
    public void deleteAlumno(Long id);
}