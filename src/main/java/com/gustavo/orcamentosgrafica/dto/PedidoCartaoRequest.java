package com.gustavo.orcamentosgrafica.dto;

import org.springframework.web.multipart.MultipartFile;

public class PedidoCartaoRequest {

    private Long clienteId;

    private Long cartaoId;

    private MultipartFile arte;

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

    public MultipartFile getArte() {
        return arte;
    }

    public void setArte(MultipartFile arte) {
        this.arte = arte;
    }
}
