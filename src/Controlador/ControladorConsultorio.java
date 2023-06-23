package Controlador;

import Modelo.Consultorio;
import Modelo.ConsultorioBO;
import Modelo.ConsultorioDAO;
import Vista.RegistrarConsultorios;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ediss
 */
public class ControladorConsultorio implements ActionListener, KeyListener {

    Consultorio modeloC = new Consultorio();
    ConsultorioDAO codao = new ConsultorioDAO();
    ConsultorioBO cobo = new ConsultorioBO();
    Consultorio co = new Consultorio();
    RegistrarConsultorios vista = new RegistrarConsultorios();
    DefaultTableModel modelo = new DefaultTableModel();
    private String mensaje = "";

    public ControladorConsultorio(Consultorio modeloC, RegistrarConsultorios v) {

        this.modeloC = modeloC;
        this.vista = v;

        this.vista = v;
        this.vista.Cob_guardar.addActionListener(this);
        this.vista.Editarco.addActionListener(this);
        this.vista.Cob_actualizar.addActionListener(this);
        this.vista.Cob_eliminar.addActionListener(this);
        this.vista.Coinactivos.addActionListener(this);
        this.vista.Cob_cancelar.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.salir.addActionListener(this);
        listar(vista.Co_Tabla);
        idConsultorio();
    }

    public void iniciar() {
        idConsultorio();
        vista.Co_id.setVisible(false);
        vista.Cob_actualizar.setEnabled(false);
        vista.Cob_cancelar.setVisible(false);
        idConsultorio();
        vista.setTitle("Consultorio");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
    }

    private void idConsultorio() {
        vista.Co_id.setText(cobo.getConsultorioID() + "");
    }

    public void listar(JTable tabla) {
        String a;
        if (vista.S_Buscar.getText().isEmpty()) {
            a = "";

        } else {
            a = vista.S_Buscar.getText();
        }

        ArrayList<Consultorio> lista;
        if (vista.Coinactivos.isSelected()) {
            lista = cobo.listarCoBO(a, 'I');
        } else {
            lista = cobo.listarCoBO(a, 'A');
        }
        modelo = (DefaultTableModel) tabla.getModel();

        Object[] object = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getNom();
            object[2] = lista.get(i).getDesc();
            modelo.addRow(object);
        }
        vista.Co_Tabla.setModel(modelo);
    }

    public void agregar() {
        int id = Integer.parseInt(vista.Co_id.getText());
        String nom = vista.Co_nom.getText();
        String desc = vista.Co_desc.getText();
        //System.out.println("" + id + nom + desc);
        co.setId(id);
        co.setNom(nom);
        co.setDesc(desc);
        mensaje = cobo.agregarCoBO(co);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void actualizar() {
        int id = Integer.parseInt(vista.Co_id.getText());
        String nom = vista.Co_nom.getText();
        String desc = vista.Co_desc.getText();
        co.setId(id);
        co.setNom(nom);
        co.setDesc(desc);
        mensaje = cobo.actualizarCoBO(co);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void eliminar() {

        int fila = vista.Co_Tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            int id = Integer.parseInt((String) vista.Co_Tabla.getValueAt(fila, 0).toString());
            mensaje = cobo.eliminarCoBO(id);
            JOptionPane.showMessageDialog(null, mensaje);
        }

    }

    public boolean validarnulos() {
        boolean v = false;

        if (vista.Co_id.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Error al parecer no se pudo extraer la id del servicio de la base de datos", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.Co_nom.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor inrese el nombre", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.Co_desc.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor inrese una breve descripcion", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else {
            v = true;
        }
        return v;
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.Co_Tabla.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    void limpiarDatos() {
        vista.S_Buscar.setText("");
        vista.Co_id.setText("");
        vista.Co_nom.setText("");
        vista.Co_desc.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//        ---------------------------------------GUARDAR---------------------   
        if (e.getSource() == vista.Cob_guardar) {
            if (validarnulos() == true) {
                agregar();
                limpiarDatos();
                limpiarTabla();
                listar(vista.Co_Tabla);
                idConsultorio();
            }
        }
//        ---------------------------------------EDITAR---------------------
        if (e.getSource() == vista.Editarco) {
            int fila = vista.Co_Tabla.getSelectedRow();
            if (fila == -1) {
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                int id = Integer.parseInt((String) vista.Co_Tabla.getValueAt(fila, 0).toString());
                String nom = (String) vista.Co_Tabla.getValueAt(fila, 1);
                String des = (String) vista.Co_Tabla.getValueAt(fila, 2);
                vista.Co_id.setText("" + id);
                vista.Co_nom.setText(nom);
                vista.Co_desc.setText(des);
                vista.Cob_guardar.setEnabled(false);
                vista.Cob_eliminar.setVisible(false);
                vista.Cob_actualizar.setEnabled(true);
                vista.Cob_cancelar.setVisible(true);

            }
        }
//        ---------------------------------------ACTUALIZAR---------------------
        if (e.getSource() == vista.Cob_actualizar) {
            if (validarnulos() == true) {
                actualizar();
                limpiarDatos();
                limpiarTabla();
                listar(vista.Co_Tabla);
                idConsultorio();
                vista.Cob_guardar.setEnabled(true);
                vista.Cob_eliminar.setVisible(true);
                vista.Cob_actualizar.setEnabled(false);
                vista.Cob_cancelar.setVisible(false);
            }
        }
//        ---------------------------------------ELIMINAR---------------------
        if (e.getSource() == vista.Cob_eliminar) {
            eliminar();
            limpiarDatos();
            limpiarTabla();
            listar(vista.Co_Tabla);
            idConsultorio();
        }
        if (e.getSource() == vista.Cob_cancelar) {
            limpiarDatos();
            limpiarTabla();
            listar(vista.Co_Tabla);
            idConsultorio();
            vista.Cob_guardar.setEnabled(true);
            vista.Cob_eliminar.setVisible(true);
            vista.Cob_actualizar.setEnabled(false);
            vista.Cob_cancelar.setVisible(false);
        }

        if (e.getSource() == vista.Coinactivos) {
            if (vista.Coinactivos.isSelected()) {
                vista.Cob_eliminar.setVisible(true);
                vista.Cob_eliminar.setEnabled(false);
                vista.Cob_guardar.setEnabled(false);
                vista.Cob_actualizar.setEnabled(false);
                vista.Editarco.setEnabled(false);
                vista.Cob_cancelar.setVisible(false);
                limpiarDatos();
                limpiarTabla();
                listar(vista.Co_Tabla);
                idConsultorio();
            } else {
                vista.Cob_eliminar.setVisible(true);
                vista.Cob_eliminar.setEnabled(true);
                vista.Cob_guardar.setEnabled(true);
                vista.Cob_actualizar.setEnabled(true);
                vista.Editarco.setEnabled(true);
                vista.Cob_cancelar.setVisible(false);
                limpiarDatos();
                limpiarTabla();
                listar(vista.Co_Tabla);
                idConsultorio();
                iniciar();
            }
        }
        
        if (e.getSource() == vista.Bot_Limpiar) {
            vista.Cob_actualizar.setEnabled(false);
            vista.Cob_cancelar.setVisible(false);
            vista.Cob_guardar.setEnabled(true);
            vista.Cob_eliminar.setVisible(true);
            vista.Cob_eliminar.setEnabled(true);
            vista.Coinactivos.setSelected(false);
            vista.Editarco.setEnabled(true);
            limpiarDatos();
            idConsultorio();
            
        }
        
        if (e.getSource() == vista.salir) {
            vista.dispose();
            limpiarDatos();
        }

    }

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        listar(vista.Co_Tabla);
        limpiarTabla();
        listar(vista.Co_Tabla);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }
}
