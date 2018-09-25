package event;

public class Date {

    private Time hour;
    private Day day;
    private Time duration;
    private Locale locale;

    /**
     *
     * @param hour> the time that the event starts
     * @param day> the date of when the event starts (dd,mm.yy)
     * @param duration> Duration of the events in hours and days
     * @param locale> location of the event
     */
    public Date(Hour hour, Day day, Period duration) {
        this.hour = hour;
        this.day = day;
        this.duration = duration;
    }

    public Time getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(Time hour) {
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
    public Time getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Time duration) {
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
