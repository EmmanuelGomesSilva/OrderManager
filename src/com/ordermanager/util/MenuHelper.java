package com.ordermanager.util;

import com.ordermanager.model.Cliente;
import com.ordermanager.model.Pedido;

import java.util.List;

public class MenuHelper {

    // Verifica se há clientes cadastrados
    public static boolean temClientes(List<Cliente> clientes) {
        if (clientes == null || clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado!");
            return false;
        }
        return true;
    }

    // Verifica se há pedidos cadastrados
    public static boolean temPedidos(List<Pedido> pedidos) {
        if (pedidos == null || pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado!");
            return false;
        }
        return true;
    }
}
