package universidad.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 61
 */
public class Conexion {

    private static final String URL = "jdbc:mariadb://localhost/";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";
    private static final String DB = "Universidad";
    private static Connection conection = null;

    private Conexion() {
    }

    public static Connection buscarConexion() {
        
        if (conection == null) {
            
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
                conection = DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos: \n - " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver de conexión: \n - " + ex.getMessage());
            }
        }
        return conection;
    }
}
