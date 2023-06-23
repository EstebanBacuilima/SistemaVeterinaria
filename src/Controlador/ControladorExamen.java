package Controlador;

import static Controlador.ControladorMascota.Imagen;
import static Controlador.ControladorMascota.Orig;
import Modelo.Examen;
import Modelo.ExamenBO;
import Modelo.MedicoBO;
import Modelo.MascotaBO;
import Modelo.MascotaDAO;
import Modelo.Propietario;
import Vista.ExamenMascota;
import Vista.ReporteMascotas;
import Vista.ReporteMedico;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorExamen implements ActionListener, MouseListener, KeyListener {

    Examen modelo = new Examen();
    ExamenMascota vista = new ExamenMascota();
    private ExamenBO modeloBO = new ExamenBO();

    // TRAER ID DELOS OTROS CONTROLADORES
    ReporteMascotas vistaMascotas = new ReporteMascotas();
    private MascotaBO modeloPacienteBO = new MascotaBO();

    ReporteMedico vistaMedicos = new ReporteMedico();
    private MedicoBO modeloMedicoBO = new MedicoBO();

    public ControladorExamen(Examen modelo, ExamenMascota vista, ReporteMascotas vistaM) {

        this.modelo = modelo;
        this.vista = vista;

        this.vista.Bot_guardar.addActionListener(this);
        this.vista.Bot_buscar_mascota.addActionListener(this);
        this.vista.Bot_buscar_medico.addActionListener(this);
        this.vista.Bot_Regresar.addActionListener(this);
        this.vista.Bot_limpiar.addActionListener(this);

        //ADICIONALES
        this.vistaMascotas.Bot_Regresar_Repo.addActionListener(this);
        this.vistaMascotas.Tablas_Pacientes_2.addMouseListener(this);
        DatosAutoPaciente(vistaMascotas.Txt_Buscar_Ce);
        DatosAutoVete(vistaMedicos.txtBuscarCedMed);

        this.vistaMedicos.Bot_Regresar_Repo.addActionListener(this);
        this.vistaMedicos.txtBuscarCedMed.addKeyListener(this);

        // MOSUSE CLICKED
        //this.vistaMedicos.Tablas_Med.addMouseListener(this);
        TraerDatosDosClick(vistaMedicos.Tablas_Med);
        TraerDatosDosClickTabla2(vistaMascotas.Tablas_Pacientes_2);

    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.Id_Examen.setVisible(false);
        vista.Id_mascota.setVisible(false);
        vista.Id_medico.setVisible(false);

        vista.Nombre_Mascota.setEditable(false);
        vista.Nombre_medico.setEditable(false);
        idExame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.Bot_guardar) {
            guardarExamen();
        }

        // PACIENTE
        if (e.getSource() == vista.Bot_buscar_mascota) {
            //TraerDatos();
            mostrarPaciente("");
            vistaMascotas.setLocationRelativeTo(null);
            vistaMascotas.setVisible(true);
        }
        if (e.getSource() == vistaMascotas.Bot_Regresar_Repo) {
            vistaMascotas.dispose();
        }

        // MEDICO
        if (e.getSource() == vista.Bot_buscar_medico) {
            //TraerDatosMedico();
            mostrarMedico("");
            vistaMedicos.setLocationRelativeTo(null);
            vistaMedicos.setVisible(true);
        }
        if (e.getSource() == vistaMedicos.Bot_Regresar_Repo) {
            vistaMedicos.dispose();
        }

        //       
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
        }
        if (e.getSource() == vista.Bot_limpiar) {
            Limpiar();
        }
    }

    private void TraerDatosDosClick(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosMedico(e);
            }
        });
    }

    //--------------------------------TRAER DATOS MEDICO A TXTFIELDS-----------------------------
    private void mostrarMedico(String cedula) {
        modeloMedicoBO.listarMedico(vistaMedicos.Tablas_Med, cedula);
    }

    void TraerDatosMedico(MouseEvent e) {

        String nombre = "";
        String apelido = "";
        String Completo = "";

        int fila = vistaMedicos.Tablas_Med.getSelectedRow();

        if (e.getClickCount() == 2) {
            if (fila >= 0) {

                vista.Id_medico.setText(String.valueOf(vistaMedicos.Tablas_Med.getValueAt(fila, 0)));
                vista.Nombre_medico.setText(String.valueOf(vistaMedicos.Tablas_Med.getValueAt(fila, 2)));
                vistaMedicos.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    //---------------------------------------------------------------------------------------------
    private void TraerDatosDosClickTabla2(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosPaciente(e);
            }
        });
    }

    //--------------------------------TRAER DATOS PACIENTE A TXTFIELDS-----------------------------
    private void mostrarPaciente(String clave) {
        modeloPacienteBO.listarPacientes(vistaMascotas.Tablas_Pacientes_2, clave);
    }

    void TraerDatosPaciente(MouseEvent e) {

        int fila = vistaMascotas.Tablas_Pacientes_2.getSelectedRow();

        if (e.getClickCount() == 2) {
            if (fila >= 0) {

                vistaMascotas.Tablas_Pacientes_2.changeSelection(fila, 0, false, false);
                vista.Id_mascota.setText(String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 0)));
                vista.Nombre_Mascota.setText(String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 2)));
                vistaMascotas.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }
    //-------------------------------------------------------------------------------------------------

    // IDES
    private void idExame() {
        vista.Id_Examen.setText(modeloBO.IdExamne() + "");
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    // METODOS 
    ArrayList<Examen> listaExamens = new ArrayList<>();

    public void guardarExamen() {

        if (vista.Nombre_Mascota.getText().isEmpty() || vista.Nombre_medico.getText().isEmpty() || vista.NombreExa.getText().isEmpty() || vista.des_exa.getText().isEmpty() || vista.Resul_exa.getText().isEmpty() || vista.TipoEax.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));

        } else {

            int Id_examen = Integer.parseInt(vista.Id_Examen.getText());
            int Id_medico = Integer.parseInt(vista.Id_medico.getText());
            int Id_mascota = Integer.parseInt(vista.Id_mascota.getText());

            String nombreExa = vista.NombreExa.getText();
            String tipoExa = vista.TipoEax.getText();
            String ObsrvacionesExa = vista.des_exa.getText();
            String ResultadosExa = vista.Resul_exa.getText();

            Examen newExamen = new Examen();

            newExamen.setExamen_id(Id_examen);
            newExamen.setMedico_id(Id_medico);
            newExamen.setMascota_id(Id_mascota);

            newExamen.setNombre_examen(nombreExa);
            newExamen.setTipo_examen(tipoExa);
            newExamen.setObservaciones(ObsrvacionesExa);
            newExamen.setResutaldo_exa(ResultadosExa);

            listaExamens.add(newExamen);
            String mensaje = modeloBO.guardarExamen(newExamen);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            Limpiar();
        }

    }

    void Limpiar() {

        vista.Nombre_Mascota.setText("");
        vista.Nombre_medico.setText("");

        vista.Id_Examen.setText("");
        vista.Id_medico.setText("");
        vista.Id_mascota.setText("");
        vista.NombreExa.setText("");
        vista.TipoEax.setText("");
        vista.des_exa.setText("");
        vista.Resul_exa.setText("");
        idExame();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //TraerDatosMedico(e);
        //TraerDatosPaciente(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    //-------- MASCOTAS -------------------------------------------------------------------------------
    private MascotaDAO validacionDao = new MascotaDAO();

    // CREAR ARRAY LISTA ALMACENAR 
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

            vistaMascotas.Txt_Buscar_Ce.setText(complete);
            vistaMascotas.Txt_Buscar_Ce.setCaretPosition(last);
            vistaMascotas.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }

    void autocompletarPaciente(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarPaciente(vistaMascotas.Txt_Buscar_Ce.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaMascotas.Txt_Buscar_Ce.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }

    void BusquedaTablas() {

        if (vistaMascotas.Txt_Buscar_Ce.getText().isEmpty()) {
            mostrarPaciente("");
            Limpiar();
        } else {
            mostrarPaciente(vistaMascotas.Txt_Buscar_Ce.getText());
        }
    }

    private void DatosAutoPaciente(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarPaciente(e);
            }
        });
    }

    //-------- MASCOTAS -------------------------------------------------------------------------------
    @Override
    public void keyReleased(KeyEvent e) {
        BusquedaTablas();
    }
    
    //------------------------------------------------------------------

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList nameVet = new ArrayList();
    String datosVet;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletar() {
        modeloMedicoBO.TraerDatosAuto(nameVet, datosVet);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarVet(String txt) {
        TraerDatosAutoCompletar(); // TRAER EL METODO LLENAR ARRAY
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

            vistaMedicos.txtBuscarCedMed.setText(complete);
            vistaMedicos.txtBuscarCedMed.setCaretPosition(last);
            vistaMedicos.txtBuscarCedMed.moveCaretPosition(start);

        }
    }
    // AUTOCOMPLETAR KEY RELEASED

    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarMedico(vistaMedicos.txtBuscarCedMed.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaMedicos.txtBuscarCedMed.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }
    
    private void DatosAutoVete(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarCedula(e);
            }
        });
    }
}
