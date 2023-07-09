package br.com.apivalhallakitchen.adapter.driven.infra;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.ClienteEntity;
import br.com.apivalhallakitchen.adapter.driven.infra.jpa.ClienteRepositoryJpa;
import br.com.apivalhallakitchen.core.domain.Cliente;
import br.com.apivalhallakitchen.adapter.utils.mappers.ClienteMapper;
import br.com.apivalhallakitchen.core.applications.ports.ClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {
    private final ClienteRepositoryJpa clienteRepositoryJpa;

    public ClienteRepositoryImpl(ClienteRepositoryJpa clienteRepositoryJpa) {
        this.clienteRepositoryJpa = clienteRepositoryJpa;
    }

    @Override
    public Optional<Cliente> buscarClientePorCpf(Long cpf) {
        return clienteRepositoryJpa.findById(cpf).map(ClienteMapper::clienteEntityToCliente);
    }

    @Override
    public List<Cliente> buscarTodosClientes() {
        List<Cliente> clientesDTO = new ArrayList<>();
        for (ClienteEntity cliente : clienteRepositoryJpa.findAll()) {
            clientesDTO.add(ClienteMapper.clienteEntityToCliente(cliente));
        }
        return clientesDTO;
    }

    @Override
    public Cliente criarCliente(Cliente cliente) {
        ClienteEntity clienteEntity = clienteRepositoryJpa.save(ClienteMapper.clienteToEntity(cliente));
        return ClienteMapper.clienteEntityToCliente(clienteEntity);
    }
}