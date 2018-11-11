/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Seguro {
    
    private int id_seguro;
    private int dias_cobertura;
    private int costo;
    private String descripcion;
    private int estado;
    private Aseguradora aseguradora;
    private Date fecha_inicio;
    private Date fecha_termino;
    

    public Seguro() {
    }

    public Seguro(int id_seguro, int dias_cobertura, int costo, String descripcion, int estado, Aseguradora aseguradora, Date fecha_inicio, Date fecha_termino) {
        this.id_seguro = id_seguro;
        this.dias_cobertura = dias_cobertura;
        this.costo = costo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.aseguradora = aseguradora;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    

    public int getId_seguro() {
        return id_seguro;
    }

    public void setId_seguro(int id_seguro) {
        this.id_seguro = id_seguro;
    }

    public int getDias_cobertura() {
        return dias_cobertura;
    }

    public void setDias_cobertura(int dias_cobertura) {
        this.dias_cobertura = dias_cobertura;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Aseguradora getAseguradora() {
        return aseguradora;
    }

    public void setAseguradora(Aseguradora aseguradora) {
        this.aseguradora = aseguradora;
    }
    
    
    
    
}
