/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.entidades;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;

/**
 *
 * @author valen
 */
public class Alumno {
    private int id=-1;
    private int dni;
    private String nombre,apellido;
    private LocalDate fN;
    private boolean activo;

    public Alumno() {
    }
public Alumno(int idAlumno, int dni, String nombre, String apellido, LocalDate fN, boolean activo) {
    this.id=idAlumno;    
    this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fN = fN;
        this.activo = activo;
    }
    public Alumno(int dni, String nombre, String apellido, LocalDate fN, boolean activo) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fN = fN;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getfN() {
        return fN;
    }

    public void setfN(LocalDate fN) {
        this.fN = fN;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
    @Override
    public String toString(){
        return dni+" - "+apellido+", "+nombre;
                
                
    }
    
}
