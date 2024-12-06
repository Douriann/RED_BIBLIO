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
import factoriaAbstracta.CrudAbstracto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudAdmin extends Conexion implements CrudAbstracto{
    
    public boolean registrarAdmin(Administrador admin){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "INSERT INTO \"Usuario\" (\"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\")  VALUES (?,?,?,?,?,?,?)";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, admin.getCedula()); 
            ps.setString(2, admin.getNombre());   
            ps.setString(3, admin.getApellido()); 
            ps.setInt(4, admin.getTipo()); 
            ps.setString(5, admin.getContacto());
            ps.setString(6, admin.getContraseña());
            ps.setInt(7, admin.getIdBiblioteca());
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
    
    public boolean modificarAdmin(Administrador admin){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "UPDATE \"Usuario\" SET \"cedula\" =?, \"nombre\"=?, \"apellido\"=?, \"contacto\"=?,\"contraseña\"=?,\"idBiblioteca\"=? WHERE \"cedula\"=?";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, admin.getCedula()); 
            ps.setString(2, admin.getNombre());   
            ps.setString(3, admin.getApellido()); 
            ps.setString(4, admin.getContacto());
            ps.setString(5, admin.getContraseña());
            ps.setInt(6, admin.getIdBiblioteca());
            ps.setInt(7, admin.getCedula());
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
    
    public boolean eliminarAdmin(Administrador admin){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "DELETE FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, admin.getCedula()); 
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
    
    public boolean BuscarAdmin(Administrador admin){
        
        // Consulta preparada, variable que guardara registro y apertura de conexion a bd 
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "SELECT \"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\" FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, admin.getCedula()); 
            rs =ps.executeQuery();             //Ejecuto consulta y guardo resultado
            
            if(rs.next()){
                //usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                //Establezco valores a objeto. Los datos vienen de BD
                admin.setCedula(Integer.parseInt(rs.getString("cedula")));
                admin.setNombre(rs.getString("nombre"));
                admin.setApellido(rs.getString("apellido"));
                admin.setTipo(Integer.parseInt(rs.getString("tipo")));
                admin.setContacto(rs.getString("contacto"));
                admin.setContraseña(rs.getString("contraseña"));
                admin.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
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

    @Override
    public void objetivo() {
        System.out.println("Consultas a tabla usuario");
    }
}