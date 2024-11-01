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

public class CrudEjemplar extends Conexion {
    
    public boolean registrarEjemplar(Ejemplar eje){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        String sql = "INSERT INTO \"Ejemplar\" (\"idLibro\",\"idEstadoEj\", \"ubicacion\") VALUES (?, ?, ?)";
       
          
        try{
            ps = con.prepareStatement(sql); 
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
        
        String sql = "UPDATE \"Ejemplar\" SET \"idLibro\" = ?, \"idEstadoEj\" = ?,  \"ubicacion\" = ? WHERE \"idEjemplar\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
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
    // METODO PARA CREAR UNA LISTA DE OBJETOS DE LA CLASE
        public ArrayList<Ejemplar> listarEjemplar(Ejemplar eje) throws ParseException {
    // CREA E INICIALIZA UNA NUEVA ARRAYLIST DE LOS OBJETOS
        ArrayList<Ejemplar> datosEjemplar = new ArrayList<>();
    // SE INICIALIZA Y PREPARAR LAS CONSULTAS SQL CON SU RESPECTIVA CONEXION
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
    // CONSULTA SQL

        String sql = "SELECT * FROM \"Ejemplar\"";
        // PROBAR SI SE PUEDE REALIZAR LA OPERACION
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCION
            while (rs.next()) {
                // CREA UN  NUEVO OBJETO PARA AÑADIR AL ARREGLO
                Ejemplar ejemplar = new Ejemplar();
                // OBTIENE LOS ATRIBUTOS PARA LA CREACION
                ejemplar.setIdEjemplar(Integer.parseInt(rs.getString("idEjemplar")));
                ejemplar.setIdLibro(Integer.parseInt(rs.getString("idLibro")));
                ejemplar.setIdEstadoEj(Integer.parseInt(rs.getString("idEstadoEj")));
                ejemplar.setUbicacion(rs.getString("ubicacion"));
                // SE AÑADE EL OBJETO AL ARREGLO
                datosEjemplar.add(ejemplar);
            }
            // ANTE CUALQUIER PROBLEMA, ENTREGAR UN ARREGLO VACIO O EXCEPCION
            return datosEjemplar;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datosEjemplar;
    }    
}
