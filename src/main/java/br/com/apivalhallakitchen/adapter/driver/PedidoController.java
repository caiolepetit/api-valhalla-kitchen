package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.adapter.driver.dto.PedidoDTO;
import br.com.apivalhallakitchen.adapter.driver.form.PedidoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> buscarTodosPedidos() {
        PedidoDTO pedidoDTO = PedidoDTO.builder().id(1L).nomeCliente("Caio").build();

        return ResponseEntity.ok(Collections.singletonList(pedidoDTO));
    }

    @PostMapping
    public ResponseEntity<String> criarPedido(@RequestBody PedidoForm pedidoForm, UriComponentsBuilder uriBuilder) {
        PedidoDTO pedidoDTO = PedidoDTO.builder().id(1L).build();

        String novaUri = uriBuilder.path("/{id}").buildAndExpand(pedidoDTO.getId()).toUriString();

        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri())
                .body("Pedito criado com sucesso!");
    }

}