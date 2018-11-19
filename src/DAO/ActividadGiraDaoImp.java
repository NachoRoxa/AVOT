/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.ActividadGira;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Seba
 */
public class ActividadGiraDaoImp implements BaseDao<ActividadGira> {

    @Override
    public boolean insertar(ActividadGira dto) {
        CONEXION.Conexion obj = new Conexion();
        try {
            Connection con = obj.getConnection();
            String sql;
            sql = "{call PR_AGREGAR_ACTIVIDADES_GIRA(?,?,?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setString(1, dto.getTipo_actividad());
            proc.setInt(2, dto.getCosto());
            proc.setString(3, dto.getDescripcion());
            proc.setInt(4, dto.getEstado());
            proc.executeQuery();
            JOptionPane.showMessageDialog(null, "AGREGADO!");
            return true;            
        } catch (Exception ex) {
            System.out.println("Ocurrio un problema con el procedure PR_AGREGAR_ACTIVIDADES_GIRA: " + ex.getMessage());
            return false;
        }
        
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
                //actividadGira.setFecha(re.getDate("FECHA"));
                actividadGira.setDescripcion(re.getString("DESCRIPCION"));
                actividadGira.setEstado(re.getInt("ESTADO"));
                lista.add(actividadGira);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }

    public ArrayList<ActividadGira> listarActividadesTour(int idTour) {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<ActividadGira> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            String sql = "{call PR_LISTAR_ACT_CONTRATO(?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", idTour);
            proc.registerOutParameter("out_list", OracleTypes.CURSOR);
            proc.executeUpdate();
            ResultSet re = (ResultSet) proc.getObject("out_list");
            while (re.next()) {
                ActividadGira actividadGira = new ActividadGira();
                actividadGira.setFecha(re.getDate("FECHA"));
                actividadGira.setDuracion_horas(re.getInt("DURACION_HORAS"));
                actividadGira.setId_actividad(re.getInt("ID ACTIVIDAD"));
                actividadGira.setTipo_actividad(re.getString("TIPO ACTIVIDAD"));
                actividadGira.setCosto(re.getInt("COSTO"));
                actividadGira.setDescripcion(re.getString("DESCRIPCION"));
                actividadGira.setEstado(re.getInt("ESTADO"));
                lista.add(actividadGira);
            }
        } catch (SQLException e) {
            return lista;
        }
        return lista;
    }
}
