package com.example.vendas.dados;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomePedido;
    private String valorPedido;
    private String status;
    private LocalDateTime localDate;

    public Pedidos(Pedidos pedido) {
        this.nomePedido = pedido.getNomePedido();
        this.valorPedido = pedido.getValorPedido();
        this.status = pedido.getStatus();
    }
}
