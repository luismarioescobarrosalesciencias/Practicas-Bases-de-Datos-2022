/**
 * Clase que modela una Mascota 
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales 
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */
package SRC;
public class Mascota{
    String nombre;
    String peso;
    String edad;
    String FechaNacimiento;
    String raza;
    String idPersona;
    
    /**
     * Constructor por omision
     */
    public Mascota() {
    }
    
    /**
     * Constructor por parametros que genera una Mascota
     * @param  nombre -- nombre de la mascota
     * @param  peso -- peso de la mascota
     * @param  edad  -- edad de la mascota
     * @param  fechaNacimiento -- fecha de nacimiento de la mascota
     * @param  raza -- raza de la mascota
     * @param idpersona -- identificador de la persona a la que pertenece la mascota
     */

    public Mascota(String nombre, String peso, String edad, String fechaNacimiento, String raza, String idpersona) {
        this.nombre = nombre;
        this.peso = peso;
        this.edad = edad;
        FechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.idPersona = idpersona;
    }

   /**
    * Metodo getNombre que obtiene el nombre de la mascota.
    * @return nombre -- regresa el nombre de la mascota. 
    */
    public String getNombre() {
        return nombre;
    }
    
   /**
    * Metodo setNombre que define el nuevo nombre de la mascota. 
    * @param  nombre -- El nuevo nombre de la mascota.
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
    * Metodo getPeso que obtiene el peso de la mascota.
    * @return peso -- regresa el peso de la mascota. 
    */
    public String getPeso() {
        return peso;
    }

    /**
    * Metodo setPeso que modifica   el nuevo peso de la mascota. 
    * @param  peso -- el nuevo peso de la mascota 
    */
    public void setPeso(String peso) {
        this.peso = peso;
    }

    
   /**
    * Metodo getEdad que obtiene la edad de la mascota.
    * @return edad -- regresa la edad  de la mascota. 
    */  
    public String getEdad() {
        return edad;
    }

   /**
    * Metodo setEdad que modifica  la edad  de la mascota. 
    * @param  edad -- modifica la edad de la mascota 
    */
    public void setEdad(String edad) {
        this.edad = edad;
    }

   /**
    * Metodo getFechaNacimiento que obtiene la fecha de nacimiento  de la mascota.
    * @return  edad -- regresa la edad  de la mascota. 
    */      
    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    
   /**
    * Metodo setFechaNacimiento que modifica  la fecha de nacimiento  de la mascota. 
    * @param  fechaNacimiento -- modifica la fecha de nacimiento  de la mascota 
    */
    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
    
   /**
    * Metodo getRaza que obtiene la raza  de la mascota.
    * @return  raza -- regresa la edad  de la mascota. 
    */  
    public String getRaza() {
        return raza;
    }

   /**
    * Metodo setRaza que modifica  la raza de   de la mascota. 
    * @param raza -- modifica la raza de la mascota   de la mascota 
    */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    
   /**
    * Metodo getIdPersona que obtiene  el identificador del dueño   de la mascota.
    * @return IdPersona -- regresa el identificador del dueño   de la mascota. 
    */ 
    public String getIdPersona() {
        return idPersona;
    }

    
   /**
    * Metodo setIdPersona que modifica  el Id del dueño de la mascota. 
    * @param  idPersona -- modifica el identificador del dueño de la mascota
    */
    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

   /**
    * Metodo toString que regresa un string que representa a la mascota . 
    * @return modelo de la mascota   
    */
    @Override
    public String toString() {
        return nombre +","+peso+","+edad+","+FechaNacimiento.toString()+","+raza+","+ idPersona.toString();
    }
}
