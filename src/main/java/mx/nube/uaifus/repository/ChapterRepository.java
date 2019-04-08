package mx.nube.uaifus.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.nube.uaifus.model.Episode;

/**
 * ChapterRepository
 */
@Repository
public interface ChapterRepository extends CrudRepository<Episode, Integer> {

}