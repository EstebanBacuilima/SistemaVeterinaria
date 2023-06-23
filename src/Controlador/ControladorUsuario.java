package Controlador;

import Modelo.MUsuarios;
import Modelo.UsuariosBO;
import Vista.DatosSecretaria;
import Vista.RegistrosEmpleados;
import Vista.Usuarios;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ControladorUsuario implements ActionListener, ItemListener, KeyListener {

    MUsuarios modeloU = new MUsuarios();
    Usuarios vistaU = new Usuarios();
    RegistrosEmpleados vistaR = new RegistrosEmpleados();
    DatosSecretaria vistaS = new DatosSecretaria();

    private UsuariosBO ubo = new UsuariosBO();

    public ControladorUsuario(Usuarios vista, MUsuarios modelo) {
        this.vistaU = vista;
        this.modeloU = modelo;
        this.vistaU.btAgr.addActionListener(this);
        this.vistaU.btMod.addActionListener(this);
        this.vistaU.btEli.addActionListener(this);
        this.vistaU.Restaurar.addActionListener(this);
        this.vistaU.chbIn.addActionListener(this);
        this.vistaU.cbEm.addItemListener(this);
        this.vistaU.btMed.addActionListener(this);
        this.vistaU.btSec.addActionListener(this);
        this.vistaR.btSal.addActionListener(this);
        this.vistaS.btSal.addActionListener(this);
        this.vistaR.trBus.addKeyListener(this);
        this.vistaS.trBusq.addKeyListener(this);
        this.vistaU.trBuscar.addKeyListener(this);
        this.vistaU.Bot_limpiar.addActionListener(this);
        this.vistaU.Bot_buscar_paciente.addActionListener(this);
//        TraerDatosUsuario(vistaU.Tabla_Usuario);
//        DatosAutoUser(vistaU.trBuscar);

        DatosAutoMedico(vistaR.trBus);
        DatosAutoSecretaria(vistaS.trBusq);
        validarTamaño(vistaU.trCon, 10);
    }

    public void Iniciar_Vista() {
        vistaU.setLocationRelativeTo(null);
        mostrar("");
        idIncre();
        vistaU.trId.setVisible(false);
        vistaU.btAgr.setEnabled(true);
        vistaU.btMod.setEnabled(false);
        vistaU.Restaurar.setVisible(false);
        vistaU.btEli.setVisible(true);
    }

    ArrayList<MUsuarios> listau = new ArrayList<MUsuarios>();

    public void ingresar() {
        int id_user = Integer.parseInt(vistaU.trId.getText());
        int id_empleado = Integer.parseInt(vistaU.trCo.getText());
        String tipo = vistaU.cbEm.getSelectedItem().toString();
        String usuario = vistaU.trUs.getText();
        String contraseña = vistaU.trCon.getText();

        MUsuarios user = new MUsuarios();
        user.setId_user(id_user);
        user.setId_empleado(id_empleado);
        user.setTipo(tipo);
        user.setUsuario(usuario);
        user.setContraseña(contraseña);
        listau.add(user);
        String mensaje = ubo.agregarUsuario(user, usuario);
        JOptionPane.showMessageDialog(null, mensaje);
        limpiar();
        mostrar("");
    }

    public void modificar() {
        int id_user = Integer.parseInt(vistaU.trId.getText());
        int id_empleado = Integer.parseInt(vistaU.trCo.getText());
        String tipo = vistaU.cbEm.getSelectedItem().toString();
        String usuario = vistaU.trUs.getText();
        String contraseña = vistaU.trCon.getText();

        MUsuarios user = new MUsuarios();
        user.setId_user(id_user);
        user.setId_empleado(id_empleado);
        user.setTipo(tipo);
        user.setUsuario(usuario);
        user.setContraseña(contraseña);
        listau.add(user);
        String mensaje = ubo.modificarUsuario(user, usuario);
        JOptionPane.showMessageDialog(null, mensaje);
        mostrar("");
        limpiar();
        vistaU.btAgr.setEnabled(true);
    }

    public void eliminar() {
        int fila = vistaU.Tabla_Usuario.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaU, "Debe seleccionar una fila");
        } else {
            String usuario = vistaU.Tabla_Usuario.getValueAt(fila, 3).toString();
            String mensaje = ubo.inactivar(usuario);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiar();
            mostrar("");
            vistaU.btAgr.setEnabled(true);
        }

    }

    public void Restaurar() {
        int fila = vistaU.Tabla_Usuario.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaU, "Debe seleccionar una fila");
        } else {
            String usuario = vistaU.Tabla_Usuario.getValueAt(fila, 3).toString();
            String mensaje = ubo.reactivar(usuario);
            JOptionPane.showMessageDialog(null, mensaje);
            limpiar();
            ubo.eliminados(vistaU.Tabla_Usuario);
            vistaU.btAgr.setEnabled(true);
        }

    }

    private void mostrareliminados() {
        if (vistaU.chbIn.isSelected()) {
            ubo.eliminados(vistaU.Tabla_Usuario);
            vistaU.Restaurar.setVisible(true);
            vistaU.btEli.setVisible(false);
        } else {
            ubo.listarUsuario(vistaU.Tabla_Usuario, "");
            vistaU.Restaurar.setVisible(false);
            vistaU.btEli.setVisible(true);
        }
    }

    void BuscarU() {

        if (vistaU.trBuscar.getText().isEmpty()) {
            mostrar("");
        } else {
            mostrar(vistaU.trBuscar.getText());
        }

    }

    void Buscar() {

        if (vistaR.trBus.getText().isEmpty()) {
            mostrarm("");
        } else {
            mostrarm(vistaR.trBus.getText());
        }

    }

    void Buscars() {

        if (vistaS.trBusq.getText().isEmpty()) {
            mostrars("");
        } else {
            mostrars(vistaS.trBusq.getText());
        }

    }

    private void idIncre() {
        vistaU.trId.setText(ubo.getIncreID() + "");
    }

    private void limpiar() {
        vistaU.btAgr.setEnabled(true);
        vistaU.btMod.setEnabled(false);
        vistaU.trId.setEnabled(true);
        vistaU.trCo.setEnabled(true);
        vistaU.trCo.setText("");
        vistaU.cbEm.setSelectedIndex(0);
        vistaU.trUs.setText("");
        vistaU.trCon.setText("");
        vistaU.btAgr.setEnabled(true);
        vistaR.trBus.setText("");
        vistaU.Restaurar.setVisible(false);
        vistaU.btEli.setVisible(true);
        idIncre();

    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaU.btAgr) {

            if (vistaU.trUs.getText().isEmpty() || vistaU.trCon.getText().isEmpty() || vistaU.trId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                ingresar();
            }

        }
        if (e.getSource() == vistaU.btMod) {
            int res = JOptionPane.showConfirmDialog(this.vistaU, "¿Está seguro de Modificar los datos del Usuario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {

                if (vistaU.trCon.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                } else {
                    modificar();
                    vistaU.cbEm.setEnabled(true);
                }
            }

        }
        if (e.getSource() == vistaU.btEli) {
            eliminar();
        }

        if (e.getSource() == vistaU.Restaurar) {
            Restaurar();
        }
        if (e.getSource() == vistaU.chbIn) {
            mostrareliminados();
        }
        if (e.getSource() == vistaU.btMed) {
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
            TraerDatosMedico(vistaR.Tabla_REg_Empleado);
            mostrarm("");
        }
        if (e.getSource() == vistaU.btSec) {
            vistaS.setLocationRelativeTo(null);
            vistaS.setVisible(true);
            TraerDatosSecretaria(vistaS.Tabla_REg_Empleado);
            mostrars("");
        }
        if (e.getSource() == vistaS.btSal) {
            vistaS.dispose();
            vistaU.setLocationRelativeTo(null);
            vistaU.setVisible(true);
            vistaS.trBusq.setText("");
        }
        if (e.getSource() == vistaR.btSal) {
            vistaR.dispose();
            vistaU.setLocationRelativeTo(null);
            vistaU.setVisible(true);
            vistaR.trBus.setText("");
        }

        if (e.getSource() == vistaU.Bot_buscar_paciente) {
            buscarUsuarioTabla();
        }

        if (e.getSource() == vistaU.Bot_limpiar) {
            limpiar();
        }
    }

    public void buscarUsuarioTabla() {

        String cedula = vistaU.trBuscar.getText();
        if (vistaU.trBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Caja de texto vacia");
            vistaU.Tabla_Usuario.clearSelection();
            limpiar();
        } else {
            for (int i = 0; i < vistaU.Tabla_Usuario.getRowCount(); i++) {
                if (vistaU.Tabla_Usuario.getValueAt(i, 3).equals(cedula)) {
                    vistaU.Tabla_Usuario.requestFocus();
                    vistaU.Tabla_Usuario.changeSelection(i, 3, false, false);
                    vistaU.trId.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(i, 0)));
                    vistaU.trCo.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(i, 1)));
                    vistaU.cbEm.setSelectedItem(vistaU.Tabla_Usuario.getValueAt(vistaU.Tabla_Usuario.getSelectedRow(), 2));
                    vistaU.trUs.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(i, 3)));
                    vistaU.trCon.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(i, 4)));
                    vistaU.btAgr.setEnabled(false);
                    vistaU.btMod.setEnabled(true);
                    vistaU.Tabla_Usuario.clearSelection();
                    vistaU.trBuscar.setText("");
                } 
            }
        }
    }

    private void mostrar(String cedula) {
        ubo.listarUsuario(vistaU.Tabla_Usuario, cedula);
    }

    private void TraerDatosUsuario(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerUsuario(e);
            }
        });
    }

    void TraerUsuario(MouseEvent e) {

        int fila = vistaU.Tabla_Usuario.getSelectedRow();

        if (e.getClickCount() == 2) {

            vistaU.btAgr.setEnabled(false);
            vistaU.btMod.setEnabled(true);

            if (fila >= 0) {

                vistaU.Tabla_Usuario.changeSelection(fila, 0, false, false);
                vistaU.trId.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(fila, 0)));
                vistaU.trCo.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(fila, 1)));
                vistaU.cbEm.setSelectedItem(vistaU.Tabla_Usuario.getValueAt(vistaU.Tabla_Usuario.getSelectedRow(), 2));
                vistaU.trUs.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(fila, 3)));
                vistaU.trCon.setText(String.valueOf(vistaU.Tabla_Usuario.getValueAt(fila, 4)));
                vistaU.trBuscar.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    private void mostrarm(String cedula) {
        ubo.mostrarmedico(vistaR.Tabla_REg_Empleado, cedula);
    }

    private void TraerDatosMedico(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerMedico(e);
            }
        });
    }

    void TraerMedico(MouseEvent e) {

        int fila = vistaR.Tabla_REg_Empleado.getSelectedRow();

        if (e.getClickCount() == 2) {

            if (fila >= 0) {

                vistaR.Tabla_REg_Empleado.changeSelection(fila, 0, false, false);
                vistaU.trCo.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 0)));
                vistaU.trUs.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 1)));
                vistaR.trBus.setText("");
                vistaU.setLocationRelativeTo(null);
                vistaU.setVisible(true);
                vistaR.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    private void mostrars(String cedula) {
        ubo.mostrarsecretaria(vistaS.Tabla_REg_Empleado, cedula);
    }

    private void TraerDatosSecretaria(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerSecretaria(e);
            }
        });
    }

    void TraerSecretaria(MouseEvent e) {

        int fila = vistaS.Tabla_REg_Empleado.getSelectedRow();

        if (e.getClickCount() == 2) {

            if (fila >= 0) {

                vistaS.Tabla_REg_Empleado.changeSelection(fila, 0, false, false);
                vistaU.trCo.setText(String.valueOf(vistaS.Tabla_REg_Empleado.getValueAt(fila, 0)));
                vistaU.trUs.setText(String.valueOf(vistaS.Tabla_REg_Empleado.getValueAt(fila, 1)));
                vistaS.trBusq.setText("");
                vistaU.setLocationRelativeTo(null);
                vistaU.setVisible(true);
                vistaS.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList user = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarUser() {
        ubo.TraerDatosAutoUser(user, datos);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarUser(String us) {
        TraerDatosAutoCompletarUser(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = us.length();
        int last = us.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < user.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (user.get(a).toString().startsWith(us)) {

                complete = user.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaU.trBuscar.setText(complete);
            vistaU.trBuscar.setCaretPosition(last);
            vistaU.trBuscar.moveCaretPosition(start);

        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList cedula = new ArrayList();
    String data;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarMedico() {
        ubo.TraerDatosAutoMedico(cedula, data);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarMedico(String med) {
        TraerDatosAutoCompletarMedico(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = med.length();
        int last = med.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < cedula.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (cedula.get(a).toString().startsWith(med)) {

                complete = cedula.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaR.trBus.setText(complete);
            vistaR.trBus.setCaretPosition(last);
            vistaR.trBus.moveCaretPosition(start);

        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList ced = new ArrayList();
    String dat;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarSecretaria() {
        ubo.TraerDatosAutoSecretaria(ced, dat);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarSecretaria(String sec) {
        TraerDatosAutoCompletarSecretaria(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = sec.length();
        int last = sec.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < ced.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (ced.get(a).toString().startsWith(sec)) {

                complete = ced.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaS.trBusq.setText(complete);
            vistaS.trBusq.setCaretPosition(last);
            vistaS.trBusq.moveCaretPosition(start);

        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            if (vistaU.cbEm.getSelectedIndex() == 1) {
                vistaU.btMed.setEnabled(false);
                vistaU.btSec.setEnabled(true);
                String cedula = "";
                ubo.mostrarsecretaria(vistaS.Tabla_REg_Empleado, cedula);
            } else {
                if (vistaU.cbEm.getSelectedIndex() == 2) {
                    vistaU.btMed.setEnabled(true);
                    vistaU.btSec.setEnabled(false);
                    String cedula = "";
                    ubo.mostrarmedico(vistaR.Tabla_REg_Empleado, cedula);
                } else {
                }
                if (vistaU.cbEm.getSelectedIndex() == 0) {
                    vistaU.btMed.setEnabled(false);
                    vistaU.btSec.setEnabled(false);
                    String cedula = "";
                    ubo.listarUsuario(vistaU.Tabla_Usuario, cedula);
                    limpiar();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

//    void BuscarTablaEmpleados(){
//        if (vistaU.cbEm.getSelectedIndex() == 1) {
//            DatosAutoSecretaria(vistaR.trBus);
//        } else {
//            if (vistaU.cbEm.getSelectedIndex() == 2) {
//                DatosAutoMedico(vistaR.trBus);
//            } else {
//            }
//        }
//    }
    private void DatosAutoSecretaria(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarSecretaria(e);
            }
        });
    }

    private void DatosAutoMedico(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarMedico(e);
            }
        });
    }

    private void DatosAutoUser(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarUsuario(e);
            }
        });
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        BuscarTablaEmpleados();
    }

    void autocompletarUsuario(KeyEvent e) {
        BuscarU();
        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaU.trBuscar.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String user = vistaU.trBuscar.getText();
                        autoCompletarUser(user);
                    }
                });

        }
    }

    void autocompletarSecretaria(KeyEvent e) {
        Buscars();
        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrars(vistaS.trBusq.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String sec = vistaS.trBusq.getText();
                        autoCompletarSecretaria(sec);
                    }
                });

        }
    }

    void autocompletarMedico(KeyEvent e) {
        Buscar();
        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarm(vistaR.trBus.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String med = vistaR.trBus.getText();
                        autoCompletarMedico(med);
                    }
                });

        }
    }

    // validar tamaño
    public static void Validarcedtamaño(String ced, int tam, KeyEvent ev) {
        if (ced.trim().length() >= tam) {
            ev.consume();
            JOptionPane.showMessageDialog(null, "Campo completo");
        }
    }

    private void validarTamaño(JTextField txt, int tam) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                Validarcedtamaño(txt.getText(), tam, e);
            }
        });
    }
}
