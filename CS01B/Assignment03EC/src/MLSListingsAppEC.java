
public class MLSListingsAppEC
{
    public static void main(String[] args)
    {
        PropertyList clonedPropertyList = null; 
        PropertyList propertyList = new PropertyList();
        SingleFamilyHouse prop1 = new SingleFamilyHouse(1000, 10);
        SingleFamilyHouse prop2 = new SingleFamilyHouse(); 
        SingleFamilyHouse prop3 = new SingleFamilyHouse(); 
        
        propertyList.insert(prop1);
        propertyList.insert(prop2);
        propertyList.insert(prop3);
        
        try
        {
            Property clonedHead = propertyList.getHead().clone();
            clonedPropertyList = new PropertyList(); 
            clonedPropertyList.setHead(clonedHead);
        } catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        } 
        System.out.println(propertyList.getAllProperties());
        System.out.println(clonedPropertyList.getAllProperties());
    }
}
