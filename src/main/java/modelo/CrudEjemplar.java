/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class CrudEjemplar extends Conexion {
    
    public boolean registrarEjemplar(Ejemplar eje){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO \"Ejemplar\" (\"idLibro\",\"idEstadoEj\", \"ubicacion\") VALUES (?, ?, ?)";
       
          
        try{
            ps = con.prepareStatement(sql); 
            //ps.setInt(1, bli.getIdEjemplar()); //PASO LOS DATOS. EL ID NO SE REGISTRA
            ps.setInt(1, eje.getIdLibro());
            ps.setInt(2, eje.getIdEstadoEj());
            ps.setString(3, eje.getUbicacion());// Segundo la direccion
            ps.execute();                            //EJECUTO CONSULTA
            return true;
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }  
    }
    
    public boolean modificarEjemplar(Ejemplar eje){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "UPDATE Biblioteca SET nomBiblioteca=?, direccion=? WHERE idBiblioteca=?";
        String sql = "UPDATE \"Ejemplar\" SET \"idLibro\" = ?, \"idEstadoEj\" = ?,  \"ubicacion\" = ? WHERE \"idEjemplar\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
            //PASO LOS DATOS. Aqui si se pasa el id. Los datos se pasan siguiendo el mismo orden de la sentencia
            ps.setInt(1, eje.getIdLibro());
            ps.setInt(2, eje.getIdEstadoEj());
            ps.setString(3, eje.getUbicacion()); 
            ps.setInt(4, eje.getIdEjemplar());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean eliminarEjemplar(Ejemplar eje){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "DELETE FROM Biblioteca WHERE idBiblioteca=?";
        String sql = "DELETE FROM \"Ejemplar\" WHERE \"idEjemplar\" = ?";

        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, eje.getIdEjemplar()); //PASO LOS DATOS
            ps.execute();                            //EJECUTO CONSULTA
            return true;
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    public boolean buscarEjemplar(Ejemplar eje){
        PreparedStatement ps = null;
        ResultSet rs = null; //Variable que guarda resultado de consulta. Es decir registro
        Connection con = getConexion();
        
        //Como se seleccionan todas las columnas de la tabla, se puede usar el operador *
        String sql = "SELECT * FROM \"Ejemplar\" WHERE \"idEjemplar\" = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, eje.getIdEjemplar());
            rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()
            
            if(rs.next()) //Si encontro algo realiza esta logica 
            {
                eje.setIdEjemplar(Integer.parseInt(rs.getString("idEjemplar")));
                eje.setIdEstadoEj(Integer.parseInt(rs.getString("idEstadoEj")));
                eje.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                eje.setUbicacion(rs.getString("ubicacion"));
                return true; //Faltaba el return true. Esto indica que se encontro un registro y se inicializo el objeto biblioteca con los valores encontrados en bd
            }
            return false; //Si no encontro registro retorna falso
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
