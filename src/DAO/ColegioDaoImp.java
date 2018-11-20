/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Colegio;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class ColegioDaoImp implements BaseDao<Colegio>{

    @Override
    public boolean insertar(Colegio dto) {
        Conexion con = new Conexion();
        try
        {
            Connection cx = con.getConnection();
            String sql="{call PR_AGREGAR_COLEGIO(?,?,?,?,?)}";
            CallableStatement proc = cx.prepareCall(sql);
            proc.setInt(1, dto.getId_colegio());
            proc.setString(2, dto.getNombre());
            proc.setString(3, dto.getDireccion());
            proc.setString(4, dto.getRut());
            proc.setString(5, dto.getTelefono());
            proc.executeQuery();
            return true;            
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema con el procedimiento, intente mas tarde o comuniquese con el administrador");
            return false;
        }
    }

    @Override
    public Colegio buscar(Colegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Colegio dto) {
        Conexion cx = new Conexion();
        try
        {
            Connection con = cx.getConnection();
            String sql="{call PR_BORRAR_COLEGIO(?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setString(1, dto.getRut());
            proc.executeUpdate();
            return true;
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema con el procedimiento, intente mas tarde o comuniquese con el administrador");
            return false;
        }
    }

    @Override
    public boolean modificar(Colegio dto) {
        CONEXION.Conexion obj = new Conexion();
        try {
            Connection con = obj.getConnection();
            String sql;
            sql = "{call PR_UPDATE_COLEGIO(?,?,?,?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_COLEGIO", dto.getId_colegio());
            proc.setString("IN_NOMBRE", dto.getNombre());
            proc.setString("IN_DIRECCION", dto.getDireccion());
            proc.setString("IN_RUT", dto.getRut());
            proc.setString("IN_TELEFONO", dto.getTelefono());
            proc.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Ocurrio un problema con el procedure PR_UPDATE_APODERADO: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean existe(Colegio dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Colegio> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_colegio,nombre,direccion,"
                    + "rut,telefono from colegios");
            while (re.next()) {
                Colegio colegio = new Colegio();
                colegio.setId_colegio(re.getInt(1));
                colegio.setNombre(re.getString(2));
                colegio.setDireccion(re.getString(3));
                colegio.setRut(re.getString(4));
                colegio.setTelefono(re.getString(5));
                lista.add(colegio);
            }
        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
}
