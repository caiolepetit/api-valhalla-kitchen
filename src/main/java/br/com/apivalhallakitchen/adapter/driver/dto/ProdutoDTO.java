package br.com.apivalhallakitchen.adapter.driver.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProdutoDTO {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
}