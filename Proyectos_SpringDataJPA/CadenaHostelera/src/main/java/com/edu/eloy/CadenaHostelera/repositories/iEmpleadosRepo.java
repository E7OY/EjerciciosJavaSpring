package com.edu.eloy.CadenaHostelera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.eloy.CadenaHostelera.entities.Empleado;

public interface iEmpleadosRepo extends JpaRepository<Empleado, Integer> {

    //QUERY METHODS

}
