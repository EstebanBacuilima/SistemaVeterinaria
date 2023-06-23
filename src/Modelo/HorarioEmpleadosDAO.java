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

public class HorarioEmpleadosDAO {
    private String mensaje = "";
    
    public String agregarHorarioEmp(Connection conn, MHorarioEmpleados he){
        PreparedStatement ps = null;
        String sql = "INSERT INTO HORARIO_VETERINARIO(ID_HORARIO_VET, ID_HORARIO, ID_VETERINARIO, ESTADO) VALUES (?,?,?,'A')" ;
        try{
                ps = conn.prepareStatement(sql);                
                ps.setInt(1, he.getId_horarioemp());
                ps.setInt(2, he.getId_horario());
                ps.setInt(3, he.getId_medico());
                
                mensaje = "REGISTRADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarHorarioEmp(Connection conn, MHorarioEmpleados he, int id_horariohe){
        PreparedStatement ps = null;
        String sql = "UPDATE HORARIO_VETERINARIO SET ID_HORARIO = ? WHERE ID_HORARIO_VET = '" + id_horariohe + "'";
        try{
                ps = conn.prepareStatement(sql);
                ps.setInt(1, he.getId_horario());
                mensaje = "MODIFICADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarHorarioEmp(Connection conn, int id_horarioemp){
        PreparedStatement ps = null;
        String sql = "UPDATE HORARIO_VETERINARIO SET ESTADO = 'I' WHERE ID_HORARIO_VET = '" + id_horarioemp + "'";
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
    
    public void listarHorarioEmp(Connection conn, JTable table, String apellido){
       DefaultTableModel model = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
       };
       
       model.addColumn("ID");
       model.addColumn("ID VETERINARIO");
       model.addColumn("NOMBRE");
       model.addColumn("APELLIDO");
       model.addColumn("DIA");
       model.addColumn("HORA INICIO");
       model.addColumn("HORA FIN");
       table.setModel(model);
       
       String sql = "";

       if (apellido.equals("")) {
           sql = "SELECT HE.ID_HORARIO_VET, V.VETERINARIO_ID, P.PERSONA_PRI_NOMBRE, P.PERSONA_PAT_APELLIDO,H.DIA, H.HORA_INICIO, H.HORA_FIN FROM HORARIO_VETERINARIO HE, CONTROL_HORARIO H, PERSONAS P, VETERINARIO V WHERE HE.ID_HORARIO = H.ID_HORARIO AND HE.ID_VETERINARIO = V.VETERINARIO_ID AND V.PERSONA_ID = P.PERSONA_ID AND HE.ESTADO = 'A' ORDER BY HE.ID_HORARIO_VET";
       }else{
           sql = "SELECT HE.ID_HORARIO_VET, V.VETERINARIO_ID, P.PERSONA_PRI_NOMBRE, P.PERSONA_PAT_APELLIDO,H.DIA, H.HORA_INICIO, H.HORA_FIN FROM HORARIO_VETERINARIO HE, CONTROL_HORARIO H, PERSONAS P, VETERINARIO V WHERE P.PERSONA_PAT_APELLIDO LIKE '%" + apellido + "%' AND HE.ID_HORARIO = H.ID_HORARIO AND HE.ID_VETERINARIO = V.VETERINARIO_ID AND V.PERSONA_ID = P.PERSONA_ID AND HE.ESTADO = 'A' ORDER BY HE.ID_HORARIO_VET";
       }
       
       String [] filas = new String[7];
       
       try{
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               filas[0] = rs.getString(1);
               filas[1] = rs.getString(2);
               filas[2] = rs.getString(3);
               filas[3] = rs.getString(4);
               filas[4] = rs.getString(5);
               filas[5] = rs.getString(6);
               filas[6] = rs.getString(7);
               
               model.addRow(filas);
           }
           table.setModel(model);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "7. NO SE PUEDE LISTAR LA TABLA" + e);
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
        modelo.addColumn("CONSULTORIO");

        tabla_med.setModel(modelo);
        
        String sql = "";
        
        if (cedula.equals("")) {
            sql= "SELECT vet.VETERINARIO_ID, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero, vet.profesion,C.ID_AREA FROM personas P, veterinario vet,area_trabajo C WHERE vet.area_id = C.ID_AREA AND P.persona_id = vet.persona_id AND vet.estado = 'A' ORDER BY vet.persona_id ASC";
        }else{
            sql= "SELECT vet.VETERINARIO_ID, P.persona_cedula,P.persona_Pri_nombre, P.persona_Pat_apellido,P.persona_genero, vet.profesion,C.ID_AREA FROM personas P, veterinario vet,area_trabajo C WHERE vet.area_id = C.ID_AREA AND P.persona_cedula LIKE '%" + cedula + "%'" + " AND P.persona_id = vet.persona_id AND vet.estado = 'A' ORDER BY vet.persona_id ASC";
        }
        String[] datos = new String[7];

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

                modelo.addRow(datos);
            }
            tabla_med.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }
    
    public void listarHorario(Connection conn, JTable table, String dia){
       DefaultTableModel model = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
       };
       
       model.addColumn("ID");
       model.addColumn("HORA INICIO");
       model.addColumn("HORA FIN");
       model.addColumn("DIA");
       
       table.setModel(model);
       String sql = "";

       if (dia.equals("")) {
           sql = "SELECT * FROM CONTROL_HORARIO WHERE ESTADO = 'A' ORDER BY ID_HORARIO";
       }else{
           sql = "SELECT * FROM CONTROL_HORARIO WHERE DIA = '" + dia + "' AND ESTADO = 'A' ORDER BY ID_HORARIO";
       }
       
       String [] filas = new String[4];
       
       try{
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               filas[0] = rs.getString(1);
               filas[1] = rs.getString(2);
               filas[2] = rs.getString(3);
               filas[3] = rs.getString(4);
               
               model.addRow(filas);
           }
           table.setModel(model);
       }catch(Exception e){
           JOptionPane.showMessageDialog(null, "NO SE PUEDE LISTAR LA TABLA");
       }
    }
    
    public void eliminados(Connection conn, JTable table){
       DefaultTableModel model = new DefaultTableModel(){
           @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
       };
       
       model.addColumn("ID");
       model.addColumn("ID VETERINARIO");
       model.addColumn("NOMBRE");
       model.addColumn("APELLIDO");
       model.addColumn("DIA");
       model.addColumn("HORA INICIO");
       model.addColumn("HORA FIN");
       table.setModel(model);
       
       String sql = "SELECT HE.ID_HORARIO_VET, V.VETERINARIO_ID, P.PERSONA_PRI_NOMBRE, P.PERSONA_PAT_APELLIDO,H.DIA, H.HORA_INICIO, H.HORA_FIN FROM HORARIO_VETERINARIO HE, CONTROL_HORARIO H, PERSONAS P, VETERINARIO V WHERE HE.ID_HORARIO = H.ID_HORARIO AND HE.ID_VETERINARIO = V.VETERINARIO_ID AND V.PERSONA_ID = P.PERSONA_ID AND HE.ESTADO = 'I' ORDER BY HE.ID_HORARIO_VET";
       
       String [] filas = new String[7];
       
       try{
           Statement st = conn.createStatement();
           ResultSet rs = st.executeQuery(sql);
           while(rs.next()){
               
               filas[0] = rs.getString(1);
               filas[1] = rs.getString(2);
               filas[2] = rs.getString(3);
               filas[3] = rs.getString(4);
               filas[4] = rs.getString(5);
               filas[5] = rs.getString(6);
               filas[6] = rs.getString(7);
               
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
        String sql = "SELECT MAX(ID_HORARIO_VET) FROM HORARIO_VETERINARIO";
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
    
    // AUTOCOMPLETAR
    public void TraerDatosAuto(Connection conn, ArrayList name, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.PERSONA_CEDULA FROM PERSONAS P, VETERINARIO V WHERE V.PERSONA_ID = P.PERSONA_ID AND ESTADO = 'A'";
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
    
    public void TraerDatosAutoHo(Connection conn, ArrayList hora, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT * FROM HORARIO";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("DIA");
                // Añadimos todo al Array
                hora.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }
    
    public void TraerDatosAutoHoEmp(Connection conn, ArrayList he, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT P.PERSONA_PAT_APELLIDO FROM HORARIO_VETERINARIO HE, CONTROL_HORARIO H, PERSONAS P, VETERINARIO V WHERE HE.ID_HORARIO = H.ID_HORARIO AND HE.ID_VETERINARIO = V.VETERINARIO_ID AND V.PERSONA_ID = P.PERSONA_ID AND HE.ESTADO = 'A' ORDER BY HE.ID_HORARIO_VET ";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString(1);
                // Añadimos todo al Array
                he.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }
    }
    
    // validar repetidos
    public boolean validacionNoRepetidos(Connection conn, String id_servicio, String horaInicio, String horafin, String dia){
        
        boolean verificar = false;
         
        try {
            Statement stm = conn.createStatement();
            String sql2 = "SELECT O.hora_inicio, O.hora_fin, C.id_area FROM area_trabajo C, veterinario V, horario_veterinario H, control_horario O WHERE V.area_id = C.id_area AND H.ID_VETERINARIO  = V.veterinario_id AND H.ID_HORARIO = O.ID_HORARIO AND  C.id_area = '" + id_servicio + "' AND O.hora_inicio = '" + horaInicio + "' AND O.hora_fin = '" + horafin +"'";
            ResultSet rs = stm.executeQuery(sql2);
            if (rs.next()) {
                verificar = true;
            } else {
                verificar = false;
            }
        } catch (SQLException ex) {
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + ex.getMessage();
        }
        return verificar;
    }
}
