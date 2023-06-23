package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class SecretariaDAO {

    private String mensaje = "";

    // =========== METODO REGISTRAR ===========
    public String agregarSecretaria(Connection con, Secretaria p) {

        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;
        String sql = "INSERT INTO personas(persona_id, persona_cedula , persona_Pri_nombre,persona_Seg_nombre, persona_Pat_apellido,persona_Mat_apellido, persona_fecha_nacimiento, persona_correo, persona_direccion, persona_genero, persona_telefono, persona_movil) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlp2 = "INSERT INTO secretaria(secretaria_id,persona_id,numero_ventanilla,imagen,estado) VALUES (?,?,?,?,'A')";

        try {
            pstp = con.prepareStatement(sql);
            pstp2 = con.prepareStatement(sqlp2);

            pstp.setInt(1, p.getPersona_id());
            pstp.setString(2, p.getCedula());
            pstp.setString(3, p.getPri_nombre());
            pstp.setString(4, p.getSeg_nombre());
            pstp.setString(5, p.getPat_apellido());
            pstp.setString(6, p.getMat_apellido());
            pstp.setDate(7, java.sql.Date.valueOf(p.getFecha_nacimiento()));
            pstp.setString(8, p.getCorreo());
            pstp.setString(9, p.getDireccion());
            pstp.setString(10, p.getGenero());
            pstp.setString(11, p.getTelefono());
            pstp.setString(12, p.getMovil());

            pstp2.setInt(1, p.getId_secretaria());
            pstp2.setInt(2, p.getPersona_id());
            pstp2.setInt(3, p.getNumero_ventanilla());
            pstp2.setString(4, p.getImagene());

            mensaje = "REGISTRADO EXITOSAMENTE";
            pstp.execute();
            pstp.close();
            pstp2.execute();
            pstp2.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }//------------ FIN REGISTRAR ------------

    // =========== METODO ACTUALIZAR ===========
    public String modificarSecretaria(Connection conn, Secretaria p, String cedula, int id_secre) {

        PreparedStatement pstp = null;
        PreparedStatement pstp_secre = null;

        String sql = "UPDATE personas SET persona_Pri_nombre = ?,persona_Seg_nombre = ?, persona_Pat_apellido = ?, persona_Mat_apellido = ?, persona_fecha_nacimiento = ?, persona_correo = ?, persona_direccion = ?, persona_genero = ?, persona_telefono = ?, persona_movil = ? WHERE persona_cedula = '" + cedula + "'";
        String sql_Secre = "UPDATE secretaria SET numero_ventanilla = ?, imagen = ? WHERE secretaria_id ='" + id_secre + "'";

        try {
            pstp = conn.prepareStatement(sql);
            pstp_secre = conn.prepareStatement(sql_Secre);

            pstp.setString(1, p.getPri_nombre());
            pstp.setString(2, p.getSeg_nombre());
            pstp.setString(3, p.getPat_apellido());
            pstp.setString(4, p.getMat_apellido());
            pstp.setDate(5, java.sql.Date.valueOf(p.getFecha_nacimiento()));
            pstp.setString(6, p.getCorreo());
            pstp.setString(7, p.getDireccion());
            pstp.setString(8, p.getGenero());
            pstp.setString(9, p.getTelefono());
            pstp.setString(10, p.getMovil());

            pstp_secre.setInt(1, p.getNumero_ventanilla());
            pstp_secre.setString(2, p.getImagene());

            mensaje = "MODIFICADO EXITOSAMENTE";
            pstp.executeUpdate();
            pstp.close();

            pstp_secre.executeUpdate();
            pstp_secre.close();

        } catch (SQLException e) {
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarSecretaria(Connection conn, String codigo) {
        PreparedStatement ps = null;
        String sql = "UPDATE secretaria SET estado = 'I' WHERE secretaria_id = '" + codigo + "'";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ELIMINADO EXITOSAMENTE";
            ps.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA ELIMINADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public int getPersonaID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(persona_id) FROM personas";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("1.Error al mostrar id " + e.getMessage());
        }
        return id;
    }

    public int getSecretariaID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(secretaria_id) FROM secretaria";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("2.Error al mostrar id " + e.getMessage());
        }
        return id;
    }

    void mostrardatos(Connection con, JTable Tablas_Pro, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES APELLIDOS");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("CAJA");
        modelo.addColumn("FOTO");

        Tablas_Pro.setModel(modelo);
        Tablas_Pro.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(0).setPreferredWidth(10);
        Tablas_Pro.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(2).setPreferredWidth(140);
        Tablas_Pro.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(3).setPreferredWidth(32);
        Tablas_Pro.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(9).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(9).setPreferredWidth(10);
        Tablas_Pro.getColumnModel().getColumn(10).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(10).setPreferredWidth(10);

        String sql = "";

        if (cedula.equals("")) {

            sql = "SELECT Pr.secretaria_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), Pr.numero_ventanilla, Pr.imagen FROM personas P, secretaria Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

        } else {

            sql = "SELECT Pr.secretaria_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), Pr.numero_ventanilla, Pr.imagen FROM personas P, secretaria Pr WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

        }

        String[] datos = new String[11];

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);
                datos[9] = rs.getString(10);
                datos[10] = rs.getString(11);
                modelo.addRow(datos);
            }
            Tablas_Pro.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

    // AUTOCOMPLETAR
    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.persona_cedula FROM personas P, secretaria S WHERE P.persona_id = S.persona_id";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString(1);
                // Añadimos todo al Array
                name.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }

    public void ReporteSecre(Connection conn, JButton boton) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("D:\\Programas NetBeans\\ProyectoTercerCliclo\\src\\Reportes\\ReporteSecretaria.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteSecretaria.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }

    public void ReporteSecreEliminados(Connection conn, JButton boton) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("D:\\Programas NetBeans\\ProyectoTercerCliclo\\src\\Reportes\\ReporteSecretariaEliminados.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteSecretariaEliminados.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }
}
