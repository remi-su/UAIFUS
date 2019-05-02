package mx.nube.uaifus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.nube.uaifus.exception.RecursoNoEncontradoException;
import mx.nube.uaifus.exception.UsuarioExistenteException;
import mx.nube.uaifus.model.Token;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.repository.UsuarioRepository;
import mx.nube.uaifus.request.UsuarioRequest;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
            LOG.error("Error ocasionado por una colisión entre registros.");
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

    public Usuario getUserById(Integer id) {
        Optional user = usuarioRepository.findById(id);

        if (!user.isPresent()) {
            LOG.error("Error ocasionado por la inexistencia de un registro");
            throw new RecursoNoEncontradoException("User id: " + id);
        }

        return (Usuario) user.get();
    }

    public Usuario getUser(UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario == null) {
            LOG.error("Error ocasionado por la inexistencia de un registro");
            throw new RecursoNoEncontradoException(request.getUsuario());
        }

        return usuario;
    }

    public Usuario deleteUser(Integer id) {
        Usuario usuario = getUserById(id);
        usuarioRepository.delete(usuario);
        return usuario;
    }

    public Usuario modifyUser(UsuarioRequest request) {
        Usuario user = new Usuario();
        user.setId(request.getId());
        user.setUsuario(request.getUsuario());
        user.setPassword(request.getPassword());

        Usuario userTempo = usuarioRepository.findByUsuario(request.getUsuario());

        if (userTempo != null) {
            LOG.error("Error ocasionado por la colisión existencial entre dos registros");
            throw new UsuarioExistenteException(request.getUsuario());
        }

        usuarioRepository.save(user);

        return user;
    }

    public Token Login(UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario == null) {
            LOG.error("Error ocasionado por la inexistencia de un registro");
            throw new RecursoNoEncontradoException(request.getUsuario());
        }

        if (usuario.getPassword().compareTo(request.getPassword()) != 0) {
            LOG.error("Error ocasionado por información mal proporcionada");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        String token = UUID.randomUUID().toString();
        usuario.setToken(token);
        usuarioRepository.save(usuario);

        Token tokenResponse = new Token();
        tokenResponse.setToken(token);

        return tokenResponse;
    }

}