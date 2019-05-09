package mx.nube.uaifus.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Token;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.request.UsuarioRequest;
import mx.nube.uaifus.service.UsuarioService;
import java.util.List;

/**
 * UserResource
 */

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserResource {

    final Logger LOG = LoggerFactory.getLogger(UserResource.class);
    @Autowired
    private UsuarioService userService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUser(@PathVariable Integer id) {

        Usuario usuario = userService.getUserById(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(usuario);
    }

    @GetMapping("")
    public List<Usuario> getUser() {

        List<Usuario> usuario = userService.getUsers();

        return usuario;
    }

    @PutMapping("")
    public ResponseEntity<Usuario> modifyUser(@RequestBody UsuarioRequest request) {
        Usuario user = userService.modifyUser(request);
        LOG.info("Se ha modificado la información de un Usuario con id: " + user.getId());
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        Usuario user = userService.deleteUser(id);
        LOG.info("Se ha eliminado un usuario con id: " + user.getId());
        return ResponseEntity.ok().body("Eliminado");
    }

}