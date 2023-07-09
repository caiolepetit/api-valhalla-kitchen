package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Pedido")
@Data
public class PedidoEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "clienteId")
    private Long clienteId;

    @Column(name = "status")
    private String status;
}
