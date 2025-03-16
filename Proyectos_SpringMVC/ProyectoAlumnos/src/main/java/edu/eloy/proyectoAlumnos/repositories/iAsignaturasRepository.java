package edu.eloy.proyectoAlumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.proyectoAlumnos.entities.Asignatura;

public interface iAsignaturasRepository extends JpaRepository<Asignatura, Integer> {

}
