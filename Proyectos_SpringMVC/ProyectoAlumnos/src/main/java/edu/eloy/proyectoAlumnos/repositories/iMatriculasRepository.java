package edu.eloy.proyectoAlumnos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.proyectoAlumnos.entities.Matricula;

public interface iMatriculasRepository extends JpaRepository<Matricula, Integer>{

    
}
