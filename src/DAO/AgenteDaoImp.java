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
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author NachoRoxa
 */
public class AgenteDaoImp implements BaseDao{

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
        CONEXION.Conexion obj= new Conexion();
        Agente ag = new Agente();
        try
        {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re=st.executeQuery("select usuario, passwd from agente where usuario=? and passwd=?;");
            
        }
        catch(Exception ex)
        {
            return false;
        }
        return true;
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Agente> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_actividad,tipo_actividad,costo,descripcion,estado from actividades_gira");
            while (re.next()) {
                Agente agente = new Agente();
                agente.set(re.getInt(1));
                agente.setTipo_actividad(re.getString(2));
                agente.setCosto(re.getInt(3));
                agente.setDescripcion(re.getString(4));
                agente.setEstado(re.getInt(5));
                lista.add(agente);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }   
}