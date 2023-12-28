import java.awt.List;
import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.nio.charset.*;

public class PropertyList
{
    private static final String FILE_LOCATION = 
            "/Users/w.li/eclipse-workspace/CS1B/Assignments/Assignment03/PropertyListText.txt"; 
    private Property head; 
    
    public PropertyList()
    {
        head = null; 
    }
    
    public void insert(Property property)
    {
        property.setNext(head);
        head = property;   
    }
    
    public String getAllProperties()
    {
        Property property = head;
        String allProperties = property.toString() + "\n";
        property = property.getNext(); 
        while(property != null)
        {
            allProperties += property.toString() + "\n";
            property = property.getNext();
        }
        return allProperties;
    }
    
    public Property getHead()
    {
        return head; 
    }
    
    public void setHead(Property head)
    {
        this.head = head; 
    }
}
