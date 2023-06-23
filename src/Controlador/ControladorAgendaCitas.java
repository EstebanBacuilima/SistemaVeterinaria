package Controlador;

import Modelo.AgendaCitasBO;
import Modelo.AgendaCitasDAO;
import Modelo.CitaBO;
import Vista.AgendaCitas;
import Vista.MenuPrincipal;
import Vista.RegistroCitas;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static java.text.DateFormat.*;
import java.util.Locale;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

public class ControladorAgendaCitas implements ActionListener, ItemListener, ChangeListener, PropertyChangeListener {

    AgendaCitasBO acbo = new AgendaCitasBO();
    AgendaCitas vista = new AgendaCitas();
    CitaBO cibo = new CitaBO();
    //
    MenuPrincipal vistaMenu = new MenuPrincipal();
    java.sql.Date fechaactual = new java.sql.Date(System.currentTimeMillis());
    SimpleDateFormat dates = new SimpleDateFormat("dd-mm-yyyy");

    public ControladorAgendaCitas(AgendaCitas vista) {
        this.vista = vista;
        this.vista.prueba.addActionListener(this);
        this.vista.B_Proximas.addActionListener(this);
        this.vista.B_Canceladas.addActionListener(this);
        this.vista.B_atendidas.addActionListener(this);
        this.vista.B_todas.addActionListener(this);
        this.vista.B_cancelarcita.addActionListener(this);
        this.vista.B_citaatendida.addActionListener(this);
        this.vista.B_Reagendarcita.addActionListener(this);
        this.vista.Confirmar.addActionListener(this);
        this.vista.Cancelar_r.addActionListener(this);
        this.vista.C_hora.addChangeListener(this);
        this.vista.B_actuales.addActionListener(this);
        this.vista.C_fecha.addPropertyChangeListener(this);
        vista.B_Reagendarcita.setVisible(false);
        vista.B_cancelarcita.setVisible(false);
        vista.B_citaatendida.setVisible(false);
        vista.Panel_reagendar.setVisible(false);

        escojerhorario();
        validarHora();
        //inciarDatos();
        vista.Tipo_emp.setVisible(false);
        vista.prueba.setVisible(false);
        vista.Id_Personal.setVisible(false);
    }

    public void inciar() {
        
        vista.setLocationRelativeTo(null);
        vista.B_Reagendarcita.setVisible(false);
        vista.B_cancelarcita.setVisible(false);
        vista.B_citaatendida.setVisible(false);
        vista.Panel_reagendar.setVisible(false);
        vista.h_f_rango.setVisible(false);

        escojerhorario();
        validarHora();
        
        vista.Id_cita.setVisible(false);
        
    }
    
//    public void inciarDatos() {
//        
//        String Templ = vista.Tipo_emp.getText();
//        String Id_personal = vista.Id_Personal.getText();
//        ContarCitas(Templ);
//        vista.Tipo_emp.setVisible(false);
//        vista.prueba.setVisible(false);
//        vista.Id_Personal.setVisible(false);
//        
//    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.prueba) {
            String Templ = vista.Tipo_emp.getText();
            String Id_personal = vista.Id_Personal.getText();
            ContarCitas(Templ);
            vista.B_cancelarcita.setVisible(false);
        }
        if (e.getSource() == vista.B_actuales) {
            mostrarCitas("H");
            activarBotones();
        }
        if (e.getSource() == vista.B_Proximas) {
            mostrarCitas("P");
            activarBotones();
        }
        if (e.getSource() == vista.B_Canceladas) {
            mostrarCitas("C");
            String templ = vista.Tipo_emp.getText();
            if ("Secretaria".equals(templ)) {
                vista.B_Reagendarcita.setVisible(true);
                vista.B_cancelarcita.setVisible(false);
                vista.B_citaatendida.setVisible(false);

            } else {
                vista.B_Reagendarcita.setVisible(false);
                vista.B_cancelarcita.setVisible(false);
                vista.B_citaatendida.setVisible(false);
            }
        }
        if (e.getSource() == vista.B_atendidas) {;
            mostrarCitas("A");
            desactivarBotones();
        }
        if (e.getSource() == vista.B_todas) {
            mostrarCitas("T");
            desactivarBotones();
        }
        if (e.getSource() == vista.B_cancelarcita) {
            int fila = vista.T_agendac.getSelectedRow();
            int idci = 0;
            if (fila == -1) {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                idci = Integer.parseInt((String) vista.T_agendac.getValueAt(fila, 0).toString());
                cancelarCita(idci);
            }
        }
        if (e.getSource() == vista.B_citaatendida) {
            int fila = vista.T_agendac.getSelectedRow();
            int idci = 0;
            if (fila == -1) {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
            } else {
                idci = Integer.parseInt((String) vista.T_agendac.getValueAt(fila, 0).toString());
                atenderCita(idci);
            }
        }
        if (e.getSource() == vista.B_Reagendarcita) {
            activareagenda(1);
            int fila = vista.T_agendac.getSelectedRow();
            if (fila >= 0) {
                vista.Id_cita.setText(String.valueOf(vista.T_agendac.getValueAt(fila, 0)));
            } else {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "No selecciono fila");
            }
        }

        if (e.getSource() == vista.Confirmar) {
            if (vista.C_fecha.getDate() == null) {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Debe selecionar una fecha");
            } else if (vista.C_combohoras.getSelectedItem() == "Seleccionar Horario") {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Debe selecionar un Horario");
            } else if (validarhora() == true) {
                reagendarCita();
                vista.C_fecha.setDate(null);
                vista.C_combohoras.removeAllItems();
            } else {
                UIManager UI = new UIManager();
            UI.put("OptionPane.background", Color.white);
            UI.put("Panel.background", Color.white);
                JOptionPane.showMessageDialog(null, "Selecione la hora correctamente ");
            }

        }
        if (e.getSource() == vista.Cancelar_r) {
            activareagenda(2);
            String templ = vista.Tipo_emp.getText();
            mostrarCitas("P");
            ContarCitas(templ);
            vista.C_fecha.setDate(null);
            vista.C_combohoras.removeAllItems();
            vista.h_f_rango.setVisible(false);
        }
    }

    public void ContarCitas(String templ) {

        String fechaHoy = "ss";
        int id = Integer.parseInt(vista.Id_Personal.getText());
        this.vista.B_actuales.setText("HOY (" + acbo.ContarcitasBO("H", id, templ, fechaHoy) + ")");
        this.vista.B_Proximas.setText("Proximas (" + acbo.ContarcitasBO("P", id, templ, fechaHoy) + ")");
        this.vista.B_Canceladas.setText("Canceladas (" + acbo.ContarcitasBO("C", id, templ, fechaHoy) + ")");
        this.vista.B_atendidas.setText("Atendidas (" + acbo.ContarcitasBO("A", id, templ, fechaHoy) + ")");
        this.vista.B_todas.setText("Todas (" + acbo.ContarcitasBO("T", id, templ, fechaHoy) + ")");
    }

    public void mostrarCitas(String estado) {
        String fecha = vista.F_fecha.getFecha();
        //System.out.println("ff " + fecha);
        Date myDate = new Date(fecha);
        //Aquí obtienes el formato que deseas
        //System.out.println(new SimpleDateFormat("MM/dd/yyyy").format(myDate));
        String fechaHoy = new SimpleDateFormat("MM/dd/yyyy").format(myDate);
        int id = Integer.parseInt(vista.Id_Personal.getText());
        String templ = vista.Tipo_emp.getText();
        acbo.mostrarCitasBO(vista.T_agendac, estado, id, templ, fechaHoy);
    }

    public void cancelarCita(int idcita) {
        acbo.cancelarCitaBO(idcita);
        String templ = vista.Tipo_emp.getText();
        mostrarCitas("P");
        ContarCitas(templ);
    }

    public void atenderCita(int idcita) {
        acbo.atenderCitaBO(idcita);
        String templ = vista.Tipo_emp.getText();
        mostrarCitas("P");
        ContarCitas(templ);
    }

    public void reagendarCita() {
        int id = Integer.parseInt(vista.Id_cita.getText());
        LocalDate f = fecha_cita();
        String fe = f.toString();
        String[] fec = fe.split("-");
        String fecha = fec[2] + "/" + fec[1] + "/" + fec[0];

        String horaselecionada = vista.C_hora.getValue().toString();
        String[] datos = horaselecionada.split(" ");
        String horaspiner = datos[3];
        String[] horaselec = horaspiner.split(":");
        String h1 = horaselec[0] + ":" + horaselec[1];

        acbo.reagendarCitaBO(id, fecha, h1);
        activareagenda(2);
        String templ = vista.Tipo_emp.getText();
        mostrarCitas("P");
        ContarCitas(templ);

    }

    public void activareagenda(int num) {
        if (num == 1) {
            vista.Panel_reagendar.setVisible(true);
            vista.B_Canceladas.setVisible(false);
            vista.B_Proximas.setVisible(false);
            vista.B_atendidas.setVisible(false);
            vista.B_todas.setVisible(false);
            vista.B_actuales.setVisible(false);
        } else if (num == 2) {
            vista.Panel_reagendar.setVisible(false);
            vista.B_Canceladas.setVisible(true);
            vista.B_Proximas.setVisible(true);
            vista.B_atendidas.setVisible(true);
            vista.B_todas.setVisible(true);
            vista.B_actuales.setVisible(true);
        }
    }

    public void horasatencion(int idm, String dia) {

        acbo.horasatencionBO(vista.C_combohoras, idm, dia);

    }

    public void activarBotones() {
        String templ = vista.Tipo_emp.getText();
        if ("Secretaria".equals(templ)) {
            vista.B_Reagendarcita.setVisible(true);
            vista.B_cancelarcita.setVisible(true);
            vista.B_citaatendida.setVisible(false);
        } else {
            vista.B_Reagendarcita.setVisible(false);
            vista.B_cancelarcita.setVisible(false);
            vista.B_citaatendida.setVisible(true);
        }
    }

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
                    dia = "Miercoles";
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

    public void escojerhorario() {
        vista.C_combohoras.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt2) {
                if (evt2.getStateChange() == ItemEvent.SELECTED) {
                    String horario = vista.C_combohoras.getSelectedItem().toString();
                    rangosSpiners(horario);

                }
            }
        });
    }

    public void rangosSpiners(String horario) {
        if (horario == "Selecionar Horario") {

        } else {
            String[] horas = horario.split(" ");
            String hinicial = horas[0];
            String horae = hinicial + ":01";

            try {
                SimpleDateFormat ssf = new SimpleDateFormat("HH:mm:ss");
                java.util.Date hora = ssf.parse(horae);
                SpinnerDateModel sm = new SpinnerDateModel(hora, null, null, Calendar.HOUR_OF_DAY);
                vista.C_hora.setModel(sm);
                JSpinner.DateEditor de = new JSpinner.DateEditor(vista.C_hora, "HH:mm:ss");
                vista.C_hora.setEditor(de);
                validarhora();
            } catch (Exception e) {
            }
        }
    }

    public void validarHora() {
        vista.C_hora.addChangeListener(new javax.swing.event.ChangeListener() {
            @Override
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                if (evt.getSource() == vista.C_hora) {
                    validarhora();
                }

            }
        });
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
        //confirmar si no existe esa hora elegida en la base de datos 
        if (conf == true) {
            String horavf = "" + hselec + ":" + mselec + "";
            LocalDate fecha = fecha_cita();
            String f = fecha.toString();
            String[] fe = f.split("-");

            String h1 = horaselec[0] + ":" + horaselec[1];
            String fechas = fe[2] + "/" + fe[1] + "/" + fe[0];
            int idc = Integer.parseInt(vista.Id_cita.getText());
            int idmedico = acbo.extraeridmedicoBO(idc);
            int numv = cibo.verificarhoraBO(idmedico, h1, fechas);
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

    public LocalDate fecha_cita() {

        LocalDate fecha_cita = null;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechemi = formato.format(vista.C_fecha.getDate());
        String fech[] = fechemi.split("-");
        LocalDate fechas = LocalDate.of((Integer.parseInt(fech[0])), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
        fecha_cita = fechas;
        return fecha_cita;
    }

    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    public void desactivarBotones() {
        vista.B_Reagendarcita.setVisible(false);
        vista.B_cancelarcita.setVisible(false);
        vista.B_citaatendida.setVisible(false);
        //vista.B_actuales.setVisible(false);
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
                int idc = Integer.parseInt(vista.Id_cita.getText());
                int idmedico = acbo.extraeridmedicoBO(idc);
                horasatencion(idmedico, dia);
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
    }

    @Override
    public void stateChanged(ChangeEvent e) {
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        mostraroras();
    }
}
