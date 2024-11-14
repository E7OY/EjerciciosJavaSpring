package com.edu.eloy.CadenaHostelera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edu.eloy.CadenaHostelera.entities.Local;
import java.util.List;

public interface iLocalesRepo extends JpaRepository<Local, Integer> {

    //QUERY METHODS
    Local findByNombre(String nombre);

    List<Local> findByAforoBetween(Integer min, Integer max);

}
