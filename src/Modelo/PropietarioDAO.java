package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
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

public class PropietarioDAO {
    
    //ICONO JOPTIONPANE

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    private String mensaje = "";

    // =========== METODO REGISTRAR ===========
    public String agregarPropietario(Connection con, Propietario p, String cedula)  {

        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;
        //VALIDAR VALORES REPETIDOS
        try {
            Statement stm = con.createStatement();
            String sql2 = "SELECT P.persona_cedula FROM personas P, propietario Pr WHERE P.persona_id = Pr.persona_id AND P.persona_cedula = '" + cedula + "'";
            ResultSet rs = stm.executeQuery(sql2);
            if (rs.next()) {
                mensaje = "CEDULA EXISTENTE";
            } else {
                String sql = "INSERT INTO personas(persona_id, persona_cedula , persona_Pri_nombre,persona_Seg_nombre, persona_Pat_apellido,persona_Mat_apellido, persona_fecha_nacimiento, persona_correo, persona_direccion, persona_genero, persona_telefono, persona_movil) "
                        + "VALUES (?,?,Initcap(?),Initcap(?),Initcap(?),Initcap(?),?,?,?,?,?,?)";
                String sqlp2 = "INSERT INTO propietario(propietario_id,persona_id, estado) VALUES (?,?,'A')";

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

                    pstp2.setInt(1, p.getId_propietario());
                    pstp2.setInt(2, p.getPersona_id());

                    mensaje = "REGISTRADO EXITOSAMENTE";
                    pstp.execute();
                    pstp.close();
                    pstp2.execute();
                    pstp2.close();
                } catch (SQLException e) {
                    mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
                }
            }
        } catch (SQLException ex) {
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + ex.getMessage();
        }

        return mensaje;
    }//------------ FIN REGISTRAR ------------

    // =========== METODO ACTUALIZAR ===========
    public String modificarPropietario(Connection conn, Propietario p, String cedula) {
        PreparedStatement pstp = null;
        String sql = "UPDATE personas SET persona_Pri_nombre = ?,persona_Seg_nombre = ?, persona_Pat_apellido = ?, persona_Mat_apellido = ?, persona_fecha_nacimiento = ?, persona_correo = ?, persona_direccion = ?, persona_genero = ?, persona_telefono = ?, persona_movil = ? WHERE persona_cedula = '" + cedula + "'";
        try {
            pstp = conn.prepareStatement(sql);

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

            mensaje = "MODIFICADO EXITOSAMENTE";
            pstp.executeUpdate();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPropietario(Connection conn, String codigo) {
        PreparedStatement ps = null;
        String sql = "UPDATE propietario SET estado = 'I' WHERE propietario_id = '" + codigo + "'";
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
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");

        Tablas_Pro.setModel(modelo);
        
        Tablas_Pro.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Pro.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tablas_Pro.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(3).setPreferredWidth(30);
        Tablas_Pro.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(8).setPreferredWidth(15);
        String sql = "";

        if (cedula.equals("")) {

            sql = "SELECT Pr.propietario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD') FROM personas P, propietario Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

        } else {

            sql = "SELECT Pr.propietario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD') FROM personas P, propietario Pr WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

        }

        String[] datos = new String[9];

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

                modelo.addRow(datos);
            }
            Tablas_Pro.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "Encontrado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

    // AUTOCOMPLETAR
    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.persona_cedula FROM personas P, propietario Pr WHERE P.persona_id = Pr.persona_id";
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

    // DATOS PARA EL HISTORIAL CLINICO 
    void mostrardatosHistorial(Connection con, String clave, int id_mascota, JLabel cedula, JLabel nombres, JLabel correo, JLabel direc, JLabel telf) {

        String sql = "SELECT P.persona_cedula, P.Persona_pri_nombre||' '|| P.Persona_seg_nombre ||' '|| P.PERSONA_PAT_APELLIDO||' '|| P.PERSONA_MAT_APELLIDO, P.Persona_correo, P.persona_direccion, P.Persona_telefono FROM PERSONAS P, Propietario Pro, mascota M WHERE Pro.persona_id = P.persona_id AND M.propietario_id = Pro.propietario_id AND M.mascota_id = '" + id_mascota + "' AND M.mascota_clave = '" + clave + "'";
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cedula.setText(rs.getString(1));
                nombres.setText(rs.getString(2));
                correo.setText(rs.getString(3));
                direc.setText(rs.getString(4));
                telf.setText(rs.getString(5));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }

    public void ReportePropietari(Connection conn, JButton boton) {
        
        try {
            //JasperReport report = JasperCompileManager.compileReport("D:\\Programas NetBeans\\ProyectoTercerCliclo\\src\\Reportes\\ReprotePropietarios.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReprotePropietarios.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }
    
    public void ReportePropietariEliminados(Connection conn, JButton boton) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("D:\\Programas NetBeans\\ProyectoTercerCliclo\\src\\Reportes\\ReprotePropietariosEliminados.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReprotePropietariosEliminados.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }
}
