package modelo;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class CRUDRenovacion extends Conexion {
    public boolean registrarRenovacion(Renovacion ren)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "INSERT INTO \"Renovacion\"(\"idPrestamo\", \"fechaSalida\", \"fechaVence\",\"idEstadoRen\") VALUES(?,?,?,?)"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, ren.getPrestamo().getIdPrestamo()); //PASO LOS DATOS
            ps.setDate(2, (Date) ren.getFechaSalida());
            ps.setDate(3, (Date) ren.getFechaVence());
            ps.setInt(4, ren.getIdEstadoRen());
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
    
    public boolean modificarRenovacion(Renovacion ren)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "UPDATE \"Renovacion\" SET \"idPrestamo\" = ?, \"idEstadoRen\" = ? WHERE \"idRenovacion\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, ren.getPrestamo().getIdPrestamo());
            ps.setInt(2, ren.getIdEstadoRen());
            ps.setInt(3, ren.getIdRenovacion());
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
    
    public boolean eliminarRenovacion(Renovacion ren)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "DELETE FROM \"Renovacion\" WHERE \"idRenovacion\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1,ren.getIdRenovacion());
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
        
    public boolean buscarRenovacion(Renovacion ren)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
        Connection con = getConexion();

        
        //CONSULTA SQL
        String sql = "SELECT * FROM \"Renovacion\" WHERE \"idRenovacion\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, ren.getIdRenovacion());
            rs = ps.executeQuery();
            //ps.execute();                            //EJECUTO CONSULTA
            if(rs.next()){
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
                ren.setPrestamo(prestamo);
                ren.setIdEstadoRen(Integer.parseInt(rs.getString("idEstadoRen")));
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
    
/*    public ArrayList<Renovacion> listarRenovacion(Renovacion ren) throws ParseException
    {
        ArrayList<Renovacion> datosRen = new ArrayList<>();
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
        Connection con = getConexion();

        
        //CONSULTA SQL
        String sql = "SELECT * FROM \"Renovacion\""; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            rs = ps.executeQuery();
            //ps.execute();                            //EJECUTO CONSULTA
            if(rs.next()){
                while(rs.next()){
                Prestamo prestamo = new Prestamo();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
                ren.setIdRenovacion(0);
                ren.setPrestamo(prestamo);
                ren.setFechaSalida(dateFormat.parse(rs.getString("fechaSalida")));
                ren.setFechaVence(dateFormat.parse(rs.getString("fechaVence")));
                ren.setIdEstadoRen(Integer.parseInt(rs.getString("idEstadoRen")));
                datosRen.add(ren);
            }
                return datosRen;
            }

            return datosRen;
               
        } catch(SQLException e)
        {
            System.err.println(e);
        } finally                         //CIERRO CONEXION
        {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datosRen;
    }*/
    
public ArrayList<Renovacion> listarRenovacion(Renovacion ren) throws ParseException {
    ArrayList<Renovacion> datosRen = new ArrayList<>();
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();

    String sql = "SELECT * FROM \"Renovacion\"";

    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Prestamo prestamo = new Prestamo();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
            
            Renovacion renovacion = new Renovacion();
            renovacion.setIdRenovacion(Integer.parseInt(rs.getString("idRenovacion")));
            renovacion.setPrestamo(prestamo);
            renovacion.setFechaSalida(dateFormat.parse(rs.getString("fechaSalida")));
            renovacion.setFechaVence(dateFormat.parse(rs.getString("fechaVence")));
            renovacion.setIdEstadoRen(Integer.parseInt(rs.getString("idEstadoRen")));
            
            datosRen.add(renovacion);
        }
        return datosRen;
    } catch (SQLException e) {
        System.err.println(e);
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    return datosRen;
}

}
