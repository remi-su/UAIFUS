package mx.nube.uaifus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Favourite;
import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.model.Favourite.FavouriteId;

/**
 * FavouriteRepository
 */
@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, Integer> {
    public List<Favourite> findByUsuario(Usuario usuario);

    public Favourite findById(FavouriteId id);
}