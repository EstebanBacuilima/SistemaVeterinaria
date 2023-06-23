package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class UsuariosBO {
    private String mensaje = "";
    private UsuariosDAO udao = new UsuariosDAO();
    
    public String agregarUsuario(MUsuarios u, String usuario){
        Connection conn = Conexion.getConection();
        try {
            mensaje = udao.agregarUsuario(conn, u, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String modificarUsuario(MUsuarios u, String usuario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = udao.modificarUsuario(conn, u, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    public String inactivar(String usuario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = udao.inactivo(conn, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String reactivar(String usuario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = udao.Reactivar(conn, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarUsuario(String usuario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = udao.eliminarUsuario(conn, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarUsuario(JTable table,String cedula){
       Connection conn = Conexion.getConection();
       udao.listarUsuario(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void eliminados(JTable table){
       Connection conn = Conexion.getConection();
       udao.eliminados(conn, table);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void mostrarsecretaria(JTable Tablas_Pro, String cedula) {
        Connection conn = Conexion.getConection();
        udao.mostrarsecretaria(conn, Tablas_Pro, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    public void mostrarmedico(JTable tabla_med, String cedula) {
        Connection conn = Conexion.getConection();
        udao.mostrarmedico(conn, tabla_med, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getIncreID(){
       Connection conn = Conexion.getConection();
       int id = udao.getIncreID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void TraerDatosAutoUser(ArrayList user, String datos) {
        Connection conn = Conexion.getConection();
        udao.TraerDatosAutoUser(conn, user, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void TraerDatosAutoMedico(ArrayList cedula, String datos) {
        Connection conn = Conexion.getConection();
        udao.TraerDatosAutoMedico(conn, cedula, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void TraerDatosAutoSecretaria(ArrayList cedula, String datos) {
        Connection conn = Conexion.getConection();
        udao.TraerDatosAutoSecretaria(conn, cedula, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
