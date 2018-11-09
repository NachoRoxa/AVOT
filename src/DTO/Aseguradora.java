/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.List;

/**
 *
 * @author cetecom
 */
public class Aseguradora {
    private String rut;
    private String nombre_aseguradora;
    private String direccion;
    private List<Seguro> seguros;

    public Aseguradora() {
    }

    public Aseguradora(String rut, String nombre_aseguradora, String direccion, List<Seguro> seguros) {
        this.rut = rut;
        this.nombre_aseguradora = nombre_aseguradora;
        this.direccion = direccion;
        this.seguros = seguros;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre_aseguradora() {
        return nombre_aseguradora;
    }

    public void setNombre_aseguradora(String nombre_aseguradora) {
        this.nombre_aseguradora = nombre_aseguradora;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }
    
    
}

