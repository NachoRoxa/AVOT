/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author pedro
 */
public class Curso {
    
    private int id_curso;
    private int monto_recargado;
    private Colegio colegio;
    private List<ActividadColegio> actividades;

    public Curso() {
    }

    public Curso(int id_curso, int monto_recargado, Colegio colegio, List<ActividadColegio> actividades) {
        this.id_curso = id_curso;
        this.monto_recargado = monto_recargado;
        this.colegio = colegio;
        this.actividades = actividades;
    }

    /**
     * @return the id_curso
     */
    public int getId_curso() {
        return id_curso;
    }

    /**
     * @param id_curso the id_curso to set
     */
    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    /**
     * @return the monto_recargado
     */
    public int getMonto_recargado() {
        return monto_recargado;
    }

    /**
     * @param monto_recargado the monto_recargado to set
     */
    public void setMonto_recargado(int monto_recargado) {
        this.monto_recargado = monto_recargado;
    }

    /**
     * @return the colegios_id_colegio
     */
    public Colegio getColegio() {
        return colegio;
    }

    /**
     * @param colegio the colegios_id_colegio to set
     */
    public void setColegio(Colegio colegio) {
        this.colegio = colegio;
    }

    public List<ActividadColegio> getActividades() {
        return actividades;
    }

    public void setActividades(List<ActividadColegio> actividades) {
        this.actividades = actividades;
    }
    
    
}
