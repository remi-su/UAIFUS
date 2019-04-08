package mx.nube.uaifus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Season;

/**
 * SeasonRepository
 */
@Repository
public interface SeasonRepository extends CrudRepository<Season, Integer> {

}