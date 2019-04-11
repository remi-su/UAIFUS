package mx.nube.uaifus.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * UsuarioRequest
 */

public class UsuarioRequest {

    private Integer id;

    @NotBlank
    @Size(min = 6, max = 16)
    private String usuario;

    @NotBlank
    @Size(min = 8, max = 16)
    private String password;

    public UsuarioRequest() {

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}