package Controlador;

import Modelo.LoginDAO;
import Modelo.RContraseñaBO;
import Vista.RecuperarContraseña;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class ControladosRCon implements ActionListener, MouseListener {

    RecuperarContraseña vista = new RecuperarContraseña();
    private RContraseñaBO cbo = new RContraseñaBO();
    private LoginDAO modelDAO = new LoginDAO();

    public ControladosRCon(RecuperarContraseña vista) {
        this.vista = vista;
        this.vista.btAgr.addActionListener(this);
        this.vista.btSal.addActionListener(this);
        this.vista.btAgr.addMouseListener(this);
    }

    public void Iniciar_Vista() {
        vista.setLocationRelativeTo(null);
    }

    public void modificar() {
        String usuario = vista.trUs.getText();
        modelDAO.ValidarUsuarioExistente(usuario);
        if (modelDAO.ValidarUsuarioExistente(usuario) == true) {
            String contraseña = vista.trCon.getText();
            RecuperarContraseña rcontra = new RecuperarContraseña();
            String mensaje = cbo.modificarContra(contraseña, usuario);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje);
            Limpiar();
        } else {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        }

    }

    public void Limpiar() {
        vista.trUs.setText("");
        vista.trCon.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btAgr) {

            if (vista.trCon.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Campos Vacios", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                modificar();
            }

        }

        if (e.getSource() == vista.btSal) {
            vista.dispose();
            Limpiar();
        }
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vista.btAgr.setForeground(new Color(48, 97, 100));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vista.btAgr.setForeground(new Color(23, 161, 207));
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
}
