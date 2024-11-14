package edu.eloy.valorantworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.valorantworld.entities.Agente;
import java.util.List;
import edu.eloy.valorantworld.enumerated.Rol;


public interface iAgentesRepository extends JpaRepository<Agente, Long> {

    //Query Methods
    List<Agente> findByRol(Rol rol);
    List<Agente> findByNombre(String nombre);

}
