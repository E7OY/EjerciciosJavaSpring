package com.eloy.cadenaHostelera.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eloy.cadenaHostelera.entities.Cliente;

public interface iClientesRepository extends JpaRepository<Cliente, Integer> {

}
