package br.com.apivalhallakitchen.adapter.driven.infra.jpa;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepositoryJpa extends JpaRepository<ProdutoEntity, Long> {
    List<ProdutoEntity> findAllByCategoria(String categoria);
}