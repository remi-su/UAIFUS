package mx.nube.uaifus.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Season;
import mx.nube.uaifus.model.Serie;

/**
 * SeasonRepository
 */
@Repository
public interface SeasonRepository extends CrudRepository<Season, Integer> {
    public List<Season> findByIdSerie(Serie idSerie);
}