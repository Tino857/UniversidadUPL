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
        
        int registro = 0;
        String query = "INSERT INTO `materia`(`nombre`, `año`, `estado`) "
                + "VALUES (?,?,?)";
        
        try {
            
            Materia mat = Vista.getMD().buscarMateriaPorID(M.getId());
            if (mat != null) {
                
                if (mat.getId() != M.getId()) {

                    return registro;
                }
            }
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, M.getNombre());
            ps.setInt(2, M.getAnioMateria());
            ps.setBoolean(3, M.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                
                M.setId(rs.getInt(1));
                registro = rs.getInt(1);
            } else {
                
                System.out.println("No se pudo recuperar el ID");
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al guardar la materia : " + M.getNombre() + " " + e.getMessage());
        }
        return registro;
    }
    
    //ELIMINAR MATERIA
    public int eliminarMateriaLogico(String nombre){
        
        String query = "UPDATE `materia` SET estado=0 WHERE nombre=?";
        int registro = 0;
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            registro = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al borrar la materia : " + e.getMessage());
        }
        return registro;
    }

    //EDITAR MATERIA
    public int editarMateria(Materia M) {
        
        String query = "UPDATE materia SET nombre=?,año=? WHERE idMateria=?";
        int registro = 0;
        try {
            
            Materia mat = Vista.getMD().buscarMateriaPorNombre(M.getNombre());
            if (mat != null) {
                
                if (mat.getId() != M.getId()) {
                    
                    return registro;
                }
            }
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, M.getNombre());
            ps.setInt(2, M.getAnioMateria());
            ps.setInt(3, M.getId());
            registro = ps.executeUpdate();

            ps.close();
        } catch (SQLException e) {
            System.out.println("Error editar la materia : " + M.getNombre() + " " + e.getMessage());
        }
        return registro;
    }
    
    //BUSCAR MATERIA POR NOMBRE
    public Materia buscarMateriaPorNombre(String nombre) {
        
        String query = "SELECT * FROM `materia` WHERE nombre=?";
        Materia mat = null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                mat = new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(nombre);
                mat.setActivo(rs.getBoolean("estado"));
            }

            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al buscar materia " + e.getMessage());
        }
        return mat;
    }

    //BUSCAR MATERIA POR ID
    public Materia buscarMateriaPorID(int id) {
        
        String query = "SELECT * FROM `materia` WHERE idMateria=?";// and estado=1";
        Materia mat = null;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                mat = new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(rs.getBoolean("estado"));
            }

            ps.close();
        } catch (SQLException e) {
            System.out.println("Error al buscar materia " + e.getMessage());
        }
        return mat;
    }
    
    //LISTAR MATERIAS
    public ArrayList<Materia> listarMaterias() {
        
        ArrayList<Materia> listaDeMateria = new ArrayList();
        String query = "SELECT * FROM materia WHERE estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            Materia mat = null;
            while (rs.next()) {
                
                mat = new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(true);
                mat.setActivo(rs.getBoolean("estado"));
                listaDeMateria.add(mat);
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al borrar al alumno" + e.getMessage());
        }
        return listaDeMateria;
    }
}
