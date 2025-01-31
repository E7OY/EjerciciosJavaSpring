package edu.rico.alumnos.mvc.entities;

import java.time.LocalDate;

import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alumnos")

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;
    @Column(name = "apellido1", length = 55, nullable = false)
    private String apellido1;
    @Column(name = "apellido2", length = 55, nullable = true)
    private String apellido2;
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", nullable = false, columnDefinition ="ENUM('HOMBRE', 'MUJER')")
    private Genero genero;
    @Enumerated(EnumType.STRING)
    @Column(name = "disposicion", nullable = false, columnDefinition = "ENUM('AUSENTE', 'COLABORADOR', 'TRABAJADOR')")
    private Disposicion disposicion;
    @Column(name = "foto_dni", length = 255, nullable = true)
    private String fotoDni;
    
  

    public Alumno() {
    }

    public Alumno(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Genero genero,
            Disposicion disposicion, String fotoDni) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.disposicion = disposicion;
        this.fotoDni = fotoDni;
    }
 
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return apellido1;
    }
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return apellido2;
    }
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Disposicion getDisposicion() {
        return disposicion;
    }
    public void setDisposicion(Disposicion disposicion) {
        this.disposicion = disposicion;
    }
 

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", disposicion=" + disposicion
                + ", fotoDni=" + fotoDni + "]";
    }

    public String getFotoDni() {
        return fotoDni;
    }

    public void setFotoDni(String fotoDni) {
        this.fotoDni = fotoDni;
    }
}
