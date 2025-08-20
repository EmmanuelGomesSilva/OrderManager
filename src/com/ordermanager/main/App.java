package com.ordermanager.main;

import com.ordermanager.model.Cliente;
import com.ordermanager.model.Pedido;
import com.ordermanager.enums.StatusCliente;
import com.ordermanager.enums.StatusPedido;
import com.ordermanager.service.ClienteService;
import com.ordermanager.service.PedidoService;
import com.ordermanager.util.InputHelper;

import java.time.LocalDate;
import java.util.List;

public class App {
    public static void main(String[] args) {
        InputHelper input = new InputHelper();
        ClienteService clienteService = new ClienteService();
        PedidoService pedidoService = new PedidoService();

        boolean rodando = true;
        while (rodando) {
            System.out.println("=== MENU PRINCIPAL ===");
            System.out.println("1 - Clientes");
            System.out.println("2 - Pedidos");
            System.out.println("0 - Sair");

            int opcao = input.lerInt("Escolha uma opção:", 0, 2);

            switch (opcao) {
                case 1 -> menuClientes(input, clienteService); // chama menu de clientes
                case 2 -> menuPedidos(input, pedidoService);   // chama menu de pedidos
                case 0 -> {
                    rodando = false;
                    System.out.println("Saindo...");
                }
            }
        }
    }

    // Menu para gerenciar clientes: cadastrar, listar, atualizar e remover
    private static void menuClientes(InputHelper input, ClienteService service) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU CLIENTES ===");
            System.out.println("1 - Cadastrar cliente");
            System.out.println("2 - Listar clientes");
            System.out.println("3 - Atualizar cliente");
            System.out.println("4 - Remover cliente");
            System.out.println("0 - Voltar");

            int opcao = input.lerInt("Escolha uma opção:", 0, 4);

            switch (opcao) {
                case 1 -> {
                    String nome = input.lerString("Nome:");
                    String email = input.lerString("Email:");
                    String telefone = input.lerString("Telefone:");
                    StatusCliente status = input.lerStatusCliente("Status do cliente:");

                    Cliente c = new Cliente(0, nome, email, telefone, status);
                    boolean sucesso = service.registrarCliente(c);
                    System.out.println(sucesso ? "Cliente cadastrado!" : "Erro ao cadastrar cliente.");
                }
                case 2 -> {
                    List<Cliente> clientes = service.listarClientes();
                    clientes.forEach(System.out::println);
                }
                case 3 -> {
                    int id = input.lerInt("ID do cliente para atualizar:", 1, Integer.MAX_VALUE);
                    String nome = input.lerString("Novo nome:");
                    String email = input.lerString("Novo email:");
                    String telefone = input.lerString("Novo telefone:");
                    StatusCliente status = input.lerStatusCliente("Novo status:");

                    Cliente c = new Cliente(id, nome, email, telefone, status);
                    boolean sucesso = service.atualizarCliente(c);
                    System.out.println(sucesso ? "Cliente atualizado!" : "Cliente não encontrado.");
                }
                case 4 -> {
                    int id = input.lerInt("ID do cliente para remover:", 1, Integer.MAX_VALUE);
                    boolean sucesso = service.removerCliente(id);
                    System.out.println(sucesso ? "Cliente removido!" : "Cliente não encontrado.");
                }
                case 0 -> rodando = false; // volta pro menu principal
            }
        }
    }

    // Menu para gerenciar pedidos: registrar, listar, atualizar e remover
    private static void menuPedidos(InputHelper input, PedidoService service) {
        boolean rodando = true;
        while (rodando) {
            System.out.println("\n=== MENU PEDIDOS ===");
            System.out.println("1 - Registrar pedido");
            System.out.println("2 - Listar pedidos");
            System.out.println("3 - Atualizar pedido");
            System.out.println("4 - Remover pedido");
            System.out.println("0 - Voltar");

            int opcao = input.lerInt("Escolha uma opção:", 0, 4);

            switch (opcao) {
                case 1 -> {
                    int id = input.lerInt("ID do pedido:", 1, Integer.MAX_VALUE);
                    int clienteId = input.lerInt("ID do cliente:", 1, Integer.MAX_VALUE);
                    double valor = input.lerDouble("Valor do pedido:");
                    StatusPedido status = input.lerStatusPedido("Status do pedido:");

                    Pedido p = new Pedido(id, clienteId, LocalDate.now(), valor, status);
                    boolean sucesso = service.registrarPedido(p);
                    System.out.println(sucesso ? "Pedido registrado!" : "Erro ao registrar pedido.");
                }
                case 2 -> {
                    List<Pedido> pedidos = service.listarPedidos();
                    pedidos.forEach(System.out::println);
                }
                case 3 -> {
                    int id = input.lerInt("ID do pedido para atualizar:", 1, Integer.MAX_VALUE);
                    int clienteId = input.lerInt("Novo ID do cliente:", 1, Integer.MAX_VALUE);
                    double valor = input.lerDouble("Novo valor do pedido:");
                    StatusPedido status = input.lerStatusPedido("Novo status do pedido:");

                    Pedido p = new Pedido(id, clienteId, LocalDate.now(), valor, status);
                    boolean sucesso = service.atualizarPedido(p);
                    System.out.println(sucesso ? "Pedido atualizado!" : "Pedido não encontrado.");
                }
                case 4 -> {
                    int id = input.lerInt("ID do pedido para remover:", 1, Integer.MAX_VALUE);
                    boolean sucesso = service.removerPedido(id);
                    System.out.println(sucesso ? "Pedido removido!" : "Pedido não encontrado.");
                }
                case 0 -> rodando = false; // volta pro menu principal
            }
        }
    }
}
