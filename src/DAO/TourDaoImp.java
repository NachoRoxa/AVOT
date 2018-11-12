/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Agente;
import DTO.Tour;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class TourDaoImp implements BaseDao<Tour> {

    @Override
    public boolean insertar(Tour dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tour buscar(Tour dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
