package edu.eloy.MotoGP.DTOs;

import java.util.List;

import edu.eloy.MotoGP.entities.Carrera;
import edu.eloy.MotoGP.entities.enumerated.Conduccion;

public class PilotoDTO {

    private String nombre;
    private Conduccion conduccion;
    private List<Carrera> carreras;

    public PilotoDTO(){
    }

    public PilotoDTO(String nombre, Conduccion conduccion, List<Carrera> carreras) {
        this.nombre = nombre;
        this.conduccion = conduccion;
        this.carreras = carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Conduccion getConduccion() {
        return conduccion;
    }

    public void setConduccion(Conduccion conduccion) {
        this.conduccion = conduccion;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public String toString() {
        return "PilotoDTO [nombre=" + nombre + ", conduccion=" + conduccion + ", carreras=" + carreras + "]";
    }

  

}
