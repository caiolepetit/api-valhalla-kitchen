package br.com.apivalhallakitchen.adapter.driver.mappers.impl;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMapper;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;

public class ClienteMappersImpl implements ClienteMapper {
    @Override
    public ClienteEntity clienteFormToEntity(ClienteForm clienteForm) {
        return ClienteEntity.builder().cpf(clienteForm.getCpf()).email(clienteForm.getEmail()).build();
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
