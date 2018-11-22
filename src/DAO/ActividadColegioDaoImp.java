/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.ActividadColegio;
import java.util.ArrayList;
import CONEXION.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Seba
 */
public class ActividadColegioDaoImp implements BaseDao<ActividadColegio>{

    @Override
    public boolean insertar(ActividadColegio dto) {
        Conexion cx = new Conexion();
        try
        {
            Connection con = cx.getConnection();
            String sql = "{call PR_AGREGAR_ACT_COLEGIO (?,?,?,?,?,?}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setString(1, dto.getDescripcion());
            proc.setInt(2, dto.getInversion());
            proc.setInt(3, dto.getId_actividad());            
            proc.setInt(4, dto.getRecaudacion());
            proc.setInt(5, dto.getMonto_deposito());
            proc.setString(6, dto.getNumero_deposito());
            proc.executeQuery();
            return true;
        }catch(Exception ex)
        {
            return false;
        }
        
    }

    @Override
    public ActividadColegio buscar(ActividadColegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(ActividadColegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(ActividadColegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(ActividadColegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<ActividadColegio> listar() {
        Conexion cx = new Conexion();
        ArrayList<ActividadColegio> lista = new ArrayList<>();
        try
        {
            Connection con = cx.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select id_actividad, descripcion, inversion, recaudacion, monto_deposito, numero_deposito from actividades_colegio");
            while(rs.next())
            {
                ActividadColegio actCole = new ActividadColegio();
                actCole.setId_actividad(rs.getInt(1));
                actCole.setDescripcion(rs.getString(2));
                actCole.setInversion(rs.getInt(3));
                actCole.setRecaudacion(rs.getInt(4));
                actCole.setMonto_deposito(rs.getInt(5));
                actCole.setNumero_deposito(rs.getString(6));
                lista.add(actCole);
            }
        }catch(Exception ex)
        {
            return lista;
        }        
        return lista;
    }    
}