package edu.eloy.MotoGP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.eloy.MotoGP.repositories.iCarrerasRepository;
import edu.eloy.MotoGP.repositories.iCircuitosRepository;
import edu.eloy.MotoGP.repositories.iPilotoRepository;

@SpringBootApplication
public class MotoGpApplication implements CommandLineRunner{

	@Autowired
	iPilotoRepository pilotosrepo;

	@Autowired
	iCircuitosRepository circuitosRepo;

	@Autowired
	iCarrerasRepository carrerasRepo;

	public static void main(String[] args) {
		SpringApplication.run(MotoGpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {


	}

}
