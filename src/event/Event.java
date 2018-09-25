package event;

public class Event extends Date {

    String name;
    Locale locale;

    public Event(String name, Hour hour, Day day, Period duration) {
        super(hour, day, duration);
        this.name = name;
    }

    public Event(String name, Hour hour, Day day, Period duration, Locale locale) {
        super(hour, day, duration);
        this.name = name;
        this.locale = locale;
    }

}
