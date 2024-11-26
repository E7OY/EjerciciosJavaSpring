package edu.eloy.MotoGP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.eloy.MotoGP.entities.Circuito;

public interface iCircuitosRepository extends JpaRepository<Circuito, Integer>{

    public Circuito findByNombre(String nombre);

}
