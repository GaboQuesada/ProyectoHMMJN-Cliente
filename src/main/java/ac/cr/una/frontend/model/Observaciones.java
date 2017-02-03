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
public class Observaciones {

    @JsonProperty("idObservaciones")
    int idObservaciones;
    @JsonProperty("idPacientes")
    Pacientes idPacientes;
    @JsonProperty("observacion")
    String observacion;

    /**
     *
     */
    public Observaciones() {
    }

    /**
     *
     * @param idObservaciones
     * @param idPacientes
     * @param observacion
     */
    public Observaciones(int idObservaciones, Pacientes idPacientes, String observacion) {
        this.idObservaciones = idObservaciones;
        this.idPacientes = idPacientes;
        this.observacion = observacion;
    }

    /**
     *
     * @return
     */
    public int getIdObservaciones() {
        return idObservaciones;
    }

    /**
     *
     * @param idObservaciones
     */
    public void setIdObservaciones(int idObservaciones) {
        this.idObservaciones = idObservaciones;
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
    public String getObservacion() {
        return observacion;
    }

    /**
     *
     * @param observacion
     */
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    @Override
    public String toString() {
        return "Observaciones{" + "idObservaciones=" + idObservaciones + ", idPacientes=" + idPacientes + ", observacion=" + observacion + '}';
    }

}
