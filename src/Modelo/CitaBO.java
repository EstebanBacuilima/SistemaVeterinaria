package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class CitaBO {
    
    private String mensaje = "";
    private CitaDAO Cidao = new CitaDAO();
    Conexion Conexion = new Conexion();
    Connection con;
//    
    public String agregarCBO(Cita c){
        con = Conexion.getConection();
        try {
            mensaje = Cidao.agregarC( con, c);
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
    
    public void mostrar_datos_extBO (JTable Tlista, String dato, int num){
        con = Conexion.getConection();
        try {
             Cidao.mostrar_datos_ext(con, Tlista,dato, num);
//            mensaje = Sdao.actualizarS(con, s);
        } catch (Exception e) {
//            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
//                mensaje = mensaje + " " +e.getMessage();
            }
        }
    }
    
    public String traerprecioBO(int ids){
        String precio="";
        con = Conexion.getConection();
        try {
             precio=Cidao.traerprecioDAO(con, ids);
//            mensaje = Sdao.actualizarS(con, s);
        } catch (Exception e) {
//            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
//                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return precio;
    }
    
    public Persona datosdueñoBO(int idd){
        Persona Pfac = new Persona();
        con = Conexion.getConection();
        try {
             Pfac=Cidao.datosdueñoDAO(con, idd);
//            mensaje = Sdao.actualizarS(con, s);
        } catch (Exception e) {
//            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(con != null){
                    con.close();
                }
            } catch (Exception e) {
//                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return Pfac;
    }
    
    
//    public String listardueñoBO(String ced){
//        con = Conexion.getConnection();
//        try {
//            String nombre;
//            nombre = Cidao.listardueñoDAO(con, ced);
////            mensaje = Sdao.actualizarS(con, s);
//        } catch (Exception e) {
////            mensaje = mensaje + " " +e.getMessage();
//        }finally{
//            try {
//                if(con != null){
//                    con.close();
//                }
//            } catch (Exception e) {
////                mensaje = mensaje + " " +e.getMessage();
//            }
//        }
//        return mensaje;
//    }
//    
    public void listarCBO(JTable tabla,String nom, char estado){
        ArrayList<Cita>lista;
        con = Conexion.getConection();
        System.out.println(""+estado);
        Cidao.listarCitas(con,tabla,nom,estado);
        try{
            if(con != null){
                    con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public Cita listarporidCBO(int id){
        Cita datosc = new Cita();
        con = Conexion.getConection();
        datosc = Cidao.listarporidDAO(con,id);
        try{
            if(con != null){
                    con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return datosc;
    }
//    
    public int getCitaIDBO(){
       con = Conexion.getConection();
       int id = Cidao.getCitaID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    public void mostrarserviciosBO(JComboBox ComboServicio){
       con = Conexion.getConection();
       Cidao.mostrarserviciosDAO(con,ComboServicio);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void mostrarveterinarioBO(JComboBox ComboVeteri, String nomservicio){
       con = Conexion.getConection();
       Cidao.mostrarveterinarioDAO(con,ComboVeteri,nomservicio);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }  
    public int mostraridservicioBO(String nom){
        con = Conexion.getConection();
        int id = Cidao.mostraridservicioDAO(con,nom);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    public int mostraridveteriBO(int ids, String nomv){
        int id=0;
        con = Conexion.getConection();
        id = Cidao.mostraridveteriDAO(con,ids,nomv);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    
    
    public String[] mostraridnomconsutorioBO(int id){
        String[] datos = new String[3];
        con = Conexion.getConection();
        datos = Cidao.mostraridnomconsutorioDAO(con,id);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return datos;
    }
    
    public void horasatencionBO(JComboBox h, int idm,String dia){
   
        con = Conexion.getConection();
        Cidao.horasatencionDAO(con,h,idm,dia);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int verificarhoraBO(int id,String hora,String fecha){
        int num=0;
        con = Conexion.getConection();
        num=Cidao.verificarhoraDAO(con,id,hora,fecha);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return num;
    }
    public int getIDFacturaBO(){
       con = Conexion.getConection();
       int id = Cidao.getIDFacturaDAO(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }
    public String agregarFacturaBO(CFactura f){
        con = Conexion.getConection();
        try {
            mensaje = Cidao.agregarFacturaDAO( con, f);
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
    
    // IMPRESIONEs
    public void mostrarF(String num ){
        Connection con = Conexion.getConection();
        Cidao.mostrarF(con, num);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void mostrarT(String num ){
        Connection con = Conexion.getConection();
        Cidao.mostrarT(con, num);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
