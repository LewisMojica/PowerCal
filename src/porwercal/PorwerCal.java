package porwercal;

import event.Day;
import event.Event;
import event.Hour;
import event.Period;
import static porwercal.Methods.*;

public class PorwerCal {

    public static void main(String[] args) {
        Event evento = new Event("Math class", new Hour(9, 30), new Day(4, 3, 2018), new Period(1, 45));

        printMainMenu();

    }

}
