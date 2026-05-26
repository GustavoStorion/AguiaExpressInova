package br.com.fiap.aguiaexpressapi.controller;

import br.com.fiap.aguiaexpressapi.repository.EntregaRepository;
import br.com.fiap.aguiaexpressapi.repository.OperadorRepository;
import br.com.fiap.aguiaexpressapi.model.enums.NivelUrgencia;
import br.com.fiap.aguiaexpressapi.model.enums.StatusEntrega;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Tag(
        name = "Dashboard",
        description = "Endpoints de métricas e indicadores logísticos"
)
public class DashboardController {

    @Autowired
    private EntregaRepository entregaRepository;

    @Autowired
    private OperadorRepository operadorRepository;

    @GetMapping("/dashboard/metricas")
    @Operation(summary = "Exibir métricas do dashboard")
    public Map<String, Object> metricas(){

        Map<String, Object> dados = new HashMap<>();

        long totalEntregas = entregaRepository.count();

        long entregasConcluidas = entregaRepository
                .findAll()
                .stream()
                .filter(e -> e.getStatusEntrega() == StatusEntrega.ENTREGUE)
                .count();

        long entregasUrgentes = entregaRepository
                .findAll()
                .stream()
                .filter(e -> e.getNivelUrgencia() == NivelUrgencia.ULTRA_URGENTE)
                .count();

        long totalOperadores = operadorRepository.count();

        dados.put("totalEntregas", totalEntregas);
        dados.put("entregasConcluidas", entregasConcluidas);
        dados.put("entregasUrgentes", entregasUrgentes);
        dados.put("totalOperadores", totalOperadores);

        return dados;
    }
}