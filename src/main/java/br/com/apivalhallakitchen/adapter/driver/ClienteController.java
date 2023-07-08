package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import br.com.apivalhallakitchen.core.applications.services.ClienteService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class ClienteController {

    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listaTodosClientes() {
        return ResponseEntity.ok(clienteService.buscaTodosClientes());
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscaClientePorCpf(@PathVariable Long cpf) {
        ClienteDTO clienteDTO = clienteService.buscaClienteCpf(cpf);
        if (clienteDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteDTO);
    }

    @PostMapping
    public ResponseEntity<String> criaCliente(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        ClienteDTO clienteDTO = clienteService.criarCliente(clienteForm);
        if(clienteDTO == null) {
            return ResponseEntity.internalServerError().body("Não foi possível incluir o cliente");
        }
        String novaUri = uriBuilder.path("/{id}").buildAndExpand(clienteDTO.getCpf()).toUriString();
        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri())
                              .body("Usuário criado com sucesso!");
    }

}