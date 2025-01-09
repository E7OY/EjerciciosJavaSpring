package com.eloy.cadenaHostelera.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eloy.cadenaHostelera.Repositories.iClientesRepository;
import com.eloy.cadenaHostelera.entities.Cliente;
import com.eloy.cadenaHostelera.entities.enumerated.Categoria;

@Service

public class ClientesService implements iClientesService {

    @Autowired
    iClientesRepository clientesRepo;

    @Override
    public List<Cliente> getAllClientes() {
        return clientesRepo.findAll();
    }

    @Override
    public Cliente getClienteId(Integer idUrl) {
        Optional<Cliente> op = clientesRepo.findById(idUrl); 
        if(!op.isPresent()) {
            System.out.println("No se ha encontrado un cliente con el id especificado");
            return null;
        }
        return op.get();
    }

    @Override
    public void deleteClienteId(Integer idUrl) {
        clientesRepo.deleteById(idUrl);
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        return clientesRepo.save(cliente);
    }

    @Override
    public Cliente updateCliente(Cliente cliente) {
        return clientesRepo.save(cliente);
    }

    // Devuelve una lista de clientes que son VIP
    @Override
    public List<Cliente> clientesVip() {
        List<Cliente> listaClientes = clientesRepo.findAll();
        List<Cliente> clientesVip = new ArrayList<>();
        for(Cliente cli : listaClientes) {
            if (cli.getCategoria() == Categoria.VIP) {
                clientesVip.add(cli);
            }
        }
        return clientesVip;
    }
}
