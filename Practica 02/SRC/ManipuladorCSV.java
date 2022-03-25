/**
 * ManipuladorCSV Clase que Manipula archivos CSV
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales 
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */
package SRC;
import java.io.*;
import java.util.LinkedList;

public class ManipuladorCSV {
    /**
    * Metodo que lee un archivo Csv y guarda cada linea de este en una LinkedList
    * @param ArchivoCsv con el nombre del archivo a leer
    * @return LinkedList con cada linea del ArchivoCsv
    *  
    */
    public LinkedList<String> LeeArchivoCsv(String ArchivoCsv){
        LinkedList<String> lista = new LinkedList<>();
        BufferedReader bufferLectura = null;

        try {
            bufferLectura = new BufferedReader(new FileReader(ArchivoCsv));
            String linea1 = bufferLectura.readLine();

            while (linea1 != null) {

                lista.add(linea1);
                linea1 = bufferLectura.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferLectura != null) {
                try {
                    bufferLectura.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(lista.getFirst().toString()+"--"+lista.getLast().toString());
        return lista;
    }

    /**
     * Metodo que escribe un Csv pasandole una LinkedList
     * @param listaAEscribir con el nombre del archivo a guardar
     * @param ArchivoDondeSeGuarda lista con las lineas en String que se escribiran en el csv
     * @return String con el archivo donde se guarda la lista
     *  
     */
    public String EscribeCsv(LinkedList<String> listaAEscribir, String ArchivoDondeSeGuarda){
        BufferedWriter bw ;
        String Nombre = ArchivoDondeSeGuarda;
        try{
            bw = new BufferedWriter(new FileWriter(Nombre));
            for (String str: listaAEscribir) {
                bw.write(str);
                bw.newLine();
            }
            bw.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
        return Nombre;
    }
    
     /**
     * Metodo que escribe u Csv con una lista de Personas 
     * @param listaAEscribir con el nombre del archivo a guardar
     * @param ArchivoDondeSeGuarda lista con las lineas en String que se escribiran en el csv
     * @return String con el archivo donde se guarda la lista
     *  
     */
    public String EscribeCsvPersonas(LinkedList<Persona> listaAEscribir, String ArchivoDondeSeGuarda){
        ManipuladorListas manipuladorListas = new ManipuladorListas();
        EscribeCsv(manipuladorListas.PersonasAString(listaAEscribir),ArchivoDondeSeGuarda);
        return ArchivoDondeSeGuarda;
    }
    
    /**
     * Metodo que escribe un Csv con una lista de Veterinarias 
     * @param listaAEscribir con el nombre del archivo a guardar
     * @param ArchivoDondeSeGuarda lista con las lineas en String que se escribiran en el csv
     * @return String con el archivo donde se guarda la lista
     * 
     */
    public String EscribeCsvVeterinarias(LinkedList<Veterinaria> listaAEscribir, String ArchivoDondeSeGuarda){
        ManipuladorListas manipuladorListas = new ManipuladorListas();
        EscribeCsv(manipuladorListas.VeterinariasAString(listaAEscribir),ArchivoDondeSeGuarda);
        return ArchivoDondeSeGuarda;
    }
    
     /**
     * Metodo que escribe un Csv con una lista de Mascotas 
     * @param listaAEscribir con el nombre del archivo a guardar
     * @param ArchivoDondeSeGuarda lista con las lineas en String que se escribiran en el csv
     * @return String con el archivo donde se guarda la lista
     * 
     */
    public String EscribeCsvMascotas(LinkedList<Mascota> listaAEscribir, String ArchivoDondeSeGuarda){
        ManipuladorListas manipuladorListas = new ManipuladorListas();
        EscribeCsv(manipuladorListas.MascotasAString(listaAEscribir),ArchivoDondeSeGuarda);
        return ArchivoDondeSeGuarda;
    }


}
