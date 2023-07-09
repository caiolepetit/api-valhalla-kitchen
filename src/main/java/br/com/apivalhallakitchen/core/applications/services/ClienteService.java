package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.adapter.driver.mappers.ClienteMapper;
import br.com.apivalhallakitchen.core.applications.ports.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteDTO> buscaTodosClientes(){
        return clienteRepository.buscarTodosClientes();
    }

    public Optional<ClienteDTO> buscaClienteCpf(Long cpf){
        return clienteRepository.buscarClientePorCpf(cpf);
    }

    public ClienteDTO criarCliente(ClienteForm clienteForm){
        return clienteRepository.criarCliente(ClienteMapper.clienteFormToDto(clienteForm));
    }

}
