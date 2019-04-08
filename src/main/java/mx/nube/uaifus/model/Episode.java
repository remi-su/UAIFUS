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
@Table(name = "capitulos")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idChapter;

    @Column
    private String nameChapter;

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
     * @return the idChapter
     */
    public Integer getIdChapter() {
        return idChapter;
    }

    /**
     * @return the idSeason
     */
    public Season getIdSeason() {
        return idSeason;
    }

    /**
     * @return the nameChapter
     */
    public String getNameChapter() {
        return nameChapter;
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
     * @param idChapter the idChapter to set
     */
    public void setIdChapter(Integer idChapter) {
        this.idChapter = idChapter;
    }

    /**
     * @param idSeason the idSeason to set
     */
    public void setIdSeason(Season idSeason) {
        this.idSeason = idSeason;
    }

    /**
     * @param nameChapter the nameChapter to set
     */
    public void setNameChapter(String nameChapter) {
        this.nameChapter = nameChapter;
    }

    /**
     * @param urlVideo the urlVideo to set
     */
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }

    @Override
    public String toString() {
        return "{" + "nameChapter = '" + getNameChapter() + "'," + "duration = '" + getDuration() + "',"
                + "urlVideo = '" + getUrlVideo() + "'," + "idChapter = '" + getIdChapter() + "'," + "idSeason = '"
                + getIdSeason() + "'" + "}";
    }
}