/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author scocl
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private final String HOST = "localhost";
    private final String PUERTO = "5432";
    private final String DB = "BD_RED_BIBLIOTECA";
    private final String USER = "postgres";
    private final String PASSWORD = "michumiau123";
    
        //Metodo que retorna objeto de tipo conexion
    public Connection getConexion(){
        Connection conexion = null; //objeto conexion
        
        try{
            Class.forName("org.postgresql.Driver"); //Hacer referencia a un archivo
            String url = "jdbc:postgresql://"+HOST+":"+PUERTO+"/"+DB;
            conexion = DriverManager.getConnection(url,USER, PASSWORD);
            JOptionPane.showMessageDialog(null,"CONEXION EXITOSA");
        }catch(Exception e){      
                JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return conexion;
    }
}