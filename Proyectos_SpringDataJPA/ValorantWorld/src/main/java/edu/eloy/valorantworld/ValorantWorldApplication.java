package edu.eloy.valorantworld;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.eloy.valorantworld.entities.Agente;
import edu.eloy.valorantworld.enumerated.Rol;
import edu.eloy.valorantworld.repositories.iAgentesRepository;
import edu.eloy.valorantworld.repositories.iHabilidadesRepository;
import edu.eloy.valorantworld.repositories.iJugadoresRepositort;
import edu.eloy.valorantworld.repositories.iPartidasRepository;

@SpringBootApplication
public class ValorantWorldApplication implements CommandLineRunner {

	//Creamos una instancia "agentesRepo" de la interfaz iAgentesRepository para poder utilizar los métodos de JpaRepository
	@Autowired
	iAgentesRepository agentesRepo;

	@Autowired
	iHabilidadesRepository habilidadesRepo;

	@Autowired
	iJugadoresRepositort jugadoresRepo;

	@Autowired
	iPartidasRepository partidasRepo;


	public static void main(String[] args) {
		SpringApplication.run(ValorantWorldApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Método para DEVOLVER TODOS LOS REGISTROS de una tabla en forma de lista de objertos
//		System.out.println(agentesRepo.findAll());


		//Método para DEVOLVER UN REGISTRO POR SU ID
//		Optional<Agente> op = agentesRepo.findById((long) 4);
//		if (op.isPresent()) {
//			System.out.println(op.get());
//		} else {
//			System.out.println("No se ha encontrado ningún agente con el id seleccionado!");
//		}


		//Método para INSERTAR UN REGISTRO en la tabla
//		Agente agenteInsertar = new Agente("eloy", Rol.DUELISTA, "ultimate", "España");
//		agentesRepo.save(agenteInsertar);


		//Método para ACTUALIZAR UN REGISTRO 
//		Agente agenteActualizar = new Agente((long)4, "Mateus", Rol.INICIADOR, "Aniquilación orbital", "Brasil");
//		agentesRepo.save(agenteActualizar);


		//Método para ELIMINAR UN REGISTRO POR SU ID
//		agentesRepo.deleteById((long)28);


		//Método PARA ELIMINAR VARIOS REGISTROS POR SU ID
//		List<Long> ids = new ArrayList<>();
//		ids.add((long)26);
//		ids.add((long)25);
//		agentesRepo.deleteAllById(ids);

		System.out.println(partidasRepo.findAll());
		}
	}


