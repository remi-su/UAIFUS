package mx.nube.uaifus.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import mx.nube.uaifus.service.SeasonService;

/**
 * SeasonResource
 */
@RestController
@RequestMapping("/season")
public class SeasonResource {

    @Autowired
    private SeasonService seasonService;

    @GetMapping("/{id}")
    public ResponseEntity<Season> getSeason(@PathVariable Integer id) {
        Season season = seasonService.getSeason(id);
        return ResponseEntity.ok().body(season);
    }

    @GetMapping("/Serie/{id}")
    public List<Season> getSeasons(@PathVariable Integer id) {
        List<Season> listSeasons = seasonService.getSeasons(id);
        return listSeasons;
    }

    @PostMapping("")
    public ResponseEntity<Season> saveSeason(@RequestBody SeasonRequest request) {
        Season newSeason = seasonService.saveSeason(request);
        return ResponseEntity.ok().body(newSeason);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Season> deleteSeason(@PathVariable Integer id) {
        Season easerSeason = seasonService.deleteSeason(id);
        return ResponseEntity.ok().body(easerSeason);
    }

    @PutMapping("")
    public ResponseEntity<Season> modifySeason(@RequestBody SeasonRequest request) {
        Season oldSeason = seasonService.modifySeason(request);
        return ResponseEntity.ok().body(oldSeason);
    }
}