package Controlador;

import Modelo.LoginDAO;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.RecuperarContraseña;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class Control_Login implements ActionListener, MouseListener {

    Login vistaL = new Login();
    private LoginDAO modelDAO = new LoginDAO();

    // Recuperar
    RecuperarContraseña vistRecup = new RecuperarContraseña();
    ControladosRCon controladorR = new ControladosRCon(vistRecup);

    MenuPrincipal menu = new MenuPrincipal();
    ControladorMenuPrincipal controladorMenu = new ControladorMenuPrincipal(menu);

    public Control_Login(Login vista) {

        this.vistaL = vista;

        this.vistaL.Salir.addActionListener(this);
        this.vistaL.Iniciar_Sesion.addActionListener(this);
        this.vistaL.Olvido_Contraseña.addActionListener(this);
        this.vistaL.Olvido_Contraseña.addMouseListener(this);

        CambiarColorEntrar(vistaL.Iniciar_Sesion);
        CambiarColorSalir(vistaL.Iniciar_Sesion);
    }

    public void inciar() {
        vistaL.setVisible(true);
        vistaL.setLocationRelativeTo(null);
        vistaL.Tipo.setVisible(false);
        vistaL.Text_ID.setVisible(false);
        vistaL.Text_Foto.setVisible(false);
        vistaL.Text_Foto_vet.setVisible(false);
        vistaL.Text_ID_secre.setVisible(false);
    }

    // ENVIAR DATOS
    public void EnviarDatos() {
        menu.Text_ID_secre.setText(vistaL.Text_ID_secre.getText());
        menu.Text_Foto.setText(vistaL.Text_Foto.getText());
        menu.Text_ID1.setText(vistaL.Text_ID.getText());
        menu.Text_Tipo.setText(vistaL.Tipo.getText());
        menu.Text_Foto1.setText(vistaL.Text_Foto_vet.getText());
        usuario = vistaL.Txt_user.getText();
        menu.Nombres.setText(modelDAO.TraerNombres(usuario));

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaL.Iniciar_Sesion) {
            setTipo();
            EnviarDatos();
            Menus();
        }
        if (e.getSource() == vistaL.Olvido_Contraseña) {
            vistRecup.setVisible(true);
            vistRecup.setLocationRelativeTo(null);
            controladorR.Iniciar_Vista();
        }
        if (e.getSource() == vistaL.Salir) {
            System.exit(0);
        }
    }

    String usuario;
    String contraseña;
    String tipo;

    private void setTipo() {
        
        usuario = vistaL.Txt_user.getText();
        contraseña = vistaL.Txt_pasword.getText();
        
        
        vistaL.Tipo.setText(modelDAO.TraerTipo(usuario, contraseña));     
        String id = String.valueOf(modelDAO.TraerIDVeterinario(usuario));
        String id2 = String.valueOf(modelDAO.TraerIDSecretaria(usuario));
        vistaL.Text_ID.setText(id);
        vistaL.Text_ID_secre.setText(id2);
        vistaL.Text_Foto.setText(modelDAO.TraerImagen(usuario));
        vistaL.Text_Foto_vet.setText(modelDAO.TraerImagenVet(usuario));
        validar();
    }

    private void Menus() {

        if (vistaL.Tipo.getText().equals("Admin")) {
            controladorMenu.inciar();
            menu.setVisible(true);
            menu.foto.setVisible(false);
            vistaL.dispose();
            menu.Menu_laboratorio.setVisible(false);
            menu.Item_historiaal.setVisible(false);
            menu.Item_historiaal.setVisible(false);
            menu.Menu_Citas.setVisible(false);
        } else {
            if (vistaL.Tipo.getText().equals("Veterinario")) {

                menu.Text_Foto.setText(modelDAO.TraerImagenVet(usuario));
                controladorMenu.inciar();
                menu.setVisible(true);
                menu.registrarCita.setVisible(false);
                menu.Menu_Pro.setVisible(false);
                menu.Menu_reportes.setVisible(false);
                menu.Menu_Veterinarios.setVisible(false);
                menu.Menu_admin.setVisible(false);
                menu.Menu_Servicios.setVisible(false);
                vistaL.dispose();
                
            } else {
                if (vistaL.Tipo.getText().equals("Secretaria")) {
                    ;
                    controladorMenu.inciar();
                    menu.setVisible(true);
                    menu.Menu_laboratorio.setVisible(false);
                    menu.Menu_Veterinarios.setVisible(false);
                    menu.Menu_Servicios.setVisible(false);
                    menu.Menu_admin.setVisible(false);
                    menu.Item_historiaal.setVisible(false);
                    vistaL.dispose();

                } else {
                    System.out.println("NADA");
                }
            }
        }

    }

    public void validar() {
        usuario = vistaL.Txt_user.getText();
        contraseña = vistaL.Txt_pasword.getText();
        modelDAO.Acceder(usuario, contraseña, vistaL.Tipo.getText());
    }

    public void limpiar() {
        vistaL.Txt_user.setText("");
        vistaL.Txt_pasword.setText("");
        vistaL.Tipo.setText("");
        vistaL.Tipo.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vistaL.Olvido_Contraseña.setForeground(new Color(48, 97, 100));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vistaL.Olvido_Contraseña.setForeground(new Color(23, 161, 207));
    }

    private void CambiarColorEntrar(JButton txt) {
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                vistaL.Iniciar_Sesion.setForeground(new Color(48, 97, 100));
            }
        });
    }

    private void CambiarColorSalir(JButton txt) {
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                vistaL.Iniciar_Sesion.setForeground(new Color(23, 161, 207));
            }
        });
    }

}
