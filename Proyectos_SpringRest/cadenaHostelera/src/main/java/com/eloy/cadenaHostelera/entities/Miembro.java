package com.eloy.cadenaHostelera.entities;

import java.time.LocalDate;

import com.eloy.cadenaHostelera.entities.enumerated.Cargo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "miembros")

public class Miembro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_miembro;

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
    @Column(nullable = false, columnDefinition = "ENUM('LIMPIADOR', 'CAMARERO', 'SECURATA', 'COCINERO')")
    private Cargo cargo;


    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = Local.class, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "local", referencedColumnName = "id_local")
    private Local local;

    public Miembro() {
    }

    public Miembro(Integer id_miembro, String apellido1, String apellido2, LocalDate fecha_nacimiento, Integer telefono,
            Cargo cargo) {
        this.id_miembro = id_miembro;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public Miembro(String apellido1, String apellido2, LocalDate fecha_nacimiento, Integer telefono,
    Cargo cargo) {
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public Integer getId_miembro() {
        return id_miembro;
    }

    public void setId_miembro(Integer id_miembro) {
        this.id_miembro = id_miembro;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Miembro [id_miembro=" + id_miembro + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", cargo=" + cargo + "]";
    }


}
