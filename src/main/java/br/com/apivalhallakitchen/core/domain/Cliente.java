package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class Cliente {
    private UUID id;
    private String cpf;
    private String email;

}
