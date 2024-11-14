package com.edu.eloy.CadenaHostelera.entities;

import java.time.LocalDate;
import com.edu.eloy.CadenaHostelera.entities.enumerated.Cargo;
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
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "empleados")

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpleado")
    private Integer idEmpleado;

    @Column(name = "nombre", length = 55, nullable = false)
    private String nombre;
    
    @Column(name = "apellido1", length = 55, nullable = false)
    private String apellido1;

    @Column(name = "apellido2", length = 55, nullable = true)
    private String apellido2;

    @Column(name = "fecha_nacimiento", length = 55, nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate fecha_nacimiento;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "cargo", nullable = false, columnDefinition = "ENUM('LIMPIADOR', 'SECURATA', 'CAMARERO', 'COCINERO')")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.EAGER ,targetEntity = Local.class, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "local", referencedColumnName = "idLocal")
    private Local local;

    public Empleado() {
    }

    public Empleado(Integer idEmpleado, String nombre, String apellido1, String apellido2, LocalDate fecha_nacimiento,
            Integer telefono, Cargo cargo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.cargo = cargo;
    }

    public Empleado(String nombre, String apellido1, String apellido2, LocalDate fecha_nacimiento,
            Integer telefono, Cargo cargo) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.cargo = cargo;
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

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    

    @Override
    public String toString() {
        return "Empleado [id=" + idEmpleado + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
                + ", fecha_nacimiento=" + fecha_nacimiento + ", telefono=" + telefono + ", cargo=" + cargo + ", local="
                + local.getNombre() + "]";
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

}
