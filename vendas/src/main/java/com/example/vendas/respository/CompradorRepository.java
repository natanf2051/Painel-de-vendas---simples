package com.example.vendas.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.vendas.dados.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {

}
