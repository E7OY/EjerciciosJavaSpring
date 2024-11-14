package edu.rico.valorant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.valorant.entities.Jugador;

public interface IJugadoresRepository extends JpaRepository<Jugador, Long>{

}
