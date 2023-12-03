package com.example.vendas.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vendas.dados.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {

    
}
