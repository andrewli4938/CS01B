import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.nio.charset.*;


/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: Customer class contains all the methods that report customer balances, total points earned from transactions, <br>
 * total bank charges, and a listing of all of the customer's past transactions read from a text file. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */
public class Customer
{ 
    private static final int MAX_SIZE = 8; 
    private String custName, credNum;
    private double totalBal, rewardBal;
    private Transaction[] transactionList; 
    private Rewardable[] rewardsList; 
    private static final String INPUT_FILE_LOCATION = "/Users/w.li/eclipse-workspace/CS1B/Assignments/Assignment02/TransactionsData.txt";
    
    // default constructor
    public Customer()
    {
        custName = "John Doe";
        credNum = "1111222233334444"; 
        totalBal = 0; 
        rewardBal = 1000; 
        transactionList = new Transaction[MAX_SIZE]; 
        rewardsList = new Rewardable[MAX_SIZE]; 
    }
    
    // non-default constructors
    public Customer(String name, String card, double balance, double points)
    {
        custName = name; 
        credNum = card; 
        totalBal = balance; 
        rewardBal = points; 
        transactionList = new Transaction[MAX_SIZE];
        rewardsList = new Rewardable[MAX_SIZE]; 
    }
    
    public void reportCurrentBalance()
    {
        System.out.print("\nBalance Summary for " + custName + " "); 
        lastDigits(); 
        System.out.println();
        System.out.format("%-45s$%.2f\n", "Previous credit card balance", totalBal); 
        double moneySpent = 0; 
        for (Transaction transaction : transactionList)
        {
            moneySpent += transaction.getAmount(); 
        }
        totalBal = totalBal - moneySpent; 
        System.out.format("%-45s$%.2f\n", "- Total money spent", moneySpent ); 
        System.out.println("-----------------------------------------------------");
        System.out.format("%-45s$%.2f\n", "Current Balance", totalBal); 
    }
    
    public void reportRewardSummary()
    {
        double departmentPoints = 0;
        double groceryPoints = 0; 
        System.out.print("\nRewards Summary for " + custName + " " );
        lastDigits(); 
        System.out.println();
        System.out.format("%-45s%.2f\n", "Previous Points Balance", rewardBal); 
        
        for (Transaction transaction : transactionList)
        {
            if (transaction instanceof Rewardable)
            {
                if (transaction instanceof DepartmentStoreTransaction)
                {
                    departmentPoints += ((Rewardable) transaction).earnPoints(); 
                } else
                {
                    groceryPoints += ((Rewardable) transaction).earnPoints(); 
                }
            }
        }
        
        System.out.format("%-45s%.2f\n", "+ Points earned on department stores", departmentPoints);
        System.out.format("%-45s%.2f\n", "+ Points earned on grocery stores", groceryPoints); 
        System.out.println("----------------------------------------------------------------");
        System.out.format("%-45s%.2f\n", "Total Points Available for Redemption", groceryPoints + departmentPoints); 
    }
    
    public void reportBankingCharges()
    {
        double bankCharges = 0; 
        for (Transaction transaction : transactionList)
        {
            if (transaction instanceof BankTransaction)
            {
                bankCharges += ((BankTransaction) transaction).getCharge(); 
            }
        }
        System.out.println("\nTotal bank charges are: $" + bankCharges);
    }
    
    public void reportTransactions()
    {
        System.out.println("\nTRANSACTION LISTING REPORT"); 
        for (Transaction transaction : transactionList)
        {
            transaction.list();
        }
    } 
    
    public void readTransactions()
    {
        storeTransactions(transactionList, INPUT_FILE_LOCATION); 
        Arrays.sort(transactionList, 0, transactionList.length);
        int index = 0;
        for (Transaction trans : transactionList)
        {
            if (trans instanceof Rewardable)
            {
                rewardsList[index++] = (Rewardable) trans; 
            }
        }
    }
    
    private static void storeTransactions(Transaction[] list, String inputFilePath)
    {
        Path inputLocation = Paths.get(inputFilePath); 
        BufferedReader br = null; 
        String line = null; 
        int index = 0;
        
        try
        {
            br = Files.newBufferedReader(inputLocation, StandardCharsets.UTF_8);
            while((line = br.readLine())!= null)
            {
                // parse data and add to the array 
                addData(list, line, index++); 
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
                
    }
    
    private static void addData(Transaction[] list, String line, int index) 
    {
        String type = null; 
        String[] data = null; 
        String[] dates = null;
        int id = 0; 
        int month = 0; 
        int day = 0; 
        int year = 0; 
        double amount = 0; 
        data = line.split("~");
        dates = data[1].split("/"); 
        type = data[0]; 
        
        // assign dates
        month = Integer.parseInt(dates[0]);
        day = Integer.parseInt(dates[1]);
        year = Integer.parseInt(dates[2]);
        
        // assign data for Transaction objects
        id = Integer.parseInt(data[2]); 
        amount = Double.parseDouble(data[3]);
        
        // instance fields specific to different Transactions will be defined separately
        if (type.equals("Department"))
        {
            String name = null; 
            String returnPol = null; 
            name = data[4]; 
            returnPol = data[5]; 
            list[index] = new DepartmentStoreTransaction(id, month, day, year, amount, name, returnPol); 
        }
        
        if (type.equals("Bank"))
        {
            String method = null; 
            double charge = 0; 
            method = data[4]; 
            charge = Double.parseDouble(data[5]);  
            list[index] = new BankTransaction(id, month, day, year, amount, method, charge); 
        }
        
        if (type.equals("Grocery"))
        {
            String name = null; 
            name = data[4]; 
            list[index] = new GroceryTransaction(id, month, day, year, amount, name); 
        }
    }
    
    public void lastDigits()
    {
        for (int i = 12; i < credNum.length(); i++)
        {
            System.out.print(credNum.charAt(i));
        }
    }
}
