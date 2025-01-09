package com.edu.eloy.EloyGarcia1Trim.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.eloy.EloyGarcia1Trim.entities.talleres_coches;

public interface iTalleresCochesRepository extends JpaRepository<talleres_coches, Integer>{
    List<talleres_coches> findByFechaBefore(LocalDate fecha);

}
