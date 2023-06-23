package Vista;
import Controlador.ControladorConsultorio;
import Modelo.Consultorio;
public class RegistrarConsultorios extends javax.swing.JFrame {

    public RegistrarConsultorios() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editarco = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Co_nom = new jtextfieldround.JTextFieldRound();
        Co_id = new jtextfieldround.JTextFieldRound();
        S_Buscar = new jtextfieldround.JTextFieldRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        salir = new javax.swing.JButton();
        limpiarrr1 = new javax.swing.JLabel();
        Bot_Limpiar = new javax.swing.JButton();
        Cob_guardar = new javax.swing.JButton();
        Cob_eliminar = new javax.swing.JButton();
        Cob_actualizar = new javax.swing.JButton();
        Coinactivos = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        Co_desc = new javax.swing.JTextArea();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        Co_Tabla = new rojeru_san.complementos.RSTableMetro();
        jLabel12 = new javax.swing.JLabel();
        Cob_cancelar = new javax.swing.JButton();
        jSeparator11 = new javax.swing.JSeparator();

        Editarco.setText("EDITAR");
        jPopupMenu1.add(Editarco);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(23, 161, 207));
        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        jLabel2.setText("NOMBRE: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, 25));

        jLabel3.setBackground(new java.awt.Color(23, 161, 207));
        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("DESCRIPCION:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        Co_nom.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(Co_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 160, -1));

        Co_id.setEditable(false);
        jPanel1.add(Co_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 40, -1));

        S_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                S_BuscarKeyReleased(evt);
            }
        });
        jPanel1.add(S_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 160, 30));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("REGISTRO DE AREA DE TRABAJO");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 790, 40));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SALIR");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, -1, -1));

        salir.setBackground(new java.awt.Color(0, 153, 153));
        salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        salir.setForeground(new java.awt.Color(0, 153, 153));
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        salir.setBorder(null);
        salir.setContentAreaFilled(false);
        salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        salir.setFocusPainted(false);
        jPanel3.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 40, -1));

        limpiarrr1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        limpiarrr1.setForeground(new java.awt.Color(255, 255, 255));
        limpiarrr1.setText("LIMPIAR");
        jPanel3.add(limpiarrr1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 20));

        Bot_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_Limpiar.setBorderPainted(false);
        Bot_Limpiar.setContentAreaFilled(false);
        Bot_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_LimpiarActionPerformed(evt);
            }
        });
        jPanel3.add(Bot_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 790, 50));

        Cob_guardar.setBackground(new java.awt.Color(23, 161, 207));
        Cob_guardar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Cob_guardar.setForeground(new java.awt.Color(18, 125, 161));
        Cob_guardar.setText("GUARDAR");
        Cob_guardar.setBorder(null);
        Cob_guardar.setContentAreaFilled(false);
        Cob_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Cob_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, -1));

        Cob_eliminar.setBackground(new java.awt.Color(23, 161, 207));
        Cob_eliminar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Cob_eliminar.setForeground(new java.awt.Color(18, 125, 161));
        Cob_eliminar.setText("ELIMINAR");
        Cob_eliminar.setBorder(null);
        Cob_eliminar.setContentAreaFilled(false);
        Cob_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Cob_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, -1));

        Cob_actualizar.setBackground(new java.awt.Color(23, 161, 207));
        Cob_actualizar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Cob_actualizar.setForeground(new java.awt.Color(18, 125, 161));
        Cob_actualizar.setText("MODIFICAR");
        Cob_actualizar.setBorder(null);
        Cob_actualizar.setContentAreaFilled(false);
        Cob_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Cob_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 100, -1));

        Coinactivos.setBackground(new java.awt.Color(246, 252, 254));
        Coinactivos.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Coinactivos.setForeground(new java.awt.Color(18, 125, 161));
        Coinactivos.setText("INACTIVOS");
        jPanel1.add(Coinactivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 420, -1, 20));

        Co_desc.setColumns(20);
        Co_desc.setLineWrap(true);
        Co_desc.setRows(5);
        Co_desc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(Co_desc);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 290, 100));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 100, 10));
        jPanel1.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 100, 10));

        Co_Tabla = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Co_Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Descripcion"
            }
        ));
        Co_Tabla.setAltoHead(25);
        Co_Tabla.setAutoscrolls(false);
        Co_Tabla.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        Co_Tabla.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        Co_Tabla.setColorBordeHead(new java.awt.Color(255, 255, 255));
        Co_Tabla.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        Co_Tabla.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        Co_Tabla.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        Co_Tabla.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        Co_Tabla.setColorSelForeground(new java.awt.Color(51, 51, 51));
        Co_Tabla.setComponentPopupMenu(jPopupMenu1);
        Co_Tabla.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Co_Tabla.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Co_Tabla.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        Co_Tabla.setGridColor(new java.awt.Color(0, 0, 0));
        Co_Tabla.getTableHeader().setResizingAllowed(false);
        Co_Tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(Co_Tabla);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 400, 210));

        jLabel12.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(103, 206, 233));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        Cob_cancelar.setBackground(new java.awt.Color(23, 161, 207));
        Cob_cancelar.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        Cob_cancelar.setForeground(new java.awt.Color(18, 125, 161));
        Cob_cancelar.setText("CANCELAR");
        Cob_cancelar.setBorder(null);
        Cob_cancelar.setContentAreaFilled(false);
        Cob_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(Cob_cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, -1));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 100, 10));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void S_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_S_BuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_S_BuscarKeyReleased

    private void Bot_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_LimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_LimpiarActionPerformed

    /** 
     * 
     */
    public static void main(String args[]) {
        RegistrarConsultorios v=new RegistrarConsultorios();
        Consultorio modelo = new Consultorio();
        ControladorConsultorio control = new ControladorConsultorio(modelo,v);
        control.iniciar();

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
    public rojeru_san.complementos.RSTableMetro Co_Tabla;
    public javax.swing.JTextArea Co_desc;
    public jtextfieldround.JTextFieldRound Co_id;
    public jtextfieldround.JTextFieldRound Co_nom;
    public javax.swing.JButton Cob_actualizar;
    public javax.swing.JButton Cob_cancelar;
    public javax.swing.JButton Cob_eliminar;
    public javax.swing.JButton Cob_guardar;
    public javax.swing.JCheckBox Coinactivos;
    public javax.swing.JMenuItem Editarco;
    public jtextfieldround.JTextFieldRound S_Buscar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator8;
    public javax.swing.JLabel limpiarrr1;
    public javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
