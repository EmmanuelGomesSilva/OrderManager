package com.ordermanager.enums;

// Status do cliente
public enum StatusCliente {
    ATIVO,
    INATIVO;

    // Converte número em StatusCliente
    public static StatusCliente fromInt(int escolha) {
        switch (escolha) {
            case 1: return ATIVO;
            case 2: return INATIVO;
            default: throw new IllegalArgumentException("Escolha inválida! Digite 1 ou 2.");
        }
    }
}
