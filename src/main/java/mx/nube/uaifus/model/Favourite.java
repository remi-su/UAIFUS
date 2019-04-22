package mx.nube.uaifus.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Favourite
 */
@Entity
@Table(name = "favourites")
public class Favourite {
    @EmbeddedId
    private FavouriteId id;

    @ManyToOne
    @MapsId("id_usuario")
    @JoinColumn(name = "id_usuario")
    @JsonBackReference
    private Usuario usuario;

    @ManyToOne
    @MapsId("id_serie")
    @JoinColumn(name = "id_serie")
    @JsonBackReference
    private Serie serie;

    @Embeddable
    public static class FavouriteId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "id_usuario")
        private Integer idUsuario;

        @Column(name = "id_serie")
        private Integer idSerie;

        public FavouriteId() {

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

    public Favourite() {

    }

    public Favourite(FavouriteId id, Usuario usuario, Serie serie) {
        this.id = id;
        this.serie = serie;
        this.usuario = usuario;
    }

    /**
     * @return the id
     */
    public FavouriteId getId() {
        return id;
    }

    /**
     * @return the serie
     */
    public Serie getSerie() {
        return serie;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param id the id to set
     */
    public void setId(FavouriteId id) {
        this.id = id;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "{ idFavourite: '" + getId() + "', " + "usuario :'" + getUsuario() + "', " + "serie:'" + getSerie() + "'"
                + "}";
    }
}