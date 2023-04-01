package com.example.vendas.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vendas.dados.Comprador;
import com.example.vendas.respository.CompradorRepository;
import com.example.vendas.service.CompradorService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping
public class CompradorController {

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private CompradorService compradorService;

    @PostMapping(value = "/cadastrar")
    public ResponseEntity postMethodName(@RequestBody Comprador comprador) {
        Comprador cliente = new Comprador(comprador);

        compradorRepository.save(cliente);

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping(value = "/buscar")
    public List<Comprador> Buscar() {
        return compradorRepository.findAll();
    }

    @PostMapping(value = "/comprar/{idComprador}/{idPedidos}")
    public ResponseEntity postMethodName(@PathVariable Long idComprador, @PathVariable Long idPedidos) {
        Comprador comp = compradorService.comprar(idComprador, idPedidos);
        return ResponseEntity.ok().body(comp);

    }
}
