package com.eloy.cadenaHostelera.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.OnDelete;

import com.eloy.cadenaHostelera.entities.enumerated.Categoria;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column(length = 55, nullable = false)
    private String nombre;

    @Column(length = 55, nullable = false)
    private String apellido1;

    @Column(length = 55, nullable = true)
    private String apellido2;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate fecha_nacimiento;

    @Column(nullable = false)
    private Integer telefono;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "ENUM('VIP', 'REGULAR', 'INVITADO', 'CASUAL')")
    private Categoria categoria;

    @ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Local> listaLocales;

    public Cliente() {
    }

    public Cliente(Integer id_cliente, String nombre, String apellido1, String apellido2, LocalDate fecha_nacimiento,
            Integer telefono, Categoria categoria) {
        this.id_cliente = id_cliente;
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

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
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
        return "Cliente [id_cliente=" + id_cliente + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2="
                + apellido2 + ", fechaNacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", categoria="
                + categoria + "]";
    }
}
