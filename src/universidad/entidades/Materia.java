/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.entidades;

/**
 *
 * @author valen
 */
public class Materia {

    private int id = -1;
    private int anioMateria;
    private String nombre;
    private boolean activo;

    public Materia(int id, int anioMateria, String nombre, boolean activo) {
        this.id = id;

        this.anioMateria = anioMateria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Materia() {
    }

    public Materia(int anioMateria, String nombre, boolean activo) {

        this.anioMateria = anioMateria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAnioMateria() {
        return anioMateria;
    }

    public void setAnioMateria(int anioMateria) {
        this.anioMateria = anioMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

}
