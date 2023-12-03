package com.comprador.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comprador.Dados.Cliente;
import com.comprador.Dados.Estoque;
import com.comprador.Repository.ClienteCompraRepository;
import com.comprador.Service.CarrinhoService;
import com.comprador.Service.ComprarService;



@RestController
@RequestMapping
public class CarrinhoController {
    

    @Autowired
    private CarrinhoService carrinhoService;  
      
    @Autowired
    private ComprarService comprarService;

    @Autowired
    private ClienteCompraRepository clienteCompraRepository;

    
    @PostMapping(value = "/carrinho/{id}")
    public ResponseEntity adicionarCarrinho(@PathVariable Long id, @RequestBody Estoque quantidade){
       List<Estoque> itens = carrinhoService.adicionarCarrinho(id, quantidade);
       
        return ResponseEntity.ok().body(itens);         
    }

    @GetMapping(value = "/carrinho/ver")
    public List<Estoque> vizualizarCarrinho(){
        return carrinhoService.verCarrinho();
    }

     @GetMapping(value = "/carrinho/vera")
    public List<Cliente> zualizarCarrinho(){
        return clienteCompraRepository.findAll();
    }

    @PostMapping(value = "/finalizar/{id}")
    public ResponseEntity finalizarCompra(@PathVariable Long id){
        
        return ResponseEntity.ok().body(carrinhoService.adicionarAoCliente(id));
    }


}
