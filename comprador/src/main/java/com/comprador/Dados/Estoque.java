package com.comprador.Dados;



import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nomePedido;
    private Double valorPedido;
    private Integer quantidade = 0;
    @JsonIgnore
    private Integer inventario;
    private Double valorParcial = 0.0;
    private Double valorfinal = 0.0;

    public Estoque(Estoque estoque) {
        this.nomePedido = estoque.getNomePedido();
        this.valorPedido = estoque.getValorPedido();
        this.quantidade = estoque.getQuantidade();
        this.inventario = estoque.getInventario();
        this.valorParcial = estoque.getValorParcial();
        this.valorfinal = estoque.getValorfinal();
        
       
    }
   

 
    
}
