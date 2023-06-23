
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author ediss
 */
public class AgendaCitasBO {
     private String mensaje = "";
    AgendaCitasDAO acdao = new  AgendaCitasDAO();
    Conexion Conexion = new Conexion();
    Connection con;
    
    
    public int ContarcitasBO(String estado,int id, String templ, String fecha){
        int num=0;
        con = Conexion.getConection();
        try {
            num = acdao.ContarcitasDAO( con, estado,id,templ,fecha);
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
        return num;
    }
    
    public void mostrarCitasBO(JTable tagenda, String estado,int id, String templ, String fecha){
                con = Conexion.getConection();
        try {
            acdao.mostrarCitasDAO( con,tagenda,estado,id,templ, fecha);
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
    }
    
    public void cancelarCitaBO(int idcita ){
        con = Conexion.getConection();
        try {
           acdao.cancelarCitaDAO( con, idcita);
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
    }
    
    public void atenderCitaBO(int idcita ){
        con = Conexion.getConection();
        try {
           acdao.atenderCitaDAO( con, idcita);
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
    }
    
    public int extraeridmedicoBO(int idc){
        int idm=0;
        con = Conexion.getConection();
        try {
           idm=acdao.extraeridmedicoDAO( con, idc);
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
        
        return idm;
    }
    public void horasatencionBO(JComboBox h, int idm,String dia){
   
        con = Conexion.getConection();
        acdao.horasatencionDAO(con,h,idm,dia);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void reagendarCitaBO(int id, String fecha, String hora){
        con = Conexion.getConection();
        acdao.reagendarCitaDAO(con,id,fecha,hora);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } 
    }

}
