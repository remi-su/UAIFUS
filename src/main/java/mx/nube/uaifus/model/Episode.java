package mx.nube.uaifus.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Capitulo
 */
@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEpisode;

    @Column
    private String nameEpisode;

    @Column
    private Integer duration;

    @Column
    private String urlVideo;

    @ManyToOne
    @JoinColumn(name = "idSeason")
    private Season idSeason;

    public Episode() {

    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * @return the idEpisode
     */
    public Integer getIdEpisode() {
        return idEpisode;
    }

    /**
     * @return the idSeason
     */
    public Season getIdSeason() {
        return idSeason;
    }

    /**
     * @return the nameEpisode
     */
    public String getNameEpisode() {
        return nameEpisode;
    }

    /**
     * @return the urlVideo
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * @param idEpisode the idEpisode to set
     */
    public void setIdEpisode(Integer idEpisode) {
        this.idEpisode = idEpisode;
    }

    /**
     * @param idSeason the idSeason to set
     */
    public void setIdSeason(Season idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * @param nameEpisode the nameEpisode to set
     */
    public void setNameEpisode(String nameEpisode) {
        this.nameEpisode = nameEpisode;
    }

    /**
     * @param urlVideo the urlVideo to set
     */
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public String toString() {
        return "{" + "nameEpisode = '" + getNameEpisode() + "'," + "duration = '" + getDuration() + "',"
                + "urlVideo = '" + getUrlVideo() + "'," + "idEpisode = '" + getIdEpisode() + "'," + "idSeason = '"
                + getIdSeason() + "'" + "}";
    }
}