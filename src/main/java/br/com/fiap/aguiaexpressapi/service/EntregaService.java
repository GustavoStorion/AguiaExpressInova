package br.com.fiap.aguiaexpressapi.service;

import br.com.fiap.aguiaexpressapi.dto.EntregaDTO;
import br.com.fiap.aguiaexpressapi.exception.EntregaNaoEncontradaException;
import br.com.fiap.aguiaexpressapi.model.Entrega;
import br.com.fiap.aguiaexpressapi.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Entrega salvar(Entrega entrega){
        return entregaRepository.save(entrega);
    }

    public List<EntregaDTO> listarTodas(){
        return entregaRepository
                .findAll()
                .stream()
                .map(EntregaDTO::new)
                .toList();
    }

    public EntregaDTO buscarPorId(Long id){

        Entrega entrega = entregaRepository
                .findById(id)
                .orElseThrow(() -> new EntregaNaoEncontradaException("Entrega não encontrada"));

        return new EntregaDTO(entrega);
    }

    public Entrega atualizar(Long id, Entrega entregaAtualizada){

        Entrega entrega = entregaRepository
                .findById(id)
                .orElseThrow(() -> new EntregaNaoEncontradaException("Entrega não encontrada"));

        entrega.setNomeDestinatario(entregaAtualizada.getNomeDestinatario());
        entrega.setEnderecoEntrega(entregaAtualizada.getEnderecoEntrega());
        entrega.setStatusEntrega(entregaAtualizada.getStatusEntrega());
        entrega.setNivelUrgencia(entregaAtualizada.getNivelUrgencia());

        return entregaRepository.save(entrega);
    }

    public void deletar(Long id){

        Entrega entrega = entregaRepository
                .findById(id)
                .orElseThrow(() -> new EntregaNaoEncontradaException("Entrega não encontrada"));

        entregaRepository.delete(entrega);
    }

}