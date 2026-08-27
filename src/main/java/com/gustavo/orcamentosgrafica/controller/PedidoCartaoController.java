package com.gustavo.orcamentosgrafica.controller;

import com.gustavo.orcamentosgrafica.dto.PedidoCartaoRequest;
import com.gustavo.orcamentosgrafica.dto.PedidoCartaoResponse;
import com.gustavo.orcamentosgrafica.entity.PedidoCartao;
import com.gustavo.orcamentosgrafica.service.PedidoCartaoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos/cartoes")
public class PedidoCartaoController {

    private final PedidoCartaoService pedidoCartaoService;

    public PedidoCartaoController(PedidoCartaoService pedidoCartaoService){
        this.pedidoCartaoService = pedidoCartaoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PedidoCartaoResponse criar(@RequestBody PedidoCartaoRequest request) {
        return pedidoCartaoService.criar(request);
    }

    @GetMapping
    public List<PedidoCartaoResponse> listar() {
        return pedidoCartaoService.listar();
    }

}
