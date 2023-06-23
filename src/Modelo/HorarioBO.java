package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class HorarioBO {
    private String mensaje = "";
    private HorarioDAO hdao = new HorarioDAO();
    
    public String agregarHorario(MHorario h){
        Connection conn = Conexion.getConection();
        try {
            mensaje = hdao.agregarHorario(conn, h);
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
    
    public String modificarHorario(MHorario h){
            Connection conn = Conexion.getConection();
        try {
            mensaje = hdao.modificarHorario(conn, h);
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
    
    public String eliminarHorario(int id_horario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = hdao.eliminarHorario(conn, id_horario);
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
    
    public void listarHorario(JTable table, String dia){
       Connection conn = Conexion.getConection();
       hdao.listarHorario(conn, table, dia);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void eliminados(JTable table){
       Connection conn = Conexion.getConection();
       hdao.eliminados(conn, table);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getIncreID(){
       Connection conn = Conexion.getConection();
       int id = hdao.getIncreID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    public void TraerDatosAutoHorario(ArrayList horario, String datos) {
        Connection conn = Conexion.getConection();
        hdao.TraerDatosAutoHorario(conn, horario, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
