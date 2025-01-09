package com.edu.eloy.EloyGarcia1Trim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.eloy.EloyGarcia1Trim.entities.Taller;
import java.util.List;


public interface iTallerRepository extends JpaRepository<Taller, Integer> {

    public List<Taller> findByNombre(String nombre);

}
