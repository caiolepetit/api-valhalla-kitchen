package br.com.apivalhallakitchen.adapter.driver.mappers;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;

public interface ClienteMappers {
    ClienteDTO clienteFormToDto(ClienteForm clienteForm);

    ClienteDTO clienteEntityToDto(ClienteEntity clienteEntity);

    ClienteEntity clienteDtoToEntity(ClienteDTO clienteDTO);
}