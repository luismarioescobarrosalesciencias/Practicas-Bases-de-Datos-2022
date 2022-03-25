/**
 * Clase que Manipula archivos CSV  
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales 
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */

package SRC;
import java.text.ParseException;
import java.util.LinkedList;
public class ManipuladorListas {

    /**
     * Constructor por omisión
     */
    public ManipuladorListas() {
    }

    /**
     * Método que recibe una lista de string y devuelve una lista de personas.
     * @param LectorCsv -- lista de strings que se leyeron del archivoCSV
     * @return listaPersonas -- La lista de personas
     * @throws ParseException --Tira Expcepecion de Parseo
     */
    public LinkedList<Persona> LeePersonas(LinkedList<String> LectorCsv) throws ParseException {
        LinkedList<Persona> listaPersonas= new LinkedList<>();
        for (String linea:LectorCsv) {
            String[] arr = linea.split(",");
            System.out.println(arr.length);
            Direccion direccion = new Direccion(arr[5],arr[6],arr[7],arr[8]);
            Persona persona = new Persona(arr[0],arr[1],arr[2],arr[3],arr[4],direccion,arr[9],arr[10],arr[11]);
            listaPersonas.add(persona);
        }
        return listaPersonas;
    }

    /**
     * Método que recibe una lista de string y devuelve una lista de veterinarias.
     * @param LectorCsv -- lista de strings que se leyeron del archivoCSV
     * @return listaVeterinarias -- La lista de veterinarias
     */
    public LinkedList<Veterinaria> LeeVeterinaria(LinkedList<String> LectorCsv){
        LinkedList<Veterinaria> listaVeterinarias = new LinkedList<>();
        for (String linea:LectorCsv){
            String[] arr = linea.split(",");
            Direccion direccion = new Direccion(arr[6],arr[7],arr[8],arr[9]);
            Horario horario = new Horario(arr[4],arr[5]);
            Veterinaria veterinaria = new Veterinaria(arr[0],arr[1],arr[2],arr[3],horario,direccion);
            listaVeterinarias.add(veterinaria);
        }
        return listaVeterinarias;
    }

    /**
     * Método que recibe una lista de string y devuelve una lista de mascotas.
     * @param LectorCsv -- lista de strings que se leyeron del archivoCSV
     * @return listaMascotas -- La lista de mascotas
     * @throws ParseException --Tira Expcepecion de Parseo
     */
    public LinkedList<Mascota> LeeMascota(LinkedList<String> LectorCsv) throws ParseException {
        LinkedList<Mascota> listaMascotas = new LinkedList<>();
        for (String linea:LectorCsv) {
            String[] arr = linea.split(",");
            Mascota mascota = new Mascota(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]);
            listaMascotas.add(mascota);
        }
        return listaMascotas;
    }

    /**
     * Método PersonasAString que recibe una lista de personas, 
     * cada elemento de la lista lo convierte a string y lo agrega a una nueva lista.
     * @param listapersonas -- lista que contiene las personas
     * @return listaAescribir -- lista a escribir de las personas
     */
    public LinkedList<String> PersonasAString(LinkedList<Persona>listapersonas){
        LinkedList<String> listaAescribir = new LinkedList<>();
        for (Persona personas:listapersonas) {
            listaAescribir.add(personas.toString());
        }
        return listaAescribir;
    }

    /**
     * Método VeterinariasAString que recibe una lista de veterinarios, 
     * cada elemento de la lista lo convierte a string y lo agrega a una nueva lista.
     * @param listaVeterinarias -- lista que contiene las veterinarias
     * @return listaAescribir -- lista a escribir de las veterinarias
     */
    public LinkedList<String> VeterinariasAString(LinkedList<Veterinaria>listaVeterinarias){
        LinkedList<String> listaAescribir = new LinkedList<>();
        for (Veterinaria veterinaria:listaVeterinarias) {
            listaAescribir.add(veterinaria.toString());
        }
        return listaAescribir;
    }

    /**
     * Método MascotasAString que recibe una lista de mascotas, 
     * cada elemento de la lista lo convierte a string y lo agrega a una nueva lista.
     * @param listaMascotas -- lista que contiene las mascotas
     * @return listaAescribir -- lista a escribir de las mascotas
     */
    public LinkedList<String> MascotasAString(LinkedList<Mascota>listaMascotas){
        LinkedList<String> listaAescribir = new LinkedList<>();
        for (Mascota mascotas:listaMascotas) {
            listaAescribir.add(mascotas.toString());
        }
        return listaAescribir;
    }

}
