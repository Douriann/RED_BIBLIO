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

public class CrudEstudiante extends Conexion implements CrudAbstracto{
    
    public boolean registrarEstudiante(Estudiante estudiante){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "INSERT INTO \"Usuario\" (\"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\",\"idCarrera\")  VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, estudiante.getCedula()); 
            ps.setString(2, estudiante.getNombre());   
            ps.setString(3, estudiante.getApellido()); 
            ps.setInt(4, estudiante.getTipo()); 
            ps.setString(5, estudiante.getContacto());
            ps.setString(6, estudiante.getContraseña());
            ps.setInt(7, estudiante.getIdBiblioteca());
            ps.setInt(8, estudiante.getIdCarrera());
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
    
    public boolean modificarEstudiante(Estudiante estudiante){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "UPDATE \"Usuario\" SET \"cedula\" =?, \"nombre\"=?, \"apellido\"=?, \"contacto\"=?,\"contraseña\"=?,\"idBiblioteca\"=?, \"idCarrera\"=? WHERE \"cedula\"=?";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, estudiante.getCedula()); 
            ps.setString(2, estudiante.getNombre());   
            ps.setString(3, estudiante.getApellido()); 
            ps.setString(4, estudiante.getContacto());
            ps.setString(5, estudiante.getContraseña());
            ps.setInt(6, estudiante.getIdBiblioteca());
            ps.setInt(7, estudiante.getIdCarrera());
            ps.setInt(8, estudiante.getCedula());
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
    
    public boolean eliminarEstudiante(Estudiante estudiante){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "DELETE FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, estudiante.getCedula()); 
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
    
    public boolean BuscarEstudiante(Estudiante estudiante){
        
        // Consulta preparada, variable que guardara registro y apertura de conexion a bd 
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "SELECT \"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\",\"idCarrera\" FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, estudiante.getCedula()); 
            rs = ps.executeQuery();             //Ejecuto consulta y guardo resultado
            
            if(rs.next()){
                //Establezco valores a objeto. Los datos vienen de BD
                estudiante.setCedula(Integer.parseInt(rs.getString("cedula")));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTipo(Integer.parseInt(rs.getString("tipo")));
                estudiante.setContacto(rs.getString("contacto"));
                estudiante.setContraseña(rs.getString("contraseña"));
                estudiante.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                estudiante.setIdCarrera(Integer.parseInt(rs.getString("idCarrera")));
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

