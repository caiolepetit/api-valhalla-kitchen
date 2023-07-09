package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.core.domain.Cliente;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.adapter.utils.mappers.ClienteMapper;
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

    public List<Cliente> buscaTodosClientes(){
        return clienteRepository.buscarTodosClientes();
    }

    public Optional<Cliente> buscaClienteCpf(Long cpf){
        return clienteRepository.buscarClientePorCpf(cpf);
    }

    public Cliente criarCliente(ClienteForm clienteForm){
        return clienteRepository.criarCliente(ClienteMapper.clienteFormToCliente(clienteForm));
    }

}
