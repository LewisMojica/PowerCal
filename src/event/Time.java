package event;


/*
* the hour is in 24 format
 */
class Time {

    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toStringFormat24() {
        String out;    //this var will be return

        // convert the hour to String
        out = String.valueOf(hour) + ":" + String.valueOf(minute);
        return out;
    }

    public String toStringFormat12() {
        String out;     //this var will be return
        
            //conver the hour to String but in 12 hours format 
            if (hour > 12) {
                out = String.valueOf(hour - 12) + ":" + String.valueOf(minute) + " PM";
            } else{
                out = String.valueOf(hour) + ":" + String.valueOf(minute) + " AM";
            }
        
        return out;
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
