package event;


/*
* the hour is in 24 format
 */
public class Time {

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
    public static boolean isTime(String time){
        int colon_intex = time.indexOf(":");
        if (colon_intex == -1) return false;
        
        if(isNumeric(removeCharByIndex(time, colon_intex))){
            return true;
        }
        else{
            return false;
        }
    }

    private static String removeCharByIndex(String input, int index){
        String output = "";
        if (input.length() - 1 > index){
            return input.substring(0,index) + input.substring(index + 1);
        }
        else {
            return input.substring(0,index);
        }
    }

    private static boolean isNumeric(String test) {
        String numbers = "0123456789";
        for (int i = 0; i < test.length(); i++) {
            boolean wasNumeric = false;
            for (int e = 0; e < numbers.length(); e++) {
                if (test.charAt(i) == numbers.charAt(e)) {
                    wasNumeric = true;
                }
            }
            if (!wasNumeric) return false;
        }
        return true;
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