package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;

public class PropietaroBO {

    private String mensaje = "";
    private PropietarioDAO hdao = new PropietarioDAO();

    public String agregarPropietario(Propietario p, String cedula) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarPropietario(con, p,cedula);
        } catch (Exception e) {
            mensaje = mensaje + " " + e.getMessage();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                mensaje = mensaje + " " + e.getMessage();
            }
        }
        return mensaje;
    }

    public String modificarPropietario(Propietario p, String cedula) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarPropietario(con, p, cedula);
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

    public String eliminarPropietario(String codigo_pro) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarPropietario(con, codigo_pro);
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

    public void listarPropietarios(JTable table, String cedula) {

        Connection con = Conexion.getConection();
        hdao.mostrardatos(con, table, cedula);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getPersonaID() {
        Connection con = Conexion.getConection();
        int id = hdao.getPersonaID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public int getProID() {
        Connection con = Conexion.getConection();
        int id = hdao.getProID(con);
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

    // Historial
    public void mostrardatosHistorial(String clave, int id_mascota, JLabel cedula, JLabel nombres, JLabel correo, JLabel direc, JLabel telf) {

        Connection conn = Conexion.getConection();
        hdao.mostrardatosHistorial(conn, clave, id_mascota, cedula, nombres, correo, direc, telf);
        try {
            conn.close();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
        }

    }

    public void ReportePropietario(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReportePropietari(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void ReportePropietarioEliinados(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReportePropietariEliminados(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
