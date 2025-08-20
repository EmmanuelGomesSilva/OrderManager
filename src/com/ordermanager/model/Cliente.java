package com.ordermanager.model;

import com.ordermanager.enums.StatusCliente;

// Representa um cliente
public class Cliente {
    private int id;
    private String nome;
    private String email;
    private String telefone;
    private StatusCliente status;

    public Cliente(int id, String nome, String email, String telefone, StatusCliente status) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.status = status;
    }

    public Cliente() {}

    // getters e setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public StatusCliente getStatus() { return status; }
    public void setStatus(StatusCliente status) { this.status = status; }

    // mostra os dados do cliente de forma simples
    @Override
    public String toString() {
        return "ID: " + id +
                " | Nome: " + nome +
                " | Email: " + email +
                " | Telefone: " + telefone +
                " | Status: " + status;
    }
}
