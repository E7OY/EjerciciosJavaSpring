package edu.eloy.MotoGP.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import edu.eloy.MotoGP.entities.Carrera;

public interface iCarrerasRepository extends JpaRepository<Carrera, Integer> {

    public List<Carrera> findByPosicion();

}
