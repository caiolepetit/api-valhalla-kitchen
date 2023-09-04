package br.com.apivalhallakitchen.adapter.driven.infra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "email")
    private String email;

}