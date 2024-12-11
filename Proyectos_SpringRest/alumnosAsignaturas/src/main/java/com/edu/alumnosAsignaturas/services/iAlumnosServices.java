package com.edu.alumnosAsignaturas.services;

import java.util.List;
import com.edu.alumnosAsignaturas.entities.Alumno;

public interface iAlumnosServices {

    public Alumno getAlumnoId(Integer idUrl);

    public List<Alumno> getAlumnos();

    public void eliminarAlumnoId(Integer idUrl);

    public Alumno alumnoActualizar(Alumno alumno);

    public Alumno alumnoGuardar(Alumno alumno);

}
