package mx.nube.uaifus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nube.uaifus.exception.RecursoNoEncontradoException;
import mx.nube.uaifus.model.Episode;
import mx.nube.uaifus.model.Season;
import mx.nube.uaifus.repository.EpisodeRepository;
import mx.nube.uaifus.repository.SeasonRepository;
import mx.nube.uaifus.request.EpisodeRequest;

/**
 * EpisodeService
 */

@Service
public class EpisodeService {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public Episode getEpisode(Integer id) {
        Optional episode = episodeRepository.findById(id);

        if (!episode.isPresent()) {
            throw new RecursoNoEncontradoException("Episode id = " + id);
        }

        return (Episode) episode.get();
    }

    public List<Episode> getEpisodes(Integer idSeason) {
        Optional ownSeason = seasonRepository.findById(idSeason);

        if (!ownSeason.isPresent()) {
            throw new RecursoNoEncontradoException("Season id = " + idSeason);
        }

        Season season = (Season) ownSeason.get();

        List<Episode> listEpisodes = episodeRepository.findByIdSeason(season);
        return listEpisodes;
    }

    public Episode saveEpisode(EpisodeRequest request) {
        Optional ownSeason = seasonRepository.findById(request.getIdSeason());

        if (!ownSeason.isPresent()) {
            throw new RecursoNoEncontradoException("Season id = " + request.getIdSeason());
        }

        Season season = (Season) ownSeason.get();

        Episode newEpisode = new Episode();
        newEpisode.setIdSeason(season);
        newEpisode.setDuration(request.getDuration());
        newEpisode.setNameEpisode(request.getNameEpisode());
        newEpisode.setUrlVideo(request.getUrlVideo());

        episodeRepository.save(newEpisode);

        return newEpisode;
    }

    public Episode modifyEpisode(EpisodeRequest request) {
        Optional episode = episodeRepository.findById(request.getIdEpisode());

        if (!episode.isPresent()) {
            throw new RecursoNoEncontradoException("Episode id = " + request.getIdEpisode());
        }

        Episode oldEpisode = (Episode) episode.get();

        oldEpisode.setDuration(request.getDuration());
        oldEpisode.setNameEpisode(request.getNameEpisode());
        oldEpisode.setUrlVideo(request.getUrlVideo());

        episodeRepository.save(oldEpisode);

        return oldEpisode;
    }

    public Episode deleteEpisode(Integer id) {
        Episode byeEpisode = getEpisode(id);
        episodeRepository.delete(byeEpisode);
        return byeEpisode;
    }

}