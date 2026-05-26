package br.com.fiap.aguiaexpressapi.repository;

import br.com.fiap.aguiaexpressapi.model.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository extends JpaRepository<Operador, Long> {
}
