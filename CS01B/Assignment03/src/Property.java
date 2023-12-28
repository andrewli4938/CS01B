/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: Property class is where all of the data put out on the JTextArea is stored. It contains a toString() method that formats
 * the data into a presentable String. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class Property
{
    private String address; 
    private double offeredPrice; 
    private int yearBuilt;
    private Property next; 
    
    public Property()
    {
        next = null; 
        address = "4444 Candy St, Candyland, CA 12345";
        offeredPrice = 500000; 
        yearBuilt = 1970; 
    }
    
    public Property(String address, double offeredPrice, int yearBuilt)
    {
        next = null; 
        this.address = address; 
        this.offeredPrice = offeredPrice; 
        this.yearBuilt = yearBuilt; 
    }
    
    public String toString()
    {
        return String.format("%-55s$%-15.2f%-15d", address, offeredPrice, yearBuilt); 
    }
    
    public boolean equals(Property property)
    {
        return address == property.address && offeredPrice == property.offeredPrice;
    }
    
    public String getAddress()
    {
        return address; 
    }
    
    public double getPrice()
    {
        return offeredPrice;
    }
    
    public int getYearBuilt()
    {
        return yearBuilt; 
    }
    
    public void setAddress(String address)
    {
        this.address = address; 
    }
    
    public void setPrice(double offeredPrice)
    {
        this.offeredPrice = offeredPrice; 
    }
    
    public void setYearBuilt(int yearBuilt)
    {
        this.yearBuilt = yearBuilt; 
    }
    
    public Property getNext()
    {
        return next; 
    }
    
    public void setNext(Property property)
    {
        next = property; 
    }
}
