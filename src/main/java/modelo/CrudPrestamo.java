/*
 EQUIPO NUMERO 3
    ADRIAN PEREIRA
    MAURICIO RODRIGUEZ
    ALONDRA LEON
    ANDREA VALECILLOS
    WILLIANNY CHUELLO
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CrudPrestamo extends Conexion {
    
    public boolean registrarPrestamo(Prestamo pres) throws SQLException
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
        // metodo para crear una lista de objetos
        public ArrayList<Prestamo> listarPrestamo(Prestamo pres) throws ParseException {
        //CREA E INICIALIZA UNA NUEVA ARRAYLIST DE LOS OBJETOS
        ArrayList<Prestamo> datosPres = new ArrayList<>();
        // SE INICIALIZA Y PREPARAN LAS CONSULTAS SQL CON SU RESPECTIVA CONEXION
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        //CONSULTA SQL
        String sql = "SELECT \"Prestamo\".*, \"EstadoPrestamo\".\"nomEstadoPre\" FROM \"Prestamo\" JOIN \"EstadoPrestamo\" ON \"Prestamo\".\"idEstadoPre\" = \"EstadoPrestamo\".\"idEstadoPre\"";
        // PROBAR SI SE PUEDE REALIZAR LA OPERACION
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCION
            while (rs.next()) {
                // CREA UN NUEVO OBJETO PARA INSTANCIAR LA CLASE COMO UN ATRIBUTO
                Usuario usuario = new Usuario();
                usuario.setCedula(Integer.parseInt(rs.getString("cedula")));
                
                Ejemplar ejemplar = new Ejemplar();
                ejemplar.setIdEjemplar(Integer.parseInt(rs.getString("idEjemplar")));
                
                // LLAMA A LA CLASE DATEFORMAT PARA PARSEAR EL ATRIBUTO DE LA BD A UN DATO TIPO DATE
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                // OBTIENE LOS ATRIBUTOS PARA LA CREACION
                Prestamo prestamo = new Prestamo();
                prestamo.setIdPrestamo(Integer.parseInt(rs.getString("idPrestamo")));
                prestamo.setUsuario(usuario);
                prestamo.setEjemplar(ejemplar);
                prestamo.setFechaSalida(dateFormat.parse(rs.getString("fechaSalida")));
                prestamo.setFechaVence(dateFormat.parse(rs.getString("fechaVence")));
                prestamo.setFechaEntrego(dateFormat.parse(rs.getString("fechaEntrega")));
                prestamo.setIdEstadoPre(Integer.parseInt(rs.getString("idEstadoPre")));
                prestamo.setNomEstadoPre(rs.getString("nomEstadoPre"));
                // SE AÑADE EL OBJETO AL ARREGLO
                datosPres.add(prestamo);
            }
            // DEVUELVE EL ARREGLO
            return datosPres;
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
        return datosPres;
    }
        // METODO PARA CONSEGUIR LA CANTIDAD DE EJEMPLARES DE UN LIBRO
        public int buscarEjemplar(Prestamo pres){

            PreparedStatement ps = null;
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
            Connection con = getConexion();


            //CONSULTA SQL COMPUESTA
            /*
            DADO LOS ATRIBUTOS DEL USUARIO QUE SOLICITA EL PRESTAMO, SE CONSIGUE LA BIBLIOTECA EN
            DONDE PERTENECE, DEPENDIENDO DEL ID DEL LIBRO, SE CONSIGUE DICHO ATRIBUTO
            LUEGO, EN LA TABLA BIBLIOTECALIBRO CONSIGUE LA CANTIDAD DE EJEMPLARES PARA CONSULTAR
            */
            String sql = "SELECT \"bl\".\"cantEjemplares\" FROM \"Usuario\" \"u\" JOIN \"BibliotecaLibro\" \"bl\" ON \"u\".\"idBiblioteca\" = \"bl\".\"idBiblioteca\" WHERE \"u\".\"cedula\" = ? AND \"bl\".\"idLibro\" = ?"; 

            //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA

            try{

                ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
                //MANDAR DATOS
                //SE INTERACTUA CON LOS DATOS DEL MODELO
                ps.setInt(1, pres.getUsuario().getCedula());
                ps.setInt(2, pres.getEjemplar().getIdEjemplar());
                rs = ps.executeQuery();
                //ps.execute();                            //EJECUTO CONSULTA
                if(rs.next()){
                    int cantEjemplar;
                    cantEjemplar = Integer.parseInt(rs.getString("cantEjemplares"));
                    return cantEjemplar;
                }
                return 0;

            } catch(SQLException e)
            {
                System.err.println(e);
                return 0;
            } finally                         //CIERRO CONEXION
            {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }

        }
        
        public boolean actualizarEjemplarPres(Prestamo pres)
    {
        //PREPARAR CONSULTA
        PreparedStatement ps = null;
        Connection con = getConexion();
        
        //CONSULTA SQL
        /*
        AL REALIZAR EL PRESTAMO, SE REMUEVE UN EJEMPLAR DE LOS EXISTENTES EN LA BIBLIOTECA
        ESTO LO HACE CONSULTANDO EL ID DEL LIBRO Y EL ID DE BIBLIOTECA
        */
        String sql = "UPDATE \"BibliotecaLibro\" SET \"cantEjemplares\" = \"cantEjemplares\" - 1 WHERE \"idBiblioteca\" = (SELECT \"idBiblioteca\" FROM \"Usuario\" WHERE \"cedula\" = ?) AND \"idLibro\" = ?";
        
        //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA
        
        try{
            
            ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
            //MANDAR DATOS
            //SE INTERACTUA CON LOS DATOS DEL MODELO
            ps.setInt(1, pres.getUsuario().getCedula()); //PASO LOS DATOS
            ps.setInt(2, pres.getEjemplar().getIdEjemplar());
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
    
}
