package mx.nube.uaifus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Usuario;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    public Usuario findByUsuario(String usuario);

    public List<Usuario> findByToken(String token);

}