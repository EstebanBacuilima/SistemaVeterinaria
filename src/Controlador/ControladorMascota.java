package Controlador;

import Modelo.Mascota;
import Modelo.MascotaBO;
import Modelo.MascotaDAO;
import Modelo.PropietaroBO;
import Vista.RegistroMascota;
import Vista.ReporteMascotas;
import Vista.ReportePropietarios;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorMascota implements ActionListener, KeyListener, MouseListener {

    Mascota modelo = new Mascota();
    RegistroMascota vista = new RegistroMascota();
    ReporteMascotas vistaMascotas = new ReporteMascotas();
    ReportePropietarios vistaR = new ReportePropietarios();

    private MascotaBO modeloBO = new MascotaBO();
    private PropietaroBO modeloPro = new PropietaroBO();

    private MascotaDAO validacionDao = new MascotaDAO();

    public ControladorMascota(Mascota modelo, RegistroMascota vista, ReporteMascotas vistaM) {

        this.modelo = modelo;
        this.vista = vista;

        this.vista.Bot_registrar.addActionListener(this);
        this.vista.Bot_actualizar.addActionListener(this);
        this.vista.Bot_eliminar.addActionListener(this);
        this.vista.Bot_Reporte_Mascota.addActionListener(this);
        this.vista.Bot_salir.addActionListener(this);
        this.vista.Bot_buscar_propietario.addActionListener(this);
        this.vista.Bot_limpiar.addActionListener(this);
        this.vista.Bot_subirFoto.addActionListener(this);
        this.vista.Traer_Datos_Paciete.addActionListener(this);

        this.vistaMascotas.Bot_Regresar_Repo.addActionListener(this);
        this.vistaMascotas.Txt_Buscar_Ce.addKeyListener(this);
        this.vistaMascotas.Tablas_Pacientes_2.addMouseListener(this);

        this.vista.Bot_registrar.addMouseListener(this);
        this.vista.Bot_actualizar.addMouseListener(this);
        this.vista.Bot_eliminar.addMouseListener(this);

        // Tabla de Propietarios
        this.vistaR.Bot_Regresar_Repo.addActionListener(this);
        this.vistaR.Txt_Buscar_Ce.addKeyListener(this);
        TraerDatosDosClick(vistaR.Tablas_Pro);

        // 
        DatosAutoPaciente(vistaMascotas.Txt_Buscar_Ce);
        DatosAutoPropi(vistaR.Txt_Buscar_Ce);

        // validaciones
        validarsolonumeros(vista.edad_paciente);
        validarsolonumeros(vista.peso_paciente);
    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        vista.Id_propi.setVisible(false);
        vista.Id_mascota.setVisible(false);
        vista.La_foto_paciente_txt.setVisible(false);
        idPropetario();
        idPaciente();
        GenrarFicha();
        vista.clave_mascota.setEditable(false);
        vista.cedula_propietario.setEditable(false);
        vista.ErrorFaltaTexto.setVisible(false);
        // BOTONES

        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_registrar.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Bot_registrar) {
            crearPaciente();
        }
        if (e.getSource() == vista.Bot_actualizar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Modificar los datos de la Mascota?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {

                if (vista.nombre_paciente.getText().isEmpty() || vista.edad_paciente.getText().isEmpty() || vista.peso_paciente.getText().isEmpty() || vista.especie_paciente.getText().isEmpty() || vista.raza_paciente.getText().isEmpty()
                        || vista.obser_paciente.getText().isEmpty() || vista.macho.isSelected() == false && vista.hembra.isSelected() == false || vista.tamaño_paciente.getSelectedItem().equals("Seleccione")) {

                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                } else {
                    modificarPaciente();
                }
            }

        }
        if (e.getSource() == vista.Bot_eliminar) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar los datos de la Mascota?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                    icono("/iconos/alerta.png", 40, 40));
            if (res == JOptionPane.YES_OPTION) {
                eliminarPaciente();
            }

        }
        if (e.getSource() == vista.Bot_subirFoto) {
            String nuevaFot = SubirPefil();
            vista.La_foto_paciente.setText(nuevaFot);
        }
        if (e.getSource() == vista.Bot_buscar_propietario) {
            mostrar("");
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
        }
        if (e.getSource() == vista.Traer_Datos_Paciete) {
            if (vista.Txt_Buscar_clave.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Caja de Texto vacia", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                vista.ErrorFaltaTexto.setVisible(true);
            } else {
                TraerDatosPaciente();
                vista.ErrorFaltaTexto.setVisible(false);
                vista.Bot_actualizar.setEnabled(true);
                vista.Bot_eliminar.setEnabled(true);
                vista.Bot_registrar.setEnabled(false);
            }

        }
        if (e.getSource() == vista.Bot_Reporte_Mascota) {
            mostrarPaciente("");
            vistaMascotas.setLocationRelativeTo(null);
            vistaMascotas.setVisible(true);
        }
        if (e.getSource() == vistaMascotas.Bot_Regresar_Repo) {
            vistaMascotas.dispose();

        }
        if (e.getSource() == vistaR.Bot_Regresar_Repo) {
            vistaR.dispose();
            vistaR.Txt_Buscar_Ce.setText("");
        }
        if (e.getSource() == vista.Bot_limpiar) {
            Limpiar();
        }

        if (e.getSource() == vista.Bot_salir) {
            vista.dispose();
            Limpiar();
        }

        // VISTA 2
        if (e.getSource() == vistaR.Bot_Regresar_Repo) {
            vistaR.dispose();
        }
    }

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

            vistaMascotas.Txt_Buscar_Ce.setText(complete);
            vistaMascotas.Txt_Buscar_Ce.setCaretPosition(last);
            vistaMascotas.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }
    //------------------------------------------------------------------------------

    // GENERAR FICHA AUTOMATICA
    public void GenrarFicha() {
        Random rnd = new Random();
        String Abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cadena = "";
        int m = 0, pos = 0, pos2 = 0, num;

        while (m < 1) {
            pos = (int) (rnd.nextDouble() * Abecedario.length() - 1 + 0);
            pos2 = (int) (rnd.nextDouble() * Abecedario.length() - 1 + 0);
            num = (int) (rnd.nextDouble() * 999 + 100);
            cadena = cadena + Abecedario.charAt(pos) + Abecedario.charAt(pos2) + num;
            vista.clave_mascota.setText(cadena);
            cadena = "";
            m++;
        }
    }

    //--------------------------------TRAER DATOS PROPIETARIOS A TXTFIELDS-----------------------------
    public void mostrar(String cedula) {
        modeloPro.listarPropietarios(vistaR.Tablas_Pro, cedula);
    }
    //-------------------------------------------------------------------------------------------------

    // LISTAR PACIENTES
    private void mostrarPaciente(String clave) {
        modeloBO.listarPacientes(vistaMascotas.Tablas_Pacientes_2, clave);
    }

    void TraerDatosPaciente() {

        mostrarPaciente(vista.Txt_Buscar_clave.getText());
        int fila = 0;

        vista.cedula_propietario.setVisible(false);
        vista.texto_ci.setVisible(false);
        vista.Bot_buscar_propietario.setVisible(false);

        ///
        vista.Bot_actualizar.setEnabled(true);
        vista.Bot_eliminar.setEnabled(true);
        vista.Bot_registrar.setEnabled(false);

        for (int i = 0; fila < vistaMascotas.Tablas_Pacientes_2.getRowCount(); fila++) {

            vistaMascotas.Tablas_Pacientes_2.changeSelection(i, 0, false, false);

            vista.Id_mascota.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 0).toString());
            vista.clave_mascota.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 1).toString());
            vista.nombre_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 2).toString());
            vista.edad_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 3).toString());
            vista.peso_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 4).toString());
            String sexo = String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 5).toString());
            if ("Macho".equals(sexo)) {
                vista.macho.setSelected(true);
            } else if ("Hembra".equals(sexo)) {
                vista.hembra.setSelected(true);
            }
            vista.especie_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 6).toString());
            vista.raza_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 7).toString());
            vista.tamaño_paciente.setSelectedItem(vistaMascotas.Tablas_Pacientes_2.getValueAt(vistaMascotas.Tablas_Pacientes_2.getSelectedRow(), 8).toString());
            vista.obser_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 9).toString());

            Imagen = String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(i, 10));
            vista.La_foto_paciente_txt.setText(Imagen);
            String fotoBuscar = vista.La_foto_paciente_txt.getText();
            Orig = "src/Imagenes_mascotas/" + fotoBuscar;
            ImageIcon icon = new ImageIcon(Orig);
            ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.La_foto_paciente.getWidth(), vista.La_foto_paciente.getHeight(), Image.SCALE_DEFAULT));
            vista.La_foto_paciente.setText(null);
            vista.La_foto_paciente.setIcon(icono);
        }

    }

    // ID INCREMENTABLES
    private void idPropetario() {
        vista.Id_propi.setText(modeloBO.getProID() + "");
    }

    private void idPaciente() {
        vista.Id_mascota.setText(modeloBO.getpaciID() + "");
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
        String ficha = vista.clave_mascota.getText();
        for (int i = 0; i < vistaMascotas.Tablas_Pacientes_2.getRowCount(); i++) {
            if (vistaMascotas.Tablas_Pacientes_2.getValueAt(i, 1).equals(ficha)) {
                chek = true;
            }
        }
        return chek;
    }

    // CREACION PACIENTE
    ArrayList<Mascota> listaPacientes = new ArrayList<>();

    public void crearPaciente() {

        if (validarExistencia() == true) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Ficha Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            GenrarFicha();
        } else {
            if (vista.nombre_paciente.getText().isEmpty() || vista.edad_paciente.getText().isEmpty() || vista.peso_paciente.getText().isEmpty() || vista.especie_paciente.getText().isEmpty() || vista.raza_paciente.getText().isEmpty()
                    || vista.obser_paciente.getText().isEmpty() || vista.cedula_propietario.getText().isEmpty() || vista.macho.isSelected() == false && vista.hembra.isSelected() == false || vista.tamaño_paciente.getSelectedItem().equals(0) || vista.La_foto_paciente.getText().isEmpty()) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));

            } else {

                int Id_pro = Integer.parseInt(vista.Id_mascota.getText());
                int Id_paciente = Integer.parseInt(vista.Id_propi.getText());
                String nombre = vista.nombre_paciente.getText();
                int edad = Integer.parseInt(vista.edad_paciente.getText());
                int peso = Integer.parseInt(vista.peso_paciente.getText());
                String sexo = eleccionSexo();
                String especie = vista.especie_paciente.getText();
                String raza = vista.raza_paciente.getText();
                String tamaño = vista.tamaño_paciente.getSelectedItem().toString();
                String observacions = vista.obser_paciente.getText();
                String imagen = Imagen;
                String clave_mascota = vista.clave_mascota.getText();

                Mascota newPaciente = new Mascota();

                newPaciente.setId_propietario(Id_paciente);
                newPaciente.setId_mascota(Id_pro);
                newPaciente.setNombre_pac(nombre);
                newPaciente.setEdad(edad);
                newPaciente.setPeso(peso);
                newPaciente.setSexo(sexo);
                newPaciente.setEspecie(especie);
                newPaciente.setRaza(raza);
                newPaciente.setTamaño(tamaño);
                newPaciente.setObservaciones(observacions);
                newPaciente.setImagene(imagen);
                newPaciente.setMascota_clave(clave_mascota);

                listaPacientes.add(newPaciente);
                String mensaje = modeloBO.agregarPaciente(newPaciente);
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                Limpiar();
            }
        }
    }

    // MODIFICAR PACIENTE
    public void modificarPaciente() {

        String clave_mascota = vista.clave_mascota.getText();

        String nombre = vista.nombre_paciente.getText();
        int edad = Integer.parseInt(vista.edad_paciente.getText());
        int peso = Integer.parseInt(vista.peso_paciente.getText());
        String sexo = eleccionSexo();
        String especie = vista.especie_paciente.getText();
        String raza = vista.raza_paciente.getText();
        String tamaño = vista.tamaño_paciente.getSelectedItem().toString();
        String observacions = vista.obser_paciente.getText();
        String imagen = Imagen;

        Mascota newPaciente = new Mascota();

        newPaciente.setNombre_pac(nombre);
        newPaciente.setEdad(edad);
        newPaciente.setPeso(peso);
        newPaciente.setSexo(sexo);
        newPaciente.setEspecie(especie);
        newPaciente.setRaza(raza);
        newPaciente.setTamaño(tamaño);
        newPaciente.setObservaciones(observacions);
        newPaciente.setImagene(imagen);

        listaPacientes.add(newPaciente);
        String mensaje = modeloBO.modificarPaciente(newPaciente, clave_mascota);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    // ELIMINAR PACIENTE
    public void eliminarPaciente() {
        String clave = vista.clave_mascota.getText();
        String mensaje = modeloBO.eliminarPaciente(clave);
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
        Limpiar();
    }

    //---------------------------CARGAR IMAGEN----------------------------//
    protected static String Imagen;
    protected static String Dest, Orig;
    String nombreI;

    public String SubirPefil() {

        try {

            JFileChooser file = new JFileChooser();
            int valor = file.showOpenDialog(file);

            if (valor == file.CANCEL_OPTION) {
                //System.out.println("no seleciono");
            } else {
                //file = new JFileChooser("C:\\Users\\edu\\Downloads\\Imagenes Proyecto Vet");
                //file.showOpenDialog(null);
                File archivo = file.getSelectedFile();
                Dest = "src/Imagenes_mascotas/" + archivo.getName();
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
                    System.out.println("Error imagen uno: " + e);
                }
            }

        } catch (NullPointerException a) {
            System.out.println("Error imagen dos: " + a);
        }
        return nombreI;
    }
    //--------------------------------------------------------------------

    public String eleccionSexo() {

        String genero = null;
        if (vista.macho.isSelected()) {
            genero = "Macho";
        }
        if (vista.hembra.isSelected()) {
            genero = "Hembra";
        }
        return genero;
    }

    public void Limpiar() {

        vista.Txt_Buscar_clave.setText("");
        vista.clave_mascota.setText("");
        vista.nombre_paciente.setText("");
        vista.edad_paciente.setText("");
        vista.peso_paciente.setText("");
        vista.raza_paciente.setText("");
        vista.especie_paciente.setText("");
        vista.sexo_mascota.clearSelection();
        vista.tamaño_paciente.setSelectedIndex(0);
        vista.obser_paciente.setText("");
        vista.cedula_propietario.setText("");
        vista.La_foto_paciente.setIcon(null);
        vista.La_foto_paciente.setText("");
        vista.cedula_propietario.setVisible(true);
        vista.texto_ci.setVisible(true);
        idPaciente();
        idPropetario();
        GenrarFicha();
        vista.Bot_buscar_propietario.setVisible(true);
        vista.Bot_actualizar.setEnabled(false);
        vista.Bot_eliminar.setEnabled(false);
        vista.Bot_registrar.setEnabled(true);
        vista.ErrorFaltaTexto.setVisible(false);

    }

    // EVENTOS TXT FIELDS
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        BusquedaTablas();
        BusquedaTablasProp();
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

    private void DatosAutoPropi(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarCedula(e);
            }
        });
    }

    //-------------------------------------------------------------------------------------------------------------
    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList pro = new ArrayList();
    String datospro;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarProp() {
        modeloPro.TraerDatosAuto(pro, datospro);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarPropietario(String txt) {
        TraerDatosAutoCompletarProp(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = txt.length();
        int last = txt.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < pro.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (pro.get(a).toString().startsWith(txt)) {

                complete = pro.get(a).toString();
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
                        autoCompletarPropietario(txt);

                    }
                });

        }
    }

    //------------------------------------------------
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
    //-------------------------------------------------------------------------------------------------------------

    void BusquedaTablasProp() {
        if (vistaR.Txt_Buscar_Ce.getText().isEmpty()) {
            mostrar("");
            Limpiar();
        } else {
            mostrar(vistaR.Txt_Buscar_Ce.getText());
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

    @Override
    public void mouseClicked(MouseEvent e) {
        //TraerDatosPropietraio(e);
        TraerDatosMascota(e);
    }

    private void TraerDatosDosClick(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosPropietraio(e);
            }
        });
    }

    private void TraerDatosPropietraio(MouseEvent e) {

        int fila = vistaR.Tablas_Pro.getSelectedRow();

        if (e.getClickCount() == 2) {
            if (fila >= 0) {

                vista.Id_propi.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 0)));
                vista.cedula_propietario.setText(String.valueOf(vistaR.Tablas_Pro.getValueAt(fila, 1)));
                vistaR.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    private void TraerDatosMascota(MouseEvent e) {

        int fila = vistaMascotas.Tablas_Pacientes_2.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.Bot_actualizar.setEnabled(true);
            vista.Bot_eliminar.setEnabled(true);
            vista.Bot_registrar.setEnabled(false);

            if (fila >= 0) {

                vista.Id_mascota.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 0).toString());
                vista.clave_mascota.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 1).toString());
                vista.nombre_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 2).toString());
                vista.edad_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 3).toString());
                vista.peso_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 4).toString());
                String sexo = String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 5).toString());
                if ("Macho".equals(sexo)) {
                    vista.macho.setSelected(true);
                } else if ("Hembra".equals(sexo)) {
                    vista.hembra.setSelected(true);
                }
                vista.especie_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 6).toString());
                vista.raza_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 7).toString());
                vista.tamaño_paciente.setSelectedItem(vistaMascotas.Tablas_Pacientes_2.getValueAt(vistaMascotas.Tablas_Pacientes_2.getSelectedRow(), 8).toString());
                vista.obser_paciente.setText(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 9).toString());

                Imagen = String.valueOf(vistaMascotas.Tablas_Pacientes_2.getValueAt(fila, 10));
                vista.La_foto_paciente_txt.setText(Imagen);
                String fotoBuscar = vista.La_foto_paciente_txt.getText();
                Orig = "src/Imagenes_mascotas/" + fotoBuscar;
                ImageIcon icon = new ImageIcon(Orig);
                ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.La_foto_paciente.getWidth(), vista.La_foto_paciente.getHeight(), Image.SCALE_DEFAULT));
                vista.La_foto_paciente.setText(null);
                vista.La_foto_paciente.setIcon(icono);
                vistaMascotas.dispose();

                vista.cedula_propietario.setVisible(false);
                vista.texto_ci.setVisible(false);
                vista.Bot_buscar_propietario.setVisible(false);

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

    // solo numeros
    private void validarnum(java.awt.event.KeyEvent evt) {
        char vali = evt.getKeyChar();
        if (Character.isLetter(vali) || vali == ',' || vali == '.') {
            vista.getToolkit().beep();
            evt.consume();
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
