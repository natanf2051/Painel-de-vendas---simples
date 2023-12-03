package com.comprador.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.comprador.Dados.Cliente;
import com.comprador.Dados.Estoque;
import com.comprador.Repository.ClienteCompraRepository;
import com.comprador.Repository.EstoqueCompraRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ComprarService {
    
    @Autowired
    private ClienteCompraRepository clienteCompraRepository;

    @Autowired
    private EstoqueCompraRepository estoqueCompraRepository;

        @Transactional
        public Cliente comprar(Long idComprador, Long idPedido) {
            Cliente cliente = clienteCompraRepository.findById(idComprador)
                    .orElseThrow(() -> new EntityNotFoundException("Comprador não encontrado"));
    
            Estoque pedido = estoqueCompraRepository.findById(idPedido)
                    .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado"));
    
    
            cliente.getPedidos().add(pedido);
            estoqueCompraRepository.save(pedido);
            clienteCompraRepository.save(cliente);
            return cliente;
    
        }

}