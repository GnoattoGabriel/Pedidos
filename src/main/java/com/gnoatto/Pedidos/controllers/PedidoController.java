package com.gnoatto.Pedidos.controllers;


import com.gnoatto.Pedidos.models.PedidoModel;
import com.gnoatto.Pedidos.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public PedidoModel criarPedido(@RequestBody PedidoModel pedidoNovo){
        return pedidoService.criarPedido(pedidoNovo);
    }

    @GetMapping
    public List<PedidoModel> buscarTodosPedido(){
        return pedidoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
    }

    @GetMapping("/{id}")
    public Optional<PedidoModel> buscarPorId(@PathVariable Long id){
        return pedidoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public PedidoModel atualizarPedido(@PathVariable Long id,@RequestBody PedidoModel pedidoNovo){
        return pedidoService.atualizarPedido(id, pedidoNovo);
    }

}
