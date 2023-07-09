package br.com.apivalhallakitchen.core.applications.services;

import br.com.apivalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.apivalhallakitchen.adapter.utils.mappers.ProdutoMapper;
import br.com.apivalhallakitchen.core.applications.ports.ProdutoRepository;
import br.com.apivalhallakitchen.core.domain.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> buscarTodosProdutos() {
        return produtoRepository.buscarTodosProdutos();
    }

    public List<Produto> buscarTodosProdutosPorCategoria(String categoria) {
        return produtoRepository.buscarTodosProdutosPorCategoria(categoria);
    }

    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepository.buscarProdutoPorId(id);
    }

    public Produto criarProduto(ProdutoForm produtoForm) {
        return produtoRepository.salvarProduto(ProdutoMapper.produtoFormToProduto(produtoForm));
    }

    public Optional<Produto> editarProdutoPorId(Long id, ProdutoForm produtoForm) {
        Optional<Produto> produtoDTO = produtoRepository.buscarProdutoPorId(id);

        if(produtoDTO.isPresent()) {
            Produto produtoAtualizado = ProdutoMapper.produtoFormToProduto(produtoForm);
            produtoAtualizado.setId(id);

            produtoRepository.salvarProduto(produtoAtualizado);
        }

        return produtoDTO;
    }

    public Optional<Produto> inativarProduto(Long id) {
        Optional<Produto> produtoDTO = produtoRepository.buscarProdutoPorId(id);

        if (produtoDTO.isPresent()) {
            Produto produtoAtualizado = produtoDTO.get();
            produtoAtualizado.setStatus("I");

            produtoRepository.salvarProduto(produtoAtualizado);

            return Optional.of(produtoAtualizado);
        }

        return produtoDTO;
    }
}