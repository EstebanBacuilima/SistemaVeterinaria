package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class HorarioEmpleadosBO {
    private String mensaje = "";
    private HorarioEmpleadosDAO hedao = new HorarioEmpleadosDAO();
    
    public String agregarHorarioEmp( MHorarioEmpleados he){
        Connection conn = Conexion.getConection();
        try {
            mensaje = hedao.agregarHorarioEmp(conn, he);
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
    
    public String modificarHorarioEmp(MHorarioEmpleados he, int id_horariohe){
            Connection conn = Conexion.getConection();
        try {
            mensaje = hedao.modificarHorarioEmp(conn, he, id_horariohe);
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
    
    public String eliminarHorarioEmp(int id_horarioemp){
            Connection conn = Conexion.getConection();
        try {
            mensaje = hedao.eliminarHorarioEmp(conn, id_horarioemp);
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
    
    public void listarHorarioEmp(JTable table, String apellido){
       Connection conn = Conexion.getConection();
       hedao.listarHorarioEmp(conn, table, apellido);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void eliminados(JTable table){
       Connection conn = Conexion.getConection();
       hedao.eliminados(conn, table);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void mostrarmedico(JTable tabla_med, String cedula) {
        Connection conn = Conexion.getConection();
        hedao.mostrarmedico(conn, tabla_med, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarHorario(JTable table, String dia){
       Connection conn = Conexion.getConection();
       hedao.listarHorario(conn, table, dia);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getIncreID(){
       Connection conn = Conexion.getConection();
       int id = hedao.getIncreID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
     public void TraerDatosAuto(ArrayList name, String datos) {
        Connection conn = Conexion.getConection();
        hedao.TraerDatosAuto(conn, name, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     public void TraerDatosAutoHo(ArrayList hora, String datos) {
        Connection conn = Conexion.getConection();
        hedao.TraerDatosAutoHo(conn, hora, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
    public void TraerDatosAutoHoEmp(ArrayList he, String datos) {
        Connection conn = Conexion.getConection();
        hedao.TraerDatosAutoHoEmp(conn, he, datos);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean validarRepetido(String id_servicio, String horaInicio, String horafin,String dia){      
        boolean verificar = false;
        
        Connection conn = Conexion.getConection();
        try {    
            if ( hedao.validacionNoRepetidos(conn, id_servicio, horaInicio, horafin,dia) == true) {
                verificar = true;
            } else {
                verificar = false;
            }
           
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println("Error " + e);
            }
        }
        return verificar;
    }
}
