package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {

    private String cpf;
    private String email;

}
