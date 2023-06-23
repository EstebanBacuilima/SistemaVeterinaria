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

public class HorarioDAO {
    
    private String mensaje = "";
    
    public String agregarHorario(Connection conn, MHorario h){
        PreparedStatement ps = null;
        String sql = "INSERT INTO CONTROL_HORARIO(ID_HORARIO, HORA_INICIO, HORA_FIN, DIA, ESTADO) VALUES (?,?,?,?,'A')" ;
        try{
                ps = conn.prepareStatement(sql);                
                ps.setInt(1, h.getId_horario());
                ps.setString(2, h.getHora_inicio());
                ps.setString(3, h.getHora_fin());
                ps.setString(4, h.getDia());
                
                mensaje = "REGISTRADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }

    public String modificarHorario(Connection conn, MHorario h){
        PreparedStatement ps = null;
        String sql = "UPDATE CONTROL_HORARIO SET DIA = ? WHERE ID_HORARIO = ?" ;
        try{
                ps = conn.prepareStatement(sql);
                ps.setString(1, h.getDia());
                ps.setInt(2, h.getId_horario());
                mensaje = "MODIFICADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA MODIFICADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
    
    public String eliminarHorario(Connection conn, int id_horario){
        PreparedStatement ps = null;
        String sql = "UPDATE CONTROL_HORARIO SET ESTADO = 'I' WHERE ID_HORARIO = ?" ;
        try{
                ps = conn.prepareStatement(sql);
                ps.setInt(1, id_horario);
                mensaje = "ELIMINADO EXITOSAMENTE";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA ELIMINADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
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
           sql = "SELECT * FROM CONTROL_HORARIO WHERE DIA = '" + dia + "'  AND ESTADO = 'A' ORDER BY ID_HORARIO";
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
       model.addColumn("HORA INICIO");
       model.addColumn("HORA FIN");
       model.addColumn("DIA");
       table.setModel(model);
       String sql = "SELECT * FROM CONTROL_HORARIO WHERE ESTADO = 'I' ORDER BY ID_HORARIO";
       
       String [] filas = new String[5];
       
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
    
    public int getIncreID(Connection conn){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(ID_HORARIO) FROM CONTROL_HORARIO";
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
    
    public void TraerDatosAutoHorario(Connection conn, ArrayList horario, String datos) {

        // SENTECIA SELCIONAR LA TABLA
        String sql = "SELECT * FROM CONTROL_HORARIO";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                // Traer el campo especificado de la tabla de la Base
                datos = rs.getString("DIA");
                // Añadimos todo al Array
                horario.add(datos);
            }

        } catch (SQLException ex) {

            System.out.println("Error:" + ex);
        }

    }
}