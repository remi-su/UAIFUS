package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;

/**
 * SeasonRequest
 */
public class SeasonRequest {

    private Integer idSerie;

    private Integer idSeason;

    @NotBlank
    private String name;

    @NotBlank
    private Double rate;

    public SeasonRequest() {

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
    public Integer getIdSerie() {
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
    public void setIdSerie(Integer idSerie) {
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

}