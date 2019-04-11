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
    private Integer idSerie;

    @Column
    private String nameSerie;

    @Column
    private String genre;

    @Column
    private Double rate;

    @Column
    private Date releasedDate;

    @Column
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
    public Integer getIdSerie() {
        return idSerie;
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
     * @return the releasedDate
     */
    public Date getReleasedDate() {
        return releasedDate;
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
    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
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

    /**
     * @param releasedDate the releasedDate to set
     */
    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        return "{" + " id = '" + getIdSerie() + "'" + ", name = '" + getNameSerie() + "'" + ", genre = '" + getGenre()
                + "'" + ", rate =  '" + getRate() + "'" + ", releasedDate = '" + getReleasedDate() + "'"
                + ", description = '" + getDescription() + "'}";
    }
}