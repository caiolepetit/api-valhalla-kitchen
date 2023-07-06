package br.com.apivalhallakitchen.adapter.driver.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PedidoDTO {
    private Long id;
    private String nomeCliente;
    private List<ProdutoDTO> produtos;
}