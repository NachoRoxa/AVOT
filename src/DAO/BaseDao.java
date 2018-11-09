/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;

/**
 *
 * @author cetecom
 */
public interface BaseDao<T> {
    boolean insertar(T dto);
    T buscar(T dto);
    boolean eliminar(T dto);
    boolean modificar(T dto);
    boolean existe(T dto);
    ArrayList<T> listar();
}
