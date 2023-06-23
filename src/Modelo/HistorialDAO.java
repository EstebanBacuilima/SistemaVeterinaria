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

public class HistorialDAO {

    // ACTUALES
    private String mensaje = "";

     void mostrardatosMedAc(Connection con, JTable Tablas_Historial, String cedula) {

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
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("SERVICIO");
        modelo.addColumn("CONSULTORIO");

        Tablas_Historial.setModel(modelo);

        String sql;
        sql = "SELECT m.veterinario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), m.profesion, s.nombre,c.nombre FROM personas P, veterinario m, servicios s, area_trabajo c WHERE P.persona_cedula LIKE '%" + cedula + "%'" + "  AND m.servicios_id = s.id_servicio AND m.area_id = c.id_area AND P.persona_id = m.persona_id AND m.estado = 'A' ORDER BY m.veterinario_id ASC";

        String[] datos = new String[12];

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

                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
//Auxiliar

    void mostrardatosAuxAct(Connection con, JTable Tablas_Historial, String cedula) {

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
        modelo.addColumn("SERVICIO");
        Tablas_Historial.setModel(modelo);

        String sql;
        sql = "SELECT a.auxiliar_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), a.labores, s.nombre FROM personas P, auxiliar a, servicios s WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = a.persona_id AND a.servicios_id = s.id_servicio AND a.estado = 'A' ORDER BY a.auxiliar_id ASC";
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
            Tablas_Historial.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

//Secretaria
    void mostrardatosSecretariaAct(Connection con, JTable Tablas_Historial, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES y APELLIDOS");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("N CAJA");

        Tablas_Historial.setModel(modelo);

        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(80);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setPreferredWidth(100);
        Tablas_Historial.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(8).setPreferredWidth(10);

        String sql;
        sql = "SELECT Pr.secretaria_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, Pr.numero_ventanilla FROM personas P, secretaria Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

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
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }

//Propietario
    void mostrardatosPropAct(Connection con, JTable Tablas_Historial, String cedula) {

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
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");

        Tablas_Historial.setModel(modelo);
        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(80);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setPreferredWidth(100);

        String sql;
        sql = "SELECT Pr.propietario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD') FROM personas P, propietario Pr WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

        String[] datos = new String[8];
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
                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }
//Paciente 

    void mostrardatosPaAct(Connection con, JTable Tablas_Historial, String clave) {

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

        Tablas_Historial.setModel(modelo);
        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(50);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(100);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(20);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(20);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(9).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(9).setPreferredWidth(200);

        String sql;
        sql = "SELECT P.mascota_id,P.mascota_clave, P.mascota_nombre,P.mascota_edad,P.mascota_peso,P.mascota_sexo,P.mascota_especie,P.mascota_raza,P.mascota_tamaño,P.mascota_observaciones FROM mascota P, propietario Pr WHERE P.mascota_clave LIKE '%" + clave + "%'" + " AND P.propietario_id = Pr.propietario_id AND P.estado = 'A' ORDER BY P.mascota_id ASC";

        String[] datos = new String[10];
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

                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }

public String eliminarMedico(Connection conn, Medico m, String IdMedico) {
        PreparedStatement pstp = null;
        String sql2 = "UPDATE veterinario SET estado= 'I' WHERE veterinario_id= '" + IdMedico + "'";
        try {
            pstp = conn.prepareStatement(sql2);
            mensaje = "ELIMINACION EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarAuxiliar(Connection conn, Auxiliar m, String auxiliar_id) {
        PreparedStatement pstp = null;
        String sql2 = "UPDATE auxiliar SET estado = 'I' WHERE auxiliar_id= '" + auxiliar_id + "'";
        try {
            pstp = conn.prepareStatement(sql2);

            mensaje = "ELIMINACION EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarSecretaria(Connection conn, Secretaria p, String secretaria_id) {

        PreparedStatement pstp = null;
        String sql = "UPDATE secretaria SET estado = 'I' WHERE secretaria_id ='" + secretaria_id + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "ELIMINACION EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPropietario(Connection conn, Propietario p, String propietario_id) {
        PreparedStatement pstp = null;
        String sql = "UPDATE propietario SET estado = 'I' WHERE propietario_id = '" + propietario_id + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "ELIMINACION EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    public String eliminarPaciente(Connection conn, Mascota p, String clave) {
        PreparedStatement pstp = null;
        String sql = "UPDATE paciente SET estado = 'I' WHERE mascota_clave = '" + clave + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "ELIMINACION EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    // ELIMINADOS
    //medico
    void mostrardatosMed(Connection con, JTable Tablas_Historial, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("ESPECIALIDAD");
        modelo.addColumn("SERVICIO");
        modelo.addColumn("CONSULTORIO");
        Tablas_Historial.setModel(modelo);

        String sql;
        sql = "SELECT m.veterinario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), m.profesion, s.nombre, c.nombre FROM personas P, veterinario m, servicios s, area_trabajo c WHERE P.persona_cedula LIKE '%" + cedula + "%'" + "  AND m.servicios_id = s.id_servicio AND m.area_id = c.id_area AND P.persona_id = m.persona_id AND m.estado = 'I' ORDER BY m.veterinario_id ASC";

        String[] datos = new String[12];

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

                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
//Auxiliar

    void mostrardatosAux(Connection con, JTable Tablas_Historial, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE Y APELLIDO");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("LABORES");
        modelo.addColumn("SERVICIO");
        Tablas_Historial.setModel(modelo);

        String sql;
        sql = "SELECT a.auxiliar_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), a.labores, s.nombre FROM personas P, auxiliar a, servicios s WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = a.persona_id AND a.servicios_id = s.id_servicio AND a.estado = 'I' ORDER BY a.auxiliar_id ASC";
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
            Tablas_Historial.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

//Secretaria
    void mostrardatosSecretaria(Connection con, JTable Tablas_Historial, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };
        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRES y APELLIDOS");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("N CAJA");

        Tablas_Historial.setModel(modelo);

        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(80);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setPreferredWidth(100);
        Tablas_Historial.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(8).setPreferredWidth(10);

        String sql;
        sql = "SELECT Pr.secretaria_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, Pr.numero_ventanilla FROM personas P, secretaria Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'I' ORDER BY Pr.persona_id ASC";

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
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }

//Propietario
    void mostrardatosProp(Connection con, JTable Tablas_Historial, String cedula) {

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
        modelo.addColumn("CORREO");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");

        Tablas_Historial.setModel(modelo);
        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(150);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(80);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(30);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setPreferredWidth(100);

        String sql;
        sql = "SELECT Pr.propietario_id, P.persona_cedula,P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion,TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD') FROM personas P, propietario Pr WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = Pr.persona_id AND Pr.estado = 'I' ORDER BY Pr.persona_id ASC";

        String[] datos = new String[8];
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
                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }
//Paciente 

    void mostrardatosPa(Connection con, JTable Tablas_Historial, String clave) {

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
        modelo.addColumn("TAMAÑO ");
        modelo.addColumn("OBSERVACIONES");

        
        Tablas_Historial.setModel(modelo);
        
        Tablas_Historial.setModel(modelo);
        Tablas_Historial.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(0).setPreferredWidth(5);
        Tablas_Historial.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(1).setPreferredWidth(50);
        Tablas_Historial.getColumnModel().getColumn(2).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(2).setPreferredWidth(100);
        Tablas_Historial.getColumnModel().getColumn(3).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(3).setPreferredWidth(20);
        Tablas_Historial.getColumnModel().getColumn(4).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(4).setPreferredWidth(20);
        Tablas_Historial.getColumnModel().getColumn(5).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(5).setPreferredWidth(40);
        Tablas_Historial.getColumnModel().getColumn(6).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(7).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(8).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(9).setResizable(false);
        Tablas_Historial.getColumnModel().getColumn(9).setPreferredWidth(200);

        String sql;
        sql = "SELECT P.mascota_id,P.mascota_clave, P.mascota_nombre,P.mascota_edad,P.mascota_peso,P.mascota_sexo,P.mascota_especie,P.mascota_raza,P.mascota_tamaño,P.mascota_observaciones FROM mascota P, propietario Pr WHERE P.mascota_clave LIKE '%" + clave + "%'" + " AND P.propietario_id = Pr.propietario_id AND P.estado = 'I' ORDER BY P.mascota_id ASC";

        String[] datos = new String[10];
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

                modelo.addRow(datos);
            }
            Tablas_Historial.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }
    }
    //Restaurar Medico

     public String RestaurarMedico(Connection conn, Medico m, String IdMedico) {
        PreparedStatement pstp = null;
        String sql2 = "UPDATE veterinario SET estado= 'A' WHERE veterinario_id= '" + IdMedico + "'";
        try {
            pstp = conn.prepareStatement(sql2);
            mensaje = "RESTAURACIÓN EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }
    //Restaurar Auxiliar

    public String RestaurarAuxiliar(Connection conn, Auxiliar m, String auxiliar_id) {
        PreparedStatement pstp = null;
        String sql2 = "UPDATE auxiliar SET estado = 'A' WHERE auxiliar_id= '" + auxiliar_id + "'";
        try {
            pstp = conn.prepareStatement(sql2);

            mensaje = "RESTAURACIÓN EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }
    //Restaurar Secretaria

    public String RestaurarSecretaria(Connection conn, Secretaria p, String secretaria_id) {

        PreparedStatement pstp = null;
        String sql = "UPDATE secretaria SET estado = 'A' WHERE secretaria_id ='" + secretaria_id + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "RESTAURACIÓN EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    //Restaurar Propietario
    public String RestaurarPropietario(Connection conn, Propietario p, String propietario_id) {
        PreparedStatement pstp = null;
        String sql = "UPDATE propietario SET estado = 'A' WHERE propietario_id = '" + propietario_id + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "RESTAURACIÓN EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

    //Restaurar Paciente
    public String RestaurarPaciente(Connection conn, Mascota p, String clave) {
        PreparedStatement pstp = null;
        String sql = "UPDATE mascota SET estado = 'A' WHERE mascota_clave = '" + clave + "'";
        try {
            pstp = conn.prepareStatement(sql);
            mensaje = "RESTAURACIÓN EXITOSA";
            pstp.execute();
            pstp.close();
        } catch (SQLException e) {
            mensaje = "NO SE HA PODIDO RESTAURAR \n " + e.getMessage();
        }
        return mensaje;
    }

//    // AUTOCOMPLETAR
//    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {
//
//        // SENTECIA SELCIONAR LA TABLA
//        String sql = "select persona_cedula  from personas";
//        try {
//
//            Statement st = conn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//
//                // Traer el campo especificado de la tabla de la Base
//                datos = rs.getString("persona_cedula");
//                // Añadimos todo al Array
//                name.add(datos);
//            }
//
//        } catch (SQLException ex) {
//
//            System.out.println("Error:" + ex);
//        }
//
//    }
}
