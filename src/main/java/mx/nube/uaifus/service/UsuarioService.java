package mx.nube.uaifus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.nube.uaifus.exception.RecursoNoEncontradoException;
import mx.nube.uaifus.exception.UsuarioExistenteException;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.repository.UsuarioRepository;
import mx.nube.uaifus.request.UsuarioRequest;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * UsuarioService
 */

@Service
public class UsuarioService {
    final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUser(UsuarioRequest request) {

        Usuario user = new Usuario();
        user.setUsuario(request.getUsuario());
        user.setPassword(request.getPassword());

        Usuario userTempo = usuarioRepository.findByUsuario(request.getUsuario());

        if (userTempo != null) {
            throw new UsuarioExistenteException(request.getUsuario());
        }

        usuarioRepository.save(user);
        return user;
    }

    public List<Usuario> getUsers() {
        List<Usuario> listUsers = new LinkedList<>();
        usuarioRepository.findAll().iterator().forEachRemaining(listUsers::add);
        return listUsers;
    }

    public Usuario getUserById(String id) {
        Usuario user = usuarioRepository.findById(id);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return user;
    }

    public Usuario getUser(UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario == null) {
            throw new RecursoNoEncontradoException(request.getUsuario());
        }

        return usuario;
    }

    public Usuario deleteUser(UsuarioRequest request) {
        Usuario usuario = getUser(request);
        usuarioRepository.delete(usuario);
        return usuario;
    }

}