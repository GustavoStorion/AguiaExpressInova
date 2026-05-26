package br.com.fiap.aguiaexpressapi.service;

import br.com.fiap.aguiaexpressapi.dto.OperadorDTO;
import br.com.fiap.aguiaexpressapi.model.Operador;
import br.com.fiap.aguiaexpressapi.repository.OperadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperadorService {

    @Autowired
    private OperadorRepository operadorRepository;

    public Operador salvar(Operador operador){
        return operadorRepository.save(operador);
    }

    public List<OperadorDTO> listarTodos(){
        return operadorRepository
                .findAll()
                .stream()
                .map(OperadorDTO::new)
                .toList();
    }

    public OperadorDTO buscarPorId(Long id){

        Operador operador = operadorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Operador não encontrado"));

        return new OperadorDTO(operador);
    }

    public Operador atualizar(Long id, Operador operadorAtualizado){

        Operador operador = operadorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Operador não encontrado"));

        operador.setNome(operadorAtualizado.getNome());
        operador.setEmail(operadorAtualizado.getEmail());
        operador.setTelefone(operadorAtualizado.getTelefone());
        operador.setCargo(operadorAtualizado.getCargo());

        return operadorRepository.save(operador);
    }

    public void deletar(Long id){

        Operador operador = operadorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Operador não encontrado"));

        operadorRepository.delete(operador);
    }
}