package event;

public class Date {

    private Time hour;
    private Day day;
    private boolean has_hour, has_day;

    /**
     *
     * @param hour> the time that the event starts
     * @param day> the date of when the event starts (dd,mm.yy)
     */
    public Date(Hour hour, Day day) {
        this.hour = hour;
        this.day = day;
        has_day = true;
        has_hour = true;
    }
    
    public Date(){
        has_day = false;
        has_hour = false;
    }
    
    public Date(Hour hour){
        this.hour = hour;
        has_day = false;
        has_hour = true;
    }
    
    public Date(Day day){
        this.day = day;
        has_day = true;
        has_hour = false;
    }

    public Time getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(Time hour) {
        this.hour = hour;
        has_hour = true;
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
        has_day = true;
    }

    /**
     * @return the has_hour
     */
    public boolean hasHour() {
        return has_hour;
    }

    /**
     * @return the has_day
     */
    public boolean hasDay() {
        return has_day;
    }
}
