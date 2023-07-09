package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.apivalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.apivalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.apivalhallakitchen.core.domain.Pedido;
import io.micrometer.observation.ObservationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponse;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
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
            case "Novo" -> pedido.setStatus("Em preparação");
            case "Em preparação" -> pedido.setStatus("Pronto");
            case "Pronto" -> pedido.setStatus("Retirado");
            default -> throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE);
        }
        return pedido;
    }
}