package mx.nube.uaifus.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Token;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.request.UsuarioRequest;
import mx.nube.uaifus.service.CredentialsService;

/**
 * CredentialsResource
 */
@RestController
@RequestMapping("/credentials")
public class CredentialsResource {
    final Logger LOG = LoggerFactory.getLogger(CredentialsResource.class);

    @Autowired
    private CredentialsService credentialsService;

    @GetMapping("/login")
    public ResponseEntity<Token> loginUser(@RequestBody UsuarioRequest request) {
        Token token = credentialsService.Login(request);
        LOG.info("Ha ingresado un usuario con el nombre: " + request.getUsuario() + ", usando el token: "
                + token.getToken());
        return ResponseEntity.status(HttpStatus.FOUND).body(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> saveUser(@RequestBody UsuarioRequest request) {
        Usuario user = credentialsService.saveUser(request);
        LOG.info("Se ha creado un registro de tipo Usuario con id: " + user.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}