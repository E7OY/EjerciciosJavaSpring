package edu.rico.valorant.entities;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.time.*;
import java.util.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Entity
@Table(name="jugadores")
public class Jugador {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 55, nullable = false)
    private String nombre;
    @Column(length = 55, nullable = false)
    private String apellido;
    private int edad;
    @Column(length = 255, nullable = false)
    private String email;
    private String nacionalidad;
    @Column(unique=true,length = 55, nullable = false)
    private String apodo;
    @Temporal(TemporalType.DATE)
    private LocalDate fechaNacimiento;

    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "jugador", orphanRemoval = true, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<Partida> partidas;

    public Jugador(){}

    public Jugador(Long id, String nombre, String apellido, int edad, String email, String nacionalidad, String apodo,
            LocalDate fechaNacimiento, List<Partida> partidas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.email = email;
        this.nacionalidad = nacionalidad;
        this.apodo = apodo;
        this.fechaNacimiento = fechaNacimiento;
        this.partidas = partidas;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
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
                + email + ", nacionalidad=" + nacionalidad + ", apodo=" + apodo + ", fechaNacimiento=" + fechaNacimiento
                + "]";
    }

    public List<Partida> getPartidas() {
        return partidas;
    }

    public void setPartidas(List<Partida> partidas) {
        this.partidas = partidas;
    }

    

    


}
