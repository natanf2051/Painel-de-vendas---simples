package com.example.vendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.dados.Pedidos;
import com.example.vendas.respository.PedidosRepository;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping
public class PedidosController {

    @Autowired
    private PedidosRepository pedidosRepository;

    @PostMapping(value = "/cadastrar/pedidos")
    public ResponseEntity cadastrarPedido(@RequestBody Pedidos pedidos) {
        Pedidos pedido = new Pedidos(pedidos);

        pedidosRepository.save(pedido);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping(value = "/buscar/pedidos")
    public List<Pedidos> getMethodName() {
        return pedidosRepository.findAll();
    }

}
