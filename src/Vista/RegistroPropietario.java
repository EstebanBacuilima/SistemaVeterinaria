package Vista;

public class RegistroPropietario extends javax.swing.JFrame {

    public RegistroPropietario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        Genero = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Txt_buscar_mascota = new jtextfieldround.JTextFieldRound();
        jLabel12 = new javax.swing.JLabel();
        Bot_buscar_mascota = new javax.swing.JButton();
        ErrorFaltaTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Bot_eliminar = new javax.swing.JButton();
        Bot_registrar = new javax.swing.JButton();
        Bot_actualizar = new javax.swing.JButton();
        PropirtarioNomSeg = new jtextfieldround.JTextFieldRound();
        jLabel3 = new javax.swing.JLabel();
        PropietarioNomPrim = new jtextfieldround.JTextFieldRound();
        jLabel4 = new javax.swing.JLabel();
        PropietarioApellPri = new jtextfieldround.JTextFieldRound();
        PropietarioApellSeg = new jtextfieldround.JTextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        PropietarioFechaNac = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Masculino = new javax.swing.JRadioButton();
        Femenino = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PropietarioCorreo = new jtextfieldround.JTextFieldRound();
        PropietarioDirec = new jtextfieldround.JTextFieldRound();
        jLabel11 = new javax.swing.JLabel();
        PropietarioCedula = new jtextfieldround.JTextFieldRound();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        Bot_Limpiar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        Bot_Regresar = new javax.swing.JButton();
        Bot_Reporte = new javax.swing.JButton();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        Id_Persona = new javax.swing.JTextField();
        Id_propietario = new javax.swing.JTextField();
        ErrorCed = new javax.swing.JLabel();
        ErrorFecha = new javax.swing.JLabel();
        ErrorCorreo = new javax.swing.JLabel();
        PropietarioTelf = new javax.swing.JFormattedTextField();
        PropietarioCelular = new javax.swing.JFormattedTextField();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(246, 252, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(Txt_buscar_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 28, -1, 30));

        jLabel12.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(103, 206, 233));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 160, 90));

        Bot_buscar_mascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_buscar_mascota.setBorderPainted(false);
        Bot_buscar_mascota.setContentAreaFilled(false);
        Bot_buscar_mascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_buscar_mascota.setFocusPainted(false);
        jPanel2.add(Bot_buscar_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 20, 50, 40));

        ErrorFaltaTexto.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        ErrorFaltaTexto.setForeground(new java.awt.Color(255, 0, 0));
        ErrorFaltaTexto.setText("* Campo Vacio");
        jPanel2.add(ErrorFaltaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 80, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO PROPIETARIO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        jLabel2.setText("NOMBRES");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, -1, -1));

        Bot_eliminar.setBackground(new java.awt.Color(0, 153, 153));
        Bot_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Bot_eliminar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_eliminar.setText("ELIMINAR");
        Bot_eliminar.setBorderPainted(false);
        Bot_eliminar.setContentAreaFilled(false);
        Bot_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_eliminar.setFocusPainted(false);
        Bot_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Bot_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 120, 40));

        Bot_registrar.setBackground(new java.awt.Color(0, 153, 153));
        Bot_registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Bot_registrar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_registrar.setText("REGISTRAR");
        Bot_registrar.setBorderPainted(false);
        Bot_registrar.setContentAreaFilled(false);
        Bot_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_registrar.setFocusPainted(false);
        jPanel1.add(Bot_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 140, 40));

        Bot_actualizar.setBackground(new java.awt.Color(0, 153, 153));
        Bot_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Bot_actualizar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_actualizar.setText("ACTUALIZAR");
        Bot_actualizar.setBorderPainted(false);
        Bot_actualizar.setContentAreaFilled(false);
        Bot_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_actualizar.setFocusPainted(false);
        Bot_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Bot_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 140, 40));

        PropirtarioNomSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropirtarioNomSegActionPerformed(evt);
            }
        });
        jPanel1.add(PropirtarioNomSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("GENERO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, -1, -1));

        PropietarioNomPrim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioNomPrimActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioNomPrim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 125, 161));
        jLabel4.setText("FECHA NACIMIENTO");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, -1, 20));

        PropietarioApellPri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioApellPriActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioApellPri, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 130, 30));

        PropietarioApellSeg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioApellSegActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioApellSeg, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 130, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 125, 161));
        jLabel5.setText("APELLIDOS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, -1, 20));

        PropietarioFechaNac.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(PropietarioFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 260, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 125, 161));
        jLabel7.setText("CELULAR");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 420, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 125, 161));
        jLabel8.setText("DIRECCION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 420, -1, -1));

        Masculino.setBackground(new java.awt.Color(246, 252, 254));
        Genero.add(Masculino);
        Masculino.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Masculino.setForeground(new java.awt.Color(18, 125, 161));
        Masculino.setText("Masculino");
        Masculino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Masculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MasculinoActionPerformed(evt);
            }
        });
        jPanel1.add(Masculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 270, -1, -1));

        Femenino.setBackground(new java.awt.Color(246, 252, 254));
        Genero.add(Femenino);
        Femenino.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Femenino.setForeground(new java.awt.Color(18, 125, 161));
        Femenino.setText("Femenino");
        Femenino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Femenino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemeninoActionPerformed(evt);
            }
        });
        jPanel1.add(Femenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 125, 161));
        jLabel9.setText("CORREO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 125, 161));
        jLabel10.setText("TELEFONO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 330, -1, -1));

        PropietarioCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioCorreoActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 370, 260, -1));

        PropietarioDirec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioDirecActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioDirec, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 260, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 125, 161));
        jLabel11.setText("CEDULA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, -1, -1));

        PropietarioCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PropietarioCedulaActionPerformed(evt);
            }
        });
        jPanel1.add(PropietarioCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 260, -1));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 40));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LIMPIAR");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 30, 60, 30));

        Bot_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_Limpiar.setBorderPainted(false);
        Bot_Limpiar.setContentAreaFilled(false);
        Bot_Limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_Limpiar.setFocusPainted(false);
        jPanel4.add(Bot_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, -1));

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SALIR");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 50, 30));

        Bot_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_Regresar.setBorderPainted(false);
        Bot_Regresar.setContentAreaFilled(false);
        Bot_Regresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_Regresar.setFocusPainted(false);
        jPanel4.add(Bot_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 50, 30));

        Bot_Reporte.setBackground(new java.awt.Color(255, 255, 255));
        Bot_Reporte.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Bot_Reporte.setForeground(new java.awt.Color(18, 125, 161));
        Bot_Reporte.setText("VER TODOS");
        Bot_Reporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_Reporte.setFocusPainted(false);
        jPanel4.add(Bot_Reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 230, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1000, 65));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 100, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 100, 10));
        jPanel1.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 190, 100, 10));

        Id_Persona.setBorder(null);
        jPanel1.add(Id_Persona, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 140, 30, 30));

        Id_propietario.setBorder(null);
        jPanel1.add(Id_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 30, 30));

        ErrorCed.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        ErrorCed.setForeground(new java.awt.Color(255, 0, 0));
        ErrorCed.setText("* Verifique su cédula");
        jPanel1.add(ErrorCed, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 140, 20));

        ErrorFecha.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        ErrorFecha.setForeground(new java.awt.Color(255, 0, 0));
        ErrorFecha.setText("* Verifique su Fecha de nacimineto");
        jPanel1.add(ErrorFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 320, 160, 20));

        ErrorCorreo.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        ErrorCorreo.setForeground(new java.awt.Color(255, 0, 0));
        ErrorCorreo.setText("* Verifique su correo");
        jPanel1.add(ErrorCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 160, 20));

        try {
            PropietarioTelf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(07)-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        PropietarioTelf.setToolTipText("Ejemplo de nº de telefono: (07)234-2893");
        jPanel1.add(PropietarioTelf, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 370, 270, 30));

        try {
            PropietarioCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(593)-###-###-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        PropietarioCelular.setToolTipText("Ejemplo de nº de celular: (593)098-406-6690");
        jPanel1.add(PropietarioCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, 270, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bot_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_eliminarActionPerformed

    private void Bot_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_actualizarActionPerformed

    private void PropirtarioNomSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropirtarioNomSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropirtarioNomSegActionPerformed

    private void PropietarioNomPrimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioNomPrimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioNomPrimActionPerformed

    private void PropietarioApellPriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioApellPriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioApellPriActionPerformed

    private void PropietarioApellSegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioApellSegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioApellSegActionPerformed

    private void MasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MasculinoActionPerformed

    private void FemeninoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemeninoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FemeninoActionPerformed

    private void PropietarioCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioCorreoActionPerformed

    private void PropietarioDirecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioDirecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioDirecActionPerformed

    private void PropietarioCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PropietarioCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PropietarioCedulaActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPropietario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Limpiar;
    public javax.swing.JButton Bot_Regresar;
    public javax.swing.JButton Bot_Reporte;
    public javax.swing.JButton Bot_actualizar;
    public javax.swing.JButton Bot_buscar_mascota;
    public javax.swing.JButton Bot_eliminar;
    public javax.swing.JButton Bot_registrar;
    public javax.swing.JLabel ErrorCed;
    public javax.swing.JLabel ErrorCorreo;
    public javax.swing.JLabel ErrorFaltaTexto;
    public javax.swing.JLabel ErrorFecha;
    public javax.swing.JRadioButton Femenino;
    public javax.swing.ButtonGroup Genero;
    public javax.swing.JTextField Id_Persona;
    public javax.swing.JTextField Id_propietario;
    public javax.swing.JRadioButton Masculino;
    public jtextfieldround.JTextFieldRound PropietarioApellPri;
    public jtextfieldround.JTextFieldRound PropietarioApellSeg;
    public jtextfieldround.JTextFieldRound PropietarioCedula;
    public javax.swing.JFormattedTextField PropietarioCelular;
    public jtextfieldround.JTextFieldRound PropietarioCorreo;
    public jtextfieldround.JTextFieldRound PropietarioDirec;
    public com.toedter.calendar.JDateChooser PropietarioFechaNac;
    public jtextfieldround.JTextFieldRound PropietarioNomPrim;
    public javax.swing.JFormattedTextField PropietarioTelf;
    public jtextfieldround.JTextFieldRound PropirtarioNomSeg;
    public jtextfieldround.JTextFieldRound Txt_buscar_mascota;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    // End of variables declaration//GEN-END:variables
}
