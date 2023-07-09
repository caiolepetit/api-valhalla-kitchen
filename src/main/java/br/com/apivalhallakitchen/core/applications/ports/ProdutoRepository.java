package br.com.apivalhallakitchen.core.applications.ports;

import br.com.apivalhallakitchen.core.domain.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    List<Produto> buscarTodosProdutos();

    List<Produto> buscarTodosProdutosPorCategoria(String categoria);

    Optional<Produto> buscarProdutoPorId(Long id);

    Produto salvarProduto(Produto produto);
}