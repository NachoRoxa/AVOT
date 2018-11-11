/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.EmpresaTransporte;
import DTO.Viaje;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class ViajeDaoImp implements BaseDao{

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
        ArrayList<Viaje> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select va.id_viaje,va.origen,va.dest"
                    + "ino,va.costo,va.estado,et.nombre_empresa from viajes va "
                    + "join empresas_transporte et on va.EMP_TRANS_ID_TRANSPORTE"
                    + " = et.ID_TRANSPORTE");
            while (re.next()) {
                Viaje viaje = new Viaje();
                EmpresaTransporte empt;
                viaje.setId_viaje(re.getInt(1));
                viaje.setOrigen(re.getString(2));
                viaje.setDestino(re.getString(3));
                viaje.setCosto(re.getInt(4));
                viaje.setEstado(re.getInt(5));
                viaje.setEmpresa_transporte(empt = new EmpresaTransporte());
                empt.setNombre_empresa(re.getString(6));
                lista.add(viaje);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
        
    }
    
}
