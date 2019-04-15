package mx.nube.uaifus.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Episode;
import mx.nube.uaifus.model.Season;

/**
 * ChapterRepository
 */
@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Integer> {
    public List<Episode> findByIdSeason(Season idSeason);
}