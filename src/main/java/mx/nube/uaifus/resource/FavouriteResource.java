package mx.nube.uaifus.resource;

import java.util.List;

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
        return ResponseEntity.ok().body(favorito);
    }

    @DeleteMapping("")
    public ResponseEntity<Favourite> removeFavourite(@RequestBody FavouriteRequest request) {
        Favourite favorito = favouriteService.removeFavourite(request);
        return ResponseEntity.ok().body(favorito);
    }
}
