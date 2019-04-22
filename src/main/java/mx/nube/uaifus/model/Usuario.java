package mx.nube.uaifus.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String usuario;

    @Column
    private String password;

    @Column
    private String token;

    @OneToMany(mappedBy = "usuario")
    @JsonManagedReference
    private Set<Favourite> favourites;

    public Usuario() {
    }

    public Usuario(Integer id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Usuario id(Integer id) {
        this.id = id;
        return this;
    }

    public Usuario usuario(String usuario) {
        this.usuario = usuario;
        return this;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @return the favourites
     */
    public Set<Favourite> getFavourites() {
        return favourites;
    }

    /**
     * @param favourites the favourites to set
     */
    public void setFavourites(Set<Favourite> favourites) {
        this.favourites = favourites;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", usuario='" + getUsuario() + "', seriesFavoritas: '" + getFavourites()
                + "'}";
    }

}