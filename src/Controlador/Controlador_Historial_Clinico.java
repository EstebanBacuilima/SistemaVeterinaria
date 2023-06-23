package Controlador;

import static Controlador.ControladorMascota.Imagen;
import static Controlador.ControladorMascota.Orig;
import Modelo.ExamenBO;
import Modelo.MascotaBO;
import Modelo.MascotaDAO;
import Modelo.PropietaroBO;
import Modelo.RecetaBO;
import Vista.HistorialMascota;
import Vista.ReporteMascotas;
import Vista.VerDetalleReceta;
import Vista.VerDetalles;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class Controlador_Historial_Clinico implements ActionListener, ItemListener {

    HistorialMascota vista = new HistorialMascota();
    VerDetalles vistDetalles = new VerDetalles();
    VerDetalleReceta vistReceta = new VerDetalleReceta();

    ReporteMascotas vistaMascotasRe = new ReporteMascotas();
    private MascotaBO modeloBO = new MascotaBO();
    private PropietaroBO modeloPro = new PropietaroBO();
    private ExamenBO modeloEx = new ExamenBO();
    private RecetaBO modeloReceta = new RecetaBO();
    
     private MascotaDAO validacionDao = new MascotaDAO();
       

    public Controlador_Historial_Clinico(HistorialMascota vista) {

        this.vista = vista;
        this.vista.Bot_buscar_paciente.addActionListener(this);
        this.vistaMascotasRe.Bot_Regresar_Repo.addActionListener(this);
        this.vista.Tipo_historial.addItemListener(this);
        this.vista.Boton_regresar.addActionListener(this);
        this.vista.Bot_limpiar2.addActionListener(this);
        this.vista.Ver_detalle.addActionListener(this);
        this.vistDetalles.Bot_Regresar.addActionListener(this);
        this.vistReceta.Bot_Regresar.addActionListener(this);
        this.vista.Ver_detalle_receta.addActionListener(this);
        TraerDatosDosClickPaciente(vistaMascotasRe.Tablas_Pacientes_2);
        DatosAutoPaciente(vistaMascotasRe.Txt_Buscar_Ce);
    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.Id_mascota.setVisible(false);
        vista.Tipo_historial.setEnabled(false);
        vista.clave_mascota.setEditable(false);
        vista.ocultar_tablas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Bot_buscar_paciente) {
            mostrarPaciente("");
            vistaMascotasRe.setLocationRelativeTo(null);
            vistaMascotasRe.setVisible(true);
        }
        if (e.getSource() == vistaMascotasRe.Bot_Regresar_Repo) {
            vistaMascotasRe.dispose();
        }
        if (e.getSource() == vista.Ver_detalle) {
            vistDetalles.setVisible(true);
            vistDetalles.setLocationRelativeTo(null);
            EnviarAtextArea();
        }
        if (e.getSource() == vistDetalles.Bot_Regresar) {
            vistDetalles.dispose();
        }
        
        if (e.getSource() == vista.Ver_detalle_receta) {
            vistReceta.setVisible(true);
            vistReceta.setLocationRelativeTo(null);
            EnviarAtextAreaReceta();
        }
        if (e.getSource() == vistReceta.Bot_Regresar) {
            vistReceta.dispose();
        }

        if (e.getSource() == vista.Boton_regresar) {
            vista.dispose();
            Limpiar();
        }
        if (e.getSource() == vista.Bot_limpiar2) {
            Limpiar();
        }
    }

    // ----------------------------------------LISTAR PACIENTES---------------------------------------------------------
    private void mostrarPaciente(String clave) {
        modeloBO.listarPacientes(vistaMascotasRe.Tablas_Pacientes_2, clave);
    }

    void TraerDatosPaciente(MouseEvent e) {

        int fila = vistaMascotasRe.Tablas_Pacientes_2.getSelectedRow();

        if (e.getClickCount() == 2) {

            if (fila >= 0) {

                vista.Id_mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 0).toString());
                vista.clave_mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 1).toString());
                vista.Nombre_Mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 2).toString());
                vista.Edad_Mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 3).toString());
                vista.Peso_Mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 4).toString());
                String sexo = String.valueOf(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 5).toString());
                if ("Macho".equals(sexo)) {
                    vista.Sexo_Mascota.setText(sexo);
                } else if ("Hembra".equals(sexo)) {
                    vista.Sexo_Mascota.setText(sexo);
                }
                vista.Especie_Mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 6).toString());
                vista.Raza_Mascota.setText(vistaMascotasRe.Tablas_Pacientes_2.getValueAt(fila, 7).toString());

                int ID = Integer.parseInt(vista.Id_mascota.getText());
                String CLAVE = vista.clave_mascota.getText();

                DatosPropietario(ID, CLAVE);

                vistaMascotasRe.dispose();
                vista.Tipo_historial.setEnabled(true);
                vista.Tipo_historial.setSelectedIndex(0);
                vista.ocultar_tablas.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }

    }

    private void TraerDatosDosClickPaciente(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosPaciente(e);
            }
        });
    }
    // ----------------------------------------LISTAR PACIENTES---------------------------------------------------------

    // DATOS PORPIETARIO---------------------------------------------------------------------------------------------
    void DatosPropietario(int ID, String ClAVE) {
        modeloPro.mostrardatosHistorial(ClAVE, ID, vista.Cedula_Pro, vista.nombres_Pro, vista.corre_Pro3, vista.Direc_Pro, vista.Telf_Pro2);
    }

    // DATOS PORPIETARIO---------------------------------------------------------------------------------------------
    // LLENADO DE TABLAS
    // EXAMENS
    void ExamenesHistorial(JTable tabla, int id_mascota) {
        modeloEx.mostrardatosExamenes(tabla, id_mascota);
    }

    // RECETAS
    void recetasHistorial(JTable tabla, int id_mascota) {
        modeloReceta.listarRecetaHist(tabla, id_mascota);
    }

    // COMBOBOX
    @Override
    public void itemStateChanged(ItemEvent e) {

        int ID = Integer.parseInt(vista.Id_mascota.getText());

        if (vista.Tipo_historial.getSelectedIndex() == 0) {
            LimpiarTabla();
        } else {
            if (vista.Tipo_historial.getSelectedIndex() == 1) {
                ExamenesHistorial(vista.Tablas_Historial, ID);
                vista.Ver_detalle_receta.setVisible(false);
                vista.Ver_detalle.setVisible(true);
            } else {
                if (vista.Tipo_historial.getSelectedIndex() == 2) {
                    recetasHistorial(vista.Tablas_Historial, ID);
                    vista.Ver_detalle_receta.setVisible(true);
                    vista.Ver_detalle.setVisible(false);
                }
            }

        }

    }
    
    // ver detalladamnete

    public void EnviarAtextArea() {

        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila >= 0) {
            vistDetalles.Nom_examen.setText(vista.Tablas_Historial.getValueAt(fila, 0).toString());
            vistDetalles.Tipo_examne.setText(vista.Tablas_Historial.getValueAt(fila, 1).toString());
            vistDetalles.Area_Observaciones.setText(vista.Tablas_Historial.getValueAt(fila, 2).toString());
            vistDetalles.Area_Observaciones.setEditable(false);
            vistDetalles.Area_Detalles.setText(vista.Tablas_Historial.getValueAt(fila, 3).toString());
            vistDetalles.Area_Detalles.setEditable(false);
        } else {
            vistDetalles.setVisible(false);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No seleciono fila");
        }
    }
    
    // ver detalladamnete receta

    public void EnviarAtextAreaReceta() {

        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila >= 0) {
            vistReceta.Nom_vet.setText(vista.Tablas_Historial.getValueAt(fila, 0).toString());
            vistReceta.FEcha_emision.setText(vista.Tablas_Historial.getValueAt(fila, 1).toString());
            vistReceta.Area_Diagnostico.setText(vista.Tablas_Historial.getValueAt(fila, 2).toString());
            vistReceta.Area_Diagnostico.setEditable(false);
            vistReceta.Area_Indicaciones.setText(vista.Tablas_Historial.getValueAt(fila, 3).toString());
            vistReceta.Area_Indicaciones.setEditable(false);
        } else {
            vistDetalles.setVisible(false);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No seleciono fila");
        }
    }

    public void Limpiar() {

        vista.Id_mascota.setText("");
        vista.clave_mascota.setText("");
        vista.Nombre_Mascota.setText("");
        vista.Sexo_Mascota.setText("");
        vista.Edad_Mascota.setText("");
        vista.Peso_Mascota.setText("");
        vista.Especie_Mascota.setText("");
        vista.Raza_Mascota.setText("");
        vista.Nombre_Mascota.setText("");
        vista.Cedula_Pro.setText("");
        vista.Direc_Pro.setText("");
        vista.corre_Pro3.setText("");
        vista.Telf_Pro2.setText("");
        vista.nombres_Pro.setText("");

        vista.ocultar_tablas.setVisible(true);
        vista.Tipo_historial.setEnabled(false);

        LimpiarTabla();

    }

    public void LimpiarTabla() {
        
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };
        vista.Tablas_Historial.setModel(modelo);
        int rowCount = modelo.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            modelo.removeRow(i);
        }
    }

    // AUTOCOMPLETADOS TABLAS PACIENTE
    // CREAR ARRAY LISTA ALMACENAR PACIENTES ------------------------------------------------------------
    ArrayList name = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatos() {
        validacionDao.TraerDatosAuto(name, datos);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletar(String txt) {
        TraerDatos();
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = txt.length();
        int last = txt.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < name.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (name.get(a).toString().startsWith(txt)) {

                complete = name.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaMascotasRe.Txt_Buscar_Ce.setText(complete);
            vistaMascotasRe.Txt_Buscar_Ce.setCaretPosition(last);
            vistaMascotasRe.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }
    void autocompletarPaciente(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarPaciente(vistaMascotasRe.Txt_Buscar_Ce.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaMascotasRe.Txt_Buscar_Ce.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }
    
    // METODOS KEY RELEASE
    private void DatosAutoPaciente(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarPaciente(e);
            }
        });
    }
    //------------------------------------------------------------------------------
    
}
