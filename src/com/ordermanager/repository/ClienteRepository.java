package com.ordermanager.repository;

import com.ordermanager.model.Cliente;
import java.util.ArrayList;
import java.util.List;

// Aqui guardamos os clientes em memória
public class ClienteRepository {

    private final List<Cliente> clientes = new ArrayList<>();

    // Adiciona cliente na lista
    public void cadastrarCliente(Cliente c) {
        clientes.add(c);
    }

    // Retorna todos os clientes
    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes); // devolve cópia da lista
    }

    // Atualiza cliente existente
    public boolean atualizarCliente(Cliente c) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == c.getId()) {
                cliente.setNome(c.getNome());
                cliente.setEmail(c.getEmail());
                cliente.setTelefone(c.getTelefone());
                cliente.setStatus(c.getStatus());
                return true;
            }
        }
        return false;
    }

    // Remove cliente pelo ID
    public boolean removerCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                clientes.remove(c);
                return true;
            }
        }
        return false;
    }
}
