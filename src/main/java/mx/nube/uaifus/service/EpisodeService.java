package mx.nube.uaifus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Episode episode = episodeRepository.findById(id).get();
        return episode;
    }

    public List<Episode> getEpisodes(Integer idSeason) {
        Season ownSeason = seasonRepository.findById(idSeason).get();
        List<Episode> listEpisodes = episodeRepository.findByIdSeason(ownSeason);
        return listEpisodes;
    }

    public Episode saveEpisode(EpisodeRequest request) {
        Season ownSeason = seasonRepository.findById(request.getIdSeason()).get();
        Episode newEpisode = new Episode();
        newEpisode.setIdSeason(ownSeason);
        newEpisode.setDuration(request.getDuration());
        newEpisode.setNameEpisode(request.getNameEpisode());
        newEpisode.setUrlVideo(request.getUrlVideo());

        episodeRepository.save(newEpisode);

        return newEpisode;
    }

    public Episode modifyEpisode(EpisodeRequest request) {
        Episode oldEpisode = episodeRepository.findById(request.getIdEpisode()).get();
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