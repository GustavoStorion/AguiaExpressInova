package br.com.fiap.aguiaexpressapi.dto;

import br.com.fiap.aguiaexpressapi.model.Usuario;
import br.com.fiap.aguiaexpressapi.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {

    private Long usuarioId;
    private String nome;
    private String email;
    private TipoUsuario tipoUsuario;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario){
        this.usuarioId = usuario.getUsuarioId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.tipoUsuario = usuario.getTipoUsuario();
    }
}