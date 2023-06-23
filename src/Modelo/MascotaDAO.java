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
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class MascotaDAO {

    private String mensaje = "";

    // =========== METODO REGISTRAR ===========
    public String agregarPaciente(Connection con, Mascota p) {

        PreparedStatement pstp = null;

        String sql = "INSERT INTO mascota(mascota_id,propietario_id,mascota_nombre,mascota_edad,mascota_peso,mascota_sexo,mascota_especie,mascota_raza,mascota_tamaño,mascota_observaciones,mascota_imagen,mascota_clave,estado) "
                + "VALUES (?,?,Initcap(?),?,?,Initcap(?),Initcap(?),Initcap(?),Initcap(?),Initcap(?),?,?,'A')";

        try {
            pstp = con.prepareStatement(sql);

            pstp.setInt(1, p.getId_mascota());
            pstp.setInt(2, p.getId_propietario());
            pstp.setString(3, p.getNombre_pac());
            pstp.setInt(4, p.getEdad());
            pstp.setInt(5, p.getPeso());
            pstp.setString(6, p.getSexo());
            pstp.setString(7, p.getEspecie());
            pstp.setString(8, p.getRaza());
            pstp.setString(9, p.getTamaño());
            pstp.setString(10, p.getObservaciones());
            pstp.setString(11, p.getImagene());
            pstp.setString(12, p.getMascota_clave());

            mensaje = "REGISTRADO EXITOSAMENTE";
            pstp.execute();
            pstp.close();

        } catch (SQLException e) {
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }//------------ FIN REGISTRAR ------------

    // =========== METODO ACTUALIZAR ===========
    public String modificarPaciente(Connection conn, Mascota p, String clave) {

        PreparedStatement pstp = null;
        String sql = "UPDATE mascota SET mascota_nombre = ?,mascota_edad = ?, mascota_peso = ?, mascota_sexo = ?, mascota_especie = ?, mascota_raza = ?, mascota_tamaño = ?, mascota_observaciones = ?, mascota_imagen = ? WHERE mascota_clave = '" + clave + "'";
        try {
            pstp = conn.prepareStatement(sql);

            pstp.setString(1, p.getNombre_pac());
            pstp.setInt(2, p.getEdad());
            pstp.setInt(3, p.getPeso());
            pstp.setString(4, p.getSexo());
            pstp.setString(5, p.getEspecie());
            pstp.setString(6, p.getRaza());
            pstp.setString(7, p.getTamaño());
            pstp.setString(8, p.getObservaciones());
            pstp.setString(9, p.getImagene());

            mensaje = "MODIFICADO EXITOSAMENTE";
            pstp.executeUpdate();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    //----------------- ELIMINAR -------------------------------
    public String eliminarPaciente(Connection conn, String clave) {
        PreparedStatement ps = null;
        String sql = "UPDATE mascota SET estado = 'I' WHERE mascota_clave = '" + clave + "'";
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

    // -------------------- TRAER DATOS A UNA TABLA --------------------------
    void mostrardatos(Connection con, JTable Tablas_Pro, String clave) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CLAVE");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("EDAD");
        modelo.addColumn("PESO");
        modelo.addColumn("SEXO");
        modelo.addColumn("ESPECIE");
        modelo.addColumn("RAZA");
        modelo.addColumn("TAMAÑO");
        modelo.addColumn("OBSERVACIONES");
        modelo.addColumn("FOTO");

        Tablas_Pro.setModel(modelo);
        Tablas_Pro.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(0).setPreferredWidth(10);

        Tablas_Pro.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(2).setResizable(false);

        Tablas_Pro.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(3).setPreferredWidth(20);
        Tablas_Pro.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(4).setPreferredWidth(22);
        Tablas_Pro.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(5).setPreferredWidth(22);

        Tablas_Pro.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(8).setResizable(false);

        Tablas_Pro.getColumnModel().getColumn(9).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(9).setPreferredWidth(200);

        Tablas_Pro.getColumnModel().getColumn(10).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(10).setPreferredWidth(1);

        String sql = "";

        if (clave.equals("")) {

            sql = "SELECT P.mascota_id,P.mascota_clave, P.mascota_nombre,P.mascota_edad,P.mascota_peso,P.mascota_sexo,P.mascota_especie,P.mascota_raza,P.mascota_tamaño,P.mascota_observaciones, P.mascota_imagen FROM mascota P, propietario Pr WHERE P.propietario_id = Pr.propietario_id AND P.estado = 'A' ORDER BY P.mascota_id ASC";

        } else {

            sql = "SELECT P.mascota_id,P.mascota_clave, P.mascota_nombre,P.mascota_edad,P.mascota_peso,P.mascota_sexo,P.mascota_especie,P.mascota_raza,P.mascota_tamaño,P.mascota_observaciones, P.mascota_imagen FROM mascota P, propietario Pr WHERE P.mascota_clave LIKE '%" + clave + "%'" + " AND P.propietario_id = Pr.propietario_id AND P.estado = 'A' ORDER BY P.mascota_id ASC";
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

    public int getProID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(propietario_id) FROM propietario";
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

    public int getpaciID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(mascota_id) FROM mascota";
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

    // AUTOCOMPLETAR
    public void TraerDatosAuto(ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT * FROM mascota";
        Connection conn = Conexion.getConection();
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("mascota_clave");
                // Añadimos todo al Array
                name.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }

    public void ReporteMascota(Connection conn, JButton boton) {
        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteMascotas.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setTitle("Reporte Mascotas");
            jv.setVisible(true);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }

    public void ReporteMascotaEliminadas(Connection conn, JButton boton) {
        try {
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteMascotasEliminados.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }

}
