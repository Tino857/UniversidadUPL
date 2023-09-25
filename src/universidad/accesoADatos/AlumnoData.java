package universidad.accesoADatos;

import universidad.entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import universidad.vistas.Vista;

/**
 *
 * @author Grupo 61
 */
public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        
        this.con = Conexion.buscarConexion();
    }
    
    
    //GUARDAR ALUMNO
    public int guardarAlumno(Alumno alumno) {
        
        String query = "INSERT INTO alumno(dni,apellido, nombre, fechaNacimiento,estado) "
                + "VALUES (?,?,?,?,?)";// se define consulta SQL
        int registro = 0;//  Esta variable se utilizará para almacenar el ID generado del nuevo registro en la base de datos   
        try {
            
            Alumno al = Vista.getAD().buscarAlumnoPorDni(alumno.getDni());// Esto se hace para verificar si el alumno ya existe en la base de datos
            if (al != null) {//Se verifica si se encontró un alumno en la base de datos
                
                if (al.getId() != alumno.getId()) {//compara el ID por parametro con el de la base para no duplicar un DNI
                    
                    return registro;
                }
            }

            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS); // se preparan los valores de la sentencia SQL junto a las claves generadas.
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getfN().toString());
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();// se ejecuta la consulta
            ResultSet rs = ps.getGeneratedKeys();// se recupera un conjunto de resultados
            
            if (rs.next()) {// consulta si rs tiene un valor posterior
                
                alumno.setId(rs.getInt(1));//Si se obtuvieron claves generadas, se asigna el ID generado al objeto alumno
                registro = rs.getInt(1);// el valor del id se guarda en registro
            } else {                
                
                System.out.println("No se pudo recuperar el ID");
            }
            ps.close();// se cierra la consulta
        } catch (SQLException e) {// se captura una posible excepcion SQL
            
            System.out.println("Error al guardar al alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " " + e.getMessage());
        }
        return registro;//retorna un registro
    }
    
    //ELIMINAR ALUMNO (DAR DE BAJA)
    public int eliminarAlumnoLogico(int dni) {
        
        String query = "UPDATE alumno SET estado=0 WHERE dni=?";
        int registro = 0;//para determinar el cambio en el registro
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//se crea y se prepara la sentencia PS
            ps.setInt(1, dni);
            registro = ps.executeUpdate();// Se ejecuta la consulta preparada utilizando el metodo executeUpdate() y se recupera llave generada automaticamente

            ps.close();// cierra consulta
        } catch (SQLException e) {
            
            System.out.println("Error al borrar al alumno" + e.getMessage());
        }
        return registro; // retorna variable registro al metodo que lo invoca
    }
    
    //EDITAR ALUMNO
    public int editarAlumno(Alumno alumno) {
        
        String query = "UPDATE `alumno` SET `dni`=?,`apellido`=?,`nombre`=?,`fechaNacimiento`=? WHERE idAlumno=?";
        int registro = 0;
        try {
            
            Alumno al = Vista.getAD().buscarAlumnoPorDni(alumno.getDni());//busqueda de alumno por dni en BD utilizando el metodo buscarAlumnoPorDni
            if (al != null) {//si no encuentra un alumno con el dni no ingresa
                
                if (al.getId() != alumno.getId()) {// compara el ID pasado por parametro con el de la Base de datos y evita que se repita un DNI
                    
                    return registro;
                }
            }
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//Preparación y ejecución de la consulta SQL
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getfN().toString());
            ps.setInt(5, alumno.getId());
            registro = ps.executeUpdate(); //ejecuta Update
            ps.close();//Cierra consulta
        } catch (SQLException e) {
            
            System.out.println("Error editar al alumno : " + alumno.getNombre() + " " + alumno.getApellido() + " " + e.getMessage());
        }
        return registro;
    }

    //  BUSCAR ALUMNO POR ID
    public Alumno buscarAlumnoPorId(int id) {
        
        Alumno al = null;//Declara una variable al de tipo Alumno e inicializa su valor como null. Esta variable se utilizará para almacenar el resultado de la búsqueda.
        String query = "SELECT * FROM alumno WHERE idAlumno=? and estado=1";
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//se prepara la consulta PS y se solicita las claves generadas automaticamente
            ps.setInt(1, id);// se modifica el ID
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta y se almacena en un resulset "rs"
            if (rs.next()) {// si rs contiene valores, se recuperan abajo
                
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));
            } else {
                
                JOptionPane.showMessageDialog(null, "No existe el alumno");//si no se encuentran alumnos con los parametros buscados deja el msj
            }
            ps.close();//Cierra consulta
        } catch (SQLException e) {
            
            System.out.println("Error al buscar el alumno" + e.getMessage());
        }
        return al;//retorna un alumno
    }

    //  BUSCAR ALUMNO POR DNI
    public Alumno buscarAlumnoPorDni(int dni) {
        
        Alumno al = null;// se crea instancia de alumno para utilizarlo dentro del try
        String query = "SELECT * FROM alumno WHERE dni=?"; 
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);//se modifica el comodin por el pasado por teclado
            ResultSet rs = ps.executeQuery();//s

            if (rs.next()) {
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));
            }
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al buscar el alumno" + e.getMessage());
        }
        return al;
    }

    //LISTAR ALUMNOS
    public ArrayList<Alumno> listarAlumnos() {
        
        ArrayList<Alumno> listaDeAlumno = new ArrayList();//se  creo una lista paraa almacenar Alumnos
        String query = "SELECT * FROM alumno WHERE estado=1";//se define consulta
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta, para un conjunto de resultados(resulset)
            Alumno al = null;// se inicializa un alumno en null
            while (rs.next()) {//se inicializa un bucle para modificar al alumno(al)
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));
                listaDeAlumno.add(al);//se agrega a la lista
            }
            ps.close();//cierra  el PS
        } catch (SQLException e) {
            
            System.out.println("Error al encontrar al alumno" + e.getMessage());
        }
        return listaDeAlumno;//retorna una lista de alumnos
    }
}
