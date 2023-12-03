package com.comprador.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comprador.Dados.Cliente;
import com.comprador.Dados.Estoque;
import com.comprador.Repository.ClienteCompraRepository;
import com.comprador.Repository.EstoqueCompraRepository;




@Service
public class CarrinhoService {

    @Autowired
    private EstoqueCompraRepository estoqueRepository;

    @Autowired
    private ClienteCompraRepository clienteCompraRepository;

    private List<Estoque> cesta = new ArrayList<>();

    public List<Estoque> adicionarCarrinho(Long ide, Estoque quantidade) {
        Optional<Estoque> itemExistente = cesta.stream().filter(item -> item.getId().equals(ide)).findFirst();
        

        if (itemExistente.isPresent()) {

            Estoque item = itemExistente.get();
            item.setQuantidade(quantidade.getQuantidade());
            calcularValorTotal(quantidade);
            
        } else {
            atualizarCarrinho(ide, quantidade);
            calcularValorTotal(quantidade);

        }
        valorFinal(quantidade);
        return cesta;
    }


    public List<Estoque> verCarrinho() {
        return cesta;
    }

    public List<Estoque> adicionarAoCliente(Long id) {
       
            for (Estoque item : cesta) {
                
                 Cliente pessoa = new Cliente();
                    pessoa.getPedidos().add(item);
                
            }

           
            return null;
       
    }

    public void atualizarCarrinho(Long id, Estoque quantidade) {
        Estoque item = estoqueRepository.findById(id).orElse(null);

        if (item != null) {
            item.setQuantidade(quantidade.getQuantidade());
            cesta.add(item);
        }

    }

    private void calcularValorTotal(Estoque quantidade){
        Double valorTotal = 0.0;

          for (Estoque item : cesta) {
            Integer quantidades = item.getQuantidade();
            Double valor = item.getValorPedido();
            valorTotal = valor * quantidades;
            item.setValorParcial(valorTotal);
        }

    }

    private void valorFinal(Estoque quantidade){
        Double valorTotal = 0.0;

          for (Estoque item : cesta) {
            Integer quantidades = item.getQuantidade();
            Double valor = item.getValorPedido();
            valorTotal += valor * quantidades;
            item.setValorfinal(valorTotal);
        }

    }


}
