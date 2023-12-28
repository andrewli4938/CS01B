import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: PropertyList class is the Linked List class. It contains the insert() method, which inserts the Property object
 * in the front of the list, as well as many other methods that iterate through the list. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class PropertyList
{
    private static final String FILE_LOCATION = 
            "/Users/w.li/eclipse-workspace/CS1B/Assignments/Assignment03/PropertyListText.txt"; 
    private Property head; 
    private static final int MAX =100;
    
    public PropertyList()
    {
        head = null; 
    }
    
    private void insert(Property property)
    {
        property.setNext(head);
        head = property;   
    }
    
    public void initialize()
    {
        Path filePath = Paths.get(FILE_LOCATION); 
        BufferedReader br; 
        int index = 0;
        String line = null; 
        Property[] propertyArray = new Property[MAX]; 
        
        try
        {
            br = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
            while((line = br.readLine()) != null)
            {
                String[] data = null; 
                String type = null; 
                double offeredPrice;
                int yearBuilt; 
                
                data = line.split(";");
                type = data[0];
                offeredPrice = Double.parseDouble(data[2]);
                yearBuilt = Integer.parseInt(data[3]);
    
                if(type.equalsIgnoreCase("Condo"))
                {
                    Double hoaFee;
                    hoaFee = Double.parseDouble(data[4]); 
                    propertyArray[index] = new Condo(data[1], offeredPrice, yearBuilt, hoaFee);
                }
                if(type.equalsIgnoreCase("SFH"))
                {
                    int backyardArea; 
                    backyardArea = Integer.parseInt(data[4]);
                    propertyArray[index] = new SingleFamilyHouse(data[1], offeredPrice, yearBuilt, backyardArea);
                }
                index++;
            }
            br.close();
            for(Property property : propertyArray)
            {
                if(property  != null)
                {
                    this.insert(property);                    
                }
            }
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public String getAllProperties()
    {
        Property property = head;
        String allProperties = ""; 
        
        while(property != null)
        {
            allProperties += property.toString() + "\n";
            property = property.getNext();
        }
        return allProperties;
    }
    
    public String getSingleFamilyHouse()
    {
        Property property = head; 
        String allSFH = ""; 
        
        while(property != null)
        {
            if(property instanceof SingleFamilyHouse)
            {
                allSFH += property.toString() + "\n"; 
            }
            property = property.getNext();
        }
        return allSFH; 
    }
    
    public String getCondo()
    {
        Property property = head; 
        String allCondo = ""; 

        while(property != null)
        {
            if(property instanceof Condo)
            {
                allCondo += property.toString() + "\n"; 
            }
            property = property.getNext();
        }
        return allCondo; 
    }
    
    public String searchByPriceRange(double min, double max)
    {
        Property property = head; 
        String allFound = ""; 

        while(property != null)
        {
            if(property.getPrice() >= min && property.getPrice() <= max)
            {
                allFound += property.toString() + "\n"; 
            }
            property = property.getNext();
        }
        return allFound;
    }
}
