package br.com.fiap.aguiaexpressapi.dto;

import br.com.fiap.aguiaexpressapi.model.Armazem;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArmazemDTO {

    private Long armazemId;
    private String nome;
    private String endereco;
    private Integer capacidade;

    public ArmazemDTO() {
    }

    public ArmazemDTO(Armazem armazem){
        this.armazemId = armazem.getArmazemId();
        this.nome = armazem.getNome();
        this.endereco = armazem.getEndereco();
        this.capacidade = armazem.getCapacidade();
    }
}