package com.ordermanager.enums;

// Status do pedido
public enum StatusPedido {
    PENDENTE,
    PAGO,
    CANCELADO;

    // Converte número em StatusPedido
    public static StatusPedido fromInt(int escolha) {
        switch (escolha) {
            case 1: return PENDENTE;
            case 2: return PAGO;
            case 3: return CANCELADO;
            default: throw new IllegalArgumentException("Escolha inválida! Digite 1, 2 ou 3.");
        }
    }
}
