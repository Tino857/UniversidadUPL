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
import universidad.vistas.Vista;

/**
 *
 * @author Grupo 61
 */
public class InscripcionData {

    private Connection con = null;

    public InscripcionData() {
        
        this.con = Conexion.buscarConexion();//Establece la conexion antes detallada
    }
    
    //GUARDAR INSCRIPCIONES
    public int guardarInscripcion(Inscripcion insc) {
        
        int registro = 0;//variable para almacenar el cambio 
        String query = "INSERT INTO `inscripcion`(`nota`, `idAlumno`, `idMateria`) "
                + "VALUES (?,?,?)";//se prepara la consulta, la misma inserta valores en la tabla inscripcion
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, insc.getNota());//se reemplazan los marcadores de posicion
            ps.setInt(2, insc.getIdAlumno());//se reemplazan los marcadores de posicion
            ps.setInt(3, insc.getIdMateria());//se reemplazan los marcadores de posicion
            ps.executeUpdate();//se ejecuta la consulta
            ResultSet rs = ps.getGeneratedKeys();//se obtiene un conjunto de resultados
            if (rs.next()) {
                
                insc.setIdInscripcion(rs.getInt(1));//si se pudo obtener el id se asigna el valor a insc y a registro
                registro = rs.getInt(1);
            } else {
                
                System.out.println("No se pudo recuperar el ID");
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al guardar la inscripcion: " + e.getMessage());
        }
        return registro;//retorna un registro
    }
    
    //LISTAR INSCRIPCIONES
    public ArrayList<Inscripcion> listarInscripciones() {
        
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();//se crea un Array para guardar Inscripciones
        String query = "SELECT * FROM inscripcion";//se prepara la consulta
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta
            Inscripcion insc = null;//se inicializa insc en null, para guardar los cambios 
            while (rs.next()) {//se inicializa un bucle mientras
                
                insc=new Inscripcion();//se creo una instancia nueva de tipo Inscripcion
                insc.setIdInscripcion(rs.getInt("idInscripto"));//se setean los parametros de la instancia Inscripcion
                insc.setIdMateria(rs.getInt("idMateria"));//se setean los parametros de la instancia Inscripcion
                insc.setIdAlumno(rs.getInt("idAlumno"));//se setean los parametros de la instancia Inscripcion
                insc.setNota(rs.getDouble("nota"));//se setean los parametros de la instancia Inscripcion
                listaDeInscripciones.add(insc);// se agrega la inscripcion a la lista
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al entrar a la BD" + e.getMessage());
        }
        return listaDeInscripciones;//retorna una lista de inscripciones
    }
    
    //LISTAR INSCRIPCIONES POR ALUMNO
    public ArrayList<Inscripcion> listarInscripcionesPorAlumno(int id) {
        
        ArrayList<Inscripcion> listaDeInscripciones = new ArrayList();//se crea una lista
        String query = "SELECT * FROM inscripcion join materia on (inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno=? and materia.estado=1";//se prepara la consulta
        
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);//se asigna el valor del parametro al comodin 
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta, devolviendo un conjunto de resultados
            Inscripcion insc = null;//se inicializa una Inscripcion null, se usara para guardar los cambios
            Materia mat = null;//también se inicializan variables mat y alu de tipo Materia y Alumno respectivamente, que se utilizaran para informacion adicional
            Alumno alu = null;
            while (rs.next()) {//se inicia un bucle
                
                insc = new Inscripcion();//se inicializa una INSC nueva en cada iteracion del bucle
                insc.setIdInscripcion(rs.getInt("idInscripto"));
                mat = Vista.getMD().buscarMateriaPorID(rs.getInt("idMateria"));
                alu = Vista.getAD().buscarAlumnoPorId(rs.getInt("idAlumno"));
                insc.setMateria(mat);
                insc.setAlumno(alu);
                insc.setNota(rs.getDouble("nota"));
                listaDeInscripciones.add(insc);//se agrega a la lista de inscripciones
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al entrar a la BD" + e.getMessage());
        }
        return listaDeInscripciones;//retorna una lista de inscaripciones
    }
    
    //LISTAR MATERIAS CURSADAS
    public ArrayList<Materia> listarMateriasCursadas(int id) {
        
        ArrayList<Materia> listaDeMateriasCursadas = new ArrayList();//se crea una lista
        String query = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia ON "
                + "(inscripcion.idMateria = materia.idMateria) WHERE inscripcion.idAlumno = ? and materia.estado=1";//se prepara la consulta SQL

        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);//se asigna el valor del parametro al  comodin
            ResultSet rs = ps.executeQuery();//se ejecuta laa consulta, dando como resultado un conjunto de resultados
            Materia mat = null; // se inicializa una Materia en null
            while (rs.next()) {// se inicia un bucle
                
                mat=new Materia();//materia nueva para setear en cadaa iteracion
                mat.setId(rs.getInt("idMateria"));
                mat.setAnioMateria(rs.getInt("año"));
                mat.setNombre(rs.getString("nombre"));
                listaDeMateriasCursadas.add(mat);// se agrega una mataria en cada proceso del bucle
            }
            
            ps.close();//se cierra el ps
        } catch (SQLException e) {
            
            System.out.println("Error al entrar a la BD" + e.getMessage());// se manejan las excepciones 
        }
        return listaDeMateriasCursadas;//retorna una lista de materias
    }
    
    //LISTAR MATERIAS NO CURSADAS
    public ArrayList<Materia> listarMateriasNoCursadas(int id) {
        
        ArrayList<Materia> listaDeMateriasNoCursadas = new ArrayList();//se crea una listaa
        String query = "SELECT materia.idMateria, materia.nombre, materia.año FROM materia WHERE NOT EXISTS "
                + "(SELECT 1 FROM inscripcion WHERE inscripcion.idAlumno = ? AND inscripcion.idMateria = materia.idMateria and materia.estado=1)";
               //se utiliza un WHERE NOT EXISTS para filtrar las materias que no tienen registros correspondientes en la tabla inscripcion
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);//se prepara una sentencia 
            ps.setInt(1, id);//se asigna el ID(pasado por parametro) al comodin
            ResultSet rs = ps.executeQuery();//se ejecutta ala consulta
            Materia mat = null; //se inicializa una Materia  para guardar los cambios en cada iteracion del bucle
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
    
    //BORRAR INSCRIPCION
    public int borarInscripcionPorMateriaAlumno(int idAl,int idMat){
        
        String query = "DELETE FROM `inscripcion` WHERE idMateria=? and idAlumno=?;";//se prepara la consulta, que elimina una fila
        int registro = 0;//variable en 0, para almacenar los cambios
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idMat);//se asigna valorres paasados por parametro a los comodines
            ps.setInt(2,idAl);//se asigna valorres paasados por parametro a los comodines
            registro = ps.executeUpdate();//se ejecuta la consulta y see guarda en la variable registro

            ps.close();// se cierra el ps
        } catch (SQLException e) {
            
            System.out.println("Error al borrar la inscripcion" + e.getMessage());
        }
        return registro;//se retorna un registro
    }
    
    //ACTUALIZAR NOTA
    public int actualizarNota(int idAl,int idMat, double nota){
        
        String query = "UPDATE `inscripcion` SET nota=? WHERE `idAlumno`=? AND `idMateria`=?;";//se prepara la consulta
        int registro = 0;//se inicializa la variable en 0 para guardar los cambios
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, nota);//se asigna valor por parametro al comodin de posicion
            ps.setInt(2, idAl);//se asigna valor por parametro al comodin de posicion
            ps.setInt(3, idMat);//se asigna valor por parametro al comodin de posicion
            registro = ps.executeUpdate();//se ejecuta la consulta
            ps.close();//se cierra ps
        } catch (SQLException e) {
            
            System.out.println("Error editar la nota : "+e.getMessage());//manejo de excepciones
        }
        return registro;//retorno de registro
    }
    
    //LISTAR ALUMNOS POR MATERIA
    public ArrayList<Alumno> listarAlumnoxMateria(int idMat){
        ArrayList<Alumno> listaDeAlumno=new ArrayList();//se crea una lista de Alumnos
        String query = "SELECT alumno.idAlumno,alumno.dni,alumno.apellido,alumno.nombre,alumno.fechaNacimiento from alumno "
        + "join inscripcion ON(inscripcion.idAlumno=alumno.idAlumno) WHERE inscripcion.idMateria=? and alumno.estado=1; ";// se utiliza un join para unnir table de alumno con inscripcion basada en idAlumno
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idMat); //se asigna valor por parametro al comodin de posicion
            ResultSet rs = ps.executeQuery();//se ejecuta la consulta
            Alumno al = null;//inicializamos al en null
            while (rs.next()) {//inicia un bucle
                
                al = new Alumno();//esto aseguura que se inicie una nueva clasae de Alumno en cada ciclo
                al.setId(rs.getInt("idAlumno"));
                al.setApellido(rs.getString("apellido"));
                al.setNombre(rs.getString("nombre"));
                al.setDni(rs.getInt("dni"));
                al.setfN(rs.getDate("fechaNacimiento").toLocalDate());
                al.setActivo(true);
                listaDeAlumno.add(al);// se agrega el alumno a la lista
            }
            
            ps.close();
        } catch (SQLException e) {
            
            System.out.println("Error al encontrar al alumno" + e.getMessage());//manejo de excepciones
        }  
        return listaDeAlumno;//retorna un alumno
    }
    //Elimina las inscripciones activas de las materias que hayan sido eliminadas
    public void limpariInscripciones(Materia mat){
        String query = "DELETE FROM `inscripcion` WHERE idMateria=?;";//se prepara la consulta, que elimina una fila
        int registro = 0;//variable en 0, para almacenar los cambios
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mat.getId());//se asigna valorres paasados por parametro a los comodines          
            registro = ps.executeUpdate();//se ejecuta la consulta y see guarda en la variable registro

            ps.close();// se cierra el ps
        } catch (SQLException e) {
            
            System.out.println("Error al borrar la inscripcion" + e.getMessage());
        }
       
    }
      //Elimina las inscripciones activas de los alumnos que hayan sido eliminados
    public void limpariInscripciones(Alumno al){
        String query = "DELETE FROM `inscripcion` WHERE idAlumno=?;";//se prepara la consulta, que elimina una fila
        int registro = 0;//variable en 0, para almacenar los cambios
        try {
            
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, al.getId());//se asigna valorres paasados por parametro a los comodines          
            registro = ps.executeUpdate();//se ejecuta la consulta y see guarda en la variable registro

            ps.close();// se cierra el ps
        } catch (SQLException e) {
            
            System.out.println("Error al borrar la inscripcion" + e.getMessage());
        }
       
    }
    
}
