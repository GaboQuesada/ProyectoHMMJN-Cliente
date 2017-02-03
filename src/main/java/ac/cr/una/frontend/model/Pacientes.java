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
public class Pacientes {
    @JsonProperty("idPacientes")
    private int idPacientes;
    @JsonProperty("name")
    private String name;
    @JsonProperty("telefono")
    private String telefono;
    @JsonProperty("direccion")
    private String direccion;
    @JsonProperty("fechanacimiento")
    private String fechanacimiento; 

    public Pacientes() {
    }

    public Pacientes(int idPacientes, String name, String telefono, String direccion, String fechanacimiento) {
        this.idPacientes = idPacientes;
        this.name = name;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechanacimiento = fechanacimiento;
    }

    public int getIdPacientes() {
        return idPacientes;
    }

    public void setIdPacientes(int idPacientes) {
        this.idPacientes = idPacientes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechanacimiento() {
        return fechanacimiento;
    }

    public void setFechanacimiento(String fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idPacientes;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.direccion);
        hash = 59 * hash + Objects.hashCode(this.fechanacimiento);
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
        final Pacientes other = (Pacientes) obj;
        if (this.idPacientes != other.idPacientes) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.fechanacimiento, other.fechanacimiento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "idPacientes=" + idPacientes + ", name=" + name + ", telefono=" + telefono + ", direccion=" + direccion + ", fechanacimiento=" + fechanacimiento + '}';
    }
    
    
}
