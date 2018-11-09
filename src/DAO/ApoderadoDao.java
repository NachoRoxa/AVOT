/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.Apoderado;
import java.util.ArrayList;
/**
 *
 * @author cetecom
 */
public interface ApoderadoDao extends BaseDao<Apoderado> {
    ArrayList<Apoderado> ListarPorColegio(String colegio);
}
