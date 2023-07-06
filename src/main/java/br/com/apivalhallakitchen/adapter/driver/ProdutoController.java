package br.com.apivalhallakitchen.adapter.driver;

import br.com.apivalhallakitchen.adapter.driver.dto.ProdutoDTO;
import br.com.apivalhallakitchen.adapter.driver.form.ProdutoForm;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<List<ProdutoDTO>> listarTodosProdutos(@RequestParam (required = false) String categoria) {
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

    @PostMapping
    public ResponseEntity<String> criarProduto(@RequestBody ProdutoForm produtoForm, UriComponentsBuilder uriBuilder) {
        ProdutoDTO pelosOlhosDeOdin = ProdutoDTO.builder()
                .id(1L)
                .descricao(produtoForm.getDescricao())
                .preco(produtoForm.getPreco())
                .nome(produtoForm.getNome()).build();

        String novaUri = uriBuilder.path("/{id}").buildAndExpand(pelosOlhosDeOdin.getId()).toUriString();

        return ResponseEntity.created(UriComponentsBuilder.fromUriString(novaUri).build().toUri())
                .body("Produto criado com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoDTO> editarProdutoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(this.buscaProdutoPorId(id).getBody());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> inativaProduto(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}