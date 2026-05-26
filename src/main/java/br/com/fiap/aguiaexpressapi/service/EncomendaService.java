package br.com.fiap.aguiaexpressapi.service;

import br.com.fiap.aguiaexpressapi.dto.EncomendaDTO;
import br.com.fiap.aguiaexpressapi.model.Encomenda;
import br.com.fiap.aguiaexpressapi.repository.EncomendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncomendaService {

    @Autowired
    private EncomendaRepository encomendaRepository;

    public Encomenda save(Encomenda encomenda){
        return encomendaRepository.save(encomenda);
    }

    public List<EncomendaDTO> findAll(){

        return encomendaRepository
                .findAll()
                .stream()
                .map(EncomendaDTO::new)
                .toList();
    }

    public EncomendaDTO findById(Long id){

        Encomenda encomenda = encomendaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Encomenda not found"));

        return new EncomendaDTO(encomenda);
    }

    public Encomenda update(Long id, Encomenda encomendaAtualizada){

        Encomenda encomenda = encomendaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Encomenda not found"));

        encomenda.setDescricao(encomendaAtualizada.getDescricao());
        encomenda.setPeso(encomendaAtualizada.getPeso());
        encomenda.setCodigoRastreio(encomendaAtualizada.getCodigoRastreio());
        encomenda.setValor(encomendaAtualizada.getValor());

        return encomendaRepository.save(encomenda);
    }

    public void delete(Long id){

        Encomenda encomenda = encomendaRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Encomenda not found"));

        encomendaRepository.delete(encomenda);
    }
}