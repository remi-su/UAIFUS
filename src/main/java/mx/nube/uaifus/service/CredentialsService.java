package mx.nube.uaifus.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

/**
 * CredentialsService
 */
@Service
public class CredentialsService {

    final Logger LOG = LoggerFactory.getLogger(CredentialsService.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

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
}