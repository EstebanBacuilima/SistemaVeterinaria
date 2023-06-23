package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class MedicoDAO {

    private String mensaje = "";

    // =========== METODO REGISTRAR ===========
    public String agregarMedico(Connection con, Medico m, String cedula) {

        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;
        String sql = "INSERT INTO personas(persona_id, persona_cedula ,persona_Pri_nombre,persona_Seg_nombre,persona_Pat_apellido,persona_Mat_apellido, persona_fecha_nacimiento, persona_correo,persona_direccion, persona_genero, persona_telefono, persona_movil) VALUES (?,?,Initcap(?),Initcap(?),Initcap(?),Initcap(?),?,?,Initcap(?),?,?,?)";
        String sqlp2 = "INSERT INTO veterinario(veterinario_id,persona_id,profesion,servicios_id,area_id,imagen,estado) VALUES (?,?,Initcap(?),?,?,?,'A')";

        try {
            pstp = con.prepareStatement(sql);
            pstp2 = con.prepareStatement(sqlp2);

            pstp.setInt(1, m.getPersona_id());
            pstp.setString(2, m.getCedula());
            pstp.setString(3, m.getPri_nombre());
            pstp.setString(4, m.getSeg_nombre());
            pstp.setString(5, m.getPat_apellido());
            pstp.setString(6, m.getMat_apellido());
            pstp.setDate(7, java.sql.Date.valueOf(m.getFecha_nacimiento()));
            pstp.setString(8, m.getCorreo());
            pstp.setString(9, m.getDireccion());
            pstp.setString(10, m.getGenero());
            pstp.setString(11, m.getTelefono());
            pstp.setString(12, m.getMovil());

            pstp2.setInt(1, m.getIdMedico());
            pstp2.setInt(2, m.getPersona_id());
            pstp2.setString(3, m.getEspecialidad());
            pstp2.setInt(4, m.getServicio_id());
            pstp2.setInt(5, m.getConsultorio_id());
            pstp2.setString(6, m.getImagen());
            mensaje = "REGISTRADO EXITOSAMENTE";
            pstp.execute();
            pstp.close();
            pstp2.execute();
            pstp2.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO REGISTRAR \n " + e.getMessage();
        }

        return mensaje;
    }

    // =========== METODO ACTUALIZAR ===========
    public String modificarMedico(Connection conn, Medico m, String cedula, int IdVeterinario) {
        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;
        String sql = "UPDATE personas SET persona_Pri_nombre =Initcap(?),persona_Seg_nombre = Initcap(?), persona_Pat_apellido = Initcap(?), persona_Mat_apellido =Initcap(?), persona_fecha_nacimiento = ?, persona_correo = ?, persona_direccion = Initcap(?), persona_genero = ?, persona_telefono = ?, persona_movil = ? WHERE persona_cedula = '" + cedula + "'";
        String sql2 = "UPDATE veterinario SET profesion = Initcap(?),servicios_id = ? ,area_id = ?, imagen =? WHERE veterinario_id= '" + IdVeterinario + "'";
        try {
            pstp = conn.prepareStatement(sql);
            pstp2 = conn.prepareStatement(sql2);

            pstp.setString(1, m.getPri_nombre());
            pstp.setString(2, m.getSeg_nombre());
            pstp.setString(3, m.getPat_apellido());
            pstp.setString(4, m.getMat_apellido());
            pstp.setDate(5, java.sql.Date.valueOf(m.getFecha_nacimiento()));
            pstp.setString(6, m.getCorreo());
            pstp.setString(7, m.getDireccion());
            pstp.setString(8, m.getGenero());
            pstp.setString(9, m.getTelefono());
            pstp.setString(10, m.getMovil());

            pstp2.setString(1, m.getEspecialidad());
            pstp2.setInt(2, m.getServicio_id());
            pstp2.setInt(3, m.getConsultorio_id());
            pstp2.setString(4, m.getImagen());

            mensaje = "MODIFICADO EXITOSAMENTE";
            pstp.execute();
            pstp2.execute();
            pstp.close();
            pstp2.close();

        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO MODIFICAR \n " + e.getMessage();
        }
        return mensaje;
    }

    //----------------- ELIMINAR -------------------------------
    public String eliminarMedico(Connection conn, String cedula) {
        PreparedStatement ps = null;
        String sql = "UPDATE veterinario SET estado = 'I' WHERE veterinario_id = (SELECT veterinario_id FROM veterinario  WHERE veterinario_id=(select m.veterinario_id FROM veterinario m, personas p WHERE m.persona_id = p.persona_id AND p.persona_cedula='" + cedula + "'))";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            mensaje = "ELIMINADO EXITOSAMENTE";
            ps.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO ELIMINAR\n " + e.getMessage();
        }
        return mensaje;
    }
    //ID INCREMENTALES  

    public int getPersonaID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(persona_id)  FROM personas";
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

    public int getMedID(Connection con) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(veterinario_id) FROM veterinario";
        try {
            ps = con.prepareStatement(sql);
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

    // -------------------- TRAER DATOS A UNA TABLA --------------------------
    void mostrardatos(Connection con, JTable Tablas_Med, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES Y APELLIDOS");
        modelo.addColumn("GÉNERO");
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("PROFESIÓN");
        modelo.addColumn("ID SERVICIO");
        modelo.addColumn("NOM.SERVICIO");
        modelo.addColumn("NUM.AREA TRABAJO");
        modelo.addColumn("NOM.AREA TRABAJO");
        modelo.addColumn("FOTO");
        Tablas_Med.setModel(modelo);
        Tablas_Med.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Med.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Med.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Med.getColumnModel().getColumn(2).setPreferredWidth(200);

        String sql;
        sql = "SELECT m.veterinario_id,P.persona_cedula, P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), m.profesion,m.servicios_id, s.nombre, m.area_id , c.nombre, m.Imagen FROM personas P, veterinario m, servicios s, area_trabajo c WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND m.servicios_id = s.id_servicio AND m.area_id = c.id_area AND P.persona_id = m.persona_id AND m.estado = 'A' ORDER BY m.veterinario_id";

        String[] datos = new String[15];

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
                datos[11] = rs.getString(12);
                datos[12] = rs.getString(13);
                datos[13] = rs.getString(14);
                datos[14] = rs.getString(15);

                modelo.addRow(datos);
            }
            Tablas_Med.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Veterinario No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

    //Traer datos a combos
    public void mostrarserviciosDAO(Connection con, JComboBox ComboServicios) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT nombre FROM servicios where estado= 'A' ORDER BY nombre ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ComboServicios.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al traer los Servicios " + e);
        }
    }

    public int mostraridservicioDAO(Connection con, String nom) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        int id = 0;
        String sql = "select id_servicio from servicios where nombre='" + nom + "' and estado = 'A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al traer el idServicio " + e);
        }
        return id;
    }

    public void mostrarConsultorioDAO(Connection con, JComboBox ComboConsultorio) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select nombre from area_trabajo where estado= 'A' ORDER BY nombre ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                ComboConsultorio.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al traer las Areas de Trabajo " + e);
        }
    }

    //la consulta me da una id la cual la retornamos a la clase controlador 
    public int mostraridConsultorioDAO(Connection con, String nomC) {
        int idC = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select id_area from area_trabajo where nombre='" + nomC + "' and estado = 'A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idC = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al traer el idArea " + e);
        }
        return idC;
    }
    // AUTOCOMPLETAR

    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "select persona_cedula  from personas  where persona_id IN(select persona_id from veterinario where estado ='A')";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("persona_cedula");
                // Añadimos todo al Array
                name.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }

    public void ReporteMedic(Connection conn, JButton boton) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("C:\\Users\\edu\\Downloads\\ProyectoTercerCliclo\\src\\Reportes\\ReporteMedico.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteMedico.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }

    public void ReporteMedicosEliminados(Connection conn, JButton boton2) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("C:\\Users\\edu\\Downloads\\ProyectoTercerCliclo\\src\\Reportes\\ReporteMedicoEliminado.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteMedicoEliminado.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }
}
