package edu.eloy.proyectoAlumnos.services;

import java.util.List;

import edu.eloy.proyectoAlumnos.entities.Alumno;

public interface iAlumnosService {

    public List<Alumno> getAlumnosByEdad();
    public Long getNumberAlumnos();
    public List<Alumno> getAlumnos();
    public void deleteAlumno(Integer id);
    public Alumno getAlumnoById(Integer id);
    public Alumno saveAlumno(Alumno alumno);

}
