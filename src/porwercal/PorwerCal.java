package porwercal;

import static porwercal.Methods.*;
import java.util.ArrayList;
import java.util.Scanner;

public class PorwerCal {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int i;
        do {
            System.out.println("Ingrese el nuevo Integer");
            i = in.nextInt();
            if (i != 0 && i != 42) {
                addItem(i);
            }
            System.out.println("Hay" + list.size());
        } while (i != 0 && i != 42);
        if (i == 42) {
            for (int e = list.size(); e != 0; e--) {
                System.out.println("Objeto no. " + (-1 + e) + " es igual a >> " + list.get(e - 1));
            }
        }
    }

    private static void addItem(Integer i) {
        list.add(i);
    }

}
