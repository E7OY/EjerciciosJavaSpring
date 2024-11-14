package edu.eloy.valorantworld.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="jugadores")

public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private Long edad;
    private String email;
    private String nacionalidad;
    @Column(unique = true)
    private String apodo;
    //Para el manejo de fechas usamos LocalDate en vez de Date para facilitar la conversión de datos
    private LocalDate fechaNacimiento;
    

        //OnDelete -> Anotación para inidicar que se eliminen en cascada las partidas de un jugador cuando se elimine el jugador 
        @OnDelete(action = OnDeleteAction.CASCADE)
        //Anotación para indicar que la relación es de uno a muchos, un jugador puede tener varias partidas
        @OneToMany(mappedBy = "jugador", fetch = FetchType.EAGER, orphanRemoval = true)
        private List<Partida> partidas;

    public Jugador() {
    }

    public Jugador(Long id, String nombre, String apellido, Long edad, String email, String nacionalidad, String apodo,
            LocalDate fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Jugador(String nombre, String apellido, Long edad, String email, String nacionalidad, String apodo,
    LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    @Override
    public String toString() {
        return "Jugador [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", email="
                + email + ", nacionalidad=" + nacionalidad + ", apodo=" + apodo + ", fechaNacimiento=" + fechaNacimiento + "]";
    }

}
