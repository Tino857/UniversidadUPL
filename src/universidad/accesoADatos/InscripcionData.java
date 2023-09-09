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
import universidad.entidades.Materia;

/**
 *
 * @author valen
 */
public class InscripcionData {

    private Connection con = null;
    private final AlumnoData aluData;
    private final MateriaData matData;

    public InscripcionData(Conexion conex, AlumnoData aluData, MateriaData matData) {
        this.con = conex.buscarConexion();
        this.aluData = aluData;
        this.matData = matData;
    }

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

    public ArrayList<Inscripcion> listarInscripciones() {
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();
        String query = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();
            Inscripcion insc = new Inscripcion();

            while (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setIdMateria(rs.getInt("idMateria"));
                insc.setIdAlumno(rs.getInt("idAlumno"));
                insc.setNota(rs.getInt("nota"));
                listaDeInscripciones.add(insc);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeInscripciones;
    }

    public ArrayList<Inscripcion> listarInscripcionesPorAlumno(int id) {
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();
        String query = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            Inscripcion insc = new Inscripcion();

            while (rs.next()) {
                insc.setIdInscripcion(rs.getInt("idInscripcion"));
                insc.setIdMateria(rs.getInt("idMateria"));
                insc.setIdAlumno(rs.getInt("idAlumno"));
                insc.setNota(rs.getInt("nota"));
                listaDeInscripciones.add(insc);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeInscripciones;
    }

    public ArrayList<Materia> listarMateriasCursadas(int id) {
        ArrayList<Materia> listaDeMateriasCursadas = new ArrayList();
        String query = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia ON (inscripcion.idMateria = materia.idMateria) WHERE inscripcion.idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Materia materia = new Materia();

            while (rs.next()) {
                materia.setId(rs.getInt("idMateria"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                listaDeMateriasCursadas.add(materia);
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
        String query = "SELECT m.idMateria, m.nombre, m.año FROM materia AS m WHERE NOT EXISTS "
                + "(SELECT 1 FROM inscripcion AS i WHERE i.idAlumno = 1 AND i.idMateria = m.idMateria)";

        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Materia materia = new Materia();

            while (rs.next()) {
                materia.setId(rs.getInt("idMateria"));
                materia.setAnioMateria(rs.getInt("año"));
                materia.setNombre(rs.getString("nombre"));
                listaDeMateriasNoCursadas.add(materia);
            }
            ps.close();

        } catch (SQLException e) {
            System.out.println("Error al entrar a la BD" + e.getMessage());

        }
        return listaDeMateriasNoCursadas;
    }

}
