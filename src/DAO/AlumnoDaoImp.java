/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Alumno;
import DTO.Apoderado;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Seba
 */
public class AlumnoDaoImp implements BaseDao<Alumno> {

    @Override
    public boolean insertar(Alumno dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Alumno buscar(Alumno dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(Alumno dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modificar(Alumno dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existe(Alumno dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList listar() {
        CONEXION.Conexion obj = new Conexion();
        ArrayList<Alumno> lista = new ArrayList<>();
        try {
            Connection con = obj.getConnection();
            Statement st = con.createStatement();
            ResultSet re = st.executeQuery("SELECT a.run,a.nombre,a.apellido_paterno,a.apellido_materno,a.monto_personal,ap.nombre,ap.apellido FROM ALUMNOS A JOIN APODERADOS AP ON A.APODERADOS_RUN = AP.RUN");
            while (re.next()) {
                Alumno alumno = new Alumno();
                Apoderado a;
                alumno.setRun(re.getString(1));
                alumno.setNombre(re.getString(2));
                alumno.setApellido_paterno(re.getString(3));
                alumno.setApellido_materno(re.getString(4));
                alumno.setMonto_personal(re.getInt(5));
                alumno.setApoderado(a = new Apoderado());
                a.setNombre(re.getString(6));
                a.setApellido(re.getString(7));
                lista.add(alumno);
            }

        } catch (Exception e) {
            return lista;
        }
        return lista;
    }   
}
