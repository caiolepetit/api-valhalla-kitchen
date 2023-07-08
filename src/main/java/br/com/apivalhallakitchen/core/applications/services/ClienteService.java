package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMapper;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.applications.ports.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> buscaTodosClientes(){
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (ClienteEntity cliente : clienteRepository.findAll()) {
            clientesDTO.add(ClienteMapper.clienteEntityToDto(cliente));
        }
        return clientesDTO;
    }

    public ClienteDTO buscaClienteCpf(Long cpf){
        return clienteRepository.findById(cpf).map(ClienteMapper::clienteEntityToDto).orElse(null);
    }

    public ClienteDTO criarCliente(ClienteForm clienteForm){
        try {
            ClienteEntity clienteEntitySaved = clienteRepository.save(ClienteMapper.clienteFormToEntity(clienteForm));

            return ClienteMapper.clienteEntityToDto(clienteEntitySaved);
        } catch (Exception e) {
            return null;
        }
    }

}
