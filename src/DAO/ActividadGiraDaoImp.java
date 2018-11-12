/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.ActividadGira;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class ActividadGiraDaoImp implements BaseDao<ActividadGira> {
    
    @Override
    public boolean insertar(ActividadGira dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActividadGira buscar(ActividadGira dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ActividadGira dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ActividadGira dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(ActividadGira dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<ActividadGira> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_actividad,tipo_actividad,costo,descripcion,estado from actividades_gira");
            while (re.next()) {
                ActividadGira actividadGira = new ActividadGira();
                actividadGira.setId_actividad(re.getInt(1));
                actividadGira.setTipo_actividad(re.getString(2));
                actividadGira.setCosto(re.getInt(3));
                actividadGira.setDescripcion(re.getString(4));
                actividadGira.setEstado(re.getInt(5));
                lista.add(actividadGira);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
    
}
