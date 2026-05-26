package br.com.fiap.aguiaexpressapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tbl_armazens")
public class Armazem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long armazemId;

    @NotBlank
    private String nome;

    @NotBlank
    private String endereco;

    private Integer capacidade;
}