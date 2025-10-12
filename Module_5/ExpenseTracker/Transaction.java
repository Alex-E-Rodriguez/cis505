/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_5.ExpenseTracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    // Instanced Variables
    private String date; //MM-dd-yyyy
    private String description; 
    private double amount;

    /** 
     * Default constructor for the Transaction class.
     * @return returns an instance of Transaction with the current date, a blank description, and an amount of $0.00.
    */
    Transaction() 
    {
        date =  LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        description = "";
        amount = 0.0d;
    } // end constructor

    /** 
     * Overloaded constructor for the Transaction class.
     * @param date String
     * @param description String
     * @param double amount
     * @return returns an instance of Transaction with the specified date, description, and amount.
    */
    Transaction(String date, String description, double amount) 
    {
        this.date = date;
        this.description = description;
        this.amount = amount;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the transaction date.
     * @return the transaction date as a formatted MM-dd-yyyy string.
    */
    public String getDate() 
    {
        return date;
    } // end getType

    /** 
     * Method with one argument, which is used as a mutator for the transaction date.
     * @param date String
    */
    public void setDate(String date)
    {
        this.date = date;
    } // end setDate

    /** 
     * Method with no arguments, which is used as an accessor for the transaction description.
     * @return the transaction description as a string.
    */
    public String getDescription() 
    {
        return description;
    } // end getDescription

    /** 
     * Method with one argument, which is used as a mutator for the transaction description.
     * @param description String
    */
    public void setDescription(String description)
    {
        this.description = description;
    } // end setDescription

    /** 
     * Method with no arguments, which is used as an accessor for the transaction amount.
     * @return the transaction amount as a double.
    */
    public double getAmount() 
    {
        return amount;
    } // end getAmount

    /** 
     * Method with one argument, which is used as a mutator for the transaction amount.
     * @param amount double
    */
    public void setAmount(double amount)
    {
        this.amount = amount;
    } // end setAmount

    /** 
     * Override method to output the current Transaction.
     * @return returns a String that reports the Transaction's date, description, and amount.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("  Date: %1$s\n", date));
        stringBuilder.append(String.format("  Description: %1$s\n", description));
        stringBuilder.append(String.format("  Amount: $%,6.2f\n",amount));
        return stringBuilder.toString();
    } // end toString
}
