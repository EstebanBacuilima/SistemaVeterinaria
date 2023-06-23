package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;

public class SecretariaBO {
    
    private String mensaje = "";
    private SecretariaDAO hdao = new SecretariaDAO();
    
    public String agregarSecretaria(Secretaria p){
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarSecretaria(con, p);
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
    
    public String modificarSecretaria(Secretaria p, String cedula, int id_secre){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarSecretaria(con, p, cedula, id_secre);
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
    
    public String eliminarSecretaria(String id_secre){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarSecretaria(con, id_secre);
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
    
    public void listarSecretaria(JTable table, String cedula){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatos(con, table, cedula);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getPersonaID(){
       Connection con = Conexion.getConection();
       int id = hdao.getPersonaID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public int getSecretariaID(){
       Connection con = Conexion.getConection();
       int id = hdao.getSecretariaID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    // AUTOCOMPLETAR 
    public void TraerDatosAuto(ArrayList name, String datos) {

        Connection conn = Conexion.getConection();
        hdao.TraerDatosAuto(conn, name, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    // REPORTES
    public void ReporteSecre(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteSecre(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
     public void ReporteSecreEliminados(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteSecreEliminados(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
