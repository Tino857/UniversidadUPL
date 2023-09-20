package universidad.entidades;

/**
 *
 * @author Grupo 61
 */
public class Materia {

    private int id = -1;
    private int anioMateria;
    private boolean activo;
    private String nombre;

    public Materia() {
    }

    public Materia(int anioMateria, String nombre, boolean activo) {

        this.anioMateria = anioMateria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Materia(int id, int anioMateria, String nombre, boolean activo) {

        this.id = id;
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

    @Override
    public String toString() {
        return nombre + " - " + anioMateria;
    }
}
