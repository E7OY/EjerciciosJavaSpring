package edu.rico.valorant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.valorant.entities.Agente;
import java.util.List;
import edu.rico.valorant.entities.enumerated.Rol;


public interface IAgentesRepository extends JpaRepository<Agente, Long>{

    public List<Agente> findByRol(Rol rol);
    public List<Agente> findByPais(String pais);
    public Agente findByNombreAndPais(String nombre, String pais);
    public Agente findByNombreAndPaisAndRol(String nombre, String pais, Rol rol);
    public List<Agente> findByIdAgenteGreaterThan(int idAgente);
    public List<Agente> findByNombreStartingWith(String patron);


}
