package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class MedicoBO {

    private String mensaje = "";
    private MedicoDAO hdao = new MedicoDAO();

    public String agregarMedico(Medico m, String cedula) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.agregarMedico(con, m, cedula);
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

    public String modificarMedico(Medico m, String cedula, int idMedico) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.modificarMedico(con, m, cedula, idMedico);
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

    public String eliminarMedico(String cedula) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.eliminarMedico(con, cedula);
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

    public void listarMedico(JTable table, String cedula) {

        Connection conn = Conexion.getConection();
        hdao.mostrardatos(conn, table, cedula);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int getPersonaID() {
        Connection conn = Conexion.getConection();
        int id = hdao.getPersonaID(conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public int getMedID() {
        Connection con = Conexion.getConection();
        int id = hdao.getMedID(con);
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

    public void mostrarConsultorioBO(JComboBox ComboConsultorio) {
        Connection con = Conexion.getConection();
        hdao.mostrarConsultorioDAO(con, ComboConsultorio);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public int mostraridConsultorioBO(String nomC) {
        Connection con = Conexion.getConection();
        int idC = hdao.mostraridConsultorioDAO(con, nomC);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return idC;

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

    public void ReporteMedic(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteMedic(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void ReporteMedicosEliminados(JButton boton) {
        Connection con = Conexion.getConection();
        hdao.ReporteMedicosEliminados(con, boton);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
