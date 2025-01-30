package edu.rico.alumnos.mvc.entities;

import java.time.LocalDate;

import edu.rico.alumnos.mvc.entities.enumerated.Disposicion;
import edu.rico.alumnos.mvc.entities.enumerated.Genero;

public class Alumno {

    private String nombre;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaNacimiento;
    private Genero genero;
    private Disposicion disposicion;
    
    public Alumno() {
    }
    
    public Alumno(String nombre, String apellido1, String apellido2, LocalDate fechaNacimiento, Genero genero,
            Disposicion disposicion) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.disposicion = disposicion;
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
                + ", fechaNacimiento=" + fechaNacimiento + ", genero=" + genero + ", disposicion=" + disposicion + "]";
    }
}
