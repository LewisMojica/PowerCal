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

    static ArrayList<Event> events_array = new ArrayList<>();
    static private Scanner in = new Scanner(System.in);
    static int selection;

    static void initMenu() {
        do {
            printMainMenu();
            selection = in.nextInt();
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

    static void printMainMenu() {
        System.out.print("Opciones principales: \n\n"
                + "-->  0. Salir\n"
                + "-->  1. Crear nuevo evento\n"
                + "-->  2. Ver evento\n"
                + "-->  3. Eliminar evento (no soportado)\n");
    }

    

    private static void menuSelection1() {
        System.out.print("Ingrese el nombre del nuevo evento\n"
                + "> ");
        String name = in.next();

        System.out.print("Ingrese la hora del evento formato: <hora>:<minuto>\n"
                + "> ");
        Hour hour = stringToHour(in.next());

        System.out.print("Ingrese la fecha del nuevo evento formato: <day>/<month>/<year>\n"
                + "> ");
        Day day = stringToDay(in.next());

        System.out.print("Ingrese la duracion del nuevo evento formato: <horas>:<minutos>\n"
                + "> ");
        Period duration = stringToPeriod(in.next());
        
        //se agraga el nuevo evento al array
        newEvent(name, hour, day, duration);
        
        System.out.println("Evento < " + name + " >creado");

    }
    
    static void newEvent(String name, Hour hour, Day day, Period duration) {

        Event evento = new Event(name, hour, day, duration);
        events_array.add(evento);
    }

    private static void menuSelection2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void menuSelection3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //convierte un String del formato hora:minuto a un objeto de tipo Hour
    private static Hour stringToHour(String next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //convierte un String del formato horas:minutos  a un objeto de tipo Period
    private static Period stringToPeriod(String next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //convierte un String del formato day/mes/year a un objeto de tipo Day
    private static Day stringToDay(String next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
