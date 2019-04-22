package mx.nube.uaifus.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.nube.uaifus.model.Favourite;
import mx.nube.uaifus.model.Serie;
import mx.nube.uaifus.model.Usuario;
import mx.nube.uaifus.model.Favourite.FavouriteId;
import mx.nube.uaifus.repository.FavouriteRepository;
import mx.nube.uaifus.repository.SerieRepository;
import mx.nube.uaifus.repository.UsuarioRepository;
import mx.nube.uaifus.request.FavouriteRequest;

/**
 * FavouriteService
 */
@Service
public class FavouriteService {

    @Autowired
    private FavouriteRepository favouriteRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> getFavouritesSeries(Integer idUsuario) {
        List<Serie> listFavouritesSeries = new LinkedList<>();
        Usuario usuario = usuarioRepository.findById(idUsuario).get();
        List<Favourite> listFavourites = favouriteRepository.findByUsuario(usuario);

        for (Favourite fav : listFavourites) {
            listFavouritesSeries.add(fav.getSerie());
        }

        return listFavouritesSeries;
    }

    public Favourite addFavourite(FavouriteRequest request) {
        Favourite favorito = new Favourite();
        FavouriteId id = new FavouriteId();
        id.setIdSerie(request.getIdSerie());
        id.setIdUsuario(request.getIdUsuario());
        favorito.setId(id);
        favouriteRepository.save(favorito);

        return favorito;
    }

    public Favourite removeFavourite(FavouriteRequest request) {
        FavouriteId id = new FavouriteId();
        id.setIdSerie(request.getIdSerie());
        id.setIdUsuario(request.getIdUsuario());
        Favourite favorito = favouriteRepository.findById(id);
        favouriteRepository.delete(favorito);
        return favorito;
    }

}