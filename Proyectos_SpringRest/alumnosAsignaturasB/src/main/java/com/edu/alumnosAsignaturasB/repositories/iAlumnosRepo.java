package com.edu.alumnosAsignaturasB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.alumnosAsignaturasB.entities.Alumno;

public interface iAlumnosRepo  extends JpaRepository<Alumno, Integer>{

}
