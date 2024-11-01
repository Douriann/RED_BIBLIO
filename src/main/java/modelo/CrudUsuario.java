/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;

// IMPORTANDO LIBRERIAS NECESARIAS
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudUsuario extends Conexion{
    
    public boolean registrarUsuario(Usuario usuario){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "INSERT INTO \"Usuario\" (\"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\")  VALUES (?,?,?,?,?,?,?)";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, usuario.getCedula()); 
            ps.setString(2, usuario.getNombre());   
            ps.setString(3, usuario.getApellido()); 
            ps.setInt(4, usuario.getTipo()); 
            ps.setString(5, usuario.getContacto());
            ps.setString(6, usuario.getContraseña());
            ps.setInt(7, usuario.getIdBiblioteca());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
        } catch(SQLException e) //Maneja cualquier error
        {
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya hecho consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean modificarUsuario(Usuario usuario){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "UPDATE \"Usuario\" SET \"cedula\" =?, \"nombre\"=?, \"apellido\"=?, \"contacto\"=?,\"contraseña\"=?,\"idBiblioteca\"=? WHERE \"cedula\"=?";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, usuario.getCedula()); 
            ps.setString(2, usuario.getNombre());   
            ps.setString(3, usuario.getApellido()); 
            ps.setString(4, usuario.getContacto());
            ps.setString(5, usuario.getContraseña());
            ps.setInt(6, usuario.getIdBiblioteca());
            ps.setInt(7, usuario.getCedula());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
        } catch(SQLException e) //Maneja cualquier error
        {
            System.err.println(e);
            return false;
        } finally { //Finalmente cierra la conexion asi se haya hecho consulta o no
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
    public boolean eliminarUsuario(Usuario usuario){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "DELETE FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, usuario.getCedula()); 
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
    
    public boolean BuscarUsuario(Usuario usuario){
        
        // Consulta preparada, variable que guardara registro y apertura de conexion a bd 
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "SELECT \"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\" FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, usuario.getCedula()); 
            rs =ps.executeQuery();             //Ejecuto consulta y guardo resultado
            
            if(rs.next()){
                //usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                //Establezco valores a objeto. Los datos vienen de BD
                usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido(rs.getString("apellido"));
                usuario.setTipo(Integer.parseInt(rs.getString("tipo")));
                usuario.setContacto(rs.getString("contacto"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                return true;
            }
            return false;
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
