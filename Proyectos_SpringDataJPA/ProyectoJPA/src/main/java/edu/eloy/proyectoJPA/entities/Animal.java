package edu.eloy.proyectoJPA.entities;

import edu.eloy.proyectoJPA.enumerated.Especie;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//Lo que lleva @ son decoradores
//las clases entities no son beans, no son parte de la configuración de Spring, son clases que se van a mapear a la base de datos
//si una clase es bean, spring instancia un objeto de esa clase al iniciar la aplicación
@Entity //definimos la clase como Entity

//indicamos a que tabla va a mapear la clase Animal
@Table(name="animales")  //importamos jakarta.persistence.Table

public class Animal {

    //le indicamos la columna que va a ser la clave primaria
    @Id
    
    //Le indicamos que la clave primaria va a ser generada automáticamente (auto-increment) y la estrategia de generación de la clave
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    //long con L mayuscula ya que es una clase envoltorio o wrapper, Integer es la clase wrapper de int 
    private Integer id;
    @Column(name = "nombre", length = 255, nullable = false, unique = true)
    private String nombre;
    @Enumerated(EnumType.STRING)
    private Especie especie;
    private Double peso;
    private Integer edad;

    //para generar constructores y getters y setters, clic derecho -> source action...
    public Animal() {
    }

    public Animal(Integer id, String nombre, Especie especie, Double peso, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
    }

    public Animal(String nombre, Especie especie, Double peso, Integer edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.peso = peso;
        this.edad = edad;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especie getEspecie() {
        return especie;
    }

    public void setEspecie(Especie especie) {
        this.especie = especie;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Animal [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", peso=" + peso + ", edad=" + edad
                + "]";
    }



}
