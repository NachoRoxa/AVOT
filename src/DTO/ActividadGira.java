/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author pedro
 */
public class ActividadGira {
    
    private int id_actividad;
    private String tipo_actividad;
    private int costo;
    private String descripcion;
    private int estado;
    private Date fecha;
    private int duracion_horas;

    public ActividadGira() {
    }

    public ActividadGira(int id_actividad, String tipo_actividad, int costo, String descripcion, int estado, Date fecha, int duracion_horas) {
        this.id_actividad = id_actividad;
        this.tipo_actividad = tipo_actividad;
        this.costo = costo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fecha = fecha;
        this.duracion_horas = duracion_horas;
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
     * @return the tipo_actividad
     */
    public String getTipo_actividad() {
        return tipo_actividad;
    }

    /**
     * @param tipo_actividad the tipo_actividad to set
     */
    public void setTipo_actividad(String tipo_actividad) {
        this.tipo_actividad = tipo_actividad;
    }

    /**
     * @return the costo
     */
    public int getCosto() {
        return costo;
    }

    /**
     * @param costo the costo to set
     */
    public void setCosto(int costo) {
        this.costo = costo;
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
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDuracion_horas() {
        return duracion_horas;
    }

    public void setDuracion_horas(int duracion_horas) {
        this.duracion_horas = duracion_horas;
    }
    
    
    
}
