//prueba
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CrudMulta extends Conexion {
    public boolean registrarMulta(Multa mult)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "INSERT INTO \"Multa\"(\"idPrestamo\", \"fechaInicio\", \"fechaFin\") VALUES(?,?,?)"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, mult.getPrestamo().getIdPrestamo()); //PASO LOS DATOS
            ps.setDate(2, (Date) mult.getFechaInicio());
            ps.setDate(3, (Date) mult.getFechaFin());
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
    
    public boolean modificarMulta(Multa mult)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "UPDATE \"Multa\" SET \"idPrestamo\" = ? WHERE \"idMulta\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, mult.getPrestamo().getIdPrestamo());
            ps.setInt(2, mult.getIdMulta());
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
            
    public boolean eliminarMulta(Multa mult)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        String sql = "DELETE FROM \"Multa\" WHERE \"idMulta\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, mult.getIdMulta());
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
            
    public boolean buscarMulta(Multa mult)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
        Connection con = getConexion();

        
        //CONSULTA SQL
        String sql = "SELECT * FROM \"Multa\" WHERE \"idMulta\" = ?"; 
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, mult.getIdMulta());
            rs = ps.executeQuery();
            //ps.execute();                            //EJECUTO CONSULTA
            if(rs.next()){
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
                mult.setPrestamo(prestamo);
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
    // METODO PARA CREAR UNA LISTA DE OBJETOS DE LA CLASE
    public ArrayList<Multa> listarMulta(Multa mult) throws ParseException {
        // CREA E INICIALIZA UNA NUEVA ARRAYLIST DE LOS OBJETOS
    ArrayList<Multa> datosMult = new ArrayList<>();
        // SE INICIALIZA Y PREPARAN LAS CONSULTAS SQL CON SU RESPECTIVA CONEXION
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = getConexion();
        // CONSUTLA SQL
    String sql = "SELECT * FROM \"Multa\"";
        // PROBAR SI SE PUEDE REALIZAR LA OPERACION
    try {
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCION
        while (rs.next()) {
            // CREA UN NUEVO OBJETO PARA INSTANCIAR LA CLASE COMO ATRIBUTO
            Prestamo prestamo = new Prestamo();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
            // CREA UN NUEVO OBJETO PARA AÑADIR AL ARREGLO
            Multa multa = new Multa();
            multa.setIdMulta(Integer.parseInt(rs.getString("idMulta")));
            multa.setPrestamo(prestamo);
            multa.setFechaInicio(dateFormat.parse(rs.getString("fechaInicio")));
            multa.setFechaFin(dateFormat.parse(rs.getString("fechaFin")));
            // SE AÑADE EL OBJETO AL ARREGLO
            datosMult.add(multa);
        }
        // DEVUELVE AL ARREGLO
        return datosMult;
        // ANTE CUALQUIER PROBLEMA, ENTREGA UN ARREGLO VACIO O EXCEPCION
    } catch (SQLException e) {
        System.err.println(e);
    } finally {
        try {
            con.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    return datosMult;
}
}
