package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JTable;

public class MascotaBO {

    private String mensaje = "";
    private MascotaDAO hdao = new MascotaDAO();

    public String agregarPaciente(Mascota p) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarPaciente(con, p);
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

    public String modificarPaciente(Mascota p, String clave) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarPaciente(con, p, clave);
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

    public String eliminarPaciente(String clave) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarPaciente(con, clave);
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

    public void listarPacientes(JTable table, String clave) {

        Connection con = Conexion.getConection();
        hdao.mostrardatos(con, table, clave);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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

    public int getpaciID() {
        Connection con = Conexion.getConection();
        int id = hdao.getpaciID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public void ReportePaciente(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteMascota(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void ReportePacienteeliminados(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteMascotaEliminadas(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
