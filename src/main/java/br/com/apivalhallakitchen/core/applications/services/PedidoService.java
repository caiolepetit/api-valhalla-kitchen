package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.form.MLTransacaoForm;
import br.com.apivalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.apivalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.apivalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.apivalhallakitchen.core.domain.Pedido;
import br.com.apivalhallakitchen.core.domain.Produto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ProdutoService produtoService;

    public PedidoService(PedidoRepository pedidoRepository, ProdutoService produtoService) {
        this.pedidoRepository = pedidoRepository;
        this.produtoService = produtoService;
    }

    public List<Pedido> buscarTodosPedidos() {
        return pedidoRepository.buscarTodosPedidos();
    }

    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.buscarPedidoPorId(id);
    }

    public Pedido criarPedido(PedidoForm pedidoForm) {
       return pedidoRepository.salvarPedido(PedidoMapper.pedidoFormToPedido(pedidoForm));
    }

    public Optional<Pedido> alterarStatusPedido(Long id) {
        Optional<Pedido> pedido = pedidoRepository.buscarPedidoPorId(id);

        if (pedido.isPresent()) {
            Pedido pedidoAtualizado = atualizarParaProximoStatus(pedido.get(), pedido.get().getStatus());
            pedidoRepository.salvarPedido(pedidoAtualizado);

            return Optional.of(pedidoAtualizado);
        }
        return pedido;
    }

    private Pedido atualizarParaProximoStatus(Pedido pedido, String status) {
        switch (status) {
            case "Recebido" -> pedido.setStatus("Recebido");
            case "Em preparação" -> pedido.setStatus("Pronto");
            case "Pronto" -> pedido.setStatus("Retirado");
            case "Finalizado" -> pedido.setStatus("Finalizado");
            default -> throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return pedido;
    }


    public String consultarStatusPagamento(Long id) {
        return pedidoRepository.buscarPedidoPorId(id).get().getStatusPagamento();
    }

    public List<Pedido> consultarFila() {
        List<String> status = Arrays.asList("Pronto", "Em preparação", "Recebido");
        return pedidoRepository.buscarFilaPedidos(status);
    }

    public Pedido processarTransacaoPagamentoML(MLTransacaoForm mlTransacaoForm) {
        //implantar processamento
        return null;
    }

    public Pedido atualizarStatusPagamento(Pedido pedido, String status){
        switch (status) {
            case "state_FINISHED" -> pedido.setStatusPagamento("Aprovado");
            case "state_ERROR" -> pedido.setStatus("Reprovado");
            case "state_CANCELED" -> pedido.setStatus("Reprovado");
            default -> throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return pedido;
    }

}