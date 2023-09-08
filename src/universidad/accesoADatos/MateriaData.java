/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.accesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import universidad.entidades.Materia;

/**
 *
 * @author valen
 */
public class MateriaData {
    private Connection con=null;

    public MateriaData() {
       this.con=Conexion.buscarConexion();
    }
    // GUARDAR MATERIA
       public void guardarMateria(Materia M) {
        String query = "INSERT INTO `materia`(`nombre`, `año`, `estado`) "
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, M.getNombre());
            ps.setInt(2, M.getAnioMateria());
            ps.setBoolean(3, M.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                M.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo recuperar el ID");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar la materia : " + M.getNombre() + " "+ e.getMessage());

        }

    } 
       //ELIMINAR MATERIA
        public void eliminarMateriaLogico(int id) {
        String query = "UPDATE `materia` SET estado=0 WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();

            if (registro == 1) {
                System.out.println("La materia ha sido borrada");
            } else {
                System.out.println("No se pudo borrar a la materia");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar la materia : "+ e.getMessage());

        }

    } 
        public void eliminarMateria(int id) {
        String query = "DELETE FROM materia WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            int registro = ps.executeUpdate();

            if (registro == 1) {
                System.out.println("La materia ha sido borrada");
            } else {
                System.out.println("No se pudo borrar a la materia");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar la materia : "+ e.getMessage());

        }

    }
        //EDITAR MATERIA
        public void editarMateria(Materia M) {
        String query = "UPDATE materia SET nombre=?,año=? WHERE idMateria=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           ps.setString(1, M.getNombre());
            ps.setInt(2, M.getAnioMateria());
           ps.setInt(3,M.getId());
            
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("La materia fue editada correctamente");
            } else {
                System.out.println("La materia no pudo ser editada");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error editar al alumno : " + M.getNombre() +" " + e.getMessage());

        }
        

    }
        //BUSCAR MATERIA
        public Materia buscarMateriaPorId(int id){
            Materia mat=new Materia();
            String query="SELECT * FROM `materia` WHERE idMateria=? and estado=1";
             try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {

                mat.setId(id);
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                mat.setActivo(true);
              
               
               
           
            }else{
                JOptionPane.showMessageDialog(null, "No existe la materia");
            }
            
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar materia "+ e.getMessage());

        }
            return mat;
        }
        //LISTAR MATERIAS
        public ArrayList<Materia> listarMaterias(){
    ArrayList<Materia> listaDeMateria=new  ArrayList();
        String query = "SELECT * FROM materia";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Materia mat=new Materia();
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
