/**
 * @version 1.0 8-06-2020
 * @author Andrew Li
 * <br>
 * Purpose: Media class is a type of Chargeable that only contains data specific to a media message, which is size and <br>
 * format. Also contains a toString() and equals() method that formats and compares the instances fields respectively. <br>
 * <br>
 * Revision History: <br>
 * Date: 8-06-2020 <br>
 * Programmer: Andrew Li
 */
public class Media implements Chargeable
{
    private double size;
    private String format;

    public Media()
    {
        size = 0;
        format = "";
    }

    public Media(double size, String format)
    {
        this.size = size;
        this.format = format;
    }

    public String toString()
    {
        return new String("\tMEDIA: Size:" + size + " MB, Format: " + format);
    }

    public boolean equals(Object object)
    {
        Media otherMedia = (Media) object; 
        return size == otherMedia.size && format.equalsIgnoreCase(otherMedia.format); 
    }

    public double charge()
    {
        return size * 0.5; 
    }
}
