package com.comprador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprador.Dados.Estoque;



public interface EstoqueCompraRepository extends JpaRepository<Estoque, Long> {

    
}
