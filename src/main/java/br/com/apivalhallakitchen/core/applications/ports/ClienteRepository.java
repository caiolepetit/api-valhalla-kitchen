package br.com.apivalhallakitchen.core.applications.ports;

import br.com.apivalhallakitchen.core.domain.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository {
    Optional<Cliente> buscarClientePorCpf(Long cpf);
    List<Cliente> buscarTodosClientes();
    Cliente criarCliente(Cliente cliente);
}