package com.gustavo.orcamentosgrafica.service;

import com.gustavo.orcamentosgrafica.dto.PedidoCartaoRequest;
import com.gustavo.orcamentosgrafica.dto.PedidoCartaoResponse;
import com.gustavo.orcamentosgrafica.entity.Cartao;
import com.gustavo.orcamentosgrafica.entity.Cliente;
import com.gustavo.orcamentosgrafica.entity.PedidoCartao;
import com.gustavo.orcamentosgrafica.entity.StatusPedido;
import com.gustavo.orcamentosgrafica.exception.ArquivoInvalidoException;
import com.gustavo.orcamentosgrafica.repository.CartaoRepository;
import com.gustavo.orcamentosgrafica.repository.ClienteRepository;
import com.gustavo.orcamentosgrafica.repository.PedidoCartaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    private void validarArte(MultipartFile arte){
        if (arte == null || arte.isEmpty()) {
            throw new ArquivoInvalidoException("A arte é obrigatória!");
        }

        if (arte.getSize() > 10 * 1024 * 1024) {
            throw new ArquivoInvalidoException("A arte deve ter no máximo 10MB!");
        }

        String nomeArquivo = arte.getOriginalFilename();

        if (nomeArquivo == null || !nomeArquivo.toLowerCase().endsWith(".pdf")){
            throw new ArquivoInvalidoException("O arquivo deve estar no formato pdf");
        }

        String contentType = arte.getContentType();

        if (!"application/pdf".equals(contentType)){
            throw new ArquivoInvalidoException("O arquivo enviado não é um pdf válido!");
        }

    }

    public PedidoCartaoResponse criar(PedidoCartaoRequest request) {

        validarArte(request.getArte());

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ArquivoInvalidoException("Cliente não encontrado"));

        Cartao cartao = cartaoRepository.findById(request.getCartaoId())
                .orElseThrow(() -> new ArquivoInvalidoException("Cartão não encontrado"));

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
