package com.example.vendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.dados.Estoque;
import com.example.vendas.respository.EstoqueRepository;
import com.example.vendas.service.EstoqueService;

@RestController
@RequestMapping
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    @Autowired
    private EstoqueService estoqueService;

    @PostMapping(value = "/cadastrar/produto")
    public ResponseEntity cadastrarProduto(@RequestBody Estoque estoque){
        estoqueService.cadastrarProduto(estoque);

        return ResponseEntity.ok().body(estoque);
    }

    @GetMapping(value = "/buscar/pedidos")
    public List<Estoque> buscarProduto(){
        return estoqueRepository.findAll();
    
    }

    @GetMapping(value = "/buscar/pedidos/{id}")
    public Estoque buscarProduto(@PathVariable Long id){
        return estoqueService.buscaUnitaria(id);
    
    }


    
}
