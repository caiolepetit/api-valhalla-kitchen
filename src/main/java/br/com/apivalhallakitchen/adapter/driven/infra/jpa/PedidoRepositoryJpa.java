package br.com.apivalhallakitchen.adapter.driven.infra.jpa;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {

    List<PedidoEntity> findByStatusIn(List<String> status);

}