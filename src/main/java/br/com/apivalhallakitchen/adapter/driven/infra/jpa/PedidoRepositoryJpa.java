package br.com.apivalhallakitchen.adapter.driven.infra.jpa;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import br.com.apivalhallakitchen.core.domain.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepositoryJpa extends JpaRepository<PedidoEntity, Long> {

    List<Pedido> findByStatusInOrderByStatusDesc(List<String> status);

}