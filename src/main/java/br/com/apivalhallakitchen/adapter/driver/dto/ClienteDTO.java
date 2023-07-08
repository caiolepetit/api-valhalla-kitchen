package br.com.apivalhallakitchen.adapter.driver.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteDTO {

    private Long cpf;
    private String email;

}
