package com.edu.eloy.CadenaHostelera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.eloy.CadenaHostelera.entities.Cliente;
import com.edu.eloy.CadenaHostelera.entities.Local;

import java.util.List;
import com.edu.eloy.CadenaHostelera.entities.enumerated.Categoria;

public interface iClientesRepo extends JpaRepository<Cliente, Integer> {

    //QUERY METHODS
    List<Cliente> findByCategoria(Categoria categoria);

    List<Cliente> findByIdClienteAndLocales(Integer idCliente, Local local);

 



}
