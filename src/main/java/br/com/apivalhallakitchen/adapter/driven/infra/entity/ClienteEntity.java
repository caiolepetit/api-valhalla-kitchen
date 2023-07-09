package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {
    @Id
    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "email")
    private String email;

}