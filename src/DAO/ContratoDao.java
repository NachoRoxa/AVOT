/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import CONEXION.Conexion;
import DTO.Alumno;
import DTO.Apoderado;
import DTO.Colegio;
import DTO.Curso;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Camilo
 */
public class ContratoDao{
    public Colegio getColegiosContrato(int idTour){
        CONEXION.Conexion obj = new Conexion();
        Colegio col = new Colegio();
        Curso curso = new Curso();
        ArrayList<Alumno> alumnos = new ArrayList<>();
        boolean colCargado = false;
        boolean curCargado = false;
        
        try {
            Connection con = obj.getConnection();
            String sql = "{call PR_LISTAR_CURSO_CONTRATO(?,?)}";
            CallableStatement proc = con.prepareCall(sql);
            proc.setInt("IN_ID_TOUR", idTour);
            proc.registerOutParameter("out_list", OracleTypes.CURSOR);
            proc.executeUpdate();
            ResultSet re = (ResultSet)proc.getObject("out_list");
            while (re.next()) {
                if (!colCargado) {
                    col.setId_colegio(re.getInt("ID COLEGIO"));
                    col.setNombre(re.getString("NOMBRE COLEGIO"));
                    col.setDireccion(re.getString("DIRECCION COLEGIO"));
                    col.setRut(re.getString("RUT COLEGIO"));
                    col.setTelefono(re.getString("TELEFONO COLEGIO"));
                    colCargado = true;
                }
                if (!curCargado) {
                    curso.setId_curso(re.getInt("ID CURSO"));
                    curso.setMonto_recaudado(re.getInt("MONTO DE CURSO"));
                    curso.setDescripcion(re.getString("DESCRIPCION CURSO"));
                    curCargado = true;
                }
                Alumno alumno = new Alumno();
                Apoderado ap = new Apoderado();
                alumno.setRun(re.getString("RUN ALUMNO"));
                alumno.setNombre(re.getString("NOMBRE ALUMNO"));
                alumno.setApellido_paterno(re.getString("APELLIDO PATERNO"));
                alumno.setApellido_materno(re.getString("APELLIDO MATERNO"));
                alumno.setMonto_personal(re.getInt("MONTO PERSONAL"));
                ap.setRun(re.getString("RUN APODERADO"));
                ap.setNombre(re.getString("NOMBRE APODERADO"));
                ap.setApellido(re.getString("APELLIDO APODERADO"));
                alumno.setApoderado(ap);
                alumnos.add(alumno);
            }
            curso.setAlumnos(alumnos);
            col.setCurso(curso);
            
        } catch (Exception e) {
            return col;
        }
        return col;
    }
}
