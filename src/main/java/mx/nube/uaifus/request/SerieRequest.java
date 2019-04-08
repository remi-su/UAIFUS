package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * SerieRequest
 */
public class SerieRequest {

    @NotBlank
    @Size(max = 50, min = 10)
    private String name;

    @NotBlank
    @Size(max = 20, min = 5)
    private String genre;

    @NotBlank
    private Double rate;

    public SerieRequest() {

    }

    /**
     * @return the genre
     */
    public String getGenre() {
        return genre;
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
     * @param genre the genre to set
     */
    public void setGenre(String genre) {
        this.genre = genre;
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