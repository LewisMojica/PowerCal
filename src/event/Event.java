package event;

public class Event extends Date {

    private String name;
    private Locale locale;
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

    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
