package Vista;

import Controlador.ControladorCita;
public class RegistroCitas extends javax.swing.JFrame {

    /**
     * Creates new form V_ventanilla
     */
    public RegistroCitas() {
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

        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        PoEliminar = new javax.swing.JMenuItem();
        PoEditar = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        Registroc = new javax.swing.JPanel();
        Cb_registrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        C_hini = new javax.swing.JLabel();
        Bot_b_dueño = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Cid_dueño = new jtextfieldround.JTextFieldRound();
        C_ceddueño = new jtextfieldround.JTextFieldRound();
        C_idcita = new jtextfieldround.JTextFieldRound();
        jLabel10 = new javax.swing.JLabel();
        C_nomdueño = new jtextfieldround.JTextFieldRound();
        Cb_cancelaredit = new javax.swing.JButton();
        C_nompaciente = new jtextfieldround.JTextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Cb_actualizar = new javax.swing.JButton();
        C_nomconsultorio = new jtextfieldround.JTextFieldRound();
        Cid_paciente = new jtextfieldround.JTextFieldRound();
        Cid_serv = new jtextfieldround.JTextFieldRound();
        Cid_consul = new jtextfieldround.JTextFieldRound();
        Cid_med = new jtextfieldround.JTextFieldRound();
        C_nomservicio = new javax.swing.JComboBox<>();
        C_nomveteri = new javax.swing.JComboBox<>();
        C_combohoras = new javax.swing.JComboBox<>();
        C_hora = new javax.swing.JSpinner();
        C_hini1 = new javax.swing.JLabel();
        h_f_rango = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        C_fecha = new com.toedter.calendar.JDateChooser();
        Panel_lista = new javax.swing.JPanel();
        N_factura = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        T_solicitadas = new rojeru_san.complementos.RSTableMetro();
        logo = new javax.swing.JPanel();
        id_secretaria = new jtextfieldround.JTextFieldRound();
        F_fecha = new rojeru_san.rsdate.RSLabelFecha();
        jLabel13 = new javax.swing.JLabel();
        piedeframe = new javax.swing.JPanel();
        limpiarrr = new javax.swing.JLabel();
        Bot_Limpiar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Bot_Regresar1 = new javax.swing.JButton();
        Cb_vlista = new javax.swing.JButton();
        Cb_generarf = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        encabezado = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        PoEliminar.setText("Eliminar");
        jPopupMenu1.add(PoEliminar);

        PoEditar.setText("Editar");
        jPopupMenu1.add(PoEditar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Registroc.setBackground(new java.awt.Color(246, 252, 254));
        Registroc.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Cb_registrar.setBackground(new java.awt.Color(18, 125, 161));
        Cb_registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cb_registrar.setForeground(new java.awt.Color(18, 125, 161));
        Cb_registrar.setText("REGISTRAR");
        Cb_registrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Cb_registrar.setBorderPainted(false);
        Cb_registrar.setContentAreaFilled(false);
        Registroc.add(Cb_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 140, 40));

        jLabel11.setBackground(new java.awt.Color(18, 125, 161));
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(18, 125, 161));
        jLabel11.setText("Servicio");
        Registroc.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 25));

        C_hini.setBackground(new java.awt.Color(18, 125, 161));
        C_hini.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hini.setForeground(new java.awt.Color(18, 125, 161));
        C_hini.setText("Hora ");
        Registroc.add(C_hini, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, -1, 25));

        Bot_b_dueño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Consultar.png"))); // NOI18N
        Bot_b_dueño.setBorderPainted(false);
        Bot_b_dueño.setContentAreaFilled(false);
        Registroc.add(Bot_b_dueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 30, 30));

        jLabel3.setBackground(new java.awt.Color(18, 125, 161));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("Fecha:");
        Registroc.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, 25));
        Registroc.add(Cid_dueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 30, -1));

        C_ceddueño.setPreferredSize(new java.awt.Dimension(200, 25));
        Registroc.add(C_ceddueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, -1, -1));

        C_idcita.setBackground(new java.awt.Color(246, 252, 254));
        C_idcita.setBorder(null);
        C_idcita.setPreferredSize(new java.awt.Dimension(200, 25));
        Registroc.add(C_idcita, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 70, -1));

        jLabel10.setBackground(new java.awt.Color(18, 125, 161));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(18, 125, 161));
        jLabel10.setText("Consultorio");
        Registroc.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, -1, 25));

        C_nomdueño.setPreferredSize(new java.awt.Dimension(200, 25));
        Registroc.add(C_nomdueño, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, -1));

        Cb_cancelaredit.setBackground(new java.awt.Color(18, 125, 161));
        Cb_cancelaredit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cb_cancelaredit.setForeground(new java.awt.Color(18, 125, 161));
        Cb_cancelaredit.setText("CANCELAR");
        Cb_cancelaredit.setBorderPainted(false);
        Cb_cancelaredit.setContentAreaFilled(false);
        Cb_cancelaredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_cancelareditActionPerformed(evt);
            }
        });
        Registroc.add(Cb_cancelaredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 120, 40));

        C_nompaciente.setPreferredSize(new java.awt.Dimension(200, 25));
        Registroc.add(C_nompaciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 110, -1, -1));

        jLabel2.setBackground(new java.awt.Color(18, 125, 161));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        Registroc.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 30));

        jLabel8.setBackground(new java.awt.Color(18, 125, 161));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(18, 125, 161));
        jLabel8.setText("Dueño");
        Registroc.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 25));

        jLabel9.setBackground(new java.awt.Color(18, 125, 161));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(18, 125, 161));
        jLabel9.setText("Nombre");
        Registroc.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 80, -1, 25));

        jLabel4.setBackground(new java.awt.Color(18, 125, 161));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 125, 161));
        jLabel4.setText("Veterinario");
        Registroc.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, 25));

        Cb_actualizar.setBackground(new java.awt.Color(18, 125, 161));
        Cb_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Cb_actualizar.setForeground(new java.awt.Color(18, 125, 161));
        Cb_actualizar.setText("ACTUALIZAR");
        Cb_actualizar.setBorderPainted(false);
        Cb_actualizar.setContentAreaFilled(false);
        Cb_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cb_actualizarActionPerformed(evt);
            }
        });
        Registroc.add(Cb_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 140, 40));

        C_nomconsultorio.setEditable(false);
        C_nomconsultorio.setPreferredSize(new java.awt.Dimension(200, 25));
        Registroc.add(C_nomconsultorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 210, -1, -1));
        Registroc.add(Cid_paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 110, 30, -1));

        Cid_serv.setBorder(null);
        Registroc.add(Cid_serv, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 30, -1));

        Cid_consul.setBorder(null);
        Registroc.add(Cid_consul, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 180, 30, 20));

        Cid_med.setBorder(null);
        Registroc.add(Cid_med, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 30, 20));

        C_nomservicio.setForeground(new java.awt.Color(18, 125, 161));
        C_nomservicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));
        Registroc.add(C_nomservicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 200, 25));

        C_nomveteri.setForeground(new java.awt.Color(18, 125, 161));
        C_nomveteri.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR" }));
        C_nomveteri.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Registroc.add(C_nomveteri, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 200, 25));

        C_combohoras.setForeground(new java.awt.Color(18, 125, 161));
        C_combohoras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecionar Horario" }));
        Registroc.add(C_combohoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 200, 25));

        C_hora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Registroc.add(C_hora, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 310, 70, 25));

        C_hini1.setBackground(new java.awt.Color(18, 125, 161));
        C_hini1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        C_hini1.setForeground(new java.awt.Color(18, 125, 161));
        C_hini1.setText("Horarios de atencion");
        Registroc.add(C_hini1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, 25));

        h_f_rango.setBackground(new java.awt.Color(204, 0, 0));
        h_f_rango.setForeground(new java.awt.Color(204, 0, 0));
        h_f_rango.setText("*Selecionar dentro del rango");
        Registroc.add(h_f_rango, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 340, -1, -1));

        jLabel12.setBackground(new java.awt.Color(18, 125, 161));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(18, 125, 161));
        jLabel12.setText("Paciente");
        Registroc.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 80, -1, 25));

        C_fecha.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                C_fechaPropertyChange(evt);
            }
        });
        Registroc.add(C_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 210, 30));

        jPanel1.add(Registroc, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 900, 410));

        Panel_lista.setBackground(new java.awt.Color(246, 252, 254));
        Panel_lista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        N_factura.setEditable(false);
        Panel_lista.add(N_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 30, -1));

        T_solicitadas = new rojeru_san.complementos.RSTableMetro(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        T_solicitadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        T_solicitadas.setAltoHead(25);
        T_solicitadas.setAutoscrolls(false);
        T_solicitadas.setColorBackgoundHead(new java.awt.Color(23, 161, 207));
        T_solicitadas.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        T_solicitadas.setColorBordeHead(new java.awt.Color(255, 255, 255));
        T_solicitadas.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        T_solicitadas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        T_solicitadas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        T_solicitadas.setColorSelBackgound(new java.awt.Color(153, 204, 255));
        T_solicitadas.setColorSelForeground(new java.awt.Color(51, 51, 51));
        T_solicitadas.setComponentPopupMenu(jPopupMenu1);
        T_solicitadas.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_solicitadas.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        T_solicitadas.setFuenteHead(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        T_solicitadas.setGridColor(new java.awt.Color(0, 0, 0));
        T_solicitadas.getTableHeader().setResizingAllowed(false);
        T_solicitadas.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(T_solicitadas);

        Panel_lista.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 780, 320));

        jPanel1.add(Panel_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 900, 410));

        logo.setBackground(new java.awt.Color(246, 252, 254));
        logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        id_secretaria.setBackground(new java.awt.Color(246, 252, 254));
        id_secretaria.setBorder(null);
        id_secretaria.setPreferredSize(new java.awt.Dimension(200, 25));
        logo.add(id_secretaria, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 70, -1));

        F_fecha.setForeground(new java.awt.Color(246, 252, 254));
        logo.add(F_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, 90, 20));

        jLabel13.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(103, 206, 233));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        logo.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 90));

        jPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 90));

        piedeframe.setBackground(new java.awt.Color(23, 161, 207));
        piedeframe.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        limpiarrr.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        limpiarrr.setForeground(new java.awt.Color(255, 255, 255));
        limpiarrr.setText("LIMPIAR");
        piedeframe.add(limpiarrr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 50, 30));

        Bot_Limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_Limpiar.setBorderPainted(false);
        Bot_Limpiar.setContentAreaFilled(false);
        Bot_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bot_LimpiarActionPerformed(evt);
            }
        });
        piedeframe.add(Bot_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, -1));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("SALIR");
        piedeframe.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, 40));

        Bot_Regresar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_Regresar1.setBorderPainted(false);
        Bot_Regresar1.setContentAreaFilled(false);
        piedeframe.add(Bot_Regresar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 50, 40));

        Cb_vlista.setBackground(new java.awt.Color(255, 255, 255));
        Cb_vlista.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Cb_vlista.setText("Lista");
        piedeframe.add(Cb_vlista, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 80, 40));

        Cb_generarf.setBackground(new java.awt.Color(255, 255, 255));
        Cb_generarf.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Cb_generarf.setText("Generar Factura");
        piedeframe.add(Cb_generarf, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 150, 40));

        Volver.setBackground(new java.awt.Color(255, 255, 255));
        Volver.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        Volver.setText("Volver");
        piedeframe.add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        jPanel1.add(piedeframe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 910, 60));

        encabezado.setBackground(new java.awt.Color(23, 161, 207));
        encabezado.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("REGISTRO DE CITA");
        encabezado.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, -1, -1));

        jPanel1.add(encabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 910, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cb_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_actualizarActionPerformed

    private void Bot_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bot_LimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bot_LimpiarActionPerformed

    private void Cb_cancelareditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cb_cancelareditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Cb_cancelareditActionPerformed

    private void C_fechaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_C_fechaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_C_fechaPropertyChange

    /**z 
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        RegistroCitas v=new RegistroCitas();
        ControladorCita c=new ControladorCita(v);
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
            java.util.logging.Logger.getLogger(RegistroCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroCitas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
        //</editor-fold>

//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new V_reg_citas().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Limpiar;
    public javax.swing.JButton Bot_Regresar1;
    public javax.swing.JButton Bot_b_dueño;
    public jtextfieldround.JTextFieldRound C_ceddueño;
    public javax.swing.JComboBox<String> C_combohoras;
    public com.toedter.calendar.JDateChooser C_fecha;
    public javax.swing.JLabel C_hini;
    public javax.swing.JLabel C_hini1;
    public javax.swing.JSpinner C_hora;
    public jtextfieldround.JTextFieldRound C_idcita;
    public jtextfieldround.JTextFieldRound C_nomconsultorio;
    public jtextfieldround.JTextFieldRound C_nomdueño;
    public jtextfieldround.JTextFieldRound C_nompaciente;
    public javax.swing.JComboBox<String> C_nomservicio;
    public javax.swing.JComboBox<String> C_nomveteri;
    public javax.swing.JButton Cb_actualizar;
    public javax.swing.JButton Cb_cancelaredit;
    public javax.swing.JButton Cb_generarf;
    public javax.swing.JButton Cb_registrar;
    public javax.swing.JButton Cb_vlista;
    public jtextfieldround.JTextFieldRound Cid_consul;
    public jtextfieldround.JTextFieldRound Cid_dueño;
    public jtextfieldround.JTextFieldRound Cid_med;
    public jtextfieldround.JTextFieldRound Cid_paciente;
    public jtextfieldround.JTextFieldRound Cid_serv;
    public rojeru_san.rsdate.RSLabelFecha F_fecha;
    public javax.swing.JTextField N_factura;
    public javax.swing.JPanel Panel_lista;
    public javax.swing.JMenuItem PoEditar;
    public javax.swing.JMenuItem PoEliminar;
    public javax.swing.JPanel Registroc;
    public rojeru_san.complementos.RSTableMetro T_solicitadas;
    public javax.swing.JButton Volver;
    public javax.swing.JPanel encabezado;
    public javax.swing.JLabel h_f_rango;
    public jtextfieldround.JTextFieldRound id_secretaria;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public javax.swing.JLabel limpiarrr;
    public javax.swing.JPanel logo;
    public javax.swing.JPanel piedeframe;
    // End of variables declaration//GEN-END:variables
}
