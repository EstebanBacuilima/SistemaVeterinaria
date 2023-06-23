package Validaciones;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ValidacionCorreo {
//
    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public boolean VerificarEmail(String correo) {

        // Patrón para validar el email
        Pattern pattern = Pattern.compile("([a-z0-9]+(\\.?[a-z0-9])*)+@(([a-z]+)\\.([a-z]+))+");
        Matcher mather = pattern.matcher(correo);
        if (mather.find() == true) {
            //System.out.println("El email ingresado es válido.");
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "No se ha completado la operación,Revise su correo", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            return false;
        }
    }

}
