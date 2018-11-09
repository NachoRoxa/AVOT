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
public class EmpresaTransporte {
    
    private int id_transporte;
    private String nombre_empresa;
    private String tipo_transporte;

    public EmpresaTransporte() {
    }

    public EmpresaTransporte(int id_transporte, String nombre_empresa, String tipo_transporte) {
        this.id_transporte = id_transporte;
        this.nombre_empresa = nombre_empresa;
        this.tipo_transporte = tipo_transporte;
    }

    /**
     * @return the id_transporte
     */
    public int getId_transporte() {
        return id_transporte;
    }

    /**
     * @param id_transporte the id_transporte to set
     */
    public void setId_transporte(int id_transporte) {
        this.id_transporte = id_transporte;
    }

    /**
     * @return the nombre_empresa
     */
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    /**
     * @param nombre_empresa the nombre_empresa to set
     */
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    /**
     * @return the tipo_transporte
     */
    public String getTipo_transporte() {
        return tipo_transporte;
    }

    /**
     * @param tipo_transporte the tipo_transporte to set
     */
    public void setTipo_transporte(String tipo_transporte) {
        this.tipo_transporte = tipo_transporte;
    }
    
    
    
}
