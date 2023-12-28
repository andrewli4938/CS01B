
public abstract class Item
{
    private int time; 
    private String from, to; 
    private double charge;
   
    public Item()
    {
        time = 1596546448;
        charge = 10; 
        from = "5105555555"; 
        to = "5104444444";
    }
    
    public Item(int time, String from, String to, double charge)
    {
        this.time = time; 
        this.from = from; 
        this.to = to; 
        this.charge = charge; 
    }
    
    public String toString()
    {
        return String.format("Time: %9d,From: %14s,To: %14s,Charge: $%.2f", time, from, to, charge); 
    }
    
    public boolean equals(Object other)
    {
        Item otherItem = (Item) other; 
        return this.time == otherItem.time && this.from.equals(otherItem.from) && this.to.equals(otherItem.to); 
    }
    
    public int getTime()
    {
        return time; 
    }
    
    public double getCharge()
    {
        return charge; 
    }
    
    public String getFrom()
    {
        return from; 
    }
    
    public String getTo()
    {
        return to; 
    }
    
    public void setTime(int time)
    {
        this.time = time; 
    }
    
    public void setCharge(double charge)
    {
        this.charge = charge; 
    }
    
    public void setFrom(String from)
    {
        this.from = from; 
    }
    
    public void setTo(String to)
    {
        this.to = to; 
    }

}
