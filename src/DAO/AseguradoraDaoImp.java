/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Aseguradora;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class AseguradoraDaoImp implements BaseDao<Aseguradora>{

    @Override
    public boolean insertar(Aseguradora dto) {
        Conexion con = new Conexion();
        try{
            Connection co = con.getConnection();
            String query = "{call PR_AGREGAR_ASEGURADORA(?,?,?)}";
            CallableStatement proc = co.prepareCall(query);
            proc.setString(1, dto.getRut());
            proc.setString(2, dto.getNombre_aseguradora());
            proc.setString(3, dto.getDireccion());
            proc.executeQuery();
            return true;
        }
        catch(Exception ex){
            System.out.println("Ocurrio un problema con el procedimiento.");
            return false;
        }
    }

    @Override
    public Aseguradora buscar(Aseguradora dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Aseguradora dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Aseguradora dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Aseguradora dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Aseguradora> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select rut,nombre_aseguradora,direc"
                    + "cion from aseguradoras");
            while (re.next()) {
                Aseguradora aseguradora = new Aseguradora();
                aseguradora.setRut(re.getString(1));
                aseguradora.setNombre_aseguradora(re.getString(2));
                aseguradora.setDireccion(re.getString(3));
                lista.add(aseguradora);
            }
        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
}
