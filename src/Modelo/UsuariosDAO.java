package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UsuariosDAO {
    private String mensaje = "";
    
    public String agregarUsuario(Connection conn, MUsuarios u, String usuario){
        try {
            Statement stm = conn.createStatement();
            String sql2 = "SELECT USUARIO FROM USUARIOS WHERE USUARIO = '" + usuario +"'";
            ResultSet rs = stm.executeQuery(sql2);
            if (rs.next()) {
                mensaje= "USUARIO EXISTENTE";
            } else {
                PreparedStatement ps = null;
                String sql = "INSERT INTO USUARIOS(ID_USER, ID_EMPLEADO, TIPO, USUARIO, CONTRASEÑA, ESTADO) VALUES (?,?,?,?,?,'A')" ;
                try{
                    ps = conn.prepareStatement(sql);                
                    ps.setInt(1, u.getId_user());
                    ps.setInt(2, u.getId_empleado());
                    ps.setString(3, u.getTipo());
                    ps.setString(4, u.getUsuario());
                    ps.setString(5, u.getContraseña());

                    mensaje = "REGISTRADO EXITOSAMENTE";
                    ps.execute();
                    ps.close();            
                }catch(SQLException e){
                    mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
                }
            }
        } catch (SQLException ex) {
           mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + ex.getMessage();
        }
        return mensaje;
    }

    public String modificarUsuario(Connection conn, MUsuarios u, String usuario){
        PreparedStatement ps = null;
        String sql = "UPDATE USUARIOS SET CONTRASEÑA = ? WHERE USUARIO = '" + usuario + "'";
        try{
                ps = conn.prepareStatement(sql);
                ps.setString(1, u.getContraseña());
                mensaje = "MODIFICADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String inactivo(Connection conn, String usuario){
        PreparedStatement ps = null;
        String sql = "UPDATE USUARIOS SET estado = 'I' WHERE USUARIO = '" + usuario + "'"; 
        try{
                ps = conn.prepareStatement(sql);
                mensaje = "USUARIOS INACTIVADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA INACTIVADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String Reactivar (Connection conn, String usuario){
        PreparedStatement ps = null;
        String sql = "UPDATE USUARIOS SET estado = 'A' WHERE USUARIO = '" + usuario + "'"; 
        try{
                ps = conn.prepareStatement(sql);
                mensaje = "USUARIOS ACTIVADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA ACTIVADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarUsuario(Connection conn, String usuario){
        PreparedStatement ps = null;
        String sql = "DELETE FROM USUARIOS WHERE USUARIO = '" + usuario + "'"; 
        try{
                ps = conn.prepareStatement(sql);
                mensaje = "ELIMINADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA ELIMINADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public void listarUsuario(Connection conn, JTable table,String cedula){
       DefaultTableModel model = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
       };
       
       model.addColumn("ID USER");
       model.addColumn("ID EMPLEADO");
       model.addColumn("TIPO");
       model.addColumn("USUARIO");
       model.addColumn("CONTRASEÑA");
       table.setModel(model);
       
       String sql = "";

       if (cedula.equals("")) {
            sql = "SELECT U.id_user, P.persona_id, U.tipo, U.usuario, U.contraseña FROM USUARIOS U, PERSONAS P WHERE U.id_empleado = P.persona_id AND U.ESTADO = 'A' AND U.tipo != 'Admin' ORDER BY U.ID_USER";
       }else{
            sql = "SELECT U.id_user, P.persona_id, U.tipo, U.usuario, U.contraseña FROM USUARIOS U, PERSONAS P WHERE U.usuario LIKE '%" + cedula + "%'" + " AND U.id_empleado = P.persona_id AND ESTADO = 'A' AND U.tipo != 'Admin' ORDER BY U.ID_USER";
       }
       
       String [] filas = new String[5];
       
       try{
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               filas[0] = rs.getString(1);
               filas[1] = rs.getString(2);
               filas[2] = rs.getString(3);
               filas[3] = rs.getString(4);
               filas[4] = rs.getString(5);
               
               model.addRow(filas);
           }
           table.setModel(model);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
       }
    }
    
    public void mostrarsecretaria(Connection con, JTable Tablas_Pro, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("GENERO");
        modelo.addColumn("N CAJA");

        Tablas_Pro.setModel(modelo);
        
        String sql = "";

        if (cedula.equals("")) {
            sql = "SELECT P.persona_id, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero,  Pr.numero_ventanilla FROM personas P, secretaria Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";
        }else{
            sql = "SELECT P.persona_id, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero,  Pr.numero_ventanilla FROM personas P, secretaria Pr WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";
        }
        String[] datos = new String[6];

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

                modelo.addRow(datos);
            }
            Tablas_Pro.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
    
    public void mostrarmedico(Connection con, JTable tabla_med, String cedula) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("APELLIDO");
        modelo.addColumn("GENERO");
        modelo.addColumn("PROFESION");

        tabla_med.setModel(modelo);
        
        String sql = "";
        
        if (cedula.equals("")) {
            sql= "SELECT P.persona_id, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero, vet.profesion FROM personas P, veterinario vet WHERE P.persona_id = vet.persona_id AND vet.estado = 'A' ORDER BY vet.persona_id ASC";
        }else{
            sql= "SELECT P.persona_id, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero, vet.profesion FROM personas P, veterinario vet WHERE P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = vet.persona_id AND vet.estado = 'A' ORDER BY vet.persona_id ASC";
        }
        String[] datos = new String[6];

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

                modelo.addRow(datos);
            }
            tabla_med.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
    
    public void eliminados(Connection conn, JTable table){
       DefaultTableModel model = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
       };
       
       model.addColumn("ID USER");
       model.addColumn("ID EMPLEADO");
       model.addColumn("TIPO");
       model.addColumn("USUARIO");
       model.addColumn("CONTRASEÑA");
       table.setModel(model);
       String sql = "SELECT * FROM USUARIOS WHERE ESTADO = 'I' ORDER BY ID_USER";
       
       String [] filas = new String[5];
       
       try{
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               filas[0] = rs.getString(1);
               filas[1] = rs.getString(2);
               filas[2] = rs.getString(3);
               filas[3] = rs.getString(4);
               filas[4] = rs.getString(5);
               
               model.addRow(filas);
           }
           table.setModel(model);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
       }
    }
    
    public int getIncreID(Connection conn){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(ID_USER) FROM USUARIOS";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1)+1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("2.Error al mostrar id" + e.getMessage());
        }
        return id;
    }
    
    public void TraerDatosAutoUser(Connection conn, ArrayList user, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT * FROM USUARIOS";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("USUARIO");
                // Añadimos todo al Array
                user.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }
    
    public void TraerDatosAutoMedico(Connection conn, ArrayList cedula, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.persona_cedula FROM personas P, veterinario vet WHERE P.persona_id = vet.persona_id AND estado = 'A'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString(1);
                // Añadimos todo al Array
                cedula.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }
    
    public void TraerDatosAutoSecretaria(Connection conn, ArrayList cedula, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.persona_cedula FROM personas P, secretaria s WHERE P.persona_id = s.persona_id AND estado = 'A'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString(1);
                // Añadimos todo al Array
                cedula.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }
}
