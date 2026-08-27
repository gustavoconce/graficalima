package com.gustavo.orcamentosgrafica.entity;

import jakarta.persistence.*;

@Entity
public class PedidoCartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cartao_id", nullable = false)
    private Cartao cartao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private String arteUrl;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public PedidoCartao() {

    }

    public PedidoCartao(Cartao cartao, Cliente cliente, String arteUrl, StatusPedido status) {
        this.cartao = cartao;
        this.cliente = cliente;
        this.arteUrl = arteUrl;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getArteUrl() {
        return arteUrl;
    }

    public void setArteUrl(String arteUrl) {
        this.arteUrl = arteUrl;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }
}
