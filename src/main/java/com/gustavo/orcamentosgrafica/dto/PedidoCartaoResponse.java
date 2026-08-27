package com.gustavo.orcamentosgrafica.dto;


import com.gustavo.orcamentosgrafica.entity.PedidoCartao;
import com.gustavo.orcamentosgrafica.entity.StatusPedido;

import java.math.BigDecimal;

public class PedidoCartaoResponse {

    private Long id;

    private Long clienteId;
    private String clienteName;
    private String clienteEmail;
    private String clienteTelefone;

    private String material;
    private Integer gramatura;
    private String impressao;
    private Integer quantidade;
    private BigDecimal preco;

    private String arteUrl;
    private StatusPedido status;

    public PedidoCartaoResponse() {
    }

    public PedidoCartaoResponse(
            Long id,
            Long clienteId,
            String clienteName,
            String clienteEmail,
            String clienteTelefone,
            String material,
            Integer gramatura,
            String impressao,
            Integer quantidade,
            BigDecimal preco,
            String arteUrl,
            StatusPedido status) {

        this.id = id;
        this.clienteId = clienteId;
        this.clienteName = clienteName;
        this.clienteEmail = clienteEmail;
        this.clienteTelefone = clienteTelefone;
        this.material = material;
        this.gramatura = gramatura;
        this.impressao = impressao;
        this.quantidade = quantidade;
        this.preco = preco;
        this.arteUrl = arteUrl;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getClienteName() {
        return clienteName;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public String getClienteTelefone() {
        return clienteTelefone;
    }

    public String getMaterial() {
        return material;
    }

    public Integer getGramatura() {
        return gramatura;
    }

    public String getImpressao() {
        return impressao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public String getArteUrl() {
        return arteUrl;
    }

    public StatusPedido getStatus() {
        return status;
    }
}