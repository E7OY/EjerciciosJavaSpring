package edu.eloy.proyectoJPA.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.proyectoJPA.entities.Animal;

//JpaRepository es una interfaz de Spring Data JPA que nos proporciona métodos para trabajar con la base de datos

public interface iAnimalRepository extends JpaRepository<Animal, Integer> {  //las interfaces no pueden implementar otras interfaces, por lo que sera hija de la clase animal
    //en el operador <> se indica el tipo de Entity con el que se va a trabajar y el tipo de dato que contiene la clave primaria
}
