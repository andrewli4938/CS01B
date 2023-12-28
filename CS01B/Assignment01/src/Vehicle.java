/**
 * @version 1.0  07-02-2020
 * @author Andrew Li
 * <br>
 * Purpose: Vehicle class contains two constructors, default and non-default which takes make, model, year, and price as parameters. <br>
 * Also contains an overridden toString method which will take the Vehicle class attributes and format them into a single string. <br>
 * <br>
 * Revision History: <br>
 * Date 07-02-2020 <br>
 * Programmer Andrew Li <br>
 */
public class Vehicle 
{
    private String make, model;
    private int year;
    private double price;

    // default constructor
    public Vehicle()
    {
        make = new String("MFG");
        model = new String("MOD");
        year = 1970;
        price = 0.0;
    }

    // non-default constructor
    public Vehicle(String make, String model, int year, double price)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;

    }

    // accessor / mutator methods for instance fields
    public String getMake()
    {
        return make;
    }

    public String changeMake(String make)
    {
        this.make = make;
        return this.make; 
    }
    
    public String getModel()
    {
        return model;
    }
    
    public String changeModel(String model)
    {
        this.model = model; 
        return this.model;
    }

    public int getYear()
    {
        return year;
    }
    
    public int changeYear(int year)
    {
        this.year = year; 
        return this.year;
    }

    public double getPrice()
    {
        return price;
    }
    
    public double changePrice(double price)
    {
        this.price = price; 
        return this.price;
    }
    
    
    
    public String toMakeModel()
    {
        String makeModel = make + model; 
        return makeModel; 
    }
    
//    public String toMakeModel(int year)
//    {
//        String makeModelYear = make + model + year; 
//        return makeModelYear; 
//    }
    
    // formats instance fields in a string
    public String toString()
    {
        String car = String.format("%-13s%-16s%-6d$%.2f", make, model, year, price);
        return car; 
    }
    
    // equals method extra credit
    public boolean equals(Vehicle vehicle)
    {
        if (this.getMake().equalsIgnoreCase(vehicle.getMake()) && this.getModel().equalsIgnoreCase(vehicle.getModel()) && this.getYear() == vehicle.getYear())
        {
            return true; 
        }
        return false; 
    }
}
