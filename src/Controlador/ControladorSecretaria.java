package Controlador;

import static Controlador.ControladorMascota.Dest;
import static Controlador.ControladorMascota.Imagen;
import static Controlador.ControladorMascota.Orig;
import Modelo.Secretaria;
import Modelo.SecretariaBO;
import Modelo.UsuariosBO;
import Validaciones.ValidacionCedula;
import Validaciones.ValidacionCorreo;
import Validaciones.ValidacionFechasNacimiento;
import Vista.RegistroSecretaria;
import Vista.ReporteSecretarias;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorSecretaria implements ActionListener, MouseListener, KeyListener {

    Secretaria modelo = new Secretaria();
    RegistroSecretaria vista = new RegistroSecretaria();
    ReporteSecretarias vistaRe = new ReporteSecretarias();
    private SecretariaBO modeloBO = new SecretariaBO();

    // VALIDACIONES
    ValidacionCedula validarCedula = new ValidacionCedula();
    ValidacionFechasNacimiento validarFecha = new ValidacionFechasNacimiento();
    ValidacionCorreo validarCorreo = new ValidacionCorreo();

    public ControladorSecretaria(Secretaria modelo, RegistroSecretaria vista, ReporteSecretarias vistaRe) {

        this.modelo = modelo;
        this.vista = vista;

        this.vista.Bot_registrar.addActionListener(this);
        this.vista.Bot_actualizar.addActionListener(this);
        this.vista.Bot_eliminar.addActionListener(this);

        this.vista.Bot_Regresar.addActionListener(this);
        this.vista.Bot_buscar_mascota.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vista.Bot_Reporte.addActionListener(this);
        this.vista.Bot_subirFoto.addActionListener(this);

        this.vistaRe.Bot_Regresar_Repo.addActionListener(this);
        this.vistaRe.Tablas_Secre.addMouseListener(this);

        this.vistaRe.Txt_Buscar_Ce.addKeyListener(this);

        // Validar Txt
        validarcedula(vista.CedulaSecre);

        validarsololetras(vista.NomPrimSecre);
        validarTamaño(vista.NomPrimSecre, 50);
        validarsololetras(vista.NomSegSecre);
        validarTamaño(vista.NomSegSecre, 50);
        validarsololetras(vista.ApellPriSecre);
        validarTamaño(vista.ApellPriSecre, 50);
        validarsololetras(vista.ApellSegSecre);
        validarTamaño(vista.ApellSegSecre, 50);

        validarsolonumeros(vista.TelfSecre);
        validarTamaño(vista.TelfSecre, 13);
        validarsolonumeros(vista.CelularSecre);
        validarTamaño(vista.CelularSecre, 18);
        validarsolonumeros(vista.NumeroVentanilla);
        validarTamaño(vista.NumeroVentanilla, 2);

    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.ErrorFaltaTexto.setVisible(false);
        idPersona();
        idPro();

        // BOTONES
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        vista.Id_Persona.setVisible(false);
        vista.Id_secre.setVisible(false);
        vista.La_foto_paciente_txt.setVisible(false);

        // ADEVERTENCIAS
        vista.ErrorCed.setVisible(false);
        vista.ErrorCorreo.setVisible(false);
        vista.ErrorFecha.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Bot_registrar) {
            crearSecretaria();
        }
        if (e.getSource() == vista.Bot_actualizar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos del Secretaria?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {

                if (vista.CedulaSecre.getText().isEmpty() || vista.NomPrimSecre.getText().isEmpty() || vista.NomSegSecre.getText().isEmpty() || vista.ApellPriSecre.getText().isEmpty()
                        || vista.ApellSegSecre.getText().isEmpty() || vista.CorreoSecre.getText().isEmpty() || vista.DirecSecre.getText().isEmpty()
                        || vista.TelfSecre.getText().isEmpty() || vista.CelularSecre.getText().isEmpty() || vista.Masculino.isSelected() == false && vista.Femenino.isSelected() == false || vista.FechaNacSecre.getDate() == null || vista.La_foto_paciente.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                } else {
                    if (validarFecha.FechaNacimiento(vista.FechaNacSecre) == false) {
                        vista.ErrorFecha.setVisible(true);
                    } else {
                        modificarSecretaria();
                        vista.CedulaSecre.setEditable(true);
                    }
                }
            }

        }
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos del Secretaria?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                eliminarSecretaria();
                vista.CedulaSecre.setEditable(true);
            }

        }
        if (e.getSource() == vista.Bot_Limpiar) {
            Limpiar();
        }
        if (e.getSource() == vista.Bot_Regresar) {
            vista.dispose();
            Limpiar();
        }
        if (e.getSource() == vista.Bot_subirFoto) {
            String nuevaFot = SubirPefil();
            vista.La_foto_paciente.setText(nuevaFot);
        }
        if (e.getSource() == vista.Bot_Reporte) {
            mostrar("");
            vistaRe.setLocationRelativeTo(null);
            vistaRe.setVisible(true);
        }
        if (e.getSource() == vistaRe.Bot_Regresar_Repo) {
            vistaRe.dispose();
            vistaRe.Txt_Buscar_Ce.setText(" ");
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
    }

    // MOSTRAR DATOS Y TRAER DATOS
    private void mostrar(String cedula) {
        modeloBO.listarSecretaria(vistaRe.Tablas_Secre, cedula);
    }

    void TraerDatos() {

        mostrar(vista.Txt_buscar_mascota.getText());

        vista.Bot_actualizar.setEnabled(true);
        vista.Bot_eliminar.setEnabled(true);
        vista.Bot_registrar.setEnabled(false);

        int fila = 0;

        for (int i = 0; fila < vistaRe.Tablas_Secre.getRowCount(); fila++) {

            vistaRe.Tablas_Secre.changeSelection(i, 0, false, false);

            vista.Id_secre.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 0)));
            vista.CedulaSecre.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 1)));
            vista.CedulaSecre.setEditable(false);
            String nombresApellidos = vistaRe.Tablas_Secre.getValueAt(fila, 2).toString();
            StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
            while (st.hasMoreTokens()) {
                vista.NomPrimSecre.setText(st.nextToken());
                vista.NomSegSecre.setText(st.nextToken());
                vista.ApellPriSecre.setText(st.nextToken());
                vista.ApellSegSecre.setText(st.nextToken());
            }
            String Genero = String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 3).toString());
            if ("Masculino".equals(Genero)) {
                vista.Masculino.setSelected(true);
            } else if ("Femenino".equals(Genero)) {
                vista.Femenino.setSelected(true);
            }
            vista.CorreoSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 4).toString());
            vista.TelfSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 5).toString());
            vista.CelularSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 6).toString());
            vista.DirecSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 7).toString());

            String fecha = vistaRe.Tablas_Secre.getValueAt(fila, 8).toString();
            SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaN = vista.FechaNacSecre.getDate();
            try {
                fechaN = formatoDelTexto.parse(fecha);
                vista.FechaNacSecre.setDate(fechaN);
            } catch (ParseException ex) {
                ex.printStackTrace();
            }

            vista.NumeroVentanilla.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 9)));
            Imagen = String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 10));
            vista.La_foto_paciente_txt.setText(Imagen);
            String fotoBuscar = vista.La_foto_paciente_txt.getText();
            Orig = "src/ImagenesPersonal/" + fotoBuscar;
            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.La_foto_paciente.getWidth(), vista.La_foto_paciente.getHeight(), Image.SCALE_DEFAULT));
            vista.La_foto_paciente.setText(null);
            vista.La_foto_paciente.setIcon(icono);

        }

    }

    // IDES
    private void idPersona() {
        vista.Id_Persona.setText(modeloBO.getPersonaID() + "");
    }

    private void idPro() {
        vista.Id_secre.setText(modeloBO.getSecretariaID() + "");
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    //validar existencia
    public boolean validarExistencia() {

        boolean chek = false;
        String ficha = vista.CedulaSecre.getText();
        for (int i = 0; i < vistaRe.Tablas_Secre.getRowCount(); i++) {
            if (vistaRe.Tablas_Secre.getValueAt(i, 1).equals(ficha)) {
                chek = true;
            }
        }
        return chek;
    }

    ArrayList<Secretaria> listaSecretaria = new ArrayList<Secretaria>();

    public void crearSecretaria() {

        if (validarExistencia() == true) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Cedula Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            if (vista.CedulaSecre.getText().isEmpty() || vista.NomPrimSecre.getText().isEmpty() || vista.NomSegSecre.getText().isEmpty() || vista.ApellPriSecre.getText().isEmpty()
                    || vista.ApellSegSecre.getText().isEmpty() || vista.CorreoSecre.getText().isEmpty() || vista.DirecSecre.getText().isEmpty()
                    || vista.TelfSecre.getText().isEmpty() || vista.CelularSecre.getText().isEmpty() || vista.Masculino.isSelected() == false && vista.Femenino.isSelected() == false || vista.FechaNacSecre.getDate() == null || vista.La_foto_paciente.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                if (validarFecha.FechaNacimiento(vista.FechaNacSecre) == false) {
                    vista.ErrorFecha.setVisible(true);
                } else {

                    if (validarCorreo.VerificarEmail(vista.CorreoSecre.getText()) == false) {
                        vista.ErrorCorreo.setVisible(true);
                    } else {

                        int Id_persona = Integer.parseInt(vista.Id_Persona.getText());
                        int Id_secre = Integer.parseInt(vista.Id_secre.getText());
                        String cedula = vista.CedulaSecre.getText();
                        String PriNombre = vista.NomPrimSecre.getText();
                        String SegNombre = vista.NomSegSecre.getText();
                        String PaApellido = vista.ApellPriSecre.getText();
                        String MaAepllido = vista.ApellSegSecre.getText();
                        LocalDate FechaNacimiento = fecha_nacimiento();
                        String correo = vista.CorreoSecre.getText();
                        String direccion = vista.DirecSecre.getText();
                        String genero = eleccionGenero();
                        String telefono = vista.TelfSecre.getText();
                        String movil = vista.CelularSecre.getText();
                        int NumCaja = Integer.parseInt(vista.NumeroVentanilla.getText());
                        String foto = Imagen;

                        Secretaria newSecretaria = new Secretaria();

                        newSecretaria.setPersona_id(Id_persona);
                        newSecretaria.setCedula(cedula);
                        newSecretaria.setPri_nombre(PriNombre);
                        newSecretaria.setSeg_nombre(SegNombre);
                        newSecretaria.setPat_apellido(PaApellido);
                        newSecretaria.setMat_apellido(MaAepllido);
                        newSecretaria.setFecha_nacimiento(FechaNacimiento);
                        newSecretaria.setCorreo(correo);
                        newSecretaria.setDireccion(direccion);
                        newSecretaria.setGenero(genero);
                        newSecretaria.setTelefono(telefono);
                        newSecretaria.setMovil(movil);

                        newSecretaria.setId_secretaria(Id_secre);
                        newSecretaria.setNumero_ventanilla(NumCaja);
                        newSecretaria.setImagene(foto);

                        listaSecretaria.add(newSecretaria);
                        String mensaje = modeloBO.agregarSecretaria(newSecretaria);
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

    public void modificarSecretaria() {

        int Id_secre = Integer.parseInt(vista.Id_secre.getText());

        String cedula = vista.CedulaSecre.getText();
        String PriNombre = vista.NomPrimSecre.getText();
        String SegNombre = vista.NomSegSecre.getText();
        String PaApellido = vista.ApellPriSecre.getText();
        String MaAepllido = vista.ApellSegSecre.getText();
        LocalDate FechaNacimiento = fecha_nacimiento();
        String correo = vista.CorreoSecre.getText();
        String direccion = vista.DirecSecre.getText();
        String genero = eleccionGenero();
        String telefono = vista.TelfSecre.getText();
        String movil = vista.CelularSecre.getText();

        int NumCaja = Integer.parseInt(vista.NumeroVentanilla.getText());
        String foto = Imagen;

        Secretaria newSecretaria = new Secretaria();

        newSecretaria.setPri_nombre(PriNombre);
        newSecretaria.setSeg_nombre(SegNombre);
        newSecretaria.setPat_apellido(PaApellido);
        newSecretaria.setMat_apellido(MaAepllido);
        newSecretaria.setFecha_nacimiento(FechaNacimiento);
        newSecretaria.setCorreo(correo);
        newSecretaria.setDireccion(direccion);
        newSecretaria.setGenero(genero);
        newSecretaria.setTelefono(telefono);
        newSecretaria.setMovil(movil);

        newSecretaria.setNumero_ventanilla(NumCaja);
        newSecretaria.setImagene(foto);

        listaSecretaria.add(newSecretaria);
        String mensaje = modeloBO.modificarSecretaria(newSecretaria, cedula, Id_secre);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    private UsuariosBO ubo = new UsuariosBO();

    public void eliminarSecretaria() {
        String clave = vista.Id_secre.getText();
        String cedula = vista.CedulaSecre.getText();
        String mensaje = modeloBO.eliminarSecretaria(clave);
        // eliminar user
        String mensaje2 = ubo.eliminarUsuario(cedula);
        //JOptionPane.showMessageDialog(null, mensaje);
        //JOptionPane.showMessageDialog(null, mensaje2);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    String nombreI;

    public String SubirPefil() {

        try {

            JFileChooser file = new JFileChooser("C:\\Users\\edu\\Downloads\\Imagenes Proyecto Vet");
            int valor = file.showOpenDialog(file);

            if (valor == file.CANCEL_OPTION) {
                //System.out.println("no seleciono");
            } else {

                File archivo = file.getSelectedFile();
                Dest = "src\\ImagenesPersonal\\" + archivo.getName();
                Orig = archivo.getPath();
                Imagen = archivo.getName();
                nombreI = Imagen;

                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.La_foto_paciente.getWidth(), vista.La_foto_paciente.getHeight(), Image.SCALE_DEFAULT));
                vista.La_foto_paciente.setText(null);
                vista.La_foto_paciente.setIcon(icono);

                try {

                    Path Destino = Paths.get(Dest);
                    Path Origen = Paths.get(Orig);
                    Files.copy(Origen, Destino, StandardCopyOption.REPLACE_EXISTING);

                } catch (IOException e) {
                    System.out.println("Error imagen " + e);
                }
            }

        } catch (NullPointerException a) {
            System.out.println("Error imagen dos: " + a);
        }
        return nombreI;

    }

    public void Limpiar() {

        vista.CedulaSecre.setEditable(true);
        vista.Txt_buscar_mascota.setText("");
        vista.CedulaSecre.setText("");
        vista.NomPrimSecre.setText("");
        vista.NomSegSecre.setText("");
        vista.ApellPriSecre.setText("");
        vista.ApellSegSecre.setText("");
        vista.CorreoSecre.setText("");
        vista.DirecSecre.setText("");
        vista.Genero.clearSelection();
        vista.FechaNacSecre.setCalendar(null);
        vista.TelfSecre.setText("");
        vista.CelularSecre.setText("");
        vista.NumeroVentanilla.setText("");
        vista.La_foto_paciente.setIcon(null);
        vista.La_foto_paciente.setText("");
        vista.La_foto_paciente_txt.setText("");

        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_registrar.setEnabled(true);

        vista.ErrorCed.setVisible(false);
        vista.ErrorCorreo.setVisible(false);
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
        String fechemi = formato.format(vista.FechaNacSecre.getDate());
        String fech[] = fechemi.split("/");
        LocalDate fechas = LocalDate.of(Integer.parseInt(fech[0]), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_nacimiento = fechas;

        return fecha_nacimiento;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int fila = vistaRe.Tablas_Secre.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.Bot_registrar.setEnabled(false);
            vista.Bot_actualizar.setEnabled(true);
            vista.Bot_eliminar.setEnabled(true);

            if (fila >= 0) {

                vista.Id_secre.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 0)));
                vista.CedulaSecre.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 1)));
                vista.CedulaSecre.setEditable(false);
                String nombresApellidos = vistaRe.Tablas_Secre.getValueAt(fila, 2).toString();
                StringTokenizer st = new StringTokenizer(nombresApellidos, " ");
                while (st.hasMoreTokens()) {
                    vista.NomPrimSecre.setText(st.nextToken());
                    vista.NomSegSecre.setText(st.nextToken());
                    vista.ApellPriSecre.setText(st.nextToken());
                    vista.ApellSegSecre.setText(st.nextToken());
                }
                String Genero = String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 3).toString());
                if ("Masculino".equals(Genero)) {
                    vista.Masculino.setSelected(true);
                } else if ("Femenino".equals(Genero)) {
                    vista.Femenino.setSelected(true);
                }
                vista.CorreoSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 4).toString());
                vista.TelfSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 5).toString());
                vista.CelularSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 6).toString());
                vista.DirecSecre.setText(vistaRe.Tablas_Secre.getValueAt(fila, 7).toString());

                String fecha = vistaRe.Tablas_Secre.getValueAt(fila, 8).toString();
                SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaN = vista.FechaNacSecre.getDate();
                try {
                    fechaN = formatoDelTexto.parse(fecha);
                    vista.FechaNacSecre.setDate(fechaN);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }

                vista.NumeroVentanilla.setText(String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 9)));
                Imagen = String.valueOf(vistaRe.Tablas_Secre.getValueAt(fila, 10));
                vista.La_foto_paciente_txt.setText(Imagen);
                String fotoBuscar = vista.La_foto_paciente_txt.getText();
                Orig = "src/ImagenesPersonal/" + fotoBuscar;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.La_foto_paciente.getWidth(), vista.La_foto_paciente.getHeight(), Image.SCALE_DEFAULT));
                vista.La_foto_paciente.setText(null);
                vista.La_foto_paciente.setIcon(icono);
                vistaRe.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }

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

    @Override
    public void keyReleased(KeyEvent e) {
        BusquedaTablas();
        autocompletarCedula(e);
    }

    void BusquedaTablas() {

        if (vistaRe.Txt_Buscar_Ce.getText().isEmpty()) {
            mostrar("");
            Limpiar();
        } else {
            mostrar(vistaRe.Txt_Buscar_Ce.getText());
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
        Validarcedtamaño(vista.CedulaSecre.getText(), tam, evt);
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

            vistaRe.Txt_Buscar_Ce.setText(complete);
            vistaRe.Txt_Buscar_Ce.setCaretPosition(last);
            vistaRe.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }

    // AUTOCMPLETAR KEY RELEASED
    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaRe.Txt_Buscar_Ce.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaRe.Txt_Buscar_Ce.getText();
                        autoCompletar(txt);

                    }
                });

        }
    }

}
