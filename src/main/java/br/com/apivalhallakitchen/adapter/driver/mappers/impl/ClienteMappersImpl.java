package br.com.apivalhallakitchen.adapter.driver.mappers.impl;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMappers;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;

public class ClienteMappersImpl implements ClienteMappers {
    @Override
    public ClienteDTO clienteFormToDto(ClienteForm clienteForm) {
        return ClienteDTO.builder().cpf(clienteForm.getCpf()).email(clienteForm.getEmail()).build();
    }

    @Override
    public ClienteDTO clienteEntityToDto(ClienteEntity clienteEntity) {
        return ClienteDTO.builder().email(clienteEntity.getEmail()).cpf(clienteEntity.getCpf()).build();
    }

    @Override
    public ClienteEntity clienteDtoToEntity(ClienteDTO clienteDTO) {
        return ClienteEntity.builder().cpf(clienteDTO.getCpf()).email(clienteDTO.getEmail()).build();
    }
}
