/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Estadia;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class EstadiaDaoImp implements BaseDao {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Estadia> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_estadia,nombre,direccion,costo_por_dia,estado,capatidad from estadias");
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
    
}
