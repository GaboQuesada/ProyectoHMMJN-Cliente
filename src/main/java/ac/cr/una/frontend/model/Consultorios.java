/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.frontend.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
/**
 *
 * @author Gabo Quesada
 */
public class Consultorios {
    @JsonProperty("idConsultorio")
    private int idConsultorio;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("fechayhora")
    private String fechayhora;
    @JsonProperty("name")
    private String name;

    /**
     *
     */
    public Consultorios() {
    }

    /**
     *
     * @param idConsultorio
     * @param telefono
     * @param fechayhora
     */
    public Consultorios(int idConsultorio, String telefono, String fechayhora) {
        this.idConsultorio = idConsultorio;
        this.telefono = telefono;
        this.fechayhora = fechayhora;
    }

  

    /**
     *
     * @return
     */
    public int getIdConsultorio() {
        return idConsultorio;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param idConsultorio
     */
    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

    /**
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return
     */
    public String getFechayhora() {
        return fechayhora;
    }

    /**
     *
     * @param fechayhora
     */
    public void setFechayhora(String fechayhora) {
        this.fechayhora = fechayhora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.idConsultorio;
        hash = 67 * hash + Objects.hashCode(this.telefono);
        hash = 67 * hash + Objects.hashCode(this.fechayhora);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consultorios other = (Consultorios) obj;
        if (this.idConsultorio != other.idConsultorio) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.fechayhora, other.fechayhora)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Consultorios{" + "idConsultorio=" + idConsultorio + ", telefono=" + telefono + ", fechayhora=" + fechayhora + '}';
    }
            
            
}
