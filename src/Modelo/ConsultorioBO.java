package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class ConsultorioBO {
    
    private String mensaje = "";
    private ConsultorioDAO Codao = new ConsultorioDAO();

    public String agregarCoBO(Consultorio co){
       Connection con = Conexion.getConection();
        try {
            mensaje = Codao.agregarCo( con, co);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String actualizarCoBO(Consultorio co){
        Connection con = Conexion.getConection();
        try {
            mensaje = Codao.actualizarCo(con, co);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarCoBO(int id){
       Connection con = Conexion.getConection();
        try {
            mensaje = Codao.eliminarCo(con, id);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public ArrayList listarCoBO(String nom, char estado){
        ArrayList<Consultorio>lista;
        Connection con = Conexion.getConection();
        lista = Codao.listarCo(con,nom,estado);
        try{
            if(con != null){
                    con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public int getConsultorioID(){
       Connection con = Conexion.getConection();
       int id = Codao.getConsID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    
}
