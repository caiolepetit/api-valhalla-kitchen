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
@RequiredArgsConstructor
public class ClienteService {

    private ClienteRepository clienteRepository;
    private ClienteMapper clienteMapper;
    
    public List<ClienteDTO> buscaTodosClientes(){
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (ClienteEntity cliente : clienteRepository.findAll()) {
            clientesDTO.add(clienteMapper.clienteEntityToDto(cliente));
        }
        return clientesDTO;
    }

    public ClienteDTO buscaClienteCpf(Long cpf){
        return clienteRepository.findById(cpf).map(entity -> clienteMapper.clienteEntityToDto(entity)).orElse(null);
    }

    public ClienteDTO criarCliente(ClienteForm clienteForm){
        try {
            ClienteEntity clienteEntitySaved = clienteRepository.save(clienteMapper.clienteFormToEntity(clienteForm));

            return clienteMapper.clienteEntityToDto(clienteEntitySaved);
        } catch (Exception e) {
            return null;
        }
    }

}
