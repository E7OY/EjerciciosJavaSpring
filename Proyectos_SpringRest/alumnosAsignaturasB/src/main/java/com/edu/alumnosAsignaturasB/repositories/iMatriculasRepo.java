package com.edu.alumnosAsignaturasB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.alumnosAsignaturasB.entities.Matricula;

public interface iMatriculasRepo extends JpaRepository<Matricula, Integer> {

}
