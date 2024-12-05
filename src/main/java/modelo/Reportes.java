
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Reportes extends Conexion{
    
        public int contTotalPrestamosMes(){

            PreparedStatement ps = null;
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
            Connection con = getConexion();


            //CONSULTA SQL COMPUESTA
            /*
            DADO LOS ATRIBUTOS DEL USUARIO QUE SOLICITA EL PRESTAMO, SE CONSIGUE LA BIBLIOTECA EN
            DONDE PERTENECE, DEPENDIENDO DEL ID DEL LIBRO, SE CONSIGUE DICHO ATRIBUTO
            LUEGO, EN LA TABLA BIBLIOTECALIBRO CONSIGUE LA CANTIDAD DE EJEMPLARES PARA CONSULTAR
            */
            
            Calendar calendario = new GregorianCalendar();
            calendario.set(Calendar.DAY_OF_MONTH, 1);
            java.sql.Date primerDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
            java.sql.Date ultimoDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            String sql = "SELECT COUNT (*) FROM \"Prestamo\" WHERE \"fechaSalida\" >= ? AND \"fechaSalida\" <= ?"; 

            //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA

            try{

                ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
                //MANDAR DATOS
                //SE INTERACTUA CON LOS DATOS DEL MODELO
                ps.setDate(1, primerDiaMesActual);
                ps.setDate(2, ultimoDiaMesActual);
                rs = ps.executeQuery();
                //ps.execute();                            //EJECUTO CONSULTA
                if(rs.next()){
                    return rs.getInt(1);
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
        
        public int contTotalMultadosMes(){

            PreparedStatement ps = null;
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
            Connection con = getConexion();


            //CONSULTA SQL COMPUESTA
            /*
            DADO LOS ATRIBUTOS DEL USUARIO QUE SOLICITA EL PRESTAMO, SE CONSIGUE LA BIBLIOTECA EN
            DONDE PERTENECE, DEPENDIENDO DEL ID DEL LIBRO, SE CONSIGUE DICHO ATRIBUTO
            LUEGO, EN LA TABLA BIBLIOTECALIBRO CONSIGUE LA CANTIDAD DE EJEMPLARES PARA CONSULTAR
            */
            
            Calendar calendario = new GregorianCalendar();
            calendario.set(Calendar.DAY_OF_MONTH, 1);
            java.sql.Date primerDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
            java.sql.Date ultimoDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            String sql = "SELECT COUNT (*) FROM \"Multa\" WHERE \"fechaInicio\" >= ? AND \"fechaInicio\" <= ?"; 

            //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA

            try{

                ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
                //MANDAR DATOS
                //SE INTERACTUA CON LOS DATOS DEL MODELO
                ps.setDate(1, primerDiaMesActual);
                ps.setDate(2, ultimoDiaMesActual);
                rs = ps.executeQuery();
                //ps.execute();                            //EJECUTO CONSULTA
                if(rs.next()){
                    return rs.getInt(1);
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
                public int contTotalLibrosDisp(){

            PreparedStatement ps = null;
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()
            Connection con = getConexion();


            //CONSULTA SQL COMPUESTA
            /*
            DADO LOS ATRIBUTOS DEL USUARIO QUE SOLICITA EL PRESTAMO, SE CONSIGUE LA BIBLIOTECA EN
            DONDE PERTENECE, DEPENDIENDO DEL ID DEL LIBRO, SE CONSIGUE DICHO ATRIBUTO
            LUEGO, EN LA TABLA BIBLIOTECALIBRO CONSIGUE LA CANTIDAD DE EJEMPLARES PARA CONSULTAR
            */
            
            String sql = "SELECT COUNT (*) FROM \"Libro\""; 

            //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA

            try{

                ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
                //MANDAR DATOS
                //SE INTERACTUA CON LOS DATOS DEL MODELO
                rs = ps.executeQuery();
                //ps.execute();                            //EJECUTO CONSULTA
                if(rs.next()){
                    return rs.getInt(1);
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
}
