package edu.eloy.proyectoJPA;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.eloy.proyectoJPA.entities.Animal;
import edu.eloy.proyectoJPA.enumerated.Especie;
import edu.eloy.proyectoJPA.repositorios.iAnimalRepository;

@SpringBootApplication
public class ProyectoJpaApplication implements CommandLineRunner {  //Implementamos la interfaz CommandLineRunner que nos proporciona un metodo para ejecutar codigo al iniciar la aplicacion

	@Autowired  //anotacion para la inyeccion de dependencias
	iAnimalRepository animalRepo;  //inyeccion de dependencias, no se instancia la clase, se inyecta la dependencia
	//creamos la instancia animalRepo de tipo iAnimalRepository la cual nos facilitará invocar los métodos de JPARepository

	public static void main(String[] args) {
		SpringApplication.run(ProyectoJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Animal> lista = animalRepo.findAll();  //findAll() devuelve una lista con todos los animales, por lo que hay que crear una lista
		//LA CLASE LIST SE IMPORTA DEL PAQUETE JAVA.UTIL
		System.out.println(lista);


		//Para insertar un animal
		//Animal animalInsertar = new Animal(null, null, null, null, null) no podemos usar este constructor porque el id es auto incremental, y lo gestiona el gestor de base de datos
		Animal animalInsetar  = new Animal();
		animalInsetar.setNombre("Eloy");
		animalInsetar.setEspecie("Lubina");
		animalInsetar.setEdad(20);
		animalInsetar.setPeso(78.5);

		Animal animalInsertar2 = new Animal("Loira", "Humano", 21.5, 21);

		//Para actualizar un animal le pasamos el id, y ya hace el update el gestor de base de datos
		Animal animalActualizar = new Animal(7, "Lubina", "Lubina", 20.0, 78);

		//Para eliminar un animal le pasamos el id, y ya hace el delete el gestor de base de datos
		animalRepo.delete(new Animal(4, "Eloy", "Lubina", 20.0, 78));
		animalRepo.deleteById(4);

		animalRepo.save(animalInsetar);  
		System.out.println("Menudo animal" + animalRepo.save(animalInsertar2));
		System.out.println(animalRepo.findAll());

		animalRepo.save(new Animal ("Eloy", Especie.CANINO, 20.0, 78));
		
	}

}
