
/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Subclass of Transaction, and represents a transaction made in a department store. It implements  <br>
 * the Rewardable interface, as points can be earned by spending money here. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */

public class DepartmentStoreTransaction extends Transaction implements Rewardable
{
    private String departmentName;
    private String returnPolicy;

    // default constructor
    public DepartmentStoreTransaction()
    {
        super();
    }

    // non-default constructors
    public DepartmentStoreTransaction(int id, int month, int day, int year, double amount, String name,
            String returnPol)
    {
        super(id, month, day, year, amount);
        departmentName = name;
        returnPolicy = returnPol;
    }
    
    public DepartmentStoreTransaction(int id, Date d, double amount, String name, String policy)
    {
        super(id, d, amount); 
        departmentName = name; 
        returnPolicy = policy; 
    }

    public String toString()
    {
        return String.format("%s~%s~%s~%s", "Department", super.toString(), departmentName, returnPolicy);
    }

    public void list()
    {
        System.out.format("%-13s%-15s%-10s$%-10.2f%s\n", date.toString(), "Department", departmentName,
                transAmnt, returnPolicy);
    }

    public double earnPoints()
    {
        return transAmnt * 3;
    }

    public String getName()
    {
        return departmentName; 
    }
    
    public String getReturnPol()
    {
        return returnPolicy; 
    }
    
    public void changeName(String name)
    {
        departmentName = name;
    }

    public void changePolicy(String num)
    {
        returnPolicy = num;
    }

}
