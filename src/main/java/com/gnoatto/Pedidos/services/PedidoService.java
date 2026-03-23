package com.gnoatto.Pedidos.services;


import com.gnoatto.Pedidos.models.PedidoModel;
import com.gnoatto.Pedidos.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public PedidoModel criarPedido(PedidoModel pedido){
        return pedidoRepository.save(pedido);
    }

    public List<PedidoModel> findAll(){
        return pedidoRepository.findAll();
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }

    public Optional<PedidoModel> buscarPorId(Long id){
        return pedidoRepository.findById(id);
    }

    public PedidoModel atualizarPedido(Long id, PedidoModel pedidoNovo){
        Optional<PedidoModel> pedidoNobanco = pedidoRepository.findById(id);

        if (pedidoNobanco.isPresent()){
            PedidoModel pedidoEditar = pedidoNobanco.get();

            pedidoEditar.setData(pedidoNovo.getData());
            pedidoEditar.setValorTotal(pedidoNovo.getValorTotal());
            pedidoEditar.setStatus(pedidoNovo.getStatus());

            return pedidoRepository.save(pedidoEditar);
        } else return  null;
    }

}
