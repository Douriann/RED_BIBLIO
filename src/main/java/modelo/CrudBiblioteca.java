
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CrudBiblioteca extends Conexion {
    
    public boolean registrarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "INSERT INTO Biblioteca (idBiblioteca, nomBiblioteca, direccion) VALUES(?,?,?)";
        //String sql = "INSERT INTO public."Biblioteca"("idBibloteca", "nomBiblioteca", direccion) VALUES (?, ?, ?)";
        //String sql = "INSERT INTO public.\"Biblioteca\" (\"idBibloteca\", \"nomBiblioteca\", direccion) VALUES (?, ?, ?)";
        //String sql = "INSERT INTO Biblioteca ("idBiblioteca", "nomBiblioteca", direccion) VALUES(?,?,?)";
        //String sql = "INSERT INTO \"Biblioteca\" (\"idBiblioteca\", \"nomBiblioteca\", direccion) VALUES (?, ?, ?)";
        //String sql = "INSERT INTO \"Biblioteca\" (\"idBiblioteca\", \"nomBiblioteca\", \"direccion\") VALUES (?, ?, ?)";
          //String sql = "INSERT INTO public.\"Biblioteca\" (\"idbiblioteca\", \"nombiblioteca\", \"direccion\") VALUES (?, ?, ?)";
        //String sql = "INSERT INTO public.\"Biblioteca\" (\"idBiblioteca\", \"nomBiblioteca\", \"direccion\") VALUES (?, ?, ?)";
        
        //Sentencia correcta. Quite palabra public. No se registra el id. La BD lo genera de forma automatica.
        String sql = "INSERT INTO \"Biblioteca\" (\"nomBiblioteca\", \"direccion\") VALUES (?, ?)";

          
        try{
            ps = con.prepareStatement(sql); 
            //ps.setInt(1, bli.getIdBiblioteca()); //PASO LOS DATOS. EL ID NO SE REGISTRA
            ps.setString(1, bli.getNomBiblioteca()); //Acomode los numeros. Primero se manda nombre de biblioteca
            ps.setString(2, bli.getDireccion());    // Segundo la direccion
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
    public boolean modificarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "UPDATE Biblioteca SET nomBiblioteca=?, direccion=? WHERE idBiblioteca=?";
        String sql = "UPDATE \"Biblioteca\" SET \"nomBiblioteca\" = ?, \"direccion\" = ? WHERE \"idBiblioteca\" = ?";
        
        try{
            ps = con.prepareStatement(sql); 
            //PASO LOS DATOS. Aqui si se pasa el id. Los datos se pasan siguiendo el mismo orden de la sentencia
            ps.setString(1, bli.getNomBiblioteca()); 
            ps.setString(2, bli.getDireccion());
            ps.setInt(3, bli.getIdBiblioteca());
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
    public boolean eliminarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //String sql = "DELETE FROM Biblioteca WHERE idBiblioteca=?";
        String sql = "DELETE FROM \"Biblioteca\" WHERE \"idBiblioteca\" = ?";

        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, bli.getIdBiblioteca()); //PASO LOS DATOS
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
    public boolean buscarBiblioteca(Biblioteca bli){
        PreparedStatement ps = null;
        ResultSet rs = null; //Variable que guarda resultado de consulta. Es decir registro
        Connection con = getConexion();
        
        //String sql = "SELECT * FROM Biblioteca WHERE idBiblioteca=? ";
        //String sql = "SELECT * FROM \"Biblioteca\" WHERE \"idBiblioteca\" = ?";
        //String sql = "SELECT "idBiblioteca", "nomBiblioteca", direccion FROM public."Biblioteca" WHERE "idBiblioteca" = ?";
        //String sql = "SELECT \"idBiblioteca\", \"nomBiblioteca\", \"direccion\" FROM public.\"Biblioteca\" WHERE \"idBiblioteca\" = ?";
        
        //Como se seleccionan todas las columnas de la tabla, se puede usar el operador *
        String sql = "SELECT * FROM \"Biblioteca\" WHERE \"idBiblioteca\" = ?";
        try{
            ps = con.prepareStatement(sql); 
            ps.setInt(1, bli.getIdBiblioteca());
            rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()
            
            if(rs.next()) //Si encontro algo realiza esta logica
            {
                bli.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                bli.setNomBiblioteca(rs.getString("nomBiblioteca"));
                bli.setDireccion(rs.getString("direccion"));
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
    
        public ArrayList<Biblioteca> listarBiblioteca(Biblioteca bli) throws ParseException {
        ArrayList<Biblioteca> datosBiblio = new ArrayList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM \"Biblioteca\"";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Biblioteca biblioteca = new Biblioteca();
                biblioteca.setIdBiblioteca(Integer.parseInt(rs.getString("idBiblioteca")));
                biblioteca.setNomBiblioteca(rs.getString("nomBiblioteca"));
                biblioteca.setDireccion(rs.getString("direccion"));
                datosBiblio.add(biblioteca);
            }
            return datosBiblio;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datosBiblio;
    }
}
