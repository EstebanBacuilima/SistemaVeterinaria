package Controlador;

import javax.swing.JOptionPane;
import Modelo.*;
import Validaciones.ValidacionFechasNacimiento;
import Vista.DiseñoReceta;
import Vista.RegistroRecetas;
import Vista.ReporteMascotas;
import Vista.ReporteMedico;
import Vista.ReporteRecetas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class ControladorReceta implements ActionListener, KeyListener, MouseListener, Printable {

    UIManager UI;
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    Receta modelo = new Receta();
    RegistroRecetas vista = new RegistroRecetas();
    ReporteRecetas vistaRepReceta = new ReporteRecetas();
    ReporteMedico vistaRepMed = new ReporteMedico();
    ReporteMascotas vistaRepMasc = new ReporteMascotas();
    DiseñoReceta vistaDR = new DiseñoReceta();

    private RecetaBO modeloRec = new RecetaBO();
    private MascotaBO modeloMas = new MascotaBO();
    private MedicoBO modeloMed = new MedicoBO();
    ValidacionFechasNacimiento validarFecha = new ValidacionFechasNacimiento();

    public ControladorReceta(Receta modelo, RegistroRecetas vista, ReporteRecetas vistaM) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.Bot_registrar.addActionListener(this);
        this.vista.Bot_actualizar.addActionListener(this);
        this.vista.Bot_eliminar.addActionListener(this);
        this.vista.Bot_Reporte.addActionListener(this);
        this.vista.Bot_Regresar.addActionListener(this);
        this.vista.Bot_buscar.addActionListener(this);
        this.vista.Bot_limpiar.addActionListener(this);

        this.vista.Bot_ConsultarMed.addActionListener(this);
        this.vista.Bot_ConsultarMasc.addActionListener(this);
        this.vista.Bot_Imprimir.addActionListener(this);

        this.vistaRepReceta.Bot_Regresar_Repo.addActionListener(this);
        this.vistaRepReceta.Bot_RepBuscar.addActionListener(this);
        //ACTION REPORTES
        this.vistaRepMed.Bot_Regresar_Repo.addActionListener(this);
        this.vistaRepMasc.Bot_Regresar_Repo.addActionListener(this);

        // MOUSE CLICKED
        TraerDatosClick1(vistaRepMed.Tablas_Med);
        TraerDatosClick2(vistaRepMasc.Tablas_Pacientes_2);
        this.vistaRepReceta.Tablas_Rec.addMouseListener(this);
        // EVENTOS BUSCAR EN FRAME TODOS
        this.vistaRepReceta.txtConsultar.addKeyListener(this);

        // EVENTOS DE MOUSE
        this.vista.Bot_registrar.addMouseListener(this);
        this.vista.Bot_actualizar.addMouseListener(this);
        this.vista.Bot_eliminar.addMouseListener(this);

        // TXT FIELS
        validarTamaño(vista.Diagnostico_receta, 100);
        validarTamaño(vista.indicaciones_receta, 600);

    }
//INICIAR

    public void iniciar() {
        vista.setTitle("Receta");
        vista.setLocationRelativeTo(null);
        vistaDR.setLocationRelativeTo(null);
        vista.setVisible(true);
        idReceta();
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_actualizar.setEnabled(false);
        vista.ErrorIdMascota.setVisible(false);
        vista.ErrorCedMed.setVisible(false);
        vista.ErrorF_Emision.setVisible(false);
        vista.ErrorDiagnostico.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);

        vista.ErrorIndicaciones.setVisible(false);
        vista.nom_mascota.setEditable(false);
        vista.nom_medico.setEditable(false);
        vista.Bot_Imprimir.setEnabled(false);
        vista.Id_medico.setVisible(false);
        vista.ErrorIndicaciones.setVisible(false);
        vista.EspecialidadMedic.setVisible(false);

        vista.Id_Recetas.setEditable(false);
        vista.CedMedico.setEditable(false);
        vista.id_mascota.setEditable(false);
    }
// INCONO JOPTIONPANE

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
//EVENTOS DE ACTIONPERFORMED

    @Override
    public void actionPerformed(ActionEvent e) {
// BOTON REGISTRAR
        if (e.getSource() == vista.Bot_registrar) {
                if (vista.id_mascota.getText().isEmpty() || vista.Id_medico.getText().isEmpty() || vista.indicaciones_receta.getText().isEmpty() || vista.fechaEmision.getDate()==null) {
            UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE,
                        icono("/iconos/alerta.png", 40, 40));
            } else {
                crearReceta();
                vista.Bot_Imprimir.setEnabled(true);
                vista.ErrorF_Emision.setVisible(false);
            }
        }
// BOTON ACTUALIZAR        
        if (e.getSource() == vista.Bot_actualizar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos de la Receta?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));

            if (res == JOptionPane.YES_OPTION) {
                if (vista.id_mascota.getText().isEmpty() || vista.Id_medico.getText().isEmpty() || vista.indicaciones_receta.getText().isEmpty() || vista.fechaEmision.getDate()==null) {
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "No se ha completado la operacion, existe algun campo vacio");
                } else {
                    modificarReceta();
                    vista.Bot_Imprimir.setEnabled(true);
                    vista.ErrorF_Emision.setVisible(false);
                }
            }
        }
//BOTON ELIMINAR        
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos de la Receta?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));

            if (res == JOptionPane.YES_OPTION) {
                eliminarReceta();
            }
        }
//Boton regresar        
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
            LimpiarDiseno();
        }
//BOTON BUSCAR RECETA
        if (e.getSource() == vista.Bot_buscar) {
            if (vista.txtConsultarReceta.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Caja de Texto vacia", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                vista.ErrorFaltaTexto.setVisible(true);
            } else {
                TraerDatosReceta();
                vista.Bot_registrar.setEnabled(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
            }
        }
//BOTON BUSCAR MEDICO
        if (e.getSource() == vista.Bot_ConsultarMed) {
            // TraerDatosMedico();
            mostrarMedico("");
            vistaRepMed.setLocationRelativeTo(null);
            vistaRepMed.setVisible(true);
        }
        if (e.getSource() == vistaRepMed.Bot_Regresar_Repo) {
            vistaRepMed.dispose();

        }
//BUSCAR PACIENTE (MASCOTA)
        if (e.getSource() == vista.Bot_ConsultarMasc) {
            //TraerDatosMascota();
            mostrarPaciente("");
            vistaRepMasc.setLocationRelativeTo(null);
            vistaRepMasc.setVisible(true);
        }
        if (e.getSource() == vistaRepMasc.Bot_Regresar_Repo) {
            vistaRepMasc.dispose();
        }
//BOTON IMPRIMIR RECETA        
        if (e.getSource() == vista.Bot_Imprimir) {
            ImprimirReceta();
            Limpiar();
            //vistaDR.setVisible(true);
        }
//BOTON VISUALIZAR REPORTE
        if (e.getSource() == vista.Bot_Reporte) {
            mostrarReceta("");
            vista.dispose();
            vistaRepReceta.setLocationRelativeTo(null);
            vistaRepReceta.setVisible(true);
            vista.txtConsultarReceta.setText("");
            vistaRepReceta.txtConsultar.setText("");
        }
// BOTON LIMPIAR        
        if (e.getSource() == vista.Bot_limpiar) {
            Limpiar();
            vista.Bot_Imprimir.setEnabled(false);
        }
//---VISTA REPORTE--
//BOTON REGRESAR
        if (e.getSource() == vistaRepReceta.Bot_Regresar_Repo) {
            vistaRepReceta.dispose();
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
            vistaRepReceta.txtConsultar.setText("");
            vista.txtConsultarReceta.setText("");
        }
//BOTON BUSCAR EN REPORTE
        if (e.getSource() == vistaRepReceta.Bot_RepBuscar) {
            BusquedaTablas();
        }
//KEYLISTENER        
        this.vistaRepReceta.txtConsultar.addKeyListener(this);
    }
    //---------------------------------------------------------------------

    // validar tamaño
    private void validarTamaño(JTextArea txt, int tam) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
        });
    }

    // EVENTOS  KEY
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        BusquedaTablas();
        autocompletarCedula(e);
    }
//MOSTRAR MEDICO

    private void TraerDatosClick1(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosMedico(e);
            }
        });
    }

    private void mostrarMedico(String cedula) {
        modeloMed.listarMedico(vistaRepMed.Tablas_Med, cedula);
    }

    void TraerDatosMedico(MouseEvent e) {

        int fila = vistaRepMed.Tablas_Med.getSelectedRow();

        if (e.getClickCount() == 2) {
            if (fila >= 0) {

                vista.Id_medico.setText(String.valueOf(vistaRepMed.Tablas_Med.getValueAt(fila, 0)));
                vista.CedMedico.setText(String.valueOf(vistaRepMed.Tablas_Med.getValueAt(fila, 1)));
                vista.nom_medico.setText(String.valueOf(vistaRepMed.Tablas_Med.getValueAt(fila, 2)));
                vista.EspecialidadMedic.setText(String.valueOf(vistaRepMed.Tablas_Med.getValueAt(fila, 9)));
                vistaRepMed.dispose();

            } else {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/error.png", 40, 40));

            }
        }
    }

//MOSTRAR MASCOTA
    private void TraerDatosClick2(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosPaciente(e);
            }
        });
    }

    private void mostrarPaciente(String idMascota) {
        modeloMas.listarPacientes(vistaRepMasc.Tablas_Pacientes_2, idMascota);
    }

    void TraerDatosPaciente(MouseEvent e) {

        int fila = vistaRepMasc.Tablas_Pacientes_2.getSelectedRow();

        if (e.getClickCount() == 2) {
            if (fila >= 0) {

                vistaRepMasc.Tablas_Pacientes_2.changeSelection(fila, 0, false, false);
                vista.id_mascota.setText(String.valueOf(vistaRepMasc.Tablas_Pacientes_2.getValueAt(fila, 0)));
                vista.nom_mascota.setText(String.valueOf(vistaRepMasc.Tablas_Pacientes_2.getValueAt(fila, 2)));
                vistaRepMasc.dispose();

            } else {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se encontró el registro", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/error.png", 40, 40));

            }
        }
    }

    //MOSTRAR RECETA --PRINCIPAL
    private void mostrarReceta(String idReceta) {
        modeloRec.listarRecetas(vistaRepReceta.Tablas_Rec, idReceta);
    }

    void TraerDatosReceta() {
        mostrarReceta(vista.txtConsultarReceta.getText());

        int fila = 0;

        for (int i = 0; fila < vistaRepReceta.Tablas_Rec.getRowCount(); fila++) {

            vistaRepReceta.Tablas_Rec.changeSelection(i, 0, false, false);

            vista.Id_Recetas.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 0)));
            vista.id_mascota.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 1)));
            vista.nom_mascota.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 2).toString());
            vista.Id_medico.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 3)));
            vista.CedMedico.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 4)));
            vista.nom_medico.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 5).toString());
            vista.EspecialidadMedic.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 6)));
            String fecha = vistaRepReceta.Tablas_Rec.getValueAt(fila, 7).toString();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaN = vista.fechaEmision.getDate();
            try {
                fechaN = formatoDelTexto.parse(fecha);
                vista.fechaEmision.setDate(fechaN);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            vista.Diagnostico_receta.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 8).toString());
            vista.indicaciones_receta.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 9).toString());
            vista.ErrorFaltaTexto.setVisible(false);
        }
    }

//BUSCAR EN LA TABLA
    void BusquedaTablas() {

        if (vistaRepReceta.txtConsultar.getText().isEmpty()) {
            mostrarReceta("");
            Limpiar();
        } else {
            mostrarReceta(vistaRepReceta.txtConsultar.getText());
        }
    }

//ID INCREMENTABLES
    private void idReceta() {
        vista.Id_Recetas.setText(modeloRec.getRecID() + "");
    }

    ArrayList<Receta> listaReceta = new ArrayList<Receta>();
//CREAR RECETA

    public void crearReceta() {
        java.util.Date dat = new java.util.Date();//Instancia la fecha del sistema
        if (vista.fechaEmision.getDate().getTime() > dat.getTime()) {//Compara si la fecha seleccionada es menor o igual a la fecha actual
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            vista.ErrorF_Emision.setVisible(true);
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, Fecha Infrige a la fecha Actual", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            String Id_Rec = vista.Id_Recetas.getText();
            int IdMascota = Integer.parseInt(vista.id_mascota.getText());
            String nomMascota = vista.nom_mascota.getText();
            int idMedico = Integer.parseInt(vista.Id_medico.getText());
            String nomMedico = vista.nom_medico.getText();
            LocalDate fechaEmision = fechaEmision();
            String diagnostico = vista.Diagnostico_receta.getText();
            String indicaciones = vista.indicaciones_receta.getText();
            Receta newReceta = new Receta();
            newReceta.setReceta_id(Id_Rec);
            newReceta.setMascota_id(IdMascota);
            newReceta.setMedico_id(idMedico);
            newReceta.setReceta_fechaEmision(fechaEmision);
            newReceta.setReceta_diagnostico(diagnostico);
            newReceta.setReceta_indicaciones(indicaciones);
            listaReceta.add(newReceta);
            String mensaje = modeloRec.agregarReceta(newReceta);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            vista.Bot_Imprimir.setEnabled(true);
        }

    }
//MODIFICAR RECETA

    public void modificarReceta() {
                java.util.Date dat = new java.util.Date();//Instancia la fecha del sistema
           if (vista.fechaEmision.getDate().getTime() > dat.getTime()) {//Compara si la fecha seleccionada es menor o igual a la fecha actual
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            vista.ErrorF_Emision.setVisible(true);
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, Fecha Infrige a la fecha Actual", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
        String idReceta = vista.Id_Recetas.getText();
        int idMascota = Integer.parseInt(vista.id_mascota.getText());
        int idMed = Integer.parseInt(vista.Id_medico.getText());
        LocalDate fechaEmision = fechaEmision();
        String diagnostico = vista.Diagnostico_receta.getText();
        String indicaciones = vista.indicaciones_receta.getText();
        Receta newReceta = new Receta();
        newReceta.setReceta_id(idReceta);
        newReceta.setMascota_id(idMascota);
        newReceta.setMedico_id(idMed);
        newReceta.setReceta_fechaEmision(fechaEmision);
        newReceta.setReceta_diagnostico(diagnostico);
        newReceta.setReceta_indicaciones(indicaciones);
        listaReceta.add(newReceta);
        String mensaje = modeloRec.modificarReceta(newReceta, String.valueOf(idReceta));
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        vista.Bot_Imprimir.setEnabled(true);
    }
    }
//ELIMINAR RECETA

    public void eliminarReceta() {
        String idReceta = vista.Id_Recetas.getText();
        String mensaje = modeloRec.eliminarReceta(String.valueOf(idReceta));
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        LimpiarDiseno();
        Limpiar();
    }
//LIMPIAR CAMPOS

    public void Limpiar() {
        vista.txtConsultarReceta.setText("");
        vista.Id_Recetas.setText("");
        vista.indicaciones_receta.setText("");
        vista.fechaEmision.setCalendar(null);
        vista.id_mascota.setText("");
        vista.nom_mascota.setText("");
        vista.Id_medico.setText("");
        vista.nom_medico.setText("");
        vista.Diagnostico_receta.setText("");
        vista.EspecialidadMedic.setText("");
        vista.CedMedico.setText("");
        idReceta();
        vista.Bot_registrar.setEnabled(true);
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_Imprimir.setEnabled(false);
        //advertencias
        vista.ErrorIdMascota.setVisible(false);
        vista.ErrorCedMed.setVisible(false);
        vista.ErrorF_Emision.setVisible(false);
        vista.ErrorDiagnostico.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);
    }
//FECHA

    public LocalDate fechaEmision() {
        LocalDate fecha_nacimiento = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechemi = formato.format(vista.fechaEmision.getDate());
        String fech[] = fechemi.split("/");
        LocalDate fechas = LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_nacimiento = fechas;
        return fecha_nacimiento;
    }

// EVENTOS MOUSE
    @Override
    public void mouseClicked(MouseEvent e) {

        int fila = vistaRepReceta.Tablas_Rec.getSelectedRow();
        if (e.getClickCount() == 2) {
            if (fila >= 0) {
                vista.Id_Recetas.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 0)));
                vista.id_mascota.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 1).toString());
                vista.nom_mascota.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 2).toString());
                vista.Id_medico.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 3)));
                vista.CedMedico.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 4)));
                vista.nom_medico.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 5).toString());
                vista.EspecialidadMedic.setText(String.valueOf(vistaRepReceta.Tablas_Rec.getValueAt(fila, 6)));
                String fecha = vistaRepReceta.Tablas_Rec.getValueAt(fila, 7).toString();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaN = vista.fechaEmision.getDate();
                try {
                    fechaN = formatoDelTexto.parse(fecha);
                    vista.fechaEmision.setDate(fechaN);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                vista.Diagnostico_receta.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 8).toString());
                vista.indicaciones_receta.setText(vistaRepReceta.Tablas_Rec.getValueAt(fila, 9).toString());
                vistaRepReceta.dispose();
                vista.setVisible(true);
                vista.Bot_registrar.setEnabled(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
                vista.Bot_Imprimir.setEnabled(true);
            }
        } else {
            Limpiar();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        vista.Bot_registrar.setForeground(new Color(103, 206, 233));
        vista.Bot_actualizar.setForeground(new Color(103, 206, 233));
        vista.Bot_eliminar.setForeground(new Color(103, 206, 233));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        vista.Bot_registrar.setForeground(new Color(97, 161, 187));
        vista.Bot_actualizar.setForeground(new Color(97, 161, 187));
        vista.Bot_eliminar.setForeground(new Color(97, 161, 187));
    }
    //------------------------------------------------------------------

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList name = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletar() {
        modeloRec.TraerDatosAuto(name, datos);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletar(String txt) {
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

            vistaRepReceta.txtConsultar.setText(complete);
            vistaRepReceta.txtConsultar.setCaretPosition(last);
            vistaRepReceta.txtConsultar.moveCaretPosition(start);

        }
    }
    // AUTOCOMPLETAR KEY RELEASED

    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarReceta(vistaRepReceta.txtConsultar.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaRepReceta.txtConsultar.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }

    public void LimpiarDiseno() {
        vistaDR.txtNomMedic.setText("");
        vistaDR.txtEspecialidadMed.setText("");
        vistaDR.txtNomPaciente.setText("");
        vistaDR.txtDiagnostico.setText("");
        vistaDR.txtIndicaciones.setText("");
        vistaDR.txtFechaE.setText("");

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex == 0) {
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            this.vistaDR.setVisible(true);
            vistaDR.printAll(graphics);
            return PAGE_EXISTS;

        } else {
            return NO_SUCH_PAGE;
        }

    }

    //IMPRIMIR RECETA
    private void ImprimirReceta() {
        vistaDR.txtNomMedic.setText(vista.nom_medico.getText());
        vistaDR.txtNomPaciente.setText(vista.nom_mascota.getText());
        vistaDR.txtEspecialidadMed.setText(vista.EspecialidadMedic.getText());
        String fecha = (formato.format(vista.fechaEmision.getDate()));
        vistaDR.txtFechaE.setText(fecha);
        vistaDR.txtDiagnostico.setText(vista.Diagnostico_receta.getText());
        vistaDR.txtIndicaciones.setText(vista.indicaciones_receta.getText());

        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setPrintable((Printable) ControladorReceta.this);
        try {
            printerJob.print();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Receta creado correctamente.", "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            vistaDR.dispose();
        } catch (PrinterException es) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Error al generar PDF, contacte al administrador", "Error", JOptionPane.PLAIN_MESSAGE, icono("/iconos/error.png", 40, 40));
        }
        LimpiarDiseno();
    }
}
