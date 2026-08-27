package com.gustavo.orcamentosgrafica.controller;

import com.gustavo.orcamentosgrafica.entity.Cartao;
import com.gustavo.orcamentosgrafica.repository.CartaoRepository;
import com.gustavo.orcamentosgrafica.service.CartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cartoes")
public class CartaoController {

    private final CartaoService cartaoService;

    public CartaoController(CartaoService cartaoService){
        this.cartaoService = cartaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cartao criar(@RequestBody Cartao cartao){
        return cartaoService.criar(cartao);
    }

    @GetMapping
    public List<Cartao> listar(){
        return cartaoService.listar();
    }

    @GetMapping("/buscar")
    public List<Cartao> buscarPorConfiguracao(@RequestParam String material, @RequestParam Integer gramatura, @RequestParam String impressao){
        return cartaoService.buscarPorConfiguracao(material, gramatura, impressao);
    }

}
