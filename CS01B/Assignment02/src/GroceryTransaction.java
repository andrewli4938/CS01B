
/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Subclass of Transaction. It represents a Transaction made in a grocery store. It implements  <br>
 * the Rewardable interface as each transaction will be rewarded with points. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */

public class GroceryTransaction extends Transaction implements Rewardable
{
    private String storeName;

    // default constructor
    public GroceryTransaction()
    {
        super();
    }

    // non-default constructors
    public GroceryTransaction(int id, int month, int day, int year, double amount, String name)
    {
        super(id, month, day, year, amount);
        storeName = name;
    }
    
    public GroceryTransaction(int id, Date date, double amount, String name)
    {
        super(id, date, amount); 
        storeName = name; 
    }

    public String toString()
    {
        return String.format("%s~%s~%s", "Grocery", super.toString(), storeName);
    }

    public void list()
    {
        System.out.format("%-13s%-15s%-10s$%.2f\n", date.toString(), "Grocery", storeName, transAmnt);
    }

    public double earnPoints()
    {
        return transAmnt * 5;
    }

    public String getStoreName()
    {
        return storeName; 
    }
    
    public void changeStore(String store)
    {
        storeName = store;
    }

}
