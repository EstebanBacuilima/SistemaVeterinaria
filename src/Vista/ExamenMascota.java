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
public class ExamenMascota extends javax.swing.JFrame {

    /**
     * Creates new form ExamenMascota
     */
    public ExamenMascota() {
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
        Nombre_Mascota = new jtextfieldround.JTextFieldRound();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TipoEax = new jtextfieldround.JTextFieldRound();
        NombreExa = new jtextfieldround.JTextFieldRound();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Resul_exa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Nombre_medico = new jtextfieldround.JTextFieldRound();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        des_exa = new javax.swing.JTextArea();
        Bot_guardar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        Bot_Regresar = new javax.swing.JButton();
        Bot_limpiar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Bot_buscar_mascota = new javax.swing.JButton();
        Bot_buscar_medico = new javax.swing.JButton();
        jSeparator8 = new javax.swing.JSeparator();
        Id_medico = new javax.swing.JTextField();
        Id_mascota = new javax.swing.JTextField();
        Id_Examen = new jtextfieldround.JTextFieldRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(246, 252, 254));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Nombre_Mascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_MascotaActionPerformed(evt);
            }
        });
        jPanel1.add(Nombre_Mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 210, -1));

        jLabel2.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(18, 125, 161));
        jLabel2.setText("TIPO DE EXAMEN");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, -1));

        jLabel3.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(18, 125, 161));
        jLabel3.setText("MEDICO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(18, 125, 161));
        jLabel4.setText("RESULTADOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));
        jPanel1.add(TipoEax, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 220, -1));
        jPanel1.add(NombreExa, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 220, -1));

        jLabel5.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(18, 125, 161));
        jLabel5.setText("NOMBRE EXAMEN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, -1, -1));

        Resul_exa.setColumns(20);
        Resul_exa.setLineWrap(true);
        Resul_exa.setRows(5);
        Resul_exa.setWrapStyleWord(true);
        jScrollPane1.setViewportView(Resul_exa);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 230, 240));

        jLabel6.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(18, 125, 161));
        jLabel6.setText("MASCOTA");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jPanel2.setBackground(new java.awt.Color(246, 252, 254));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(23, 161, 207));
        jLabel1.setText("EXAMEN MASCOTA");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 50));

        jLabel20.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(103, 206, 233));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_veterinaria_Pri.png"))); // NOI18N
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 510, 270, 70));

        jLabel19.setFont(new java.awt.Font("Monotype Corsiva", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(103, 206, 233));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/LogoVeterinaria.png"))); // NOI18N
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 160, 70));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 70));

        Nombre_medico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Nombre_medicoActionPerformed(evt);
            }
        });
        jPanel1.add(Nombre_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 210, -1));

        jLabel7.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(18, 125, 161));
        jLabel7.setText("DESCRIPCION");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, -1, -1));

        des_exa.setColumns(20);
        des_exa.setLineWrap(true);
        des_exa.setRows(5);
        des_exa.setWrapStyleWord(true);
        jScrollPane2.setViewportView(des_exa);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 230, 100));

        Bot_guardar.setFont(new java.awt.Font("Nirmala UI", 1, 13)); // NOI18N
        Bot_guardar.setForeground(new java.awt.Color(97, 161, 187));
        Bot_guardar.setText("GUARDAR");
        Bot_guardar.setBorder(null);
        Bot_guardar.setBorderPainted(false);
        Bot_guardar.setContentAreaFilled(false);
        Bot_guardar.setFocusPainted(false);
        jPanel1.add(Bot_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 530, -1, 40));

        jPanel4.setBackground(new java.awt.Color(23, 161, 207));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("SALIR");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 50, 40));

        Bot_Regresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_exit_25px.png"))); // NOI18N
        Bot_Regresar.setBorderPainted(false);
        Bot_Regresar.setContentAreaFilled(false);
        jPanel4.add(Bot_Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 50, 40));

        Bot_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_broom_25px.png"))); // NOI18N
        Bot_limpiar.setBorderPainted(false);
        Bot_limpiar.setContentAreaFilled(false);
        jPanel4.add(Bot_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 64, 40));

        jLabel14.setFont(new java.awt.Font("Nirmala UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LIMPIAR");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 50, 20));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 720, 50));

        jPanel3.setBackground(new java.awt.Color(23, 161, 207));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 710, 30));

        Bot_buscar_mascota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_buscar_mascota.setBorder(null);
        Bot_buscar_mascota.setBorderPainted(false);
        Bot_buscar_mascota.setContentAreaFilled(false);
        Bot_buscar_mascota.setFocusPainted(false);
        jPanel1.add(Bot_buscar_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, 30));

        Bot_buscar_medico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_search_30px_1.png"))); // NOI18N
        Bot_buscar_medico.setBorder(null);
        Bot_buscar_medico.setBorderPainted(false);
        Bot_buscar_medico.setContentAreaFilled(false);
        Bot_buscar_medico.setFocusPainted(false);
        jPanel1.add(Bot_buscar_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, -1, 30));
        jPanel1.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 560, 80, 20));

        Id_medico.setBackground(new java.awt.Color(246, 252, 254));
        Id_medico.setBorder(null);
        jPanel1.add(Id_medico, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 30, 30));

        Id_mascota.setBackground(new java.awt.Color(246, 252, 254));
        Id_mascota.setBorder(null);
        jPanel1.add(Id_mascota, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 30, 30));

        Id_Examen.setBorder(null);
        jPanel1.add(Id_Examen, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 28, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Nombre_MascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_MascotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_MascotaActionPerformed

    private void Nombre_medicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Nombre_medicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Nombre_medicoActionPerformed

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
            java.util.logging.Logger.getLogger(ExamenMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExamenMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExamenMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExamenMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExamenMascota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Bot_Regresar;
    public javax.swing.JButton Bot_buscar_mascota;
    public javax.swing.JButton Bot_buscar_medico;
    public javax.swing.JButton Bot_guardar;
    public javax.swing.JButton Bot_limpiar;
    public jtextfieldround.JTextFieldRound Id_Examen;
    public javax.swing.JTextField Id_mascota;
    public javax.swing.JTextField Id_medico;
    public jtextfieldround.JTextFieldRound NombreExa;
    public jtextfieldround.JTextFieldRound Nombre_Mascota;
    public jtextfieldround.JTextFieldRound Nombre_medico;
    public javax.swing.JTextArea Resul_exa;
    public jtextfieldround.JTextFieldRound TipoEax;
    public javax.swing.JTextArea des_exa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator8;
    // End of variables declaration//GEN-END:variables
}