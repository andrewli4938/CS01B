
public class SingleFamilyHouse extends Property implements Cloneable
{
    private int backyardArea; 
    
    public SingleFamilyHouse()
    {
        super(); 
        backyardArea = 0; 
    }
    
    public SingleFamilyHouse(int zipCode, int backyardArea)
    {
        super(zipCode); 
        this.backyardArea = backyardArea; 
    }
    
    public String toString()
    {
        return super.toString() + "Backyard area: "+ backyardArea + "(sqft)" + "\n"; 
    }
    
    public SingleFamilyHouse clone() throws CloneNotSupportedException
    {
        return (SingleFamilyHouse) super.clone(); 
    }
}
