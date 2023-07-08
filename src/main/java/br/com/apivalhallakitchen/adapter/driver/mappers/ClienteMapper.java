package br.com.apivalhallakitchen.adapter.driver.mappers;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;

public class ClienteMapper {
    public static ClienteEntity clienteFormToEntity(ClienteForm clienteForm) {
        return ClienteEntity.builder().cpf(clienteForm.getCpf()).email(clienteForm.getEmail()).build();
    }

    public static ClienteDTO clienteEntityToDto(ClienteEntity clienteEntity) {
        return ClienteDTO.builder().email(clienteEntity.getEmail()).cpf(clienteEntity.getCpf()).build();
    }
}