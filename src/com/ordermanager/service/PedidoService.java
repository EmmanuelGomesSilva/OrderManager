package com.ordermanager.service;

import com.ordermanager.model.Pedido;
import com.ordermanager.repository.PedidoRepository;
import com.ordermanager.enums.StatusPedido;

import java.util.List;

// Regras de negócio dos pedidos
public class PedidoService {

    private final PedidoRepository pedidoRepository = new PedidoRepository();

    // Registra um pedido com validações simples
    public boolean registrarPedido(Pedido p) {
        if (p.getValor() <= 0) return false;
        if (p.getStatus() == null) p.setStatus(StatusPedido.PENDENTE);

        pedidoRepository.cadastrarPedido(p);
        return true;
    }

    // Retorna todos os pedidos
    public List<Pedido> listarPedidos() {
        return pedidoRepository.listarPedidos();
    }

    // Atualiza um pedido existente
    public boolean atualizarPedido(Pedido p) {
        if (p.getClienteId() <= 0) return false;
        if (p.getValor() <= 0) return false;
        if (p.getStatus() == null) p.setStatus(StatusPedido.PENDENTE);

        return pedidoRepository.atualizarPedido(p);
    }

    // Remove pedido pelo ID
    public boolean removerPedido(int id) {
        if (id <= 0) return false;
        return pedidoRepository.removerPedido(id);
    }
}
