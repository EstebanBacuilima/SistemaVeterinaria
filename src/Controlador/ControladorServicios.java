package Controlador;

import Modelo.Servicio;
import Modelo.ServicioBO;
import Modelo.ServiciosDAO;
import Vista.RegistrarServicios;
import java.awt.Color;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class ControladorServicios implements ActionListener, KeyListener {

    Servicio modeloS = new Servicio();
    ServiciosDAO mreg = new ServiciosDAO();
    ServicioBO sbo = new ServicioBO();
    Servicio s = new Servicio();
    RegistrarServicios vista = new RegistrarServicios();
    DefaultTableModel modelo = new DefaultTableModel();
    private String mensaje = "";

    public ControladorServicios(Servicio modeloS, RegistrarServicios v) {
        this.modeloS = modeloS;
        this.vista = v;
        this.vista.S_cancelar.addActionListener(this);
        this.vista.Sb_guardar.addActionListener(this);
        this.vista.Editars.addActionListener(this);
        this.vista.Sb_actualizar.addActionListener(this);
        this.vista.Sb_eliminar.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.Sinactivos.addActionListener(this);
        this.vista.Salir.addActionListener(this);
        listar(vista.S_Tabla);
        idServicio();
    }

    public void iniciar() {
        vista.setTitle("Servicios");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        idServicio();
        vista.S_id.setVisible(false);
        vista.Sb_actualizar.setEnabled(false);
        vista.S_cancelar.setVisible(false);
        validarsolonumeros(vista.S_cost);
    }

    private void idServicio() {
        vista.S_id.setText(sbo.getSerID() + "");
    }

    public void listar(JTable tabla) {

        String a;
        if (vista.S_Buscar.getText().isEmpty()) {
            a = "";

        } else {
            a = vista.S_Buscar.getText();
        }
        ArrayList<Servicio> lista;
        if (vista.Sinactivos.isSelected()) {
            lista = sbo.listarSBO(a, 'I');
        } else {
            lista = sbo.listarSBO(a, 'A');
        }
        modelo = (DefaultTableModel) tabla.getModel();

        Object[] object = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNom();
            object[2] = lista.get(i).getDesc();
            object[3] = lista.get(i).getPrecio();
            modelo.addRow(object);
        }
        vista.S_Tabla.setModel(modelo);
    }
//     solo numeros

    private void validarnum(java.awt.event.KeyEvent evt) {
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali) || vali == ',') {
            vista.getToolkit().beep();
            evt.consume();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
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

    public boolean validarnulos() {
        boolean v = false;
        char[] puntos = {'.'};
        int n_puntos = 0;
        String entra = vista.S_cost.getText();
        for (int i = 0; i < entra.length(); i++) {
            if (entra.charAt(i) == puntos[0]) {
                n_puntos++;
            }
        }
        if (vista.S_id.getText().equals("")) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Error al parecer no se pudo extraer la id del servicio de la base de datos", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.S_nom.getText().equals("")) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor ingrese el nombre", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.S_desc.getText().equals("")) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor ingrese una breve descripcion", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.S_cost.getText().equals("")) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor ingrese el precio del servicio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (n_puntos > 1) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor ingrese el precio con un solo punto decimal", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else {
            v = true;
        }
        return v;
    }

    public void agregar() {

        int id = Integer.parseInt(vista.S_id.getText());
        String nom = vista.S_nom.getText();
        String desc = vista.S_desc.getText();
        double prec = Double.parseDouble(vista.S_cost.getText());

        //System.out.println("" + id + nom + desc + prec);
        s.setId(id);
        s.setNom(nom);
        s.setDesc(desc);
        s.setPrecio(prec);
        mensaje = sbo.agregarSBO(s);
        JOptionPane.showMessageDialog(null, mensaje);

    }

    public void actualizar() {
        int id = Integer.parseInt(vista.S_id.getText());
        String nom = vista.S_nom.getText();
        String desc = vista.S_desc.getText();
        double prec = Double.parseDouble(vista.S_cost.getText().toString());
        s.setId(id);
        s.setNom(nom);
        s.setDesc(desc);
        s.setPrecio(prec);
        mensaje = sbo.actualizarSBO(s);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void eliminar() {
        int fila = vista.S_Tabla.getSelectedRow();
        if (fila == -1) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt((String) vista.S_Tabla.getValueAt(fila, 0).toString());
            mensaje = sbo.eliminarSBO(id);
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.S_Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void limpiarDatos() {
        vista.S_Buscar.setText("");
        vista.S_id.setText("");
        vista.S_nom.setText("");
        vista.S_desc.setText("");
        vista.S_cost.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        ---------------------------------------MOSTRAR---------------------
        if (e.getSource() == vista.S_cancelar) {
            limpiarDatos();
            limpiarTabla();
            listar(vista.S_Tabla);
            idServicio();

            vista.Sb_guardar.setEnabled(true);
            vista.Sb_eliminar.setVisible(true);
            vista.Sb_actualizar.setEnabled(false);
            vista.S_cancelar.setVisible(false);

//        ---------------------------------------GUARDAR---------------------   
        }
        if (e.getSource() == vista.Sb_guardar) {
            if (validarnulos() == true) {
                agregar();
                limpiarDatos();
                limpiarTabla();
                listar(vista.S_Tabla);
                idServicio();

            }
        }
//        ---------------------------------------EDITAR---------------------
        if (e.getSource() == vista.Editars) {
            int fila = vista.S_Tabla.getSelectedRow();
            if (fila == -1) {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt((String) vista.S_Tabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.S_Tabla.getValueAt(fila, 1);
                String des = (String) vista.S_Tabla.getValueAt(fila, 2);
                double pre = Double.parseDouble((String) vista.S_Tabla.getValueAt(fila, 3).toString());
                vista.S_id.setText("" + id);
                vista.S_nom.setText(nom);
                vista.S_desc.setText(des);
                vista.S_cost.setText("" + pre);

                vista.Sb_guardar.setEnabled(false);
                vista.Sb_eliminar.setVisible(false);
                vista.Sb_actualizar.setEnabled(true);
                vista.S_cancelar.setVisible(true);
            }
        }
//        ---------------------------------------ACTUALIZAR---------------------
        if (e.getSource() == vista.Sb_actualizar) {
            if (validarnulos() == true) {
                actualizar();
                limpiarDatos();
                limpiarTabla();
                listar(vista.S_Tabla);
                idServicio();
                vista.Sb_guardar.setEnabled(true);
                vista.Sb_eliminar.setVisible(true);
                vista.Sb_actualizar.setEnabled(false);
                vista.S_cancelar.setVisible(false);
            }
        }
//        ---------------------------------------ELIMINAR---------------------
        if (e.getSource() == vista.Sb_eliminar) {
            eliminar();
            limpiarDatos();
            limpiarTabla();
            listar(vista.S_Tabla);
            idServicio();
        }

        if (e.getSource() == vista.Sinactivos) {
            if (vista.Sinactivos.isSelected()) {
                vista.Sb_eliminar.setVisible(true);
                vista.Sb_eliminar.setEnabled(false);
                vista.Sb_guardar.setEnabled(false);
                vista.Sb_actualizar.setEnabled(false);
                vista.Editars.setEnabled(false);
                vista.S_cancelar.setVisible(false);
                limpiarDatos();
                limpiarTabla();
                listar(vista.S_Tabla);
                idServicio();
            } else {
                vista.Sb_eliminar.setVisible(true);
                vista.Sb_eliminar.setEnabled(true);
                vista.Sb_guardar.setEnabled(true);
                vista.Sb_actualizar.setEnabled(true);
                vista.Editars.setEnabled(true);
                vista.S_cancelar.setVisible(false);
                limpiarDatos();
                limpiarTabla();
                listar(vista.S_Tabla);
                idServicio();
                iniciar();
            }
        }
        
        if (e.getSource() == vista.Bot_Limpiar) {
            vista.Sb_actualizar.setEnabled(false);
            vista.S_cancelar.setVisible(false);
            vista.Sb_guardar.setEnabled(true);
            vista.Sb_eliminar.setVisible(true);
            vista.Sb_eliminar.setEnabled(true);
            vista.Sinactivos.setSelected(false);
            vista.Editars.setEnabled(true);
            limpiarDatos();
            idServicio();
            
        }
        
        if (e.getSource() == vista.Salir) {
            vista.dispose();
            limpiarDatos();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        listar(vista.S_Tabla);
        limpiarTabla();
        listar(vista.S_Tabla);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

}
