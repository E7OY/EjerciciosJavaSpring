package edu.eloy.SenhorDeLosAnillos.services;

import java.util.List;

import edu.eloy.SenhorDeLosAnillos.entities.Personaje;


public interface iPersonajesService {

    public List<Personaje> buscarPersonajes();

    public Personaje buscarPersonajePorId(Integer id);

    public void borrarPersonaje(Integer id);

    public Personaje guardarPersonaje(Personaje personaje);

    public Personaje actualizarPersonaje(Personaje personaje);

}
