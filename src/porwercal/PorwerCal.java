package porwercal;

import event.*;

public class PorwerCal {

    public static void main(String[] args) {
        Date fecha = new Date(new Hour(30, 34), new Day(4, 3, 2018), new Hour(1, 0));
        
        System.out.println(fecha.getHour().toStringFormat12());
        System.out.println(fecha.getHour().toStringFormat24());
    }

}
