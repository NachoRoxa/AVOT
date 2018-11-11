/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Colegio;
import DTO.Curso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class CursoDaoImp implements BaseDao{

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
        ArrayList<Curso> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("select cur.id_curso,cur.monto_recau"
                    + "dado,co.nombre,cur.descripcion from cursos cur join cole"
                    + "gios co on cur.colegios_id_colegio = co.id_colegio");
            while (re.next()) {
                Curso curso = new Curso();
                Colegio col;
                curso.setId_curso(re.getInt(1));
                curso.setMonto_recaudado(re.getInt(2));
                curso.setColegio(col = new Colegio());
                col.setNombre(re.getString(3));
                curso.setDescripcion(re.getString(4));
                lista.add(curso);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
        
    }
    
}
