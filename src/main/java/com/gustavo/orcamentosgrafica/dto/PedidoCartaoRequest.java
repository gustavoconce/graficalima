package com.gustavo.orcamentosgrafica.dto;

public class PedidoCartaoRequest {

    private Long clienteId;

    private Long cartaoId;

    public PedidoCartaoRequest() {
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public Long getCartaoId() {
        return cartaoId;
    }

    public void setCartaoId(Long cartaoId) {
        this.cartaoId = cartaoId;
    }

}
