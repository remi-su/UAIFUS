package mx.nube.uaifus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UsuarioExistenteException extends RuntimeException {

    public UsuarioExistenteException(String usuario) {
        super("El Usuario" + usuario + " ya existe");
    }
}