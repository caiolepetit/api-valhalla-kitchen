package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.adapter.driver.dto.ClienteDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ClienteForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/clientes")
public class ClienteController {

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> listaTodosClientes() {
        ClienteDTO cliente01 = ClienteDTO.builder().cpf("111111111111").email("odin@teste.com").build();
        return ResponseEntity.ok(Collections.singletonList(cliente01));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteDTO> buscaClientePorCpf(@PathVariable String cpf) {
        ClienteDTO cliente01 = ClienteDTO.builder()
                .cpf(cpf)
                .build();
        return ResponseEntity.ok(cliente01);
    }

    @PostMapping
    public ResponseEntity<String> criaCliente(@RequestBody ClienteForm clienteForm, UriComponentsBuilder uriBuilder) {
        ClienteDTO cliente01 = ClienteDTO.builder()
                                    .cpf(clienteForm.getCpf())
                                    .email(clienteForm.getEmail())
                                    .build();

        String novaUri = uriBuilder.path("/{id}").buildAndExpand(cliente01.getCpf()).toUriString();

        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri())
                              .body("Usuário criado com sucesso!");
    }

}