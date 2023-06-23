package Controlador;

import Modelo.Auxiliar;
import Modelo.AuxiliarBO;
import Modelo.HistorialBO;
import Modelo.HistorialDAO;
import Modelo.Medico;
import Modelo.MedicoBO;
import Modelo.Mascota;
import Modelo.MascotaBO;
import Modelo.Propietario;
import Modelo.PropietaroBO;
import Modelo.Secretaria;
import Modelo.SecretariaBO;
import Vista.HistorialEmpleadosActivos;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class ControladorHistorialActivos implements ActionListener, ItemListener {

    ArrayList<Medico> listaMedico = new ArrayList<>();
    ArrayList<Auxiliar> listaAuxiliar = new ArrayList<>();
    ArrayList<Secretaria> listaSecretaria = new ArrayList<>();
    ArrayList<Propietario> listaPropietario = new ArrayList<>();
    ArrayList<Mascota> listaPaciente = new ArrayList<>();

    UIManager UI;
    HistorialEmpleadosActivos vista = new HistorialEmpleadosActivos();
    HistorialBO modeloH = new HistorialBO();
    HistorialDAO modeloHD = new HistorialDAO();

    Connection con;

    // reportes
    private MascotaBO modeloBOPaciente = new MascotaBO();
    private PropietaroBO modeloBOPropie = new PropietaroBO();
    private SecretariaBO modeloBOSecre = new SecretariaBO();
    private MedicoBO modeloBOMed = new MedicoBO();
    private AuxiliarBO modeloBOAux = new AuxiliarBO();

    public ControladorHistorialActivos(HistorialEmpleadosActivos vista) {
        this.vista = vista;
        this.vista.Bot_Regresar_Repo.addActionListener(this);
        this.vista.comboFiltro.addItemListener(this);
        this.vista.Bot_RepBuscar.addActionListener(this);
        this.vista.Restaurar.addActionListener(this);
        this.vista.Restaurar1.addActionListener(this);
        this.vista.Generar_Rep_Mascota.addActionListener(this);
        this.vista.CheckElimimados.addActionListener(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
    }

    private void limpiar() {
        VaciarTabla();
        vista.txtBuscar.setText("");
    }

    private void VaciarTabla() {
        DefaultTableModel model = (DefaultTableModel) vista.Tablas_Historial.getModel();
        model.setRowCount(0);
        model.setColumnCount(0);
    }

    // Vaidar Datos Vacios
    public int datosdetabla() {
        int numf = 0;
        for (int i = 0; i <= vista.Tablas_Historial.getRowCount(); i++) {
            numf = i;
        }
        return numf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Generar_Rep_Mascota) {

            if (datosdetabla() == 0) {
                JOptionPane.showMessageDialog(null, "No se puede Generar un reporte Vacio");
            } else {

                switch (vista.comboFiltro.getSelectedIndex()) {
                    case 5:
                        if (vista.CheckElimimados.isSelected()) {
                            modeloBOPaciente.ReportePacienteeliminados(vista.Generar_Rep_Mascota);
                        } else {
                            modeloBOPaciente.ReportePaciente(vista.Generar_Rep_Mascota);
                        }
                        break;
                    case 4:
                        if (vista.CheckElimimados.isSelected()) {
                            modeloBOPropie.ReportePropietarioEliinados(vista.Generar_Rep_Mascota);
                        } else {
                            modeloBOPropie.ReportePropietario(vista.Generar_Rep_Mascota);
                        }

                        break;
                    case 3:
                        if (vista.CheckElimimados.isSelected()) {
                            modeloBOSecre.ReporteSecreEliminados(vista.Generar_Rep_Mascota);
                        } else {
                            modeloBOSecre.ReporteSecre(vista.Generar_Rep_Mascota);
                        }

                        break;
                    case 2:
                        if (vista.CheckElimimados.isSelected()) {
                            modeloBOAux.ReporteAuxiliaresEliminados(vista.Generar_Rep_Mascota);
                        } else {
                            modeloBOAux.ReporteAuxiliar(vista.Generar_Rep_Mascota);
                        }

                        break;
                    case 1:
                        if (vista.CheckElimimados.isSelected()) {
                            modeloBOMed.ReporteMedicosEliminados(vista.Generar_Rep_Mascota);
                        } else {
                            modeloBOMed.ReporteMedic(vista.Generar_Rep_Mascota);
                        }

                        break;
                    case 0:
                        JOptionPane.showMessageDialog(null, "No selecciono ningun reporte");
                        break;
                    default:
                        break;
                }
            }

        }

        if (e.getSource() == vista.Bot_Regresar_Repo) {
            vista.comboFiltro.setSelectedItem("Seleccione");
            vista.dispose();
            limpiar();
        }
        if (e.getSource() == vista.Bot_RepBuscar) {
            buscarEnTabla();
        }

        if (e.getSource() == vista.Restaurar) {

            if (vista.comboFiltro.getSelectedIndex() == 1) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        icono("/iconos/alerta.png", 40, 40));
                if (res == JOptionPane.YES_OPTION) {
                    RMedico();
                    Recargar();
                }
            } else {
                if (vista.comboFiltro.getSelectedIndex() == 2) {

                    int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            icono("/iconos/alerta.png", 40, 40));
                    if (res == JOptionPane.YES_OPTION) {
                        RAuxiliar();
                        Recargar();
                    }

                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 3) {
                        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                icono("/iconos/alerta.png", 40, 40));
                        if (res == JOptionPane.YES_OPTION) {
                            RSecretaria();
                            Recargar();
                        }
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 4) {
                            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                    icono("/iconos/alerta.png", 40, 40));
                            if (res == JOptionPane.YES_OPTION) {
                                RPropietario();
                                Recargar();
                            }
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 5) {
                                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Eliminar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                        icono("/iconos/alerta.png", 40, 40));
                                if (res == JOptionPane.YES_OPTION) {
                                    RPaciente();
                                    Recargar();

                                }
                            }
                        }
                    }
                }
            }

        }

        // Eliminados
        if (e.getSource() == vista.Restaurar1) {

            if (vista.comboFiltro.getSelectedIndex() == 1) {
                UIManager UI = new UIManager();
                UI.put("OptionPane.background", Color.white);
                UI.put("Panel.background", Color.white);
                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Restaurar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                        icono("/iconos/alerta.png", 40, 40));
                if (res == JOptionPane.YES_OPTION) {
                    ReMedico();
                    RecargarEliminados();
                }

            } else {
                if (vista.comboFiltro.getSelectedIndex() == 2) {
                    UIManager UI = new UIManager();
                    UI.put("OptionPane.background", Color.white);
                    UI.put("Panel.background", Color.white);
                    int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Restaurar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                            icono("/iconos/alerta.png", 40, 40));
                    if (res == JOptionPane.YES_OPTION) {
                        ReAuxiliar();
                        RecargarEliminados();
                    }

                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 3) {
                        UIManager UI = new UIManager();
                        UI.put("OptionPane.background", Color.white);
                        UI.put("Panel.background", Color.white);
                        int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Restaurar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                icono("/iconos/alerta.png", 40, 40));
                        if (res == JOptionPane.YES_OPTION) {
                            ReSecretaria();
                            RecargarEliminados();
                        }
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 4) {
                            UIManager UI = new UIManager();
                            UI.put("OptionPane.background", Color.white);
                            UI.put("Panel.background", Color.white);
                            int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Restaurar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                    icono("/iconos/alerta.png", 40, 40));
                            if (res == JOptionPane.YES_OPTION) {
                                RePropietario();
                                RecargarEliminados();
                            }
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 5) {
                                UIManager UI = new UIManager();
                                UI.put("OptionPane.background", Color.white);
                                UI.put("Panel.background", Color.white);
                                int res = JOptionPane.showConfirmDialog(this.vista, "¿Está seguro de Restaurar este registro?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                                        icono("/iconos/alerta.png", 40, 40));
                                if (res == JOptionPane.YES_OPTION) {
                                    RePaciente();
                                    RecargarEliminados();
                                }
                            }
                        }
                    }
                }
            }

        }

        if (e.getSource() == vista.CheckElimimados) {
            vista.comboFiltro.setSelectedIndex(0);
        }
    }

    void MostrarEliminados() {

        vista.Restaurar.setVisible(false);
        vista.Restaurar1.setVisible(true);

        if (vista.comboFiltro.getSelectedIndex() == 1) {
            mostrarMedicoE("");
        } else {
            if (vista.comboFiltro.getSelectedIndex() == 2) {
                mostrarAuxiliarE("");
            } else {
                if (vista.comboFiltro.getSelectedIndex() == 3) {
                    mostrarSecretariaE("");
                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 4) {
                        mostrarPropietarioE("");
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 5) {
                            mostrarPacienteE("");
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 0) {
                                limpiar();

                            }
                        }
                    }
                }
            }
        }
    }

    void MostrarActivos() {
        vista.Restaurar.setVisible(false);
        vista.Restaurar1.setVisible(false);

        if (vista.comboFiltro.getSelectedIndex() == 1) {
            mostrarMedico("");
        } else {
            if (vista.comboFiltro.getSelectedIndex() == 2) {
                mostrarAuxiliar("");
            } else {
                if (vista.comboFiltro.getSelectedIndex() == 3) {
                    mostrarSecretaria("");
                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 4) {
                        mostrarPropietario("");
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 5) {
                            mostrarPaciente("");
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 0) {
                                limpiar();
                            }
                        }
                    }
                }
            }
        }

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (vista.CheckElimimados.isSelected()) {
            MostrarEliminados();

        } else {
            MostrarActivos();
        }
    }

    //////////////// METODOS MOSTRAR  //////////////////////
    //medico
    private void mostrarMedico(String cedula) {
        modeloH.listarMedicoAc(vista.Tablas_Historial, cedula);
    }

    //Auxiliar
    private void mostrarAuxiliar(String cedula) {
        modeloH.listarAuxiliarAc(vista.Tablas_Historial, cedula);
    }

    //Secretaria
    private void mostrarSecretaria(String cedula) {
        modeloH.listarSecreatariaAc(vista.Tablas_Historial, cedula);
    }

    //Propietario
    public void mostrarPropietario(String cedula) {
        modeloH.listarPropietariosAc(vista.Tablas_Historial, cedula);
    }

    //Paciente  
    private void mostrarPaciente(String clave) {
        modeloH.listarPacientesAct(vista.Tablas_Historial, clave);
    }

    // ELIMINADOS
    //medico
    private void mostrarMedicoE(String cedula) {
        modeloH.listarMedico(vista.Tablas_Historial, cedula);
    }

    //Auxiliar
    private void mostrarAuxiliarE(String cedula) {
        modeloH.listarAuxiliar(vista.Tablas_Historial, cedula);
    }

    //Secretaria
    private void mostrarSecretariaE(String cedula) {
        modeloH.listarSecreataria(vista.Tablas_Historial, cedula);
    }

    //Propietario
    public void mostrarPropietarioE(String cedula) {
        modeloH.listarPropietarios(vista.Tablas_Historial, cedula);
    }

    //Paciente  
    private void mostrarPacienteE(String clave) {
        modeloH.listarPacientes(vista.Tablas_Historial, clave);
    }
    //////////////// METODOS MOSTRAR  //////////////////////

    public void Recargar() {
        if (vista.comboFiltro.getSelectedIndex() == 1) {
            mostrarMedico("");
        } else {
            if (vista.comboFiltro.getSelectedIndex() == 2) {
                mostrarAuxiliar("");
            } else {
                if (vista.comboFiltro.getSelectedIndex() == 3) {
                    mostrarSecretaria("");
                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 4) {
                        mostrarPropietario("");
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 5) {
                            mostrarPaciente("");
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 0) {
                                limpiar();

                            }
                        }
                    }
                }
            }
        }
    }

    public void RecargarEliminados() {
        if (vista.comboFiltro.getSelectedIndex() == 1) {
            mostrarMedicoE("");
        } else {
            if (vista.comboFiltro.getSelectedIndex() == 2) {
                mostrarAuxiliarE("");
            } else {
                if (vista.comboFiltro.getSelectedIndex() == 3) {
                    mostrarSecretariaE("");
                } else {
                    if (vista.comboFiltro.getSelectedIndex() == 4) {
                        mostrarPropietarioE("");
                    } else {
                        if (vista.comboFiltro.getSelectedIndex() == 5) {
                            mostrarPacienteE("");
                        } else {
                            if (vista.comboFiltro.getSelectedIndex() == 0) {
                                limpiar();

                            }
                        }
                    }
                }
            }
        }
    }
    // RESTARURAR

    //Restaurar Medico
    public void ReMedico() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Medico m = new Medico();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Medico newMedico = new Medico();
            listaMedico.add(newMedico);
            String mensaje = modeloH.RestaurarMedico(newMedico, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //Restaurar Auxiliar
    public void ReAuxiliar() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Auxiliar a = new Auxiliar();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Auxiliar newAuxiliar = new Auxiliar();
            listaAuxiliar.add(newAuxiliar);
            String mensaje = modeloH.RestaurarAuxiliar(newAuxiliar, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //Restaurar Secretaria
    public void ReSecretaria() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Secretaria s = new Secretaria();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Secretaria newSecretaria = new Secretaria();
            listaSecretaria.add(newSecretaria);
            String mensaje = modeloH.RestaurarSecretaria(newSecretaria, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //Restaurar Propietario
    public void RePropietario() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Propietario pr = new Propietario();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Propietario newPropietario = new Propietario();
            listaPropietario.add(newPropietario);
            String mensaje = modeloH.RestaurarPropietario(newPropietario, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //Restaurar Paciente
    public void RePaciente() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Mascota p = new Mascota();
            String clave = vista.Tablas_Historial.getValueAt(fila, 1).toString();
            Mascota newPaciente = new Mascota();
            listaPaciente.add(newPaciente);
            String mensaje = modeloH.RestaurarPaciente(newPaciente, clave);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }
    //ELIMINAR
    //Eliinar Medico

    public void RMedico() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Medico m = new Medico();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Medico newMedico = new Medico();
            listaMedico.add(newMedico);
            String mensaje = modeloH.eliminarMedico(newMedico, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //eliminar Auxiliar
    public void RAuxiliar() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Auxiliar a = new Auxiliar();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Auxiliar newAuxiliar = new Auxiliar();
            listaAuxiliar.add(newAuxiliar);
            String mensaje = modeloH.eliminarAuxiliar(newAuxiliar, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //eliminar Secretaria
    public void RSecretaria() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Secretaria s = new Secretaria();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Secretaria newSecretaria = new Secretaria();
            listaSecretaria.add(newSecretaria);
            String mensaje = modeloH.eliminarSecretaria(newSecretaria, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //eliminar Propietario
    public void RPropietario() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Propietario pr = new Propietario();
            String cedula = vista.Tablas_Historial.getValueAt(fila, 0).toString();
            Propietario newPropietario = new Propietario();
            listaPropietario.add(newPropietario);
            String mensaje = modeloH.eliminarPropietario(newPropietario, cedula);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //eliminar Paciente
    public void RPaciente() {
        int fila = vista.Tablas_Historial.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar una fila");
        } else {
            Mascota p = new Mascota();
            String clave = vista.Tablas_Historial.getValueAt(fila, 1).toString();
            Mascota newPaciente = new Mascota();
            listaPaciente.add(newPaciente);
            String mensaje = modeloH.eliminarPaciente(newPaciente, clave);
            JOptionPane.showMessageDialog(vista, mensaje);
        }
    }

    //ICONO JOPTIONPANE
    public Icon icono(String path, int width, int heigth) {
        Icon img = new ImageIcon(new ImageIcon(getClass().getResource(path)).getImage()
                .getScaledInstance(width, heigth, java.awt.Image.SCALE_SMOOTH));
        return img;
    }

    // BUSQUEDAS
    int verificacion;

    public void buscarEnTabla() {

        String cedula = vista.txtBuscar.getText();
        if (vista.txtBuscar.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Caja de texto vacia");
            vista.Tablas_Historial.clearSelection();
        } else {
            for (int i = 0; i < vista.Tablas_Historial.getRowCount(); i++) {

                if (vista.Tablas_Historial.getValueAt(i, 1).equals(cedula)) {
                    vista.Tablas_Historial.requestFocus();
                    vista.Tablas_Historial.changeSelection(i, 1, false, false);
                    verificacion = 1;
                }
            }
        }
//
//        if (verificacion == 1) {
//            //System.out.println("Existe " + verificacion);
//        } else {
//            JOptionPane.showMessageDialog(null, "Dato No Existente", "Advertencia", JOptionPane.PLAIN_MESSAGE, icono("/iconos/alerta.png", 40, 40));
//        }
    }
}
