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

public class CrudProfesor extends Conexion implements CrudAbstracto{
    
    public boolean registrarProfesor(Profesor profesor){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "INSERT INTO \"Usuario\" (\"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\",\"idTituloAcad\",\"idDepartamento\")  VALUES (?,?,?,?,?,?,?,?,?)";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, profesor.getCedula()); 
            ps.setString(2, profesor.getNombre());   
            ps.setString(3, profesor.getApellido()); 
            ps.setInt(4, profesor.getTipo()); 
            ps.setString(5, profesor.getContacto());
            ps.setString(6, profesor.getContraseña());
            ps.setInt(7, profesor.getIdBiblioteca());
            ps.setInt(8, profesor.getIdTituloAcad());
            ps.setInt(9, profesor.getIdDepartamento());
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
    
    public boolean modificarProfesor(Profesor profesor){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "UPDATE \"Usuario\" SET \"cedula\" =?, \"nombre\"=?, \"apellido\"=?, \"contacto\"=?,\"contraseña\"=?,\"idBiblioteca\"=?, \"idTituloAcad\"=?, \"idDepartamento\"=? WHERE \"cedula\"=?";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, profesor.getCedula()); 
            ps.setString(2, profesor.getNombre());   
            ps.setString(3, profesor.getApellido()); 
            ps.setString(4, profesor.getContacto());
            ps.setString(5, profesor.getContraseña());
            ps.setInt(6, profesor.getIdBiblioteca());
            ps.setInt(7, profesor.getIdTituloAcad());
            ps.setInt(8, profesor.getIdDepartamento());
            ps.setInt(9, profesor.getCedula());
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
    
    public boolean eliminarProfesor(Profesor profesor){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "DELETE FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, profesor.getCedula()); 
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
    
    public boolean BuscarProfesor(Profesor profesor){
        
        // Consulta preparada, variable que guardara registro y apertura de conexion a bd 
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "SELECT \"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\", \"idTituloAcad\", \"idDepartamento\" FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, profesor.getCedula()); 
            rs =ps.executeQuery();             //Ejecuto consulta y guardo resultado
            
            if(rs.next()){
                //usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                //Establezco valores a objeto. Los datos vienen de BD
                profesor.setCedula(Integer.parseInt(rs.getString("cedula")));
                profesor.setNombre(rs.getString("nombre"));
                profesor.setApellido(rs.getString("apellido"));
                profesor.setTipo(Integer.parseInt(rs.getString("tipo")));
                profesor.setContacto(rs.getString("contacto"));
                profesor.setContraseña(rs.getString("contraseña"));
                profesor.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                profesor.setIdTituloAcad(Integer.parseInt(rs.getString("idTituloAcad")));
                profesor.setIdDepartamento(Integer.parseInt(rs.getString("idDepartamento")));
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

