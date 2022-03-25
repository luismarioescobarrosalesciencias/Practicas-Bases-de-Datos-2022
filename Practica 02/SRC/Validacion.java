/**
 * Clase que Valida que ciertos datos tengan una entrada correcta 
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales 
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */

package SRC;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacion {
    public static final Pattern VALID_PHONE_ADDRESS_REGEX =
            Pattern.compile("^[0-9]{6,15}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_AGE_ADDRESS_REGEX =
            Pattern.compile("^[0-9]{0,3}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_CONSULTORIOS_ADDRESS_REGEX =
            Pattern.compile("^[1-4]{0,1}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    
    
   /**
    * Metodo que normaliza una cadena pal , eliminando caracteres invalidos como emojis,y quitano espacios en blanco, haciendo uso de regex  
    * @param pal cadena a normalizar 
    * @return pal cadena normalizada 
    */
    public static String normaliza(String pal){
        if (pal.isEmpty()){
            return "is empty";
        }
        if (pal.contains("\uDE88")||pal.contains("\uD835")){
            return "contains invalid characters";
        }
        if(pal.contains(" ")){
            String[] aux = pal.split(" ");
            pal ="";
            for (String auxiliar : aux) {
                if(auxiliar.length() >1){
                    pal= pal +" " + auxiliar;
                } else{
                    pal = pal + auxiliar;
                }
            }
        }
        pal = pal.toUpperCase();
        pal = pal.replace("á","a").replace("é","e").replace("í","i").replace("ó","o").replace("ú","u").replace("ñ","n");
        pal = pal.replaceAll("[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]",""); // Quita emojis
        pal = pal.trim();
        if (pal.isEmpty()){
            return "is empty";
        }
        return pal;
    }
    
   /**
    * Metodo que valida que una Persona sea valida, verificando que sus atributos sean correctos 
    * @param persona persona a verificar
    * @return true en caso de ser una persona valida, false en caso contrario 
    */
    
    public boolean ValidacionPersona(Persona persona){
        if (persona ==null){
            return false;
        } else{
            if (!ValidacionNombre(persona.getNombres())) return false;
            if (!ValidacionNombre(persona.getApellidoPaterno())) return false;
            if (!ValidacionNombre(persona.getApellidoMaterno())) return false;
            if (!ValidacionNombre(persona.getCURP())) return false;
            if (persona.getDireccion()==null) return false;
            if (persona.getDireccion().getEstado() ==null) return false;
            if (persona.getDireccion().getCalle()==null) return false;
            if (persona.getDireccion().getNumero()==null)return false;
            if (persona.getDireccion().getCodigoPostal() ==null) return false;
            if (persona.getFechaNacimiento() == null) return false;
            if (!ValidacionTelefono(persona.getTelefono())) return false;
            if(!ValidacionEmail(persona.getEmail())) return false;
        }
        return true;
    }
    
    /**
    * Metodo que valida que una Mascota  sea valida, verificando que sus atributos sean correctos 
    * @param mascota mascota a verificar  
    * @return true en caso de ser una mascota valida, false en caso contrario 
    */
    public boolean ValidacionMascota(Mascota mascota){
        if (mascota == null) return false;
        if (!ValidacionNombre(mascota.getNombre())) return false;
        if (!ValidacionEdad(mascota.getEdad())) return false;
        if (mascota.getFechaNacimiento()==null) return false;
        if (mascota.getPeso()==null) return false;
        if (!ValidacionNombre(mascota.getRaza())) return false;
        return true;
    }
    
   /**
    * Metodo que valida que una Veterinaria  sea valida, verificando que sus atributos sean correctos 
    * @param veterinaria veterinaria a verificar  
    * @return true en caso de ser una mascota valida, false en caso contrario 
    */
    public boolean ValidacionVeterinaria(Veterinaria veterinaria){
        if (veterinaria==null) return false;
        if (!ValidacionNombre(veterinaria.getNombre()))return false;
        if (!ValidacionNombre(veterinaria.getApartado()))return false;
        if (veterinaria.getDireccion()==null) return false;
        if (veterinaria.getDireccion().getEstado() ==null) return false;
        if (veterinaria.getDireccion().getCalle()==null) return false;
        if (veterinaria.getDireccion().getNumero()==null)return false;
        if (veterinaria.getDireccion().getCodigoPostal() ==null) return false;
        if (!ValidacionConsultorios(veterinaria.getConsultorios())) return false;
        if (!ValidacionTelefono(veterinaria.getTelefono())) return false;
        if (veterinaria.getHorario()==null) return false;
        return true;
    }
    
    /**
    * Metodo que valida que una cadena str  sea un nombre valida,
    * normaliza la cadena, y verifica si tiene caracteres invalidos 
    * @param str cadena  a verificar  
    * @return true en caso de ser un nombre  valido, false en caso contrario 
    */
    public boolean ValidacionNombre(String str){
        String strNormalizado = normaliza(str);
        if(strNormalizado.equals("isempty")||strNormalizado.equals("contains invalid characters")||strNormalizado.isEmpty()||str.isEmpty()){
            return false;
        }
        return true;
    }
    
   /**
    * Metodo que valida que una cadena str  sea un telefono valido,
    * normaliza la cadena, y verifica si los caracteres son solo numeros  
    * @param str cadena  a verificar  
    * @return true en caso de ser un telefono valida, false en caso contrario 
    */
    public boolean ValidacionTelefono(String str){
        Matcher matcher = VALID_PHONE_ADDRESS_REGEX.matcher(str);
        return matcher.find();
    }
    
   /**
    * Metodo que valida que una cadena str  sea un email valido,
    * normaliza la cadena, y verifica si el caracter tiene una estrucura tipo : example@example.mmm
    * @param str cadena  a verificar  
    * @return true en caso de ser un email valido, false en caso contrario 
    */
    public boolean ValidacionEmail(String str){
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(str);
        return matcher.find();
    }
    /**
    * Metodo que valida que una cadena str  sea una edad valida,
    * normaliza la cadena, y verifica si los caracteres son solo numeros   
    * @param str cadena  a verificar  
    * @return true en caso de ser una edad valida, false en caso contrario 
    */
    public boolean ValidacionEdad(String str){
        Matcher matcher = VALID_AGE_ADDRESS_REGEX.matcher(str);
        return matcher.find();
    }
    
   /**
    * Metodo que valida que una cadena str  sean consultorios validos,
    * normaliza la cadena, y verifica si es valida   
    * @param str cadena  a verificar  
    * @return true en caso de ser consultorios validos, false en caso contrario 
    */
    public boolean ValidacionConsultorios(String str){
        Matcher matcher = VALID_CONSULTORIOS_ADDRESS_REGEX.matcher(str);
        return matcher.find();
    }
}
