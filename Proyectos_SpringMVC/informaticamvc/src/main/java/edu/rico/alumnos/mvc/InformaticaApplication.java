package edu.rico.alumnos.mvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import edu.rico.alumnos.mvc.entities.Alumno;
import edu.rico.alumnos.mvc.entities.Ordenador;
import edu.rico.alumnos.mvc.entities.enumerated.CPU;
import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.GPU;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;
import edu.rico.alumnos.mvc.entities.enumerated.Memoria;

@SpringBootApplication
public class InformaticaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(InformaticaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Alumno alumno = new Alumno( "Juan", "Perez", "Garcia", LocalDate.of(1990, 1, 1), Genero.HOMBRE, Disposicion.COLABORADOR);

		List<Alumno> alumnos = new ArrayList<>();
		alumnos.add(alumno);
		System.out.println(alumnos);

		Ordenador ordenador = new Ordenador("HP", "Pavilion", Memoria.GB_16, CPU.AMD_RYZEN_3, GPU.ASUS);
		System.out.println(ordenador);


	}

}
