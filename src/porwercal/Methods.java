/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package porwercal;

import java.util.Scanner;
import event.*;
import java.util.ArrayList;

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
            printMainMenu();
            System.out.print("> ");
            selection = Integer.parseInt(in.nextLine());
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
                        System.out.println("< " + selection + " > No es una opcion valida\n"
                                + "------------------------------");
                }
            }
        } while (selection != 0);
    }

    private static void printMainMenu() {
        System.out.print("Opciones principales: \n\n"
                + "-->  0. Salir\n"
                + "-->  1. Crear nuevo evento\n"
                + "-->  2. Ver evento\n"
                + "-->  3. Eliminar evento (no soportado)\n");
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
        System.out.print("Menu ver evento:\n\n"
                + "-->  0. Volver a menu principal\n"
                + "-->  1. Ver todos los eventos\n"
                + "-->  2. Ver evento especifico\n"
                + "> ");
        int selection = Integer.parseInt(in.nextLine());

        switch (selection) {
            case 0:
                break;
            case 1:
                menuSelection11();
                break;
            case 2:
                menuSelection12();
                break;
            default:
                System.out.println("< " + selection + " > No es una opcion valida\n"
                                + "------------------------------");
                break;
                

        }
    }

    private static void menuSelection3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void menuSelection11() {
        System.out.println("------------------------------");
        int i = 0;
        //imprimos todos los nombres de los eventos en una nueva linea, precesido por su posicion
        for(Event event: events_array){
            i++;
            System.out.println( i + "--> " + event.getName());
        }
        System.out.println("------------------------------");
    }

    private static void menuSelection12() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
}
