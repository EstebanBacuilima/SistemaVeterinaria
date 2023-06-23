package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

public class AuxiliarDAO {

    private String mensaje = "";

//REGISTRAR AUXILIAR
    public String agregarAuxiliar(Connection con, Auxiliar m, String cedula) {

        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;

        String sql = "INSERT INTO personas(persona_id, persona_cedula ,persona_Pri_nombre,persona_Seg_nombre,persona_Pat_apellido,persona_Mat_apellido, persona_fecha_nacimiento, persona_correo,persona_direccion, persona_genero, persona_telefono, persona_movil) VALUES (?,?,Initcap(?),Initcap(?),Initcap(?),Initcap(?),?,?,Initcap(?),?,?,?)";
        String sqlp2 = "INSERT INTO auxiliar(auxiliar_id,persona_id,labores,servicios_id,imagen,estado) VALUES (?,?,?,?,?,'A')";
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

            pstp2.setInt(1, m.getAuxiliar_id());
            pstp2.setInt(2, m.getPersona_id());
            pstp2.setString(3, m.getLabores());
            pstp2.setInt(4, m.getId_servicio());
            pstp2.setString(5, m.getImagen());
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
//ACTUALIZAR AUXILIAR

    public String modificarAuxiliar(Connection conn, Auxiliar m, String cedula, int auxiliar_id) {
        PreparedStatement pstp = null;
        PreparedStatement pstp2 = null;
        String sql = "UPDATE personas SET persona_Pri_nombre =Initcap(?),persona_Seg_nombre = Initcap(?), persona_Pat_apellido = Initcap(?), persona_Mat_apellido =Initcap(?), persona_fecha_nacimiento = ?, persona_correo = ?, persona_direccion = Initcap(?), persona_genero = ?, persona_telefono = ?, persona_movil = ? WHERE persona_cedula = '" + cedula + "'";
        String sql2 = "UPDATE auxiliar SET labores = ? ,servicios_id = ?, imagen = ? WHERE auxiliar_id = '" + auxiliar_id + "'";
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

            pstp2.setString(1, m.getLabores());
            pstp2.setInt(2, m.getId_servicio());
            pstp2.setString(3, m.getImagen());

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
//ELIMINAR AUXILIAR

    public String eliminarAuxiliar(Connection conn, String cedula) {
        PreparedStatement ps = null;
        String sql = "UPDATE auxiliar SET estado = 'I' WHERE auxiliar_id = (SELECT auxiliar_id FROM auxiliar  WHERE auxiliar_id=(select a.auxiliar_id FROM auxiliar a, personas p WHERE a.persona_id = p.persona_id AND p.persona_cedula='" + cedula + "'))";
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

    public int getAuxID(Connection con) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(auxiliar_id) FROM auxiliar";
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

//TRAER DATOS A LA TABLA AUXILIAR
    void mostrardatos(Connection con, JTable Tablas_Aux, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES Y APELLIDOS");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("LABORES");
        modelo.addColumn("ID SERVICIO");
        modelo.addColumn("NOM.SERVICIO");
        modelo.addColumn("FOTO");
        Tablas_Aux.setModel(modelo);
        Tablas_Aux.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Aux.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Aux.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Aux.getColumnModel().getColumn(2).setPreferredWidth(200);
        String sql;
        sql = "SELECT a.auxiliar_id,P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), a.labores,a.servicios_id, s.nombre, a.Imagen FROM personas P, auxiliar a, servicios s WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = a.persona_id AND a.servicios_id = s.id_servicio AND a.estado = 'A' ORDER BY a.auxiliar_id ASC";
        String[] datos = new String[13];

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
                modelo.addRow(datos);

            }
            Tablas_Aux.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
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

    // AUTOCOMPLETAR
    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "select persona_cedula  from personas  where persona_id IN(select persona_id from auxiliar where estado ='A')";
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

    public void ReporteAuxiliar(Connection conn, JButton boton) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("C:\\Users\\edu\\Downloads\\ProyectoTercerCliclo\\src\\Reportes\\ReporteAuxiliar.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteAuxiliar.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }

    public void ReporteAuxiliaresEliminados(Connection conn, JButton boton2) {
        //JasperReport report;
        try {
            //report = JasperCompileManager.compileReport("C:\\Users\\edu\\Downloads\\ProyectoTercerCliclo\\src\\Reportes\\ReporteAuxiliarEliminado.jrxml");
            JasperReport report = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/ReporteAuxiliarEliminado.jasper"));
            Map map = new HashMap();
            map.put("Imagen", "LogoVeterinaria.png");
            JasperPrint jp = JasperFillManager.fillReport(report, map, conn);
            JasperViewer.viewReport(jp, false);

        } catch (JRException e) {
            System.out.println("Error reporte: " + e.getMessage());
        }
    }
}
