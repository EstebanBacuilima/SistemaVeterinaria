package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RContraseñaDAO {
    private String mensaje = "";

    public String modificarContra(Connection conn, String contra, String usuario){
        PreparedStatement ps = null;
        String sql = "UPDATE USUARIOS SET CONTRASEÑA = '" + contra + "' WHERE USUARIO = '" + usuario + "'";
        try{
                ps = conn.prepareStatement(sql);
                mensaje = "CONTRASEÑA ACTUALIZADA";
                ps.execute();
                ps.close();            
        }catch(SQLException e){
            mensaje = "NO SE HA ACTUALIZADO EXITOSAMENTE \n " + e.getMessage();
        }
        return mensaje;
    }
  
}
