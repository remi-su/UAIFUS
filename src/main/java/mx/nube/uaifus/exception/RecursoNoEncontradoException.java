package mx.nube.uaifus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RecursoNoEncontradoException
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecursoNoEncontradoException extends RuntimeException {
    public RecursoNoEncontradoException(String recurso) {
        super("El recurso " + recurso + " no fue encontrado.");
    }
}