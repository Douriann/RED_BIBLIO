
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author scocl
 */
public class CRUDPrestamo extends Conexion {
    public boolean registrarPrestamo(Prestamo pres)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "INSERT INTO \"Prestamo\"(\"cedula\", \"idEjemplar\", \"fechaSalida\", \"fechaVence\",\"fechaEntrega\",\"idEstadoPre\") VALUES(?,?,?,?,?,?)"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, pres.getUsuario().getCedula()); //PASO LOS DATOS
            ps.setInt(2, pres.getEjemplar().getIdEjemplar());
            ps.setDate(3, (Date) pres.getFechaSalida());
            ps.setDate(4, (Date) pres.getFechaVence());
            ps.setDate(5, (Date) pres.getFechaEntrego());
            ps.setInt(6, pres.getIdEstadoPre());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
               
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally                         //CIERRO CONEXION
        {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
    
        public boolean modificarPrestamo(Prestamo pres)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "UPDATE \"Prestamo\" SET \"cedula\" = ?, \"idEjemplar\" = ?,\"idEstadoPre\" = ? WHERE \"idPrestamo\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, pres.getUsuario().getCedula()); //PASO LOS DATOS
            ps.setInt(2, pres.getEjemplar().getIdEjemplar());
            ps.setInt(3, pres.getIdEstadoPre());
            ps.setInt(4, pres.getIdPrestamo());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
               
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally                         //CIERRO CONEXION
        {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
        public boolean eliminarPrestamo(Prestamo pres)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "DELETE FROM \"Prestamo\" WHERE \"idPrestamo\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, pres.getIdPrestamo());
            ps.execute();                            //EJECUTO CONSULTA
            return true;
               
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally                         //CIERRO CONEXION
        {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
        public boolean buscarPrestamo(Prestamo pres)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
        Connection con = getConexion();

        
        //CONSULTA SQL
        String sql = "SELECT * FROM \"Prestamo\" WHERE \"idPrestamo\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, pres.getIdPrestamo());
            rs = ps.executeQuery();
            //ps.execute();                            //EJECUTO CONSULTA
            if(rs.next()){
                Usuario usuario = new Usuario();
                usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(Integer.parseInt(rs.getString("idEjemplar")));
                
                pres.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
                pres.setUsuario(usuario);
                pres.setEjemplar(ejemplar);
                pres.setIdEstadoPre(Integer.parseInt(rs.getString("idEstadoPre")));
                return true;
            }
            return false;
               
        } catch(SQLException e)
        {
            System.err.println(e);
            return false;
        } finally                         //CIERRO CONEXION
        {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}
