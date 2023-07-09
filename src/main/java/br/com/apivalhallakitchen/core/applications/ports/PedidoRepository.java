package br.com.apivalhallakitchen.core.applications.ports;

import br.com.apivalhallakitchen.adapter.driven.infra.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}