/**
 * @version 1.0 7-18-2020
 * @author Andrew Li
 * <br>
 * Purpose: CreditCardTransactionAnalayzer class contains the main method in which methods from Customer class are <br>
 * called. It lists all of the customer information from his / her previous transactions. <br>
 * <br>
 * Revision History: <br>
 * Date: 7-18-2020 <br>
 * Programmer: Andrew Li
 */
public class CreditCardTransactionAnalyzer
{
    public static void main(String[] args)
    {
        Customer customer = new Customer("Andrew Li", "1111111111111111",10000, 20); 
        customer.readTransactions();
        customer.reportTransactions();
        customer.reportBankingCharges(); 
        customer.reportRewardSummary();
        customer.reportCurrentBalance();
        
    }
}