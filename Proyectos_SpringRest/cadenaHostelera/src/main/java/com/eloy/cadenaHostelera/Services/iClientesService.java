package com.eloy.cadenaHostelera.Services;

import java.util.List;
import com.eloy.cadenaHostelera.entities.Cliente;

public interface iClientesService {

    public List<Cliente> getAllClientes();

    public Cliente getClienteId(Integer idUrl);

    public void deleteClienteId(Integer idUrl);

    public Cliente saveCliente(Cliente cliente);

    public Cliente updateCliente(Cliente cliente);

    public List<Cliente> clientesVip();
}
