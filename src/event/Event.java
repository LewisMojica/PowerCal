package event;

public class Event extends Date {

    String name;
    Locale locale;
    Period duration;

    public Event(String name, Hour hour, Day day, Period duration) {
        super(hour, day);
        this.name = name;
        this.duration = duration;
    }

    public Event(String name, Hour hour, Day day, Period duration, Locale locale) {
        super(hour, day);
        this.name = name;
        this.duration = duration;
        this.locale = locale;
    }

}
