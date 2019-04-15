package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;

/**
 * EpisodeRequest
 */
public class EpisodeRequest {

    private Integer idEpisode;

    private Integer idSeason;

    @NotBlank
    private String nameEpisode;

    @NotBlank
    private Integer duration;

    @NotBlank
    private String urlVideo;

    public EpisodeRequest() {

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
    public Integer getIdSeason() {
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
    public void setIdSeason(Integer idSeason) {
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
}