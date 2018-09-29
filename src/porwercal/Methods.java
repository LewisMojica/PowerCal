/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porwercal;

import java.util.Scanner;
import event.*;
import java.util.ArrayList;
import java.util.Objects;
import jdk.jfr.EventType;

/**
 *
 * @author star_man
 */
class Methods {

    static private ArrayList<Event> events_array = new ArrayList<>();
    static private Scanner in = new Scanner(System.in);

    static void initMenu() {
        int selection;
        do {
        System.out.print("Opciones principales: \n\n"
                + "-->  0. Salir\n"
                + "-->  1. Crear nuevo evento\n"
                + "-->  2. Ver evento\n"
                + "-->  3. Eliminar evento (no soportado)\n"
                + "> ");
            String test_err = in.nextLine();
            while (!isNumeric(test_err) || test_err.isEmpty()) {
                System.out.println("***Ah introducido caracteres no validos.\n"
                        + "Por favor, lea la lista de opciones y luego escoja una.");
                System.out.print("> ");
                test_err = in.nextLine();
            }

            selection = Integer.parseInt(test_err);

            if (selection != 0) {
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
                        System.out.println("\n*** < " + selection + " > No es una opcion valida\n");
                }
            }
        } while (selection != 0);
    }



    private static void menuSelection1() {
        System.out.print("Ingrese el nombre del nuevo evento\n"
                + "> ");
        String name = in.nextLine().trim();

        System.out.print("Ingrese la hora del evento formato: <hora>:<minuto>\n"
                + "> ");
        String test = in.nextLine();
        while (test.indexOf(" ") != -1) {
            System.out.print("Sin espacios en blanco\n"
                    + "> ");
            test = in.nextLine();
        }
        Hour hour = stringToHour(test);

        System.out.print("Ingrese la fecha del nuevo evento formato: <day>/<month>/<year>\n"
                + "> ");
        test = in.nextLine();
        while (test.indexOf(" ") != -1) {
            System.out.print("Sin espacios en blanco\n"
                    + "> ");
            test = in.nextLine();
        }
        Day day = stringToDay(test);

        System.out.print("Ingrese la duracion del nuevo evento formato: <horas>:<minutos>\n"
                + "> ");
        test = in.nextLine();
        while (test.indexOf(" ") != -1) {
            System.out.print("Sin espacios en blanco\n"
                    + "--> ");
            test = in.nextLine();
        }
        Period duration = stringToPeriod(test);

        //se agrega el nuevo evento al array
        newEvent(name, hour, day, duration);

        System.out.println("Evento < " + name + " >creado");

    }

    private static void menuSelection2() {
        int selection;
        do {
            System.out.print("Menu ver evento:\n\n"
                    + "-->  0. Volver a menu principal\n"
                    + "-->  1. Ver todos los eventos\n"
                    + "-->  2. Ver evento especifico\n"
                    + "> ");
            String test_err = in.nextLine();
            while (!isNumeric(test_err) || test_err.isEmpty()) {
                System.out.println("***Ah introducido caracteres no validos.\n"
                        + "Por favor, lea la lista de opciones y luego escoja una.");
                System.out.print("> ");
                test_err = in.nextLine();
            }

            selection = Integer.parseInt(test_err);

            switch (selection) {
                case 0:
                    break;
                case 1:
                    menuSelection21();
                    break;
                case 2:
                    menuSelection22();
                    break;
                default:
                    System.out.println("< " + selection + " > No es una opcion valida\n"
                            + "------------------------------");
                    break;

            }
        } while (selection != 0);
    }

    private static void menuSelection3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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

    private static void menuSelection22() {
        System.out.print("Ingresa el nombre del evento seguido de un '-' y la informacion que deseas visualizar\n"
                + "Ecribe <*help> para ver la diferentes informaciones que se pueden visualizar\n"
                + "> ");
        String input, event_name, event_info_requested;
        int tag_index; //porsicion del char '-' en el String input
        int index_event;
        do {
            input = in.nextLine();
            if (input.equals("*help")){
                //se imprime informacion de ayuda de este menu especifico
                System.out.print("> ");
            }
        } while (input.equals("*help"));

        tag_index = input.indexOf("-"); //buscamos la posicion del char '_'

        event_name = input.substring(0, tag_index).trim(); //extraemos el nombre del evento y lo asignamos a su variable correspondiente

        event_info_requested = input.substring(tag_index + 1).trim();

        index_event = getIndexEventByName(event_name);

        System.out.println(event_name + " -- " + event_info_requested); //solo para probar que se recupero el nombre del evento y la info solicitada
        System.out.print(getEventInfo(events_array.get(index_event), event_info_requested));
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
    private static Day stringToDay(String next) {
        int slash_1 = next.indexOf("/"); //ubacar la posicion de la primera ocurrencia del char '/'
        int slash_2 = next.indexOf("/", slash_1 + 1);//ubacar la posicion de la segunda ocurrencia del char '/'
        int day = Integer.parseInt(next.substring(0, slash_1));//asigna el dia a la variable Day
        int month = Integer.parseInt(next.substring(slash_1 + 1, slash_2));//asigna el mes a la variable month
        int year = Integer.parseInt(next.substring(slash_2 + 1));//so on
        return new Day(day, month, year);
    }

    private static void newEvent(String name, Hour hour, Day day, Period duration) {

        Event evento = new Event(name, hour, day, duration);
        events_array.add(evento);
    }

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
    private static String getEventInfo(Event get, String event_info_requested) {
        String result = "";
        boolean n,h,d,p;
        if(event_info_requested.contains("n")){
            result = "nombre del evento --> " + get.getName() + "\n";
        }
        if(event_info_requested.contains("h")){
            result += "hora del evento --> " + get.getHour().toStringFormat24() + "\n";
        }
        if(event_info_requested.contains("d")){
            result += "fecha del evento --> " + get.getDay().toString() + "\n";
        }
        if(event_info_requested.contains("p")){
            result += "duracion del evento --> " + get.getDuration().toStringFormat24() + "\n";
        }
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
