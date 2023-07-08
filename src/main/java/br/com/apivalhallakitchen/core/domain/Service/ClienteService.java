package br.com.apivalhallakitchen.core.domain.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.applications.ports.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private  ClienteRepository clienteRepository;
    
    public ClienteDTO buscaTodosClientes(){
        return ClienteDTO.builder().cpf("111111111111").email("odin@teste.com").build();
    }

    public ClienteDTO buscaClienteCpf(String cpf){
        return ClienteDTO.builder().cpf("111111111111").email("odin@teste.com").build();
    }

    public ClienteDTO criarCliente(ClienteForm clienteForm){
        return ClienteDTO.builder()
                            .cpf(clienteForm.getCpf())
                            .email(clienteForm.getEmail())
                            .build();
    }

}
