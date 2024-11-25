package edu.eloy.MotoGP.repositories;

import org.hibernate.id.factory.spi.CustomIdGeneratorCreationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.MotoGP.entities.Circuito;
import java.util.List;


public interface iCircuitosRepository extends JpaRepository<Circuito, Integer>{

    public Circuito findByNombre(String nombre);

}
