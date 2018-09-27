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

    static ArrayList<Integer> list = new ArrayList<>();
    static private Scanner in = new Scanner(System.in);
    static int selection;

    static void initMenu() {
        do {
            printMainMenu();
            selection = in.nextInt();
        } while (selection != 0);
    }

    static void printMainMenu() {
        System.out.print("Opciones principales: \n\n"
                + "-->  0. Salir\n"
                + "-->  1. Crear nuevo evento\n"
                + "-->  2. Ver evento\n"
                + "-->  3. Eliminar evento (no soportado)\n");
    }

    static void newEvent(String name, Hour hour, Day day, Period duration) {

        Event evento = new Event(name, hour, day, duration);
    }
}
