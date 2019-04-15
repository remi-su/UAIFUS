
package mx.nube.uaifus.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nube.uaifus.exception.RecursoNoEncontradoException;
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
        Optional seasonTempo = seasonRepository.findById(id);

        if (!seasonTempo.isPresent()) {
            throw new RecursoNoEncontradoException("Season id: " + id);
        }
        return (Season) seasonTempo.get();
    }

    public List<Season> getSeasons(Integer idSerie) {
        Optional ownSerie = serieRepository.findById(idSerie);

        if (!ownSerie.isPresent()) {
            throw new RecursoNoEncontradoException("Serie id: " + idSerie);
        }

        List<Season> listSeason = seasonRepository.findByIdSerie((Serie) ownSerie.get());
        return listSeason;
    }

    public Season saveSeason(SeasonRequest request) {
        Optional ownSerie = serieRepository.findById(request.getIdSerie());

        if (!ownSerie.isPresent()) {
            throw new RecursoNoEncontradoException("Serie id: " + request.getIdSerie());
        }

        Season newSeason = new Season();
        newSeason.setIdSerie((Serie) ownSerie.get());
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
        Optional season = seasonRepository.findById(request.getIdSeason());
        if (!season.isPresent()) {
            throw new RecursoNoEncontradoException("Season id: " + request.getIdSeason());
        }
        Season changeSeason = (Season) season.get();
        changeSeason.setName(request.getName());
        changeSeason.setRate(request.getRate());

        seasonRepository.save(changeSeason);

        return changeSeason;
    }
}