package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "clienteId")
    private Long clienteId;

    @Column(name = "status")
    @Builder.Default
    private String status = "Novo";

    @ElementCollection
    @CollectionTable(name = "pedido_produto",
            joinColumns = @JoinColumn(name = "pedido_id"))
    @Column(name = "produto_id")
    private List<Long> produtos;
}
