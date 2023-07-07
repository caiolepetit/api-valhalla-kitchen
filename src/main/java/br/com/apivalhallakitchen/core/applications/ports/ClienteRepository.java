package br.com.apivalhallakitchen.core.applications.ports;

import br.com.apivalhallakitchen.core.domain.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Long, ClienteEntity> {
}