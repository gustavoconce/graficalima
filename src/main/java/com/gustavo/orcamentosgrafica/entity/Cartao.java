package com.gustavo.orcamentosgrafica.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "cartoes", uniqueConstraints = {@UniqueConstraint(columnNames = {
        "material",
        "gramatura",
        "impressao",
        "quantidade"
})})
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String material;

    private Integer gramatura;

    private String impressao;

    private Integer quantidade;

    @Column(precision = 10, scale = 2)
    private BigDecimal preco;

    public Cartao(){

    }

    public Cartao(String material, Integer gramatura, String impressao, Integer quantidade, BigDecimal preco) {
        this.material = material;
        this.gramatura = gramatura;
        this.impressao = impressao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getGramatura() {
        return gramatura;
    }

    public void setGramatura(Integer gramatura) {
        this.gramatura = gramatura;
    }

    public String getImpressao() {
        return impressao;
    }

    public void setImpressao(String impressao) {
        this.impressao = impressao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
