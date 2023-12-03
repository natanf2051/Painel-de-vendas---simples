package com.example.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendas.dados.Cliente;
import com.example.vendas.respository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cadastrar(Cliente cliente){
        Cliente cliente1 = new Cliente();
        clienteRepository.save(cliente);

        return cliente1;
    }
    
}
