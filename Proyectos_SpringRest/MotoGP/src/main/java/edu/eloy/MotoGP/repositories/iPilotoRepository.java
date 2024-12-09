package edu.eloy.MotoGP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import edu.eloy.MotoGP.entities.Piloto;
import edu.eloy.MotoGP.entities.enumerated.Conduccion;

public interface iPilotoRepository extends JpaRepository<Piloto, Integer>{

    public List<Piloto> findByConduccion(Conduccion conduccion);

}
