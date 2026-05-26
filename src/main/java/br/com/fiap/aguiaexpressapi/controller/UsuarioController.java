package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.dto.UsuarioDTO;
import br.com.fiap.aguiaexpressapi.model.Usuario;
import br.com.fiap.aguiaexpressapi.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
@Tag(
        name = "Usuarios",
        description = "Endpoints para gerenciamento de usuários"
)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastrar novo usuário")
    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody @Valid Usuario usuario){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usuarioService.save(usuario));
    }

    @Operation(summary = "Listar todos os usuários")
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> findAll(){

        return ResponseEntity.ok(usuarioService.findAll());
    }

    @Operation(summary = "Buscar usuário por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @Operation(summary = "Atualizar usuário")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(
            @PathVariable Long id,
            @RequestBody Usuario usuario){

        return ResponseEntity.ok(usuarioService.update(id, usuario));
    }

    @Operation(summary = "Deletar usuário")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        usuarioService.delete(id);

        return ResponseEntity.noContent().build();
    }
}