package edu.eloy.proyectoAlumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.proyectoAlumnos.entities.Alumno;
import java.util.List;


public interface iAlumnosRepository extends JpaRepository<Alumno, Integer> {

    List<Alumno> findByEdadBetween(int minEdad, int maxEdad);
}
