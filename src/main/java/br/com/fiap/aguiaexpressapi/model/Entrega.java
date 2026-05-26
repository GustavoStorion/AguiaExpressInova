package br.com.fiap.aguiaexpressapi.model;

import br.com.fiap.aguiaexpressapi.model.enums.NivelUrgencia;
import br.com.fiap.aguiaexpressapi.model.enums.StatusEntrega;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_entregas")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entregaId;

    @NotBlank
    private String nomeDestinatario;

    @NotBlank
    private String enderecoEntrega;

    @Enumerated(EnumType.STRING)
    private StatusEntrega statusEntrega;

    @Enumerated(EnumType.STRING)
    private NivelUrgencia nivelUrgencia;

    @ManyToOne
    @JsonIgnoreProperties("entregas")
    private Operador operador;
}