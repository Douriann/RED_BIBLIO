
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
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()OSEA, DA LOS RESULTADOS OBTENIDOS EN LA BASE DE DATOS
            Connection con = getConexion();
            // CREAMOS UNA INSTANCIA DE CALENDARIO
            Calendar calendario = new GregorianCalendar();
            //  SE ASIGNA EL VALOR PARA CONSEGUIR EL PRIMER DIA DEL MES ACTUAL
            calendario.set(Calendar.DAY_OF_MONTH, 1);
            // SE ASIGNA EL VALOR DEL PRIMER DIA DEL MES ADAPTADO A LA SINTAXIS DE LA BD
            java.sql.Date primerDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            // SE ASIGNA EL VALOR DEL ULTIMO DIA DEL MES ACTUAL
            calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
            // SE ASIGNA EL VALOR DEL ULTOMO DIA DEL MES ADAPTADO A LA SINTAXIS DE LA BD
            java.sql.Date ultimoDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            //CONSULTA SQL
            /*
             ACORDE AL PRESTAMO, VA A CONTAR LA CANTIDAD DE REGISTROS QUE HAY DESDE EL INICIO DEL MES AL FINAL
             DEL MES
            */
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
                // EN CASO DE EXISTIR CONSULTA, RETORNA EL VALOR DE LA PRIMERA FILA (CONTADOR)
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
            ResultSet rs = null; // rs se le asigna lo que regresa ps.executeQuery()OSEA, DA LOS RESULTADOS OBTENIDOS EN LA BASE DE DATOS
            Connection con = getConexion();
            // CREAMOS UNA INSTANCIA DE CALENDARIO
            Calendar calendario = new GregorianCalendar();
            //  SE ASIGNA EL VALOR PARA CONSEGUIR EL PRIMER DIA DEL MES ACTUAL
            calendario.set(Calendar.DAY_OF_MONTH, 1);
            // SE ASIGNA EL VALOR DEL PRIMER DIA DEL MES ADAPTADO A LA SINTAXIS DE LA BD
            java.sql.Date primerDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            //  SE ASIGNA EL VALOR PARA CONSEGUIR EL ULTIMO DIA DEL MES ACTUAL
            calendario.set(Calendar.DAY_OF_MONTH, calendario.getActualMaximum(Calendar.DAY_OF_MONTH));
            // SE ASIGNA EL VALOR DEL ULTIMO DIA DEL MES ADAPTADO A LA SINTAXIS DE LA BD
            java.sql.Date ultimoDiaMesActual = new java.sql.Date(calendario.getTimeInMillis());
            
            //CONSULTA SQL
            /*
             ACORDE A LAS MULTAS, VA A CONTAR LA CANTIDAD DE REGISTROS QUE HAY DESDE EL INICIO DEL MES AL FINAL
             DEL MES
            */
            
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
                // EN CASO DE EXISTIR CONSULTA, RETORNA EL VALOR DE LA PRIMERA FILA (CONTADOR)
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


            //CONSULTA SQL
            /*
             ACORDE A LOS LIBROS EXISTENTES, VA A CONTAR LA CANTIDAD DE REGISTROS QUE HAY 
            */
            
            String sql = "SELECT COUNT (*) FROM \"Libro\""; 

            //SEGMENTO DE CODIGO PARA MANDAR DATOS A LA CONSULTA

            try{

                ps = con.prepareStatement(sql); //INVOCO LA CONSULTA, MANDO SQL
                //MANDAR DATOS
                //SE INTERACTUA CON LOS DATOS DEL MODELO
                rs = ps.executeQuery();
                //ps.execute();                            //EJECUTO CONSULTA
                // EN CASO DE EXISTIR CONSULTA, RETORNA EL VALOR DE LA PRIMERA FILA (CONTADOR)
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
