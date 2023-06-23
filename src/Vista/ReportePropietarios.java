package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReportePropietarios extends javax.swing.JFrame {

    public ReportePropietarios() {
        initComponents();
        setLocationRelativeTo(null);
        //mostrardatos();
    }

    Connection con = Conexion.getConection();

    void mostrardatos() {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("CEDULA");
        modelo.addColumn("PRIMER NOMBRE");
        modelo.addColumn("SEGUDO NOMBRE");
        modelo.addColumn("APELLIDO PATERNO");
        modelo.addColumn("APELLIDO MATERNO");
        modelo.addColumn("GENERO");
        modelo.addColumn("CORREO ");
        modelo.addColumn("TELEFONO");
        modelo.addColumn("MOVIL");
        modelo.addColumn("DIRECCION");
        modelo.addColumn("FECHA NACIMIENTO");
        modelo.addColumn("CLAVE");

        Tablas_Pro.setModel(modelo);

        String sql = "";

        sql = "SELECT Pr.propietario_id, P.persona_cedula,P.persona_Pri_nombre,P.persona_Seg_nombre, P.persona_Pat_apellido,P.persona_Mat_apellido,P.persona_genero, P.persona_correo,P.persona_telefono, P.persona_movil,P.persona_direccion, TO_CHAR(P.persona_fecha_nacimiento, 'YYYY-MM-DD'), Pr.propietario_clave FROM personas P, propietario Pr WHERE P.persona_id = Pr.persona_id AND Pr.estado = 'A' ORDER BY Pr.persona_id ASC";

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
            Tablas_Pro.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldRoundBeanInfo1 = new jtextfieldround.JTextFieldRoundBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        BuscarTabla_Bot = new javax.swing.JButton();
        Txt_Buscar_Ce = new jtextfieldround.JTextFieldRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Bot_Regresar_Repo = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        Tablas_Pro = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setForeground(new java.awt.Color(232, 247, 252));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BuscarTabla_Bot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        BuscarTabla_Bot.setBorder(null);
        BuscarTabla_Bot.setBorderPainted(false);
        BuscarTabla_Bot.setContentAreaFilled(false);
        BuscarTabla_Bot.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BuscarTabla_Bot.setDefaultCapable(false);
        BuscarTabla_Bot.setFocusPainted(false);
        BuscarTabla_Bot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarTabla_BotActionPerformed(evt);
            }
        });
        jPanel1.add(BuscarTabla_Bot, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 50, 50));
        jPanel1.add(Txt_Buscar_Ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, 30));

        jPanel2.setBackground(new java.awt.Color(23, 161, 207));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO PROPIETARIOS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(294, 294, 294))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 60));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("SALIR");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 0, -1, 50));

        Bot_Regresar_Repo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_Regresar_Repo.setBorder(null);
        Bot_Regresar_Repo.setBorderPainted(false);
        Bot_Regresar_Repo.setContentAreaFilled(false);
        Bot_Regresar_Repo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_Regresar_Repo.setFocusPainted(false);
        Bot_Regresar_Repo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_Regresar_RepoActionPerformed(evt);
            }
        });
        jPanel3.add(Bot_Regresar_Repo, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 50, 50));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 960, 70));

        Tablas_Pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tablas_Pro.setAltoHead(25);
        Tablas_Pro.setAutoscrolls(false);
        Tablas_Pro.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        Tablas_Pro.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Tablas_Pro.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Tablas_Pro.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tablas_Pro.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tablas_Pro.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tablas_Pro.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        Tablas_Pro.setColorSelForeground(new java.awt.Color(51, 51, 51));
        Tablas_Pro.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Pro.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Pro.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        Tablas_Pro.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane5.setViewportView(Tablas_Pro);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 920, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarTabla_BotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarTabla_BotActionPerformed

    }//GEN-LAST:event_BuscarTabla_BotActionPerformed

    private void Bot_Regresar_RepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_Regresar_RepoActionPerformed

    }//GEN-LAST:event_Bot_Regresar_RepoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportePropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportePropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportePropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportePropietarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportePropietarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Regresar_Repo;
    public javax.swing.JButton BuscarTabla_Bot;
    public rojeru_san.complementos.RSTableMetro Tablas_Pro;
    public jtextfieldround.JTextFieldRound Txt_Buscar_Ce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private jtextfieldround.JTextFieldRoundBeanInfo jTextFieldRoundBeanInfo1;
    // End of variables declaration//GEN-END:variables
}
