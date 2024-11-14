package edu.rico.valorant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.rico.valorant.entities.Agente;
import edu.rico.valorant.entities.enumerated.Rol;
import edu.rico.valorant.repositories.IAgentesRepository;
import edu.rico.valorant.repositories.IHabilidadesRepository;
import edu.rico.valorant.repositories.IJugadoresRepository;
import edu.rico.valorant.repositories.IPartidasRepository;

@SpringBootApplication
public class ValorantWorldApplication implements CommandLineRunner{

	@Autowired
	private IAgentesRepository agentesRepo;

	@Autowired
	private IHabilidadesRepository habilidadesRepo;

	@Autowired
	private IJugadoresRepository jugadoresRepo;

	@Autowired
	private IPartidasRepository partidasRepo;

	public static void main(String[] args) {
		SpringApplication.run(ValorantWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(partidasRepo.findAll());
	}



}
