package Controlador;

import Modelo.MHorario;
import Vista.Horario;
import Modelo.HorarioBO;
import Modelo.MHorarioEmpleados;
import Vista.HorarioEmpleados;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorHorario implements ActionListener, KeyListener {

    MHorario modelo = new MHorario();
    Horario vista = new Horario();
    MHorarioEmpleados modelohe = new MHorarioEmpleados();
    HorarioEmpleados vistahe = new HorarioEmpleados();
    private HorarioBO hbo = new HorarioBO();

    public ControladorHorario(Horario vista, MHorario modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btAgr.addActionListener(this);
        this.vista.btMod.addActionListener(this);
        this.vista.btEli.addActionListener(this);
        this.vista.trBus.addKeyListener(this);
        this.vista.chbIn.addActionListener(this);
        this.vista.btSal.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.H_Traer.addActionListener(this);

        validarsolonumeros(this.vista.ftHI);
        validarsolonumeros(this.vista.ftHF);
    }

    public void Iniciar_Vista() {
        vista.setLocationRelativeTo(null);
        mostrar("");
        idIncre();
        vista.btAgr.setEnabled(true);
        vista.btEli.setEnabled(false);
        vista.btMod.setEnabled(false);
        vista.trId.setVisible(false);
    }

    ArrayList<MHorario> listah = new ArrayList<MHorario>();

    public void ingresar() {
        if (vista.ftHI.getText().isEmpty() || vista.ftHF.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            
            int id = Integer.parseInt(vista.trId.getText());
            String horainicio = vista.ftHI.getText();
            String horafin = vista.ftHF.getText();
            String dia = vista.cbDia.getSelectedItem().toString();
            
            if(horainicio.compareTo(horafin) == 0){
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, las horas son iguales", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            }else{
                if(horainicio.compareTo(horafin) > 0){
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, la hora inicio es mayor a la hora fin", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                }else{
                    MHorario horario = new MHorario();
                    horario.setId_horario(id);
                    horario.setHora_inicio(horainicio);
                    horario.setHora_fin(horafin);
                    horario.setDia(dia);
                    listah.add(horario);
                    String mensaje = hbo.agregarHorario(horario);
                    UIManager UI = new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                    limpiar();
                    mostrar("");
                }
            }
        }
    }

    public void modificar() {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de modificar el día del horario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                icono("/iconos/alerta.png", 40, 40));
        if (res == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.trId.getText());
            String horainicio = vista.ftHI.getText();
            String horafin = vista.ftHF.getText();
            String dia = vista.cbDia.getSelectedItem().toString();

            MHorario horario = new MHorario();
            horario.setId_horario(id);
            horario.setHora_inicio(horainicio);
            horario.setHora_fin(horafin);
            horario.setDia(dia);
            listah.add(horario);
            String mensaje = hbo.modificarHorario(horario);
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            mostrar("");
            limpiar();
            vista.btAgr.setEnabled(true);
        }else{
            limpiar();
            vista.ftHI.setEnabled(true);
            vista.ftHF.setEnabled(true);
            vista.btAgr.setEnabled(true);
            vista.btMod.setEnabled(false);
            vista.btEli.setEnabled(false);
        }
    }

    public void eliminar() {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de eliminar el horario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                icono("/iconos/alerta.png", 40, 40));
        if (res == JOptionPane.YES_OPTION) {
            int id = Integer.parseInt(vista.trId.getText());
            String mensaje = hbo.eliminarHorario(id);
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            limpiar();
            mostrar("");
            vista.btAgr.setEnabled(true);
        }else{
            limpiar();
            vista.ftHI.setEnabled(true);
            vista.ftHF.setEnabled(true);
            vista.btAgr.setEnabled(true);
            vista.btMod.setEnabled(false);
            vista.btEli.setEnabled(false);
        }
    }

    private void mostrar(String dia) {
        hbo.listarHorario(vista.Tabla_Horario, dia);
    }

    private void mostrareliminados() {
        if (vista.chbIn.isSelected()) {
            hbo.eliminados(vista.Tabla_Horario);
        } else {
            String dia = "";
            hbo.listarHorario(vista.Tabla_Horario, dia);
        }
    }

    private void idIncre() {
        vista.trId.setText(hbo.getIncreID() + "");
    }

    private void limpiar() {
        vista.btAgr.setEnabled(true);
        vista.btEli.setEnabled(false);
        vista.btMod.setEnabled(false);
        vista.trId.setEnabled(true);
        vista.ftHI.setEnabled(true);
        vista.ftHF.setEnabled(true);
        vista.ftHI.setText("00:00");
        vista.ftHF.setText("00:00");
        vista.cbDia.setSelectedIndex(0);
        vista.trBus.setText("");
        idIncre();
    }

    void Buscar() {

        if (vista.trBus.getText().isEmpty()) {
            mostrar("");
        } else {
            mostrar(vista.trBus.getText());
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btAgr) {
            ingresar();
        }
        if (e.getSource() == vista.btMod) {
            modificar();
        }
        if (e.getSource() == vista.btEli) {
            eliminar();
        }
        if (e.getSource() == vista.chbIn) {
            mostrareliminados();
        }
        if (e.getSource() == vista.btSal) {
            vista.dispose();
            limpiar();
        }
        if (e.getSource() == vista.Bot_Limpiar) {
            limpiar();
            mostrar("");
        }
        if(e.getSource()==vista.H_Traer){
            DevolverDatos();
        }
    }

    void DevolverDatos(){
        int fila = vista.Tabla_Horario.getSelectedRow();
            if (fila >= 0) {
                vista.trId.setText(String.valueOf(vista.Tabla_Horario.getValueAt(fila, 0)));
                vista.trId.setEnabled(false);
                vista.ftHI.setText(vista.Tabla_Horario.getValueAt(fila, 1).toString());
                vista.ftHI.setEnabled(false);
                vista.ftHF.setText(vista.Tabla_Horario.getValueAt(fila, 2).toString());
                vista.ftHF.setEnabled(false);
                vista.cbDia.setSelectedItem(vista.Tabla_Horario.getValueAt(vista.Tabla_Horario.getSelectedRow(), 3).toString());
                vista.btAgr.setEnabled(false);
                vista.btMod.setEnabled(true);
                vista.btEli.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList horario = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarHorario() {
        hbo.TraerDatosAutoHorario(horario, datos);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarHora(String dia) {
        TraerDatosAutoCompletarHorario(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = dia.length();
        int last = dia.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < horario.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (horario.get(a).toString().startsWith(dia)) {

                complete = horario.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vista.trBus.setText(complete);
            vista.trBus.setCaretPosition(last);
            vista.trBus.moveCaretPosition(start);

        }
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        autocompletarDia(e);
    }

    void autocompletarDia(KeyEvent e) {
        Buscar();
        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vista.trBus.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String dia = vista.trBus.getText();
                        autoCompletarHora(dia);
                    }
                });

        }
    }

    //---------------------------------------------------------------------
    // solo numeros
    private void validarnum(java.awt.event.KeyEvent evt) {
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali)) {
            vista.getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Digite solo numeros");
        }
    }

    private void validarsolonumeros(JTextField txt) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                validarnum(e);
            }
        });
    }

    //---------------------------------------------------------------------
}
