package SRC;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Clase que crea un menu
 * @author Luis Emilio Gonzalez Covarrubias
 * @author Luis Mario Escobar Rosales
 * @author Melissa Vazquez Gonzalez
 * @author Genaro de Jesus Miranda Martinez
 * @author Maria del Sol Silva Hernandez
 * @version 23/03/2022
 */
public class Menu {
    String ArchivoPersonas;
    String ArchivoMascotas;
    String ArchivoVeterinarias;
    ManipuladorCSV manipuladorCSV;
    ManipuladorListas manipuladorListas;
    Validacion validacion;
    Scanner scanner;
    Scanner scanner2;
    Scanner scanner3;
    int contador1;

    /**
     * Constructor de el Menu
     */
    public Menu() {
        String Path = "SRC/";
//        String Path = "";
        ArchivoMascotas =Path+"Mascotas.csv";
        ArchivoPersonas = Path+"Personas.csv";
        ArchivoVeterinarias =Path+ "Veterinarias.csv";
        manipuladorCSV = new ManipuladorCSV();
        manipuladorListas = new ManipuladorListas();
        scanner = new Scanner(System.in);
        scanner2 = new Scanner(System.in);
        validacion = new Validacion();
        contador1=0;
    }

    /**
     * Crea el menu, es recursivo controlando excepciones para no dejar caer el programa
     */
    public void menu(){
        try{
            if(contador1>0){
                System.out.println("Abriendo Menu... Si tarda presione enter hasta abrir");
                String entrada2 = scanner.nextLine();
            }

            int entrada=0;
            int seleccion =0;
            String instancia="";
            int indice=0;
            LinkedList lista;
            try{
            System.out.println("Ah continuacion se le presentara el menu: \n" +
                    "Teclee la opcion de su preferencia: \n" +
                    "1.- Visualizar \n" +
                    "2.- Modificar \n" +
                    "3.- Agregar \n" +
                    "4.- Eliminar \n" +
                    "5.-Salir"
            );
                entrada = scanner.nextInt();


            }catch(Exception i){
                System.out.println("Usted no ha introducido un entero\n" +
                        "Sera redirigido al menu");
                contador1++;
//                System.exit(0);
                menu();
            }
            if(entrada>5||entrada<1){
                System.out.println("El Entero que introdujo no esta en rango, favor de introducir uno entre 1 y 4 \n"
                        + "Porfavor lee las instrucciones");
                menu();
            }
            switch (entrada){
                case 1:
                    lista =menuEntidades("Visualizar");
                    instancia = Visualizar(lista);
                    menu();
                    break;
                case 2:
                    lista =menuEntidades("Modificar");
                    instancia = Visualizar(lista);
                    indice = Seleccion();
                    switch (instancia){
                        case "Persona":
                            lista = ModificarPersonas(lista,indice);
                            manipuladorCSV.EscribeCsv(manipuladorListas.PersonasAString(lista),ArchivoPersonas);
                            break;
                        case "Mascota":
                            lista = ModificarMascotas(lista,indice);

                            manipuladorCSV.EscribeCsv(manipuladorListas.MascotasAString(lista),ArchivoMascotas);
                            break;
                        case "Veterinaria":
                            lista = ModificarVeterinarias(lista,indice);

                            manipuladorCSV.EscribeCsv(manipuladorListas.VeterinariasAString(lista),ArchivoVeterinarias);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            menu();
                            break;
                    }
                    menu();
                    break;
                case 3:
                    lista =menuEntidades("Agregar");
                    instancia = Visualizar(lista);
                    switch (instancia){
                        case "Persona":
                            System.out.println("Agregue los datos de su dueño a continuacion:");
                            lista =AgregarPersona(lista);
                            manipuladorCSV.EscribeCsv(manipuladorListas.PersonasAString(lista),ArchivoPersonas);
                            break;
                        case "Mascota":
                            lista = AgregarMascota(lista);
                            manipuladorCSV.EscribeCsv(manipuladorListas.MascotasAString(lista),ArchivoMascotas);
                            break;
                        case "Veterinaria":
                            lista = AgregaVeterinaria(lista);
                            manipuladorCSV.EscribeCsv(manipuladorListas.VeterinariasAString(lista),ArchivoVeterinarias);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            menu();
                            break;
                    }
                    menu();

                    break;
                case 4:
                    lista =menuEntidades("Eliminar");
                    instancia = Visualizar(lista);
                    indice = Seleccion();
                    switch (instancia){
                        case "Persona":
                            lista.remove(indice);
                            manipuladorCSV.EscribeCsv(manipuladorListas.PersonasAString(lista),ArchivoPersonas);
                            break;
                        case "Mascota":
                            lista.remove(indice);
                            manipuladorCSV.EscribeCsv(manipuladorListas.MascotasAString(lista),ArchivoMascotas);
                            break;
                        case "Veterinaria":
                            lista.remove(indice);
                            manipuladorCSV.EscribeCsv(manipuladorListas.VeterinariasAString(lista),ArchivoVeterinarias);
                            break;
                        default:
                            System.out.println("Opcion no valida");
                            menu();
                            break;
                    }
                    menu();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("El Entero que introdujo no esta en rango, favor de introducir uno entre 1 y 4 \n"
                            + "Porfavor lee las instrucciones");
                    menu();
                    break;
            }
        }catch(Exception e){
            System.out.println("La seleccion es invalida, regresando al menu");
            menu();
        }


    }

    /**
     * menuEntidades Genera el menu de las entidades utiliza recursion y control de excepciones
     * Permite elegir la entidad sobre la cual queremos explorar
     * @param seleccion -- La seleccion de la entidad que se eligio
     * @return LinkedList con las entidades para manipularlas
     */
    public LinkedList menuEntidades(String seleccion){

            Scanner scanner = new Scanner(System.in);
             int entrada=0;
            System.out.println("Sobre cual de las opcion quiere: "+seleccion+"\n"+
                    "1.-Dueños\n"+ "2.-Mascotas\n"+"3.-Veterinarias");
        try{
            entrada = scanner.nextInt();
        }catch(java.util.InputMismatchException i){
            System.out.println("Usted no ha introducido un entero\n" +
                    "Sera redirigido al menu");
            menuEntidades(seleccion);
        }
        if(entrada>4||entrada<1){
            System.out.println("El Entero que introdujo no esta en rango, favor de introducir uno entre 1 y 3 \n"
                    + "Porfavor lee las instrucciones");
            menuEntidades(seleccion);
        }
        try{
            switch (entrada){
                case 1:
                    LinkedList<Persona> listaPersona=manipuladorListas.LeePersonas(manipuladorCSV.LeeArchivoCsv(ArchivoPersonas));
                    return listaPersona;
                case 2:
                    LinkedList<Mascota> listaMascota=manipuladorListas.LeeMascota(manipuladorCSV.LeeArchivoCsv(ArchivoMascotas));
                    return listaMascota;
                case 3:
                    LinkedList<Veterinaria> listaVeterinaria=manipuladorListas.LeeVeterinaria(manipuladorCSV.LeeArchivoCsv(ArchivoVeterinarias));
                    return listaVeterinaria;
                case 4:
                    System.out.println("Usted Regresara al menu");
                    menu();
                    break;
                default:
                    System.out.println("Selecciono una opcion invalida, regresara al menu");
                    menu();
                    break;
            }
        }catch(ParseException e){
            System.out.println("No se pudo completar la operacion");
            menu();
        }

        return null;
    }

    /**
     * getInstanceof Obtiene la instancia a la que pertenecen los elementos de una lista
     * @param lista -- lista a probar para buscar a que entidad pertenecen sus elementos
     * @return String con el nombre de la clase a la que pertenecen sus elementos de la lista
     */
    public String getInstanceof(LinkedList lista){
        String cad="";
        Persona persona= new Persona();
        Mascota mascota = new Mascota();
        Veterinaria veterinaria = new Veterinaria();
        try{
            persona = (Persona)lista.getFirst();
            cad = "Persona";
        }catch(Exception e){
            try{
                mascota = (Mascota)lista.getFirst();
                cad = "Mascota";
            }catch(Exception i){
                try{
                    veterinaria = (Veterinaria) lista.getFirst();
                    cad = "Veterinaria";
                }catch(Exception o){
                    System.out.println("No es un objeto valido");
                }
            }
        }
        return cad;
    }

    /**
     * Visualizar Imprime en pantalla todos los elementos de una lista de Personas, Veterinarias, mascotas
     * @param lista -- lista con las entidades que queremos visualizar
     * @return String con la clase de las entidades visualizadas usando getinstanceof
     */
    public String Visualizar(LinkedList lista){
        String instancia = getInstanceof(lista);
        int contador =0;
        System.out.println("Ha continuacion se mostrara las " + instancia + "s");
        System.out.println(" ");
        switch (instancia){
            case "Persona":
                for (Persona persona:(LinkedList<Persona>)lista){
                    System.out.println(contador + ": " + persona.toString());
                    contador++;
                }
                break;
            case "Mascota":
                for (Mascota mascota:(LinkedList<Mascota>)lista){
                    System.out.println(contador + ": " + mascota.toString());
                    contador++;
                }
                break;
            case "Veterinaria":
                for (Veterinaria veterinaria:(LinkedList<Veterinaria>)lista){
                    System.out.println(contador + ": " + veterinaria.toString());
                    contador++;
                }
                break;
        }
        return instancia;
    }

    /**
     * Seleccion Lee de teclado la seleccion en menu de numeros
     * @return int con la seleccion
     */
    public int Seleccion(){
        System.out.println("Seleccione una de las opciones anteriores, eligiendo su indice:");
        int entrada;
        try{
            entrada = scanner.nextInt();
        }catch(Exception e){
            System.out.println("La opcion elegida es invalida, intente denuevo:");
            entrada =Seleccion();
        }
        return entrada;
    }

    /**
     * ModificarPersonas este metodo permite modificar los datos de una persona
     * @param lista -- la lista con las personas a modificar
     * @param indice -- el indice de la persona que se desea modificar
     * @return LinkedList con las personas modificadas
     */
    public LinkedList ModificarPersonas(LinkedList lista, int indice){
        LinkedList<Persona>listaPersonas = (LinkedList<Persona>) lista;
        int elegir=0;
        String entrada;
        System.out.println("Selecciona el atributo a modificar:");
        System.out.println("1.-Regresar al menu \n" +
                "2.-Nombres\n" +
                "3.-ApellidoPaterno\n" +
                "4.-ApellidoMaterno\n" +
                "5.-CURP\n" +
                "6.-direccion\n" +
                "7.-telefono\n" +
                "8.-FechaNacimiento\n" +
                "9.-email\n" +
                "Introduzca su seleccion: ");
        try{
            elegir = scanner.nextInt();
            switch (elegir){
                case 1:
                    return listaPersonas;
                case 2:
                    System.out.println("Introduce el(los) Nombre(s):");
                    entrada = scanner2.nextLine();
                    if(!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setNombres(entrada);
                    break;
                case 3:
                    System.out.println("Introduce el Apellido Paterno:");
                    entrada = scanner2.nextLine();
                    if(!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setApellidoPaterno(entrada);
                    break;
                case 4:
                    System.out.println("Introduce el Apellido Materno:");
                    entrada = scanner2.nextLine();
                    if(!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setApellidoMaterno(entrada);
                    break;
                case 5:
                    System.out.println("Introduce el CURP:");
                    entrada = scanner2.nextLine();
                    if (entrada ==null){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setCURP(entrada);
                    break;
                case 6:
                    System.out.println("Introduce el estado:");
                    entrada = scanner2.nextLine();
                    Direccion direccion = new Direccion();
                    direccion.setEstado(entrada);
                    System.out.println("Introduce la calle:");
                    entrada = scanner2.nextLine();
                    direccion.setCalle(entrada);
                    System.out.println("Introduce el numero:");
                    entrada = scanner2.nextLine();
                    direccion.setNumero(entrada);
                    System.out.println("Introduce el codigo postal:");
                    entrada = scanner2.nextLine();
                    direccion.setCodigoPostal(entrada);
                    if(direccion==null){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setDireccion(direccion);
                    break;
                case 7:
                    System.out.println("Introduce el Telefono:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionTelefono(entrada)){
                        throw new NullPointerException();
                    }
                    listaPersonas.get(indice).setTelefono(entrada);
                    break;
                case 8:
                    System.out.println("Introduce la fecha de nacimiento:");
                    entrada = scanner2.nextLine();
                    if (entrada==null) {
                        throw new NullPointerException();

                    }
                    listaPersonas.get(indice).setFechaNacimiento(entrada);

                    break;
                case 9:
                    System.out.println("Introduce el Email:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionEmail(entrada)){
                    throw new NullPointerException();
                }
                    listaPersonas.get(indice).setEmail(entrada);
                    break;
            }
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return ModificarPersonas(listaPersonas,indice);


    }
    /**
     * ModificarMascotas este metodo permite modificar los datos de una mascota
     * @param lista -- la lista con las mascotas a modificar
     * @param indice -- el indice de la mascota que se desea modificar
     * @return LinkedList con las mascotas modificadas
     */
    public LinkedList ModificarMascotas(LinkedList lista, int indice){

        LinkedList<Mascota>listaMascotas = (LinkedList<Mascota>) lista;
        int elegir=0;
        String entrada;
        System.out.println("Selecciona el atributo a modificar:");
        System.out.println("1.-Regresar al menu \n" +
                "2.-Nombre\n" +
                "3.-Peso\n" +
                "4.-edad\n" +
                "5.-Fecha de Nacimiento\n" +
                "6.-raza\n" +
                "7.-IdDueño\n" +
                "Introduzca su seleccion: ");
        try{
            elegir = scanner.nextInt();
            switch (elegir){
                case 1:
                    return listaMascotas;
                case 2:
                    System.out.println("Introduce el Nombre:");
                    entrada = scanner2.nextLine();
                    if(!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setNombre(entrada);
                    break;
                case 3:
                    System.out.println("Introduce el peso:");
                    entrada = scanner2.nextLine();
                    if(entrada==null){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setPeso(entrada);
                    break;
                case 4:
                    System.out.println("Introduce la edad:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionEdad(entrada)){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setEdad(entrada);
                    break;
                case 5:
                    System.out.println("Introduce la fecha de nacimiento:");
                    entrada = scanner2.nextLine();
                    if(entrada ==null){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setFechaNacimiento(entrada);
                    break;
                case 6:
                    System.out.println("Introduce la raza:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setRaza(entrada);
                    break;
                case 7:
                    System.out.println("Introduce el id del dueño:");
                    entrada = scanner2.nextLine();
                    if(entrada==null){
                        throw new NullPointerException();
                    }
                    listaMascotas.get(indice).setIdPersona(entrada);
                    break;
            }
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return ModificarPersonas(listaMascotas,indice);

    }
    /**
     * ModificarVeterinarias este metodo permite modificar los datos de una Veterinaria
     * @param lista -- la lista con las Veterinarias a modificar
     * @param indice -- el indice de la Veterinarias que se desea modificar
     * @return LinkedList con las Veterinarias modificadas
     */
    public LinkedList ModificarVeterinarias(LinkedList lista, int indice){

        LinkedList<Veterinaria>listaVeterinarias = (LinkedList<Veterinaria>) lista;
        int elegir=0;
        String entrada;
        System.out.println("Selecciona el atributo a modificar:");
        System.out.println("1.-Regresar al menu \n" +
                "2.-Nombre\n" +
                "3.-Consultorios\n" +
                "4.-Apartado\n" +
                "5.-Telefono\n" +
                "6.-Direccion\n" +
                "7.-Horario\n" +
                "Introduzca su seleccion: ");
        try{
            elegir = scanner.nextInt();
            switch (elegir){
                case 1:
                    return listaVeterinarias;
                case 2:
                    System.out.println("Introduce el Nombre:");
                    entrada = scanner2.nextLine();
                    if(!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaVeterinarias.get(indice).setNombres(entrada);
                    break;
                case 3:
                    System.out.println("Introduce el numero de consultorios:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionConsultorios(entrada)){
                        throw new NullPointerException();
                    }
                    listaVeterinarias.get(indice).setConsultorio(entrada);
                    break;
                case 4:
                    System.out.println("Introduce el nombre del apartado:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionNombre(entrada)){
                        throw new NullPointerException();
                    }
                    listaVeterinarias.get(indice).setApartado(entrada);
                    break;
                case 5:
                    System.out.println("Introduce el telefono:");
                    entrada = scanner2.nextLine();
                    if (!validacion.ValidacionTelefono(entrada)){
                        throw new NullPointerException();
                    }
                        listaVeterinarias.get(indice).setTelefono(entrada);
                    break;
                case 6:
                    System.out.println("Introduce el estado:");

                    entrada = scanner2.nextLine();
                    Direccion direccion = new Direccion();
                    direccion.setEstado(entrada);
                    System.out.println("Introduce la calle:");
                    entrada = scanner2.nextLine();
                    direccion.setCalle(entrada);
                    System.out.println("Introduce el numero:");
                    entrada = scanner2.nextLine();
                    direccion.setNumero(entrada);
                    System.out.println("Introduce el codigo postal:");
                    entrada = scanner2.nextLine();
                    direccion.setCodigoPostal(entrada);
                    if (direccion==null){
                        throw new NullPointerException();
                    }
                    listaVeterinarias.get(indice).setDireccion(direccion);
                    break;
                case 7:
                    System.out.println("Introduce el Horario de inicio:");
                    Horario horario = new Horario();
                    entrada = scanner2.nextLine();
                    if(entrada==null){
                        throw new NullPointerException();
                    }
                    horario.setHoraInicio(entrada);
                    System.out.println("Introduce el Horario de Termino:");
                    entrada = scanner2.nextLine();
                    if(entrada==null){
                        throw new NullPointerException();
                    }
                    horario.setHoraInicio(entrada);
                    listaVeterinarias.get(indice).setHorario(horario);
                    break;
            }
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return ModificarPersonas(listaVeterinarias,indice);

    }

    /**
     * AgregarPersonas metodo que permite agregar una persona a la base de datos
     * @param lista -- Lista con las personas a las cuales queremos agregar la nueva persona
     * @return LinkedList con la nueva persona
     */
    public LinkedList AgregarPersona(LinkedList lista){
        int tam = lista.size();
        LinkedList<Persona> listaPersonas = (LinkedList<Persona>)lista;
        String entrada;
        Persona persona = new Persona();
        String id = "0"+ tam;
        persona.setId(id);
        try{
                    System.out.println("Introduce el(los) Nombre(s):");
                    entrada = scanner2.nextLine();
                    persona.setNombres(entrada);
                    System.out.println("Introduce el Apellido Paterno:");
                    entrada = scanner2.nextLine();
                    persona.setApellidoPaterno(entrada);
                    System.out.println("Introduce el Apellido Materno:");
                    entrada =scanner2.nextLine();
                    persona.setApellidoMaterno(entrada);
                    System.out.println("Introduce el CURP:");
                    entrada = scanner2.nextLine();
                    persona.setCURP(entrada);
                    System.out.println("Introduce el estado:");
                    entrada = scanner2.nextLine();
                    Direccion direccion = new Direccion();
                    direccion.setEstado(entrada);
                    System.out.println("Introduce la calle:");
                    entrada = scanner2.nextLine();
                    direccion.setCalle(entrada);
                    System.out.println("Introduce el numero:");
                    entrada = scanner2.nextLine();
                    direccion.setNumero(entrada);
                    System.out.println("Introduce el codigo postal:");
                    entrada = scanner2.nextLine();
                    direccion.setCodigoPostal(entrada);
                    persona.setDireccion(direccion);
                    System.out.println("Introduce el Telefono:");
                    entrada = scanner2.nextLine();
                    persona.setTelefono(entrada);
                    System.out.println("Introduce la fecha de nacimiento:");
                    entrada = scanner2.nextLine();
                    persona.setFechaNacimiento(entrada);
                    System.out.println("Introduce el Email:");
                    entrada = scanner2.nextLine();
                    persona.setEmail(entrada);
                    if (!validacion.ValidacionPersona(persona)){
                        throw new NullPointerException();
                    }
                    listaPersonas.add(persona);
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return listaPersonas;
    }
    /**
     * AgregarMascota metodo que permite agregar una persona a la base de datos
     * @param lista -- Lista con las mascotas a las cuales queremos agregar la nueva mascotas
     * @return LinkedList con la nueva mascotas
     */
    public LinkedList AgregarMascota(LinkedList lista){
        int tam = lista.size();
        LinkedList<Mascota> listaMascotas = (LinkedList<Mascota>)lista;
        String entrada;
        Mascota mascota = new Mascota();
        try{
            System.out.println("Introduce el Nombre:");
            entrada = scanner2.nextLine();
            mascota.setNombre(entrada);
            System.out.println("Introduce el Peso:");
            entrada = scanner2.nextLine();
            mascota.setPeso(entrada);
            System.out.println("Introduce la edad:");
            entrada =scanner2.nextLine();
            mascota.setEdad(entrada);
            System.out.println("Introduce la fecha de nacimiento:");
            entrada = scanner2.nextLine();
            mascota.setFechaNacimiento(entrada);
            System.out.println("Introduce la raza:");
            entrada = scanner2.nextLine();
            mascota.setRaza(entrada);
            System.out.println("Introduce el id de la persona:");
            entrada = scanner2.nextLine();
            mascota.setIdPersona(entrada);
            if(!validacion.ValidacionMascota(mascota)){
                throw new NullPointerException();
            }
            listaMascotas.add(mascota);
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return listaMascotas;
    }
    /**
     * AgregarVeterinaria metodo que permite agregar una persona a la base de datos
     * @param lista -- Lista con las veterinarias a las cuales queremos agregar la nueva veterinaria
     * @return LinkedList con la nueva veterinaria
     */
    public LinkedList AgregaVeterinaria(LinkedList lista){
        int tam = lista.size();
        LinkedList<Veterinaria> listaVeterinaria = (LinkedList<Veterinaria>)lista;
        String entrada;
        Veterinaria veterinaria =  new Veterinaria();

        try{
            System.out.println("Introduce el Nombre:");
            entrada = scanner2.nextLine();
            veterinaria.setNombres(entrada);
            System.out.println("Introduce el numero de Consultorios:");
            entrada = scanner2.nextLine();
            veterinaria.setConsultorio(entrada);
            System.out.println("Introduce el nombre del aparatado:");
            entrada =scanner2.nextLine();
            veterinaria.setApartado(entrada);
            System.out.println("Introduce el Telefono:");
            entrada = scanner2.nextLine();
            veterinaria.setTelefono(entrada);
            System.out.println("Introduce el estado:");
            entrada = scanner2.nextLine();
            Direccion direccion = new Direccion();
            direccion.setEstado(entrada);
            System.out.println("Introduce la calle:");
            entrada = scanner2.nextLine();
            direccion.setCalle(entrada);
            System.out.println("Introduce el numero:");
            entrada = scanner2.nextLine();
            direccion.setNumero(entrada);
            System.out.println("Introduce el codigo postal:");
            entrada = scanner2.nextLine();
            direccion.setCodigoPostal(entrada);
            veterinaria.setDireccion(direccion);
            if(!validacion.ValidacionVeterinaria(veterinaria)){
                throw new NullPointerException();
            }
            listaVeterinaria.add(veterinaria);
        }catch(Exception e){
            System.out.println("Su eleccion es invalida, regresando al menu");
            menu();
        }
        return listaVeterinaria;
    }
}
