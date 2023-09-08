/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author valen
 */
public class Inscripcion {
    private int idInscripcion=-1;
   private Alumno alumno;
   private Materia materia;
   private double nota;

    public Inscripcion() {
    }

    public Inscripcion(double nota) {
        this.nota = nota;
    }
 public Inscripcion(int id,Alumno alumno, Materia materia, double nota) {
     this.idInscripcion=id;   
     this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
    public Inscripcion(Alumno alumno, Materia materia, double nota) {
        this.alumno = alumno;
        this.materia = materia;
        this.nota = nota;
    }
   public int getIdMateria(){
        return materia.getId();
    }
    public int getIdAlumno(){
        return alumno.getId();
    }
      public void setIdAlumno(int idAlumno) {
        this.alumno.setId(idAlumno); 
    }
     public void setIdMateria(int idMateria) {
        this.materia.setId(idMateria); 
    }
    public int getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(int idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
    
    
}
