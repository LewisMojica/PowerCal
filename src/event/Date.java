package event;

public class Date {
    private Hour hour;
    private Day day;
    private Hour duration;
    private Locale locale;

    public Date(Hour hour, Day day, Hour duration, Locale locale) {
        this.hour = hour;
        this.day = day;
        this.duration = duration;
        this.locale = locale;
    }
    public Date(Hour hour, Day day, Hour duration) {
        this.hour = hour;
        this.day = day;
        this.duration = duration;
    }
    
    public Hour getHour(){
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(Hour hour) {
        this.hour = hour;
    }

    /**
     * @return the day
     */
    public Day getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(Day day) {
        this.day = day;
    }

    /**
     * @return the duration
     */
    public Hour getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Hour duration) {
        this.duration = duration;
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
