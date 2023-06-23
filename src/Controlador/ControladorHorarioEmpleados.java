package Controlador;

import Modelo.HorarioEmpleadosBO;
import Modelo.MHorario;
import Modelo.MHorarioEmpleados;
import Vista.Horario;
import Vista.HorarioEmpleados;
import Vista.RegistroHorariosEmpleados;
import Vista.RegistrosEmpleados;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class ControladorHorarioEmpleados implements ActionListener {

    //HORARIO EMPLEADOS
    MHorarioEmpleados modelo = new MHorarioEmpleados();
    HorarioEmpleados vista = new HorarioEmpleados();
    private HorarioEmpleadosBO hebo = new HorarioEmpleadosBO();

    //VISTA DATOS MEDICO
    RegistrosEmpleados vistaR = new RegistrosEmpleados();

    //VISTA DATOS HORARIO MEDICO
    RegistroHorariosEmpleados vistaH = new RegistroHorariosEmpleados();

    //VISTA HORARIO
    MHorario modeloh = new MHorario();
    Horario vistaHo = new Horario();
    ControladorHorario controlh = new ControladorHorario(vistaHo, modeloh);

    public ControladorHorarioEmpleados(HorarioEmpleados vista, MHorarioEmpleados modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.btAgr.addActionListener(this);
        this.vista.btMod.addActionListener(this);
        this.vista.btEli.addActionListener(this);
        this.vista.Bot_Reporte.addActionListener(this);
        this.vista.btMed.addActionListener(this);
        this.vista.btHor.addActionListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);

        //ADICIONALES
        this.vistaR.btSal.addActionListener(this);
        this.vistaH.chbIn.addActionListener(this);
        this.vistaH.Bot_Regresar_Repo.addActionListener(this);

        //MOUSECLICKED
        TraerDatosMedico(vistaR.Tabla_REg_Empleado);
        TraerDatosRepHorario(vistaH.Tablas_Horarios);
        TraerDatosDosClickHorario(vistaHo.Tabla_Horario);

        //KEYRELEASED
        DatosAutoMedico(vistaR.trBus);
        DatosAutoHoraEmp(vistaH.Txt_Buscar_Ce);
    }

    public void Iniciar_Vista() {
        vista.setLocationRelativeTo(null);
        mostrar("");
        idIncre();
        vista.trId.setVisible(false);
        vista.trCod.setVisible(false);
        vista.id_servicio.setVisible(false);
        controlh.Iniciar_Vista();
        vista.btAgr.setEnabled(true);
        vista.btEli.setEnabled(false);
        vista.btMod.setEnabled(false);
    }

    //METODOS
    ArrayList<MHorarioEmpleados> listahe = new ArrayList<MHorarioEmpleados>();

    //validar existencia
    public boolean validarExistenciaMismoHorarioMismoConsultori() {

        boolean chek = false;
        String horaInicio = vista.trHI.getText();
        String horaFin = vista.trHI.getText();
        for (int i = 0; i < vistaH.Tablas_Horarios.getRowCount(); i++) {
            if (vistaH.Tablas_Horarios.getValueAt(i, 1).equals(horaFin)) {
                chek = true;
            }
        }
        return chek;
    }

    public void validarExistenciaMismoHorario() {
        String id_servicio = "";
        String horaInicio = vista.trHI.getText();
        String horaFin = vista.trHF.getText();
         String dia = vista.trDia.getText();
        hebo.validarRepetido(id_servicio, horaInicio, horaFin,dia);
    }

    public void ingresar() {
        if (vista.trNom.getText().isEmpty() || vista.trApe.getText().isEmpty() || vista.trDia.getText().isEmpty() || vista.trHI.getText().isEmpty() || vista.trHF.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No se ha completado la operación, existe algún campo vacio", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
        } else {
            String id_servicio = vista.id_servicio.getText();
            String horaInicio = vista.trHI.getText();
            String horaFin = vista.trHF.getText();
            String dia = vista.trDia.getText();

            if (hebo.validarRepetido(id_servicio, horaInicio, horaFin,dia) == true) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, el horario esta repetido", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            } else {
                int id_horarioemp = Integer.parseInt(vista.trId.getText());
                int id_horario = Integer.parseInt(vista.trCod.getText());
                int id_medico = Integer.parseInt(vista.trCo.getText());

                MHorarioEmpleados horarioemp = new MHorarioEmpleados();
                horarioemp.setId_horarioemp(id_horarioemp);
                horarioemp.setId_horario(id_horario);
                horarioemp.setId_medico(id_medico);
                listahe.add(horarioemp);
                String mensaje = hebo.agregarHorarioEmp(horarioemp);
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
                limpiar();
                mostrar("");
            }
        }
    }

    public void modificar() {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de modificar los datos del horario veterinario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                icono("/iconos/alerta.png", 40, 40));
        if (res == JOptionPane.YES_OPTION) {
            int id_horarioemp = Integer.parseInt(vista.trId.getText());
            int id_horario = Integer.parseInt(vista.trCod.getText());
            int id_medico = Integer.parseInt(vista.trCo.getText());

            MHorarioEmpleados horarioemp = new MHorarioEmpleados();
            horarioemp.setId_horarioemp(id_horarioemp);
            horarioemp.setId_horario(id_horario);
            horarioemp.setId_medico(id_medico);
            listahe.add(horarioemp);
            String mensaje = hebo.modificarHorarioEmp(horarioemp, id_horarioemp);
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            limpiar();
            mostrar("");
            vista.btAgr.setEnabled(true);
        }else{
            limpiar();
            vista.btAgr.setEnabled(true);
            vista.btMod.setEnabled(false);
            vista.btEli.setEnabled(false);
        }
    }

    public void eliminar() {
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de eliminar el horario veterinario?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                icono("/iconos/alerta.png", 40, 40));
        if (res == JOptionPane.YES_OPTION) {
            int id_horarioemp = Integer.parseInt(vista.trId.getText());
            String mensaje = hebo.eliminarHorarioEmp(id_horarioemp);
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, mensaje, "Verificación", JOptionPane.PLAIN_MESSAGE, icono("/iconos/verificar.png", 40, 40));
            limpiar();
            mostrar("");
            vista.btAgr.setEnabled(true);
        }else{
            limpiar();
            vista.btAgr.setEnabled(true);
            vista.btMod.setEnabled(false);
            vista.btEli.setEnabled(false);
        }
    }

    //MOSTRAR ELIMINADOS DE LOS HORARIOS MEDICOS
    private void mostrareliminados() {
        if (vistaH.chbIn.isSelected()) {
            hebo.eliminados(vistaH.Tablas_Horarios);
        } else {
            String cedula = "";
            hebo.listarHorarioEmp(vistaH.Tablas_Horarios, cedula);
        }
    }

    //BUSCAR EN LA TABLA MEDICO
    void Buscar() {

        if (vistaR.trBus.getText().isEmpty()) {
            mostrarm("");
        } else {
            mostrarm(vistaR.trBus.getText());
        }

    }

    //BUSCAR EN LA TABLA HORARIO MEDICO
    void BuscarM() {

        if (vistaH.Txt_Buscar_Ce.getText().isEmpty()) {
            mostrar("");
        } else {
            mostrar(vistaH.Txt_Buscar_Ce.getText());
        }

    }


    //METODO DE ID INCREMETAL
    private void idIncre() {
        vista.trId.setText(hebo.getIncreID() + "");
    }

    //LIMPIAR LOS CAMPOS
    private void limpiar() {
        vista.trId.setEnabled(true);
        vista.trCo.setText("");
        vista.trCod.setText("");
        vista.trHF.setText("");
        vista.trHI.setText("");
        vista.trDia.setText("");
        vista.trNom.setText("");
        vista.trApe.setText("");
        vista.btAgr.setEnabled(true);
        vistaR.trBus.setText("");
        
        idIncre();
        vista.btMed.setEnabled(true);
        vista.btAgr.setEnabled(true);
        vista.btEli.setEnabled(false);
        vista.btMod.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btAgr) {
            ingresar();
        }
        if (e.getSource() == vista.btMod) {
            modificar();
        }
        if (e.getSource() == vista.btEli) {
            eliminar();
        }
        if (e.getSource() == vistaH.chbIn) {
            mostrareliminados();
        }
        if (e.getSource() == vista.btMed) {
            mostrarm("");
            vistaR.setLocationRelativeTo(null);
            vistaR.setVisible(true);
            vistaR.trBus.setText("");
        }
        if (e.getSource() == vista.btHor) {
            mostrarh("");
            vistaHo.setLocationRelativeTo(null);
            vistaHo.setVisible(true);
        }
        if (e.getSource() == vistaR.btSal) {
            vistaR.dispose();
            vista.setLocationRelativeTo(null);
            vista.setVisible(true);
            
        }
        if (e.getSource() == vista.Bot_Reporte) {
            vistaH.setLocationRelativeTo(null);
            vistaH.setVisible(true);
            
        }
        if (e.getSource() == vistaH.Bot_Regresar_Repo) {
            vistaH.dispose();
            vistaH.chbIn.setSelected(false);
            vistaH.Txt_Buscar_Ce.setText("");
            mostrar("");
        }
        if (e.getSource() == vista.Bot_Limpiar){
            limpiar();
        }        
    }

    // TRAER DATOS DEL MEDICO
    private void mostrarm(String cedula) {
        hebo.mostrarmedico(vistaR.Tabla_REg_Empleado, cedula);
    }

    private void TraerDatosMedico(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosMedico(e);
            }
        });
    }

    void TraerDatosMedico(MouseEvent e) {

        int fila = vistaR.Tabla_REg_Empleado.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.btAgr.setEnabled(true);
            vista.btEli.setEnabled(false);
            vista.btMod.setEnabled(false);

            if (fila >= 0) {

                vistaR.Tabla_REg_Empleado.changeSelection(fila, 0, false, false);
                vista.trCo.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 0)));
                vista.trCo.setVisible(false);
                vista.trNom.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 2)));
                vista.trApe.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 3)));
                vista.id_servicio.setText(String.valueOf(vistaR.Tabla_REg_Empleado.getValueAt(fila, 6)));
                vistaR.trBus.setText("");
                vista.setLocationRelativeTo(null);
                vista.setVisible(true);
                vistaR.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    // TRAER DATOS DEL HORARIO MEDICO
    private void mostrar(String apellido) {
        hebo.listarHorarioEmp(vistaH.Tablas_Horarios, apellido);
    }

    private void TraerDatosRepHorario(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosRepHorario(e);
            }
        });
    }

    void TraerDatosRepHorario(MouseEvent e) {

        int fila = vistaH.Tablas_Horarios.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.btAgr.setEnabled(false);
            vista.btEli.setEnabled(true);
            vista.btMod.setEnabled(true);

            if (fila >= 0) {

                vista.trId.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 0)));
                vista.trId.setVisible(false);
                vista.trCo.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 1)));
                vista.trNom.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 2)));
                vista.trApe.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 3)));
                vista.trDia.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 4)));
                vista.trHI.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 5)));
                vista.trHF.setText(String.valueOf(vistaH.Tablas_Horarios.getValueAt(fila, 6)));
                vistaH.Txt_Buscar_Ce.setText("");
                vista.setLocationRelativeTo(null);
                vista.setVisible(true);
                vista.btMed.setEnabled(false);
                vistaH.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
            vistaH.Txt_Buscar_Ce.setText("");
        }
    }

    // TRAER DATOS DEL HORARIO
    private void mostrarh(String dia) {
        hebo.listarHorario(vistaHo.Tabla_Horario, dia);
    }

    private void TraerDatosDosClickHorario(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TraerDatosHorario(e);
            }
        });
    }

    void TraerDatosHorario(MouseEvent e) {

        int fila = vistaHo.Tabla_Horario.getSelectedRow();

        if (e.getClickCount() == 2) {

            vista.btAgr.setEnabled(true);
            vista.btEli.setEnabled(true);
            vista.btMod.setEnabled(true);
            if (fila >= 0) {

                vistaHo.Tabla_Horario.changeSelection(fila, 0, false, false);
                vista.trCod.setText(String.valueOf(vistaHo.Tabla_Horario.getValueAt(fila, 0)));
                vista.trHI.setText(String.valueOf(vistaHo.Tabla_Horario.getValueAt(fila, 1)));
                vista.trHF.setText(String.valueOf(vistaHo.Tabla_Horario.getValueAt(fila, 2)));
                vista.trDia.setText(String.valueOf(vistaHo.Tabla_Horario.getValueAt(fila, 3)));
                vistaHo.trBus.setText("");
                vista.setLocationRelativeTo(null);
                vista.setVisible(true);
                vistaHo.dispose();

            } else {
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList name = new ArrayList();
    String datos;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletar() {
        hebo.TraerDatosAuto(name, datos);
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

            vistaR.trBus.setText(complete);
            vistaR.trBus.setCaretPosition(last);
            vistaR.trBus.moveCaretPosition(start);

        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList hora = new ArrayList();
    String dat;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarHo() {
        hebo.TraerDatosAutoHo(hora, dat);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarHora(String dia) {
        TraerDatosAutoCompletarHo(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = dia.length();
        int last = dia.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < hora.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (hora.get(a).toString().startsWith(dia)) {

                complete = hora.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaHo.trBus.setText(complete);
            vistaHo.trBus.setCaretPosition(last);
            vistaHo.trBus.moveCaretPosition(start);

        }
    }

    // CREAR ARRAY LISTA ALMACENAR 
    ArrayList horaemp = new ArrayList();
    String dato;

    // TRAEMOS A LLENARA EL ARRAY
    private void TraerDatosAutoCompletarHoEmp() {
        hebo.TraerDatosAutoHoEmp(horaemp, dato);
    }

    // AUTOCOMPLETAR TXT
    public void autoCompletarHoraEmp(String apellido) {
        TraerDatosAutoCompletarHoEmp(); // TRAER EL METODO LLENAR ARRAY
        String complete = "";
        // Declaramos int al iniciar escribir y terminar de escribir 
        // length() la longitud de lo escrito
        int start = apellido.length();
        int last = apellido.length();

        int a;

        // Creamos un for que rrecore nuestro array buscando coincidencias 
        for (a = 0; a < horaemp.size(); a++) {

            // startWiht = usa para verificar el prefijo de una cadena.
            if (horaemp.get(a).toString().startsWith(apellido)) {

                complete = horaemp.get(a).toString();
                last = complete.length();

                break;
            }
        }

        if (last > start) {

            vistaH.Txt_Buscar_Ce.setText(complete);
            vistaH.Txt_Buscar_Ce.setCaretPosition(last);
            vistaH.Txt_Buscar_Ce.moveCaretPosition(start);

        }
    }

    private void DatosAutoMedico(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarCedula(e);
                Buscar();
            }
        });
    }


    private void DatosAutoHoraEmp(JTextField cajaTexto) {
        cajaTexto.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                autocompletarApellido(e);
                BuscarM();
            }
        });
    }

    // AUTOCMPLETAR KEY RELEASED
    void autocompletarCedula(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrarm(vistaR.trBus.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String txt = vistaR.trBus.getText();
                        autoCompletar(txt);
                    }
                });

        }
    }

    void autocompletarApellido(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_BACK_SPACE:
                break;

            case KeyEvent.VK_ENTER:
                mostrar(vistaHo.trBus.getText());
                break;

            default:

                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        String apellido = vistaH.Txt_Buscar_Ce.getText();
                        autoCompletarHoraEmp(apellido);
                    }
                });

        }
    }
    
    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }
}
