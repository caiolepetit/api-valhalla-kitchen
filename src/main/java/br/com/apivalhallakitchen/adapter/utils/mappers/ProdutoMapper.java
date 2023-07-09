package br.com.apivalhallakitchen.adapter.utils.mappers;

import br.com.apivalhallakitchen.core.domain.Produto;
import br.com.apivalhallakitchen.adapter.driver.form.ProdutoForm;
import br.com.apivalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;

public class ProdutoMapper {

    private ProdutoMapper() {
        throw new IllegalStateException("Utility class");
    }

    public static ProdutoEntity produtoToEntity(Produto produto) {
        return ProdutoEntity.builder().nome(produto.getNome())
                                        .descricao(produto.getDescricao())
                                        .categoria(produto.getCategoria())
                                        .preco(produto.getPreco()).build();
    }

    public static Produto produtoEntityToProduto(ProdutoEntity produtoEntity) {
        return Produto.builder().id(produtoEntity.getId())
                                    .categoria(produtoEntity.getCategoria())
                                    .preco(produtoEntity.getPreco())
                                    .nome(produtoEntity.getNome())
                                    .status(produtoEntity.getStatus()).build();
    }

    public static Produto produtoFormToProduto(ProdutoForm produtoForm) {
        return Produto.builder().categoria(produtoForm.getCategoria())
                                    .descricao(produtoForm.getDescricao())
                                    .preco(produtoForm.getPreco())
                                    .nome(produtoForm.getNome()).build();
    }

}