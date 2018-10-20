package event;

public class Event{

    private String name;
    private Date date;
    private Locale locale;
    private Period duration;

    public Event(String name, Hour hour, Day day, Period duration) {
        this.name = name;
        this.date = new Date(hour, day);
        this.duration = duration;
    }
    
    public Event(String name, Date date, Period duration) {
        this.name = name;
        this.date = date;
        this.duration = duration;
    }
    
    public Event(String name, Hour hour, Day day, Period duration, Locale locale) {
        this.name = name;
        this.date = new Date(hour, day);
        this.duration = duration;
        this.locale = locale;
    }
    
    public Event(String name,Date date, Period duration, Locale locale) {
        this.name = name;
        this.date = date;
        this.duration = duration;
        this.locale = locale;
    }
    
    public Event(String name){
        this.name = name;
        this.date = new Date();
    }
    public Event(){
        
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

    /**
     * @return the duration
     */
    public Period getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Period duration) {
        this.duration = duration;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
