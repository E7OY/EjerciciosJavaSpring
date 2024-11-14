package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;

import edu.eloy.SenhorDeLosAnillos.entities.Artefacto;

public interface iArtefactosService {

    public List<Artefacto> getArtefactos();

    public Artefacto getArtefactoPorId(Integer id);

}
