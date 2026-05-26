package br.com.fiap.aguiaexpressapi.repository;

import br.com.fiap.aguiaexpressapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}