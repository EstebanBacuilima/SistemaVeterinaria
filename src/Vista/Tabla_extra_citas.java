/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author ediss
 */
public class Tabla_extra_citas extends javax.swing.JFrame {

    /**
     * Creates new form Tablas_extra_citas
     */
    public Tabla_extra_citas() {
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Salir_pm = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tablas_ext = new rojeru_san.complementos.RSTableMetro();
        jLabel12 = new javax.swing.JLabel();
        labelced = new javax.swing.JLabel();
        B_datos_ext = new jtextfieldround.JTextFieldRound();
        Bot_b_dueño = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REGISTRO DE PROPIETARIOS");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 870, 40));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SALIR");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, 20));

        Salir_pm.setBackground(new java.awt.Color(0, 153, 153));
        Salir_pm.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Salir_pm.setForeground(new java.awt.Color(0, 153, 153));
        Salir_pm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Salir_pm.setBorder(null);
        Salir_pm.setContentAreaFilled(false);
        Salir_pm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(Salir_pm, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 40, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 870, 40));

        Tablas_ext = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Tablas_ext.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        Tablas_ext.setAltoHead(25);
        Tablas_ext.setAutoscrolls(false);
        Tablas_ext.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        Tablas_ext.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Tablas_ext.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Tablas_ext.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Tablas_ext.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Tablas_ext.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Tablas_ext.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        Tablas_ext.setColorSelForeground(new java.awt.Color(51, 51, 51));
        Tablas_ext.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_ext.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Tablas_ext.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        Tablas_ext.setGridColor(new java.awt.Color(0, 0, 0));
        Tablas_ext.getTableHeader().setResizingAllowed(false);
        Tablas_ext.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(Tablas_ext);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 830, 280));

        jLabel12.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(103, 206, 233));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        labelced.setBackground(new java.awt.Color(18, 125, 161));
        labelced.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        labelced.setForeground(new java.awt.Color(18, 125, 161));
        labelced.setText("Cedula del Propietario");
        jPanel1.add(labelced, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, 25));
        jPanel1.add(B_datos_ext, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 200, 30));

        Bot_b_dueño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_b_dueño.setBorderPainted(false);
        Bot_b_dueño.setContentAreaFilled(false);
        jPanel1.add(Bot_b_dueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tabla_extra_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla_extra_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla_extra_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla_extra_citas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Tabla_extra_citas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public jtextfieldround.JTextFieldRound B_datos_ext;
    public javax.swing.JButton Bot_b_dueño;
    public javax.swing.JButton Salir_pm;
    public rojeru_san.complementos.RSTableMetro Tablas_ext;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JLabel labelced;
    // End of variables declaration//GEN-END:variables
}
