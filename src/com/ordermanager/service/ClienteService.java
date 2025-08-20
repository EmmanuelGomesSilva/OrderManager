package com.ordermanager.service;

import com.ordermanager.model.Cliente;
import com.ordermanager.repository.ClienteRepository;
import com.ordermanager.enums.StatusCliente;

import java.util.List;

// Aqui ficam as regras de negócio dos clientes
public class ClienteService {

    private final ClienteRepository clienteRepository = new ClienteRepository();

    // Registra um cliente com validação simples
    public boolean registrarCliente(Cliente c) {
        if (c.getNome() == null || c.getNome().isBlank()) return false;
        if (c.getEmail() == null || c.getEmail().isBlank()) return false;

        if (c.getStatus() == null) c.setStatus(StatusCliente.ATIVO); // assume ATIVO por padrão

        clienteRepository.cadastrarCliente(c);
        return true;
    }

    // Retorna todos os clientes
    public List<Cliente> listarClientes() {
        return clienteRepository.listarClientes();
    }

    // Atualiza um cliente existente
    public boolean atualizarCliente(Cliente c) {
        return clienteRepository.atualizarCliente(c);
    }

    // Remove cliente pelo ID
    public boolean removerCliente(int id) {
        return clienteRepository.removerCliente(id);
    }
}
