/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Estadia;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Seba
 */
public class EstadiaDaoImp implements BaseDao<Estadia> {

    @Override
    public boolean insertar(Estadia dto) {
        CONEXION.Conexion obj = new Conexion();
        try {
            Connection con = obj.getConnection();
            String sql;
            sql = "{call PR_AGREGAR_ESTADIA(?,?,?,?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setString(1,dto.getNombre());
            proc.setInt(2,dto.getCosto_por_dia());
            proc.setString(3,dto.getDireccion());
            proc.setInt(4,dto.getEstado());
            proc.setInt(5,dto.getCapacidad());
            proc.executeQuery();
            return true;
        } catch (Exception ex) {
            System.out.println("Ocurrio un problema con el procedure PR_AGREGAR_ESTADIA: " + ex.getMessage());
            return false;
        }
    }

    @Override
    public Estadia buscar(Estadia dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Estadia dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Estadia dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Estadia dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Estadia> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_estadia,nombre,direccion,"
                    + "costo_por_dia,estado,capacidad from estadias");
            while (re.next()) {
                Estadia estadia = new Estadia();
                estadia.setId_estadia(re.getInt(1));
                estadia.setNombre(re.getString(2));
                estadia.setDireccion(re.getString(3));
                estadia.setCosto_por_dia(re.getInt(4));
                estadia.setEstado(re.getInt(5));
                estadia.setCapacidad(re.getInt(6));
                lista.add(estadia);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
    
    public ArrayList<Estadia> listarEstadiasTour(int idTour) {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Estadia> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            String sql = "{call PR_LISTAR_ESTADIAS_CONTRATO(?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", idTour);
            proc.registerOutParameter("out_list", OracleTypes.CURSOR);
            proc.executeUpdate();
            ResultSet re = (ResultSet)proc.getObject("out_list");
            while (re.next()) {
                Estadia estadia = new Estadia();
                estadia.setId_estadia(re.getInt("ID ESTADIA"));
                estadia.setFecha_ingreso(re.getDate("FECHA INGRESO"));
                estadia.setFecha_salida(re.getDate("FECHA SALIDA"));
                estadia.setNombre(re.getString("NOMBRE ESTADIA"));
                estadia.setCosto_por_dia(re.getInt("COSTO POR DIA"));
                estadia.setDireccion(re.getString("DIRECCION"));
                estadia.setEstado(re.getInt("ESTADO"));
                estadia.setCapacidad(re.getInt("CAPACIDAD"));
                lista.add(estadia);
            }
        } catch (Exception e) {
            return lista;
        }
        return lista;

    }
}
