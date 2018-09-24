package porwercal;

import event.*;

public class PorwerCal {

    public static void main(String[] args) {
        Date fecha = new Date(new Hour(9, 30), new Day(4, 3, 2018), new Period(1, 45));
        
        System.out.println(fecha.getHour().toStringFormat12());
        System.out.println(fecha.getHour().toStringFormat24());
        
        System.out.println(fecha.getDuration().toStringFormat24());
        
        System.out.println(fecha.getDay().toString());
        
    }

}
