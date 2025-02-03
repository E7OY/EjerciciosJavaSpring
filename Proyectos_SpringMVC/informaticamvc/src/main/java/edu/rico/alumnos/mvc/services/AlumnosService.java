package edu.rico.alumnos.mvc.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;
import edu.rico.alumnos.mvc.repositories.IAlumnoRepository;

@Service

public class AlumnosService implements IAlumnosService {

    @Autowired
    private IAlumnoRepository alumnosRepo;

        public List<Alumno> getAlumnos() {
        /* 
        Alumno alumno1 = new Alumno("Juan", "Perez", "Garcia", LocalDate.of(1990, 1, 1), Genero.HOMBRE, Disposicion.COLABORADOR,"image1.png");
        Alumno alumno2 = new Alumno("Maria", "Gonzalez", "Lopez", LocalDate.of(1991, 2, 2), Genero.MUJER, Disposicion.TRABAJADOR, "image2.png");
        Alumno alumno3 = new Alumno("Pedro", "Rodriguez", "Martinez", LocalDate.of(1992, 3, 3), Genero.HOMBRE, Disposicion.COLABORADOR, "image3.png");
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(alumno1);
        alumnos.add(alumno2);
        alumnos.add(alumno3);
        System.out.println(alumnos);
        return alumnos;
        */
        return null;
        }


        @Override
        public Alumno saveAlumno(Alumno alumno) {
            return alumnosRepo.save(alumno);
        }

        @Override
        public List<Alumno> getAllAlumnos() {
            return alumnosRepo.findAll();
        }


        @Override
        public Alumno getAlumnoById(Long id) {
            return alumnosRepo.findById(id).orElse(null);
        }

}
