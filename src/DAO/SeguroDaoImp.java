/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Aseguradora;
import DTO.Seguro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Seba
 */
public class SeguroDaoImp implements BaseDao<Seguro> {

    @Override
    public boolean insertar(Seguro dto) {
        Conexion cx = new Conexion();
        try
        {
            Connection con = cx.getConnection();
            String sql = "{call PR_AGREGAR_SEGURO(?,?,?,?,?)}";
            CallableStatement proc=con.prepareCall(sql);
            proc.setInt(1, dto.getDias_cobertura());
            proc.setInt(2, dto.getCosto());
            proc.setString(3, dto.getDescripcion());
            proc.setInt(4, dto.getEstado());
            proc.setObject(5, dto.getAseguradora().getRut());
            proc.executeQuery();
            return true;
        }catch(Exception ex)
        {
            System.out.println("Hubo un problema con el procedimiento, intente mas tarde.");
            return false;
        }
    }

    @Override
    public Seguro buscar(Seguro dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Seguro dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Seguro dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Seguro dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Seguro> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select s.id_seguro,s.estado,s.dias_cobertura,s.descripcion,s.costo,a.nombre_aseguradora from seguros s join aseguradoras a on s.aseguradora_rut = a.rut");
            while (re.next()) {
                Seguro seguro = new Seguro();
                Aseguradora aseguradora;
                seguro.setId_seguro(re.getInt(1));
                seguro.setEstado(re.getInt(2));
                seguro.setDias_cobertura(re.getInt(3));
                seguro.setDescripcion(re.getString(4));
                seguro.setCosto(re.getInt(5));
                seguro.setAseguradora(aseguradora = new Aseguradora());
                aseguradora.setNombre_aseguradora(re.getString(6));
                lista.add(seguro);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }

    public ArrayList<Seguro> listarSegurosTour(int idTour) {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Seguro> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            String sql = "{call PR_LISTAR_SEGUROS_CONTRATO(?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", idTour);
            proc.registerOutParameter("out_list", OracleTypes.CURSOR);
            proc.executeUpdate();
            ResultSet re = (ResultSet) proc.getObject("out_list");
            while (re.next()) {
                Seguro seguro = new Seguro();
                Aseguradora aseguradora = new Aseguradora();
                seguro.setFecha_inicio(re.getDate("FECHA INICIO"));
                seguro.setFecha_termino(re.getDate("FECHA TERMINO"));
                seguro.setId_seguro(re.getInt("ID SEGURO"));
                seguro.setDias_cobertura(re.getInt("DIAS COBERTURA"));
                seguro.setCosto(re.getInt("COSTO"));
                seguro.setDescripcion(re.getString("DESCRIPCION SEGURO"));
                seguro.setEstado(re.getInt("ESTADO SEGURO"));
                aseguradora.setRut(re.getString("RUT ASEGURADORA"));
                aseguradora.setNombre_aseguradora(re.getString("NOMBRE ASEGURADORA"));
                aseguradora.setRut(re.getString("DIRECCION ASEGURADORA"));
                seguro.setAseguradora(aseguradora);
                lista.add(seguro);
            }
        } catch (Exception e) {
            return lista;
        }
        return lista;

    }
}
