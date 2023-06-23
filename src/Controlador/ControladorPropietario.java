package Controlador;

import javax.swing.JOptionPane;
import Modelo.*;
import Validaciones.ValidacionCedula;
import Validaciones.ValidacionCorreo;
import Validaciones.ValidacionFechasNacimiento;
import Vista.RegistroPropietario;
import Vista.ReportePropietarios;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorPropietario implements ActionListener, KeyListener, MouseListener {

    UIManager UI;

    Propietario modelo = new Propietario();
    RegistroPropietario vista = new RegistroPropietario();
    ReportePropietarios vistaR = new ReportePropietarios();

    private PropietaroBO modeloBO = new PropietaroBO();

    // VALIDACIONES
    ValidacionCedula validarCedula = new ValidacionCedula();
    ValidacionFechasNacimiento validarFecha = new ValidacionFechasNacimiento();
    ValidacionCorreo validarCorreo = new ValidacionCorreo();

    public ControladorPropietario(Propietario modelo, RegistroPropietario vista, ReportePropietarios vistaR) {

        this.modelo = modelo;
        this.vista = vista;

        this.vista.Bot_registrar.addActionListener(this);
        this.vista.Bot_actualizar.addActionListener(this);
        this.vista.Bot_eliminar.addActionListener(this);

        this.vista.Bot_Regresar.addActionListener(this);
        this.vista.Bot_buscar_mascota.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.Bot_Reporte.addActionListener(this);
        this.vistaR.Bot_Regresar_Repo.addActionListener(this);
        this.vistaR.BuscarTabla_Bot.addActionListener(this);

        // EVENTOS BUSCAR EN FRAME TODOS
        this.vistaR.Txt_Buscar_Ce.addKeyListener(this);
        this.vistaR.Tablas_Pro.addMouseListener(this);

        // EVENTOS DE MOUSE
        this.vista.Bot_registrar.addMouseListener(this);
        this.vista.Bot_actualizar.addMouseListener(this);
        this.vista.Bot_eliminar.addMouseListener(this);

        // TXT FIELS
        validarcedula(vista.PropietarioCedula);
        validarsololetras(vista.PropietarioNomPrim);
        validarTamaño(vista.PropietarioNomPrim, 50);
        validarsololetras(vista.PropirtarioNomSeg);
        validarTamaño(vista.PropirtarioNomSeg, 50);
        validarsololetras(vista.PropietarioApellPri);
        validarTamaño(vista.PropietarioApellPri, 50);
        validarsololetras(vista.PropietarioApellSeg);
        validarTamaño(vista.PropietarioApellSeg, 50);

        validarsolonumeros(vista.PropietarioTelf);
        validarTamaño(vista.PropietarioTelf, 13);
        validarsolonumeros(vista.PropietarioCelular);
        validarTamaño(vista.PropietarioTelf, 18);

    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.Id_Persona.setVisible(false);
        vista.Id_propietario.setVisible(false);
        idPersona();
        idPro();

        // Botones       
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);

        // Advertencias
        vista.ErrorCorreo.setVisible(false);
        vista.ErrorCed.setVisible(false);
        vista.ErrorFecha.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);

        vista.jPanel1.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Bot_registrar) {
            crearPropietario();
        }
        if (e.getSource() == vista.Bot_actualizar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos del Propietario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {

                if (vista.PropietarioCedula.getText().isEmpty() || vista.PropietarioNomPrim.getText().isEmpty() || vista.PropirtarioNomSeg.getText().isEmpty() || vista.PropietarioApellPri.getText().isEmpty() || vista.Id_propietario.getText().isEmpty()
                        || vista.PropietarioApellSeg.getText().isEmpty() || vista.PropietarioCorreo.getText().isEmpty() || vista.PropietarioDirec.getText().isEmpty()
                        || vista.PropietarioTelf.getText().isEmpty() || vista.PropietarioCelular.getText().isEmpty() || vista.Masculino.isSelected() == false && vista.Femenino.isSelected() == false || vista.PropietarioFechaNac.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                } else {

                    if (validarFecha.FechaNacimiento(vista.PropietarioFechaNac) == false) {
                        vista.ErrorFecha.setVisible(true);
                    } else {
                        modificarPropietario();
                    }

                }
            }

        }
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos del Propietario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                eliminarPropietario();
            }

        }
        if (e.getSource() == vista.Bot_Limpiar) {
            Limpiar();
        }
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
        }
        if (e.getSource() == vista.Bot_Reporte) {
            mostrar("");
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
        }
        if (e.getSource() == vista.Bot_buscar_mascota) {

            if (vista.Txt_buscar_mascota.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Caja de Texto vacia", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                vista.ErrorFaltaTexto.setVisible(true);
            } else {
                TraerDatos();
                vista.ErrorFaltaTexto.setVisible(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
                vista.Bot_registrar.setEnabled(false);
            }

        }

        // VISTA 2
        if (e.getSource() == vistaR.Bot_Regresar_Repo) {
            vistaR.dispose();
            vistaR.Txt_Buscar_Ce.setText(" ");
        }

        if (e.getSource() == vistaR.BuscarTabla_Bot) {
            BusquedaTablas();
        }
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
        Validarcedtamaño(vista.PropietarioCedula.getText(), tam, evt);
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

            vistaR.Txt_Buscar_Ce.setText(complete);
            vistaR.Txt_Buscar_Ce.setCaretPosition(last);
            vistaR.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }

    @Override
    public void keyTyped(KeyEvent evt) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        BusquedaTablas();
        autocompletarCedula(e);
    }

    // AUTOCMPLETAR KEY RELEASED
    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaR.Txt_Buscar_Ce.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaR.Txt_Buscar_Ce.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }

    // TABLAS
    void BusquedaTablas() {

        if (vistaR.Txt_Buscar_Ce.getText().isEmpty()) {
            mostrar("");
            Limpiar();
        } else {
            mostrar(vistaR.Txt_Buscar_Ce.getText());
        }
    }

    void TraerDatos() {

        mostrar(vista.Txt_buscar_mascota.getText());

        int fila = 0;

        for (int i = 0; fila < vistaR.Tablas_Pro.getRowCount(); fila++) {

            vista.Id_propietario.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 0)));
            vista.PropietarioCedula.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 1)));
            vista.PropietarioCedula.setEnabled(false);

            String nombresApellidos = vistaR.Tablas_Pro.getValueAt(fila, 2).toString();
            StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
            while (st.hasMoreTokens()) {
                vista.PropietarioNomPrim.setText(st.nextToken());
                vista.PropirtarioNomSeg.setText(st.nextToken());
                vista.PropietarioApellPri.setText(st.nextToken());
                vista.PropietarioApellSeg.setText(st.nextToken());
            }

            String Genero = String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 3).toString());
            if ("Masculino".equals(Genero)) {
                vista.Masculino.setSelected(true);
            } else if ("Femenino".equals(Genero)) {
                vista.Femenino.setSelected(true);
            }
            vista.PropietarioCorreo.setText(vistaR.Tablas_Pro.getValueAt(fila, 4).toString());
            vista.PropietarioTelf.setText(vistaR.Tablas_Pro.getValueAt(fila, 5).toString());
            vista.PropietarioCelular.setText(vistaR.Tablas_Pro.getValueAt(fila, 6).toString());
            vista.PropietarioDirec.setText(vistaR.Tablas_Pro.getValueAt(fila, 7).toString());

            String fecha = vistaR.Tablas_Pro.getValueAt(fila, 8).toString();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaN = vista.PropietarioFechaNac.getDate();
            try {
                fechaN = formatoDelTexto.parse(fecha);
                vista.PropietarioFechaNac.setDate(fechaN);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }

    }

    // EVENTOS MOUSE
    @Override
    public void mouseClicked(MouseEvent e) {

        int fila = vistaR.Tablas_Pro.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.Bot_registrar.setEnabled(false);
            vista.Bot_actualizar.setEnabled(true);
            vista.Bot_eliminar.setEnabled(true);

            if (fila >= 0) {

                vista.Id_propietario.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 0)));
                vista.PropietarioCedula.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 1)));
                vista.PropietarioCedula.setEnabled(false);
                String nombresApellidos = vistaR.Tablas_Pro.getValueAt(fila, 2).toString();
                StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
                while (st.hasMoreTokens()) {
                    vista.PropietarioNomPrim.setText(st.nextToken());
                    vista.PropirtarioNomSeg.setText(st.nextToken());
                    vista.PropietarioApellPri.setText(st.nextToken());
                    vista.PropietarioApellSeg.setText(st.nextToken());
                }
                String Genero = String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 3).toString());
                if ("Masculino".equals(Genero)) {
                    vista.Masculino.setSelected(true);
                } else if ("Femenino".equals(Genero)) {
                    vista.Femenino.setSelected(true);
                }
                vista.PropietarioCorreo.setText(vistaR.Tablas_Pro.getValueAt(fila, 4).toString());
                vista.PropietarioTelf.setText(vistaR.Tablas_Pro.getValueAt(fila, 5).toString());
                vista.PropietarioCelular.setText(vistaR.Tablas_Pro.getValueAt(fila, 6).toString());
                vista.PropietarioDirec.setText(vistaR.Tablas_Pro.getValueAt(fila, 7).toString());

                String fecha = vistaR.Tablas_Pro.getValueAt(fila, 8).toString();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaN = vista.PropietarioFechaNac.getDate();
                try {
                    fechaN = formatoDelTexto.parse(fecha);
                    vista.PropietarioFechaNac.setDate(fechaN);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
                // Cerrar Frame
                vistaR.dispose();

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

    public void mostrar(String cedula) {
        modeloBO.listarPropietarios(vistaR.Tablas_Pro, cedula);
    }

    private void idPersona() {
        vista.Id_Persona.setText(modeloBO.getPersonaID() + "");
    }

    private void idPro() {
        vista.Id_propietario.setText(modeloBO.getProID() + "");
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    ArrayList<Propietario> listaPropietarios = new ArrayList<>();

    //validar existencia
    public boolean validarExistencia() {

        boolean chek = false;
        String ficha = vista.PropietarioCedula.getText();
        for (int i = 0; i < vistaR.Tablas_Pro.getRowCount(); i++) {
            if (vistaR.Tablas_Pro.getValueAt(i, 1).equals(ficha)) {
                chek = true;
            }
        }
        return chek;
    }

    public void crearPropietario() {

        if (validarExistencia() == true) {
            JOptionPane.showMessageDialog(null, "Cedula Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            if (vista.PropietarioCedula.getText().isEmpty() || vista.PropietarioNomPrim.getText().isEmpty() || vista.PropirtarioNomSeg.getText().isEmpty() || vista.PropietarioApellPri.getText().isEmpty()
                    || vista.PropietarioApellSeg.getText().isEmpty() || vista.PropietarioCorreo.getText().isEmpty() || vista.PropietarioDirec.getText().isEmpty()
                    || vista.PropietarioTelf.getText().isEmpty() || vista.PropietarioCelular.getText().isEmpty() || vista.Masculino.isSelected() == false && vista.Femenino.isSelected() == false || vista.PropietarioFechaNac.getDate() == null) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                if (validarFecha.FechaNacimiento(vista.PropietarioFechaNac) == false) {
                    vista.ErrorFecha.setVisible(true);
                } else {
                    if (validarCorreo.VerificarEmail(vista.PropietarioCorreo.getText()) == false) {
                        vista.ErrorCorreo.setVisible(true);
                    } else {

                        int Id_persona = Integer.parseInt(vista.Id_Persona.getText());
                        int Id_pro = Integer.parseInt(vista.Id_propietario.getText());
                        String cedula = vista.PropietarioCedula.getText();
                        String PriNombre = vista.PropietarioNomPrim.getText();
                        String SegNombre = vista.PropirtarioNomSeg.getText();
                        String PaApellido = vista.PropietarioApellPri.getText();
                        String MaAepllido = vista.PropietarioApellSeg.getText();
                        LocalDate FechaNacimiento = fecha_nacimiento();
                        String correo = vista.PropietarioCorreo.getText();
                        String direccion = vista.PropietarioDirec.getText();
                        String genero = eleccionGenero();
                        String telefono = vista.PropietarioTelf.getText();
                        String movil = vista.PropietarioCelular.getText();

                        Propietario newPropietario = new Propietario();

                        newPropietario.setPersona_id(Id_persona);
                        newPropietario.setCedula(cedula);
                        newPropietario.setPri_nombre(PriNombre);
                        newPropietario.setSeg_nombre(SegNombre);
                        newPropietario.setPat_apellido(PaApellido);
                        newPropietario.setMat_apellido(MaAepllido);
                        newPropietario.setFecha_nacimiento(FechaNacimiento);
                        newPropietario.setCorreo(correo);
                        newPropietario.setDireccion(direccion);
                        newPropietario.setGenero(genero);
                        newPropietario.setTelefono(telefono);
                        newPropietario.setMovil(movil);

                        newPropietario.setId_propietario(Id_pro);

                        listaPropietarios.add(newPropietario);
                        String mensaje = modeloBO.agregarPropietario(newPropietario, cedula);
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

    public void modificarPropietario() {

        String cedula = vista.PropietarioCedula.getText();
        String PriNombre = vista.PropietarioNomPrim.getText();
        String SegNombre = vista.PropirtarioNomSeg.getText();
        String PaApellido = vista.PropietarioApellPri.getText();
        String MaAepllido = vista.PropietarioApellSeg.getText();
        LocalDate FechaNacimiento = fecha_nacimiento();
        String correo = vista.PropietarioCorreo.getText();
        String direccion = vista.PropietarioDirec.getText();
        String genero = eleccionGenero();
        String telefono = vista.PropietarioTelf.getText();
        String movil = vista.PropietarioCelular.getText();

        Propietario newPropietario = new Propietario();

        newPropietario.setPri_nombre(PriNombre);
        newPropietario.setSeg_nombre(SegNombre);
        newPropietario.setPat_apellido(PaApellido);
        newPropietario.setMat_apellido(MaAepllido);
        newPropietario.setFecha_nacimiento(FechaNacimiento);
        newPropietario.setCorreo(correo);
        newPropietario.setDireccion(direccion);
        newPropietario.setGenero(genero);
        newPropietario.setTelefono(telefono);
        newPropietario.setMovil(movil);

        listaPropietarios.add(newPropietario);
        String mensaje = modeloBO.modificarPropietario(newPropietario, cedula);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    public void eliminarPropietario() {
        String clave = vista.Id_propietario.getText();
        String mensaje = modeloBO.eliminarPropietario(clave);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    public void Limpiar() {

        vista.Txt_buscar_mascota.setText("");
        vista.PropietarioCedula.setText("");
        vista.PropietarioCedula.setEnabled(true);
        vista.PropietarioNomPrim.setText("");
        vista.PropirtarioNomSeg.setText("");
        vista.PropietarioApellPri.setText("");
        vista.PropietarioApellSeg.setText("");
        vista.PropietarioCorreo.setText("");
        vista.PropietarioDirec.setText("");
        vista.Genero.clearSelection();
        vista.PropietarioFechaNac.setCalendar(null);
        vista.PropietarioTelf.setText(null);
        vista.PropietarioCelular.setText(null);

        // LIMPIAR LOS BOTONES
        vista.Bot_registrar.setEnabled(true);
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        // ADVERTENCIAS
        vista.ErrorCorreo.setVisible(false);
        vista.ErrorCed.setVisible(false);
        vista.ErrorFecha.setVisible(false);
        vista.ErrorFaltaTexto.setVisible(false);
        idPersona();
        idPro();
    }

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

    public LocalDate fecha_nacimiento() {

        LocalDate fecha_nacimiento = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        String fechemi = formato.format(vista.PropietarioFechaNac.getDate());
        String fech[] = fechemi.split("/");
        LocalDate fechas = LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_nacimiento = fechas;

        return fecha_nacimiento;
    }

}
