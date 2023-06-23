package Vista;

import Modelo.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReporteMascotas extends javax.swing.JFrame {

    public ReporteMascotas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldRoundBeanInfo1 = new jtextfieldround.JTextFieldRoundBeanInfo();
        jPanel1 = new javax.swing.JPanel();
        Txt_Buscar_Ce = new jtextfieldround.JTextFieldRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Bot_buscar_tabla = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Bot_Regresar_Repo = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablas_Pacientes_2 = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(Txt_Buscar_Ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, -1, 30));

        jPanel2.setBackground(new java.awt.Color(23, 161, 207));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO MASCOTAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 60));

        Bot_buscar_tabla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_buscar_tabla.setBorder(null);
        Bot_buscar_tabla.setBorderPainted(false);
        Bot_buscar_tabla.setContentAreaFilled(false);
        Bot_buscar_tabla.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_buscar_tabla.setFocusPainted(false);
        Bot_buscar_tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_buscar_tablaActionPerformed(evt);
            }
        });
        jPanel1.add(Bot_buscar_tabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 60, 50, 50));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 960, 50));

        Tablas_Pacientes_2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tablas_Pacientes_2.setAltoHead(25);
        Tablas_Pacientes_2.setAutoscrolls(false);
        Tablas_Pacientes_2.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        Tablas_Pacientes_2.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Tablas_Pacientes_2.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Tablas_Pacientes_2.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tablas_Pacientes_2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tablas_Pacientes_2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tablas_Pacientes_2.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        Tablas_Pacientes_2.setColorSelForeground(new java.awt.Color(51, 51, 51));
        Tablas_Pacientes_2.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Pacientes_2.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Pacientes_2.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        Tablas_Pacientes_2.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane3.setViewportView(Tablas_Pacientes_2);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 920, 410));

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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bot_buscar_tablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_buscar_tablaActionPerformed

    }//GEN-LAST:event_Bot_buscar_tablaActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ReporteMascotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Regresar_Repo;
    public javax.swing.JButton Bot_buscar_tabla;
    public rojeru_san.complementos.RSTableMetro Tablas_Pacientes_2;
    public jtextfieldround.JTextFieldRound Txt_Buscar_Ce;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private jtextfieldround.JTextFieldRoundBeanInfo jTextFieldRoundBeanInfo1;
    // End of variables declaration//GEN-END:variables
}
