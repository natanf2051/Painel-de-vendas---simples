package com.example.vendas.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.dados.Cliente;
import com.example.vendas.service.ClienteService;

@RestController
@RequestMapping
public class ClienteController {


    @Autowired
    private ClienteService clienteService;


    @PostMapping(value = "/cadastrar")
    public ResponseEntity cadastrarCliente(@RequestBody Cliente cliente){
        clienteService.cadastrar(cliente);

        return ResponseEntity.ok().body(cliente);

    }
    
}
