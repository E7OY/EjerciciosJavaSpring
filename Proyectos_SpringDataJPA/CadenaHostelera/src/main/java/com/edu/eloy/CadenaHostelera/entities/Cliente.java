package com.edu.eloy.CadenaHostelera.entities;

import java.time.LocalDate;
import java.util.List;
import com.edu.eloy.CadenaHostelera.entities.enumerated.Categoria;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;

    @Column(name = "apellido1", length = 55, nullable = false)
    private String apellido1;

    @Column(name = "apellido2", length = 55, nullable = true)
    private String apellido2;

    @Column(name = "fecha_nacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "categoria", columnDefinition = "ENUM('VIP', 'REGULAR', 'INVITADO', 'CASUAL')", nullable = false)
    private Categoria categoria;


    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "clientes", cascade = CascadeType.ALL)
    private List<Local> locales;




    public Cliente() {
    }

    public Cliente(Integer idCliente, String nombre, String apellido1, String apellido2, LocalDate fecha_nacimiento,
            Integer telefono, Categoria categoria) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    public Cliente(String nombre, String apellido1, String apellido2, LocalDate fecha_nacimiento,
            Integer telefono, Categoria categoria) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.categoria = categoria;
    }

    

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<Local> getLocales() {
        return locales;
    }

    public void setLocales(List<Local> locales) {
        this.locales = locales;
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

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
                + apellido2 + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", categoria="
                + categoria  + "locales= " + locales + "]";
    }


    

    

}
