package Vista;


public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Iniciar_Sesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        Olvido_Contraseña = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Tipo = new javax.swing.JTextField();
        Salir = new javax.swing.JButton();
        Txt_user = new LIB.FSTexFieldMD();
        Txt_pasword = new LIB.FSPasswordFieldMD();
        Text_ID = new javax.swing.JTextField();
        Text_Foto = new javax.swing.JTextField();
        Text_ID_secre = new javax.swing.JTextField();
        Text_Foto_vet = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jCheckBox1.setText("jCheckBox1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("MS Gothic", 1, 52)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("GE");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 60, 60));

        jLabel10.setFont(new java.awt.Font("MS Gothic", 1, 48)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_veterinarian_40px.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 40, 40));

        jLabel5.setFont(new java.awt.Font("MS Gothic", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VET");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 60, 40));

        jLabel7.setBackground(new java.awt.Color(103, 206, 233));
        jLabel7.setFont(new java.awt.Font("MS Gothic", 1, 52)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("D ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 80, 40));

        jPanel3.setBackground(new java.awt.Color(246, 252, 254));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(23, 161, 207));
        jLabel3.setText("BIENVENIDO");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 220, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_forgot_password_30px.png"))); // NOI18N
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, -1, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_pets_30px.png"))); // NOI18N
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 310, 30, 30));

        Iniciar_Sesion.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        Iniciar_Sesion.setForeground(new java.awt.Color(23, 161, 207));
        Iniciar_Sesion.setText("INICIAR SESION");
        Iniciar_Sesion.setBorder(null);
        Iniciar_Sesion.setBorderPainted(false);
        Iniciar_Sesion.setContentAreaFilled(false);
        Iniciar_Sesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Iniciar_Sesion.setFocusPainted(false);
        Iniciar_Sesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Iniciar_SesionActionPerformed(evt);
            }
        });
        jPanel3.add(Iniciar_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 140, 20));

        jSeparator1.setForeground(new java.awt.Color(48, 97, 110));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 292, 100, 10));

        Olvido_Contraseña.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Olvido_Contraseña.setForeground(new java.awt.Color(23, 161, 207));
        Olvido_Contraseña.setText("Olvido su Contraseña?");
        Olvido_Contraseña.setToolTipText("");
        Olvido_Contraseña.setBorder(null);
        Olvido_Contraseña.setBorderPainted(false);
        Olvido_Contraseña.setContentAreaFilled(false);
        Olvido_Contraseña.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Olvido_Contraseña.setFocusPainted(false);
        jPanel3.add(Olvido_Contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 190, 20));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_male_user_30px.png"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_male_user_30px.png"))); // NOI18N
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, 30));

        Tipo.setBackground(new java.awt.Color(246, 252, 254));
        Tipo.setBorder(null);
        jPanel3.add(Tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 100, -1));

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_delete_30px.png"))); // NOI18N
        Salir.setToolTipText("Exit");
        Salir.setBorderPainted(false);
        Salir.setContentAreaFilled(false);
        Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Salir.setDefaultCapable(false);
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        jPanel3.add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 30, 30));

        Txt_user.setBackground(new java.awt.Color(246, 252, 254));
        Txt_user.setForeground(new java.awt.Color(51, 51, 51));
        Txt_user.setBordeColorFocus(new java.awt.Color(23, 161, 207));
        Txt_user.setPlaceholder("");
        Txt_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Txt_userActionPerformed(evt);
            }
        });
        jPanel3.add(Txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 210, 40));

        Txt_pasword.setBackground(new java.awt.Color(246, 252, 254));
        Txt_pasword.setForeground(new java.awt.Color(51, 51, 51));
        Txt_pasword.setBordeColorFocus(new java.awt.Color(23, 161, 207));
        Txt_pasword.setPlaceholder("");
        jPanel3.add(Txt_pasword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 210, 40));

        Text_ID.setBackground(new java.awt.Color(246, 252, 254));
        Text_ID.setBorder(null);
        jPanel3.add(Text_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, -1));

        Text_Foto.setBackground(new java.awt.Color(246, 252, 254));
        Text_Foto.setBorder(null);
        jPanel3.add(Text_Foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        Text_ID_secre.setBackground(new java.awt.Color(246, 252, 254));
        Text_ID_secre.setBorder(null);
        jPanel3.add(Text_ID_secre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 30, -1));

        Text_Foto_vet.setBackground(new java.awt.Color(246, 252, 254));
        Text_Foto_vet.setBorder(null);
        jPanel3.add(Text_Foto_vet, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(475, 0, 350, 345));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_login.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, -1));

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

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        dispose();
    }//GEN-LAST:event_SalirActionPerformed

    private void Txt_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Txt_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Txt_userActionPerformed

    private void Iniciar_SesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Iniciar_SesionActionPerformed

    }//GEN-LAST:event_Iniciar_SesionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Iniciar_Sesion;
    public javax.swing.JButton Olvido_Contraseña;
    public javax.swing.JButton Salir;
    public javax.swing.JTextField Text_Foto;
    public javax.swing.JTextField Text_Foto_vet;
    public javax.swing.JTextField Text_ID;
    public javax.swing.JTextField Text_ID_secre;
    public javax.swing.JTextField Tipo;
    public LIB.FSPasswordFieldMD Txt_pasword;
    public LIB.FSTexFieldMD Txt_user;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
