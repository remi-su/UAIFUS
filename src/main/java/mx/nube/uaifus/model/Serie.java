package mx.nube.uaifus.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Serie
 */
@Entity
@Table(name = "series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nameSerie")
    private String nameSerie;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "description")
    private String description;

    public Serie() {

    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * @return the idSerie
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the nameSerie
     */
    public String getNameSerie() {
        return nameSerie;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * @param idSerie the idSerie to set
     */
    public void setId(Integer idSerie) {
        this.id = idSerie;
    }

    /**
     * @param nameSerie the nameSerie to set
     */
    public void setNameSerie(String nameSerie) {
        this.nameSerie = nameSerie;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "{" + " id = '" + getId() + "'" + ", name = '" + getNameSerie() + "'" + ", genre = '" + getGenre() + "'"
                + ", rate =  '" + getRate() + "'" + ", description = '" + getDescription() + "'}";
    }
}