/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Colegio;
import DTO.Curso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Seba
 */
public class CursoDaoImp implements BaseDao<Curso> {

    @Override
    public boolean insertar(Curso dto) {
        Conexion cx = new Conexion();
        try {
            Connection con = cx.getConnection();
            String sql = "{call PR_AGREGAR_CURSO(?,?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt(1, dto.getMonto_recaudado());
            proc.setObject(2, dto.getColegio().getId_colegio());
            proc.setString(3, dto.getDescripcion());            
            proc.executeQuery();
            return true;                    
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocurrio un problema con el procedimiento. Intente mas tarde");
            return false;
        }
    }

    @Override
    public Curso buscar(Curso dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Curso dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Curso dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Curso dto) {
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
