/**
 * @version 1.0 8-06-2020
 * @author Andrew Li
 * <br>
 * Purpose: Message class is a generic class that contains a toString() method formatting the general information of each <br>
 * Message and an equals() method that compares the general information of each type of Message. <br>
 * <br>
 * Revision History: <br>
 * Date: 8-06-2020 <br>
 * Programmer: Andrew Li
 */
public class Message<T> extends Item
{
    private T chargable;

    public Message()
    {
        super();
        chargable = null;
    }

    public Message(T object, int time, String from, String to, double charge)
    {
        super(time, from, to, charge);
        this.chargable = object;
    }

    public String toString()
    {
        return String.format("%-55s%s", chargable.toString(), super.toString());
    }

    public boolean equals(Object other)
    {
        Message<?> otherMessage = (Message<?>) other;
        
        // comparing if two objects are the same type instead of "instanceof to verify if T is a Voice or Text or Media"
        // to make more generic, to allow additional Message types to be added without modifying the code.
        // i.e if you wanted to add Email
        if (otherMessage.getMessage().getClass().getName().equals(chargable.getClass().getName())) 
        {
            return super.equals(otherMessage) && this.getMessage().equals(otherMessage.getMessage());
        }
        return false;

//        if(chargable instanceof Text && otherMessage.getMessage() instanceof Text)
//        {   
//            otherMessage = (Message<Text>) other;
//            Text otherText = (Text) otherMessage.getMessage();
//            Text text = (Text) this.getMessage();
//            return super.equals(otherMessage) && text.equals(otherText);
//            
//        } else if(chargable instanceof Media && otherMessage.getMessage() instanceof Media)
//        {
//            otherMessage = (Message<Media>) other;
//            Media otherMedia = (Media) otherMessage.getMessage();
//            Media media = (Media) this.getMessage();
//            return super.equals(otherMessage) && media.equals(otherMedia);
//            
//        } else if(chargable instanceof Voice && otherMessage.getMessage() instanceof Voice)
//        {
//            otherMessage = (Message<Voice>) other;
//            Voice otherVoice = (Voice) otherMessage.getMessage();
//            Voice voice = (Voice) this.getMessage();
//            return super.equals(otherMessage) && voice.equals(otherVoice);
//        }
//        return false;

    }

    public T getMessage()
    {
        return chargable;
    }

    public void setMessage(T object)
    {
        this.chargable = object;
    }
}
