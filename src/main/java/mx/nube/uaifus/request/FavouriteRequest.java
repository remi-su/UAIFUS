package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;

/**
 * FavouriteRequest
 */
public class FavouriteRequest {

    @NotBlank
    private Integer idUsuario;

    @NotBlank
    private Integer idSerie;

    public FavouriteRequest() {

    }

    /**
     * @return the idSerie
     */
    public Integer getIdSerie() {
        return idSerie;
    }

    /**
     * @return the idUsuario
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * @param idSerie the idSerie to set
     */
    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    /**
     * @param idUsuario the idUsuario to set
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}