package br.com.fiap.aguiaexpressapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_encomendas")
public class Encomenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long encomendaId;

    @NotBlank
    private String descricao;

    private Double peso;

    @NotBlank
    private String codigoRastreio;

    private Double valor;
}