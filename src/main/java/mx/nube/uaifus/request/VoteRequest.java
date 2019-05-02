package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;

/**
 * VoteRequest
 */
public class VoteRequest {

    @NotBlank
    private Integer idSerie;

    @NotBlank
    private Double vote;

    public VoteRequest() {

    }

    /**
     * @return the idSerie
     */
    public Integer getIdSerie() {
        return idSerie;
    }

    /**
     * @return the vote
     */
    public Double getVote() {
        return vote;
    }

    /**
     * @param idSerie the idSerie to set
     */
    public void setIdSerie(Integer idSerie) {
        this.idSerie = idSerie;
    }

    /**
     * @param vote the vote to set
     */
    public void setVote(Double vote) {
        this.vote = vote;
    }
}