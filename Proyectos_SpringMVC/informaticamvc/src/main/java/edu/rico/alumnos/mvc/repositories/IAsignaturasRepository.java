package edu.rico.alumnos.mvc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.alumnos.mvc.entities.Asignatura;

public interface IAsignaturasRepository extends JpaRepository<Asignatura, Long> {


}
