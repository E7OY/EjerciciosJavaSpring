package edu.rico.alumnos.mvc.entities;

public class Asignatura {

    private String nombre;
    private String abreviatura;
    
    public Asignatura() {
    }
    public Asignatura(String nombre, String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAbreviatura() {
        return abreviatura;
    }
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    @Override
    public String toString() {
        return "Asignatura [nombre=" + nombre + ", abreviatura=" + abreviatura + "]";
    }
}
