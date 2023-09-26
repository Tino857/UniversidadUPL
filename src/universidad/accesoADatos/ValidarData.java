package universidad.accesoADatos;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Grupo 61
 */
public class ValidarData {

    //Valida si una cadena contiene caracteres especiales
    //En caso de contener retorna verdadero, caso contrario, falso
    public static boolean caracteresEspeciales(String cadena){
        
        String sup = "ºª!|@·#$~%€&¬/()=?¿¡'`^[*+]´¨{çÇ},;:.-_<>1234567890";
        for (int i = 0; i < cadena.length(); i++) {
            String letra = cadena.substring(i, i + 1);
            if (sup.contains(letra)) {
                return true;
            }
        }
        return false;
    }
    
    //Valida si una cadena cumple con un largo determinado
    //En caso de encontrarse fuera del rango retorna verdadero, caso contrario, falso
    public static boolean largoCadena(String cadena){
        
        return (cadena.length() <= 2 || cadena.length() >= 100);
    }
    
    //Valida si una entero se encuentra dentro de un rango
    //En caso de encontrarse fuera del rango retorna verdadero, caso contrario, falso
    public static boolean validarDNI(int dni){
        
        return (dni <= 10000000 || dni >= 69999999);
    }
    
    //Valida si una fecha se encuentra dentro de un rango
    //En caso de encontrarse fuera del rango retorna verdadero, caso contrario, falso
    public static boolean validarFecha(LocalDate fecha){
        
        return (fecha.isBefore(LocalDate.of(1950, 01, 01)) || fecha.isAfter(LocalDate.now(ZoneId.systemDefault())));
    }
    
    //Valida si un entero se encuentra dentro de un rango
    //En caso de encontrarse fuera del rango retorna verdadero, caso contrario, falso
    public static boolean validarAnio(int anio){
        
        return (anio < 1 || anio > 6);
    }
    
    //Valida si un double se encuentra dentro de un rango
    //En caso de encontrarse fuera del rango retorna verdadero, caso contrario, falso
    public static boolean validarNota(double nota){
        
        return (nota < 1 || nota > 10);
    }
}
