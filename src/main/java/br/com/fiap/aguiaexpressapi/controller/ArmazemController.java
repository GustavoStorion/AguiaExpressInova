package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.dto.ArmazemDTO;
import br.com.fiap.aguiaexpressapi.model.Armazem;
import br.com.fiap.aguiaexpressapi.service.ArmazemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armazens")
@Tag(
        name = "Armazéns",
        description = "Endpoints para gerenciamento de armazéns"
)
public class ArmazemController {

    @Autowired
    private ArmazemService armazemService;

    @PostMapping
    @Operation(summary = "Cadastrar novo armazém")
    public ResponseEntity<Armazem> save(@RequestBody @Valid Armazem armazem){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(armazemService.save(armazem));
    }

    @GetMapping
    @Operation(summary = "Listar todos os armazéns")
    public ResponseEntity<List<ArmazemDTO>> findAll(){

        return ResponseEntity.ok(armazemService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar armazém por ID")
    public ResponseEntity<ArmazemDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(armazemService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar armazém")
    public ResponseEntity<Armazem> update(
            @PathVariable Long id,
            @RequestBody Armazem armazem){

        return ResponseEntity.ok(armazemService.update(id, armazem));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar armazém")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        armazemService.delete(id);

        return ResponseEntity.noContent().build();
    }
}