package mx.nube.uaifus.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Serie;

/**
 * SerieRepository
 */
@Repository
public interface SerieRepository extends CrudRepository<Serie, Integer> {
    public List<Serie> findByGenre(String genre);
}