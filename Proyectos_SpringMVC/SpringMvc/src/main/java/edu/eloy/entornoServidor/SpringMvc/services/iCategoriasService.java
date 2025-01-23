package edu.eloy.entornoServidor.SpringMvc.services;

import java.util.List;

import edu.eloy.entornoServidor.SpringMvc.model.Categoria;

public interface iCategoriasService {

    void guardar(Categoria categoria);
    List<Categoria> buscarTodas();
    Categoria buscarPorId(Integer idCategoria);
    
    
}
