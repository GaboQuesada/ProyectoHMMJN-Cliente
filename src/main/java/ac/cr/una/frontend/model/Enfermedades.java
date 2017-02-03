/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ac.cr.una.frontend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author Gabo Quesada
 */
public class Enfermedades {

    @JsonProperty("idEnfermedades")
    int idEnfermedades;
    @JsonProperty("idPacientes")
    Pacientes idPacientes;
    @JsonProperty("enfermedad")
    private String enfermedad;

    /**
     *
     */
    public Enfermedades() {
    }

    /**
     *
     * @param idEnfermedades
     * @param idPacientes
     * @param enfermedad
     */
    public Enfermedades(int idEnfermedades, Pacientes idPacientes, String enfermedad) {
        this.idEnfermedades = idEnfermedades;
        this.idPacientes = idPacientes;
        this.enfermedad = enfermedad;
    }

    /**
     *
     * @return
     */
    public int getIdEnfermedades() {
        return idEnfermedades;
    }

    /**
     *
     * @param idEnfermedades
     */
    public void setIdEnfermedades(int idEnfermedades) {
        this.idEnfermedades = idEnfermedades;
    }

    /**
     *
     * @return
     */
    public Pacientes getIdPacientes() {
        return idPacientes;
    }

    /**
     *
     * @param idPacientes
     */
    public void setIdPacientes(Pacientes idPacientes) {
        this.idPacientes = idPacientes;
    }

    /**
     *
     * @return
     */
    public String getEnfermedad() {
        return enfermedad;
    }

    /**
     *
     * @param enfermedad
     */
    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    @Override
    public String toString() {
        return "Enfermedades{" + "idEnfermedades=" + idEnfermedades + ", idPacientes=" + idPacientes + ", enfermedad=" + enfermedad + '}';
    }
    
    
    
}
