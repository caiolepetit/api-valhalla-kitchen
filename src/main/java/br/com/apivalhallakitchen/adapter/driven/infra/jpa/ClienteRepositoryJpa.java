package br.com.apivalhallakitchen.adapter.driven.infra.jpa;

import br.com.apivalhallakitchen.core.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositoryJpa extends JpaRepository<ClienteEntity, Long> {
}