
package mx.nube.uaifus.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("")
    public List<Serie> getSeries() {
        List<Serie> listaSeries = serieService.getSeries();
        return listaSeries;
    }

    @PostMapping("")
    public ResponseEntity<Serie> saveSerie(@RequestBody SerieRequest request) {
        Serie nuevaSerie = serieService.saveSerie(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaSerie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Serie> deleteSerie(@PathVariable Integer id) {
        Serie deletedSerie = serieService.deleteSerie(id);
        return ResponseEntity.ok().body(deletedSerie);
    }

    @PutMapping("")
    public ResponseEntity<Serie> modifySerie(@RequestBody SerieRequest request) {
        Serie serie = serieService.modifySerie(request);
        return ResponseEntity.ok().body(serie);
    }
}