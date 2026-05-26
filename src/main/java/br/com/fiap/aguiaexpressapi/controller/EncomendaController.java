package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.dto.EncomendaDTO;
import br.com.fiap.aguiaexpressapi.model.Encomenda;
import br.com.fiap.aguiaexpressapi.service.EncomendaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/encomendas")
@Tag(
        name = "Encomendas",
        description = "Endpoints para gerenciamento de encomendas"
)
public class EncomendaController {

    @Autowired
    private EncomendaService encomendaService;

    @PostMapping
    @Operation(summary = "Cadastrar nova encomenda")
    public ResponseEntity<Encomenda> save(@RequestBody @Valid Encomenda encomenda){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(encomendaService.save(encomenda));
    }

    @GetMapping
    @Operation(summary = "Listar todas as encomendas")
    public ResponseEntity<List<EncomendaDTO>> findAll(){

        return ResponseEntity.ok(encomendaService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar encomenda por ID")
    public ResponseEntity<EncomendaDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok(encomendaService.findById(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar encomenda")
    public ResponseEntity<Encomenda> update(
            @PathVariable Long id,
            @RequestBody Encomenda encomenda){

        return ResponseEntity.ok(encomendaService.update(id, encomenda));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar encomenda")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        encomendaService.delete(id);

        return ResponseEntity.noContent().build();
    }
}