package br.com.apivalhallakitchen.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cliente {

    private Long cpf;
    private String email;

}
