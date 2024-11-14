package edu.eloy.valorantworld.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.eloy.valorantworld.entities.Partida;

public interface iPartidasRepository extends JpaRepository<Partida, Long> {

}
