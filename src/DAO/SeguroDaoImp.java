/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Aseguradora;
import DTO.Seguro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class SeguroDaoImp implements BaseDao<Seguro>{

    @Override
    public boolean insertar(Seguro dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
