package com.edu.eloy.EloyGarcia1Trim.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.eloy.EloyGarcia1Trim.entities.Coche;
import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.TipoCoche;

import java.util.List;


public interface iCocheRepository extends JpaRepository<Coche, Integer> {

    List<Coche> findByTipo(TipoCoche tipo);

}
