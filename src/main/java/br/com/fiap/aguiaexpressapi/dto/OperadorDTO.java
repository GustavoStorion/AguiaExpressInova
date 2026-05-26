package br.com.fiap.aguiaexpressapi.dto;

import br.com.fiap.aguiaexpressapi.model.Operador;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperadorDTO {

    private Long operadorId;
    private String nome;
    private String email;
    private String telefone;
    private String cargo;

    public OperadorDTO() {
    }

    public OperadorDTO(Operador operador){
        this.operadorId = operador.getOperadorId();
        this.nome = operador.getNome();
        this.email = operador.getEmail();
        this.telefone = operador.getTelefone();
        this.cargo = operador.getCargo();
    }
}