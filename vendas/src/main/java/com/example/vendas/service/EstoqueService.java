package com.example.vendas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vendas.dados.Estoque;
import com.example.vendas.respository.EstoqueRepository;


import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EstoqueService {

    private static final Logger log = LoggerFactory.getLogger(EstoqueService.class);

    @Autowired
    private EstoqueRepository estoqueRepository;
   
    public Estoque cadastrarProduto(Estoque estoque){
        log.info("Cadastrando produto: {}", estoque);
        Estoque produto = new Estoque(estoque);
        log.info("Produto cadastrado: {}", produto);
        estoqueRepository.save(produto);
        log.info("Produto cadastrado. ID: {}", produto.getId());

        return produto;
    }

    

   public Estoque buscaUnitaria(Long id) {
        Optional<Estoque> est = estoqueRepository.findById(id);

        // Verifica se o Optional contém um valor antes de chamar get()
        if (est.isPresent()) {
            return est.get();
        } else {
            // Lida com a situação em que o ID não foi encontrado
            throw new NoSuchElementException("Estoque com ID " + id + " não encontrado");
        }
}

   
}