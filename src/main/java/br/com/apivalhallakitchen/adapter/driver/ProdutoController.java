package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.adapter.driver.dto.ProdutoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodosProdutos() {
        ProdutoDTO pelosOlhosDeOdin = ProdutoDTO.builder()
                .id(1L)
                .descricao("Este é o primeiro lanche que fez Odin abrir mão de um olho!")
                .preco(new BigDecimal("20"))
                .nome("Pelos olhos de Odin").build();

        return ResponseEntity.ok(Collections.singletonList(pelosOlhosDeOdin));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDTO> buscaProdutoPorId(@PathVariable Long id) {
        ProdutoDTO pelosOlhosDeOdin = ProdutoDTO.builder()
                .id(1L)
                .descricao("Este é o primeiro lanche que fez Odin abrir mão de um olho!")
                .preco(new BigDecimal("20"))
                .nome("Pelos olhos de Odin").build();

        return ResponseEntity.ok(pelosOlhosDeOdin);
    }


}
