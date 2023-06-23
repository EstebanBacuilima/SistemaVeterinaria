
package Modelo;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class ServiciosDAO {

    PreparedStatement ps;
    ResultSet rs;
    private String mensaje = "";
    
    public ArrayList listarS (Connection con, String nom, char estado){

        String sql = "";
        if (estado == 'A') {
            if (nom.equals("")) {

                sql = "SELECT * FROM servicios WHERE estado='A' ORDER BY id_servicio";

            } else {

                sql = "SELECT * FROM servicios WHERE nombre like '%" + nom + "%' and estado='A' ORDER BY id_servicio";
            }
        } else if (estado == 'I') {
            if (nom.equals("")) {

                sql = "SELECT * FROM servicios WHERE estado='I' ORDER BY id_servicio ";

            } else {

                sql = "SELECT * FROM servicios WHERE nombre like '%" + nom + "%' and estado='I' ORDER BY id_servicio ";
            }

        }
        
        ArrayList<Servicio>datos=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Servicio s=new Servicio();
                s.setId(rs.getInt(1));
                s.setNom(rs.getString(2));
                s.setDesc(rs.getString(3));
                s.setPrecio(rs.getDouble(4));
                datos.add(s);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public int getSerID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(id_servicio) FROM servicios";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("1.Error al mostrar id " + e.getMessage());
        }
        return id;
    }
    
    
    public String agregarS(Connection con, Servicio s){
        String sql="insert into servicios (id_servicio, nombre, descripcion, Precio, Estado) values (?,?,?,?,'A')";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        
        try {
            double precioV = s.getPrecio();
            formato1.format(precioV);
            String pre = formato1.format(precioV);
            ps=con.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getNom());
            ps.setString(3, s.getDesc());
            ps.setString(4, pre);
            ps.executeQuery();
            ps.close();
            mensaje = "Registrado Exitosamente";
            
        } catch (SQLException e) {
            mensaje = "Error al Registrar "+e;
        }
        return mensaje;
    }
    
    public String actualizarS(Connection con, Servicio s){
        String sql = "update servicios set nombre=?, descripcion=?, precio=? where id_servicio = ?";
        DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
        separadoresPersonalizados.setDecimalSeparator('.');
        DecimalFormat formato1 = new DecimalFormat("#.00", separadoresPersonalizados);
        try {
            double precioV = s.getPrecio();
            formato1.format(precioV);
            String pre = formato1.format(precioV);
            ps=con.prepareStatement(sql);
            ps.setString(1, s.getNom());
            ps.setString(2, s.getDesc());
            ps.setString(3, pre);
            ps.setInt(4, s.getId());
            ps.executeUpdate();
            ps.close();
            mensaje = "Servicio Actualizado";
            
        } catch (SQLException e) {
            mensaje = "Servicio Actualizado"+e;
        }
        return mensaje;
    }
    
    public String eliminarS(Connection con, int id){
 
        String sql = "update servicios set estado='I' where id_servicio="+id;
        try {
            ps=con.prepareStatement(sql); 
            ps.executeUpdate();
            ps.close();
            mensaje = "Servicio Eliminado";
        } catch (SQLException e) {
            System.out.println("Error al eliminar "+e);
        }
        return mensaje;
    }
    
}



























