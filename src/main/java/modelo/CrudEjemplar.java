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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CrudEjemplar extends Conexion {

    private Map<String, Integer> estadoEjemplarMap = new HashMap<>();
    private Map<String, Integer> libroMap = new HashMap<>();

    public boolean registrarEjemplar(Ejemplar eje) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO \"Ejemplar\" (\"idLibro\", \"idEstadoEj\", \"ubicacion\") VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eje.getIdLibro());
            ps.setInt(2, eje.getIdEstadoEj());
            ps.setString(3, eje.getUbicacion()); // Segundo la direccion
            ps.execute(); // EJECUTO CONSULTA
            return true;
        } catch (SQLException e) {
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

    public boolean modificarEjemplar(Ejemplar eje) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE \"Ejemplar\" SET \"idLibro\" = ?, \"idEstadoEj\" = ?, \"ubicacion\" = ? WHERE \"idEjemplar\" = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eje.getIdLibro());
            ps.setInt(2, eje.getIdEstadoEj());
            ps.setString(3, eje.getUbicacion());
            ps.setInt(4, eje.getIdEjemplar());
            ps.execute(); // EJECUTO CONSULTA
            return true;
        } catch (SQLException e) {
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

    public boolean eliminarEjemplar(Ejemplar eje) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM \"Ejemplar\" WHERE \"idEjemplar\" = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eje.getIdEjemplar()); // PASO LOS DATOS
            ps.execute(); // EJECUTO CONSULTA
            return true;
        } catch (SQLException e) {
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

    public boolean buscarEjemplar(Ejemplar eje) {
        PreparedStatement ps = null;
        ResultSet rs = null; // Variable que guarda resultado de consulta. Es decir, registro
        Connection con = getConexion();

        // Como se seleccionan todas las columnas de la tabla, se puede usar el operador *
        String sql = "SELECT * FROM \"Ejemplar\" WHERE \"idEjemplar\" = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, eje.getIdEjemplar());
            rs = ps.executeQuery(); // rs se le asigna lo que regresa ps.executeQuery()

            if (rs.next()) { // Si encontró algo, realiza esta lógica
                eje.setIdEjemplar(rs.getInt("idEjemplar"));
                eje.setIdEstadoEj(rs.getInt("idEstadoEj"));
                eje.setIdLibro(rs.getInt("idLibro"));
                eje.setUbicacion(rs.getString("ubicacion"));
                return true; // Esto indica que se encontró un registro y se inicializó el objeto con los valores encontrados en bd
            }
            return false; // Si no encontró registro, retorna falso
        } catch (SQLException e) {
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

    // Método para crear una lista de objetos de la clase
    public ArrayList<Ejemplar> listarEjemplar(Ejemplar eje) throws ParseException {
        // CREA E INICIALIZA UNA NUEVA ARRAYLIST DE LOS OBJETOS
        ArrayList<Ejemplar> datosEjemplar = new ArrayList<>();
        // SE INICIALIZA Y PREPARAN LAS CONSULTAS SQL CON SU RESPECTIVA CONEXIÓN
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        // CONSULTA SQL
        String sql = "SELECT * FROM \"Ejemplar\"";
        // PROBAR SI SE PUEDE REALIZAR LA OPERACIÓN
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // MIENTRAS EXISTAN LECTURAS, REALIZAR TAL ACCIÓN
            while (rs.next()) {
                // CREA UN NUEVO OBJETO PARA AÑADIR AL ARREGLO
                Ejemplar ejemplar = new Ejemplar();
                // OBTIENE LOS ATRIBUTOS PARA LA CREACIÓN
                ejemplar.setIdEjemplar(rs.getInt("idEjemplar"));
                ejemplar.setIdLibro(rs.getInt("idLibro"));
                ejemplar.setIdEstadoEj(rs.getInt("idEstadoEj"));
                ejemplar.setUbicacion(rs.getString("ubicacion"));
                // SE AÑADE EL OBJETO AL ARREGLO
                datosEjemplar.add(ejemplar);
            }
            // ANTE CUALQUIER PROBLEMA, ENTREGAR UN ARREGLO VACÍO O EXCEPCIÓN
            return datosEjemplar;
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
        return datosEjemplar;
    }

    public void llenarComboBoxEstadoEjemplar(javax.swing.JComboBox<String> combxEstadoEjemplar) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            String sql = "SELECT \"idEstadoEj\", \"nomEstadoEj\" FROM \"EstadoEjemplar\" ORDER BY \"idEstadoEj\"";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            combxEstadoEjemplar.addItem("Seleccione Estado Ejemplar");
            while (rs.next()) {
                int idEstadoEj = rs.getInt("idEstadoEj");
                String nomEstadoEj = rs.getString("nomEstadoEj");
                combxEstadoEjemplar.addItem(nomEstadoEj);
                estadoEjemplarMap.put(nomEstadoEj, idEstadoEj);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    public void llenarComboBoxLibroEjemplar(javax.swing.JComboBox<String> combxLibEjemplar) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        try {
            String sql = "SELECT \"idLibro\", \"titulo\" FROM \"Libro\" ORDER BY \"idLibro\"";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            combxLibEjemplar.addItem("Seleccione Libro");
            while (rs.next()) {
                int idLibro = rs.getInt("idLibro");
                String titulo = rs.getString("titulo");
                combxLibEjemplar.addItem(titulo);
                libroMap.put(titulo, idLibro);
            }
            rs.close();
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }

    public Integer getIdEstadoEjemplar(String nomEstadoEj) {
        return estadoEjemplarMap.get(nomEstadoEj);
    }

    public Integer getIdLibro(String titulo) {
        return libroMap.get(titulo);
    }

    public Map<String, Integer> getEstadoEjemplarMap() {
        return estadoEjemplarMap;
    }

    public Map<String, Integer> getLibroMap() {
        return libroMap;
    }
}
