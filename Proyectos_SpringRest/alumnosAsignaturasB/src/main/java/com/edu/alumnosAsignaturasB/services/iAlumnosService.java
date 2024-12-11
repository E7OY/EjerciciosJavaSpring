package com.edu.alumnosAsignaturasB.services;

import java.util.List;
import com.edu.alumnosAsignaturasB.entities.Alumno;

public interface iAlumnosService {

    public List<Alumno> getAlumnos();

    public Alumno getAlumnoId(Integer idUrl);

    public void eliminarALumno(Integer idUrl);

    public Alumno updateAlumno(Alumno alumno);

    public Alumno saveAlumno(Alumno alumno);

}
