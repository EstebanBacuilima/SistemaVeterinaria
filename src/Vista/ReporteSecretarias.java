/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author edu
 */
public class ReporteSecretarias extends javax.swing.JFrame {

    /**
     * Creates new form ReporteSecretarias
     */
    public ReporteSecretarias() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Bot_Regresar_Repo = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        Txt_Buscar_Ce = new jtextfieldround.JTextFieldRound();
        jButton8 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Tablas_Secre = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(23, 161, 207));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO SECRETARIAS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 50));

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

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Txt_Buscar_Ce.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jPanel1.add(Txt_Buscar_Ce, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, -1, 30));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setDefaultCapable(false);
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 60, 50, 50));

        Tablas_Secre.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tablas_Secre.setAltoHead(25);
        Tablas_Secre.setAutoscrolls(false);
        Tablas_Secre.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        Tablas_Secre.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Tablas_Secre.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Tablas_Secre.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tablas_Secre.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tablas_Secre.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tablas_Secre.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        Tablas_Secre.setColorSelForeground(new java.awt.Color(51, 51, 51));
        Tablas_Secre.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Secre.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_Secre.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        Tablas_Secre.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane4.setViewportView(Tablas_Secre);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 920, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed

    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteSecretarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteSecretarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteSecretarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteSecretarias.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteSecretarias().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Regresar_Repo;
    public rojeru_san.complementos.RSTableMetro Tablas_Secre;
    public jtextfieldround.JTextFieldRound Txt_Buscar_Ce;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
