/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.EmpresaTransporte;
import DTO.Viaje;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class ViajeDaoImp implements BaseDao<Viaje> {

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

    public ArrayList<Viaje> listarViajesTour(int idTour) {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Viaje> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            String sql = "{call PR_LISTAR_VIAJES_CONTRATO(?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", idTour);
            ResultSet re = proc.executeQuery();
            while (re.next()) {
                Viaje viaje = new Viaje();
                EmpresaTransporte empt;
                viaje.setId_viaje(re.getInt("ID VIAJE"));
                viaje.setOrigen(re.getString("ORIGEN"));
                viaje.setDestino(re.getString("DESTINO"));
                viaje.setCosto(re.getInt("COSTO"));
                viaje.setEstado(re.getInt("ESTADO"));
                viaje.setFechaInicio(re.getDate("FECHA INICIO"));
                viaje.setFechaInicio(re.getDate("FECHA TERMINO"));
                viaje.setEmpresa_transporte(empt = new EmpresaTransporte());
                empt.setNombre_empresa(re.getString("NOMBRE EMPRESA"));
                empt.setId_transporte(re.getInt("ID TRANSPORTE"));
                empt.setTipo_transporte("TIPO TRANSPORTE");
                lista.add(viaje);
            }
        } catch (Exception e) {
            return lista;
        }
        return lista;

    }
}
