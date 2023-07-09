package br.com.apivalhallakitchen.adapter.utils.mappers;

import br.com.apivalhallakitchen.core.domain.Cliente;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.adapter.driven.infra.entity.ClienteEntity;

public class ClienteMapper {

    private ClienteMapper() {
        throw new IllegalStateException("Utility class");
    }
    public static ClienteEntity clienteToEntity(Cliente cliente) {
        return ClienteEntity.builder().cpf(cliente.getCpf()).email(cliente.getEmail()).build();
    }

    public static Cliente clienteEntityToCliente(ClienteEntity clienteEntity) {
        return Cliente.builder().email(clienteEntity.getEmail()).cpf(clienteEntity.getCpf()).build();
    }

    public static Cliente clienteFormToCliente(ClienteForm clienteForm) {
        return Cliente.builder().cpf(clienteForm.getCpf()).email(clienteForm.getEmail()).build();
    }
}