
package mx.nube.uaifus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nube.uaifus.model.Season;
import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.repository.SeasonRepository;
import mx.nube.uaifus.repository.SerieRepository;
import mx.nube.uaifus.request.SeasonRequest;

/**
 * SeasonService
 */
@Service
public class SeasonService {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private SerieRepository serieRepository;

    public Season getSeason(Integer id) {
        Season seasonTempo = seasonRepository.findById(id).get();
        return seasonTempo;
    }

    public List<Season> getSeasons(Integer idSerie) {
        Serie ownSerie = serieRepository.findById(idSerie).get();
        List<Season> listSeason = seasonRepository.findByIdSerie(ownSerie);
        return listSeason;
    }

    public Season saveSeason(SeasonRequest request) {
        Serie ownSerie = serieRepository.findById(request.getIdSerie()).get();
        Season newSeason = new Season();
        newSeason.setIdSerie(ownSerie);
        newSeason.setName(request.getName());
        newSeason.setRate(request.getRate());

        seasonRepository.save(newSeason);

        return newSeason;
    }

    public Season deleteSeason(Integer id) {
        Season oldSeason = getSeason(id);
        seasonRepository.delete(oldSeason);
        return oldSeason;
    }

    public Season modifySeason(SeasonRequest request) {
        Season changeSeason = new Season();
        changeSeason.setIdSeason(request.getIdSeason());
        changeSeason.setName(request.getName());
        changeSeason.setRate(request.getRate());

        seasonRepository.save(changeSeason);

        return changeSeason;
    }
}