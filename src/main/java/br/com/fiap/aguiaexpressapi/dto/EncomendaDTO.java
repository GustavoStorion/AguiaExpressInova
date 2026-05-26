package br.com.fiap.aguiaexpressapi.dto;

import br.com.fiap.aguiaexpressapi.model.Encomenda;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EncomendaDTO {

    private Long encomendaId;
    private String descricao;
    private Double peso;
    private String codigoRastreio;
    private Double valor;

    public EncomendaDTO() {
    }

    public EncomendaDTO(Encomenda encomenda){
        this.encomendaId = encomenda.getEncomendaId();
        this.descricao = encomenda.getDescricao();
        this.peso = encomenda.getPeso();
        this.codigoRastreio = encomenda.getCodigoRastreio();
        this.valor = encomenda.getValor();
    }
}