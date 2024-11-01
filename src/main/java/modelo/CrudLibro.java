/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
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
            ps.setString(1, lib.getTitulo()); 
            ps.setString(2, lib.getAutor());
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
        
        String sql = "UPDATE \"Libro\" SET \"titulo\" = ?, \"autor\" = ?, \"año\" = ?, \"idCategoria\" = ? WHERE \"idLibro\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
            //PASO LOS DATOS. Los datos se pasan siguiendo el mismo orden de la sentencia
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
    // METODO PARA CREAR UNA LISTA DE OBJETOS DE LA CLASE
    public ArrayList<Libro> listarLibro(Libro lib) throws ParseException {
        // CREA E INICIALIZA UNA NUEVA ARRAY LIST DE LOS OBJETOS
            ArrayList<Libro> datosLibro = new ArrayList<>();
            // SE INICIALIZA Y PREPARAN LAS CONSULTAS SQL CON SU RESPECTIVA CONEXION
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection con = getConexion();
            // CONSULTA SQL
            String sql = "SELECT * FROM \"Libro\"";
            // PROBAR SI SE PUEDE REALIZAR LA OPERACION

            try {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCION
                while (rs.next()) {
                    // CREA UN NUEVO OBJETO PARA AÑADIR AL ARREGLO
                    Libro libro = new Libro();
                    // OBTIENE LOS ATRIBUTOS PARA LA CREACION
                    libro.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                    libro.setTitulo(rs.getString("titulo"));
                    libro.setAutor(rs.getString("autor"));
                    libro.setAño(Integer.parseInt(rs.getString("año")));
                    libro.setIdCategoria(Integer.parseInt(rs.getString("idCategoria")));
                    // SE AÑADE EL OBJETO AL ARREGLO
                    datosLibro.add(libro);
                }
                // DEVUELVE EL ARREGLO
                return datosLibro;
                // ANTE CUALQUIER PROBLEMA, ENTREGA UN ARREGLO VACIO O EXCEPCION
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
