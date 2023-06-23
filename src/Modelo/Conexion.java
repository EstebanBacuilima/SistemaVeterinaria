package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static Connection con;
    private static String url = "jdbc:oracle:thin:@localhost:1521:orcl";//XE //orcl
    private static String usuario = "VETERINARIA";
    private static String password = "1234";
    
    public static Connection getConection(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(url,usuario,password);
            if (con != null) {
                //System.out.println("CONECTADO");
            } else {
                System.out.println("DESCONECTADO");
            }
     
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion");
        }
        return con;
    }   


}
