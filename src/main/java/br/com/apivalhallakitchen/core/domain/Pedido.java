package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Pedido {
    private Long id;
    private String nomeCliente;
    private List<Produto> produtos;
}