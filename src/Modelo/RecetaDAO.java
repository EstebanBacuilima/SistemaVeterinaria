package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RecetaDAO {

    private String mensaje = "";

    //  REGISTRAR
    public String agregarReceta(Connection con, Receta r) {

        PreparedStatement pstp = null;

        String sql = "INSERT INTO Receta(receta_id,mascota_id,veterinario_id,receta_fechaEmision,receta_diagnostico,receta_indicaciones,estado) VALUES (?,?,?,?,Initcap(?),Initcap(?),'A')";

        try {
            pstp = con.prepareStatement(sql);

            pstp.setString(1, r.getReceta_id());
            pstp.setInt(2, r.getMascota_id());
            pstp.setInt(3, r.getMedico_id());
            pstp.setDate(4, java.sql.Date.valueOf(r.getReceta_fechaEmision()));
            pstp.setString(5, r.getReceta_diagnostico());
            pstp.setString(6, r.getReceta_indicaciones());
            mensaje = "REGISTRADO EXITOSAMENTE";
            pstp.execute();
            pstp.close();

        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO REGISTRAR \n " + e.getMessage();
        }
        return mensaje;
    }

    // ACTUALIZAR
    public String modificarReceta(Connection conn, Receta r, String idReceta) {

        PreparedStatement pstp = null;
        String sql = "UPDATE receta SET mascota_id = ?,veterinario_id = ?, Receta_fechaEmision = ?,Receta_diagnostico = ?, Receta_indicaciones =Initcap(?) WHERE receta_id = '" + idReceta + "'";
        try {
            pstp = conn.prepareStatement(sql);

            pstp.setInt(1, r.getMascota_id());
            pstp.setInt(2, r.getMedico_id());
            pstp.setDate(3, java.sql.Date.valueOf(r.getReceta_fechaEmision()));
            pstp.setString(4, r.getReceta_diagnostico());
            pstp.setString(5, r.getReceta_indicaciones());

            mensaje = "MODIFICADO EXITOSAMENTE";
            pstp.executeUpdate();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO MODIFICAR \n " + e.getMessage();
        }
        return mensaje;
    }

    //ELIMINAR
    public String eliminarReceta(Connection conn, String idReceta) {
        PreparedStatement ps = null;
        String sql = "UPDATE receta SET estado = 'I' WHERE receta_id = '" + idReceta + "'";
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

    //TRAER DATOS RECETA
    //TRAER DATOS RECETA
    void mostrardatos(Connection con, JTable Tablas_Rec, String idReceta) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("ID MASCOTA");
        modelo.addColumn("NOM.MASCOTA");
        modelo.addColumn("ID VETERINARIO");
        modelo.addColumn("CED.VETERINARIO");
        modelo.addColumn("NOM.VETERINARIO");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("FECHA_EMISION");
        modelo.addColumn("DIAGNÓSTICO");
        modelo.addColumn("INDICACIONES");

        Tablas_Rec.setModel(modelo);
        Tablas_Rec.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Rec.getColumnModel().getColumn(5).setPreferredWidth(200);

        String sql;
        sql = "SELECT r.receta_id, r.mascota_id,p.mascota_nombre,r.veterinario_id,per.persona_cedula,per.persona_Pri_nombre||' '||per.persona_Seg_nombre||' '||per.persona_Pat_apellido||' '||per.persona_Mat_apellido,m.profesion,TO_CHAR(r.receta_fechaEmision, 'YYYY-MM-DD'),r.receta_diagnostico,r.receta_indicaciones FROM personas per, receta r, mascota p, veterinario m  WHERE per.persona_id= m.persona_id AND r.receta_id LIKE '%" + idReceta + "%'" + " and r.mascota_id = p.mascota_id AND r.veterinario_id = m.veterinario_id AND r.estado = 'A' ORDER BY r.receta_id ASC";
        String[] datos = new String[10];

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            boolean respu = false;
            if (rs.equals(respu)) {
                System.out.println("no se encontro");
            }
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

                modelo.addRow(datos);

            }
            Tablas_Rec.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

// INCREMENTAR ID
    public int getRecID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(receta_id) FROM receta";
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

    // AUTOCOMPLETAR
    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT receta_id FROM receta where estado = 'A'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("receta_id");
                // Añadimos todo al Array
                name.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }

    // -------------------- TRAER DATOS A UNA TABLA --------------------------
    void mostrardatosRecetaHis(Connection con, JTable Tablas_Pro, int id_mascota) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("VETERINARIO");
        modelo.addColumn("FECHA EMISION");
        modelo.addColumn("DIAGNOSTICO");
        modelo.addColumn("INDICACIONES");

        Tablas_Pro.setModel(modelo);
        Tablas_Pro.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(0).setPreferredWidth(10);
        Tablas_Pro.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(3).setPreferredWidth(20);

        String sql = "SELECT 'Doc.'||Per.Persona_pri_nombre ||' '|| Per.PERSONA_PAT_APELLIDO, TO_CHAR(R.receta_fechaemision, 'YYYY-MM-DD'),R.receta_diagnostico, R.receta_indicaciones FROM receta R, mascota P, veterinario M, Personas Per WHERE R.veterinario_id = M.veterinario_id AND M.persona_id = Per.persona_id AND P.mascota_id = R.mascota_id AND R.mascota_id = '" + id_mascota + "' ";

        String[] datos = new String[4];

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);

                modelo.addRow(datos);
            }
            Tablas_Pro.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
}
