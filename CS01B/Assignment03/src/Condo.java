/**
 * @version 1.0 7-28-2020
 * @author Andrew Li
 * <br>
 * Purpose: Condo is a class derived from Property, and contains only one instance field in addition to its superclass 
 * fields. It contains its own toString() method that calls the superclass toString() method, and adds the hoaFee data to the
 * end of the string <br>
 * <br>
 * Revision History: <br>
 * Date: 7-28-2020 <br>
 * Programmer: Andrew Li
 */
public class Condo extends Property
{
    private double hoaFee; 
    
    public Condo()
    {
        super(); 
        hoaFee = 175; 
    }
    
    public Condo(String address, double offeredPrice, int yearBuilt, double hoaFee)
    {
        super(address, offeredPrice, yearBuilt);
        this.hoaFee = hoaFee; 
    }
    
    public String toString()
    {
        return super.toString() + "HOA Fee: $" + hoaFee; 
    }
    
    public boolean equals(Condo condo)
    {
        return super.equals(condo) && hoaFee == condo.hoaFee; 
    }
    
    public double getFee()
    {
        return hoaFee; 
    }
    
    public void setFee(double hoaFee)
    {
        this.hoaFee = hoaFee; 
    }
}
