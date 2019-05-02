package mx.nube.uaifus.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.nube.uaifus.model.Favourite;
import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.request.FavouriteRequest;
import mx.nube.uaifus.service.FavouriteService;

/**
 * FavouriteResource
 */
@RestController
@RequestMapping("/favourite")
public class FavouriteResource {
    final Logger LOG = LoggerFactory.getLogger(FavouriteResource.class);
    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Serie>> getSeriesFavourites(@PathVariable Integer id) {
        List<Serie> listSeries = favouriteService.getFavouritesSeries(id);
        return ResponseEntity.ok().body(listSeries);
    }

    @PostMapping("")
    public ResponseEntity<Favourite> addFavourite(@RequestBody FavouriteRequest request) {
        Favourite favorito = favouriteService.addFavourite(request);
        LOG.info("Se ha añadido un registro favorito de la serie con id: " + favorito.getSerie().getId()
                + ", a un usuario con id: " + favorito.getUsuario().getId());
        return ResponseEntity.ok().body(favorito);
    }

    @DeleteMapping("")
    public ResponseEntity<Favourite> removeFavourite(@RequestBody FavouriteRequest request) {
        Favourite favorito = favouriteService.removeFavourite(request);
        LOG.info("Se ha eliminado un registro de tipo Favorito con id: " + favorito.getId());
        return ResponseEntity.ok().body(favorito);
    }
}
