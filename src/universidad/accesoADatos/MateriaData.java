package universidad.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import universidad.entidades.Materia;
import universidad.vistas.Vista;

/**
 *
 * @author Grupo 61
 */
public class MateriaData {

    private Connection con = null;

    public MateriaData() {
        
        this.con = Conexion.buscarConexion();
    }

    // GUARDAR MATERIA
    public int guardarMateria(Materia M) {
        
        int registro = 0;// variable para guardar cambio
        String query = "INSERT INTO `materia`(`nombre`, `año`, `estado`) "
                + "VALUES (?,?,?)";//se prepara la consulta SQL
        
        try {
            
            Materia mat = Vista.getMD().buscarMateriaPorID(M.getId());//se busca una materia en Base de datos usando ID pasado por parametro (M)
            if (mat != null) {
                
                if (mat.getId() != M.getId()) {//Si son diferentes, significa que se está intentando crear una materia con un ID que ya existe en la base de datos, por lo que el método retorna registro, si es 0 no realiza cambios

                    return registro;// retorno del registro
                }
            }
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, M.getNombre());//se asigna los valores de parrametro a los comodines de posicion
            ps.setInt(2, M.getAnioMateria());//se asigna los valores de parrametro a los comodines de posicion
            ps.setBoolean(3, M.isActivo());//se asigna los valores de parrametro a los comodines de posicion
            ps.executeUpdate();//ses ejecuta la consulta, que inserta una fila en la tabla Materia
            ResultSet rs = ps.getGeneratedKeys();//se obtiene el Id generado automaticamente
            if (rs.next()) {
                
                M.setId(rs.getInt(1));//si se obtuvo una clave sse almacena en M
                registro = rs.getInt(1);//si se obtuvo una clave sse almacena en registro
            } else {
                
                System.out.println("No se pudo recuperar el ID");
            }
            
            ps.close();//se cierra la conexion
        } catch (SQLException e) {
            
            System.out.println("Error al guardar la materia : " + M.getNombre() + " " + e.getMessage());//manejo de excepciones
        }
        return registro;
    }
    
    //ELIMINAR MATERIA
    public int eliminarMateriaLogico(String nombre){
        
        String query = "UPDATE `materia` SET estado=0 WHERE nombre=?";//se prepara consulta
        int registro = 0;////inicializa variable en 0 para guardar cambio
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);//se asigna valor al comodin con el valor pasado por parametro
            registro = ps.executeUpdate();//se ejecuta la consulta

            ps.close();//se cierra la conexion
        } catch (SQLException e) {
            
            System.out.println("Error al borrar la materia : " + e.getMessage());//manejo de excepciones
        }
        return registro;//retorno del registro
    }

    //EDITAR MATERIA
    public int editarMateria(Materia M) {
        
        String query = "UPDATE materia SET nombre=?,año=? WHERE idMateria=?";//se prepara la consulta
        int registro = 0;//inicializa variable en 0
        try {
            
            Materia mat = Vista.getMD().buscarMateriaPorNombre(M.getNombre());//se busca una materia en bd usando el metodo.buscarMateriaPorNombre
            if (mat != null) {//Se verifica que la materia obteniada no sea null, es decir que contenga una matetia
                
                if (mat.getId() != M.getId()) {//Si son diferentes, significa que se está intentando editar una materia para que tenga el mismo nombre que otra materia existente, lo que no está permitido
                    
                    return registro;//retorna el registro 1 o 0 dependiendo del resultado
                }
            }
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, M.getNombre());//se asigna valor al comodin con el valor pasado por parametro
            ps.setInt(2, M.getAnioMateria());//se asigna valor al comodin con el valor pasado por parametro
            ps.setInt(3, M.getId());//se asigna valor al comodin con el valor pasado por parametro
            registro = ps.executeUpdate();// se ejecuta la modificacion

            ps.close();//se cierra la conexion
        } catch (SQLException e) {
            System.out.println("Error editar la materia : " + M.getNombre() + " " + e.getMessage());
        }
        return registro;
    }
    
    //BUSCAR MATERIA POR NOMBRE
    public Materia buscarMateriaPorNombre(String nombre) {
        
        String query = "SELECT * FROM `materia` WHERE nombre=?";// se prepara la consulta SQL
        Materia mat = null;//se inicializa una variable para registrar cambios
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);//se asigna valor al comodin con el valor pasado por parametro
            ResultSet rs = ps.executeQuery();//se ejecuta la busqueda
            if (rs.next()) {
                
                mat = new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(nombre);
                mat.setActivo(rs.getBoolean("estado"));
            }

            ps.close();//se cierra la conexion
        } catch (SQLException e) {
            
            System.out.println("Error al buscar materia " + e.getMessage());//manejo de excepciones
        }
        return mat;//retorna una materia
    }

    //BUSCAR MATERIA POR ID
    public Materia buscarMateriaPorID(int id) {
        
        String query = "SELECT * FROM `materia` WHERE idMateria=?";//se prepara la consulta
        Materia mat = null;//inicializa mat en null, para guardar materia
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);//se asigna valor al comodin con el valor pasado por parametro
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta
            if (rs.next()) {//si el conjunto de datos, tiene una fila siguiente:
                
                mat = new Materia();//crea una nueva materia
                mat.setId(rs.getInt("idMateria"));//setea valores
                mat.setAnioMateria(rs.getInt("año"));//setea valores
                mat.setNombre(rs.getString("nombre"));//setea valores
                mat.setActivo(rs.getBoolean("estado"));//setea valores
            }

            ps.close();//cierra la coneccion
        } catch (SQLException e) {
            System.out.println("Error al buscar materia " + e.getMessage());//manejo de excepcines
        }
        return mat;//retorna una materia
    }
    
    //LISTAR MATERIAS
    public ArrayList<Materia> listarMaterias() {
        
        ArrayList<Materia> listaDeMateria = new ArrayList();//crea una lista de Materias
        String query = "SELECT * FROM materia WHERE estado=1";//prepara la consulta SQL
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();//se ejecuta la consulta
            Materia mat = null;
            while (rs.next()) {//bucle para recorrer cada fila 
                
                mat = new Materia();
                mat.setId(rs.getInt("idMateria"));//se asigna valores de las columnas de la tabla materia
                mat.setAnioMateria(rs.getInt("año"));//se asigna valores de las columnas de la tabla materia
                mat.setNombre(rs.getString("nombre"));//se asigna valores de las columnas de la tabla materia
                mat.setActivo(true);
                mat.setActivo(rs.getBoolean("estado"));
                listaDeMateria.add(mat);//se agrega la materia a la lista
            }
            
            ps.close();//cierra la conexion
        } catch (SQLException e) {
            
            System.out.println("Error al borrar al alumno" + e.getMessage());//manejo de excepciones
        }
        return listaDeMateria;//retorna una lista de materias
    }
}
