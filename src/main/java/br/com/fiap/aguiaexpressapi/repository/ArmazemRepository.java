package br.com.fiap.aguiaexpressapi.repository;

import br.com.fiap.aguiaexpressapi.model.Armazem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmazemRepository extends JpaRepository<Armazem, Long> {
}