package br.com.fiap.aguiaexpressapi.dto;

import br.com.fiap.aguiaexpressapi.model.enums.NivelUrgencia;
import br.com.fiap.aguiaexpressapi.model.enums.StatusEntrega;
import br.com.fiap.aguiaexpressapi.model.Entrega;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntregaDTO {

    private Long entregaId;

    private String nomeDestinatario;

    private String enderecoEntrega;

    private StatusEntrega statusEntrega;

    private NivelUrgencia nivelUrgencia;

    public EntregaDTO() {
    }

    public EntregaDTO(Entrega entrega){
        this.entregaId = entrega.getEntregaId();
        this.nomeDestinatario = entrega.getNomeDestinatario();
        this.enderecoEntrega = entrega.getEnderecoEntrega();
        this.statusEntrega = entrega.getStatusEntrega();
        this.nivelUrgencia = entrega.getNivelUrgencia();
    }
}