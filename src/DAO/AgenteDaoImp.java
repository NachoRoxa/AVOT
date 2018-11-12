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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NachoRoxa
 */
public class AgenteDaoImp implements BaseDao<Agente> {

    @Override
    public boolean insertar(Agente dto) {
        try {
            CONEXION.Conexion obj = new Conexion();
            Connection con = obj.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into AVOT.agentes values('?','?','?','?','?','?',?,?)");
            ps.setString(1,dto.getRun());
            ps.setString(2,dto.getNombre());
            ps.setString(3,dto.getApellido_paterno());
            ps.setString(4,dto.getApellido_materno());
            ps.setString(5,dto.getUser());
            ps.setInt(6,dto.getAdministrador());
            ps.setInt(7,dto.getEstado());
            ps.execute();
            System.out.println("Exito");
            return true;
        } catch (SQLException ex) {
            System.out.println("NOP");
            return false;
        }
    }
    
   @Override
    public Agente buscar(Agente dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Agente dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Agente dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Agente dto) {
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
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Agente> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select run,nombre,apellido_paterno,apellido_materno,usuario,administrador,estado from agentes");
            while (re.next()) {
                Agente agente = new Agente();
                agente.setRun(re.getString(1));
                agente.setNombre(re.getString(2));
                agente.setApellido_paterno(re.getString(3));
                agente.setApellido_materno(re.getString(4));
                agente.setUser(re.getString(5));
                agente.setAdministrador(re.getInt(6));
                agente.setEstado(re.getInt(7));
                lista.add(agente);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }   

    
}
