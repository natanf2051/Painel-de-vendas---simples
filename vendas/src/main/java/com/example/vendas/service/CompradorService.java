package com.example.vendas.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vendas.dados.Comprador;
import com.example.vendas.dados.Pedidos;
import com.example.vendas.respository.CompradorRepository;
import com.example.vendas.respository.PedidosRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Transactional
    public Comprador comprar(Long idComprador, Long idPedido) {
        Comprador cliente = compradorRepository.findById(idComprador)
                .orElseThrow(() -> new EntityNotFoundException("Comprador não encontrado"));

        Pedidos pedido = pedidosRepository.findById(idPedido)
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
        pedido.setLocalDate(LocalDateTime.now());
        pedido.setStatus("Concluido");
        cliente.getPedidos().add(pedido);
        pedidosRepository.save(pedido);
        compradorRepository.save(cliente);
        pedido.setStatus("Disponivel");
        return cliente;

    }

}
