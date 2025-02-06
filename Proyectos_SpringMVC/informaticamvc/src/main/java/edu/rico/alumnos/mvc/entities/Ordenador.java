package edu.rico.alumnos.mvc.entities;

import edu.rico.alumnos.mvc.entities.enumerated.CPU;
import edu.rico.alumnos.mvc.entities.enumerated.GPU;
import edu.rico.alumnos.mvc.entities.enumerated.Memoria;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "ordenadores")
public class Ordenador {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marca", length = 55, nullable = false)
    private String marca;
    @Column(name = "modelo", length = 55, nullable = false)
    private String modelo;
    @Enumerated(EnumType.STRING)
    @Column(name = "memoria_ram", nullable = false, columnDefinition = "ENUM('GB_4', 'GB_8', 'GB_16', 'GB_32', 'GB_64')")
    private Memoria memoriaRam;
    @Enumerated(EnumType.STRING)
    @Column(name = "procesador", nullable = false, columnDefinition = "ENUM('INTEL_CORE_I5', 'INTEL_CORE_I7', 'INTEL_CORE_I9', 'AMD_RYZEN_5', 'AMD_RYZEN_7', 'AMD_RYZEN_9')")
    private CPU procesador;
    @Enumerated(EnumType.STRING)
    @Column(name = "tarjeta_grafica", nullable = false, columnDefinition = "ENUM('GYGABYTE', 'MSI', 'ASUS', 'EVGA', 'ZOTAC')")
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Ordenador [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", memoriaRam=" + memoriaRam
                + ", procesador=" + procesador + ", tarjetaGrafica=" + tarjetaGrafica + "]";
    }

}