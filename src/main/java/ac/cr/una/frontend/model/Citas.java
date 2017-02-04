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
public class Citas {

    @JsonProperty("idCita")
    private int idCita;
    @JsonProperty("idPaciente")
    private Pacientes idPaciente;
    @JsonProperty("dia")
    private String dia;
    @JsonProperty("hora")
    private String hora;
    @JsonProperty("consultorio")
    private String consultorio;

    public Citas() {
    }

    public Citas(int idCita, Pacientes idPaciente, String dia, String hora, String consultorio) {
        this.idCita = idCita;
        this.idPaciente = idPaciente;
        this.dia = dia;
        this.hora = hora;
        this.consultorio = consultorio;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Pacientes getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Pacientes idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.idCita;
        hash = 79 * hash + Objects.hashCode(this.idPaciente);
        hash = 79 * hash + Objects.hashCode(this.dia);
        hash = 79 * hash + Objects.hashCode(this.hora);
        hash = 79 * hash + Objects.hashCode(this.consultorio);
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
        final Citas other = (Citas) obj;
        if (this.idCita != other.idCita) {
            return false;
        }
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        if (!Objects.equals(this.consultorio, other.consultorio)) {
            return false;
        }
        if (!Objects.equals(this.idPaciente, other.idPaciente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Citas{" + "idCita=" + idCita + ", idPaciente=" + idPaciente + ", dia=" + dia + ", hora=" + hora + ", consultorio=" + consultorio + '}';
    }
    
    
    
}
