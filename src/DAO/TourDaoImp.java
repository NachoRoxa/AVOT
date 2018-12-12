/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Agente;
import DTO.Alumno;
import DTO.Apoderado;
import DTO.Tour;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class TourDaoImp implements BaseDao<Tour> {

    @Override
    public boolean insertar(Tour dto) {
        Conexion obj = new Conexion();
        try
        {
            Connection con = obj.getConnection();
            String sql="{call PR_AGREGAR_TOUR(?,?,?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setString(1, dto.getDescripcion());
            proc.setString(2, dto.getAgente().getRun());
            proc.setDate(3, (Date) dto.getFecha_inicio());
            proc.setDate(4, (Date) dto.getFechaTermino());
            proc.executeQuery();            
            return true;
        }catch(Exception ex)
        {
            System.out.println("Ocurrio un problema con el procedimiento, intente mas tarde o comuniquese con el administrador.");
            return false;
        }
    }

    @Override
    public Tour buscar(Tour dto) {
        Tour tour = new Tour();
        try {
            CONEXION.Conexion obj = new Conexion();
            Connection con = obj.getConnection();
            String sql = "{call PR_GET_TOUR(?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", dto.getId_tour());
            ResultSet re = proc.executeQuery();
            while (re.next()) {
                tour.setId_tour(re.getInt("ID TOUR"));
                tour.setValor_total(re.getInt("VALOR TOTAL"));
                tour.setDescripcion(re.getString("DESCRIPCION"));
                tour.setNumero_contrato(re.getInt("NUMERO CONTRATO"));
                Agente agente = new Agente();
                agente.setRun(re.getString("AGENTE RUN"));
                tour.setAgente(agente);
                tour.setFecha_creacion(re.getDate("FECHA CREACION"));
                tour.setFecha_inicio(re.getDate("FECHA INICIO"));
                return tour;
            }
        } catch (SQLException e) {
            return tour;
        }
        return tour;
    }

    public Tour buscar(int id) {
        Tour tour = new Tour();
        try {
            CONEXION.Conexion obj = new Conexion();
            Connection con = obj.getConnection();
            String sql = "{call PR_GET_TOUR(?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", id);
            ResultSet re = proc.executeQuery();
            while (re.next()) {
                tour.setId_tour(re.getInt("ID TOUR"));
                tour.setValor_total(re.getInt("VALOR TOTAL"));
                tour.setDescripcion(re.getString("DESCRIPCION"));
                tour.setNumero_contrato(re.getInt("NUMERO CONTRATO"));
                Agente agente = new Agente();
                agente.setRun(re.getString("AGENTE RUN"));
                tour.setAgente(agente);
                tour.setFecha_creacion(re.getDate("FECHA CREACION"));
                tour.setFecha_inicio(re.getDate("FECHA INICIO"));
                return tour;
            }
        } catch (SQLException e) {
            return tour;
        }
        return tour;
    }
    
    @Override
    public boolean eliminar(Tour dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Tour dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Tour dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Tour> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select t.id_tour,t.valor_total,t.des"
                    + "cripcion,t.numero_contrato,a.nombre,a.apellido_paterno,a."
                    + "apellido_materno,t.fecha_creacion,t.fecha_inicio from tou"
                    + "rs t join agentes a on t.agentes_run = a.run");
            while (re.next()) {
                Tour tour = new Tour();
                Agente agente;
                tour.setId_tour(re.getInt(1));
                tour.setValor_total(re.getInt(2));
                tour.setDescripcion(re.getString(3));
                tour.setNumero_contrato(re.getInt(4));
                tour.setAgente(agente = new Agente());
                agente.setNombre(re.getString(5));
                agente.setApellido_paterno(re.getString(6));
                agente.setApellido_materno(re.getString(7));
                tour.setFecha_creacion(re.getDate(8));
                tour.setFecha_inicio(re.getDate(8));
                lista.add(tour);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
    
    public ArrayList<Tour> listarBox() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Tour> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select id_tour, numero_contrato from tours;");
            while (re.next()) {
                Tour tour = new Tour();
                tour.setId_tour(re.getInt(1));
                tour.setNumero_contrato(re.getInt(2));
                lista.add(tour);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }
}
