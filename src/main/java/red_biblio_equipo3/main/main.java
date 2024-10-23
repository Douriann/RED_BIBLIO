/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package red_biblio_equipo3.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author scocl
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String url = "jdbc:postgresql://localhost/prueba";
        try (Connection conn = DriverManager.getConnection(url, "postgres", "michumiau123")) {
            if (conn != null) {
                System.out.println("Conexión establecida");
            } else {
                System.out.println("Fallo al establecer la conexión");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
