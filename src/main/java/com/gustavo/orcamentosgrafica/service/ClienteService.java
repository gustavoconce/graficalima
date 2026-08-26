package com.gustavo.orcamentosgrafica.service;

import com.gustavo.orcamentosgrafica.entity.Cliente;
import com.gustavo.orcamentosgrafica.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

}
