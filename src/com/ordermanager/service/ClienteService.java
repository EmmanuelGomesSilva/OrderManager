package com.ordermanager.service;

import com.ordermanager.model.Cliente;
import com.ordermanager.repository.ClienteRepository;
import com.ordermanager.enums.StatusCliente;
import com.ordermanager.repository.PedidoRepository;

import java.util.List;

// Aqui ficam as regras de negócio dos clientes
public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();
    private final PedidoRepository pedidoRepository = new PedidoRepository();// verifica pedidos existentes

    // Registra um cliente com validação simples
    public boolean registrarCliente(Cliente c) {
        if (c.getNome() == null || c.getNome().isBlank()) return false;
        if (c.getEmail() == null || c.getEmail().isBlank()) return false;
        if (c.getStatus() == null) c.setStatus(StatusCliente.ATIVO); // assume ATIVO por padrão
        clienteRepository.cadastrarCliente(c);
        return true;
    }

    // Lista todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.listarClientes();
    }

    // Atualiza cliente
    public boolean atualizarCliente(Cliente c) {
        if (c.getNome() == null || c.getNome().isBlank()) return false;
        if (c.getStatus() == null) c.setStatus(StatusCliente.ATIVO);
        return clienteRepository.atualizarCliente(c);
    }

    // Remove cliente somente se não tiver pedidos
    public boolean removerCliente(int id) {
        // Verifica se há pedidos para este cliente
        boolean tempPdidos = pedidoRepository.listarPedidos().stream()
                .anyMatch(p -> p.getClienteId() == id);

        if (tempPdidos) {
            System.out.println("Não é possível remover o cliente. Ele possui pedidos cadastrados.");
            return false;
        }
        return clienteRepository.removerCliente(id);

    }
}
