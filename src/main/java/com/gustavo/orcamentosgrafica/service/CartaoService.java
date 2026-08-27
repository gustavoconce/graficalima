package com.gustavo.orcamentosgrafica.service;

import com.gustavo.orcamentosgrafica.entity.Cartao;
import com.gustavo.orcamentosgrafica.repository.CartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepository cartaoRepository;

    public CartaoService(CartaoRepository cartaoRepository){
        this.cartaoRepository = cartaoRepository;
    }

    public Cartao criar(Cartao cartao){
        return cartaoRepository.save(cartao);
    }

    public List<Cartao> listar() {
        return cartaoRepository.findAll();
    }

}
