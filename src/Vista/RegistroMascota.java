package Vista;

import java.awt.Color;


public class RegistroMascota extends javax.swing.JFrame {

    public RegistroMascota() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexo_mascota = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Txt_Buscar_clave = new jtextfieldround.JTextFieldRound();
        Traer_Datos_Paciete = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        ErrorFaltaTexto = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nombre_paciente = new jtextfieldround.JTextFieldRound();
        texto_ci = new javax.swing.JLabel();
        cedula_propietario = new jtextfieldround.JTextFieldRound();
        jLabel8 = new javax.swing.JLabel();
        edad_paciente = new jtextfieldround.JTextFieldRound();
        jLabel9 = new javax.swing.JLabel();
        raza_paciente = new jtextfieldround.JTextFieldRound();
        jLabel10 = new javax.swing.JLabel();
        macho = new javax.swing.JRadioButton();
        hembra = new javax.swing.JRadioButton();
        Bot_subirFoto = new javax.swing.JButton();
        Bot_registrar = new javax.swing.JButton();
        Bot_actualizar = new javax.swing.JButton();
        Bot_eliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        especie_paciente = new jtextfieldround.JTextFieldRound();
        peso_paciente = new jtextfieldround.JTextFieldRound();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        obser_paciente = new javax.swing.JTextArea();
        La_foto_paciente = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Bot_limpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Bot_salir = new javax.swing.JButton();
        Bot_Reporte_Mascota = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        Bot_buscar_propietario = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        tamaño_paciente = new javax.swing.JComboBox<>();
        Id_mascota = new javax.swing.JTextField();
        Id_propi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        La_foto_paciente_txt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        clave_mascota = new jtextfieldround.JTextFieldRound();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(246, 252, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(Txt_Buscar_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, -1, -1));

        Traer_Datos_Paciete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Traer_Datos_Paciete.setBorder(null);
        Traer_Datos_Paciete.setBorderPainted(false);
        Traer_Datos_Paciete.setContentAreaFilled(false);
        Traer_Datos_Paciete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Traer_Datos_Paciete.setFocusPainted(false);
        jPanel2.add(Traer_Datos_Paciete, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, 40, 40));

        jLabel19.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(103, 206, 233));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 70));

        ErrorFaltaTexto.setFont(new java.awt.Font("Times New Roman", 0, 11)); // NOI18N
        ErrorFaltaTexto.setForeground(new java.awt.Color(255, 0, 0));
        ErrorFaltaTexto.setText("* Campo Vacio");
        jPanel2.add(ErrorFaltaTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 80, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 90));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REGISTRO MASCOTA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, 40));

        jLabel6.setBackground(new java.awt.Color(0, 153, 153));
        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 125, 161));
        jLabel6.setText("NOMBRE");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        nombre_paciente.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        nombre_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(nombre_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 300, 200, -1));

        texto_ci.setBackground(new java.awt.Color(0, 153, 153));
        texto_ci.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        texto_ci.setForeground(new java.awt.Color(18, 125, 161));
        texto_ci.setText("CEDULA PROPIETARIO");
        jPanel1.add(texto_ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, -1, -1));

        cedula_propietario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cedula_propietarioActionPerformed(evt);
            }
        });
        jPanel1.add(cedula_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 450, 200, -1));

        jLabel8.setBackground(new java.awt.Color(0, 153, 153));
        jLabel8.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 125, 161));
        jLabel8.setText("TAMAÑO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 260, 70, -1));

        edad_paciente.setToolTipText("Digite en meses");
        edad_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edad_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(edad_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 120, -1));

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 125, 161));
        jLabel9.setText("SEXO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 270, -1, -1));

        raza_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                raza_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(raza_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 450, 200, -1));

        jLabel10.setBackground(new java.awt.Color(0, 153, 153));
        jLabel10.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 125, 161));
        jLabel10.setText("RAZA");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, -1, -1));

        macho.setBackground(new java.awt.Color(246, 252, 254));
        sexo_mascota.add(macho);
        macho.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        macho.setForeground(new java.awt.Color(18, 125, 161));
        macho.setText("Macho");
        macho.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        macho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machoActionPerformed(evt);
            }
        });
        jPanel1.add(macho, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, -1, -1));

        hembra.setBackground(new java.awt.Color(246, 252, 254));
        sexo_mascota.add(hembra);
        hembra.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        hembra.setForeground(new java.awt.Color(18, 125, 161));
        hembra.setText("Hembra");
        hembra.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(hembra, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 290, -1, -1));

        Bot_subirFoto.setBackground(new java.awt.Color(23, 161, 207));
        Bot_subirFoto.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        Bot_subirFoto.setForeground(new java.awt.Color(255, 255, 255));
        Bot_subirFoto.setText("SUBIR FOTO");
        Bot_subirFoto.setBorderPainted(false);
        Bot_subirFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_subirFoto.setFocusPainted(false);
        jPanel1.add(Bot_subirFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 100, -1));

        Bot_registrar.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        Bot_registrar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_registrar.setText("REGISTRAR");
        Bot_registrar.setBorder(null);
        Bot_registrar.setBorderPainted(false);
        Bot_registrar.setContentAreaFilled(false);
        Bot_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_registrar.setDefaultCapable(false);
        Bot_registrar.setFocusPainted(false);
        Bot_registrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Bot_registrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Bot_registrarMouseExited(evt);
            }
        });
        jPanel1.add(Bot_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, 120, 30));

        Bot_actualizar.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        Bot_actualizar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_actualizar.setText("ACTUALIZAR");
        Bot_actualizar.setBorder(null);
        Bot_actualizar.setBorderPainted(false);
        Bot_actualizar.setContentAreaFilled(false);
        Bot_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_actualizar.setFocusPainted(false);
        Bot_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(Bot_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 120, 30));

        Bot_eliminar.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        Bot_eliminar.setForeground(new java.awt.Color(18, 125, 161));
        Bot_eliminar.setText("ELIMINAR");
        Bot_eliminar.setBorder(null);
        Bot_eliminar.setBorderPainted(false);
        Bot_eliminar.setContentAreaFilled(false);
        Bot_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_eliminar.setFocusPainted(false);
        Bot_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(Bot_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 100, 30));

        jLabel11.setBackground(new java.awt.Color(0, 153, 153));
        jLabel11.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 125, 161));
        jLabel11.setText("Kg");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 450, 30, 30));

        especie_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                especie_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(especie_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, 200, -1));

        peso_paciente.setToolTipText("Ingrese en Kilogramos");
        peso_paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peso_pacienteActionPerformed(evt);
            }
        });
        jPanel1.add(peso_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 100, -1));

        jLabel13.setBackground(new java.awt.Color(0, 153, 153));
        jLabel13.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(18, 125, 161));
        jLabel13.setText("ESPECIE");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        obser_paciente.setColumns(20);
        obser_paciente.setLineWrap(true);
        obser_paciente.setRows(5);
        obser_paciente.setWrapStyleWord(true);
        jScrollPane1.setViewportView(obser_paciente);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, 260, 80));

        La_foto_paciente.setForeground(new java.awt.Color(18, 125, 161));
        La_foto_paciente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 161, 187), 2));
        jPanel1.add(La_foto_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 80, 90));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 1000, 40));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Bot_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_limpiar.setBorder(null);
        Bot_limpiar.setBorderPainted(false);
        Bot_limpiar.setContentAreaFilled(false);
        Bot_limpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_limpiar.setFocusPainted(false);
        jPanel4.add(Bot_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 64, 50));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SALIR");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 20, -1, 50));

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LIMPIAR");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 50, 30));

        Bot_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_salir.setBorder(null);
        Bot_salir.setBorderPainted(false);
        Bot_salir.setContentAreaFilled(false);
        Bot_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_salir.setFocusPainted(false);
        jPanel4.add(Bot_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 50, 40));

        Bot_Reporte_Mascota.setBackground(new java.awt.Color(255, 255, 255));
        Bot_Reporte_Mascota.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        Bot_Reporte_Mascota.setForeground(new java.awt.Color(18, 125, 161));
        Bot_Reporte_Mascota.setText("VER TODOS");
        Bot_Reporte_Mascota.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_Reporte_Mascota.setFocusPainted(false);
        jPanel4.add(Bot_Reporte_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 230, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 1000, 60));
        jPanel1.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 100, 10));
        jPanel1.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 100, 10));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 100, 10));

        Bot_buscar_propietario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_buscar_propietario.setBorder(null);
        Bot_buscar_propietario.setBorderPainted(false);
        Bot_buscar_propietario.setContentAreaFilled(false);
        Bot_buscar_propietario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Bot_buscar_propietario.setFocusPainted(false);
        jPanel1.add(Bot_buscar_propietario, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 450, 50, 30));

        jLabel16.setBackground(new java.awt.Color(0, 153, 153));
        jLabel16.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(18, 125, 161));
        jLabel16.setText("OBSERVACIONES");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 320, -1, 30));

        tamaño_paciente.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        tamaño_paciente.setForeground(new java.awt.Color(18, 125, 161));
        tamaño_paciente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Grande", "Mediano", "Pequeño" }));
        tamaño_paciente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(tamaño_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, 260, -1));

        Id_mascota.setBorder(null);
        Id_mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Id_mascotaActionPerformed(evt);
            }
        });
        jPanel1.add(Id_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 490, 40, 40));

        Id_propi.setBorder(null);
        jPanel1.add(Id_propi, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 40, 40));

        jLabel17.setBackground(new java.awt.Color(0, 153, 153));
        jLabel17.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(18, 125, 161));
        jLabel17.setText("PESO");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, -1, -1));
        jPanel1.add(La_foto_paciente_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 80, -1));

        jLabel18.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(18, 125, 161));
        jLabel18.setText("FICHA");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(896, 160, 50, 40));

        clave_mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clave_mascotaActionPerformed(evt);
            }
        });
        jPanel1.add(clave_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 190, 60, 30));

        jLabel12.setBackground(new java.awt.Color(0, 153, 153));
        jLabel12.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(18, 125, 161));
        jLabel12.setText("EDAD");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jLabel15.setBackground(new java.awt.Color(0, 153, 153));
        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(18, 125, 161));
        jLabel15.setText("meses");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 360, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clave_mascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clave_mascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clave_mascotaActionPerformed

    private void Id_mascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Id_mascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Id_mascotaActionPerformed

    private void peso_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peso_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peso_pacienteActionPerformed

    private void especie_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_especie_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_especie_pacienteActionPerformed

    private void Bot_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_eliminarActionPerformed

    private void Bot_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_actualizarActionPerformed

    private void Bot_registrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bot_registrarMouseExited

    }//GEN-LAST:event_Bot_registrarMouseExited

    private void Bot_registrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Bot_registrarMouseEntered

    }//GEN-LAST:event_Bot_registrarMouseEntered

    private void machoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_machoActionPerformed

    private void raza_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_raza_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_raza_pacienteActionPerformed

    private void edad_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edad_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_edad_pacienteActionPerformed

    private void cedula_propietarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cedula_propietarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cedula_propietarioActionPerformed

    private void nombre_pacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_pacienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_pacienteActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Reporte_Mascota;
    public javax.swing.JButton Bot_actualizar;
    public javax.swing.JButton Bot_buscar_propietario;
    public javax.swing.JButton Bot_eliminar;
    public javax.swing.JButton Bot_limpiar;
    public javax.swing.JButton Bot_registrar;
    public javax.swing.JButton Bot_salir;
    public javax.swing.JButton Bot_subirFoto;
    public javax.swing.JLabel ErrorFaltaTexto;
    public javax.swing.JTextField Id_mascota;
    public javax.swing.JTextField Id_propi;
    public javax.swing.JLabel La_foto_paciente;
    public javax.swing.JTextField La_foto_paciente_txt;
    public javax.swing.JButton Traer_Datos_Paciete;
    public jtextfieldround.JTextFieldRound Txt_Buscar_clave;
    public jtextfieldround.JTextFieldRound cedula_propietario;
    public jtextfieldround.JTextFieldRound clave_mascota;
    public jtextfieldround.JTextFieldRound edad_paciente;
    public jtextfieldround.JTextFieldRound especie_paciente;
    public javax.swing.JRadioButton hembra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    public javax.swing.JRadioButton macho;
    public jtextfieldround.JTextFieldRound nombre_paciente;
    public javax.swing.JTextArea obser_paciente;
    public jtextfieldround.JTextFieldRound peso_paciente;
    public jtextfieldround.JTextFieldRound raza_paciente;
    public javax.swing.ButtonGroup sexo_mascota;
    public javax.swing.JComboBox<String> tamaño_paciente;
    public javax.swing.JLabel texto_ci;
    // End of variables declaration//GEN-END:variables
}
