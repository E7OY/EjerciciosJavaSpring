package edu.rico.alumnos.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.rico.alumnos.mvc.entities.Alumno;

@Repository

public interface IAlumnoRepository extends JpaRepository<Alumno, Long> {

}