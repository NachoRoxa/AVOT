/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author pedro
 */
public class ActividadColegio {
    
    private int id_actividad;
    private String descripcion;
    private int inversion;
    private int recaudacion;
    private int monto_deposito;
    private String numero_deposito;

    public ActividadColegio() {
    }

    public ActividadColegio(int id_actividad, String descripcion, int inversion, int recaudacion, int monto_deposito, String numero_deposito) {
        this.id_actividad = id_actividad;
        this.descripcion = descripcion;
        this.inversion = inversion;
        this.recaudacion = recaudacion;
        this.monto_deposito = monto_deposito;
        this.numero_deposito = numero_deposito;
    }

    /**
     * @return the id_actividad
     */
    public int getId_actividad() {
        return id_actividad;
    }

    /**
     * @param id_actividad the id_actividad to set
     */
    public void setId_actividad(int id_actividad) {
        this.id_actividad = id_actividad;
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

    /**
     * @return the inversion
     */
    public int getInversion() {
        return inversion;
    }

    /**
     * @param inversion the inversion to set
     */
    public void setInversion(int inversion) {
        this.inversion = inversion;
    }

    /**
     * @return the recaudacion
     */
    public int getRecaudacion() {
        return recaudacion;
    }

    /**
     * @param recaudacion the recaudacion to set
     */
    public void setRecaudacion(int recaudacion) {
        this.recaudacion = recaudacion;
    }

    /**
     * @return the monto_deposito
     */
    public int getMonto_deposito() {
        return monto_deposito;
    }

    /**
     * @param monto_deposito the monto_deposito to set
     */
    public void setMonto_deposito(int monto_deposito) {
        this.monto_deposito = monto_deposito;
    }

    /**
     * @return the numero_deposito
     */
    public String getNumero_deposito() {
        return numero_deposito;
    }

    /**
     * @param numero_deposito the numero_deposito to set
     */
    public void setNumero_deposito(String numero_deposito) {
        this.numero_deposito = numero_deposito;
    }
    
    
}
