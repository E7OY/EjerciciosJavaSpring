package edu.rico.alumnos.mvc.services;

import java.util.List;
import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.Asignatura;

public interface IAlumnoService {

    public List<Alumno> getAlumnos();
    public Alumno saveAlumno(Alumno alumno);
    public Alumno getAlumnoById(Long id);
    public void deleteAlumno(Long id);
    public void deleteAsignaturaDeAlumno(Long idAlumno, Long idAsignatura);
    public List<Alumno> getAlumnosPorAsignatura(Asignatura asignatura);
}