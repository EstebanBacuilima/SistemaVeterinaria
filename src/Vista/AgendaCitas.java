package Vista;

import Controlador.ControladorAgendaCitas;

public class AgendaCitas extends javax.swing.JFrame {

    public AgendaCitas() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Bot_tabla = new javax.swing.JPopupMenu();
        B_cancelarcita = new javax.swing.JMenuItem();
        B_citaatendida = new javax.swing.JMenuItem();
        B_Reagendarcita = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        Bot_Regresar1 = new javax.swing.JButton();
        B_Canceladas = new javax.swing.JButton();
        B_todas = new javax.swing.JButton();
        B_Proximas = new javax.swing.JButton();
        B_atendidas = new javax.swing.JButton();
        B_actuales = new javax.swing.JButton();
        Id_Personal = new jtextfieldround.JTextFieldRound();
        Tipo_emp = new jtextfieldround.JTextFieldRound();
        prueba = new javax.swing.JButton();
        Panel_reagendar = new javax.swing.JPanel();
        C_hini1 = new javax.swing.JLabel();
        C_combohoras = new javax.swing.JComboBox<>();
        C_hini = new javax.swing.JLabel();
        C_hora = new javax.swing.JSpinner();
        h_f_rango = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Confirmar = new javax.swing.JButton();
        Id_cita = new jtextfieldround.JTextFieldRound();
        Cancelar_r = new javax.swing.JButton();
        C_fecha = new com.toedter.calendar.JDateChooser();
        F_fecha = new rojeru_san.rsdate.RSLabelFecha();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_agendac = new rojeru_san.complementos.RSTableMetro();
        jLabel13 = new javax.swing.JLabel();

        B_cancelarcita.setText("Cancelar_cita");
        Bot_tabla.add(B_cancelarcita);

        B_citaatendida.setText("Cita Atendida");
        B_citaatendida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_citaatendidaActionPerformed(evt);
            }
        });
        Bot_tabla.add(B_citaatendida);

        B_Reagendarcita.setText("Reagendar Cita");
        Bot_tabla.add(B_Reagendarcita);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AGENDA DE CITAS");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 40));

        jPanel5.setBackground(new java.awt.Color(23, 161, 207));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SALIR");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, 40));

        Bot_Regresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_Regresar1.setBorderPainted(false);
        Bot_Regresar1.setContentAreaFilled(false);
        Bot_Regresar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.add(Bot_Regresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 50, 40));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1000, 60));

        B_Canceladas.setBackground(new java.awt.Color(255, 51, 51));
        B_Canceladas.setText("Canceladas");
        B_Canceladas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_Canceladas.setFocusPainted(false);
        jPanel1.add(B_Canceladas, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, 190, 40));

        B_todas.setBackground(new java.awt.Color(255, 255, 102));
        B_todas.setText("Todas");
        B_todas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_todas.setFocusPainted(false);
        jPanel1.add(B_todas, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 190, 40));

        B_Proximas.setBackground(new java.awt.Color(204, 255, 255));
        B_Proximas.setText("Proximas ");
        B_Proximas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_Proximas.setFocusPainted(false);
        jPanel1.add(B_Proximas, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 190, 40));

        B_atendidas.setBackground(new java.awt.Color(102, 255, 102));
        B_atendidas.setText("Atendidas");
        B_atendidas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_atendidas.setFocusPainted(false);
        jPanel1.add(B_atendidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 190, 40));

        B_actuales.setBackground(new java.awt.Color(204, 255, 255));
        B_actuales.setText("Hoy");
        B_actuales.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        B_actuales.setFocusPainted(false);
        jPanel1.add(B_actuales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 40));
        jPanel1.add(Id_Personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 80, -1));
        jPanel1.add(Tipo_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 110, -1));
        jPanel1.add(prueba, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 50, 30));

        Panel_reagendar.setBackground(new java.awt.Color(246, 252, 254));
        Panel_reagendar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        C_hini1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hini1.setForeground(new java.awt.Color(97, 161, 187));
        C_hini1.setText("Horarios de atencion");
        Panel_reagendar.add(C_hini1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 20, -1, 20));

        C_combohoras.setForeground(new java.awt.Color(18, 125, 161));
        C_combohoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar Horario" }));
        Panel_reagendar.add(C_combohoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 200, 30));

        C_hini.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hini.setForeground(new java.awt.Color(97, 161, 187));
        C_hini.setText("Nueva Hora");
        Panel_reagendar.add(C_hini, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 20));

        C_hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel_reagendar.add(C_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 70, 30));

        h_f_rango.setForeground(new java.awt.Color(204, 0, 0));
        h_f_rango.setText("*Selecionar dentro del rango");
        Panel_reagendar.add(h_f_rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(97, 161, 187));
        jLabel3.setText("Nueva Fecha:");
        Panel_reagendar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, 20));

        Confirmar.setForeground(new java.awt.Color(18, 125, 161));
        Confirmar.setText("Confirmar");
        Confirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Confirmar.setFocusPainted(false);
        Panel_reagendar.add(Confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 50, -1, -1));
        Panel_reagendar.add(Id_cita, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 60, -1));

        Cancelar_r.setBackground(new java.awt.Color(255, 255, 255));
        Cancelar_r.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Cancelar_r.setForeground(new java.awt.Color(255, 0, 0));
        Cancelar_r.setText("X");
        Cancelar_r.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Cancelar_r.setFocusPainted(false);
        Panel_reagendar.add(Cancelar_r, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, -1, -1));

        C_fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                C_fechaPropertyChange(evt);
            }
        });
        Panel_reagendar.add(C_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 210, 30));

        jPanel1.add(Panel_reagendar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1000, 100));

        F_fecha.setForeground(new java.awt.Color(246, 252, 254));
        jPanel1.add(F_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 0, 90, 40));

        T_agendac = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        T_agendac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_agendac.setAltoHead(25);
        T_agendac.setAutoscrolls(false);
        T_agendac.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        T_agendac.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        T_agendac.setColorBordeHead(new java.awt.Color(255, 255, 255));
        T_agendac.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        T_agendac.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        T_agendac.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        T_agendac.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        T_agendac.setColorSelForeground(new java.awt.Color(51, 51, 51));
        T_agendac.setComponentPopupMenu(Bot_tabla);
        T_agendac.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_agendac.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_agendac.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        T_agendac.setGridColor(new java.awt.Color(0, 0, 0));
        T_agendac.getTableHeader().setResizingAllowed(false);
        T_agendac.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(T_agendac);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 920, 290));

        jLabel13.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(103, 206, 233));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_citaatendidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_citaatendidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_citaatendidaActionPerformed

    private void C_fechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_C_fechaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_C_fechaPropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        AgendaCitas v=new AgendaCitas();
        ControladorAgendaCitas c=new ControladorAgendaCitas(v);
        c.inciar();
        v.setVisible(true);
        v.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(AgendaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgendaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgendaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgendaCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new AgendaCitas().setVisible(true);
//                
//                
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton B_Canceladas;
    public javax.swing.JButton B_Proximas;
    public javax.swing.JMenuItem B_Reagendarcita;
    public javax.swing.JButton B_actuales;
    public javax.swing.JButton B_atendidas;
    public javax.swing.JMenuItem B_cancelarcita;
    public javax.swing.JMenuItem B_citaatendida;
    public javax.swing.JButton B_todas;
    public javax.swing.JButton Bot_Regresar1;
    private javax.swing.JPopupMenu Bot_tabla;
    public javax.swing.JComboBox<String> C_combohoras;
    public com.toedter.calendar.JDateChooser C_fecha;
    private javax.swing.JLabel C_hini;
    private javax.swing.JLabel C_hini1;
    public javax.swing.JSpinner C_hora;
    public javax.swing.JButton Cancelar_r;
    public javax.swing.JButton Confirmar;
    public rojeru_san.rsdate.RSLabelFecha F_fecha;
    public jtextfieldround.JTextFieldRound Id_Personal;
    public jtextfieldround.JTextFieldRound Id_cita;
    public javax.swing.JPanel Panel_reagendar;
    public rojeru_san.complementos.RSTableMetro T_agendac;
    public jtextfieldround.JTextFieldRound Tipo_emp;
    public javax.swing.JLabel h_f_rango;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JButton prueba;
    // End of variables declaration//GEN-END:variables
}
