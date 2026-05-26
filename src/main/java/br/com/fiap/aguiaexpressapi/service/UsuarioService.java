package br.com.fiap.aguiaexpressapi.service;

import br.com.fiap.aguiaexpressapi.dto.UsuarioDTO;
import br.com.fiap.aguiaexpressapi.model.Usuario;
import br.com.fiap.aguiaexpressapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDTO> findAll(){

        return usuarioRepository
                .findAll()
                .stream()
                .map(UsuarioDTO::new)
                .toList();
    }

    public UsuarioDTO findById(Long id){

        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));

        return new UsuarioDTO(usuario);
    }

    public Usuario update(Long id, Usuario usuarioAtualizado){

        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setSenha(usuarioAtualizado.getSenha());
        usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());

        return usuarioRepository.save(usuario);
    }

    public void delete(Long id){

        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario not found"));

        usuarioRepository.delete(usuario);
    }
}
