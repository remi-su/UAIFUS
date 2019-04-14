package mx.nube.uaifus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.repository.SerieRepository;
import mx.nube.uaifus.request.SerieRequest;

import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * SerieService
 */
@Service
public class SerieService {
    final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private SerieRepository serieRepository;

    public Serie saveSerie(SerieRequest request) {
        Serie nuevaSerie = new Serie();
        nuevaSerie.setNameSerie(request.getName());
        nuevaSerie.setGenre(request.getGenre());
        nuevaSerie.setDescription(request.getDescripcion());
        nuevaSerie.setRate(request.getRate());

        serieRepository.save(nuevaSerie);

        return nuevaSerie;
    }

    public List<Serie> getSeries() {
        List<Serie> listaSeries = new LinkedList<>();
        serieRepository.findAll().iterator().forEachRemaining(listaSeries::add);
        return listaSeries;
    }

    public List<Serie> getSeriesByGenre(String genre) {
        List<Serie> listaSeries = new LinkedList<>();
        listaSeries = serieRepository.findByGenre(genre);
        return listaSeries;
    }

    public Serie getSerie(Integer id) {
        Serie findSerie = serieRepository.findById(id).get();

        if (findSerie == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return findSerie;
    }

    public Serie deleteSerie(Integer id) {
        Serie serieEliminada = getSerie(id);
        serieRepository.delete(serieEliminada);
        return serieEliminada;
    }

    public Serie modifySerie(SerieRequest request) {
        Serie modifiedSerie = new Serie();
        modifiedSerie.setId(request.getId());
        modifiedSerie.setNameSerie(request.getName());
        modifiedSerie.setGenre(request.getGenre());
        modifiedSerie.setDescription(request.getDescripcion());
        modifiedSerie.setRate(request.getRate());

        serieRepository.save(modifiedSerie);

        return modifiedSerie;
    }
}