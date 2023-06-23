package Modelo;

import java.sql.Connection;

public class RContraseñaBO {
    private String mensaje = "";
    private RContraseñaDAO rdao = new RContraseñaDAO();
    
    public String modificarContra(String contra, String usuario){
            Connection conn = Conexion.getConection();
        try {
            mensaje = rdao.modificarContra(conn, contra, usuario);
        } catch (Exception e) {
            mensaje = mensaje + " " +e.getMessage();
        }finally{
            try {
                if(conn != null){
                    conn.close();
                }
            } catch (Exception e) {
                mensaje = mensaje + " " +e.getMessage();
            }
        }
        return mensaje;
    }
}
