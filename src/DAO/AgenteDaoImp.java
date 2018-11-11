/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import CONEXION.Conexion;
import DTO.Agente;
import java.sql.SQLException;
import org.omg.CORBA.portable.UnknownException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author NachoRoxa
 */
public class AgenteDaoImp implements BaseDao {

    @Override
    public boolean insertar(Object dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object buscar(Object dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Object dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Object dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Object dto) {
        CONEXION.Conexion obj = new Conexion();
        Agente ag = new Agente();
        String usuario = ag.getUser();
        String pass = ag.getPasswd();
        String query = "select usuario, passwd from agente where usuario = "+usuario+" and passwd= "+pass+";";
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery(query);

        } catch (Exception ex) {
            return false;
        }
        return true;
    }
    
    /***
     * Metodo para verificar la conexion en el Login.
     * @param usuario
     * @param pass
     * @return Si existe el usuario retorna true, caso contrario false
     */
    public boolean Query(String usuario, String pass)
    {
        CONEXION.Conexion obj = new Conexion();
        Agente ag = new Agente();
        usuario = ag.getUser();
        pass = ag.getPasswd();
        String query = "select usuario, passwd from agente where usuario =? and passwd=?";
        try {
            Connection con = obj.getConnection();
            PreparedStatement st = con.prepareStatement(query);            
            st.setString(1, usuario);
            st.setString(2, pass);
            ResultSet re = st.executeQuery();
        } catch (Exception ex) {            
            return false;
        }
        return true;
    }
    
    @Override
    public ArrayList listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
