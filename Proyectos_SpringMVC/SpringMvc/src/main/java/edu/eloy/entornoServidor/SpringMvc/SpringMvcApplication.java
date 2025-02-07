package edu.eloy.entornoServidor.SpringMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}

}

/*
* TODO: CREAR UNA PLANTILLA PARA VISUALIZAR EN UNA TABLA LAS ASIGNATURAS asignaturasList.html
* TENER UN FORMULARIO PARA GUARDAR UNA ASIGNATURA asignaturasForm.html
* TENER UNA PLANTILLA PARA EDITAR UNA ASIGNATURA asignaturasEdit.html
* QUE EN asignaturasList.html TENGAMOS UN BOTON "Ver alumnos" PARA CADA ASIGNATURA, SI PULSAMOS EL BOTON NOS LLEVARA
* A asignaturasAlumnos.html donde veremos todos los alumnos que tienen esa asignatura en una CARD
*/
