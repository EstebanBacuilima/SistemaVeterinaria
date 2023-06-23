package Vista;

import Controlador.ControladorServicios;
import Modelo.Servicio;

/**
 *
 *
 * @author ediss
 */
public class RegistrarServicios extends javax.swing.JFrame {

    /**
     * Creates new form V_reg_servicios
     */


    public RegistrarServicios() {
        initComponents();

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editars = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        S_cost = new jtextfieldround.JTextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        S_nom = new jtextfieldround.JTextFieldRound();
        S_id = new jtextfieldround.JTextFieldRound();
        S_Buscar = new jtextfieldround.JTextFieldRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Salir = new javax.swing.JButton();
        Bot_Limpiar = new javax.swing.JButton();
        limpiarrr1 = new javax.swing.JLabel();
        Sb_guardar = new javax.swing.JButton();
        Sb_eliminar = new javax.swing.JButton();
        Sb_actualizar = new javax.swing.JButton();
        Sinactivos = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        S_desc = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        S_Tabla = new rojeru_san.complementos.RSTableMetro();
        jLabel12 = new javax.swing.JLabel();
        S_cancelar = new javax.swing.JButton();

        Editars.setText("EDITAR");
        jPopupMenu1.add(Editars);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        S_cost.setPreferredSize(new java.awt.Dimension(250, 25));
        S_cost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                S_costKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S_costKeyReleased(evt);
            }
        });
        jPanel1.add(S_cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 160, 25));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        jLabel2.setText("NOMBRE:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 25));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("DESCRIPCIÓN:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, 30));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 125, 161));
        jLabel4.setText("PRECIO:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, 25));

        S_nom.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(S_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 200, -1));

        S_id.setEditable(false);
        jPanel1.add(S_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 40, -1));
        jPanel1.add(S_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 160, 30));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REGISTRO DE SERVICIOS");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, -1, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 810, 40));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SALIR");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, -1));

        Salir.setBackground(new java.awt.Color(0, 153, 153));
        Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Salir.setForeground(new java.awt.Color(0, 153, 153));
        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Salir.setBorder(null);
        Salir.setContentAreaFilled(false);
        jPanel3.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, 40, -1));

        Bot_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_Limpiar.setBorderPainted(false);
        Bot_Limpiar.setContentAreaFilled(false);
        Bot_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_LimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(Bot_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, -1));

        limpiarrr1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        limpiarrr1.setForeground(new java.awt.Color(255, 255, 255));
        limpiarrr1.setText("LIMPIAR");
        jPanel3.add(limpiarrr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 810, 50));

        Sb_guardar.setBackground(new java.awt.Color(0, 153, 153));
        Sb_guardar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Sb_guardar.setForeground(new java.awt.Color(18, 125, 161));
        Sb_guardar.setText("GUARDAR");
        Sb_guardar.setBorder(null);
        Sb_guardar.setContentAreaFilled(false);
        Sb_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Sb_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, -1));

        Sb_eliminar.setBackground(new java.awt.Color(0, 153, 153));
        Sb_eliminar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Sb_eliminar.setForeground(new java.awt.Color(18, 125, 161));
        Sb_eliminar.setText("ELIMINAR");
        Sb_eliminar.setBorder(null);
        Sb_eliminar.setContentAreaFilled(false);
        Sb_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Sb_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, -1));

        Sb_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        Sb_actualizar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Sb_actualizar.setForeground(new java.awt.Color(18, 125, 161));
        Sb_actualizar.setText("MODIFICAR");
        Sb_actualizar.setBorder(null);
        Sb_actualizar.setContentAreaFilled(false);
        Sb_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Sb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 100, -1));

        Sinactivos.setBackground(new java.awt.Color(246, 252, 254));
        Sinactivos.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Sinactivos.setForeground(new java.awt.Color(18, 125, 161));
        Sinactivos.setText("INACTIVOS");
        jPanel1.add(Sinactivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, -1, 20));

        S_desc.setColumns(20);
        S_desc.setLineWrap(true);
        S_desc.setRows(5);
        S_desc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(S_desc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 270, 110));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 100, 10));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 100, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, 10));

        S_Tabla = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        S_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio"
            }
        ));
        S_Tabla.setAltoHead(25);
        S_Tabla.setAutoscrolls(false);
        S_Tabla.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        S_Tabla.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        S_Tabla.setColorBordeHead(new java.awt.Color(255, 255, 255));
        S_Tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        S_Tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        S_Tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        S_Tabla.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        S_Tabla.setColorSelForeground(new java.awt.Color(51, 51, 51));
        S_Tabla.setComponentPopupMenu(jPopupMenu1);
        S_Tabla.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        S_Tabla.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        S_Tabla.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        S_Tabla.setGridColor(new java.awt.Color(0, 0, 0));
        S_Tabla.getTableHeader().setResizingAllowed(false);
        S_Tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(S_Tabla);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 350, 210));

        jLabel12.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(103, 206, 233));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        S_cancelar.setBackground(new java.awt.Color(23, 161, 207));
        S_cancelar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        S_cancelar.setForeground(new java.awt.Color(18, 125, 161));
        S_cancelar.setText("CANCELAR");
        S_cancelar.setBorder(null);
        S_cancelar.setContentAreaFilled(false);
        S_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(S_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 810, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void S_costKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S_costKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_S_costKeyPressed

    private void S_costKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S_costKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_S_costKeyReleased

    private void Bot_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_LimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_LimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//
        RegistrarServicios vistaServicios = new RegistrarServicios();
        Servicio modeloSer = new Servicio();

        ControladorServicios controlServicio = new ControladorServicios(modeloSer, vistaServicios);
        controlServicio.iniciar();

//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(V_reg_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(V_reg_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(V_reg_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(V_reg_servicios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_servicios().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Limpiar;
    public javax.swing.JMenuItem Editars;
    public jtextfieldround.JTextFieldRound S_Buscar;
    public rojeru_san.complementos.RSTableMetro S_Tabla;
    public javax.swing.JButton S_cancelar;
    public jtextfieldround.JTextFieldRound S_cost;
    public javax.swing.JTextArea S_desc;
    public jtextfieldround.JTextFieldRound S_id;
    public jtextfieldround.JTextFieldRound S_nom;
    public javax.swing.JButton Salir;
    public javax.swing.JButton Sb_actualizar;
    public javax.swing.JButton Sb_eliminar;
    public javax.swing.JButton Sb_guardar;
    public javax.swing.JCheckBox Sinactivos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    public javax.swing.JLabel limpiarrr1;
    // End of variables declaration//GEN-END:variables
}
