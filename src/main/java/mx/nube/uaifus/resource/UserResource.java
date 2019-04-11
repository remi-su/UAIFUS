package mx.nube.uaifus.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.request.UsuarioRequest;
import mx.nube.uaifus.service.UsuarioService;
import java.util.List;

/**
 * UserResource
 */

@RestController
@RequestMapping("/user")
public class UserResource {

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
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("")
    public ResponseEntity<Usuario> saveUser(@RequestBody UsuarioRequest request) {
        Usuario user = userService.saveUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUser(@PathVariable Integer id) {
        Usuario user = userService.deleteUser(id);
        return ResponseEntity.ok().body(user);
    }
}