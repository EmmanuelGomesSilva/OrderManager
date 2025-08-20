package com.ordermanager.repository;

import com.ordermanager.model.Pedido;
import java.util.ArrayList;
import java.util.List;

// Aqui guardamos os pedidos em memória
public class PedidoRepository {

    private final List<Pedido> pedidos = new ArrayList<>();

    private int proximoId = 1;// começa em 1
    // Adiciona pedido
    public void cadastrarPedido(Pedido p) {
        p.setId(proximoId++);// atribui ID automático e incrementa
        pedidos.add(p);
    }

    // Retorna todos os pedidos
    public List<Pedido> listarPedidos() {
        return new ArrayList<>(pedidos);
    }

    // Atualiza pedido existente
    public boolean atualizarPedido(Pedido p) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == p.getId()) {
                pedido.setClienteId(p.getClienteId());
                pedido.setData(p.getData());
                pedido.setValor(p.getValor());
                pedido.setStatus(p.getStatus());
                return true;
            }
        }
        return false;
    }

    // Remove pedido pelo ID
    public boolean removerPedido(int id) {
        return pedidos.removeIf(p -> p.getId() == id);
    }
}
