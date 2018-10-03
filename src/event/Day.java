/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package event;

import org.apache.commons.lang3.StringUtils;

public class Day {
    private boolean has_day = false, has_month = false, has_year = false;
    private int day,month,year;

    public Day(int day, int month, int year) {
        this.day = day;
        has_day = true;
        this.month = month;
        has_month = true;
        this.year = year;
        has_year = true;
    }
    
    public Day(){
    }
    
    
    public String toString(){
        return String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year);
    }
    
    public static boolean isDay(String input){
        if(StringUtils.countMatches(input, "/") == 2){
            String num = StringUtils.remove(input, "/");
            if(!(Integer.parseInt(num) == 0) && !StringUtils.isEmpty(num) && !StringUtils.isEmpty(input.substring(0, input.indexOf("/")))  && !StringUtils.isEmpty(input.substring(input.indexOf("/") + 1, input.lastIndexOf("/"))) && !StringUtils.isEmpty(input.substring(input.lastIndexOf("/")+1))){
                return true;
            }
            else return false;
        }
        else{
            return false;
        }
    }
    
    public boolean isSet(){
        return has_day && has_month && has_year;
    }

    /**
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
        has_day = true;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
        has_month = true;            
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
        has_year = true;
    }
    
}
