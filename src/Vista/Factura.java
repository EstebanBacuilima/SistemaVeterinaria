package Vista;

public class Factura extends javax.swing.JFrame {

    public Factura() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        Editarco = new javax.swing.JMenuItem();
        Eliminars = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        F_ced = new jtextfieldround.JTextFieldRound();
        F_id = new jtextfieldround.JTextFieldRound();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Salir_F = new javax.swing.JButton();
        Imprimir = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        F_direc = new jtextfieldround.JTextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        F_total = new jtextfieldround.JTextFieldRound();
        jLabel7 = new javax.swing.JLabel();
        F_Telef = new jtextfieldround.JTextFieldRound();
        F_coreo = new jtextfieldround.JTextFieldRound();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        F_nom = new jtextfieldround.JTextFieldRound();
        jLabel10 = new javax.swing.JLabel();
        F_idp = new jtextfieldround.JTextFieldRound();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_factura = new rojeru_san.complementos.RSTableMetro();
        F_fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel14 = new javax.swing.JLabel();

        Editarco.setText("EDITAR");
        jPopupMenu1.add(Editarco);

        Eliminars.setText("ELIMINAR");
        jPopupMenu1.add(Eliminars);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(18, 125, 161));
        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(18, 125, 161));
        jLabel1.setText("FACTURA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 80, 30));

        jLabel2.setBackground(new java.awt.Color(18, 125, 161));
        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        jLabel2.setText("Direccion");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 20));

        F_ced.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 140, -1));

        F_id.setEditable(false);
        F_id.setBackground(new java.awt.Color(246, 252, 254));
        F_id.setBorder(null);
        F_id.setCaretColor(new java.awt.Color(246, 252, 254));
        F_id.setForeground(new java.awt.Color(246, 252, 254));
        jPanel1.add(F_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 30, 30));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("FACTURA");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 590, 40));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("SALIR");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, 20));

        Salir_F.setBackground(new java.awt.Color(0, 153, 153));
        Salir_F.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Salir_F.setForeground(new java.awt.Color(0, 153, 153));
        Salir_F.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Salir_F.setBorder(null);
        Salir_F.setContentAreaFilled(false);
        Salir_F.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir_F.setFocusPainted(false);
        jPanel3.add(Salir_F, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 40, -1));

        Imprimir.setBackground(new java.awt.Color(255, 255, 255));
        Imprimir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Imprimir.setText("Imprimir");
        Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Imprimir.setFocusPainted(false);
        jPanel3.add(Imprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 140, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 590, 50));

        jLabel3.setBackground(new java.awt.Color(18, 125, 161));
        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("Telefono");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, 25));

        F_direc.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_direc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 470, -1));

        jLabel5.setBackground(new java.awt.Color(18, 125, 161));
        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 125, 161));
        jLabel5.setText("Total:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 410, -1, 25));

        F_total.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 90, -1));

        jLabel7.setBackground(new java.awt.Color(246, 252, 254));
        jLabel7.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(246, 252, 254));
        jLabel7.setText("Cliente");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 25));

        F_Telef.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_Telef, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 140, -1));

        F_coreo.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_coreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 250, -1));

        jLabel11.setBackground(new java.awt.Color(18, 125, 161));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 125, 161));
        jLabel11.setText("Nombre");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, -1, 25));

        jLabel12.setBackground(new java.awt.Color(18, 125, 161));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(18, 125, 161));
        jLabel12.setText("Correo");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, -1, 25));

        F_nom.setPreferredSize(new java.awt.Dimension(250, 25));
        jPanel1.add(F_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 250, -1));

        jLabel10.setBackground(new java.awt.Color(18, 125, 161));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 125, 161));
        jLabel10.setText("Cedula");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 25));

        F_idp.setEditable(false);
        F_idp.setBackground(new java.awt.Color(246, 252, 254));
        F_idp.setBorder(null);
        jPanel1.add(F_idp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 20, 20));

        T_factura = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        T_factura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_factura.setAltoHead(25);
        T_factura.setAutoscrolls(false);
        T_factura.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        T_factura.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        T_factura.setColorBordeHead(new java.awt.Color(255, 255, 255));
        T_factura.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        T_factura.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        T_factura.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        T_factura.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        T_factura.setColorSelForeground(new java.awt.Color(51, 51, 51));
        T_factura.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_factura.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_factura.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        T_factura.setGridColor(new java.awt.Color(0, 0, 0));
        T_factura.getTableHeader().setResizingAllowed(false);
        T_factura.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(T_factura);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 450, 180));

        F_fecha.setBackground(new java.awt.Color(18, 125, 161));
        F_fecha.setForeground(new java.awt.Color(246, 252, 254));
        jPanel1.add(F_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 90, 20));

        jLabel14.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(103, 206, 233));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** 
     * 
     */
    public static void main(String args[]) {
//        Factura v=new Factura();
//        v.setVisible(true);
//        v.setLocationRelativeTo(null);
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
    public javax.swing.JMenuItem Editarco;
    private javax.swing.JMenuItem Eliminars;
    public jtextfieldround.JTextFieldRound F_Telef;
    public jtextfieldround.JTextFieldRound F_ced;
    public jtextfieldround.JTextFieldRound F_coreo;
    public jtextfieldround.JTextFieldRound F_direc;
    public rojeru_san.rsdate.RSLabelFecha F_fecha;
    public jtextfieldround.JTextFieldRound F_id;
    public jtextfieldround.JTextFieldRound F_idp;
    public jtextfieldround.JTextFieldRound F_nom;
    public jtextfieldround.JTextFieldRound F_total;
    public javax.swing.JButton Imprimir;
    public javax.swing.JButton Salir_F;
    public rojeru_san.complementos.RSTableMetro T_factura;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
