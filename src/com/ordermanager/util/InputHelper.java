package com.ordermanager.util;

import com.ordermanager.enums.StatusCliente;
import com.ordermanager.enums.StatusPedido;

import java.util.Locale;
import java.util.Scanner;

// Facilita a leitura de dados do usuário
public class InputHelper {

    private final Scanner scanner;

    public InputHelper() {
        this.scanner = new Scanner(System.in).useLocale(Locale.US);
    }

    // Lê uma string
    public String lerString(String mensagem) {
        System.out.print(mensagem + " ");
        return scanner.nextLine().trim();
    }

    // Lê um inteiro entre min e max
    public int lerInt(String mensagem, int min, int max) {
        int valor;
        while (true) {
            System.out.print(mensagem + " ");
            try {
                valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor < min || valor > max) {
                    System.out.println("Digite um número entre " + min + " e " + max);
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
        return valor;
    }

    // Lê status do cliente
    public StatusCliente lerStatusCliente(String mensagem) {
        while (true) {
            System.out.println(mensagem + " (1 - ATIVO / 2 - INATIVO)");
            String input = scanner.nextLine().trim();
            try {
                int escolha = Integer.parseInt(input);
                return StatusCliente.fromInt(escolha);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas 1 ou 2.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Lê status do pedido
    public StatusPedido lerStatusPedido(String mensagem) {
        while (true) {
            System.out.println(mensagem + " (1 - PENDENTE / 2 - PAGO / 3 - CANCELADO)");
            String input = scanner.nextLine().trim();
            try {
                int escolha = Integer.parseInt(input);
                return StatusPedido.fromInt(escolha);
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas 1, 2 ou 3.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Lê número decimal
    public double lerDouble(String mensagem) {
        System.out.println(mensagem + " ");
        while (true){
            try{
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número:");
            }
        }
    }
}
