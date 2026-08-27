package com.gustavo.orcamentosgrafica.service;

import com.gustavo.orcamentosgrafica.dto.PedidoCartaoRequest;
import com.gustavo.orcamentosgrafica.dto.PedidoCartaoResponse;
import com.gustavo.orcamentosgrafica.entity.Cartao;
import com.gustavo.orcamentosgrafica.entity.Cliente;
import com.gustavo.orcamentosgrafica.entity.PedidoCartao;
import com.gustavo.orcamentosgrafica.entity.StatusPedido;
import com.gustavo.orcamentosgrafica.repository.CartaoRepository;
import com.gustavo.orcamentosgrafica.repository.ClienteRepository;
import com.gustavo.orcamentosgrafica.repository.PedidoCartaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoCartaoService {

    private final PedidoCartaoRepository pedidoCartaoRepository;
    private final ClienteRepository clienteRepository;
    private final CartaoRepository cartaoRepository;

    public PedidoCartaoService(
            PedidoCartaoRepository pedidoCartaoRepository,
            ClienteRepository clienteRepository,
            CartaoRepository cartaoRepository) {

        this.pedidoCartaoRepository = pedidoCartaoRepository;
        this.clienteRepository = clienteRepository;
        this.cartaoRepository = cartaoRepository;
    }

    public PedidoCartaoResponse criar(PedidoCartaoRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Cartao cartao = cartaoRepository.findById(request.getCartaoId())
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));

        PedidoCartao pedido = new PedidoCartao(cartao, cliente,null, StatusPedido.PENDENTE
                );

        PedidoCartao pedidoSalvo = pedidoCartaoRepository.save(pedido);

        return converterParaResponse(pedidoSalvo);
    }

    public List<PedidoCartaoResponse> listar() {

        return pedidoCartaoRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    private PedidoCartaoResponse converterParaResponse(PedidoCartao pedido) {

        return new PedidoCartaoResponse(
                pedido.getId(),
                pedido.getCliente().getId(),
                pedido.getCliente().getName(),
                pedido.getCliente().getEmail(),
                pedido.getCliente().getTelefone(),
                pedido.getCartao().getMaterial(),
                pedido.getCartao().getGramatura(),
                pedido.getCartao().getImpressao(),
                pedido.getCartao().getQuantidade(),
                pedido.getCartao().getPreco(),
                pedido.getArteUrl(),
                pedido.getStatus()
        );
    }

}
