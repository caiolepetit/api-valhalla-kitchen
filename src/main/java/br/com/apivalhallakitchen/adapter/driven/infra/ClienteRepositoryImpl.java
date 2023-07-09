package br.com.apivalhallakitchen.adapter.driven.infra;

import br.com.apivalhallakitchen.adapter.driven.infra.jpa.ClienteRepositoryJpa;
import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMapper;
import br.com.apivalhallakitchen.core.applications.ports.ClienteRepository;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;
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
    public Optional<ClienteDTO> buscarClientePorCpf(Long cpf) {
        return clienteRepositoryJpa.findById(cpf).map(ClienteMapper::clienteEntityToDto);
    }

    @Override
    public List<ClienteDTO> buscarTodosClientes() {
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (ClienteEntity cliente : clienteRepositoryJpa.findAll()) {
            clientesDTO.add(ClienteMapper.clienteEntityToDto(cliente));
        }
        return clientesDTO;
    }

    @Override
    public ClienteDTO criarCliente(ClienteDTO clienteDTO) {
        ClienteEntity clienteEntity = clienteRepositoryJpa.save(ClienteMapper.clienteDtoToEntity(clienteDTO));
        return ClienteMapper.clienteEntityToDto(clienteEntity);
    }
}