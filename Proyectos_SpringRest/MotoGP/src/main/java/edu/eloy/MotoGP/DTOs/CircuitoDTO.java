package edu.eloy.MotoGP.DTOs;

import java.util.List;

import edu.eloy.MotoGP.entities.Carrera;

public class CircuitoDTO {

    private String nombre;
    private String localidad;
    private List<Carrera> carreras;
    
    public CircuitoDTO() {
    }

    public CircuitoDTO(String nombre, String localidad, List<Carrera> carreras) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.carreras = carreras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    


}
