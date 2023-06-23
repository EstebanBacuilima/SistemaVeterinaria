package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class AuxiliarBO {
    
    private String mensaje = "";
    private AuxiliarDAO hdao = new AuxiliarDAO();

//AGREGAR AUXILIAR    
    public String agregarAuxiliar(Auxiliar a, String cedula){
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarAuxiliar(con, a, cedula);
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
//MODIFICAR AUXILIAR    
    public String modificarAuxiliar(Auxiliar a, String cedula, int auxiliar_id){
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarAuxiliar(con, a, cedula , auxiliar_id);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }
 //ELIMINAR AUXILIAR   
    public String eliminarAuxiliar(String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarAuxiliar(con, cedula);
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
 //LISTAR AUXILIAR   
    public void listarAuxiliar(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatos(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
//ID INCREMENTAL    
    public int getPersonaID(){
       Connection conn = Conexion.getConection();
       int id = hdao.getPersonaID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
     public int getAuxID(){
       Connection con = Conexion.getConection();
       int id = hdao.getAuxID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
     public void mostrarserviciosBO(JComboBox ComboServicio) {
        Connection con = Conexion.getConection();
        hdao.mostrarserviciosDAO(con, ComboServicio);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int mostraridservicioBO(String nom) {
        Connection con = Conexion.getConection();
        int id = hdao.mostraridservicioDAO(con, nom);
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
        public void ReporteAuxiliar(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteAuxiliar(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
          public void ReporteAuxiliaresEliminados(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteAuxiliaresEliminados(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
