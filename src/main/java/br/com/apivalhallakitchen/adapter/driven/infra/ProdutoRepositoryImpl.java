package br.com.apivalhallakitchen.adapter.driven.infra;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import br.com.apivalhallakitchen.adapter.driven.infra.jpa.ProdutoRepositoryJpa;
import br.com.apivalhallakitchen.adapter.utils.mappers.ProdutoMapper;
import br.com.apivalhallakitchen.core.applications.ports.ProdutoRepository;
import br.com.apivalhallakitchen.core.domain.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final ProdutoRepositoryJpa produtoRepositoryJpa;

    public ProdutoRepositoryImpl(ProdutoRepositoryJpa produtoRepositoryJpa) {
        this.produtoRepositoryJpa = produtoRepositoryJpa;
    }

    @Override
    public List<Produto> buscarTodosProdutos() {
        return converterListEntityToListDto(produtoRepositoryJpa.findAll());
    }

    @Override
    public List<Produto> buscarTodosProdutosPorCategoria(String categoria) {
        return converterListEntityToListDto(produtoRepositoryJpa.findAllByCategoria(categoria));
    }

    private List<Produto> converterListEntityToListDto(List<ProdutoEntity> produtoEntities) {
        List<Produto> produtos = new ArrayList<>();

        for (ProdutoEntity produto : produtoEntities) {
            produtos.add(ProdutoMapper.produtoEntityToProduto(produto));
        }
        return produtos;
    }

    @Override
    public Optional<Produto> buscarProdutoPorId(Long id) {
        return produtoRepositoryJpa.findById(id).map(ProdutoMapper::produtoEntityToProduto);
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        ProdutoEntity produtoEntity = produtoRepositoryJpa.save(ProdutoMapper.produtoToEntity(produto));
        return ProdutoMapper.produtoEntityToProduto(produtoEntity);
    }
}