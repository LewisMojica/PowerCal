package event;


/*
* the hour is in 24 format
*/
public class Hour {

    private int hour;
    private int minute;

    public Hour(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * @return the hour
     */
    public int getHour() {
        return hour;
    }

    /**
     * @param hour the hour to set
     */
    public void setHour(int hour) {
        this.hour = hour;
    }

    /**
     * @return the minute
     */
    public int getMinute() {
        return minute;
    }

    /**
     * @param minute the minute to set
     */
    public void setMinute(int minute) {
        this.minute = minute;
    }
}
