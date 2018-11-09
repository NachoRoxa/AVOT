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
public class Viajes {
    
    private int id_viaje;
    private String origen;
    private String destino;
    private int costo;
    private int estado;
    private EmpresaTransporte empresa_transporte;
    private Date fechaInicio;
    private Date fechaTermino;

    public Viajes() {
    }

    public Viajes(int id_viaje, String origen, String destino, int costo, int estado, EmpresaTransporte empresa_transporte, Date fechaInicio, Date fechaTermino) {
        this.id_viaje = id_viaje;
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.estado = estado;
        this.empresa_transporte = empresa_transporte;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public int getId_viaje() {
        return id_viaje;
    }

    public void setId_viaje(int id_viaje) {
        this.id_viaje = id_viaje;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public EmpresaTransporte getEmpresa_transporte() {
        return empresa_transporte;
    }

    public void setEmpresa_transporte(EmpresaTransporte empresa_transporte) {
        this.empresa_transporte = empresa_transporte;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }
    
}
