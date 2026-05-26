package br.com.fiap.aguiaexpressapi.service;

import br.com.fiap.aguiaexpressapi.dto.ArmazemDTO;
import br.com.fiap.aguiaexpressapi.model.Armazem;
import br.com.fiap.aguiaexpressapi.repository.ArmazemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmazemService {

    @Autowired
    private ArmazemRepository armazemRepository;

    public Armazem save(Armazem armazem){
        return armazemRepository.save(armazem);
    }

    public List<ArmazemDTO> findAll(){

        return armazemRepository
                .findAll()
                .stream()
                .map(ArmazemDTO::new)
                .toList();
    }

    public ArmazemDTO findById(Long id){

        Armazem armazem = armazemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Armazem not found"));

        return new ArmazemDTO(armazem);
    }

    public Armazem update(Long id, Armazem armazemAtualizado){

        Armazem armazem = armazemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Armazem not found"));

        armazem.setNome(armazemAtualizado.getNome());
        armazem.setEndereco(armazemAtualizado.getEndereco());
        armazem.setCapacidade(armazemAtualizado.getCapacidade());

        return armazemRepository.save(armazem);
    }

    public void delete(Long id){

        Armazem armazem = armazemRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Armazem not found"));

        armazemRepository.delete(armazem);
    }
}