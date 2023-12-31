package br.com.apivalhallakitchen.adapter.driven.infra;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.apivalhallakitchen.adapter.driven.infra.jpa.PedidoRepositoryJpa;
import br.com.apivalhallakitchen.adapter.utils.mappers.PedidoMapper;
import br.com.apivalhallakitchen.core.applications.ports.PedidoRepository;
import br.com.apivalhallakitchen.core.domain.Pedido;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class PedidoRepositoryImpl implements PedidoRepository {

    private final PedidoRepositoryJpa pedidoRepositoryJpa;

    public PedidoRepositoryImpl(PedidoRepositoryJpa pedidoRepositoryJpa) {
        this.pedidoRepositoryJpa = pedidoRepositoryJpa;
    }

    @Override
    public List<Pedido> buscarTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoEntity pedido : pedidoRepositoryJpa.findAll()) {
            pedidos.add(PedidoMapper.pedidoEntityToPedido(pedido));
        }

        return pedidos;
    }

    @Override
    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepositoryJpa.findById(id).map(PedidoMapper::pedidoEntityToPedido);
    }

    @Override
    public Pedido salvarPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = pedidoRepositoryJpa.save(PedidoMapper.pedidoToEntity(pedido));
        return PedidoMapper.pedidoEntityToPedido(pedidoEntity);
    }

    @Override
    public List<Pedido> buscarFilaPedidos(List<String> status) {
        List<Pedido> pedidos = new ArrayList<>();

        for (PedidoEntity pedido : pedidoRepositoryJpa.findByStatusIn(status)) {
            pedidos.add(PedidoMapper.pedidoEntityToPedido(pedido));
        }
        pedidos.sort(Comparator.comparing(pedido -> {
            String statusPedido = pedido.getStatus();
            if (statusPedido.equals("Pronto")) {
                return 1;
            } else if (statusPedido.equals("Em preparação")) {
                return 2;
            } else if (statusPedido.equals("Recebido")) {
                return 3;
            } else {
                return 4; // Para outros status não especificados
            }
        }));
        return pedidos;
    }
}