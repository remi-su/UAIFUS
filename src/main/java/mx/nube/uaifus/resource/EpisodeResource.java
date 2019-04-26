package mx.nube.uaifus.resource;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourceRegion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Episode;
import mx.nube.uaifus.request.EpisodeRequest;
import mx.nube.uaifus.service.EpisodeService;

/**
 * EpisodeResource
 */
@RestController
@RequestMapping("episode")
public class EpisodeResource {

    @Autowired
    private EpisodeService episodeService;

    @GetMapping("/{id}")
    public ResponseEntity<Episode> getEpisode(@PathVariable Integer id) {
        Episode episode = episodeService.getEpisode(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(episode);
    }

    @GetMapping("/season/{id}")
    public List<Episode> getEpisodes(@PathVariable Integer id) {
        List<Episode> listEpisodes = episodeService.getEpisodes(id);
        return listEpisodes;
    }

    @PostMapping("")
    public ResponseEntity<Episode> saveEpisode(@RequestBody EpisodeRequest request) {
        Episode newEpisode = episodeService.saveEpisode(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEpisode);
    }

    @PutMapping("")
    public ResponseEntity<Episode> modifyEpisode(@RequestBody EpisodeRequest request) {
        Episode oldEpisode = episodeService.modifyEpisode(request);
        return ResponseEntity.status(HttpStatus.OK).body(oldEpisode);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Episode> deleteEpisode(@PathVariable Integer id) {
        Episode byeEpisode = episodeService.deleteEpisode(id);
        return ResponseEntity.status(HttpStatus.OK).body(byeEpisode);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<UrlResource> getVideoCompleto(@PathVariable Integer id) throws MalformedURLException {
        UrlResource url = episodeService.getVideoCompleto(id);
        return ResponseEntity.ok()
                .contentType(MediaTypeFactory.getMediaType(url).orElse(MediaType.APPLICATION_OCTET_STREAM)).body(url);
    }
    /*
     * @GetMapping("/view/{id}") public ResponseEntity<ResourceRegion>
     * getVideoParte(@PathVariable Integer id, @RequestHeader HttpHeaders headers)
     * throws IOException { List<Object> lista = episodeService.getVideoPartes(id,
     * headers); ResourceRegion url = (ResourceRegion) lista.get(0); UrlResource
     * video = (UrlResource) lista.get(1); return
     * ResponseEntity.status(HttpStatus.PARTIAL_CONTENT)
     * .contentType(MediaTypeFactory.getMediaType(video).orElse(MediaType.
     * APPLICATION_OCTET_STREAM)).body(url); }
     */

}