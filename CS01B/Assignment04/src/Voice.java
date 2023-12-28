/**
 * @version 1.0 8-06-2020
 * @author Andrew Li
 * <br>
 * Purpose: Voice class is a type of Chargeable that only contains data specific to a voice message. <br>
 * Also contains a toString() and equals() method that formats and compares the duration and format instance <br>
 * fields respectively. <br>
 * <br>
 * Revision History: <br>
 * Date: 8-06-2020 <br>
 * Programmer: Andrew Li
 */
public class Voice implements Chargeable
{
    private int duration; // in seconds
    private String format;

    public Voice()
    {
        duration = 0;
        format = "";
    }

    public Voice(int duration, String format)
    {
        this.duration = duration;
        this.format = format;
    }

    public String toString()
    {
        return new String("\tVOICE: Duration:" + duration + " (sec), Format: " + format);
    }

    public boolean equals(Object object)
    {
        Voice otherVoice = (Voice) object;
        return duration == otherVoice.duration && format.equalsIgnoreCase(otherVoice.format); 
    }

    public double charge()
    {
        return duration * 0.1; 
    }
}
