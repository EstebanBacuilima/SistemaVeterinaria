package Modelo;

import Controlador.ControladorCita;
import Vista.Tabla_extra_citas;
import java.awt.Frame;
import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class CitaDAO {

    PreparedStatement ps;
    ResultSet rs;
    private String mensaje = "";
    Tabla_extra_citas Texc = new Tabla_extra_citas();
    MHorario horas = new MHorario();

    public void listarCitas(Connection con, JTable tabla, String nom, char estado) {
        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };

        modelo.addColumn("ID CITA");
        modelo.addColumn("CEDULA");
        modelo.addColumn("NOMBRE");
        modelo.addColumn("PACIENTE");
        modelo.addColumn("SERVICIO");
        modelo.addColumn("MEDICO");
        modelo.addColumn("CONSULTORIO");
        modelo.addColumn("FECHA");
        modelo.addColumn("HORA");

        tabla.setModel(modelo);
        String sql = "";
        if (estado == 'A') {
            if (nom.equals("")) {
                //System.out.println("si entra");
                sql = "select  id_cita,cedula_pro, nom_propietario,nom_paciente,nom_servicio,nom_medico, nom_consultorio, fecha, hora_ini from V_Mostrar_Citas where estado = 'A'";
            } else {

                sql = "select  id_cita,cedula_pro, nom_propietario,nom_paciente,nom_servicio,nom_medico, nom_consultorio, fecha, hora_ini from V_Mostrar_Citas where cedula_pro like '%" + nom + "%' and estado = 'A'";
            }
        } else if (estado == 'I') {
            if (nom.equals("")) {

                sql = "select  id_cita,cedula_pro, nom_propietario,nom_paciente,nom_servicio,nom_medico, nom_consultorio, fecha, hora_ini from V_Mostrar_Citas where estado = 'I'";

            } else {

                sql = "select  id_cita,cedula_pro, nom_propietario,nom_paciente,nom_servicio,nom_medico, nom_consultorio, fecha, hora_ini from V_Mostrar_Citas where cedula_pro like '%" + nom + "%' and estado = 'I' ";
            }

        }
        String[] datos = new String[9];

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                datos[8] = rs.getString(9);

                modelo.addRow(datos);
            }
            tabla.setModel(modelo);
            //JOptionPane.showMessageDialog(null, "Encontrado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

    }

    public Cita listarporidDAO(Connection con, int id) {
        Cita listac = new Cita();

        String sql = "select  ID_CITA,PROPIETARIO_ID,PROPIETARIO_CEDULA,PROPIETARIO_NOMBRE,ID_PACIENTE,NOM_PACIENTE, ID_SERVICIO, NOM_SERVICIO, ID_MEDICO, NOM_MEDICO,ID_CONSULTORIO, NOM_CONSULTORIO,FECHA,  HORA_INI  from V_mostrar_citas vc, V_MASCOTAYPROPIETARIO vm \n"
                + "where  vm.MASCOTA_ID = vc.ID_PACIENTE and  id_cita = " + id + "";
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                listac.setId(rs.getInt(1));
                listac.setId_dueño(rs.getInt(2));
                listac.setCed_dueño(rs.getString(3));
                listac.setNom_dueño(rs.getString(4));
                listac.setId_paciente(rs.getInt(5));
                listac.setNom_paciente(rs.getString(6));
                listac.setId_servicio(rs.getInt(7));
                listac.setNom_servicio(rs.getString(8));
                listac.setId_veterinario(rs.getInt(9));
                listac.setNom_veterinario(rs.getString(10));
                listac.setId_consultorio(rs.getInt(11));
                listac.setNom_consultorio(rs.getString(12));
                String f = rs.getString(13);
                String fe[] = f.split(" ");
                LocalDate fecha_cita = null;
                String fech[] = fe[0].split("-");
                LocalDate fechas = LocalDate.of((Integer.parseInt(fech[0])), Integer.parseInt(fech[1]), Integer.parseInt(fech[2]));
                fecha_cita = fechas;
                listac.setFecha(fecha_cita);
                listac.setHora_ini(rs.getString(14));
            }
            //JOptionPane.showMessageDialog(null, "Encontrado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No Encontrado");
            System.out.println("Error:" + ex);
        }

        return listac;
    }

    void mostrar_datos_ext(Connection con, JTable tab, String dato, int num) {

        DefaultTableModel modelo = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int columnas) {
                return false;
            }
        };
        String sql = "";
        switch (num) {
            case 1: //DUEÑO
                modelo.addColumn("ID DUEÑO");
                modelo.addColumn("CEDULA");
                modelo.addColumn("NOMBRE");
                modelo.addColumn("ID MASCOTA");
                modelo.addColumn("CLAVE MASCOTA");
                modelo.addColumn("NOMBRE");
                tab.setModel(modelo);

                if (dato.equals("")) {
                    sql = "select * from V_MASCOTAYPROPIETARIO";
                } else {
                    sql = "select * from V_MASCOTAYPROPIETARIO where PROPIETARIO_CEDULA like '%" + dato + "%'";
                }

                break;

        }

        String[] datos = new String[6];

        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                modelo.addRow(datos);
            }
            tab.setModel(modelo);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al importar los datos de la Base (tablas dueño y paciente)");
        }
    }

    public int getCitaID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(id_cita) FROM citas";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al importar la id de la tabla Citas de la Base");
        }
        return id;
    }

    public String agregarC(Connection con, Cita c) {
        String sql = "insert into citas (ID_CITA, ID_MASCOTA, ID_SERVICIO, ID_VETERINARIO, ID_AREA, ID_SECRETARIA, FECHA, HORA, ESTADO,ID_FACTURA) values (?,?,?,?,?,?,?,?,'P',?)";
        try {

            ps = con.prepareStatement(sql);
            int idc = getCitaID(con);
            ps.setInt(1, idc);
            ps.setInt(2, c.getId_paciente());
            ps.setInt(3, c.getId_servicio());
            ps.setInt(4, c.getId_veterinario());
            ps.setInt(5, c.getId_consultorio());
            ps.setInt(6, c.getId_secretaria());
            ps.setDate(7, java.sql.Date.valueOf(c.getFecha()));
            ps.setString(8, c.getHora_ini());
            ps.setInt(9, c.getId_factura());
            ps.executeQuery();
            ps.close();
            mensaje = "Registrado Exitosamente";

        } catch (SQLException e) {
            mensaje = "Error al Registrar " + e;
        }
        return mensaje;
    }

    public void mostrarserviciosDAO(Connection con, JComboBox ComboServicios) {
        String sql = "SELECT nombre FROM servicios where estado= 'A' ORDER BY nombre ";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //guardamos todos los datos de la consulta en el combo
            while (rs.next()) {
                ComboServicios.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al importar los registros de servicios de la Base" + e);
        }
    }

    public void mostrarveterinarioDAO(Connection con, JComboBox Comboveteri, String nomservicio) {
        String sql = "select  n.persona_pri_nombre ||' '|| n.persona_seg_nombre ||' '|| n.persona_pat_apellido ||' '|| n.persona_mat_apellido from personas n, veterinario m, servicios s where (s.id_servicio = m.servicios_id and s.nombre = '" + nomservicio + "') and m.persona_id = n.persona_id  and m.estado='A'";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //eliminamos los datos cargados en el combo de medicos y volvemos a cargar nuevos datos ya que se escogio otro servicio
            Comboveteri.removeAllItems();
            //agremos un item inicial que se mostrara en el combo
            Comboveteri.addItem("SELECCIONAR");
            //agregamos los datos de la cosulta al combo
            while (rs.next()) {
                Comboveteri.addItem(rs.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar los datos de veterinarios de la Base" + e);
        }
    }

    //la consulta me da una id la cual la retornamos a la clase controlador 
    public int mostraridservicioDAO(Connection con, String nom) {
        int id = 0;
        String sql = "select id_servicio from servicios where nombre='" + nom + "' and estado = 'A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error al importar la id del servicio " + e);
        }
        return id;
    }

    //la consulta me da una id la cual la retornamos a la clase controlador 
    public int mostraridveteriDAO(Connection con, int id, String nomv) {
        int idv = 0;
        String sql = "select m.veterinario_id from veterinario m where servicios_id = " + id + " and m.estado = 'A' and m.persona_id = (select n.persona_id from personas n where  n.persona_pri_nombre ||' '|| n.persona_seg_nombre ||' '|| n.persona_pat_apellido ||' '|| n.persona_mat_apellido = '" + nomv + "')";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar la id del veterinario " + e);
        }
        return idv;
    }

    //la consulta me retorna una array de Strings el cual retornamos a la clase controlador
    public String[] mostraridnomconsutorioDAO(Connection con, int id) {
        String[] datos = new String[2];
        String sql = "select id_area, nombre from area_trabajo c, veterinario m where (c.id_area = m.area_id and veterinario_id =" + id + " ) and c.estado='A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //guardamos los datos en el array
            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt(1));
                datos[1] = rs.getString(2);
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al importar los datos de consultorios de la Base " + e);
        }
        //retornamos el array
        return datos;
    }

    public void horasatencionDAO(Connection con, JComboBox horas, int idm, String dia) {
        String verifica = "";
        String sql = "SELECT O.hora_inicio, O.hora_fin FROM  veterinario V, horario_veterinario H, CONTROL_HORARIO O WHERE  H.ID_VETERINARIO  = V.Veterinario_id AND H.ID_HORARIO = O.ID_HORARIO AND V.Veterinario_id = " + idm + " AND O.dia='" + dia + "' AND o.ESTADO = 'A' AND H.ESTADO = 'A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //guardamos los datos en el array
            horas.removeAllItems();
            horas.addItem("Selecionar Horario");

            while (rs.next()) {
                verifica = rs.getString(1);
                horas.addItem(rs.getString(1) + " hasta " + rs.getString(2));
            }
            if (verifica == "") {

                JOptionPane.showMessageDialog(null, "El medico no esta disponible el dia seleccionado");
            } else {
                JOptionPane.showMessageDialog(null, "Horaios del medico cargados");
            }
            con.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar las horas disponibles de la base " + e);
        }
    }

    public int verificarhoraDAO(Connection con, int id, String hora, String fecha) {
        int idr = 0;
        //System.out.println("f" + fecha);
        String sql = "select id_cita from citas where (hora = '" + hora + "'  and (fecha = TO_CHAR(TO_DATE('" + fecha + "','DD/MM/YYYY'))))and id_veterinario=" + id + " and estado='P'";
        //System.out.println("ssss" + sql);
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idr = rs.getInt(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al verificar horas disponibles" + e);
        }
        return idr;
    }

    public String traerprecioDAO(Connection con, int ids) {
        String precio = "";
        String sql = "select precio from servicios where id_servicio=" + ids + " and estado = 'A'";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                precio = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al extraer el precio del servicio " + e);
        }
        return precio;
    }

    public Persona datosdueñoDAO(Connection con, int idd) {
        Persona pefac = new Persona();
        String sql = "select p.PERSONA_TELEFONO, p.PERSONA_CORREO, p.PERSONA_DIRECCION from personas p, propietario r where p.PERSONA_ID = r.PERSONA_ID and r.PROPIETARIO_ID=" + idd + " and r.estado = 'A' ";
        try {

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                pefac.setTelefono(rs.getString(1));
                pefac.setCorreo(rs.getString(2));
                pefac.setDireccion(rs.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "error al importar los datos del dueño (en la Base) " + e);
        }
        return pefac;
    }

    public int getIDFacturaDAO(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(id_factura) FROM factura";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar id de la Factura " + e);
        }
        return id;
    }

    public String agregarFacturaDAO(Connection con, CFactura f) {
        String sql = "insert into FACTURA (ID_FACTURA, ID_PROPIETARIO, FECHA, TOTAL) values (?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, f.getID_FACTURA());
            ps.setInt(2, f.getID_PROPIETARIO());
            ps.setDate(3, java.sql.Date.valueOf(f.getFECHA()));
            ps.setDouble(4, f.getTOTAL());
            ps.executeQuery();
            ps.close();
            mensaje = "Registrado Exitosamente";

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al Guardar los datos de la Factura " + e);
        }
        return mensaje;
    }

    public void mostrarF(Connection conn, String num) {

        try {
            HashMap parametro = new HashMap();
            parametro.put("Id_factura", num);
            parametro.put("Imagen", "LogoVeterinaria.png");
            JasperReport jp = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Factura.jasper"));
            JasperPrint jprin2 = JasperFillManager.fillReport(jp, parametro, conn);
            JasperViewer.viewReport(jprin2, false);
            
        } catch (JRException e) {
            System.out.println("Erro repor " + e);
        }

    }

    public void mostrarT(Connection conn, String num) {
        try {
            HashMap parametro = new HashMap();
            parametro.put("Id_fac", num);
            parametro.put("Imagen", "LogoVeterinaria.png");
            JasperReport jp = (JasperReport) JRLoader.loadObject(getClass().getResource("/Reportes/Ticket.jasper"));
            JasperPrint jprin2 = JasperFillManager.fillReport(jp, parametro, conn);
            JasperViewer.viewReport(jprin2, false);
        } catch (Exception e) {
        }
    }

}
