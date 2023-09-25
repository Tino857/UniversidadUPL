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

    private static final String URL = "jdbc:mariadb://localhost/";//direccion de la base de datos
    private static final String USUARIO = "root";//nombre de usuario para  autenticar la base de datos
    private static final String PASSWORD = "";//contraseña para autenticar
    private static final String DB = "Universidad";//nombre de la base de datos
    private static Connection conection = null;//variable ded tipo Connection que almacena la coneccion.

    private Conexion() {
    }

    public static Connection buscarConexion() {
        
        if (conection == null) {//se deja establecido que si conection es = null entonces entra en el try
            
            try {
                
                Class.forName("org.mariadb.jdbc.Driver");
                conection = DriverManager.getConnection(URL + DB + "?useLegacyDatetimeCode=false&serverTimezone=UTC" + "&user=" + USUARIO + "&password=" + PASSWORD);//Establece la conexión a la base de datos.
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al conectarse a la Base de Datos: \n - " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver de conexión: \n - " + ex.getMessage());
            }
        }
        return conection;//retorna una  coneccion
    }
}
