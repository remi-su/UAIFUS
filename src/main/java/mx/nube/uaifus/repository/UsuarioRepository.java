package mx.nube.uaifus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public Usuario findByUsuario(String usuario);

    public Usuario findByToken(String token);
}