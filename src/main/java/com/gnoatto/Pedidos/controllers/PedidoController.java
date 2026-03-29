package com.gnoatto.Pedidos.controllers;


import com.gnoatto.Pedidos.models.PedidoModel;
import com.gnoatto.Pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoModel> criarPedido(@RequestBody PedidoModel pedidoNovo){
        PedidoModel pedido = pedidoService.criarPedido(pedidoNovo);
        return ResponseEntity.status(201).body(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoModel>> buscarTodosPedido(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> atualizarPedido(@PathVariable Long id,@RequestBody PedidoModel pedidoNovo){
        PedidoModel pedido = pedidoService.atualizarPedido(id, pedidoNovo);
        return ResponseEntity.ok(pedido);
    }

}
