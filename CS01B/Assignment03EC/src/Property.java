
public class Property implements Cloneable
{
    private int zipCode;
    private Property next; 
    
    public Property()
    {
        next = null; 
        zipCode = 99999; 
    }
    
    public Property(int zipCode)
    {
        this.zipCode = zipCode; 
    }
    
    public String toString()
    {
        return String.format("%-10s%-8d","zip code: ", zipCode);
    }
    
    public Property getNext()
    {
        return next;
    }
    
    public void setNext(Property next)
    {
        this.next = next; 
    }
    
    public Property clone() throws CloneNotSupportedException 
    {
        return (Property) super.clone();
    }
}
