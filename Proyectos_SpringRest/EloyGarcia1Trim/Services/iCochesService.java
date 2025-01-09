package com.edu.eloy.EloyGarcia1Trim.Services;

import java.util.List;
import com.edu.eloy.EloyGarcia1Trim.entities.Coche;
import com.edu.eloy.EloyGarcia1Trim.entities.enumerated.TipoCoche;

public interface iCochesService {

    public List<Coche> getCoches();

    public Coche getCocheId(Integer idUrl);

    public Coche saveCoche(Coche coche);

    public void deleteCoche(Integer idUrl);

    public Coche updateCoche(Coche coche);

    public List<Coche> obtenerCochesFechaAntesDeAnho(int anho);

    public List<Coche> tipoCoche(TipoCoche tipo);


}
