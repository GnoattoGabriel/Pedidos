package com.gnoatto.Pedidos.repositories;

import com.gnoatto.Pedidos.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
