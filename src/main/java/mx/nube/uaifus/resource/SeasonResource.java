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

import mx.nube.uaifus.model.Season;
import mx.nube.uaifus.request.SeasonRequest;
import mx.nube.uaifus.request.VoteRequest;
import mx.nube.uaifus.service.SeasonService;

/**
 * SeasonResource
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/season")
public class SeasonResource {

    final Logger LOG = LoggerFactory.getLogger(SeasonResource.class);

    @Autowired
    private SeasonService seasonService;

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeason(@PathVariable Integer id) {
        Season season = seasonService.getSeason(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(season);
    }

    @GetMapping("/serie/{id}")
    public List<Season> getSeasons(@PathVariable Integer id) {
        List<Season> listSeasons = seasonService.getSeasons(id);
        return listSeasons;
    }

    @PostMapping("")
    public ResponseEntity<Season> saveSeason(@RequestBody SeasonRequest request) {
        Season newSeason = seasonService.saveSeason(request);
        LOG.info("Se ha creado un registro de tipo Season con id: " + newSeason.getIdSeason());
        return ResponseEntity.status(HttpStatus.CREATED).body(newSeason);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Season> deleteSeason(@PathVariable Integer id) {
        Season easerSeason = seasonService.deleteSeason(id);
        LOG.info("Se ha eliminado un registro de tipo Season con id: " + easerSeason.getIdSeason());
        return ResponseEntity.ok().body(easerSeason);
    }

    @PutMapping("")
    public ResponseEntity<Season> modifySeason(@RequestBody SeasonRequest request) {
        Season oldSeason = seasonService.modifySeason(request);
        LOG.info("Se ha modificado la información de una temporada con id: " + oldSeason.getIdSeason());
        return ResponseEntity.ok().body(oldSeason);
    }

    @PutMapping("/vote")
    public ResponseEntity<Season> voteSeason(@RequestBody VoteRequest request) {
        Season season = seasonService.refreshVote(request);
        LOG.info("Se ha registrado un nuevo voto para la temporada con id: " + season.getIdSeason());
        return ResponseEntity.ok().body(season);

    }
}