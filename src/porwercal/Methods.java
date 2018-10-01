package porwercal;

import java.util.Scanner;
import event.*;
import java.util.ArrayList;

class Methods {

    static private ArrayList<Event> events_array = new ArrayList<>(); //array dinamico en donde se guardan los eventos
    static private Scanner in = new Scanner(System.in);
    
    //menu principal
    static void initMenu() {
        int selection; //'selection' guarda la opcion que el usuarioa ha seleccionado
        do {// se imprime el menu principal
        System.out.print("Opciones principales: \n\n"
                + "-->  0. Salir\n"
                + "-->  1. Crear nuevo evento\n"
                + "-->  2. Ver evento\n"
                + "-->  3. Eliminar evento\n"
                + "> ");
            String input = in.nextLine(); //'input' almacena el texto que ha introducido el usuario
            while (!isNumeric(input) || input.isEmpty()) {                              //Si el texto de entrada contiene algun error
                System.out.println("***Ah introducido caracteres no validos.\n"         //*se imprime un mensaje de alerta,
                        + "Por favor, lea la lista de opciones y luego escoja una.");   //
                System.out.print("> ");                                                 //
                input = in.nextLine();                                                  //y se vuelve a solicitar al usuario que selecciones una opcion
            }

            selection = Integer.parseInt(input); /*luego de que arriba se comprobara que no hay 
                                                  *errores, convierte el texto de entrada a un entero,
                                                  *y se asigna ese entero a la variable 'selection'*/
            
            if (selection != 0) {//si el usuario no ha introducido un '0' (lo que significa salir)
                //se busca a cual opcion corresponde el numero que ha introducido el usuario
                switch (selection) {
                    case 1:
                        menuSelection1();
                        break;
                    case 2:
                        menuSelection2();
                        break;
                    case 3:
                        menuSelection3();
                        break;
                    default:
                        //si el numero que el usuario introdujo corresponde a ninguna opcion, se imprime mesaje de alerta y  se comienzar el bucle
                        System.out.println("\n*** < " + selection + " > No es una opcion valida\n");
                }
            }
        } while (selection != 0); //si el mensaje de entrada es '0', se sale de la funcion initMenu
    }


    //funcion de la opcion 1 -> crea nuevo evento
    private static void menuSelection1() {
        Date date;
        System.out.print("Ingrese el nombre del nuevo evento\n"//se pregunta por el nombre del evento
                + "> ");                                       //
        String name = in.nextLine().trim();                    //
        
        System.out.print("(pulse enter para dejar la hora sin asignar) Ingrese la hora del evento formato: <hora>:<minuto>\n"//se pregunta por la hora del evento
                + "> ");                                                        //
        String test = in.nextLine();                                            //
        
        while (!Time.isTime(test) && !test.equals("")){//mientras la "hora" introducida por el usuario contenga errores y el usuaro no haya pulsado enter
            System.out.print("Formato no permitido. Por favor, ingrese un formato valido:"//
                    + " <hora>:<minuto>, sin espacios en blanco\n"//se imprime
                    + "> ");                                      //un mensage de alerta,
            test = in.nextLine();                                 //y se pregunta nuevamente por una hora.
        }                                                         
        if(test.equals("")) {       //si el usuario ha pulsado enter,
            date = new Date();      //se crea objeto Date, pero sin asignar sus atributos
            System.out.println("\nLa hora no ha sido asignada\n");
        }
        else{date = new Date(stringToHour(test));}      //si no, cre crea nuevo objeto de tipo Date con sus atributos definidos

        System.out.print("(pulse enter para dejar la hora sin asignar) Ingrese la fecha del nuevo evento formato: <day>/<month>/<year>\n"//se pregunta por la fecha
                + "> ");
        test = in.nextLine();
        while (test.contains(" ")) {                   //mientras la fecha dada tenga errores, se imprime un mensaje de alerta, y se vuelve a
            System.out.print("Sin espacios en blanco\n"// preguntar por la fecha
                    + "> ");                           //
            test = in.nextLine();                      // 
        }
        date.setDay(stringToDay(test));//si no hay errores, se asigna el atributo Day al objeto Date

        System.out.print("(pulse enter para dejar la hora sin asignar) Ingrese la duracion del nuevo evento formato: <horas>:<minutos>\n" //se pregunta por la duracion del evento
                + "> ");                                                                     //
        test = in.nextLine();                                                                //
        
        while (!Time.isTime(test) && !test.equals("")){ //mientras la duracion dada por el usuario contenga errores, se imprime un mensaje de alerta
                                     //y se vuele a preguntar por la duracion
            System.out.print("Formato no permitido. Por favor, ingrese un formato valido: <hora>:<minuto>, sin espacios en blanco\n"//
                    + "> ");//
            test = in.nextLine();//
        }//
        
        Period duration;
        if (test.equals("")) {
            duration = new Period();
            System.out.println("\nLa duracion no ha sido asignada\n");
        } else {
            duration = stringToPeriod(test);//sin no hay errores, se crea el objeto de tipo Periodo
        }
        //se agrega el nuevo evento al array
        newEvent(name, date, duration);

        System.out.println("Evento < " + name + " > creado"); //se notifica de que el evento fue creado
    }
    
    //Opcion 2 --> visualizar eventos
    private static void menuSelection2() {
        int selection;
        do {                                                 //se imprimen las opciones
            System.out.print("Menu ver evento:\n\n"          //y se pregunta por la opcion
                    + "-->  0. Volver a menu principal\n"    //que se desea ejecutar
                    + "-->  1. Ver todos los eventos\n"      //
                    + "-->  2. Ver evento especifico\n"      //
                    + "> ");                                 //
            String input = in.nextLine();                   //
            
            while (!isNumeric(input) || input.isEmpty()) {                             //miestras la opcion dada contenga errores,
                System.out.println("***Ah introducido caracteres no validos.\n"        // se imprime mensaje de alerta,
                        + "Por favor, lea la lista de opciones y luego escoja una.");  //y se vuelve a preguntar por un numero de opcion
                System.out.print("> ");                                                //
                input = in.nextLine();                                                 //
            }                                                                          //

            selection = Integer.parseInt(input); //si no hay errores, se convierte el texto de entrada a un int

            switch (selection) { //se busta la opcion a la que corresponde el numero de entrada
                case 0:
                    break;
                case 1:
                    menuSelection21();
                    break;
                case 2:
                    menuSelection22();
                    break;
                default: //si la opcion no existe, se imprime un mensaje de error
                    System.out.println("< " + selection + " > No es una opcion valida\n"
                            + "------------------------------");
                    break;

            }
        } while (selection != 0); //si el texto de entrada es igual a '0' se sale hacia el menu principal
    }
    
    //opcion 3 --> eliminar 
    private static void menuSelection3() {
        System.out.print("Menu eliminar evento\n"
                + "Introduce el nombre del evento que deseas borrar\n"
                + "> ");
        String name = in.nextLine();
        boolean exit = false;
        while (getIndexEventByName(name) == -1 && !exit){ //mientras haya un error
            System.out.print("El evento < " + name + " > no existe/n"
                    + "Introducta un nombre validon o escrita < 0 > para salir al menu principal\n"
                    + "> ");
            name = in.nextLine();
            
            if (name.equals("0")) exit = true; //si el usuario desea salir
        }////
        if (!exit)removeEvent(getIndexEventByName(name)); //si el usuario no a dicho que quiere salir y el evento existe, se elimina el evento solicidado
        
    }

    // opcion 21 --> imprimir todod los eventos
    private static void menuSelection21() {
        System.out.println("------------------------------");
        int i = 0;
        //imprimos todos los nombres de los eventos en una nueva linea, precesido por su posicion
        for (Event event : events_array) {
            i++;
            System.out.println(i + "--> " + event.getName());
        }
        System.out.println("------------------------------");
    }
    
    //opcion 22 --> muestra informaciones especificas de un evento especifico
    private static void menuSelection22() {
        System.out.print("Ingresa el nombre del evento seguido de un '-' y la informacion que deseas visualizar\n"
                + "Ecribe <*help> para ver la diferentes informaciones que se pueden visualizar\n"
                + "> ");
        String input, event_name, event_info_requested;
        int tag_index; //porsicion del char '-' en el String input
        int index_event;
        do {
            input = in.nextLine();
            if (input.equals("*help")) {
                //se imprime informacion de ayuda de este menu especifico
                System.out.print("-n = nombre\n"
                        + "-h = hora\n"
                        + "-d = dia\n"
                        + "-p = duracion\n"
                        + "Puede hacer combinaciones, como: <nombre del evento> -hdp\n"
                        + "> ");
            }
        } while (input.equals("*help"));

        tag_index = input.indexOf("-"); //buscamos la posicion del char '_'

        event_name = input.substring(0, tag_index).trim(); //extraemos el nombre del evento y lo asignamos a su variable correspondiente

        event_info_requested = input.substring(tag_index + 1).trim();

        index_event = getIndexEventByName(event_name);

        System.out.println(event_name + " -- " + event_info_requested); //solo para probar que se recupero el nombre del evento y la info solicitada
        System.out.println(getEventInfo(events_array.get(index_event), event_info_requested));
    }

    //convierte un String del formato hora:minuto a un objeto de tipo Hour
    private static Hour stringToHour(String next) {
        int colon = next.indexOf(":"); // ubicar la posicion del char :
        int hour = Integer.parseInt(next.substring(0, colon)); //se guarda el valor numerico de las horas
        int minutes = Integer.parseInt(next.substring(colon + 1)); //se guarda el valor numerico de los minutos
        return new Hour(hour, minutes);

    }

    //convierte un String del formato horas:minutos  a un objeto de tipo Period
    private static Period stringToPeriod(String next) {
        int colon = next.indexOf(":"); // ubicar la posicion del char :
        int hour = Integer.parseInt(next.substring(0, colon)); //se guarda el valor numerico de las horas
        int minutes = Integer.parseInt(next.substring(colon + 1)); //se guarda el valor numerico de los minutos
        return new Period(hour, minutes);
    }

    //convierte un String del formato day/mes/year a un objeto de tipo Day
    private static Day stringToDay(String date) {
        int slash_1 = date.indexOf("/"); //ubicar la posicion de la primera ocurrencia del char '/'
        int slash_2 = date.indexOf("/", slash_1 + 1);//ubacar la posicion de la segunda ocurrencia del char '/'
        int day = Integer.parseInt(date.substring(0, slash_1));//asigna el dia a la variable Day
        int month = Integer.parseInt(date.substring(slash_1 + 1, slash_2));//asigna el mes a la variable month
        int year = Integer.parseInt(date.substring(slash_2 + 1));//so on
        return new Day(day, month, year);
    }

    //crea nuevo evento a partir de los atributos dados
    private static void newEvent(String name, Date date, Period duration) {
        Event evento = new Event(name, date, duration);
        events_array.add(evento);
    }
    
    //elimina evento a partir de index dado
    private static void removeEvent(int index){
        events_array.remove(index);
    }

    //retorna el index de un evento a partir de su nombre
    private static int getIndexEventByName(String name) {
        Event result;
        for (Event event : events_array) {
            if (event.getName().equalsIgnoreCase(name)) {
                return events_array.indexOf(event);
            }
        }
        return -1;
    }

    /*
    * esta funcion retorna cierta informacion sobre cierto evento
    * n = nombre
    * h = hora
    * d = dia
    * p = duracion
     */
    private static String getEventInfo(Event event, String event_info_requested) {
        String result = "";
        boolean n,h,d,p;
        boolean macth = false;
        if(event_info_requested.contains("n")){
            result = "nombre del evento --> " + event.getName() + "\n";
            macth = true;
        }
        if(event_info_requested.contains("h")){
            result += "hora del evento --> " + event.getDate().getHour().toStringFormat24() + "\n";
            macth = true;
        }
        if(event_info_requested.contains("d")){
            result += "fecha del evento --> " + event.getDate().getDay().toString() + "\n";
            macth = true;
        }
        if(event_info_requested.contains("p")){
            result += "duracion del evento --> " + event.getDuration().toStringFormat24();
            macth = true;
        }
        if(!macth)result = "**Opciones invalidas\n";
        return result;
    }
    
    private static boolean isNumeric(String test) {
        String numbers = "0123456789";
        for (int i = 0; i < test.length(); i++) {
            boolean wasNumeric = false;
            for (int e = 0; e < numbers.length(); e++) {
                if (test.charAt(i) == numbers.charAt(e)) {
                    wasNumeric = true;
                }
            }
            if (!wasNumeric) return false;
        }
        return true;
    }
}
