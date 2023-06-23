package Modelo;

import Controlador.ControladorMenuPrincipal;
import Vista.MenuPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class LoginDAO {

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public String Acceder(String usuario, String pass, String tipo) {

        Connection conn = Conexion.getConection();
        String cap = "";
        String sql = "SELECT * FROM USUARIOS WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + pass + "' AND ESTADO = 'A'";// OR user_estado = 'C'";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("TIPO");
            }

            if (cap.equals("Veterinario")) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "BIENVENIDO VETERINARIO", "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            } else {
                if (cap.equals("Secretaria")) {
                    UIManager UI = new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "BIENVENIDO SECRETARIA", "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                } else {
                    if (cap.equals("Admin")) {
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);
                        JOptionPane.showMessageDialog(null, "BIENVENIDO ADMIN", "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                    } else {
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);
                        JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO \nrevise su usuario y contraseña", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                    }
                }
            }

        } catch (SQLException ex) {

            System.out.println("Error " + ex);
        }
        return cap;
    }

    boolean confirmacion;

    public boolean ValidarUsuarioExistente(String usuario) {

        try {
            confirmacion = false;
            Connection con = Conexion.getConection();
            Statement stm = con.createStatement();
            String sql = "SELECT USUARIO FROM USUARIOS WHERE USUARIO = '" + usuario + "'";
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                confirmacion = true;
            } else {
                confirmacion = false;
            }
        } catch (SQLException ex) {
            System.out.println("Error 1 " + ex);
        }

        return confirmacion;
    }

    public String TraerTipo(String usuario, String pass) {

        Connection conn = Conexion.getConection();
        String cap = "";
        String sql = "SELECT * FROM USUARIOS WHERE USUARIO = '" + usuario + "' AND CONTRASEÑA = '" + pass + "' AND ESTADO = 'A'";// OR user_estado = 'C'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("TIPO");
            }
        } catch (SQLException ex) {

            System.out.println("Error 2 " + ex);
        }
        return cap;
    }

    public int TraerIDVeterinario(String usuario) {

        Connection conn = Conexion.getConection();
        int id = 0;
        String sql = "SELECT V.veterinario_id FROM personas P,veterinario V  WHERE  P.persona_id = V.persona_id AND P.persona_cedula = '" + usuario + "'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {

            System.out.println("Error 3 " + ex);
        }
        return id;
    }

    public int TraerIDSecretaria(String usuario) {

        Connection conn = Conexion.getConection();
        int id = 0;
        String sql = "SELECT S.secretaria_id FROM personas P,secretaria S  WHERE  P.persona_id = S.persona_id AND P.persona_cedula = '" + usuario + "'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException ex) {

            System.out.println("Error 4 " + ex);
        }
        return id;
    }

    //IMAGEN 
    public String TraerImagen(String usuario) {

        Connection conn = Conexion.getConection();
        String cap = "";
        String sql = "SELECT IMAGEN FROM PERSONAS P, SECRETARIA S WHERE P.PERSONA_ID = S.PERSONA_ID AND P.PERSONA_CEDULA = '" + usuario + "'";// OR user_estado = 'C'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString("IMAGEN");
            }
        } catch (SQLException ex) {

            System.out.println("Error 5 " + ex);
        }
        return cap;
    }

    public String TraerImagenVet(String usuario) {

        Connection conn = Conexion.getConection();
        String cap = "";
        String sql = "SELECT S.IMAGEN FROM PERSONAS P, VETERINARIO S WHERE P.PERSONA_ID = S.PERSONA_ID AND P.PERSONA_CEDULA = '" + usuario + "'";// OR user_estado = 'C'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (SQLException ex) {

            System.out.println("Error 6 " + ex);
        }
        return cap;
    }

    // NOMBRES
    public String TraerNombres(String usuario) {

        Connection conn = Conexion.getConection();
        String cap = "";
        String sql = "SELECT P.persona_Pri_nombre ||' '|| P.persona_Seg_nombre ||' '|| P.persona_Pat_apellido ||' '|| P.persona_Mat_apellido FROM PERSONAS P WHERE P.persona_cedula = '" + usuario + "'";
        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cap = rs.getString(1);
            }
        } catch (SQLException ex) {

            System.out.println("Error 7 " + ex);
        }
        return cap;
    }
}
