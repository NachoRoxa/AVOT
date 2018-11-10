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
public class AbonoPersonal {
    
    private int id_abono_personal;
    private int monto;
    private int num_registro_abono;
    private Date fecha_abono;
    private Alumno alumno;

    public AbonoPersonal() {
    }

    public AbonoPersonal(int id_abono_personal, int monto, int num_registro_abono, Date fecha_abono, Alumno alumnos) {
        this.id_abono_personal = id_abono_personal;
        this.monto = monto;
        this.num_registro_abono = num_registro_abono;
        this.fecha_abono = fecha_abono;
        this.alumno = alumnos;
    }
    
    

    /**
     * @return the id_abono_personal
     */
    public int getId_abono_personal() {
        return id_abono_personal;
    }

    /**
     * @param id_abono_personal the id_abono_personal to set
     */
    public void setId_abono_personal(int id_abono_personal) {
        this.id_abono_personal = id_abono_personal;
    }

    /**
     * @return the monto
     */
    public int getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * @return the num_registro_abono
     */
    public int getNum_registro_abono() {
        return num_registro_abono;
    }

    /**
     * @param num_registro_abono the num_registro_abono to set
     */
    public void setNum_registro_abono(int num_registro_abono) {
        this.num_registro_abono = num_registro_abono;
    }

    /**
     * @return the fecha_abono
     */
    public Date getFecha_abono() {
        return fecha_abono;
    }

    /**
     * @param fecha_abono the fecha_abono to set
     */
    public void setFecha_abono(Date fecha_abono) {
        this.fecha_abono = fecha_abono;
    }

    /**
     * @return the alumnos_run
     */
    public Alumno getAlumno() {
        return alumno;
    }

    /**
     * @param alumno the alumnos_run to set
     */
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    
    
}
