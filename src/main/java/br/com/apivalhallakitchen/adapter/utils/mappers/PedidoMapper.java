package br.com.apivalhallakitchen.adapter.utils.mappers;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.apivalhallakitchen.adapter.driver.form.PedidoForm;
import br.com.apivalhallakitchen.core.domain.Pedido;

public class PedidoMapper {
    private PedidoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static PedidoEntity pedidoToEntity(Pedido pedido) {
        return PedidoEntity.builder().clienteId(pedido.getClienteId())
                                        .status(pedido.getStatus())
                                        .statusPagamento(pedido.getStatusPagamento())
                                        .id(pedido.getId())
                                        .produtos(pedido.getProdutos()).build();
    }

    public static Pedido pedidoEntityToPedido(PedidoEntity pedidoEntity) {
        return Pedido.builder().id(pedidoEntity.getId())
                                .clienteId(pedidoEntity.getClienteId())
                                .status(pedidoEntity.getStatus())
                                .statusPagamento(pedidoEntity.getStatusPagamento())
                                .produtos(pedidoEntity.getProdutos()).build();
    }

    public static Pedido pedidoFormToPedido(PedidoForm pedidoForm) {
        return Pedido.builder().clienteId(pedidoForm.getClienteId()).produtos(pedidoForm.getProdutosId()).build();
    }


}