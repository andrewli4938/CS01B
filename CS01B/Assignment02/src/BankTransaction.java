
/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Subclass of Transaction class, and represents a transaction made in a Bank. Each transaction results <br>
 * in a banking charge, which will be added to the total transaction amount. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */

public class BankTransaction extends Transaction
{
    private String withdrawType;
    private double charge;

    // default constructor
    public BankTransaction()
    {
        super();
    }

    // non-default constructor
    public BankTransaction(int id, int month, int day, int year, double amount, String withType, double charge)
    {
        super(id, month, day, year, amount);
        withdrawType = withType;
        this.charge = charge;
    }
    
    public BankTransaction(int id, Date date, double amount, String withType, double charge)
    {
        super(id, date, amount); 
        withdrawType = withType; 
        this.charge = charge; 
    }

    public String toString()
    {
        return String.format("%s~%s~%s~%s", "Bank", super.toString(), withdrawType, charge);
    }

    public void list()
    {
        System.out.format("%-13s%-15s%-10s$%-10.2f%.2f\n", date.toString(), "Bank", withdrawType, 
                transAmnt + charge, charge);
    }

    public String getType()
    {
        return withdrawType; 
    }
    
    public double getCharge()
    {
        return charge; 
    }
    
    public void changeType(String type)
    {
        withdrawType = type;
    }

    public void changeCharge(double fee)
    {
        charge = fee;
    }
}
