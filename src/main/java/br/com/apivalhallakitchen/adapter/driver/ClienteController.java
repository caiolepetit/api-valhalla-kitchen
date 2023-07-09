package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.core.domain.Cliente;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.applications.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listaTodosClientes() {
        return ResponseEntity.ok(clienteService.buscaTodosClientes());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Cliente> buscaClientePorCpf(@PathVariable Long cpf) {
        return clienteService.buscaClienteCpf(cpf).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> criaCliente(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        Cliente cliente = clienteService.criarCliente(clienteForm);
        String novaUri = uriBuilder.path("/{id}").buildAndExpand(cliente.getCpf()).toUriString();
        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri())
                              .body("Usuário criado com sucesso!");
    }

}