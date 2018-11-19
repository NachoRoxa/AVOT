/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Curso {
    
    private int id_curso;
    private int monto_recaudado;
    private Colegio colegio;
    private String descripcion;
    private ArrayList<Alumno> alumnos;
    private ArrayList<ActividadColegio> actividades;

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(ArrayList<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Curso() {
    }

    public Curso(int id_curso, int monto_recaudado, Colegio colegio, String descripcion, ArrayList<ActividadColegio> actividades) {
        this.id_curso = id_curso;
        this.monto_recaudado = monto_recaudado;
        this.colegio = colegio;
        this.descripcion = descripcion;
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
    public int getMonto_recaudado() {
        return monto_recaudado;
    }

    /**
     * @param monto_recargado the monto_recargado to set
     */
    public void setMonto_recaudado(int monto_recaudado) {
        this.monto_recaudado = monto_recaudado;
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

    public ArrayList<ActividadColegio> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<ActividadColegio> actividades) {
        this.actividades = actividades;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
