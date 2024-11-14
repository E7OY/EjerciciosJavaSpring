package edu.eloy.SenhorDeLosAnillos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.eloy.SenhorDeLosAnillos.repositories.iArtefactoRepository;
import edu.eloy.SenhorDeLosAnillos.repositories.iPersonajeRepository;

@SpringBootApplication
public class SenhorDeLosAnillosApplication implements CommandLineRunner{

	@Autowired
	iArtefactoRepository artefactosRepo;

	@Autowired
	iPersonajeRepository personajesRepo;

	public static void main(String[] args) {
		SpringApplication.run(SenhorDeLosAnillosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

}
