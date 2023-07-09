package br.com.apivalhallakitchen.core.applications.ports;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Optional<ClienteDTO> buscarClientePorCpf(Long cpf);
    List<ClienteDTO> buscarTodosClientes();
    ClienteDTO criarCliente(ClienteDTO clienteDTO);
}