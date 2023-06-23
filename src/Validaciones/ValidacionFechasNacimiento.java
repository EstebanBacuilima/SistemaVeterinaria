package Validaciones;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ValidacionFechasNacimiento {

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public boolean FechaNacimiento(JDateChooser fecha) {

        boolean estado = false;

        Date dat = new Date();//Instancia la fecha del sistema
        if (fecha.getDate().getTime() >= dat.getTime()) {//Compara si la fecha seleccionada es menor o igual a la fecha actual
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, Fecha Infrige a la fecha Actual", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            estado = false;
        } else {
            //JOptionPane.showMessageDialog(null, "Fecha Correcta");           
            estado = true;
        }

        return estado;
    }
}
