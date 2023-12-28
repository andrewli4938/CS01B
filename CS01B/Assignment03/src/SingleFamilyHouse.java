/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: SingleFamilyHouse is a class derived from Property, and contains only one instance field in addition to its superclass 
 * fields. It contains its own toString() method that calls the superclass toString() method, and adds the backyardArea data to the
 * end of the string. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class SingleFamilyHouse extends Property
{
    private int backyardArea; 
    
    public SingleFamilyHouse()
    {
        super(); 
        backyardArea = 0; 
    }
    
    public SingleFamilyHouse(String address, double offeredPrice, int yearBuilt, int backyardArea)
    {
        super(address, offeredPrice, yearBuilt); 
        this.backyardArea = backyardArea; 
    }
    
    public String toString()
    {
        return super.toString() + backyardArea + " (sqft)"; 
    }
    
    public boolean equals(SingleFamilyHouse sfh)
    {
        return super.equals(sfh) && backyardArea == sfh.backyardArea;
    }
    
    public int getBackyardArea()
    {
        return backyardArea; 
    }
    
    public void setBackyardArea(int backyardArea)
    {
        this.backyardArea = backyardArea; 
    }
}
