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
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CrudBiblioteca extends Conexion {
    
    public boolean registrarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();

        
        //Sentencia correcta. Quite palabra public. No se registra el id. La BD lo genera de forma automatica.
        String sql = "INSERT INTO \"Biblioteca\" (\"nomBiblioteca\", \"direccion\") VALUES (?, ?)";

          
        try{
            ps = con.prepareStatement(sql); 
            ps.setString(1, bli.getNomBiblioteca()); //Primero se manda nombre de biblioteca
            ps.setString(2, bli.getDireccion());    // Segundo la direccion
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
    public boolean modificarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        

        String sql = "UPDATE \"Biblioteca\" SET \"nomBiblioteca\" = ?, \"direccion\" = ? WHERE \"idBiblioteca\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
            //PASO LOS DATOS. Aqui si se pasa el id. Los datos se pasan siguiendo el mismo orden de la sentencia
            ps.setString(1, bli.getNomBiblioteca()); 
            ps.setString(2, bli.getDireccion());
            ps.setInt(3, bli.getIdBiblioteca());
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
    public boolean eliminarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "DELETE FROM \"Biblioteca\" WHERE \"idBiblioteca\" = ?";

        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, bli.getIdBiblioteca()); //PASO LOS DATOS
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
    public boolean buscarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        ResultSet rs = null; //Variable que guarda resultado de consulta. Es decir registro
        Connection con = getConexion();
        
        //Como se seleccionan todas las columnas de la tabla, se puede usar el operador *
        String sql = "SELECT * FROM \"Biblioteca\" WHERE \"idBiblioteca\" = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, bli.getIdBiblioteca());
            rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()
            
            if(rs.next()) //Si encontro algo realiza esta logica
            {
                bli.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                bli.setNomBiblioteca(rs.getString("nomBiblioteca"));
                bli.setDireccion(rs.getString("direccion"));
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
        // METODO PARA CREAR UNA LISTA DE OBJETOS DE LA CLASE BIBLIOTECA
        public ArrayList<Biblioteca> listarBiblioteca(Biblioteca bli) throws ParseException {
        // CREA E INICIALIZA UNA NUEVA ARRAYLIST DE LOS OBJETOS
        ArrayList<Biblioteca> datosBiblio = new ArrayList<>();
        // SE INICIALIZA Y PREPARAN LAS CONSULTAS SQL CON SU RESPECTIVA CONEXION
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        // CONSULTA SQL
        String sql = "SELECT * FROM \"Biblioteca\"";
        // PROBAR SI SE PUEDE REALIZAR LA OPERACION
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCION
            while (rs.next()) {
                // CREA UN NUEVO OBJETO DE BIBLIOTECA PARA AÑADIR AL ARREGLO
                Biblioteca biblioteca = new Biblioteca();
                // OBTIENE LOS ATRIBUTOS PARA LA CREACION
                biblioteca.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                biblioteca.setNomBiblioteca(rs.getString("nomBiblioteca"));
                biblioteca.setDireccion(rs.getString("direccion"));
                // SE AÑADE EL OBJETO AL ARREGLO
                datosBiblio.add(biblioteca);
            }
            // ANTE CUALQUIER PROBLEMA, ENTREGA UN ARREGLO VACIO O EXCEPCION
            return datosBiblio;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datosBiblio;
    }
}
