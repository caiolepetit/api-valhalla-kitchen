package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "produto_generator", sequenceName = "produto_id_seq", allocationSize = 1)
public class ProdutoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "produto_generator")
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "preco")
    private BigDecimal preco;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "status")
    private String status;
}