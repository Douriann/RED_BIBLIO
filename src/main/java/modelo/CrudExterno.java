/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */

package modelo;

import factoriaAbstracta.CrudAbstracto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudExterno extends Conexion implements CrudAbstracto{
    
    public boolean registrarExterno(Externo externo){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "INSERT INTO \"Usuario\" (\"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\",\"direccion\")  VALUES (?,?,?,?,?,?,?,?)";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, externo.getCedula()); 
            ps.setString(2, externo.getNombre());   
            ps.setString(3, externo.getApellido()); 
            ps.setInt(4, externo.getTipo()); 
            ps.setString(5, externo.getContacto());
            ps.setString(6, externo.getContraseña());
            ps.setInt(7, externo.getIdBiblioteca());
            ps.setString(8, externo.getDireccion());
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
    
    public boolean modificarExterno(Externo externo){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "UPDATE \"Usuario\" SET \"cedula\" =?, \"nombre\"=?, \"apellido\"=?, \"contacto\"=?,\"contraseña\"=?,\"idBiblioteca\"=?,\"direccion\"=? WHERE \"cedula\"=?";
        
        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, externo.getCedula()); 
            ps.setString(2, externo.getNombre());   
            ps.setString(3, externo.getApellido()); 
            ps.setString(4, externo.getContacto());
            ps.setString(5, externo.getContraseña());
            ps.setInt(6, externo.getIdBiblioteca());
            ps.setString(7, externo.getDireccion());
            ps.setInt(8, externo.getCedula());
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
    
    public boolean eliminarExterno(Externo externo){
        // Consulta preparada y apertura de conexion a bd
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "DELETE FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, externo.getCedula()); 
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
    
    public boolean BuscarExterno(Externo externo){
        
        // Consulta preparada, variable que guardara registro y apertura de conexion a bd 
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        
        //Sentencia sql
        String sql = "SELECT \"cedula\", \"nombre\", \"apellido\",\"tipo\", \"contacto\",\"contraseña\",\"idBiblioteca\",\"direccion\" FROM \"Usuario\" WHERE \"cedula\" = ?";

        try{
            //Mando consulta preparada con datos a base de datos
            ps = con.prepareStatement(sql); 
            ps.setInt(1, externo.getCedula()); 
            rs =ps.executeQuery();             //Ejecuto consulta y guardo resultado
            
            if(rs.next()){
                //Establezco valores a objeto. Los datos vienen de BD
                externo.setCedula(Integer.parseInt(rs.getString("cedula")));
                externo.setNombre(rs.getString("nombre"));
                externo.setApellido(rs.getString("apellido"));
                externo.setTipo(Integer.parseInt(rs.getString("tipo")));
                externo.setContacto(rs.getString("contacto"));
                externo.setContraseña(rs.getString("contraseña"));
                externo.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                externo.setDireccion(rs.getString("direccion"));
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
