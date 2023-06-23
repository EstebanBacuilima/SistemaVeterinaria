package Controlador;

import javax.swing.JOptionPane;
import Modelo.*;
import Validaciones.ValidacionCedula;
import Validaciones.ValidacionCorreo;
import Validaciones.ValidacionFechasNacimiento;
import Vista.RegistroAuxiliar;
import Vista.ReporteAuxiliar;
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
import javax.swing.UIManager;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ControladorAuxiliar implements ActionListener, KeyListener, MouseListener, ItemListener {

    UIManager UI;
    Auxiliar modelo = new Auxiliar();
    RegistroAuxiliar vista = new RegistroAuxiliar();
    ReporteAuxiliar vistaR = new ReporteAuxiliar();
    private AuxiliarBO modeloBO = new AuxiliarBO();

    // VALIDACIONES
    ValidacionCedula validarCedula = new ValidacionCedula();
    ValidacionFechasNacimiento validarFecha = new ValidacionFechasNacimiento();
    ValidacionCorreo validarCorreo = new ValidacionCorreo();

    public ControladorAuxiliar(Auxiliar modelo, RegistroAuxiliar vista, ReporteAuxiliar vistaR) {

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
        // EVENTOS BUSCAR EN FRAME TODOS
        this.vistaR.txtBuscarCedAux.addKeyListener(this);
        this.vistaR.Tablas_Aux.addMouseListener(this);

        // EVENTOS DE MOUSE
        this.vista.Bot_registrar.addMouseListener(this);
        this.vista.Bot_actualizar.addMouseListener(this);
        this.vista.Bot_eliminar.addMouseListener(this);
        mostrarservicios();

        // VALIDAR TXT FIELS
        validarcedula(vista.AuxiliarCedula);
        validarsololetras(vista.AuxiliarNomPrim);
        validarTamaño(vista.AuxiliarNomPrim, 50);
        validarsololetras(vista.AuxiliarNomSeg);
        validarTamaño(vista.AuxiliarNomSeg, 50);
        validarsololetras(vista.AuxiliarApellPri);
        validarTamaño(vista.AuxiliarApellPri, 50);
        validarsololetras(vista.AuxiliarApellSeg);
        validarTamaño(vista.AuxiliarApellSeg, 50);

        validarsolonumeros(vista.AuxiliarTelf);
        validarTamaño(vista.AuxiliarTelf, 13);
        validarsolonumeros(vista.AuxiliarCelular);
        validarTamaño(vista.AuxiliarTelf, 18);

    }

    //INICIAR
    public void iniciar() {
        vista.setLocationRelativeTo(null);
        idPersona();
        idAux();

        //Botones
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_actualizar.setEnabled(false);
        vista.Aux_IdServ.setEditable(false);
        vista.Id_Persona.setVisible(false);
        vista.AuxiliarId.setVisible(false);
        vista.Aux_IdServ.setVisible(false);
        //Advertencias
        vista.ErrorCed.setVisible(false);
        vista.ErrorNombres1.setVisible(false);
        vista.ErrorApellidos.setVisible(false);
        vista.ErrorDireccion.setVisible(false);
        vista.ErrorEmail.setVisible(false);
        vista.ErrorNumTel.setVisible(false);
        vista.ErrorNumCel.setVisible(false);
        vista.ErrorLabores.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorFNac.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);
        //Autocompletar ComboBox
        AutoCompleteDecorator.decorate(vista.C_nomservicio);

    }
//ICONO JOPTIONPANE    

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
//EVENTO ACTIONPERFORMED    

    @Override
    public void actionPerformed(ActionEvent e) {
//BOTON REGISTRAR
        if (e.getSource() == vista.Bot_registrar) {
            crearAuxiliar();
        }
//BOTON ACTUALIZAR
        
        if (e.getSource() == vista.Bot_actualizar) {
            vista.AuxiliarCedula.setEditable(false);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos del Auxiliar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                if (vista.AuxiliarNomPrim.getText().isEmpty() || vista.AuxiliarNomSeg.getText().isEmpty() || vista.AuxiliaLabores.getSelectedItem().equals("SELECCIONE")
                        || vista.AuxiliarApellPri.getText().isEmpty() || vista.AuxiliarDirec.getText().isEmpty()
                        || vista.AuxiliarCorreo.getText().isEmpty() || vista.AuxiliarTelf.getText().isEmpty() || vista.AuxiliarCelular.getText().isEmpty()
                        || vista.AuxiliarFechaNac.getDate() == null || vista.foto.getText().isEmpty()) {

                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "No se ha completado la operacion, existe algun campo vacio");
                } else {
                    modificarAuxiliar();
                    vista.AuxiliarCedula.setEditable(true);
                }
            }
        }
//BOTON ELIMINAR
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos del Auxiliar?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                eliminarAuxiliar();
            }
        }
//BOTON LIMPIAR        
        if (e.getSource() == vista.Bot_Limpiar) {
            Limpiar();
        }

//BOTON REGRESAR
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
        }
//BOTON BUSCAR        
        if (e.getSource() == vista.Bot_buscar) {
            if (vista.Txt_buscar_aux.getText().isEmpty()) {
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
//BOTON VISUALIZAR REPORTE
        if (e.getSource() == vista.Bot_Reporte) {
            mostrar("");
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
            vista.dispose();
            vista.Txt_buscar_aux.setText("");
            vistaR.txtBuscarCedAux.setText("");
        }
//REPORTE
//BOTON REGRESAR
        if (e.getSource() == vistaR.Bot_Regresar_Repo) {
            vistaR.dispose();
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
            vistaR.txtBuscarCedAux.setText("");
            vista.Txt_buscar_aux.setText("");
            Limpiar();
        }

//BOTON BUSCAR EN REPORTE        
        if (e.getSource() == vistaR.Bot_RepBuscar) {
            BusquedaTablas();
        }

//KEYLISTENER        
        this.vistaR.txtBuscarCedAux.addKeyListener(this);
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
        Validarcedtamaño(vista.AuxiliarCedula.getText(), tam, evt);
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
//TRAER DATOS AUXILIAR

    private void mostrar(String cedula) {
        modeloBO.listarAuxiliar(vistaR.Tablas_Aux, cedula);
    }

    void TraerDatos() {
        mostrar(vista.Txt_buscar_aux.getText());
        int fila = 0;
        for (int i = 0; fila < vistaR.Tablas_Aux.getRowCount(); fila++) {

            vistaR.Tablas_Aux.changeSelection(i, 0, false, false);
            vista.AuxiliarId.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 0)));
            vista.AuxiliarCedula.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 1)));
            String nombresApellidos = vistaR.Tablas_Aux.getValueAt(fila, 2).toString();
            StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
            while (st.hasMoreTokens()) {
                vista.AuxiliarNomPrim.setText(st.nextToken());
                vista.AuxiliarNomSeg.setText(st.nextToken());
                vista.AuxiliarApellPri.setText(st.nextToken());
                vista.AuxiliarApellSeg.setText(st.nextToken());
            }
            String Genero = String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 3).toString());
            if ("Masculino".equals(Genero)) {
                vista.Masculino.setSelected(true);
            } else if ("Femenino".equals(Genero)) {
                vista.Femenino.setSelected(true);
            }
            vista.AuxiliarCorreo.setText(vistaR.Tablas_Aux.getValueAt(fila, 4).toString());
            vista.AuxiliarTelf.setText(vistaR.Tablas_Aux.getValueAt(fila, 5).toString());
            vista.AuxiliarCelular.setText(vistaR.Tablas_Aux.getValueAt(fila, 6).toString());
            vista.AuxiliarDirec.setText(vistaR.Tablas_Aux.getValueAt(fila, 7).toString());

            String fecha = vistaR.Tablas_Aux.getValueAt(fila, 8).toString();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaN = vista.AuxiliarFechaNac.getDate();
            try {
                fechaN = formatoDelTexto.parse(fecha);
                vista.AuxiliarFechaNac.setDate(fechaN);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            vista.AuxiliaLabores.setSelectedItem(vistaR.Tablas_Aux.getValueAt(vistaR.Tablas_Aux.getSelectedRow(), 9).toString());
            vista.Aux_IdServ.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 10)));
            vista.C_nomservicio.setSelectedItem(vistaR.Tablas_Aux.getValueAt(fila, 11).toString());
            Imagen = String.valueOf(vistaR.Tablas_Aux.getValueAt(i, 12));
            vista.foto.setText(Imagen);
            String fotoBuscar = vista.foto.getText();
            Orig = "src/ImagenesPersonal/" + fotoBuscar;
            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
            vista.foto.setText(null);
            vista.foto.setIcon(icono);
            vista.ErrorFaltaTexto.setVisible(false);
            vista.AuxiliarCedula.setEditable(false);
        }

    }

//BUSCAR EN TABLA
    void BusquedaTablas() {
        if (vistaR.txtBuscarCedAux.getText().isEmpty()) {
            mostrar("");
            Limpiar();
        } else {
            mostrar(vistaR.txtBuscarCedAux.getText());
        }
    }

// IDES INCREMENTABLES
    private void idPersona() {
        vista.Id_Persona.setText(modeloBO.getPersonaID() + "");
    }

    private void idAux() {
        vista.AuxiliarId.setText(modeloBO.getAuxID() + "");
    }

// EVENTOS MOUSE
    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = vistaR.Tablas_Aux.getSelectedRow();
        if (e.getClickCount() == 2) {
            if (fila >= 0) {
                vista.AuxiliarId.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 0)));
                vista.AuxiliarCedula.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 1)));
                String nombresApellidos = vistaR.Tablas_Aux.getValueAt(fila, 2).toString();
                StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
                while (st.hasMoreTokens()) {
                    vista.AuxiliarNomPrim.setText(st.nextToken());
                    vista.AuxiliarNomSeg.setText(st.nextToken());
                    vista.AuxiliarApellPri.setText(st.nextToken());
                    vista.AuxiliarApellSeg.setText(st.nextToken());
                }
                String Genero = String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 3).toString());
                if ("Masculino".equals(Genero)) {
                    vista.Masculino.setSelected(true);
                } else if ("Femenino".equals(Genero)) {
                    vista.Femenino.setSelected(true);
                }
                vista.AuxiliarCorreo.setText(vistaR.Tablas_Aux.getValueAt(fila, 4).toString());
                vista.AuxiliarTelf.setText(vistaR.Tablas_Aux.getValueAt(fila, 5).toString());
                vista.AuxiliarCelular.setText(vistaR.Tablas_Aux.getValueAt(fila, 6).toString());
                vista.AuxiliarDirec.setText(vistaR.Tablas_Aux.getValueAt(fila, 7).toString());
                String fecha = vistaR.Tablas_Aux.getValueAt(fila, 8).toString();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaN = vista.AuxiliarFechaNac.getDate();
                try {
                    fechaN = formatoDelTexto.parse(fecha);
                    vista.AuxiliarFechaNac.setDate(fechaN);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                vista.AuxiliaLabores.setSelectedItem(vistaR.Tablas_Aux.getValueAt(vistaR.Tablas_Aux.getSelectedRow(), 9).toString());
                vista.Aux_IdServ.setText(String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 10)));
                vista.C_nomservicio.setSelectedItem(vistaR.Tablas_Aux.getValueAt(fila, 11).toString());
                Imagen = String.valueOf(vistaR.Tablas_Aux.getValueAt(fila, 12));
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
                vista.AuxiliarCedula.setEditable(false);
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

    ArrayList<Auxiliar> listaAuxiliar = new ArrayList<Auxiliar>();

    protected static String Imagen;
    protected static String Dest, Orig;
    //validar cedula existente

    public boolean validarExistencia() {

        boolean chek = false;
        String ficha = vista.AuxiliarCedula.getText();
        for (int i = 0; i < vistaR.Tablas_Aux.getRowCount(); i++) {
            if (vistaR.Tablas_Aux.getValueAt(i, 1).equals(ficha)) {
                chek = true;
            }
        }
        return chek;
    }
//CREAR AUXILIAR

    public void crearAuxiliar() {
        if (validarExistencia() == true) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Cedula Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            if (vista.AuxiliarNomPrim.getText().isEmpty() || vista.AuxiliarNomSeg.getText().isEmpty() || vista.AuxiliaLabores.getSelectedItem().equals("SELECCIONE")
                    || vista.AuxiliarApellPri.getText().isEmpty() || vista.AuxiliarDirec.getText().isEmpty()
                    || vista.AuxiliarCorreo.getText().isEmpty() || vista.AuxiliarTelf.getText().isEmpty() || vista.AuxiliarCelular.getText().isEmpty()
                    || vista.AuxiliarFechaNac.getDate() == null || vista.foto.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                if (validarFecha.FechaNacimiento(vista.AuxiliarFechaNac) == false) {
                    vista.ErrorFNac.setVisible(true);
                } else {

                    if (validarCorreo.VerificarEmail(vista.AuxiliarCorreo.getText()) == false) {
                        vista.ErrorEmail.setVisible(true);
                    } else {
                        int Id_persona = Integer.parseInt(vista.Id_Persona.getText());
                        int auxiliar_id = Integer.parseInt(vista.AuxiliarId.getText());
                        String cedula = vista.AuxiliarCedula.getText();
                        String PriNombre = vista.AuxiliarNomPrim.getText();
                        String SegNombre = vista.AuxiliarNomSeg.getText();
                        String PaApellido = vista.AuxiliarApellPri.getText();
                        String MaAepllido = vista.AuxiliarApellSeg.getText();
                        LocalDate FechaNacimiento = fecha_nacimiento();
                        String correo = vista.AuxiliarCorreo.getText();
                        String direccion = vista.AuxiliarDirec.getText();
                        String genero = eleccionGenero();
                        String telefono = vista.AuxiliarTelf.getText();
                        String movil = vista.AuxiliarCelular.getText();
                        String labores = vista.AuxiliaLabores.getSelectedItem().toString();
                        int idservicio = Integer.parseInt(vista.Aux_IdServ.getText());
                        String imagen = Imagen;

                        Auxiliar newAuxiliar = new Auxiliar();

                        newAuxiliar.setPersona_id(Id_persona);
                        newAuxiliar.setCedula(cedula);
                        newAuxiliar.setPri_nombre(PriNombre);
                        newAuxiliar.setSeg_nombre(SegNombre);
                        newAuxiliar.setPat_apellido(PaApellido);
                        newAuxiliar.setMat_apellido(MaAepllido);
                        newAuxiliar.setFecha_nacimiento(FechaNacimiento);
                        newAuxiliar.setCorreo(correo);
                        newAuxiliar.setDireccion(direccion);
                        newAuxiliar.setGenero(genero);
                        newAuxiliar.setTelefono(telefono);
                        newAuxiliar.setMovil(movil);

                        newAuxiliar.setAuxiliar_id(auxiliar_id);
                        newAuxiliar.setLabores(labores);
                        newAuxiliar.setId_servicio(idservicio);
                        newAuxiliar.setImagen(imagen);
                        listaAuxiliar.add(newAuxiliar);
                        String mensaje = modeloBO.agregarAuxiliar(newAuxiliar, cedula);
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
//MODIFICAR AUXILIAR

    public void modificarAuxiliar() {
        if (validarFecha.FechaNacimiento(vista.AuxiliarFechaNac) == false) {
            vista.ErrorFNac.setVisible(true);
        } else {
            int auxiliar_id = Integer.parseInt(vista.AuxiliarId.getText());
            String cedula = vista.AuxiliarCedula.getText();
            String PriNombre = vista.AuxiliarNomPrim.getText();
            String SegNombre = vista.AuxiliarNomSeg.getText();
            String PaApellido = vista.AuxiliarApellPri.getText();
            String MaAepllido = vista.AuxiliarApellSeg.getText();
            LocalDate FechaNacimiento = fecha_nacimiento();
            String correo = vista.AuxiliarCorreo.getText();
            String direccion = vista.AuxiliarDirec.getText();
            String genero = eleccionGenero();
            String telefono = vista.AuxiliarTelf.getText();
            String movil = vista.AuxiliarCelular.getText();
            String labores = vista.AuxiliaLabores.getSelectedItem().toString();
            int id_servicio = Integer.parseInt(vista.Aux_IdServ.getText());
            String imagen = Imagen;

            Auxiliar newAuxiliar = new Auxiliar();

            newAuxiliar.setPri_nombre(PriNombre);
            newAuxiliar.setSeg_nombre(SegNombre);
            newAuxiliar.setPat_apellido(PaApellido);
            newAuxiliar.setMat_apellido(MaAepllido);
            newAuxiliar.setFecha_nacimiento(FechaNacimiento);
            newAuxiliar.setCorreo(correo);
            newAuxiliar.setDireccion(direccion);
            newAuxiliar.setGenero(genero);
            newAuxiliar.setTelefono(telefono);
            newAuxiliar.setMovil(movil);
            newAuxiliar.setLabores(labores);
            newAuxiliar.setId_servicio(id_servicio);
            newAuxiliar.setImagen(imagen);
            listaAuxiliar.add(newAuxiliar);
            String mensaje = modeloBO.modificarAuxiliar(newAuxiliar, cedula, auxiliar_id);
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            Limpiar();
        }
    }
//ELIMINAR AUXILIAR
    private UsuariosBO ubo = new UsuariosBO();

    public void eliminarAuxiliar() {
        String cedula = vista.AuxiliarCedula.getText();
        String mensaje = modeloBO.eliminarAuxiliar(cedula);
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
        vista.Txt_buscar_aux.setText("");
        vista.AuxiliarCedula.setText("");
        vista.AuxiliarNomPrim.setText("");
        vista.AuxiliarNomSeg.setText("");
        vista.AuxiliarApellPri.setText("");
        vista.AuxiliarApellSeg.setText("");
        vista.AuxiliarCorreo.setText("");
        vista.AuxiliarDirec.setText("");
        vista.Genero.clearSelection();
        vista.AuxiliarFechaNac.setCalendar(null);
        vista.AuxiliarTelf.setText(null);
        vista.AuxiliarCelular.setText(null);
        vista.AuxiliaLabores.setSelectedItem("SELECCIONE");
        vista.Aux_IdServ.setText("");
        vista.C_nomservicio.setSelectedItem("SELECCIONE");
        idPersona();
        idAux();
        vista.foto.setIcon(null);
        vista.foto.setText("");
        vista.Bot_registrar.setEnabled(true);
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);

        //Advertencias
        vista.ErrorCed.setVisible(false);
        vista.ErrorNombres1.setVisible(false);
        vista.ErrorApellidos.setVisible(false);
        vista.ErrorDireccion.setVisible(false);
        vista.ErrorEmail.setVisible(false);
        vista.ErrorNumTel.setVisible(false);
        vista.ErrorNumCel.setVisible(false);
        vista.ErrorLabores.setVisible(false);
        vista.ErrorIDServ.setVisible(false);
        vista.ErrorFNac.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);
        vista.AuxiliarCedula.setEditable(true);

    }
//GROUP GENERO

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
        String fechemi = formato.format(vista.AuxiliarFechaNac.getDate());
        String fech[] = fechemi.split("/");
        LocalDate fechas = LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_nacimiento = fechas;

        return fecha_nacimiento;
    }

//CARGAR IMAGEN
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
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
                vista.foto.setText(null);
                vista.foto.setIcon(icono);
                try {
                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);
                    vista.AuxiliarCedula.setEditable(true);
                } catch (IOException e) {
                    System.out.println("Error imagen uno: " + e);
                    vista.AuxiliarCedula.setEditable(true);
                }
            }

        } catch (NullPointerException a) {
            System.out.println("Error imagen dos: " + a);
            vista.AuxiliarCedula.setEditable(true);
        }
        return nombreI;
    }

    //TRAER SERVICIOS    
    public void mostrarservicios() {
        modeloBO.mostrarserviciosBO(vista.C_nomservicio);
    }

    public void mostrarIdSevicio(String servicio) {
        int id = modeloBO.mostraridservicioBO(servicio);
        vista.Aux_IdServ.setText("" + id);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String servicio = vista.C_nomservicio.getSelectedItem().toString();
            mostrarIdSevicio(servicio);
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

            vistaR.txtBuscarCedAux.setText(complete);
            vistaR.txtBuscarCedAux.setCaretPosition(last);
            vistaR.txtBuscarCedAux.moveCaretPosition(start);

        }
    }
    // AUTOCOMPLETAR KEY RELEASED

    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaR.txtBuscarCedAux.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaR.txtBuscarCedAux.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }
}
