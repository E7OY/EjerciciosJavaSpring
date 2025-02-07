package edu.rico.alumnos.mvc.services;

import java.util.List;
import edu.rico.alumnos.mvc.entities.Asignatura;

public interface IAsignaturaService {

    public List<Asignatura> getAsignaturas();

    public Asignatura saveAsignatura(Asignatura asignatura);
    
}
