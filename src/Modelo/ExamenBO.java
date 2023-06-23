package Modelo;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JTable;

public class ExamenBO {

    private String mensaje = "";
    private ExamenDAO hdao = new ExamenDAO();

    public String guardarExamen(Examen p) {
        Connection con = Conexion.getConection();
        try {
            mensaje = hdao.guardarExamen(con, p);
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

    // ID examen
    public int IdExamne() {
        Connection con = Conexion.getConection();
        int id = hdao.IdExamne(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    // TABLA EXAMENES
    public void mostrardatosExamenes(JTable Tablas_Pro, int id_mascota) {
        Connection con = Conexion.getConection();
        hdao.mostrardatos(con, Tablas_Pro, id_mascota);
        try {

            con.close();
        } catch (SQLException ex) {
            System.out.println("Error:" + ex);
        }

    }

}
