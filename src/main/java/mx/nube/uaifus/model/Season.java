package mx.nube.uaifus.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Season
 */
@Entity
@Table(name = "seasons")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSeason;

    @Column
    private String name;

    @Column
    private Double rate;

    @ManyToOne
    @JoinColumn(name = "idSerie")
    private Serie idSerie;

    public Season() {

    }

    /**
     * @return the idSeason
     */
    public Integer getIdSeason() {
        return idSeason;
    }

    /**
     * @return the idSerie
     */
    public Serie getIdSerie() {
        return idSerie;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the rate
     */
    public Double getRate() {
        return rate;
    }

    /**
     * @param idSeason the idSeason to set
     */
    public void setIdSeason(Integer idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * @param idSerie the idSerie to set
     */
    public void setIdSerie(Serie idSerie) {
        this.idSerie = idSerie;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "{" + "idSeason = '" + getIdSeason() + "'," + "nameSeason = '" + getName() + "'," + "rate = '"
                + getRate() + "', " + "Serie: " + getIdSerie() + "}";
    }
}