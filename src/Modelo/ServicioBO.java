package Modelo;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class ServicioBO {
    
    private String mensaje = "";
    private ServiciosDAO Sdao = new ServiciosDAO();
;
    
    public String agregarSBO(Servicio s){
       Connection con = Conexion.getConection();
        try {
            mensaje = Sdao.agregarS( con, s);
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
    
    public String actualizarSBO(Servicio s){
      Connection con = Conexion.getConection();
        try {
            mensaje = Sdao.actualizarS(con, s);
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
    
    public String eliminarSBO(int id){
        Connection con = Conexion.getConection();
        try {
            mensaje = Sdao.eliminarS(con, id);
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
    
    public ArrayList listarSBO(String nom, char estado){
        ArrayList<Servicio>lista;
        Connection con = Conexion.getConection();
        lista = Sdao.listarS(con,nom,estado);
        try{
            if(con != null){
                    con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }

    public int getSerID(){
       Connection con = Conexion.getConection();
       int id = Sdao.getSerID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    
}
