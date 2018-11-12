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
public class ViajeDaoImp implements BaseDao<Viaje>{

    @Override
    public boolean insertar(Viaje dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Viaje buscar(Viaje dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Viaje dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Viaje dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Viaje dto) {
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
