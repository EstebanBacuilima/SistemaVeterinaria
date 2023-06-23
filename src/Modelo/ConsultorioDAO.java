
package Modelo;


import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultorioDAO {

    PreparedStatement ps;
    ResultSet rs;
    private String mensaje = "";
    
    public ArrayList listarCo (Connection con, String nom, char estado){

        String sql = "";
        if (estado == 'A') {
            if (nom.equals("")) {

                sql = "SELECT * FROM area_trabajo WHERE estado='A' ORDER BY id_area";

            } else {

                sql = "SELECT * FROM AREA_TRABAJO  WHERE nombre like '%" + nom + "%' and estado='A' ORDER BY id_area";
            }
        } else if (estado == 'I') {
            if (nom.equals("")) {

                sql = "SELECT * FROM AREA_TRABAJO WHERE estado='I' ORDER BY id_area ";

            } else {

                sql = "SELECT * FROM AREA_TRABAJO WHERE nombre like '%" + nom + "%' and estado='I' ORDER BY id_area ";
            }

        }
        
        ArrayList<Consultorio>datos=new ArrayList<>();
        try {
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Consultorio co=new Consultorio();
                co.setId(rs.getInt(1));
                co.setNom(rs.getString(2));
                co.setDesc(rs.getString(3));
                datos.add(co);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    
    public int getConsID(Connection conn) {

        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(id_area) FROM AREA_TRABAJO";
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
    
    
    public String agregarCo(Connection con, Consultorio co){
        String sql="insert into AREA_TRABAJO (id_area, nombre, descripcion, Estado) values (?,?,?,'A')";
        try {
            
            ps=con.prepareStatement(sql);
            ps.setInt(1, co.getId());
            ps.setString(2, co.getNom());
            ps.setString(3, co.getDesc());
            ps.executeQuery();
            ps.close();
            mensaje = "Registrado Exitosamente";
            
        } catch (SQLException e) {
            mensaje = "Error al Registrar "+e;
        }
        return mensaje;
    }
    
    public String actualizarCo(Connection con, Consultorio co){
        String sql = "update AREA_TRABAJO set nombre=?, descripcion=? where id_area = ?";
        try {
            ps=con.prepareStatement(sql);
            ps.setString(1, co.getNom());
            ps.setString(2, co.getDesc());
            ps.setInt(3, co.getId());
            ps.executeUpdate();
            ps.close();
            mensaje = "Consultorio Actualizado";
            
        } catch (SQLException e) {
            mensaje = "Consultorio Actualizado"+e;
        }
        return mensaje;
    }
    
    public String eliminarCo(Connection con, int id){
 
        String sql = "update AREA_TRABAJO set estado='I' where id_area="+id;
        try {
            ps=con.prepareStatement(sql); 
            ps.executeUpdate();
            ps.close();
            mensaje = "Consultorio Eliminado";
        } catch (SQLException e) {
            mensaje ="Error al eliminar "+e;
        }
        return mensaje;
    }
    
}



























