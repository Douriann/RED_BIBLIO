/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;

public class CrudLibro extends Conexion {
    
    public boolean registrarLibro(Libro lib){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO \"Libro\" (\"titulo\", \"autor\",\"año\", \"idCategoria\") VALUES (?, ?, ?, ?)";

          
        try{
            ps = con.prepareStatement(sql); 
            //ps.setInt(1, bli.getIdBiblioteca()); //PASO LOS DATOS. EL ID NO SE REGISTRA
            ps.setString(1, lib.getTitulo()); //Acomode los numeros. Primero se manda nombre de biblioteca
            ps.setString(2, lib.getAutor());// Segundo la direccion
            ps.setInt(3, lib.getAño());
            ps.setInt(4, lib.getIdCategoria());
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
    public boolean modificarLibro(Libro lib){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "UPDATE Biblioteca SET nomBiblioteca=?, direccion=? WHERE idBiblioteca=?";
        String sql = "UPDATE \"Libro\" SET \"titulo\" = ?, \"autor\" = ?, \"año\" = ?, \"idCategoria\" = ? WHERE \"idLibro\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
            //PASO LOS DATOS. Aqui si se pasa el id. Los datos se pasan siguiendo el mismo orden de la sentencia
            ps.setString(1, lib.getTitulo()); 
            ps.setString(2, lib.getAutor());
            ps.setInt(3, lib.getAño());
            ps.setInt(4, lib.getIdCategoria());
            ps.setInt(5, lib.getIdLibro());
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
    public boolean eliminarLibro(Libro lib){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "DELETE FROM Biblioteca WHERE idBiblioteca=?";
        String sql = "DELETE FROM \"Libro\" WHERE \"idLibro\" = ?";

        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, lib.getIdLibro()); //PASO LOS DATOS
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
    public boolean buscarLibro(Libro lib){
        PreparedStatement ps = null;
        ResultSet rs = null; //Variable que guarda resultado de consulta. Es decir registro
        Connection con = getConexion();
        
        
        
        //Como se seleccionan todas las columnas de la tabla, se puede usar el operador *
        String sql = "SELECT * FROM \"Libro\" WHERE \"idLibro\" = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, lib.getIdLibro());
            rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()
            
            if(rs.next()) //Si encontro algo realiza esta logica
            {
                lib.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                lib.setTitulo(rs.getString("titulo"));
                lib.setAutor(rs.getString("autor"));
                lib.setAño(Integer.parseInt(rs.getString("año")));
                lib.setIdCategoria(Integer.parseInt(rs.getString("idCategoria")));
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
    
    
    public boolean buscarCantEjemplares(Libro lib){
            PreparedStatement ps = null;
            ResultSet rs = null; //Variable que guarda resultado de consulta. Es decir registro
            Connection con = getConexion();
        
            String sql = "SELECT \"cantEjemplares\" FROM \"BibliotecaLibro\" WHERE \"idBibliotecaLibro\" = ?";
            try{
                ps = con.prepareStatement(sql); 
                ps.setInt(1, lib.getIdBibliotecaLibro());
                rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()
            
                if(rs.next()) //Si encontro algo realiza esta logica
                {
                lib.setCantEjemplares(Integer.parseInt(rs.getString("cantEjemplares")));
                return true; //El return true. Esto indica que se encontro un registro y se inicializo el objeto con los valores encontrados en bd
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
    public ArrayList<Libro> listarLibro(Libro lib) throws ParseException {
            ArrayList<Libro> datosLibro = new ArrayList<>();
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();

            String sql = "SELECT * FROM \"Libro\"";

            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();

                while (rs.next()) {
                    Libro libro = new Libro();
                    libro.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setAño(Integer.parseInt(rs.getString("año")));
                    libro.setIdCategoria(Integer.parseInt(rs.getString("idCategoria")));
                    datosLibro.add(libro);
                }
                return datosLibro;
            } catch (SQLException e) {
                System.err.println(e);
            } finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
            return datosLibro;
    }   
}
