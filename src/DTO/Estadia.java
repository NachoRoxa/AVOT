/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Date;

/**
 *
 * @author cetecom
 */
public class Estadia {
    private int id_estadia;
    private String direccion;
    private int costo_por_dia;
    private int estado;
    private int capacidad;
    private String nombre;
    private Date fecha_ingreso;
    private Date fecha_salida;
    

    public Estadia() {
    }

    public Estadia(int id_estadia, String direccion, int costo_por_dia, int estado, int capacidad, String nombre, Date fecha_ingreso, Date fecha_salida) {
        this.id_estadia = id_estadia;
        this.direccion = direccion;
        this.costo_por_dia = costo_por_dia;
        this.estado = estado;
        this.capacidad = capacidad;
        this.nombre = nombre;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_salida = fecha_salida;
    }

    public int getId_estadia() {
        return id_estadia;
    }

    public void setId_estadia(int id_estadia) {
        this.id_estadia = id_estadia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCosto_por_dia() {
        return costo_por_dia;
    }

    public void setCosto_por_dia(int costo_por_dia) {
        this.costo_por_dia = costo_por_dia;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    
    
    
}
