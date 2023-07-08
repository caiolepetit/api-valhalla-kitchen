package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMappers;
import br.com.apivalhallakitchen.core.domain.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ClienteMappers clienteMappers;
    
    public List<ClienteDTO> buscaTodosClientes(){
        List<ClienteDTO> clientesDTO = new ArrayList<>();
        for (ClienteEntity cliente : clienteRepository.findAll()) {
            clientesDTO.add(clienteMappers.clienteEntityToDto(cliente));
        }
        return clientesDTO;
    }

    public ClienteDTO buscaClienteCpf(Long cpf){
        return ClienteDTO.builder().cpf("111111111111").email("odin@teste.com").build();
    }

    public ClienteDTO criarCliente(ClienteForm clienteForm){
        return ClienteDTO.builder()
                            .cpf(clienteForm.getCpf())
                            .email(clienteForm.getEmail())
                            .build();
    }

}
