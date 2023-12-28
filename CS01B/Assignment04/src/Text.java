/**
 * @version 1.0 8-06-2020
 * @author Andrew Li
 * <br>
 * Purpose: Text class is a type of Chargeable and only contains data that is specific to a text message <br>
 * (text message content). Also contains a toString() and equals() method that formats and compares the content <br>
 * instance field respectively. <br>
 * <br>
 * Revision History: <br>
 * Date: 8-06-2020 <br>
 * Programmer: Andrew Li
 */
public class Text implements Chargeable
{
    private String content;

    public Text()
    {
        content = "";
    }

    public Text(String text)
    {
        content = text;
    }

    public String toString()
    {
        return "\tTEXT: " + content;
    }

    public boolean equals(Object object)
    {
        Text otherText = (Text) object; 
        return content.equalsIgnoreCase(otherText.content);
    }

    public double charge()
    {
        return 0.2; 
    }
}
