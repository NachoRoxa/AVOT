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
public class Colegio {
    
    private int id_colegio;
    private String nombre;
    private String direccion;
    private String rut;
    private String telefono;
    private Curso curso;

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Colegio() {
    }

    public Colegio(int id_colegio, String nombre, String direccion, String rut, String telefono) {
        this.id_colegio = id_colegio;
        this.nombre = nombre;
        this.direccion = direccion;
        this.rut = rut;
        this.telefono = telefono;
    }

    /**
     * @return the id_colegio
     */
    public int getId_colegio() {
        return id_colegio;
    }

    /**
     * @param id_colegio the id_colegio to set
     */
    public void setId_colegio(int id_colegio) {
        this.id_colegio = id_colegio;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the rut
     */
    public String getRut() {
        return rut;
    }

    /**
     * @param rut the rut to set
     */
    public void setRut(String rut) {
        this.rut = rut;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
