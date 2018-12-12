/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author pedro
 */
public class Tour {
    private int id_tour;
    private int valor_total;
    private String descripcion;
    private int numero_contrato;
    private Agente agente;
    private Date fecha_creacion;
    private Date fecha_inicio;
    private Date fecha_termino;
    private ArrayList<Viaje> viajes;
    private ArrayList<Seguro> seguros;
    private ArrayList<Estadia> estadias;
    private ArrayList<ActividadGira> actividades;
    

    public Tour() {
    }

    public Tour(int id_tour, int valor_total, String descripcion, int numero_contrato, Agente agente, Date fecha_creacion, Date fecha_inicio, Date fecha_termino) {
        this.id_tour = id_tour;
        this.valor_total = valor_total;
        this.descripcion = descripcion;
        this.numero_contrato = numero_contrato;
        this.agente = agente;
        this.fecha_creacion = fecha_creacion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino=fecha_termino;
    }

    public int getId_tour() {
        return id_tour;
    }

    public void setId_tour(int id_tour) {
        this.id_tour = id_tour;
    }

    public int getValor_total() {
        return valor_total;
    }

    public void setValor_total(int valor_total) {
        this.valor_total = valor_total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumero_contrato() {
        return numero_contrato;
    }

    public void setNumero_contrato(int numero_contrato) {
        this.numero_contrato = numero_contrato;
    }

    public Agente getAgente() {
        return agente;
    }

    public void setAgente(Agente agente) {
        this.agente = agente;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public ArrayList<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(ArrayList<Viaje> viajes) {
        this.viajes = viajes;
    }

    public ArrayList<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(ArrayList<Seguro> seguros) {
        this.seguros = seguros;
    }

    public ArrayList<Estadia> getEstadias() {
        return estadias;
    }

    public void setEstadias(ArrayList<Estadia> estadias) {
        this.estadias = estadias;
    }

    public ArrayList<ActividadGira> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<ActividadGira> actividades) {
        this.actividades = actividades;
    }
    
    public Date getFechaTermino()
    {
        return fecha_termino;
    }
    
    public void setFechaTermino(Date fecha_termino)
    {
        this.fecha_termino=fecha_termino;
    }
}
