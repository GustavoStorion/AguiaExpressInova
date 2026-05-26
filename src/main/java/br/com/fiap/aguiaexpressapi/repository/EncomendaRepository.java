package br.com.fiap.aguiaexpressapi.repository;

import br.com.fiap.aguiaexpressapi.model.Encomenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EncomendaRepository extends JpaRepository<Encomenda, Long> {
}