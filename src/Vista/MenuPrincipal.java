package Vista;

import java.awt.Toolkit;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel83 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        foto = new javax.swing.JLabel();
        Nombres = new javax.swing.JLabel();
        Text_ID = new javax.swing.JTextField();
        Text_Tipo = new javax.swing.JTextField();
        Text_Foto = new javax.swing.JTextField();
        Text_ID_secre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        fondo_menu = new javax.swing.JLabel();
        Text_Foto1 = new javax.swing.JTextField();
        Text_ID1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu_Inicio = new javax.swing.JMenu();
        Menu_Pro = new javax.swing.JMenu();
        Item_Reg_Pro = new javax.swing.JMenuItem();
        Menu_Pac = new javax.swing.JMenu();
        Item_reg_paciente = new javax.swing.JMenuItem();
        Item_historiaal = new javax.swing.JMenuItem();
        Menu_Citas = new javax.swing.JMenu();
        registrarCita = new javax.swing.JMenuItem();
        item_agenda_citas = new javax.swing.JMenuItem();
        Menu_Veterinarios = new javax.swing.JMenu();
        ItemRegistroMedico = new javax.swing.JMenuItem();
        Item_regi_secre = new javax.swing.JMenuItem();
        ItemRegistroAuxiliar = new javax.swing.JMenuItem();
        Menu_laboratorio = new javax.swing.JMenu();
        Item_Examen = new javax.swing.JMenuItem();
        ItemRegistroReceta = new javax.swing.JMenuItem();
        Menu_Servicios = new javax.swing.JMenu();
        AgreServicio = new javax.swing.JMenuItem();
        Menu_reportes = new javax.swing.JMenu();
        VerActivosReport = new javax.swing.JMenuItem();
        Menu_admin = new javax.swing.JMenu();
        Item_reg_user = new javax.swing.JMenuItem();
        RegConsultorio = new javax.swing.JMenuItem();
        Item_Horario = new javax.swing.JMenuItem();
        Menu_Salir = new javax.swing.JMenu();
        Salir_Todo = new javax.swing.JMenuItem();

        jLabel83.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_dog_paw_50px.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1091, 727));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1091, 727));

        jDesktopPane1.setBackground(new java.awt.Color(204, 255, 255));
        jDesktopPane1.setForeground(new java.awt.Color(204, 255, 255));
        jDesktopPane1.setToolTipText("");
        jDesktopPane1.setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        foto.setForeground(new java.awt.Color(23, 161, 207));
        foto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(23, 161, 207)));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 100, 110));

        Nombres.setFont(new java.awt.Font("Nirmala UI", 1, 18)); // NOI18N
        Nombres.setForeground(new java.awt.Color(23, 161, 207));
        Nombres.setText("Nombres");
        jPanel1.add(Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 300, 30));

        Text_ID.setBackground(new java.awt.Color(246, 252, 254));
        Text_ID.setForeground(new java.awt.Color(246, 252, 254));
        Text_ID.setBorder(null);
        jPanel1.add(Text_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 70, -1));

        Text_Tipo.setBackground(new java.awt.Color(246, 252, 254));
        Text_Tipo.setForeground(new java.awt.Color(246, 252, 254));
        Text_Tipo.setBorder(null);
        jPanel1.add(Text_Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 70, -1));

        Text_Foto.setBackground(new java.awt.Color(246, 252, 254));
        Text_Foto.setForeground(new java.awt.Color(246, 252, 254));
        Text_Foto.setBorder(null);
        jPanel1.add(Text_Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 100, -1));

        Text_ID_secre.setBackground(new java.awt.Color(246, 252, 254));
        Text_ID_secre.setForeground(new java.awt.Color(246, 252, 254));
        Text_ID_secre.setBorder(null);
        jPanel1.add(Text_ID_secre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 70, -1));

        jLabel2.setBackground(new java.awt.Color(246, 252, 254));
        jLabel2.setOpaque(true);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 250, 370));

        fondo_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoMenu2.jpg"))); // NOI18N
        fondo_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fondo_menuMouseClicked(evt);
            }
        });
        jPanel1.add(fondo_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 700));

        Text_Foto1.setBorder(null);
        jPanel1.add(Text_Foto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 100, -1));

        Text_ID1.setBorder(null);
        jPanel1.add(Text_ID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 70, -1));

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1104, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 699, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setFont(new java.awt.Font("Ebrima", 1, 15)); // NOI18N

        Menu_Inicio.setBackground(new java.awt.Color(255, 255, 255));
        Menu_Inicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_home_page_25px_1.png"))); // NOI18N
        Menu_Inicio.setText("Bienvenido");
        Menu_Inicio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.add(Menu_Inicio);

        Menu_Pro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_dog_training_25px.png"))); // NOI18N
        Menu_Pro.setText("Propietarios");
        Menu_Pro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Item_Reg_Pro.setText("Registrar Propietarios");
        Item_Reg_Pro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Item_Reg_Pro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_Reg_ProActionPerformed(evt);
            }
        });
        Menu_Pro.add(Item_Reg_Pro);

        jMenuBar1.add(Menu_Pro);

        Menu_Pac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_pets_25px_1.png"))); // NOI18N
        Menu_Pac.setText("Pacientes");
        Menu_Pac.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Item_reg_paciente.setText("Registro Mascotas");
        Item_reg_paciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Item_reg_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_reg_pacienteActionPerformed(evt);
            }
        });
        Menu_Pac.add(Item_reg_paciente);

        Item_historiaal.setText("Historial Clinico");
        Item_historiaal.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Pac.add(Item_historiaal);

        jMenuBar1.add(Menu_Pac);

        Menu_Citas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_schedule_25px.png"))); // NOI18N
        Menu_Citas.setText("Citas");
        Menu_Citas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        registrarCita.setText("Registrar Cita");
        registrarCita.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        registrarCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarCitaActionPerformed(evt);
            }
        });
        Menu_Citas.add(registrarCita);

        item_agenda_citas.setText("Agenda de Citas");
        item_agenda_citas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Citas.add(item_agenda_citas);

        jMenuBar1.add(Menu_Citas);

        Menu_Veterinarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_veterinarian_male_skin_type_2_25px.png"))); // NOI18N
        Menu_Veterinarios.setText("Empleados");
        Menu_Veterinarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        ItemRegistroMedico.setText("Registrar Veterinario");
        ItemRegistroMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Veterinarios.add(ItemRegistroMedico);

        Item_regi_secre.setText("Registrar Secretaria");
        Item_regi_secre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Veterinarios.add(Item_regi_secre);

        ItemRegistroAuxiliar.setText("Registrar Auxiliar");
        ItemRegistroAuxiliar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ItemRegistroAuxiliar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemRegistroAuxiliarActionPerformed(evt);
            }
        });
        Menu_Veterinarios.add(ItemRegistroAuxiliar);

        jMenuBar1.add(Menu_Veterinarios);

        Menu_laboratorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_laboratory_25px.png"))); // NOI18N
        Menu_laboratorio.setText("Laboratorio");
        Menu_laboratorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Item_Examen.setText("Examen");
        Item_Examen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_laboratorio.add(Item_Examen);

        ItemRegistroReceta.setText("Receta");
        ItemRegistroReceta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_laboratorio.add(ItemRegistroReceta);

        jMenuBar1.add(Menu_laboratorio);

        Menu_Servicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_home_salon_25px.png"))); // NOI18N
        Menu_Servicios.setText("Servicios");
        Menu_Servicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        AgreServicio.setText("Agregar Servicio");
        AgreServicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Servicios.add(AgreServicio);

        jMenuBar1.add(Menu_Servicios);

        Menu_reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_report_file_25px_1.png"))); // NOI18N
        Menu_reportes.setText("Reportes");
        Menu_reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        VerActivosReport.setText("Ver Reportes");
        VerActivosReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_reportes.add(VerActivosReport);

        jMenuBar1.add(Menu_reportes);

        Menu_admin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_microsoft_admin_25px.png"))); // NOI18N
        Menu_admin.setText("Administracion");
        Menu_admin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Item_reg_user.setText("Usuario");
        Item_reg_user.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Item_reg_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_reg_userActionPerformed(evt);
            }
        });
        Menu_admin.add(Item_reg_user);

        RegConsultorio.setText("Area de Trabajo");
        RegConsultorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_admin.add(RegConsultorio);

        Item_Horario.setText("Horarios");
        Item_Horario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Item_Horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_HorarioActionPerformed(evt);
            }
        });
        Menu_admin.add(Item_Horario);

        jMenuBar1.add(Menu_admin);

        Menu_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Logout_25px.png"))); // NOI18N
        Menu_Salir.setText("Salir");
        Menu_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Salir_Todo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, java.awt.event.InputEvent.SHIFT_DOWN_MASK));
        Salir_Todo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_cancel_25px_1.png"))); // NOI18N
        Salir_Todo.setText("Salir");
        Salir_Todo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Menu_Salir.add(Salir_Todo);

        jMenuBar1.add(Menu_Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Item_reg_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_reg_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_reg_pacienteActionPerformed

    private void Item_Reg_ProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_Reg_ProActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_Reg_ProActionPerformed

    private void registrarCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarCitaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_registrarCitaActionPerformed

    private void ItemRegistroAuxiliarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemRegistroAuxiliarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemRegistroAuxiliarActionPerformed

    private void Item_HorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_HorarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_HorarioActionPerformed

    private void Item_reg_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_reg_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Item_reg_userActionPerformed

    private void fondo_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fondo_menuMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fondo_menuMouseClicked

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem AgreServicio;
    public javax.swing.JMenuItem ItemRegistroAuxiliar;
    public javax.swing.JMenuItem ItemRegistroMedico;
    public javax.swing.JMenuItem ItemRegistroReceta;
    public javax.swing.JMenuItem Item_Examen;
    public javax.swing.JMenuItem Item_Horario;
    public javax.swing.JMenuItem Item_Reg_Pro;
    public javax.swing.JMenuItem Item_historiaal;
    public javax.swing.JMenuItem Item_reg_paciente;
    public javax.swing.JMenuItem Item_reg_user;
    public javax.swing.JMenuItem Item_regi_secre;
    public javax.swing.JMenu Menu_Citas;
    public javax.swing.JMenu Menu_Inicio;
    public javax.swing.JMenu Menu_Pac;
    public javax.swing.JMenu Menu_Pro;
    public javax.swing.JMenu Menu_Salir;
    public javax.swing.JMenu Menu_Servicios;
    public javax.swing.JMenu Menu_Veterinarios;
    public javax.swing.JMenu Menu_admin;
    public javax.swing.JMenu Menu_laboratorio;
    public javax.swing.JMenu Menu_reportes;
    public javax.swing.JLabel Nombres;
    public javax.swing.JMenuItem RegConsultorio;
    public javax.swing.JMenuItem Salir_Todo;
    public javax.swing.JTextField Text_Foto;
    public javax.swing.JTextField Text_Foto1;
    public javax.swing.JTextField Text_ID;
    public javax.swing.JTextField Text_ID1;
    public javax.swing.JTextField Text_ID_secre;
    public javax.swing.JTextField Text_Tipo;
    public javax.swing.JMenuItem VerActivosReport;
    public javax.swing.JLabel fondo_menu;
    public javax.swing.JLabel foto;
    public javax.swing.JMenuItem item_agenda_citas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel83;
    public javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JMenuItem registrarCita;
    // End of variables declaration//GEN-END:variables
}
