package edu.rico.alumnos.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.Asignatura;

@Repository

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

    List<Alumno> findByAsignaturas(Asignatura asignatura);

}