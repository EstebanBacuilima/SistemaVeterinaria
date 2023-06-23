package Controlador;

import Modelo.CFactura;
import Modelo.Cita;
import Modelo.CitaBO;
import Modelo.Persona;
import Vista.Factura;
import Vista.RegistroCitas;
import Vista.Tabla_extra_citas;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ControladorCita implements ActionListener, MouseListener, ItemListener, ChangeListener, PropertyChangeListener {

    CitaBO cibo = new CitaBO();
    Cita c = new Cita();
    RegistroCitas vista = new RegistroCitas();
    Factura vistaF = new Factura();
    DefaultTableModel modelo = new DefaultTableModel();
    DefaultTableModel modeloLista = new DefaultTableModel();
    Tabla_extra_citas texc = new Tabla_extra_citas();
    public static DefaultTableModel modelof;
    DefaultTableModel modelovacio;
    double preu, total;
    String mensaje = "";
    Date fechaactual = new Date(System.currentTimeMillis());
    SimpleDateFormat dates = new SimpleDateFormat("dd-mm-yyyy");

    public ControladorCita(RegistroCitas v) {
        this.vista = v;
        this.vista.Cb_generarf.addActionListener(this);
        this.vista.Bot_Regresar1.addActionListener(this);
        this.vistaF.Salir_F.addActionListener(this);
        this.vista.Cb_registrar.addActionListener(this);
        this.vista.Cb_actualizar.addActionListener(this);
        this.vista.Cb_cancelaredit.addActionListener(this);
        this.texc.Tablas_ext.addMouseListener(this);
        this.vista.Bot_b_dueño.addActionListener(this);
        this.vista.C_nomservicio.addActionListener(this);
        this.vista.C_nomservicio.addItemListener(this);
        this.vista.Bot_Limpiar.addActionListener(this);
        this.vistaF.Imprimir.addActionListener(this);
        this.vista.PoEditar.addActionListener(this);
        this.vista.PoEliminar.addActionListener(this);
        this.vista.Volver.addActionListener(this);
        this.vista.Cb_vlista.addActionListener(this);
        this.texc.Salir_pm.addActionListener(this);
        this.vista.C_fecha.addPropertyChangeListener(this);
        this.vista.C_hora.addChangeListener(this);
        iniciarFrame();

//        vista.id_secretaria.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //abrirmos el fram de la factura
        if (e.getSource() == vista.Cb_generarf) {

            if (datosdetabla() == 0) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Se debe realizar al menos una cita para generar la factura");
            } else {

                vistaF.setVisible(true);
                vistaF.setLocationRelativeTo(null);
                vistaF.F_id.setText("" + vista.N_factura.getText());
                modelarcolumnas();
                pasarDatos();
                bloqdatosf();
                datospropietario();
                calcularCosto();
                guardarFactura();
                agregar_cita();
                String id_f = vistaF.F_id.getText();
                cibo.mostrarF(id_f);
                cibo.mostrarT(id_f);
                limpiarDatos_cita(1);
                vaciart();
            }
        }

//        ---------------------------------------GUARDAR CITA---------------------   
        if (e.getSource() == vista.Cb_registrar) {

            if (validarRegistro() == true) {
                boolean v = validarhora();
                if (v == true) {
                    lista_citas();
                    limpiarDatos_cita(2);
                    vista.C_fecha.setEnabled(false);
                    vista.C_hora.setEnabled(false);
                } else {
                    UIManager UI = new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "Escojer la hora Corectamente");
                }
            }
        }
//        ---------------------------------------Ver lista de citas---------------------   
        if (e.getSource() == vista.Cb_vlista) {
            vista.Registroc.setVisible(false);
            vista.Panel_lista.setVisible(true);
            vista.Cb_vlista.setVisible(false);
            vista.Volver.setVisible(true);
            vista.Cb_generarf.setVisible(true);
            vista.limpiarrr.setVisible(false);
            vista.Bot_Limpiar.setVisible(false);
            int idf = cibo.getIDFacturaBO();
            vista.N_factura.setText("" + idf);
        }
//        ---------------------------------------volver al registro de citas--------------------- 
        if (e.getSource() == vista.Volver) {
            vista.Panel_lista.setVisible(false);
            vista.Cb_vlista.setVisible(true);
            vista.Registroc.setVisible(true);
            vista.Volver.setVisible(false);
            vista.Cb_generarf.setVisible(false);
            vista.limpiarrr.setVisible(true);
            vista.Bot_Limpiar.setVisible(true);
        }
//        ---------------------------------------EDITAR---------------------
        if (e.getSource() == vista.PoEditar) {
            Editardatos();
            vista.Cb_actualizar.setEnabled(true);
            vista.Cb_cancelaredit.setVisible(true);
            vista.Cb_vlista.setVisible(false);
        }
//        ---------------------------------------ACTUALIZAR---------------------
        if (e.getSource() == vista.Cb_actualizar) {
            if (validarRegistro() == true) {
                boolean v = validarhora();
                if (v == true) {
                    actualizar();
                    limpiarDatos_cita(2);
                    vista.Cb_actualizar.setEnabled(false);
                    vista.Cb_cancelaredit.setVisible(false);
                    vista.C_hora.setEnabled(false);
                    vista.C_fecha.setEnabled(false);
                } else {
                    UIManager UI = new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    JOptionPane.showMessageDialog(null, "Escojer la hora Corectamente");
                    System.out.println("");
                }
            }
        }
//        --------------------------------------CANCELAR-EDICION---------------------
        if (e.getSource() == vista.Cb_cancelaredit) {

            limpiarDatos_cita(2);
            vista.Cb_actualizar.setEnabled(false);
            vista.Cb_registrar.setEnabled(true);
            vista.Cb_registrar.setVisible(true);
            vista.Cb_cancelaredit.setVisible(false);
            vista.Cb_vlista.setVisible(true);
        }

//        ---------------------------------------ELIMINAR---------------------
        if (e.getSource() == vista.PoEliminar) {
            int fila = vista.T_solicitadas.getSelectedRow();
            modeloLista.removeRow(fila);

        }
//        --------------------------------LIMPIAR---------------------         
        if (e.getSource() == vista.Bot_Limpiar) {
            if (datosdetabla() == 0) {
                limpiarDatos_cita(1);
                vaciart();
                vistaF.dispose();
            } else {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro que desea limpiar? se eliminaran todas las citas realizadas actualmente", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        icono("/iconos/alerta.png", 40, 40));
                if (res == JOptionPane.YES_OPTION) {
                    limpiarDatos_cita(1);
                    vaciart();
                    vistaF.dispose();
                }
            }
        }

//        ---------------------Mostrar Datos Mascota y su dueño---------------------
        if (e.getSource() == vista.Bot_b_dueño) {
            if (datosdetabla() == 0) {
                texc.B_datos_ext.setVisible(true);
                texc.labelced.setVisible(true);
                buscarPropietario();
                buscarpro(1);

            } else {
                texc.B_datos_ext.setText("");
                texc.B_datos_ext.setVisible(false);
                texc.labelced.setVisible(false);
                buscarpro(2);
            }
            texc.setLocationRelativeTo(null);
            texc.setVisible(true);
            TraerDatosDosClick(texc.Tablas_ext);
        }

        if (e.getSource() == vistaF.Imprimir) {
            String id_f = vistaF.F_id.getText();
            cibo.mostrarF(id_f);
            cibo.mostrarT(id_f);
            
        }
        if (e.getSource() == vistaF.Salir_F) {
            vaciarTF();
            limpiarF();
            vistaF.dispose();

        }

        if (e.getSource() == vista.Bot_Regresar1) {
            if (datosdetabla() == 0) {
                limpiarDatos_cita(1);
                vaciart();
                vista.dispose();
            } else {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro que desea Salir? se eliminaran todas las citas realizadas actualmente", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        icono("/iconos/alerta.png", 40, 40));
                if (res == JOptionPane.YES_OPTION) {
                    limpiarDatos_cita(1);
                    vaciart();
                    vista.dispose();
                }
            }
        }
        if (e.getSource() == texc.Salir_pm) {

            texc.dispose();
        }

    }

    public void buscarpro(int num) {
        if (num == 1) {
            String dato;
            if (texc.B_datos_ext.getText().isEmpty()) {
                dato = "";
            } else {
                dato = texc.B_datos_ext.getText();
            }
            cibo.mostrar_datos_extBO(texc.Tablas_ext, dato, 1);
        } else if (num == 2) {
            String dato = vista.C_ceddueño.getText();
            cibo.mostrar_datos_extBO(texc.Tablas_ext, dato, 1);

        }
    }

    public void buscarPropietario() {
        texc.B_datos_ext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                buscarpro(1);

            }
        });
    }

    public void iniciarFrame() {
        ((JSpinner.DefaultEditor) vista.C_hora.getEditor()).getTextField().setEditable(false);
        AutoCompleteDecorator.decorate(vista.C_nomservicio);
        AutoCompleteDecorator.decorate(vista.C_nomveteri);
        vista.h_f_rango.setVisible(false);
        vista.Panel_lista.setVisible(false);
        vista.Volver.setVisible(false);
        vista.Cb_generarf.setVisible(false);
        vista.N_factura.setVisible(false);
        vista.Cb_actualizar.setEnabled(false);
        vista.Cb_cancelaredit.setVisible(false);
        vista.C_idcita.setVisible(false);
        vista.Cid_dueño.setVisible(false);
        vista.Cid_paciente.setVisible(false);
        vista.Cid_serv.setVisible(false);
        vista.Cid_med.setVisible(false);
        vista.Cid_consul.setVisible(false);
        vista.C_hora.setEnabled(false);
        vista.C_fecha.setEnabled(false);
        vista.C_ceddueño.setEditable(false);
        vista.C_nomdueño.setEditable(false);
        vista.C_nompaciente.setEditable(false);
        texc.B_datos_ext.setVisible(false);
        texc.labelced.setVisible(false);
        escojerhorario();
        validarHora();
        mostrarservicios();
        buscarservicio();
        buscarveterinario();

    }

    public boolean validarRegistro() {
        boolean v = false;
        if (vista.Cid_dueño.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor especifique el dueño y la mascota que asistiran a la cita", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.Cid_serv.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor escoger el servicio para la cita ", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.Cid_med.getText().isEmpty()) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor escoger el medico para la cita", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.C_fecha.getDate() == (null)) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor escoger la fecha de la cita", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if (vista.C_combohoras.getSelectedItem() == ("Selecionar Horario")) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor escoger el horario para la cita", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else if ("0".equals(vista.C_hora.getValue())) {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "Por favor escoger el horario para la cita", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
            v = false;
        } else {
            v = true;
        }
        return v;
    }

    public void agregar_cita() {

        for (int i = 0; i < vista.T_solicitadas.getRowCount(); i++) {
//            
//        int id=Integer.parseInt(vista.C_idcita.getText());
            int id_pac = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 4).toString());
            int id_ser = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 6).toString());
            int id_med = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 8).toString());
            int id_con = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 10).toString());
            int id_sec = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 12).toString());
            String fecha = (vista.T_solicitadas.getValueAt(i, 13).toString());
            LocalDate fecha_cita = null;
            String fech[] = fecha.split("-");
            LocalDate fechas = LocalDate.of((Integer.parseInt(fech[0])), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
            fecha_cita = fechas;
            String horaselecionada = vista.T_solicitadas.getValueAt(i, 14).toString();
            int idf = Integer.parseInt(vista.N_factura.getText());

            c.setId_paciente(id_pac);
            c.setId_servicio(id_ser);
            c.setId_veterinario(id_med);
            c.setId_consultorio(id_con);
            c.setId_secretaria(id_sec);
            c.setFecha(fecha_cita);
            c.setHora_ini(horaselecionada);
            c.setId_factura(idf);
            mensaje = cibo.agregarCBO(c);

        }
        System.out.println("" + mensaje);
    }

    public boolean validarhora() {
        vista.h_f_rango.setVisible(true);
        boolean conf = true;
        //extraemos el intervalo de horas de combo
        String rangohora = vista.C_combohoras.getSelectedItem().toString();
        String[] horas = rangohora.split(" ");
        String hinicial = horas[0];
        String hfinal = horas[2];

        String[] hinicial1 = hinicial.split(":");
        int hora1 = Integer.parseInt(hinicial1[0]);
        int minu1 = Integer.parseInt(hinicial1[1]);

        String[] hfinal1 = hfinal.split(":");
        int hora2 = Integer.parseInt(hfinal1[0]);
        int minu2 = Integer.parseInt(hfinal1[1]);

        //extraemos la hora del spiner
        String horaselecionada = vista.C_hora.getValue().toString();
        String[] datos = horaselecionada.split(" ");
        String horaspiner = datos[3];
        String[] horaselec = horaspiner.split(":");
        int hselec = Integer.parseInt(horaselec[0]);
        int mselec = Integer.parseInt(horaselec[1]);

        //vaidamos que la hora este dentro del rango seleccionado     
        vista.h_f_rango.setText("*Selecionar dentro del rango");
        if ((hora1 <= hselec) && (hselec <= hora2)) {
            if (hora1 == hselec) {
                if (minu1 <= mselec) {
                    vista.h_f_rango.setVisible(false);
                    conf = true;
                } else {
                    vista.h_f_rango.setVisible(true);
                    conf = false;
                }
            } else if (hora2 == hselec) {
                if (minu2 > mselec) {
                    vista.h_f_rango.setVisible(false);
                    conf = true;
                } else {
                    vista.h_f_rango.setVisible(true);
                    conf = false;
                }
            } else {
                conf = true;
                vista.h_f_rango.setVisible(false);
            }
        } else {
            vista.h_f_rango.setVisible(true);
            conf = false;
        }
        //validamos si la hora esta disponible, osea que no haya una cita en la misma hora
        if (conf == true) {
            String horavf = "" + hselec + ":" + mselec + "";
            LocalDate fecha = fecha_cita();
            String f = fecha.toString();
            String[] fe = f.split("-");

            int id = Integer.parseInt(vista.Cid_med.getText());
            String h1 = horaselec[0] + ":" + horaselec[1];
            String fechas = fe[2] + "/" + fe[1] + "/" + fe[0];
            int numv = cibo.verificarhoraBO(id, h1, fechas);
            if (numv > 0) {
                vista.h_f_rango.setText("Hora no disponible");
                vista.h_f_rango.setVisible(true);
                conf = false;
            } else {
                conf = true;
                vista.h_f_rango.setVisible(false);
            }
            return conf;
        } else {
            conf = false;
            vista.h_f_rango.setVisible(true);
            return conf;
        }
    }

    public void validarNulos() {
        if (vista.C_idcita.equals("")) {

        }
    }

    void limpiarDatos_cita(int num) {
        vista.C_idcita.setText("");
        if (num == 1) {
            vista.Cid_dueño.setText("");
            vista.C_ceddueño.setText("");
            vista.C_nomdueño.setText("");
            vista.Cid_paciente.setText("");
            vista.C_nompaciente.setText("");
        }
        texc.B_datos_ext.setText("");
        vista.Cid_serv.setText("");
        vista.Cid_med.setText("");
        vista.Cid_consul.setText("");
        vista.C_nomconsultorio.setText("");
        vista.C_nomservicio.setSelectedIndex(0);
        vista.C_nomveteri.removeAllItems();
        vista.C_fecha.setDate(null);
        vista.C_combohoras.removeAllItems();
        vista.C_hora.setEnabled(false);
        vista.h_f_rango.setVisible(false);

    }

    public void limpiarF() {
        vistaF.F_Telef.setText("");
        vistaF.F_ced.setText("");
        vistaF.F_coreo.setText("");
        vistaF.F_direc.setText("");
        vistaF.F_id.setText("");
        vistaF.F_idp.setText("");
        vistaF.F_nom.setText("");
        vistaF.F_total.setText("");
    }
//CARGAMOS EN EL COMBO LOS HORARIOS DE ATENCION DEL VETERINARIO SEGUN LA FECHA

    public void horasatencion(int idm, String dia) {

        cibo.horasatencionBO(vista.C_combohoras, idm, dia);

    }
//EXTRAEMOS LOS DATOS DEL DUEÑO Y SU MASCOTA QUE ESTAN EN LA TABLA 

    public void TraerDatosDosClick(JTable tabla) {
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent ex) {
                if (ex.getClickCount() == 2) {
                    int fila = tabla.getSelectedRow();

                    if (fila >= 0) {
                        vista.Cid_dueño.setText(String.valueOf(tabla.getValueAt(fila, 0)));
                        vista.C_ceddueño.setText(String.valueOf(tabla.getValueAt(fila, 1)));
                        vista.C_nomdueño.setText(String.valueOf(tabla.getValueAt(fila, 2)));
                        vista.Cid_paciente.setText(String.valueOf(tabla.getValueAt(fila, 3)));
                        vista.C_nompaciente.setText(String.valueOf(tabla.getValueAt(fila, 5)));

                        texc.dispose();
                    } else {
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);
                        JOptionPane.showMessageDialog(null, "No selecciono fila");
                    }
                }
            }
        });
    }
//EXTRAEMOS EL DIA DE LA FECHA SELECIONADA

    public String extraerdia(String fecha) {
        String diai = "";
        String dia = "";
        String[] datos = fecha.split(" ");
        diai = (datos[0]);
        if (null != diai) {
            switch (diai) {
                case "Mon":
                    dia = "Lunes";
                    break;
                case "Tue":
                    dia = "Martes";
                    break;
                case "Wed":
                    dia = "Miércoles";
                    break;
                case "Thu":
                    dia = "Jueves";
                    break;
                case "Fri":
                    dia = "Viernes";
                    break;
                case "Sat":
                    dia = "Sabado";
                    break;
                case "Sun":
                    dia = "Domingo";
                    break;
            }
        }
        return dia;
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
//EXTRAEMOS LA FECHA DEL DATE CHOOSER

    public LocalDate fecha_cita() {

        LocalDate fecha_cita = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechemi = formato.format(vista.C_fecha.getDate());
        String fech[] = fechemi.split("-");
        LocalDate fechas = LocalDate.of((Integer.parseInt(fech[0])), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_cita = fechas;
        return fecha_cita;
    }

//CARGAMOS EL COMBOBOX CON LOS SERVICIOS DISPONIBLES
    public void mostrarservicios() {
        cibo.mostrarserviciosBO(vista.C_nomservicio);
    }
//MOSTRAMOS EL NOMBRE DEL  VETERINARIO QUE DA EL SERVICIO SELECIONADO

    public void mostrarveterinario(String servicio) {
        if (servicio == "SELECCIONAR") {
            vista.C_fecha.setDate(null);
            vista.C_nomveteri.removeAllItems();
            vista.C_combohoras.removeAllItems();
            vista.Cid_consul.setText("");
            vista.C_nomconsultorio.setText("");
            vista.C_fecha.setEnabled(false);

        } else {
            vista.C_combohoras.removeAllItems();
            int id = cibo.mostraridservicioBO(servicio);
            vista.Cid_serv.setText("" + id);
            if (vista.Cid_serv.getText() == "") {

            } else {
                cibo.mostrarveterinarioBO(vista.C_nomveteri, servicio);
                escojerveteri();
            }
        }
    }
//MOSTRAMOS EL CONSULTORIO DEL VETERINARIO SELECCIONADO

    public void mostraridvyConsultorio(String nomv) {
        if (nomv == "SELECCIONAR") {
            vista.Cid_med.setText("");
            vista.Cid_consul.setText("");
            vista.C_nomconsultorio.setText("");
            vista.C_fecha.setEnabled(false);
            vista.C_combohoras.removeAllItems();
        } else {
            vista.C_combohoras.removeAllItems();
            int ids = Integer.parseInt(vista.Cid_serv.getText());
            int idv = cibo.mostraridveteriBO(ids, nomv);
            vista.Cid_med.setText("" + idv);
            String[] datosconsultorio = new String[3];
            datosconsultorio = cibo.mostraridnomconsutorioBO(idv);
            vista.Cid_consul.setText(datosconsultorio[0]);
            vista.C_nomconsultorio.setText(datosconsultorio[1]);
            vista.C_combohoras.removeAllItems();
            vista.C_fecha.setEnabled(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    //primer metodo por defecto para el combobox SERVICIOS
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            String servicio = vista.C_nomservicio.getSelectedItem().toString();
            mostrarveterinario(servicio);
        }
    }

    public void buscarservicio() {
        vista.C_nomservicio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    String servicio = vista.C_nomservicio.getSelectedItem().toString();
                    mostrarveterinario(servicio);
                }
            }
        });
    }

    //metodo para el segundo combobox VETERINARIOS
    public void escojerveteri() {
        vista.C_nomveteri.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String nomv = vista.C_nomveteri.getSelectedItem().toString();
                    vista.C_fecha.setDate(null);
                    mostraridvyConsultorio(nomv);

                }
            }
        });
    }

    public void buscarveterinario() {
        vista.C_nomveteri.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
                    String nomv = vista.C_nomveteri.getSelectedItem().toString();
                    vista.C_fecha.setDate(null);
                    mostraridvyConsultorio(nomv);
                }
            }
        });
    }

    //metodo para elegir el horario de atencion del combobox
    public void escojerhorario() {
        vista.C_combohoras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt2) {
                if (evt2.getStateChange() == ItemEvent.SELECTED) {
                    String horario = vista.C_combohoras.getSelectedItem().toString();
                    rangosSpiners(horario);

                }
            }
        });
    }
//METODO DE VALIDAR LA HORA SEGUN CAMBIE EL DATO DEL SPINER

    public void validarHora() {
        vista.C_hora.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (evt.getSource() == vista.C_hora) {
                    validarhora();
                }

            }
        });
    }
//AGREGAMOS LOS RANGOS DEL SPINER

    public void rangosSpiners(String horario) {
        if (horario == "Selecionar Horario") {
            vista.C_hora.setEnabled(false);

        } else {
            vista.C_hora.setEnabled(true);
            String[] horas = horario.split(" ");
            String hinicial = horas[0];
            String hfinal = horas[2];
            String horae = hinicial + ":01";

            try {
                ((JSpinner.DefaultEditor) vista.C_hora.getEditor()).getTextField().setEditable(false);
                SimpleDateFormat ssf = new SimpleDateFormat("HH:mm:ss");
                java.util.Date hora = ssf.parse(horae);
                SpinnerDateModel sm = new SpinnerDateModel(hora, null, null, Calendar.HOUR_OF_DAY);
                vista.C_hora.setModel(sm);
                JSpinner.DateEditor de = new JSpinner.DateEditor(vista.C_hora, "HH:mm:ss");
                vista.C_hora.setEditor(de);
                validarhora();
            } catch (Exception e) {
                System.out.println("errror espiner ");
            }
        }
    }
//AGREGAMOS LA CITA REALIZADA A LA TABLA 

    public void lista_citas() {
        String[] columnas = {"ID", "ID_DUEÑO", "CEDULA_DUEÑO", "NOMBRE_DUEÑO", "ID_PACIENTE", "PACIENTE", "ID_SERVICIO", "SERVICIO", "ID_VETERINARIO", "VETERINARIO", "ID_CONSULTORIO", "CONSULTORIO", "ID_SECRETARIA", "FECHA", "HORA"};
        modeloLista.setColumnIdentifiers(columnas);
        vista.T_solicitadas.setModel(modeloLista);

        int id = 1;
        int idp = Integer.parseInt(vista.Cid_paciente.getText());
        String nomp = vista.C_nompaciente.getText();
        int idd = Integer.parseInt(vista.Cid_dueño.getText());
        String cedd = vista.C_ceddueño.getText();
        String nomd = vista.C_nomdueño.getText();
        int ids = Integer.parseInt(vista.Cid_serv.getText());
        String noms = vista.C_nomservicio.getSelectedItem().toString();
        int idv = Integer.parseInt(vista.Cid_med.getText());
        String nomv = vista.C_nomveteri.getSelectedItem().toString();
        int idc = Integer.parseInt(vista.Cid_consul.getText());
        String nomc = vista.C_nomconsultorio.getText();
        int idse = Integer.parseInt(vista.id_secretaria.getText());
        LocalDate fecha = fecha_cita();
        String f = fecha.toString();
        String[] fe = f.split("-");
        String fechas = fe[2] + "/" + fe[1] + "/" + fe[0];
        String horaselecionada = vista.C_hora.getValue().toString();
        String[] datosH = horaselecionada.split(" ");
        String horaspiner = datosH[3];
        String[] horaselec = horaspiner.split(":");
        String h1 = horaselec[0] + ":" + horaselec[1];

        ArrayList listac = new ArrayList();
        listac.add(id);
        listac.add(idd);
        listac.add(cedd);
        listac.add(nomd);
        listac.add(idp);
        listac.add(nomp);
        listac.add(ids);
        listac.add(noms);
        listac.add(idv);
        listac.add(nomv);
        listac.add(idc);
        listac.add(nomc);
        listac.add(idse);
        listac.add(fecha);
        listac.add(h1);

        Object[] datos = new Object[15];

        datos[0] = listac.get(0);
        datos[1] = listac.get(1);
        datos[2] = listac.get(2);
        datos[3] = listac.get(3);
        datos[4] = listac.get(4);
        datos[5] = listac.get(5);
        datos[6] = listac.get(6);
        datos[7] = listac.get(7);
        datos[8] = listac.get(8);
        datos[9] = listac.get(9);
        datos[10] = listac.get(10);
        datos[11] = listac.get(11);
        datos[12] = listac.get(12);
        datos[13] = listac.get(13);
        datos[14] = listac.get(14);

        modeloLista.addRow(datos);

        vista.T_solicitadas.setModel(modeloLista);
        desactivarcolumnas();
    }
//OCULTAMOS CIERTOS CAMPOS DE LA TABLA INNESESARIOS PARA EL USUARIO

    public void desactivarcolumnas() {
        vista.T_solicitadas.getColumnModel().getColumn(0).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(0).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(0).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(1).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(1).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(1).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(2).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(2).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(2).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(3).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(3).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(3).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(4).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(4).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(4).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(6).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(6).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(6).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(8).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(8).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(8).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(10).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(10).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(10).setPreferredWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(12).setMaxWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(12).setMinWidth(0);
        vista.T_solicitadas.getColumnModel().getColumn(12).setPreferredWidth(0);
    }
//PASAMOS LOS DATOS A LA TABLA DE FACTURA

    public void pasarDatos() {
        for (int i = 0; i < vista.T_solicitadas.getRowCount(); i++) {
            Object[] datos = new Object[2];
            int ids = Integer.parseInt(vista.T_solicitadas.getValueAt(i, 6).toString());
            String costo = cibo.traerprecioBO(ids);
            datos[0] = vista.T_solicitadas.getValueAt(i, 7).toString();
            datos[1] = costo;
            modelof.addRow(datos);
        }
    }
    
   public void bloqdatosf(){
       vistaF.F_ced.setEditable(false);
       vistaF.F_nom.setEditable(false);
       vistaF.F_Telef.setEditable(false);
       vistaF.F_coreo.setEditable(false);
       vistaF.F_direc.setEditable(false);
       vistaF.F_id.setEditable(false);
       vistaF.F_idp.setEditable(false);
       vistaF.F_total.setEditable(false);
       
   }
//AGREGAMOS UN MODELO PARA LA TABLA DE FACTURA

    public void modelarcolumnas() {
        modelof = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };
        modelof.addColumn("SERVICIO");
        modelof.addColumn("COSTO");

        vistaF.T_factura.setModel(modelof);

    }

//LIMPIAMOS LA TABLA DE LISTA DE CITAS
    public void vaciart() {
        DefaultTableModel dm = (DefaultTableModel) vista.T_solicitadas.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
//LIMPIAMOS LA TABLA DE FACTURA

    public void vaciarTF() {
        DefaultTableModel dm = (DefaultTableModel) vistaF.T_factura.getModel();
        int rowCount = dm.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            dm.removeRow(i);
        }
    }
//PASAMOS LOS DATOS DEL PROPIETARIO AL FRAME DE FACTURA

    public void datospropietario() {
        Persona pfactura = new Persona();
        vistaF.F_ced.setText(vista.C_ceddueño.getText());
        vistaF.F_nom.setText(vista.C_nomdueño.getText());
        vistaF.F_idp.setText(vista.Cid_dueño.getText());
        int idd = Integer.parseInt(vista.Cid_dueño.getText());
        pfactura = cibo.datosdueñoBO(idd);
        vistaF.F_Telef.setText(pfactura.getTelefono());
        vistaF.F_coreo.setText(pfactura.getCorreo());
        vistaF.F_direc.setText(pfactura.getDireccion());
    }
//CALCULAMOS EL COSTO DE LAS CITAS REALIZADAS

    public void calcularCosto() {
        total = 0;
        preu = 0;
        for (int i = 0; i < vistaF.T_factura.getRowCount(); i++) {
            preu = Double.parseDouble(vistaF.T_factura.getValueAt(i, 1).toString());
            total = total + preu;

        }
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        vistaF.F_total.setText(String.valueOf(formato1.format(total)));
    }
//GUARDAMOS LA FACTURA

    public void guardarFactura() {
        CFactura fact = new CFactura();
        DecimalFormat formato = new DecimalFormat("#.##");
        int ID_FACTURA = Integer.parseInt(vistaF.F_id.getText());
        int ID_PROPIETARIO = Integer.parseInt(vistaF.F_idp.getText());
        String fecha = vista.F_fecha.getFecha();
        LocalDate fecha_factura = null;
        String fech[] = fecha.split("/");
        LocalDate fechas = LocalDate.of((Integer.parseInt(fech[2])), Integer.parseInt(fech[1]), Integer.parseInt(fech[0]));
        fecha_factura = fechas;
        double TOTAL = Double.parseDouble(vistaF.F_total.getText());
        formato.format(TOTAL);

        fact.setID_FACTURA(ID_FACTURA);
        fact.setID_PROPIETARIO(ID_PROPIETARIO);
        fact.setFECHA(fecha_factura);
        fact.setTOTAL(TOTAL);
        cibo.agregarFacturaBO(fact);
    }
//EDITAMOS LOS DATOS DE LAS CITAS ANTES DE GUARDAR

    public void Editardatos() {
        int fila = vista.T_solicitadas.getSelectedRow();

        if (fila >= 0) {
            vista.Cid_dueño.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 1)));
            vista.C_ceddueño.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 2)));
            vista.C_nomdueño.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 3)));
            vista.Cid_paciente.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 4)));
            vista.C_nompaciente.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 5)));
            vista.Cid_serv.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 6)));
            String servicio = String.valueOf(vista.T_solicitadas.getValueAt(fila, 7));
            vista.C_nomservicio.setSelectedItem(servicio);
            mostrarveterinario(servicio);
            vista.Cid_med.setText(String.valueOf(vista.T_solicitadas.getValueAt(fila, 8)));
            String veterinario = String.valueOf(vista.T_solicitadas.getValueAt(fila, 9));
            vista.C_nomveteri.setSelectedItem(veterinario);
            mostraridvyConsultorio(veterinario);
            String fecha = String.valueOf(vista.T_solicitadas.getValueAt(fila, 13));
            vista.Panel_lista.setVisible(false);
            vista.Cb_vlista.setVisible(true);
            vista.Registroc.setVisible(true);
            vista.Volver.setVisible(false);
            vista.Cb_generarf.setVisible(false);
            vista.limpiarrr.setVisible(true);
            vista.Bot_Limpiar.setVisible(true);
            vista.Cb_registrar.setVisible(false);
        } else {
            UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
            JOptionPane.showMessageDialog(null, "No selecciono fila");
        }
    }
//METODO PARA PASAR UN STRING A DATE *NO FUNCIONA

    public static Date ParseFecha(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDate = null;
        try {
            fechaDate = (Date) formato.parse(fecha);
        } catch (ParseException ex) {
            System.out.println(ex);
        }
        return fechaDate;
    }
//ACTUALIZAMOS LOS DATOS DE LA CITA SELECCIONADA

    public void actualizar() {
        Object[] objectnu = new Object[15];

        int id = 1;
        int idp = Integer.parseInt(vista.Cid_paciente.getText());
        String nomp = vista.C_nompaciente.getText();
        int idd = Integer.parseInt(vista.Cid_dueño.getText());
        String cedd = vista.C_ceddueño.getText();
        String nomd = vista.C_nomdueño.getText();
        int ids = Integer.parseInt(vista.Cid_serv.getText());
        String noms = vista.C_nomservicio.getSelectedItem().toString();
        int idv = Integer.parseInt(vista.Cid_med.getText());
        String nomv = vista.C_nomveteri.getSelectedItem().toString();
        int idc = Integer.parseInt(vista.Cid_consul.getText());
        String nomc = vista.C_nomconsultorio.getText();
        int idse = Integer.parseInt(vista.id_secretaria.getText());
        LocalDate fecha = fecha_cita();

        String horaselecionada = vista.C_hora.getValue().toString();
        String[] datosH = horaselecionada.split(" ");
        String horaspiner = datosH[3];
        String[] horaselec = horaspiner.split(":");
        String h1 = horaselec[0] + ":" + horaselec[1];

        objectnu[0] = id;
        objectnu[1] = idd;
        objectnu[2] = cedd;
        objectnu[3] = nomd;
        objectnu[4] = idp;
        objectnu[5] = nomp;
        objectnu[6] = ids;
        objectnu[7] = noms;
        objectnu[8] = idv;
        objectnu[9] = nomv;
        objectnu[10] = idc;
        objectnu[11] = nomc;
        objectnu[12] = idse;
        objectnu[13] = fecha;
        objectnu[14] = h1;

        for (int i = 0; i < 15; i++) {
            modeloLista.setValueAt(objectnu[i], vista.T_solicitadas.getSelectedRow(), i);
        }
        UIManager UI = new UIManager();
        UI.put("OptionPane.background", Color.white);
        UI.put("Panel.background", Color.white);
        JOptionPane.showMessageDialog(null, "Cita actualizada exitozamente");
        vista.Registroc.setVisible(false);
        vista.Panel_lista.setVisible(true);
        vista.Cb_vlista.setVisible(false);
        vista.Volver.setVisible(true);
        vista.Cb_generarf.setVisible(true);
        vista.limpiarrr.setVisible(false);
        vista.Bot_Limpiar.setVisible(false);
        vista.Cb_registrar.setVisible(true);
    }

    public int datosdetabla() {
        int numf = 0;
        for (int i = 0; i <= vista.T_solicitadas.getRowCount(); i++) {
            numf = i;
        }
        return numf;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }

//METODOS DE SELECIONAR UNA FECHA DEL CALENDARIO
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mostraroras();
    }

    public void mostraroras() {
        if (vista.C_fecha.getDate() == null) {
        } else {
            java.util.Date dat = new java.util.Date();//Instancia la fecha del sistema

            if (vista.C_fecha.getDate().getTime() <= dat.getTime()) {//Compara si la fecha seleccionada es menor o igual a la fecha actual
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No se ha completado la operación, Fecha Infrige a la fecha Actual", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
                vista.C_combohoras.removeAllItems();
            } else {
                String dia;
                String fecha = String.valueOf(vista.C_fecha.getDate().toString());
                dia = extraerdia(fecha);
                int idmedico = Integer.parseInt(vista.Cid_med.getText());
                horasatencion(idmedico, dia);
            }
        }
    }

    //ICONO JOPTIONPANE PERSONALIZABLE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

}
