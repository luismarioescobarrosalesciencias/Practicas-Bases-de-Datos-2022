/**
 * Clase que modela una Direccion 
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales 
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */


package SRC;
public class Direccion {
    String estado;
    String calle;
    String numero;
    String CodigoPostal;

   /**
    * Constructor por omision
    */
    public Direccion() {
    }


    /**
     * Constructor por parametros que genera una direccion
     * @param  estado -- nombre del estado 
     * @param  calle -- nombre de la calle 
     * @param  numero  -- numero de la direccion 
     * @param  codigoPostal -- codigo postal de la direccion 
     */
    public Direccion(String estado, String calle, String numero, String codigoPostal) {
        this.estado = estado;
        this.calle = calle;
        this.numero = numero;
        CodigoPostal = codigoPostal;
    }


   /**
    * Metodo getEstado obtiene el estado(lugar) de la direccion 
    * @return estado -- regresa el estado de la direccion . 
    */
    public String getEstado() {
        return estado;
    }

   /**
    * Metodo setEstado que define el nuevo estado(lugar) de la direccion. 
    * @param  estado -- El nuevo nombre de la veterinaria.
    */
    public void setEstado(String estado) {
        this.estado = estado;
    }

   /**
    * Metodo getCalle obtiene la calle  de la direccion 
    * @return calle -- regresa la calle de la direccion . 
    */
    public String getCalle() {
        return calle;
    }

   /**
    * Metodo setCalle que define la nueva  calle  de la direccion. 
    * @param  calle -- La nueva calle de la direccion .
    */
    public void setCalle(String calle) {
        this.calle = calle;
    }
    
   /**
    * Metodo getNumero obtiene el numero  de la direccion 
    * @return getNumero -- regresa el numero  de la direccion . 
    */
    
    public String getNumero() {
        return numero;
    }
    
   /**
    * Metodo setNumero que define el nuevo numero  de la direccion. 
    * @param  numero -- El nuevo numero de la direccion .
    */
    
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCodigoPostal() {
        return CodigoPostal;
    }
    
   /**
    * Metodo setCodigoPostal que define el nuevo codigo postal   de la direccion. 
    * @param  codigoPostal-- El nuevo codigo postal  de la direccion .
    */
    public void setCodigoPostal(String codigoPostal) {
        CodigoPostal = codigoPostal;
    }
    
   /**
    * Metodo toString que regresa un string que representa la direccion  . 
    * @return modelo string de la direccion 
    */
    @Override
    public String toString() {
        return estado + "," + calle +","+numero +","+CodigoPostal;
    }
}
