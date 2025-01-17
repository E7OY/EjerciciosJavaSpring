package edu.eloy.entornoServidor.SpringMvc.services;

import java.util.List;
import edu.eloy.entornoServidor.SpringMvc.model.Vacante;

public interface iVacanteService {

    List<Vacante> buscarTodas();

    Vacante buscarPorId(Integer idVacante);

}
