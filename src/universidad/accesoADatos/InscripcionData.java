/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.accesoADatos;

import universidad.entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import universidad.entidades.Alumno;
import universidad.entidades.Materia;


public class InscripcionData {

    private Connection con = null;
    private final AlumnoData aluData;
    private final MateriaData matData;

    public InscripcionData(AlumnoData aluData, MateriaData matData) {
        this.con = Conexion.buscarConexion();
        this.aluData = aluData;
        this.matData = matData;
    }
//Guardar inscripciones
    public void guardarInscripcion(Inscripcion insc) {
        String query = "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) "
                + "VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());
            ps.setInt(2, insc.getIdAlumno());
            ps.setInt(3, insc.getIdMateria());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                insc.setIdInscripcion(rs.getInt(1));
            } else {
                System.out.println("No se pudo recuperar el ID");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar la inscripcion: " + e.getMessage());

        }

    }
//Listar inscripciones 
    public ArrayList<Inscripcion> listarInscripciones() {
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();
        String query = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            Inscripcion insc = null;
            while (rs.next()) {
                insc=new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setIdMateria(rs.getInt("idMateria"));
                insc.setIdAlumno(rs.getInt("idAlumno"));
                insc.setNota(rs.getDouble("nota"));
                listaDeInscripciones.add(insc);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeInscripciones;
    }
//Listar inscripciones por alumno
    public ArrayList<Inscripcion> listarInscripcionesPorAlumno(int id) {
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();
        String query = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Inscripcion insc = null;

            while (rs.next()) {
                insc = new Inscripcion();
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setIdMateria(rs.getInt("idMateria"));
                insc.setIdAlumno(rs.getInt("idAlumno"));
                insc.setNota(rs.getDouble("nota"));
                listaDeInscripciones.add(insc);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeInscripciones;
    }
//Listar materias cursadas y no cursadas
    public ArrayList<Materia> listarMateriasCursadas(int id) {
        ArrayList<Materia> listaDeMateriasCursadas = new ArrayList();
        String query = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia ON (inscripcion.idMateria = materia.idMateria) WHERE inscripcion.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Materia mat =null; 

            while (rs.next()) {
                mat=new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                listaDeMateriasCursadas.add(mat);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeMateriasCursadas;
    }
    
    public ArrayList<Materia> listarMateriasNoCursadas(int id) {
        ArrayList<Materia> listaDeMateriasNoCursadas = new ArrayList();
        //AgregarCondicion
        String query = "SELECT materia.idMateria, materia.nombre, materia.año FROM materia WHERE NOT EXISTS "
                + "(SELECT 1 FROM inscripcion WHERE inscripcion.idAlumno = ? AND inscripcion.idMateria = materia.idMateria)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Materia mat =null; 

            while (rs.next()) {
                mat=new Materia();
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                listaDeMateriasNoCursadas.add(mat);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeMateriasNoCursadas;
    }
//Borrar inscripcion
    public void borarInscripcionPorMateriaAlumno(int idAl,int idMat){
        String query="DELETE FROM `inscripcion` WHERE idMateria=? and idAlumno=?;";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, idMat);
            ps.setInt(2,idAl);
            int registro = ps.executeUpdate();

            if (registro == 1) {
                System.out.println("La inscripcion ha sido borrada");
            } else {
                System.out.println("No se pudo borrar la inscripcion");
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al borrar la inscripcion" + e.getMessage());

        }
    }
    //Actualizar nota 
    public void actualizarNota(int idAl,int idMat, double nota){
        String query = "UPDATE `inscripcion` SET nota=? WHERE`idAlumno`=?AND`idMateria`=?;";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);
            ps.setInt(2,idAl);
            ps.setInt(3, idMat);
          
            int resultado = ps.executeUpdate();
            if (resultado == 1) {
                System.out.println("La nota de la inscripcion fue editada correctamente");
            } else {
                System.out.println("La nota de la inscripcion no pudo ser editada");
            }

            ps.close();

        } catch (SQLException e) {
            System.out.println("Error editar la nota : "+e.getMessage());

        }
    }
    //Listar alumnos por materia
    public ArrayList<Alumno> listarAlumnoxMateria(int idMat){
       ArrayList<Alumno> listaDeAlumno=new ArrayList();
String query = "SELECT alumno.idAlumno,alumno.dni,alumno.apellido,alumno.nombre,alumno.fechaNacimiento from alumno "
        + "join inscripcion ON(inscripcion.idAlumno=alumno.idAlumno) WHERE inscripcion.idMateria=? and alumno.estado=1; ";
      try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            Alumno al =null;
            while (rs.next()) {
                al = new Alumno();
                al.setId(rs.getInt("idAlumno"));
                al.setApellido(rs.getString("apellido"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(true);
                listaDeAlumno.add(al);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al encontrar al alumno" + e.getMessage());

        }  
      return listaDeAlumno;
    }
}
