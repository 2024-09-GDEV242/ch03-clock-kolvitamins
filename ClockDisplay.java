
/**
 * 12 hour internal branch 
 * 
 * The ClockDisplay class implements a digital clock display for an
 * American style 12 hour clock. The clock shows hours and minutes. 
 * 
 * The range of the clock is 00:00 (midnight) to 11:59 (one minute before 
 * midnight). In order to trach AM or PM we will need additional fields and 
 * logic to handle the switch in meridian.
 * 
 * The clock display receives "ticks" (via the timeTick method) every minute
 * and reacts by incrementing the display. This is done in the usual clock
 * fashion: the hour increments when the minutes roll over to zero.
 * 
 * @author Jeff Kolvites
 * @version 2024.09.17
 */
public class ClockDisplay
{
    private NumberDisplay hours;
    private NumberDisplay minutes;
    private String meridian;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ClockDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ClockDisplay()
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.meridian = meridian; 
        updateDisplay();
    }

    /**
     * Constructor for ClockDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ClockDisplay(int hour, int minute, String meridian)
    {
        hours = new NumberDisplay(12);
        minutes = new NumberDisplay(60);
        this.meridian = meridian; 
        setTime(hour, minute, meridian);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        minutes.increment();
        if(minutes.getValue() == 0) {  // it just rolled over!
            hours.increment();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int hour, int minute, String meridian)
    {
        hours.setValue(hour);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        int hour = hours.getValue();
        if (hour == 0)
        {
            hour = 12;
        }
        displayString = hour + ":" + 
                        minutes.getDisplayValue() + " " + meridian;
    }
}
