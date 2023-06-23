package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class RecetaBO {
    
    private String mensaje = "";
    private RecetaDAO hdao = new RecetaDAO();
 
    // AGREGAR RECETA
    public String agregarReceta(Receta r){
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarReceta(con, r);
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
    
    // MODIFICAR RECETA
    public String modificarReceta(Receta r, String receta_id){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarReceta(con, r, receta_id);
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
    
    //ELIMINAR RECETA
    public String eliminarReceta(String receta_id){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarReceta(con, receta_id);
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
    
    // LISTAR RECETAS
    public void listarRecetas(JTable table, String receta_id){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatos(con,table, receta_id);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // ID INCREMENTAL
    public int getRecID(){
       Connection con = Conexion.getConection();
       int id = hdao.getRecID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    // AUTOCOMPLETAR  BO
    public void TraerDatosAuto(ArrayList name, String datos) {

        Connection conn = Conexion.getConection();
        hdao.TraerDatosAuto(conn, name, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    //
    public void listarRecetaHist(JTable table, int clave){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosRecetaHis(conn, table, clave);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
