package com.ordermanager.model;

import com.ordermanager.enums.StatusPedido;

import java.time.LocalDate;

// Representa um pedido feito por um cliente
public class Pedido {
    private int id;
    private int clienteId;
    private LocalDate data;
    private double valor;
    private StatusPedido status;

    public Pedido(int id, int clienteId, LocalDate data, double valor, StatusPedido status) {
        this.id = id;
        this.clienteId = clienteId;
        this.data = data;
        this.valor = valor;
        this.status = status;
    }

    public Pedido() {}

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public StatusPedido getStatus() { return status; }
    public void setStatus(StatusPedido status) { this.status = status; }

    // mostra os dados do pedido de forma simples
    @Override
    public String toString() {
        return "ID: " + id +
                " | Cliente ID: " + clienteId +
                " | Data: " + data +
                " | Valor: " + valor +
                " | Status: " + status;
    }
}
