package com.edu.alumnosAsignaturasB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edu.alumnosAsignaturasB.repositories.iAlumnosRepo;
import com.edu.alumnosAsignaturasB.repositories.iAsignaturasRepo;
import com.edu.alumnosAsignaturasB.repositories.iMatriculasRepo;

@SpringBootApplication
public class AlumnosAsignaturasBApplication implements CommandLineRunner{

	@Autowired
	iAlumnosRepo alumnosRepo;

	@Autowired
	iAsignaturasRepo asignaturasRepo;

	@Autowired
	iMatriculasRepo matriculasRepo;

	public static void main(String[] args) {
		SpringApplication.run(AlumnosAsignaturasBApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	}

}
