package Controlador;

import javax.swing.JOptionPane;
import Modelo.*;
import Validaciones.ValidacionCedula;
import Validaciones.ValidacionCorreo;
import Validaciones.ValidacionFechasNacimiento;
import Vista.RegistrarConsultorios;
import Vista.RegistrarServicios;
import Vista.RegistroMedico;
import Vista.ReporteMedico;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ControladorMedico implements ActionListener, KeyListener, MouseListener, ItemListener {

    UIManager UI;
    Medico modelo = new Medico();
    RegistroMedico vista = new RegistroMedico();
    ReporteMedico vistaR = new ReporteMedico();
    RegistrarServicios vistaSS = new RegistrarServicios();
    RegistrarConsultorios vistaCC = new RegistrarConsultorios();

    private MedicoBO modeloBO = new MedicoBO();
    private ServicioBO modeloSBO = new ServicioBO();
    private Servicio ser = new Servicio();
    private ConsultorioBO modeloCBO = new ConsultorioBO();
    private ControladorServicios cntrl = new ControladorServicios(ser, vistaSS);

    DefaultTableModel modeloTS = new DefaultTableModel();
    // VALIDACIONES
    ValidacionCedula validarCedula = new ValidacionCedula();
    ValidacionFechasNacimiento validarFecha = new ValidacionFechasNacimiento();
    ValidacionCorreo validarCorreo = new ValidacionCorreo();
//CONTROLADOR

    public ControladorMedico(Medico modelo, RegistroMedico vista, ReporteMedico vistaR) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.Bot_registrar.addActionListener(this);
        this.vista.Bot_actualizar.addActionListener(this);
        this.vista.Bot_eliminar.addActionListener(this);
        this.vista.Bot_Regresar.addActionListener(this);
        this.vista.Bot_buscar.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.Bot_Reporte.addActionListener(this);
        this.vista.CargarFoto.addActionListener(this);
        this.vistaR.Bot_Regresar_Repo.addActionListener(this);
        this.vistaR.Bot_RepBuscar.addActionListener(this);
        this.vista.C_nomservicio.addItemListener(this);
        this.vista.C_nomConsultorio.addItemListener(this);
        this.vista.ErrorNumTel.setVisible(false);

        // EVENTOS BUSCAR EN FRAME TODOS
        this.vistaR.txtBuscarCedMed.addKeyListener(this);
        this.vistaR.Tablas_Med.addMouseListener(this);

        // EVENTOS DE MOUSE
        this.vista.Bot_registrar.addMouseListener(this);
        this.vista.Bot_actualizar.addMouseListener(this);
        this.vista.Bot_eliminar.addMouseListener(this);
        mostrarservicios();
        mostrarConsultorios();

        // TXT FIELS
        validarcedula(vista.MedicoCedula);
        validarsololetras(vista.MedicoNomPrim);
        validarTamaño(vista.MedicoNomPrim, 50);
        validarsololetras(vista.MedicoNomSeg);
        validarTamaño(vista.MedicoNomSeg, 50);
        validarsololetras(vista.MedicoApellPri);
        validarTamaño(vista.MedicoApellPri, 50);
        validarsololetras(vista.MedicoApellSeg);
        validarTamaño(vista.MedicoApellSeg, 50);

        validarsolonumeros(vista.MedicoTelf);
        validarTamaño(vista.MedicoTelf, 13);
        validarsolonumeros(vista.MedicoCelular);
        validarTamaño(vista.MedicoTelf, 18);
        validarsololetras(vista.MedicoProfesion);
        validarTamaño(vista.MedicoProfesion, 20);
    }
//INICIAR

    public void iniciar() {
        vista.setTitle("Medico");
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        idPersona();
        idMed();
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_actualizar.setEnabled(false);
        vista.ErrorCed.setVisible(false);
        vista.ErrorNombres1.setVisible(false);
        vista.ErrorApellidos.setVisible(false);
        vista.ErrorDireccion.setVisible(false);
        vista.ErrorEmail.setVisible(false);
        vista.ErrorGenero.setVisible(false);
        vista.ErrorNumCel.setVisible(false);
        vista.ErrorFNac.setVisible(false);
        vista.ErroIdConsul.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);

        vista.Medico_IdServ.setEditable(false);
        vista.ErrorEspe.setVisible(false);
        vista.Medico_IdConsul.setEditable(false);
        vista.Id_Persona.setVisible(false);
        vista.IdMedico.setVisible(false);
        vista.Medico_IdConsul.setVisible(false);
        vista.Medico_IdServ.setVisible(false);
        AutoCompleteDecorator.decorate(vista.C_nomConsultorio);
        AutoCompleteDecorator.decorate(vista.C_nomservicio);
    }
//ICONO JOPTIONPANE

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
//EVENTOS ACTIONPERFORMED

    @Override
    public void actionPerformed(ActionEvent e) {
//BOTON REGISTAR
        if (e.getSource() == vista.Bot_registrar) {
            crearMedico();

        }
//BOTON ACTUALIZAR
        if (e.getSource() == vista.Bot_actualizar) {
            vista.MedicoCedula.setEditable(false);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos del Médico?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {

                if (vista.MedicoNomPrim.getText().isEmpty() || vista.MedicoNomSeg.getText().isEmpty() || vista.MedicoProfesion.getText().isEmpty()
                        || vista.MedicoApellPri.getText().isEmpty() || vista.MedicoDirec.getText().isEmpty()
                        || vista.MedicoCorreo.getText().isEmpty() || vista.MedicoTelf.getText().isEmpty() || vista.MedicoCelular.getText().isEmpty()
                        || vista.Medico_IdServ.getText().equals(0) || vista.Medico_IdConsul.getText().equals(0)
                        || vista.MedicoFechaNac.getDate() == null|| vista.foto.getText().isEmpty()) {
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE,
                            icono("/iconos/alerta.png", 40, 40));
                    vista.ErrorNombres1.setVisible(true);
                    vista.ErrorApellidos.setVisible(true);
                    vista.ErrorDireccion.setVisible(true);
                    vista.ErrorEmail.setVisible(true);
                    vista.ErrorGenero.setVisible(true);
                    vista.ErrorNumCel.setVisible(true);
                    vista.ErrorFNac.setVisible(true);
                    vista.ErrorIDServ.setVisible(true);
                    vista.ErroIdConsul.setVisible(true);
                } else {
                    modificarMedico();
                    vista.MedicoCedula.setEditable(true);
                }
            }
        }
        //BOTON ELIMINAR
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos del Médico?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                eliminarMedico();
            }
        }
//BOTON LIMPIAR CAMPOS        
        if (e.getSource() == vista.Bot_Limpiar) {
            Limpiar();
        }
//BOTON REGRESAR        
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
        }
//BOTON VISUALIZAR REPORTE        
        if (e.getSource() == vista.Bot_Reporte) {
            mostrar("");
            vista.dispose();
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
            vista.Txt_buscar_med.setText("");
            vistaR.txtBuscarCedMed.setText("");
        }
//BOTON BUSCAR        
        if (e.getSource() == vista.Bot_buscar) {
            if (vista.Txt_buscar_med.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Caja de Texto vacia", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                vista.ErrorFaltaTexto.setVisible(true);
            } else {
                TraerDatos();
                vista.Bot_registrar.setEnabled(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
            }
        }
//BOTON CARGAR FOTO        
        if (e.getSource() == vista.CargarFoto) {
            String nuevaFot = SubirPefil();
            vista.foto.setText(nuevaFot);
        }

//--REPORTE-        
//BOTON REGRESAR
        if (e.getSource() == vistaR.Bot_Regresar_Repo) {
            vistaR.dispose();
            vistaR.txtBuscarCedMed.setText("");
            vista.Txt_buscar_med.setText("");
            Limpiar();
            vista.setVisible(true);

        }
//BOTON BUSCAR EN REPORTE        
        if (e.getSource() == vistaR.Bot_RepBuscar) {
            BusquedaTablas();
        }
//KEY        
        this.vistaR.txtBuscarCedMed.addKeyListener(this);
        this.vista.Txt_buscar_med.addKeyListener(this);
    }

    //------------------------------------------------------------------
    // Solo letras
    private void txletras(java.awt.event.KeyEvent evt) {
        char vali = evt.getKeyChar();
        if (Character.isDigit(vali)) {
            vista.getToolkit().beep();
            evt.consume();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, " Ingrese solo letras  ");
        }
    }

    private void validarsololetras(JTextField txt) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                txletras(e);
            }
        });
    }

    //---------------------------------------------------------------------
    // solo numeros
    private void validarnum(java.awt.event.KeyEvent evt) {
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali)) {
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

    //---------------------------------------------------------------------
    // validar tamaño
    public static void Validarcedtamaño(String ced, int tam, KeyEvent ev) {
        if (ced.trim().length() >= tam) {
            ev.consume();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
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

    //---------------------------------------------------------------------
    // validar cedula
    private void txtvalidar(java.awt.event.KeyEvent evt, int tam) {
        Validarcedtamaño(vista.MedicoCedula.getText(), tam, evt);
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali)) {
            vista.getToolkit().beep();
            evt.consume();
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Digite solo numeros");
        }
    }

    private void validarcedula(JTextField txt) {
        txt.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                txtvalidar(e, 10);
            }
        });
    }

    // EVENTOS KEY
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

    //TRAER DATOS MEDICO
    private void mostrar(String cedula) {
        modeloBO.listarMedico(vistaR.Tablas_Med, cedula);
    }

    void TraerDatos() {
        mostrar(vista.Txt_buscar_med.getText());
        int fila = 0;
        for (int i = 0; fila < vistaR.Tablas_Med.getRowCount(); fila++) {
            vistaR.Tablas_Med.changeSelection(i, 0, false, false);
            vista.IdMedico.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 0)));
            vista.MedicoCedula.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 1)));
            vista.MedicoCedula.setEnabled(false);
            String nombresApellidos = vistaR.Tablas_Med.getValueAt(fila, 2).toString();
            StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
            while (st.hasMoreTokens()) {
                vista.MedicoNomPrim.setText(st.nextToken());
                vista.MedicoNomSeg.setText(st.nextToken());
                vista.MedicoApellPri.setText(st.nextToken());
                vista.MedicoApellSeg.setText(st.nextToken());
            }
            String Genero = String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 3).toString());
            if ("Masculino".equals(Genero)) {
                vista.Masculino.setSelected(true);
            } else if ("Femenino".equals(Genero)) {
                vista.Femenino.setSelected(true);
            }
            vista.MedicoCorreo.setText(vistaR.Tablas_Med.getValueAt(fila, 4).toString());
            vista.MedicoTelf.setText(vistaR.Tablas_Med.getValueAt(fila, 5).toString());
            vista.MedicoCelular.setText(vistaR.Tablas_Med.getValueAt(fila, 6).toString());
            vista.MedicoDirec.setText(vistaR.Tablas_Med.getValueAt(fila, 7).toString());
            String fecha = vistaR.Tablas_Med.getValueAt(fila, 8).toString();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaN = vista.MedicoFechaNac.getDate();
            try {
                fechaN = formatoDelTexto.parse(fecha);
                vista.MedicoFechaNac.setDate(fechaN);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            vista.MedicoProfesion.setText(vistaR.Tablas_Med.getValueAt(fila, 9).toString());
            vista.Medico_IdServ.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 10)));
            vista.C_nomservicio.setSelectedItem(vistaR.Tablas_Med.getValueAt(fila, 11).toString());
            vista.Medico_IdConsul.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 12)));
            vista.C_nomConsultorio.setSelectedItem(vistaR.Tablas_Med.getValueAt(fila, 13).toString());
            Imagen = String.valueOf(vistaR.Tablas_Med.getValueAt(i, 14));
            vista.foto.setText(Imagen);
            String fotoBuscar = vista.foto.getText();
            Orig = "src/ImagenesPersonal/" + fotoBuscar;
            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
            vista.foto.setText(null);
            vista.foto.setIcon(icono);
            vista.ErrorFaltaTexto.setVisible(false);
            vista.MedicoCedula.setEditable(false);

        }
    }

//BUSCAR EN TABLA
    void BusquedaTablas() {
        if (vistaR.txtBuscarCedMed.getText().isEmpty()) {
            mostrar("");
            Limpiar();
        } else {
            mostrar(vistaR.txtBuscarCedMed.getText());
        }
    }
// IDES INCREMENTABLES

    private void idPersona() {
        vista.Id_Persona.setText(modeloBO.getPersonaID() + "");
    }

    private void idMed() {
        vista.IdMedico.setText(modeloBO.getMedID() + "");
    }

    // EVENTOS MOUSE
    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vistaR.Tablas_Med.getSelectedRow();
        if (e.getClickCount() == 2) {
            if (fila >= 0) {
                vista.IdMedico.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 0)));
                vista.MedicoCedula.setText(String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 1)));
                String nombresApellidos = vistaR.Tablas_Med.getValueAt(fila, 2).toString();
                StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
                while (st.hasMoreTokens()) {
                    vista.MedicoNomPrim.setText(st.nextToken());
                    vista.MedicoNomSeg.setText(st.nextToken());
                    vista.MedicoApellPri.setText(st.nextToken());
                    vista.MedicoApellSeg.setText(st.nextToken());
                }
                String Genero = String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 3).toString());
                if ("Masculino".equals(Genero)) {
                    vista.Masculino.setSelected(true);
                } else if ("Femenino".equals(Genero)) {
                    vista.Femenino.setSelected(true);
                }
                vista.MedicoCorreo.setText(vistaR.Tablas_Med.getValueAt(fila, 4).toString());
                vista.MedicoTelf.setText(vistaR.Tablas_Med.getValueAt(fila, 5).toString());
                vista.MedicoCelular.setText(vistaR.Tablas_Med.getValueAt(fila, 6).toString());
                vista.MedicoDirec.setText(vistaR.Tablas_Med.getValueAt(fila, 7).toString());
                String fecha = vistaR.Tablas_Med.getValueAt(fila, 8).toString();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaN = vista.MedicoFechaNac.getDate();
                try {
                    fechaN = formatoDelTexto.parse(fecha);
                    vista.MedicoFechaNac.setDate(fechaN);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                vista.MedicoProfesion.setText(vistaR.Tablas_Med.getValueAt(fila, 9).toString());
                vista.Medico_IdServ.setText(vistaR.Tablas_Med.getValueAt(fila, 10).toString());
                vista.C_nomservicio.setSelectedItem(vistaR.Tablas_Med.getValueAt(fila, 11).toString());
                vista.Medico_IdConsul.setText(vistaR.Tablas_Med.getValueAt(fila, 12).toString());
                vista.C_nomConsultorio.setSelectedItem(vistaR.Tablas_Med.getValueAt(fila, 13).toString());
                Imagen = String.valueOf(vistaR.Tablas_Med.getValueAt(fila, 14));
                vista.foto.setText(Imagen);
                String fotoBuscar = vista.foto.getText();
                Orig = "src/ImagenesPersonal/" + fotoBuscar;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
                vista.foto.setText(null);
                vista.foto.setIcon(icono);
                vistaR.dispose();
                vista.setVisible(true);
                vista.Bot_registrar.setEnabled(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
                vista.MedicoCedula.setEditable(false);
            } else {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        } else {
            Limpiar();
            vista.Bot_registrar.setEnabled(true);
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

    ArrayList<Medico> listaMedico = new ArrayList<Medico>();

    protected static String Imagen;
    protected static String Dest, Orig;
    //validar cedula existente

    public boolean validarExistencia() {

        boolean chek = false;
        String ficha = vista.MedicoCedula.getText();
        for (int i = 0; i < vistaR.Tablas_Med.getRowCount(); i++) {
            if (vistaR.Tablas_Med.getValueAt(i, 1).equals(ficha)) {
                chek = true;
            }
        }
        return chek;
    }
//CREAR MEDICO

    public void crearMedico() {
        if (validarExistencia() == true) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Cedula Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            if (vista.MedicoCedula.getText().isEmpty() || vista.MedicoNomPrim.getText().isEmpty() || vista.MedicoNomSeg.getText().isEmpty() || vista.MedicoProfesion.getText().isEmpty()
                    || vista.MedicoApellPri.getText().isEmpty() || vista.MedicoDirec.getText().isEmpty()
                    || vista.MedicoCorreo.getText().isEmpty() || vista.MedicoTelf.getText().isEmpty() || vista.MedicoCelular.getText().isEmpty()
                    || vista.Medico_IdServ.getText().equals(0) || vista.Medico_IdConsul.getText().equals(0)
                    || vista.MedicoFechaNac.getDate() == null || vista.foto.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {

                if (validarFecha.FechaNacimiento(vista.MedicoFechaNac) == false) {
                    vista.ErrorFNac.setVisible(true);
                } else {

                    if (validarCorreo.VerificarEmail(vista.MedicoCorreo.getText()) == false) {
                        vista.ErrorEmail.setVisible(true);
                    } else {

                        int Id_persona = Integer.parseInt(vista.Id_Persona.getText());
                        int IdMedico = Integer.parseInt(vista.IdMedico.getText());
                        String cedula = vista.MedicoCedula.getText();
                        String PriNombre = vista.MedicoNomPrim.getText();
                        String SegNombre = vista.MedicoNomSeg.getText();
                        String PaApellido = vista.MedicoApellPri.getText();
                        String MaAepllido = vista.MedicoApellSeg.getText();
                        LocalDate FechaNacimiento = fecha_nacimiento();
                        String correo = vista.MedicoCorreo.getText();
                        String direccion = vista.MedicoDirec.getText();
                        String genero = eleccionGenero();
                        String telefono = vista.MedicoTelf.getText();
                        String movil = vista.MedicoCelular.getText();
                        String especialidad = vista.MedicoProfesion.getText();
                        int id_servicio = Integer.parseInt(vista.Medico_IdServ.getText());
                        int id_consultorio = Integer.parseInt(vista.Medico_IdConsul.getText());
                        String imagen = Imagen;

                        Medico newMedico = new Medico();

                        newMedico.setPersona_id(Id_persona);
                        newMedico.setCedula(cedula);
                        newMedico.setPri_nombre(PriNombre);
                        newMedico.setSeg_nombre(SegNombre);
                        newMedico.setPat_apellido(PaApellido);
                        newMedico.setMat_apellido(MaAepllido);
                        newMedico.setFecha_nacimiento(FechaNacimiento);
                        newMedico.setCorreo(correo);
                        newMedico.setDireccion(direccion);
                        newMedico.setGenero(genero);
                        newMedico.setTelefono(telefono);
                        newMedico.setMovil(movil);

                        newMedico.setIdMedico(IdMedico);
                        newMedico.setEspecialidad(especialidad);
                        newMedico.setServicio_id(id_servicio);
                        newMedico.setConsultorio_id(id_consultorio);
                        newMedico.setImagen(imagen);
                        listaMedico.add(newMedico);
                        String mensaje = modeloBO.agregarMedico(newMedico, cedula);
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);
                        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                        Limpiar();
                    }
                }
            }
        }
    }
    //ACTUALIZAR MEDICO

    public void modificarMedico() {

        int IdMedico = Integer.parseInt(vista.IdMedico.getText());
        String cedula = vista.MedicoCedula.getText();
        String PriNombre = vista.MedicoNomPrim.getText();
        String SegNombre = vista.MedicoNomSeg.getText();
        String PaApellido = vista.MedicoApellPri.getText();
        String MaAepllido = vista.MedicoApellSeg.getText();
        LocalDate FechaNacimiento = fecha_nacimiento();
        String correo = vista.MedicoCorreo.getText();
        String direccion = vista.MedicoDirec.getText();
        String genero = eleccionGenero();
        String telefono = vista.MedicoTelf.getText();
        String movil = vista.MedicoCelular.getText();
        String especialidad = vista.MedicoProfesion.getText();
        int idServicio = Integer.parseInt(vista.Medico_IdServ.getText());
        int idConsultorio = Integer.parseInt(vista.Medico_IdConsul.getText());
        String imagen = Imagen;

        Medico newMedico = new Medico();

        newMedico.setPri_nombre(PriNombre);
        newMedico.setSeg_nombre(SegNombre);
        newMedico.setPat_apellido(PaApellido);
        newMedico.setMat_apellido(MaAepllido);
        newMedico.setFecha_nacimiento(FechaNacimiento);
        newMedico.setCorreo(correo);
        newMedico.setDireccion(direccion);
        newMedico.setGenero(genero);
        newMedico.setTelefono(telefono);
        newMedico.setMovil(movil);
        newMedico.setEspecialidad(especialidad);
        newMedico.setServicio_id(idServicio);
        newMedico.setConsultorio_id(idConsultorio);
        newMedico.setImagen(imagen);

        listaMedico.add(newMedico);
        String mensaje = modeloBO.modificarMedico(newMedico, cedula, IdMedico);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }
//ELIMINAR MEDICO
    private UsuariosBO ubo = new UsuariosBO();

    public void eliminarMedico() {
        String cedula = vista.MedicoCedula.getText();
        String mensaje = modeloBO.eliminarMedico(cedula);
        // eliminar user
        String mensaje2 = ubo.eliminarUsuario(cedula);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }
//LIMPIAR CAMPOS

    public void Limpiar() {
        vista.Txt_buscar_med.setText("");
        vista.MedicoCedula.setText("");
        vista.MedicoNomPrim.setText("");
        vista.MedicoNomSeg.setText("");
        vista.MedicoApellPri.setText("");
        vista.MedicoApellSeg.setText("");
        vista.MedicoCorreo.setText("");
        vista.MedicoDirec.setText("");
        vista.Genero.clearSelection();
        vista.MedicoFechaNac.setCalendar(null);
        vista.MedicoTelf.setText(null);
        vista.MedicoCelular.setText(null);
        vista.MedicoProfesion.setText("");
        vista.Medico_IdServ.setText("");
        vista.C_nomservicio.setSelectedItem("SELECCIONE");
        vista.Medico_IdConsul.setText("");
        vista.C_nomConsultorio.setSelectedItem("SELECCIONE");
        idPersona();
        idMed();
        vista.foto.setIcon(null);
        vista.foto.setText("");
        vista.Bot_registrar.setEnabled(true);
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        //advertencias
        vista.ErrorCed.setVisible(false);
        vista.ErrorNombres1.setVisible(false);
        vista.ErrorApellidos.setVisible(false);
        vista.ErrorDireccion.setVisible(false);
        vista.ErrorEmail.setVisible(false);
        vista.ErrorGenero.setVisible(false);
        vista.ErrorNumCel.setVisible(false);
        vista.ErrorFNac.setVisible(false);
        vista.ErroIdConsul.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);
        vista.MedicoCedula.setEditable(true);

    }
//GENERO

    public String eleccionGenero() {
        String genero = null;
        if (vista.Masculino.isSelected()) {
            genero = "Masculino";
        }
        if (vista.Femenino.isSelected()) {
            genero = "Femenino";
        }
        return genero;
    }
//FECHA

    public LocalDate fecha_nacimiento() {

        LocalDate fecha_nacimiento = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechemi = formato.format(vista.MedicoFechaNac.getDate());
        String fech[] = fechemi.split("/");
        LocalDate fechas = LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_nacimiento = fechas;

        return fecha_nacimiento;
    }
//CARGAR FOTO
    String nombreI;

    public String SubirPefil() {
        try {

            JFileChooser file = new JFileChooser("C:\\Users\\edu\\Downloads\\Imagenes Proyecto Vet");
            int valor = file.showOpenDialog(file);

            if (valor == file.CANCEL_OPTION) {
                //System.out.println("no seleciono");
            } else {
                //file = new JFileChooser("C:\\Users\\edu\\Downloads\\Imagenes Proyecto Vet");
                //file.showOpenDialog(null);
                File archivo = file.getSelectedFile();

                Dest = "src\\ImagenesPersonal\\" + archivo.getName();
                Orig = archivo.getPath();
                Imagen = archivo.getName();
                nombreI = Imagen;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
                vista.foto.setText(null);
                vista.foto.setIcon(icono);
                try {
                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);
                    vista.MedicoCedula.setEditable(true);
                } catch (IOException e) {
                    System.out.println("Error imagen uno: " + e);
                    vista.MedicoCedula.setEditable(true);
                }
            }

        } catch (NullPointerException a) {
            System.out.println("Error imagen dos: " + a);
            vista.MedicoCedula.setEditable(true);
        }
        return nombreI;
    }

//TRAER SERVICIOS    
    public void mostrarservicios() {
        modeloBO.mostrarserviciosBO(vista.C_nomservicio);
    }

    public void mostrarIdSevicio(String servicio) {
        int id = modeloBO.mostraridservicioBO(servicio);
        vista.Medico_IdServ.setText("" + id);

    }

    ///TRAER CONSULTORIOS       
    public void mostrarConsultorios() {
        modeloBO.mostrarConsultorioBO(vista.C_nomConsultorio);
    }

    public void mostrarIdConsultorio(String consultorio) {
        int idC = modeloBO.mostraridConsultorioBO(consultorio);
        vista.Medico_IdConsul.setText("" + idC);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String servicio = vista.C_nomservicio.getSelectedItem().toString();
            mostrarIdSevicio(servicio);
            String consultorio = vista.C_nomConsultorio.getSelectedItem().toString();
            mostrarIdConsultorio(consultorio);
        }
    }
    //------------------------------------------------------------------

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList name = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletar() {
        modeloBO.TraerDatosAuto(name, datos);
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

            vistaR.txtBuscarCedMed.setText(complete);
            vistaR.txtBuscarCedMed.setCaretPosition(last);
            vistaR.txtBuscarCedMed.moveCaretPosition(start);

        }
    }
    // AUTOCOMPLETAR KEY RELEASED

    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaR.txtBuscarCedMed.getText());
                //mostrar(vista.Txt_buscar_med.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaR.txtBuscarCedMed.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }
}
