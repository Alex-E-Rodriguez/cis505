package Module_3.CustomerAccountApp;

public class Account {

    // Instanced Variables
    private double balance;

    /** 
     * Method with no arguments, which is used as an accessor for the account's current balance.
     * @return the account's current balance as a double
    */
    public double getBalance() 
    {
        return balance;
    } // end getBalance

    /** 
     * Default constructor for the Account class.
     * @return returns an instance of Account with a default balance of 200.
    */
    Account() 
    {
        balance = 200;
    } // end constructor

    /** 
     * Method with one argument, which is used to deposit a specified amount into the account's total balance.
     * @param double amt
    */
    public void deposit(double amt) 
    {
        balance += amt;
    } // end deposit

    /** 
     * Method with one argument, which is used to withdraw a specified amount from the account's total balance.
     * @param double amt
    */
    public void withdraw(double amt) 
    {
        // We will only withdraw an amount if we have the balance for it. Otherwise, we do nothing / we do not partially withdraw the amount.
        if (balance >= amt) { balance -= amt; }
    } // end withdraw
    
    /** 
     * Method with no arguments, which is used to print out a menu prompting for the user input.
     * No actual input is scanned by this method; this is purely a display header.
    */
    public void displayMenu() 
    {
        System.out.println("  Account Menu\n  Enter <D/d> for deposit\n  Enter <W/w> for withdraw\n  Enter <B/b> for balance\n    Enter option>: ");
    } // end displayMenu

    /** 
     * Method with no arguments, which is used to return a specific date.
     * @return the current date as a string in the format of MM-dd-yyyy.
    */
    public String getTransactionDate() 
    {
        return "09-24-2025"; // Return a specific date
    } // end getTransactionDate
}
