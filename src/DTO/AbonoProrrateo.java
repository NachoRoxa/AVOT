/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Pedro
 */
public class AbonoProrrateo {
    
    private int montoProrrateo;

    public AbonoProrrateo() {
    }

    public AbonoProrrateo(int montoProrrateo) {
        this.montoProrrateo = montoProrrateo;
    }

    /**
     * @return the montProrrateo
     */
    public int getMontoProrrateo() {
        return montoProrrateo;
    }

    /**
     * @param montoProrrateo the monto_prorrateo to set
     */
    public void setMonto_prorrateo(int montoProrrateo) {
        this.montoProrrateo = montoProrrateo;
    }
    
    
}
