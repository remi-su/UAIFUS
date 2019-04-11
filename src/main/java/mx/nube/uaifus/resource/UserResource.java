package mx.nube.uaifus.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.request.UsuarioRequest;
import mx.nube.uaifus.service.UsuarioService;

/**
 * UserResource
 */
@RestController
public class UserResource {

    @Autowired
    private UsuarioService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<Usuario> getUser(@RequestBody UsuarioRequest request) {
        Usuario usuario = usuarioRepository.findByUsuario(request.getUsuario());

        if (usuario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.FOUND).body(usuario);
    }

}