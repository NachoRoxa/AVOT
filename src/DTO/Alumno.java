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
public class Alumno {
    
    private String run;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private int monto_personal;
    private int cursos_id_curso;
    private Apoderado apoderado;
    private Tour tour;
    private List<Integer> montoProrrateo;

    public Alumno() {
    }

    public Alumno(String run, String nombre, String apellido_paterno, String apellido_materno, int monto_personal, int cursos_id_curso, Apoderado apoderado, Tour tour, List<Integer> montoProrrateo) {
        this.run = run;
        this.nombre = nombre;
        this.apellido_paterno = apellido_paterno;
        this.apellido_materno = apellido_materno;
        this.monto_personal = monto_personal;
        this.cursos_id_curso = cursos_id_curso;
        this.apoderado = apoderado;
        this.tour = tour;
        this.montoProrrateo = montoProrrateo;
    }
    

    /**
     * @return the run
     */
    public String getRun() {
        return run;
    }

    /**
     * @param run the run to set
     */
    public void setRun(String run) {
        this.run = run;
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
     * @return the apellido_paterno
     */
    public String getApellido_paterno() {
        return apellido_paterno;
    }

    /**
     * @param apellido_paterno the apellido_paterno to set
     */
    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    /**
     * @return the apellido_materno
     */
    public String getApellido_materno() {
        return apellido_materno;
    }

    /**
     * @param apellido_materno the apellido_materno to set
     */
    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    /**
     * @return the monto_personal
     */
    public int getMonto_personal() {
        return monto_personal;
    }

    /**
     * @param monto_personal the monto_personal to set
     */
    public void setMonto_personal(int monto_personal) {
        this.monto_personal = monto_personal;
    }

    /**
     * @return the cursos_id_curso
     */
    public int getCursos_id_curso() {
        return cursos_id_curso;
    }

    /**
     * @param cursos_id_curso the cursos_id_curso to set
     */
    public void setCursos_id_curso(int cursos_id_curso) {
        this.cursos_id_curso = cursos_id_curso;
    }

    /**
     * @return the apoderados_run
     */
    public Apoderado getApoderado() {
        return apoderado;
    }

    /**
     * @param apoderado the apoderados_run to set
     */
    public void setApoderado(Apoderado apoderado) {
        this.apoderado = apoderado;
    }

    /**
     * @return the tour
     */
    public Tour getTour() {
        return tour;
    }

    /**
     * @param tour the tours_id_tour to set
     */
    public void setTour(Tour tour) {
        this.tour = tour;
    }
    
    
}
