package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ExamenDAO {

    private String mensaje = "";
    PreparedStatement pstp = null;
    
    // =========== METODO REGISTRAR ===========
    public String guardarExamen(Connection con, Examen e)  {
        
        String sql = "INSERT INTO examen(Id_examen,Id_Veterinario,Id_mascota,Nombre_examen,Tipo_examen,Descripcion,Resultados_examen) VALUES (?,?,?,Initcap(?),Initcap(?),Initcap(?),Initcap(?))";
        try {

            pstp = con.prepareStatement(sql);

            pstp.setInt(1, e.getExamen_id());
            pstp.setInt(2, e.getMedico_id());
            pstp.setInt(3, e.getMascota_id());
            pstp.setString(4, e.getNombre_examen());
            pstp.setString(5, e.getTipo_examen());
            pstp.setString(6, e.getObservaciones());
            pstp.setString(7, e.getResutaldo_exa());

            mensaje = "GUARDADO EXITOSAMENTE";
            
            pstp.execute();
            pstp.close();

        } catch (SQLException p) {
            
            mensaje = "NO SE HA REGISTRADO EXITOSAMENTE \n"  + p.getMessage();
        }
        return mensaje;
    }//------------ FIN REGISTRAR ------------

    // TRAER ID EXAMEN
    
        public int IdExamne (Connection conn){

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(Id_examen) FROM examen";
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
        
    // -------------------- TRAER DATOS A UNA TABLA --------------------------
        
    void mostrardatos(Connection con, JTable Tablas_Pro, int id_mascota) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("EXAMEN");
        modelo.addColumn("TIPO DE EXAMEN");
         modelo.addColumn("OBSERVACIONES");
        modelo.addColumn("RESULTADOS");

        Tablas_Pro.setModel(modelo);
        Tablas_Pro.getColumnModel().getColumn(0).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(0).setPreferredWidth(10);       
        Tablas_Pro.getColumnModel().getColumn(1).setResizable(false);
        Tablas_Pro.getColumnModel().getColumn(1).setPreferredWidth(10); 
        Tablas_Pro.getColumnModel().getColumn(2).setResizable(false);   
        Tablas_Pro.getColumnModel().getColumn(3).setResizable(false);

        
        String sql = "SELECT E.nombre_examen, E.tipo_examen, E.Descripcion ,E.resultados_examen FROM Examen E, mascota P WHERE P.mascota_id = E.id_mascota AND E.id_mascota = '"+ id_mascota+"'";



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
