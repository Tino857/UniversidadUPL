/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author valen
 */
public class Conexion {
    private static final String url="jdbc:mariadb://localhost/",usuario="root",password="",DB="Universidad";
    private static Connection conection=null;

    private Conexion() {
        
    }
  public static Connection buscarConexion(){
      if (conection==null) {
          try{
              Class.forName("org.mariadb.jdbc.Driver");
              conection=DriverManager.getConnection(url+DB+"?useLegacyDatetimeCode=false&serverTimezone=UTC"+"&user="+usuario+"&password="+password);
          }catch(SQLException ex){
             JOptionPane.showMessageDialog(null, "Error al conectarse a la BD"+ex.getMessage());
          }catch(ClassNotFoundException ex){
                     JOptionPane.showMessageDialog(null, "Error al cargar los drivers"+ex.getMessage());
          }
      }
      return conection;
  }
}
