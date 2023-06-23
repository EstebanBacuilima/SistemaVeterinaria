
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediss
 */
public class AgendaCitasDAO {
    PreparedStatement ps;
    ResultSet rs;
    private String mensaje = "";
    
    
     public int ContarcitasDAO(Connection con, String estado, int id,String templ, String fechaHoy){
        int num=0;
        String sql;
        if ("Secretaria".equals(templ)){
           if ("T".equals(estado)){
                
                sql ="select count(*) from citas";
            }else {
                if ("H".equals(estado)){
                     sql ="select count(*) from citas where estado = 'P' and (fecha = TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY')))";
                     
                }else {
                    sql ="select count(*) from citas where estado = '"+estado+"' and (fecha between TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY')) and sysdate+ interval '12' month)";
                }
            }
        }else{
            if ("T".equals(estado)){
                sql ="select count(*) from citas where id_veterinario="+id+"";
                 //System.out.println("sql 4" + sql);
            }
            else {
                if ("H".equals(estado)){
                     sql ="select count(*) from citas where (estado = 'P' and id_veterinario="+id+") and (fecha = TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY')))";
                     // System.out.println("sql 5" + sql);
                }else{
                     sql ="select count(*) from citas where estado = '"+estado+"' and id_veterinario="+id+" and (fecha between TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY')) and sysdate+ interval '12' month)";
                     // System.out.println("sql 6" + sql);
                }
            }
        }
        try {      
             ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            while (rs.next()) {
               num = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " Error conteo " + e);
        }
        return num;
    }
    
    
    
    public void mostrarCitasDAO(Connection con, JTable tagenda, String estado, int id,String templ, String fechaHoy){
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        }; 
        String sql;
        if ("Secretaria".equals(templ)){
                modelo.addColumn("CITA");
                modelo.addColumn("CLAVE_MASCOTA");
                modelo.addColumn("MASCOTA");
                modelo.addColumn("SERVICIO");
                modelo.addColumn("MEDICO");
                modelo.addColumn("CONSULTORIO");
                modelo.addColumn("FECHA");
                modelo.addColumn("HORA");
                modelo.addColumn("ESTADO");
                tagenda.setModel(modelo);
            if ("T".equals(estado)){
                sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA, NOM_SERVICIO, NOM_VETERINARIO, NOM_AREA,  to_char(fecha,'DD/MM/YYYY') , HORA, ESTADO from V_Mostrar_Citas order by id_cita";
            //System.out.println("Entro a Todos");
            }else {
                if ("H".equals(estado)){
                     sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA, NOM_SERVICIO, NOM_VETERINARIO, NOM_AREA,  to_char(fecha,'DD/MM/YYYY'), HORA, ESTADO from V_Mostrar_Citas where estado = 'P' and (fecha = TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY'))) order by id_cita";
                     
                }else{
                    sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA, NOM_SERVICIO, NOM_VETERINARIO, NOM_AREA,  to_char(fecha,'DD/MM/YYYY'), HORA, ESTADO from V_Mostrar_Citas where estado = '"+estado+"' and (fecha between TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY'))and sysdate + interval '12' month) order by id_cita";
               
                }
            }
            String[] datos = new String[10];
            
            //System.out.println("ff " + sql);
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
           tagenda.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
        }
        }else{
                modelo.addColumn("CITA");
                modelo.addColumn("CLAVE_PACIENTE");
                modelo.addColumn("PACIENTE");
                modelo.addColumn("FECHA");
                modelo.addColumn("HORA");
                modelo.addColumn("ESTADO");
                tagenda.setModel(modelo);
            if ("T".equals(estado)){
                sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA,  to_char(fecha,'DD/MM/YYYY') , HORA, ESTADO from V_Mostrar_Citas where ID_VETERINARIO="+id+" order by id_cita";
                
            }else {
                if ("H".equals(estado)){
                     sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA,  to_char(fecha,'DD/MM/YYYY') , HORA, ESTADO from V_Mostrar_Citas where estado= 'P' and ID_VETERINARIO="+id+" and (fecha = TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY'))) order by id_cita";
                }else{
                sql ="select ID_CITA,CLAVE_MASCOTA, NOM_MASCOTA, to_char(fecha,'DD/MM/YYYY') , HORA, ESTADO from V_Mostrar_Citas where estado= '"+estado+"' and ID_VETERINARIO="+id+" and (fecha between TO_CHAR(TO_DATE(sysdate, 'DD/MM/YYYY'))and sysdate + interval '12' month) order by id_cita";
                }
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
                modelo.addRow(datos);
                }
                tagenda.setModel(modelo);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No Encontrado");
            }           
        }
    }      
    
    public void cancelarCitaDAO(Connection con, int idcita){
        String sql = "update citas set estado='C' where id_cita="+idcita;
        try {
            ps=con.prepareStatement(sql); 
            ps.executeUpdate();
            ps.close();
            mensaje = "Cita Cancelada";
        } catch (SQLException e) {
        }
    }
    
    public void atenderCitaDAO(Connection con, int idcita){
        String sql = "update citas set estado='A' where id_cita="+idcita;
        try {
            ps=con.prepareStatement(sql); 
            ps.executeUpdate();
            ps.close();
            mensaje = "Cita Cancelada";
        } catch (SQLException e) {
            
        }
    }
    public int extraeridmedicoDAO(Connection con, int idcita){
        int idm=0;
        String sql="select id_VETERINARIO from citas where id_cita="+idcita+"";
        try {
            ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            while (rs.next()) {
               idm = rs.getInt(1);
            }
            con.close();
        } catch (SQLException e) {
        }
        return idm;
    }
    public void horasatencionDAO(Connection con,JComboBox horas, int idm, String dia ){
        String verifica="";
        String sql ="SELECT O.hora_inicio, O.hora_fin FROM  veterinario V, horario_veterinario H, CONTROL_HORARIO O WHERE  H.ID_VETERINARIO  = V.Veterinario_id AND H.ID_HORARIO = O.ID_HORARIO AND V.Veterinario_id = " + idm +" AND O.dia='" + dia + "' AND o.ESTADO = 'A' AND H.ESTADO = 'A'";
     
        try {           
             ps = con.prepareStatement(sql); 
            rs = ps.executeQuery();
            //guardamos los datos en el array
            horas.removeAllItems();
            horas.addItem("Seleccionar Horario");
            while (rs.next()) {
               horas.addItem(rs.getString(1)+" hasta "+rs.getString(2));
               verifica = rs.getString(1);
            }
            if (verifica==""){
                JOptionPane.showMessageDialog(null, "El medico no esta disponible el dia seleccionado");
            }else{
                JOptionPane.showMessageDialog(null, "Horaios del medico cargados");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error datos consultorio " + e);
        }
    }
    
    public void reagendarCitaDAO(Connection con, int id, String fecha, String hora){
        String sql = "update citas set fecha = TO_DATE('"+fecha+"','DD-MM-YYYY'), hora = '"+hora+"', estado='P' where id_cita = "+id+"";
  
        try {
            ps=con.prepareStatement(sql); 
            ps.executeUpdate();
            ps.close();
            mensaje = "Cita Cancelada";
        } catch (SQLException e) {
            System.out.println("Error " + e);
        }
    }
    
}
