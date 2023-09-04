package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class Pedido {
    private Long id;
    private UUID clienteId;

    @Builder.Default
    private String status = "Recebido";
    private List<Long> produtos;
    @Builder.Default
    private String statusPagamento = "Aguardando";
}