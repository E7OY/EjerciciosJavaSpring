package edu.rico.alumnos.mvc.entities;

import edu.rico.alumnos.mvc.entities.enumerated.CPU;
import edu.rico.alumnos.mvc.entities.enumerated.GPU;
import edu.rico.alumnos.mvc.entities.enumerated.Memoria;

public class Ordenador {

    private String marca;
    private String modelo;
    private Memoria memoriaRam;
    private CPU procesador;
    private GPU tarjetaGrafica;

    public Ordenador() {
    }

    public Ordenador(String marca, String modelo, Memoria memoriaRam, CPU procesador, GPU tarjetaGrafica) {
        this.marca = marca;
        this.modelo = modelo;
        this.memoriaRam = memoriaRam;
        this.procesador = procesador;
        this.tarjetaGrafica = tarjetaGrafica;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Memoria getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Memoria memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public CPU getProcesador() {
        return procesador;
    }

    public void setProcesador(CPU procesador) {
        this.procesador = procesador;
    }

    public GPU getTarjetaGrafica() {
        return tarjetaGrafica;
    }

    public void setTarjetaGrafica(GPU tarjetaGrafica) {
        this.tarjetaGrafica = tarjetaGrafica;
    }

    @Override
    public String toString() {
        return "Ordenador [marca=" + marca + ", modelo=" + modelo + ", memoriaRam=" + memoriaRam + ", procesador="
                + procesador + ", tarjetaGrafica=" + tarjetaGrafica + "]";
    }
}
