package edu.rico.alumnos.mvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import edu.rico.alumnos.mvc.entities.Ordenador;

public interface IOrdenadorRepository extends JpaRepository<Ordenador, Long> {

}
