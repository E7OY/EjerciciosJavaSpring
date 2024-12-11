package com.edu.alumnosAsignaturas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.alumnosAsignaturas.entities.Alumno;

public interface alumnosRepository extends JpaRepository<Alumno, Integer> {

}
