package edu.rico.alumnos.mvc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;

@Service

public class AlumnosService implements IAlumnosService {

        public List<Alumno> getAlumnos() {

        Alumno alumno1 = new Alumno("Juan", "Perez", "Garcia", LocalDate.of(1990, 1, 1), Genero.HOMBRE,
                Disposicion.COLABORADOR);
        Alumno alumno2 = new Alumno("Maria", "Gonzalez", "Lopez", LocalDate.of(1991, 2, 2), Genero.MUJER, Disposicion.TRABAJADOR);
        Alumno alumno3 = new Alumno("Pedro", "Rodriguez", "Martinez", LocalDate.of(1992, 3, 3), Genero.HOMBRE,
                Disposicion.COLABORADOR);
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        System.out.println(alumnos);

        return alumnos;
    }

}
