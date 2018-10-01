/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event;

/**
 *
 * @author star_man
 */
public class Period extends Time{
    
    private boolean is_set;
    
    public Period(int hour, int minute) {
        super(hour, minute);
        is_set = true;
    }

    public Period() {
        super();
        is_set = false;
    }

    /**
     * @return the is_set
     */
    public boolean isSet() {
        return is_set;
    }
    
}
