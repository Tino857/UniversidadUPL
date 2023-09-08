/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoADatos;

import Entidades.Alumno;
import Entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author valen
 */
public class InscripcionData {
     private Connection con=null;
     private AlumnoData aluData;
     private MateriaData matData;

    public InscripcionData(Conexion conex,AlumnoData aluData,MateriaData matData) {
        this.con=conex.buscarConexion();
        this.aluData=aluData;
        this.matData=matData;
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
            System.out.println("Error al guardar la inscripcion: "+ e.getMessage());

        }

    }
     public ArrayList<Inscripcion> listarInscripciones(){
    ArrayList<Inscripcion> listaDeInscripciones=new  ArrayList();
        String query = "SELECT * FROM inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
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
     
     public ArrayList<Inscripcion> listarInscripcionesPorAlumno(int id){
    ArrayList<Inscripcion> listaDeInscripciones=new  ArrayList();
        String query = "SELECT * FROM inscripcion WHERE idAlumno=?";
        try {
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Inscripcion insc = new Inscripcion();
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
     public ArrayList<Materia> listarMateriasCursadas(int id){
         
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
}
