
/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Transaction abstract class is the superclass of DepartmentStoreTransaction, BankTransaction,  <br>
 * and GroceryTransaction, while many more can be made. It contains an abstract list() method, which is to all <br>
 * transaction information in a String. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */

public abstract class Transaction implements Comparable <Transaction>
{
    protected int transID; 
    protected double transAmnt; 
    protected Date date; 
    
    // default constructor
    public Transaction()
    {
        transID = 0; 
        date = new Date(); 
        transAmnt = 0; 
    }
    
    // non-default constructors
    public Transaction(int id, int month, int day, int year, double amount)
    {
        transID = id;
        date = new Date(month, day, year); 
        transAmnt = amount; 
    }
    
    public Transaction(int id, Date d, double amount)
    {
        transID = id; 
        transAmnt = amount; 
        try
        {
            date = d.clone();
        } catch (CloneNotSupportedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    abstract public void list();
    
    public String toString()
    {
        return String.format("%s~%d~%.2f", date.toString(), transID, transAmnt); 
    }
    
    public boolean equals(Transaction other)
    {
        return other.transID == transID; 
    }
    
    public int compareTo(Transaction transaction)
    {
        if (this.equals(transaction))
        {
            return 0; 
        }
        if (transID > transaction.transID)
        {
            return 1; 
        }
        return -1; 
    }
    
    public int getID()
    {
        return transID; 
    }
    
    public double getAmount()
    {
        return transAmnt; 
    }
    
    public String getDate()
    {
        return date.toString(); 
    }
    
    public void changeID(int id)
    {
        transID = id; 
    }
    
    public void changeAmount(double amount)
    {
        transAmnt = amount; 
    }
    
    public void changeDate(Date d)
    {
        try
        {
            date = d.clone(); 
        } catch (CloneNotSupportedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
}
