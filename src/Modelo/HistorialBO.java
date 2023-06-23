/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTable;

public class HistorialBO {
    private String mensaje = "";
    private HistorialDAO hdao = new HistorialDAO();    
    
    // ACTUALES
    
    public void listarMedicoAc(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosMedAc(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    public void listarAuxiliarAc(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosAuxAct(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
        public void listarSecreatariaAc(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosSecretariaAct(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    public void listarPropietariosAc(JTable table, String cedula){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatosPropAct(con, table, cedula);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarPacientesAct(JTable table, String clave){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatosPaAct(con,table, clave);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

        public String eliminarMedico(Medico m, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarMedico(con, m, cedula);
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
   
    public String eliminarAuxiliar(Auxiliar a, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarAuxiliar(con, a, cedula);
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


        public String eliminarSecretaria(Secretaria p, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarSecretaria(con, p, cedula);
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
    

        public String eliminarPropietario(Propietario p, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarPropietario(con, p, cedula);
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
    

        public String eliminarPaciente(Mascota p, String clave){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarPaciente(con, p, clave);
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
    
    
    // ELIMINADOS

    public void listarMedico(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosMed(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }    

    public void listarAuxiliar(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosAux(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    
    public void listarSecreataria(JTable table, String cedula){
        
       Connection conn = Conexion.getConection();
       hdao.mostrardatosSecretaria(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    } 
    public void listarPropietarios(JTable table, String cedula){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatosProp(con, table, cedula);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void listarPacientes(JTable table, String clave){
        
       Connection con = Conexion.getConection();
       hdao.mostrardatosPa(con,table, clave);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    //RESTAURAR MEDICO
        public String RestaurarMedico(Medico m, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.RestaurarMedico(con, m, cedula);
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
    //RESTAURAR AUXILIAR    
    public String RestaurarAuxiliar(Auxiliar a, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.RestaurarAuxiliar(con, a, cedula);
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

    //RESTAURAR SECRETARIA
        public String RestaurarSecretaria(Secretaria p, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.RestaurarSecretaria(con, p, cedula);
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
    
    //RESTAURAR PROPIETARIO
        public String RestaurarPropietario(Propietario p, String cedula){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.RestaurarPropietario(con, p, cedula);
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
    
    //RESTAURAR PACIENTE
        public String RestaurarPaciente(Mascota p, String clave){
            Connection con = Conexion.getConection();
        try {
            mensaje = hdao.RestaurarPaciente(con, p, clave);
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
//        
//               // AUTOCOMPLETAR  BO
//    public void TraerDatosAuto(ArrayList name, String datos) {
//
//        Connection conn = Conexion.getConection();
//        hdao.TraerDatosAuto(conn, name, datos);
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
}