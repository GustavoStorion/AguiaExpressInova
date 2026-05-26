package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.dto.OperadorDTO;
import br.com.fiap.aguiaexpressapi.model.Operador;
import br.com.fiap.aguiaexpressapi.service.OperadorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operadores")
@Tag(
        name = "Operadores",
        description = "Endpoints para gerenciamento de operadores logísticos"
)
public class OperadorController {

    @Autowired
    private OperadorService operadorService;

    @PostMapping
    @Operation(summary = "Cadastrar novo operador")
    public ResponseEntity<Operador> salvar(@RequestBody @Valid Operador operador){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(operadorService.salvar(operador));
    }

    @GetMapping
    @Operation(summary = "Listar todos os operadores")
    public ResponseEntity<List<OperadorDTO>> listarTodos(){

        return ResponseEntity.ok(operadorService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar operador por ID")
    public ResponseEntity<OperadorDTO> buscarPorId(@PathVariable Long id){

        return ResponseEntity.ok(operadorService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar operador")
    public ResponseEntity<Operador> atualizar(
            @PathVariable Long id,
            @RequestBody Operador operador){

        return ResponseEntity.ok(operadorService.atualizar(id, operador));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar operador")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        operadorService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}