package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;

import edu.eloy.SenhorDeLosAnillos.entities.Posesion;

public interface iPosesionesService {

    public List<Posesion> buscarPosesiones();

    public Posesion buscarPosesionPorId(Integer id);

    public void borrarPosesionPorid(Integer id);



}
