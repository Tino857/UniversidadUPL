/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.accesoADatos;

import universidad.entidades.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author valen
 */
public class AlumnoData {

    private Connection con = null;

    public AlumnoData() {
        this.con = Conexion.buscarConexion();
    }

    public void guardarAlumno(Alumno alumno) {
        String query = "INSERT INTO alumno(dni,apellido, nombre, fechaNacimiento,estado) "
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getfN().toString());
            ps.setBoolean(5, alumno.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                alumno.setId(rs.getInt(1));
            } else {
                System.out.println("No se pudo recuperar el ID");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar al alumno: " + alumno.getNombre() + " " + alumno.getApellido() + " " + e.getMessage());

        }

    }

    public int eliminarAlumnoLogico(int dni) {
        String query = "UPDATE alumno SET estado=0 WHERE dni=?";
        int registro = 0;
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1,dni);
             registro = ps.executeUpdate();

           /* if (registro == 1) {
                System.out.println("El alumno ha sido borrado");
            } else {
                System.out.println("No se pudo borrar al alumno");
            }*/
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar al alumno" + e.getMessage());

        } return registro;
    }

    public void eliminarAlumno(int id) {
        String query = "DELETE FROM `alumno` WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, id);
            int registro = ps.executeUpdate();

            if (registro == 1) {
                JOptionPane.showMessageDialog(null, "El alumno ha sido borrado");
            } else {
                JOptionPane.showMessageDialog(null,"No se pudo borrar al alumno");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar al alumno" + e.getMessage());

        }

    }

    public void editarAlumno(Alumno alumno) {
        String query = "UPDATE `alumno` SET `dni`=?,`apellido`=?,`nombre`=?,`fechaNacimiento`=? WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, alumno.getDni());
            ps.setString(2, alumno.getApellido());
            ps.setString(3, alumno.getNombre());
            ps.setString(4, alumno.getfN().toString());
            ps.setInt(5, alumno.getId());
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("El alumno fue editado correctamente");
            } else {
                System.out.println("El alumno no pudo ser editado");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error editar al alumno : " + alumno.getNombre() + " " + alumno.getApellido() + " " + e.getMessage());

        }

    }

    //  BUSCAR ALUMNO POR ID Y POR DNI
    public Alumno buscarAlumnoPorId(int id) {
        Alumno al =null; 
        String query = "SELECT * FROM alumno WHERE idAlumno=? and estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));

            } else {
                JOptionPane.showMessageDialog(null, "No existe el alumno");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar el alumno" + e.getMessage());

        }
        return al;
    }

    public Alumno buscarAlumnoPorDni(int dni) {
        Alumno al =null; 
        String query = "SELECT * FROM alumno WHERE dni=? and estado=1";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));
                
            }
            else {
              
                    JOptionPane.showMessageDialog(null, "No existe el alumno");  
              
  
               
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al buscar el alumno" + e.getMessage());

        }
        return al;
    }

    //LISTAR ALUMNOS
    public ArrayList<Alumno> listarAlumnos() {
        ArrayList<Alumno> listaDeAlumno = new ArrayList();
        String query = "SELECT * FROM alumno";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
           Alumno al = null;
            while (rs.next()) {
             al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setApellido(rs.getString("apellido"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(rs.getBoolean("estado"));
                listaDeAlumno.add(al);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al encontrar al alumno" + e.getMessage());

        }
        return listaDeAlumno;
    }
}
