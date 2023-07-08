package br.com.apivalhallakitchen.core.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Cliente")
@Data
@Builder
@RequiredArgsConstructor
public class ClienteEntity {
    @Id
    @Column(name = "cpf")
    private Long cpf;

    @Column(name = "email")
    private String email;
}