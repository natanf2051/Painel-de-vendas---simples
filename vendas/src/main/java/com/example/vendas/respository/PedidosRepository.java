package com.example.vendas.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.vendas.dados.Pedidos;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    @Modifying
    @Query(value = "UPDATE pedidos SET status = 'Em estoque' WHERE id = :id", nativeQuery = true)
    int updateStatusById(@Param("id") Long id);
}
