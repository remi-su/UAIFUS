package mx.nube.uaifus.request;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * SerieRequest
 */
public class SerieRequest {

    private Integer id;

    @NotBlank
    @Size(max = 50, min = 10)
    private String name;

    @NotBlank
    @Size(max = 20, min = 5)
    private String genre;

    @NotBlank
    private Double rate;

    @NotBlank
    private String descripcion;

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

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}