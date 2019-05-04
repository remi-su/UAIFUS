
package mx.nube.uaifus.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.request.SerieRequest;
import mx.nube.uaifus.service.SerieService;

/**
 * SerieResource
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/serie")
public class SerieResource {

    final Logger LOG = LoggerFactory.getLogger(SerieResource.class);
    @Autowired
    private SerieService serieService;

    @GetMapping("/{id}")
    public ResponseEntity<Serie> getSerie(@PathVariable Integer id) {
        Serie serie = serieService.getSerie(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(serie);
    }

    @GetMapping("/genero/{genre}")
    public List<Serie> getSerieByGenre(@PathVariable String genre) {
        List<Serie> series = serieService.getSeriesByGenre(genre);
        return series;
    }

    @GetMapping("/findName/{name}")
    public ResponseEntity<List<Serie>> getSeriesByName(@PathVariable String name) {
        List<Serie> series = serieService.getSeriesByName(name);
        return ResponseEntity.status(HttpStatus.FOUND).body(series);
    }

    @GetMapping("findRate/{rate}")
    public ResponseEntity<List<Serie>> getSeriesByRate(@PathVariable Double rate) {
        List<Serie> series = serieService.getSerieByRate(rate);
        return ResponseEntity.status(HttpStatus.FOUND).body(series);
    }

    @GetMapping("")
    public List<Serie> getSeries() {
        List<Serie> listaSeries = serieService.getSeries();
        return listaSeries;
    }

    @PostMapping("")
    public ResponseEntity<Serie> saveSerie(@RequestBody SerieRequest request) {
        Serie nuevaSerie = serieService.saveSerie(request);
        LOG.info("Se ha registrado una nueva serie con id: " + nuevaSerie.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSerie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Serie> deleteSerie(@PathVariable Integer id) {
        Serie deletedSerie = serieService.deleteSerie(id);
        LOG.info("Se ha eliminado el registro de la serie con id: " + deletedSerie.getId());
        return ResponseEntity.ok().body(deletedSerie);
    }

    @PutMapping("")
    public ResponseEntity<Serie> modifySerie(@RequestBody SerieRequest request) {
        Serie serie = serieService.modifySerie(request);
        LOG.info("Se ha modificado la información de la serie con id: " + serie.getId());
        return ResponseEntity.ok().body(serie);
    }

    @PutMapping("/vote/{id}")
    public ResponseEntity<Serie> refreshVoteSerie(@PathVariable Integer id) {
        Serie serie = serieService.refreshVoting(id);
        LOG.info("Se ha actualizado la valoración de la serie con id: " + id);
        return ResponseEntity.ok().body(serie);
    }
}