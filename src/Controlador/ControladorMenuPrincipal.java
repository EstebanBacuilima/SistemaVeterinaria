package Controlador;

import Modelo.Auxiliar;
import Modelo.Examen;
import Modelo.MHorarioEmpleados;
import Modelo.MUsuarios;
import Modelo.Medico;
import Modelo.Mascota;
import Modelo.Propietario;
import Modelo.PropietaroBO;
import Modelo.Receta;
import Modelo.Secretaria;
import Vista.ExamenMascota;
import Vista.HistorialEmpleadosActivos;
import Vista.HistorialMascota;
import Vista.HorarioEmpleados;
import Vista.Login;
import Vista.MenuPrincipal;
import Vista.RegistroAuxiliar;
import Vista.RegistroMascota;
import Vista.RegistroMedico;
import Vista.RegistroPropietario;
import Vista.RegistroRecetas;
import Vista.RegistroSecretaria;
import Vista.ReporteAuxiliar;
import Vista.ReporteMascotas;
import Vista.ReporteMedico;
import Vista.ReportePropietarios;
import Vista.ReporteRecetas;
import Vista.ReporteSecretarias;
import Vista.Usuarios;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import Controlador.ControladorAgendaCitas;
import Modelo.Cita;
import Vista.AgendaCitas;
import Controlador.ControladorCita;
import Controlador.ControladorCita;
import Modelo.Consultorio;
import Modelo.Servicio;
import Vista.RegistrarConsultorios;
import Vista.RegistrarServicios;
import Vista.RegistroCitas;
import javax.swing.JFrame;

public class ControladorMenuPrincipal implements ActionListener, KeyListener, MouseListener {

    MenuPrincipal vista = new MenuPrincipal();

    //AGENDA DE CITAS
    AgendaCitas vistaAgenda = new AgendaCitas();
    ControladorAgendaCitas controladorAgenda = new ControladorAgendaCitas(vistaAgenda);

    // REGISTRAR CITA
    RegistroCitas vistaRegCitas = new RegistroCitas();
    ControladorCita controladorRegCitas = new ControladorCita(vistaRegCitas);

    // CONTROLADORES
    RegistroPropietario vistaPro = new RegistroPropietario();
    ReportePropietarios vistaProRe = new ReportePropietarios();
    Propietario per = new Propietario();
    ControladorPropietario controlPropietario = new ControladorPropietario(per, vistaPro, vistaProRe);

    // CONTROLADORES PACIENTE
    RegistroMascota vista2 = new RegistroMascota();
    ReporteMascotas vistaM = new ReporteMascotas();
    Mascota pac = new Mascota();
    ControladorMascota controlPa = new ControladorMascota(pac, vista2, vistaM);

    // CONTROLADORES SECRETARIO   
    RegistroSecretaria vistaSecre = new RegistroSecretaria();
    ReporteSecretarias vistaReSecre = new ReporteSecretarias();
    Secretaria secrce = new Secretaria();
    ControladorSecretaria controlSe = new ControladorSecretaria(secrce, vistaSecre, vistaReSecre);

    // CONTROL EXAMEN
    ExamenMascota vistaExamen = new ExamenMascota();
    Examen modeloExamen = new Examen();
    ControladorExamen controlExamen = new ControladorExamen(modeloExamen, vistaExamen, vistaM);

    // CONTROL HORARIO EMPLEADO
    MHorarioEmpleados modeloHorario = new MHorarioEmpleados();
    HorarioEmpleados vistaHorario = new HorarioEmpleados();
    ControladorHorarioEmpleados controlHorario = new ControladorHorarioEmpleados(vistaHorario, modeloHorario);

    // CONTROL USUARIO
    MUsuarios modeloUsuario = new MUsuarios();
    Usuarios vistaUsuario = new Usuarios();
    ControladorUsuario controlUsuario = new ControladorUsuario(vistaUsuario, modeloUsuario);

    // HISOTRIAL CLINICO
    HistorialMascota vistaHistorialClinico = new HistorialMascota();
    Controlador_Historial_Clinico controlHistorialClinico = new Controlador_Historial_Clinico(vistaHistorialClinico);

    //CONTROLADOR MEDICO
    RegistroMedico vistaMedic = new RegistroMedico();
    ReporteMedico vistaRMedic = new ReporteMedico();
    Medico med = new Medico();
    ControladorMedico controlMedic = new ControladorMedico(med, vistaMedic, vistaRMedic);
    //CONTROLADOR AUXILIAR
    RegistroAuxiliar vistaAuxil = new RegistroAuxiliar();
    ReporteAuxiliar vistaRAuxil = new ReporteAuxiliar();
    Auxiliar aux = new Auxiliar();
    ControladorAuxiliar controlAuxil = new ControladorAuxiliar(aux, vistaAuxil, vistaRAuxil);
    ///CONTROLADOR RECETAS
    RegistroRecetas vistaRecet = new RegistroRecetas();
    ReporteRecetas vistaRRecet = new ReporteRecetas();
    Receta rec = new Receta();
    ControladorReceta controlRecet = new ControladorReceta(rec, vistaRecet, vistaRRecet);
    // CONSULTORIO y SERVICIOS 
    RegistrarConsultorios v = new RegistrarConsultorios();
    Consultorio modelo = new Consultorio();
    ControladorConsultorio control = new ControladorConsultorio(modelo, v);
    RegistrarServicios vistaServicios = new RegistrarServicios();
    Servicio modeloSer = new Servicio();
    ControladorServicios controlServicio = new ControladorServicios(modeloSer, vistaServicios);
    // HITORIAL 
    HistorialEmpleadosActivos vistRepoAct = new HistorialEmpleadosActivos();
    ControladorHistorialActivos contrActivosReport = new ControladorHistorialActivos(vistRepoAct);

    public ControladorMenuPrincipal(MenuPrincipal vista) {

        this.vista = vista;
        this.vista.Menu_Inicio.addActionListener(this);

        // PROPIETARIOS
        this.vista.Item_Reg_Pro.addActionListener(this);
        this.vistaProRe.Bot_Regresar_Repo.addActionListener(this);
        this.vistaProRe.Txt_Buscar_Ce.addKeyListener(this);

        // PACIENTE
        this.vista.Item_reg_paciente.addActionListener(this);
        this.vista2.Bot_salir.addActionListener(this);
        this.vistaM.Txt_Buscar_Ce.addKeyListener(this);
        this.vistaM.Bot_Regresar_Repo.addActionListener(this);

        // SECRETARIO
        this.vista.Item_regi_secre.addActionListener(this);
        this.vistaSecre.Bot_Regresar.addActionListener(this);
        this.vistaReSecre.Txt_Buscar_Ce.addKeyListener(this);

        // EXAMEN
        this.vista.Item_Examen.addActionListener(this);
        this.vistaExamen.Bot_Regresar.addActionListener(this);
        //this.vistaM.Txt_Buscar_Ce.addKeyListener(this);

        // HORARIO
        this.vista.Item_Horario.addActionListener(this);
        this.vistaHorario.btSal.addActionListener(this);

        // USUARIO
        this.vista.Item_reg_user.addActionListener(this);
        this.vistaUsuario.btSal.addActionListener(this);

        // HISTORIAL CLINICO
        this.vista.Item_historiaal.addActionListener(this);
        this.vistaHistorialClinico.Boton_regresar.addActionListener(this);

        //MEDICO
        this.vista.ItemRegistroMedico.addActionListener(this);
        this.vistaMedic.Txt_buscar_med.addKeyListener(this);
        this.vistaMedic.Bot_Regresar.addActionListener(this);
        this.vistaRMedic.Bot_Regresar_Repo.addActionListener(this);
        //AUXILIAR
        this.vista.ItemRegistroAuxiliar.addActionListener(this);
        this.vistaAuxil.Txt_buscar_aux.addKeyListener(this);
        this.vistaAuxil.Bot_Regresar.addActionListener(this);
        this.vistaRAuxil.Bot_Regresar_Repo.addActionListener(this);
        //RECETAS
        this.vista.ItemRegistroReceta.addActionListener(this);
        this.vistaRecet.txtConsultarReceta.addKeyListener(this);
        this.vistaRecet.Bot_Regresar.addActionListener(this);
        this.vistaRRecet.Bot_Regresar_Repo.addActionListener(this);
        //HISTORIAL ACTIVOS
        this.vista.VerActivosReport.addActionListener(this);
        this.vistRepoAct.txtBuscar.addKeyListener(this);
        this.vistRepoAct.Bot_Regresar_Repo.addActionListener(this);

        // AGENDA DE CITAS
        this.vista.registrarCita.addActionListener(this);
        this.vistaRegCitas.Bot_Regresar1.addActionListener(this);
        this.vista.item_agenda_citas.addActionListener(this);
        this.vistaAgenda.Bot_Regresar1.addActionListener(this);
        this.vistaRegCitas.Bot_Regresar1.addActionListener(this);
        // MENU
        this.vista.Menu_Pac.addActionListener(this);
        this.vista.Menu_Citas.addActionListener(this);
        this.vista.Menu_Veterinarios.addActionListener(this);
        this.vista.Menu_reportes.addActionListener(this);
        // SERICIO Y CONSULTORIOS
        this.vista.RegConsultorio.addActionListener(this);
        this.vista.AgreServicio.addActionListener(this);
        this.vistaServicios.Salir.addActionListener(this);
        this.v.salir.addActionListener(this);
        //
        this.vista.fondo_menu.addMouseListener(this);
        this.vista.Salir_Todo.addActionListener(this);

    }

    public void EnviarDatosAgenda() {
        vistaAgenda.Tipo_emp.setText(vista.Text_Tipo.getText());
        vistaAgenda.Id_Personal.setText(vista.Text_ID1.getText());
    }

//    public void EnviarDatosRegistarCita() {
//        vistaRegCitas.id_secretaria.setText(vista.Text_ID_secre.getText());
//    }

    public void inciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);
        ponerImagen();
        // ponerImagen2();
        validarUnFrame();

        vista.Text_Foto.setVisible(false);
        vista.Text_ID.setVisible(false);
        vista.Text_Tipo.setVisible(false);
        vista.Text_ID_secre.setVisible(false);
        vista.Text_ID.setVisible(false);
    }

    // FOTOS PERFIl
    protected static String Imagen;
    protected static String Dest, Orig;
    String nombreI;

    public void ponerImagen() {

        Imagen = vista.Text_Foto.getText();
        String fotoBuscar = Imagen;
        Orig = "src/ImagenesPersonal/" + fotoBuscar;
        ImageIcon icon = new ImageIcon(Orig);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
        vista.foto.setText(null);
        vista.foto.setIcon(icono);

    }

    public void ponerImagen2() {

        Imagen = vista.Text_Foto1.getText();
        String fotoBuscar = Imagen;
        Orig = "src/ImagenesPersonal/" + fotoBuscar;
        ImageIcon icon = new ImageIcon(Orig);
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(vista.foto.getWidth(), vista.foto.getHeight(), Image.SCALE_DEFAULT));
        vista.foto.setText(null);
        vista.foto.setIcon(icono);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.Menu_Inicio) {
            System.out.println("HOLA");
        }

        // PROPIETARIO
        if (e.getSource() == vista.Item_Reg_Pro) {
            controlPropietario.inciar();
            vistaPro.setVisible(true);
        }

        if (e.getSource() == vistaProRe.Bot_Regresar_Repo) {
            vistaProRe.dispose();
        }

        // PACIENTE
        if (e.getSource() == vista.Item_reg_paciente) {
            controlPa.inciar();
            vista2.setVisible(true);
        }
        if (e.getSource() == vista2.Bot_salir) {
            vista2.dispose();
        }
        if (e.getSource() == vistaM.Bot_Regresar_Repo) {
            vistaM.dispose();
        }

        // SECRETARIO
        if (e.getSource() == vista.Item_regi_secre) {
            controlSe.inciar();
            vistaSecre.setVisible(true);
        }
        if (e.getSource() == vistaSecre.Bot_Regresar) {
            vistaSecre.dispose();
        }

        //EXAMEN
        if (e.getSource() == vista.Item_Examen) {
            controlExamen.inciar();
            vistaExamen.setVisible(true);
        }
        if (e.getSource() == vistaExamen.Bot_Regresar) {
            vistaExamen.dispose();
        }

        //HORARIO
        if (e.getSource() == vista.Item_Horario) {
            controlHorario.Iniciar_Vista();
            vistaHorario.setVisible(true);
        }
        if (e.getSource() == vistaHorario.btSal) {
            vistaHorario.dispose();

        }

        //USUARIO
        if (e.getSource() == vista.Item_reg_user) {
            controlUsuario.Iniciar_Vista();
            vistaUsuario.setVisible(true);
        }
        if (e.getSource() == vistaUsuario.btSal) {
            vistaUsuario.dispose();
        }

        // HISTORIAL CLINICO
        if (e.getSource() == vista.Item_historiaal) {
            controlHistorialClinico.inciar();
        }

        if (e.getSource() == vistaHistorialClinico.Boton_regresar) {
            vistaHistorialClinico.dispose();
        }

        // MEDICO
        if (e.getSource() == vista.ItemRegistroMedico) {
            RegistroMedico vistaMedic = new RegistroMedico();
            ReporteMedico vistaRMedic = new ReporteMedico();
            Medico med = new Medico();
            ControladorMedico controlMedic = new ControladorMedico(med, vistaMedic, vistaRMedic);
            controlMedic.iniciar();
            vistaMedic.setVisible(true);
        }
        if (e.getSource() == vistaMedic.Bot_Regresar) {
            vistaMedic.dispose();
        }
        //AUXILIAR
        if (e.getSource() == vista.ItemRegistroAuxiliar) {
            RegistroAuxiliar vistaAuxil = new RegistroAuxiliar();
            ReporteAuxiliar vistaRAuxil = new ReporteAuxiliar();
            Auxiliar aux = new Auxiliar();
            ControladorAuxiliar controlAuxil = new ControladorAuxiliar(aux, vistaAuxil, vistaRAuxil);
            controlAuxil.iniciar();
            vistaAuxil.setVisible(true);
        }
        if (e.getSource() == vistaAuxil.Bot_Regresar) {
            vistaAuxil.dispose();
        }
        //RECETAS
        if (e.getSource() == vista.ItemRegistroReceta) {
            controlRecet.iniciar();
            vistaRecet.setVisible(true);
        }
        if (e.getSource() == vistaRecet.Bot_Regresar) {
            vistaRecet.dispose();
        }
        // HISTORIAL 
        if (e.getSource() == vista.VerActivosReport) {
            contrActivosReport.iniciar();
            vistRepoAct.setVisible(true);
        }
        if (e.getSource() == vistRepoAct.Bot_Regresar_Repo) {
            vistRepoAct.dispose();
        }

        // REGISTRAR CITA
        if (e.getSource() == vista.registrarCita) {
            RegistroCitas vistaRegCitas = new RegistroCitas();
            ControladorCita controladorRegCitas = new ControladorCita(vistaRegCitas);
            vistaRegCitas.setLocationRelativeTo(null);
            vistaRegCitas.setVisible(true);
            vistaRegCitas.id_secretaria.setText(vista.Text_ID_secre.getText());
        }
        if (e.getSource() == vistaRegCitas.Bot_Regresar1) {
            vistaRegCitas.dispose();

        }
        // AGENDA CITAS 
        if (e.getSource() == vista.item_agenda_citas) {
            vistaAgenda.setVisible(true);
            vistaAgenda.setLocationRelativeTo(null);
            EnviarDatosAgenda();
            vistaAgenda.prueba.doClick();
        }
        if (e.getSource() == vistaAgenda.Bot_Regresar1) {
            vistaAgenda.dispose();
        }
        // SERVICIO Y CONSULTORIO
        if (e.getSource() == vista.RegConsultorio) {
            control.iniciar();
        }
        if (e.getSource() == vista.AgreServicio) {
            controlServicio.iniciar();
        }
        if (e.getSource() == vistaServicios.Salir) {
            vistaServicios.dispose();
        }
        if (e.getSource() == v.salir) {
            v.dispose();
        }
        //SALIR
        if (e.getSource() == vista.Salir_Todo) {
            System.exit(0);
        }

    }

    public void validarUnFrame() {
        if (vistaPro.isShowing() == true) {
            vista.jMenuBar1.setVisible(false);
        } else {
            vista.jMenuBar1.setEnabled(true);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (vista.fondo_menu == null || vista.jMenuBar1 == null || vista.Menu_Pro == null || vista.Menu_Inicio == null) {
            //System.out.println("no dio clicl");
        } else {
            v.dispose();
            vistaServicios.dispose();
            vistaPro.dispose();
            vistaProRe.dispose();
            vistaSecre.dispose();
            vistRepoAct.dispose();
            vistaRecet.dispose();
            vistaMedic.dispose();
            vistaRMedic.dispose();
            vistaExamen.dispose();
            vistaReSecre.dispose();
            vistaHistorialClinico.dispose();
            vista2.dispose();
            vistaM.dispose();
            vistaAuxil.dispose();
            vistaUsuario.dispose();
            vistaHorario.dispose();
            vistaRegCitas.dispose();
            vistaRAuxil.dispose();
            vistaAuxil.dispose();
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

}
