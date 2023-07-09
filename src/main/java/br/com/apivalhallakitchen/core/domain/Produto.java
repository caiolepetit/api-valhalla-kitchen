package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Produto {
    private Long id;
    private String nome;
    private BigDecimal preco;
    private String descricao;
    private String categoria;

    @Builder.Default
    private String status = "A";
}