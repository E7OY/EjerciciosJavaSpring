package edu.rico.valorant.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rico.valorant.entities.Partida;

public interface IPartidasRepository extends JpaRepository<Partida, Long> {

}
