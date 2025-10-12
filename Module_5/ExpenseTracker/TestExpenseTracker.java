/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_5.ExpenseTracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestExpenseTracker {
     /** 
     * The following application tracks the user's expenses, allowing them to add transactions to a file, view their current transactions in that file, and calculate their total expenses.
     * The user can type "1", "2", or "3" to view transactions, add transactions, or view expense (calculate total amount).
     * These transactions include a date, description, and amount.
    */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in); // Create a scanner for the user input.
        boolean continuePrompt = true; // Boolean that tracks whether or not the user wants to keep looking at products. Set to true for the first iteration so they respond at least once.
        boolean showMenu = true; // Boolean that tracks whether or not the menu should be shown (i.e. first run or using prompting to continue)

        System.out.println("  Welcome to the Expense Tracker\n");
        do 
        {
            if (showMenu) 
            { 
                System.out.println("  MENU OPTIONS");
                System.out.println("    1. View Transactions");
                System.out.println("    2. Add Transactions");
                System.out.println("    3. View Expense");
                int input = ValidatorIO.getInt(scanner, "\n  Please choose an option: ");
                if (input == 1) // View Transactions
                {
                    try 
                    {
                        // If the user wants to view their transactions, try to retrieve an ArrayList of them from the expenses.txt file.
                        for (Transaction tran : TransactionIO.findAll()) 
                        {
                            // Print out each transaction scanned from the file.
                            System.out.println(tran.toString());
                        }
                    } 
                    catch (IOException e) 
                    {
                        // If the file does not exist, is invalid, or has a read access error, inform the user and prompt the menu once more.
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else if (input == 2) // Add Transactions
                {
                    // Continously prompt the user to add transactions until they wish to stop (input = 'n').
                    String c = "y"; // Track the user's yes/no input for adding transactions. Ensure the first input is 'y' so at least one iteration always occurs.
                    ArrayList<Transaction> transactions = new ArrayList<>(); // Create the ArrayList that holds the transactions added. This will later be written to a file.
                    
                    while (c.equalsIgnoreCase("y")) 
                    {
                        // If the user wishes to add a transaction, create a template transaction and modify its parameters according to user input.
                        Transaction t = new Transaction(); // Create a template transaction, which will always use the current date.
                        // Note: ValidatorIO will continuously prompt the user until they provide a valid input.
                        t.setDescription(ValidatorIO.getString(scanner, "\n  Enter the description: ")); // We use the ValidatorIO class to ensure the input is a valid string.
                        t.setAmount(ValidatorIO.getDouble(scanner, "  Enter the amount: ")); // We use the ValidatorIO class to ensure the input is a valid double.
                        transactions.add(t); // Add the transaction to the ArrayList of transactions.
                        c = ValidatorIO.getString(scanner, "\n  Add another transaction? (y/n): "); // Prompt the user if they wish to keep adding transactions. Note that technically any input that is not 'y' counts as 'n'.
                    }

                    try 
                    {
                        // Once we have a list of transactions, attempt to insert them into the file (or create a new one, if it does not exist).
                        TransactionIO.bulkInsert(transactions);
                    } 
                    catch (IOException e) 
                    {
                        // If an IO issue occurs with the file, such a write access issue, output the exception.
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else if (input == 3) // View Expense
                {
                    double monthlyExpense = 0.0d; // Final sum output. Default zero.
                    try {
                        // Attempt to retrieve a list of transactions from the expenses.txt file.
                        ArrayList<Transaction> transactions = TransactionIO.findAll();
                        for (Transaction tran : transactions) 
                        {
                            // Get the amount from the transaction and add it to the total expense. Note that negative values will subtract from the expense.
                            monthlyExpense += tran.getAmount();
                        }
                        System.out.println(String.format("\n  Your total monthly expense is $%,6.2f\n", monthlyExpense));
                    } 
                    catch (IOException e) 
                    {
                        // If an error occurs, such as the file not existing, being improperly formatted, or a read access error, display the exception. 
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else 
                {
                    // If the user types anything but 1, 2, or 3, display an error message and prompt the user if they wish to continue.
                    System.out.println("  Invalid selection.\n");
                }

                showMenu = false; // Stop showing menu after revealing once; we prompt the user if they wish to continue and show the menu again based on that input.
            } // end if
            System.out.print("  Continue? (y/n): "); // Prompt the user if they wish to continue.
            String userInput = scanner.next(); // Obtain the user input.
            userInput = userInput.trim().toLowerCase(); // Sanitize the user input.
            // If the user wishes to see the menu again, display it again.
            if (userInput.equalsIgnoreCase("y")) 
            {
                showMenu = true;
            }
            // If the user wishes to exit, exit the program.
            else if (userInput.equalsIgnoreCase("n")) 
            {
                System.out.println("\n  Program terminated by the user...");
                continuePrompt = false;
            }
            // Otherwise, display an error message.
            else 
            {
                System.out.println("  Invalid selection. Please try again.\n");
            } // end if... else
        } while (continuePrompt); // end do... while
        scanner.close(); // Close the scanner to prevent memory leaks.
    } // end main

}
