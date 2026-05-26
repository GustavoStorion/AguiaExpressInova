package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.dto.EntregaDTO;
import br.com.fiap.aguiaexpressapi.model.Entrega;
import br.com.fiap.aguiaexpressapi.service.EntregaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entregas")
@Tag(
        name = "Entregas",
        description = "Endpoints para gerenciamento de entregas"
)
public class EntregaController {

    @Autowired
    private EntregaService entregaService;

    @PostMapping
    @Operation(summary = "Cadastrar nova entrega")
    public ResponseEntity<Entrega> salvar(@Valid @RequestBody Entrega entrega){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(entregaService.salvar(entrega));
    }

    @GetMapping
    @Operation(summary = "Listar todas as entregas")
    public ResponseEntity<List<EntregaDTO>> listarTodas(){
        return ResponseEntity.ok(entregaService.listarTodas());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar entrega por ID")
    public ResponseEntity<EntregaDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(entregaService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar entrega")
    public ResponseEntity<Entrega> atualizar(
            @PathVariable Long id,
            @RequestBody Entrega entrega){

        return ResponseEntity.ok(entregaService.atualizar(id, entrega));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar entrega")
    public ResponseEntity<Void> deletar(@PathVariable Long id){

        entregaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}