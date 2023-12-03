package com.comprador.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comprador.Dados.Cliente;

public interface ClienteCompraRepository extends JpaRepository<Cliente, Long>{


    
}
