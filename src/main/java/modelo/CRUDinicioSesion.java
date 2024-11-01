
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudInicioSesion extends Conexion{
    /*Verificar si las credenciales ingresadas en la ventana de inicio coinciden
    con las credenciales de algun registro en la tabla de usuario */
    
    public boolean buscarEstudiante(InicioSesion inicioSesion){
        
        PreparedStatement ps = null;  // variable de tipo consulta preparada
        ResultSet rs = null;          // variable que va a guardar resultado de consulta
        Connection con = getConexion(); //Conexion a la base de datos
        
        String sql = "SELECT * FROM \"Usuario\" WHERE \"tipo\" = 1 AND \"nombre\" = ? AND \"contraseña\" = ?";
        
        try { //Si no hay error, se manda consulta sql con datos a bd
            ps = con.prepareStatement(sql);
            ps.setString(1, inicioSesion.getNombreUsuario());
            ps.setString(2, inicioSesion.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) { //Si se encontro un registro
                inicioSesion.setNombreUsuario(rs.getString("nombre")); //Establecer los valores encontrados en la tabla al objeto inicioSesion
                inicioSesion.setContrasena(rs.getString("contraseña"));
                return true;
            }
            return false; //No se encontro un registro
        } catch (SQLException e) { //Hubo algun error
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya podido hacer consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscarProfesor(InicioSesion inicioSesion){
        
        PreparedStatement ps = null;  // variable de tipo consulta preparada
        ResultSet rs = null;          // variable que va a guardar resultado de consulta
        Connection con = getConexion(); //Conexion a la base de datos
        
        String sql = "SELECT * FROM \"Usuario\" WHERE \"tipo\" = 2 AND \"nombre\" = ? AND \"contraseña\" = ?";
        
        try { //Si no hay error, se manda consulta sql con datos a bd
            ps = con.prepareStatement(sql);
            ps.setString(1, inicioSesion.getNombreUsuario());
            ps.setString(2, inicioSesion.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) { //Si se encontro un registro
                inicioSesion.setNombreUsuario(rs.getString("nombre")); //Establecer los valores encontrados en la tabla al objeto inicioSesion
                inicioSesion.setContrasena(rs.getString("contraseña"));
                return true;
            }
            return false; //No se encontro un registro
        } catch (SQLException e) { //Hubo algun error
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya podido hacer consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscarAdministrador(InicioSesion inicioSesion){
        
        PreparedStatement ps = null;  // variable de tipo consulta preparada
        ResultSet rs = null;          // variable que va a guardar resultado de consulta
        Connection con = getConexion(); //Conexion a la base de datos
        
        String sql = "SELECT * FROM \"Usuario\" WHERE \"tipo\" = 3 AND \"nombre\" = ? AND \"contraseña\" = ?";
        
        try { //Si no hay error, se manda consulta sql con datos a bd
            ps = con.prepareStatement(sql);
            ps.setString(1, inicioSesion.getNombreUsuario());
            ps.setString(2, inicioSesion.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) { //Si se encontro un registro
                inicioSesion.setNombreUsuario(rs.getString("nombre")); //Establecer los valores encontrados en la tabla al objeto inicioSesion
                inicioSesion.setContrasena(rs.getString("contraseña"));
                return true;
            }
            return false; //No se encontro un registro
        } catch (SQLException e) { //Hubo algun error
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya podido hacer consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean buscarExterno(InicioSesion inicioSesion){
        
        PreparedStatement ps = null;  // variable de tipo consulta preparada
        ResultSet rs = null;          // variable que va a guardar resultado de consulta
        Connection con = getConexion(); //Conexion a la base de datos
        
        String sql = "SELECT * FROM \"Usuario\" WHERE \"tipo\" = 4 AND \"nombre\" = ? AND \"contraseña\" = ?";
        
        try { //Si no hay error, se manda consulta sql con datos a bd
            ps = con.prepareStatement(sql);
            ps.setString(1, inicioSesion.getNombreUsuario());
            ps.setString(2, inicioSesion.getContrasena());
            rs = ps.executeQuery();

            if (rs.next()) { //Si se encontro un registro
                inicioSesion.setNombreUsuario(rs.getString("nombre")); //Establecer los valores encontrados en la tabla al objeto inicioSesion
                inicioSesion.setContrasena(rs.getString("contraseña"));
                return true;
            }
            return false; //No se encontro un registro
        } catch (SQLException e) { //Hubo algun error
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya podido hacer consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
