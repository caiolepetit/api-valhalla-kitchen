package br.com.apivalhallakitchen.adapter.driver.mappers;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;

public class ClienteMapper {

    private ClienteMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static ClienteEntity clienteDtoToEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder().cpf(clienteDTO.getCpf()).email(clienteDTO.getEmail()).build();
    }

    public static ClienteDTO clienteEntityToDto(ClienteEntity clienteEntity) {
        return ClienteDTO.builder().email(clienteEntity.getEmail()).cpf(clienteEntity.getCpf()).build();
    }

    public static ClienteDTO clienteFormToDto(ClienteForm clienteForm) {
        return ClienteDTO.builder().cpf(clienteForm.getCpf()).email(clienteForm.getEmail()).build();
    }
}