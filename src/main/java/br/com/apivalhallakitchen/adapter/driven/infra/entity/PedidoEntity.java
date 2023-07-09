package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Pedido")
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
    private String status = "Novo";

//    @ManyToMany
//    @JoinTable(name = "pedido_produto",
//                        joinColumns = @JoinColumn(name = "produto_id"),
//                        inverseJoinColumns = @JoinColumn(name = "pedido_id"))
//    private List<ProdutoEntity> produtos;
}
