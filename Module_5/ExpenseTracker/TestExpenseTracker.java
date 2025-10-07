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
                if (input == 1) 
                {
                    try 
                    {
                        for (Transaction tran : TransactionIO.findAll()) 
                        {
                            System.out.println(tran.toString());
                        }
                    } 
                    catch (IOException e) 
                    {
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else if (input == 2) 
                {
                    String c = "y";
                    ArrayList<Transaction> transactions = new ArrayList<>();
                    
                    while (c.equalsIgnoreCase("y")) 
                    {
                        Transaction t = new Transaction();
                        t.setDescription(ValidatorIO.getString(scanner, "\n  Enter the description: "));
                        t.setAmount(ValidatorIO.getDouble(scanner, "  Enter the amount: "));
                        transactions.add(t);
                        c = ValidatorIO.getString(scanner, "\n  Add another transaction? (y/n): ");
                    }

                    try 
                    {
                        TransactionIO.bulkInsert(transactions);
                    } 
                    catch (IOException e) {
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else if (input == 3)
                {
                    double monthlyExpense = 0.0d;
                    try {
                        ArrayList<Transaction> transactions = TransactionIO.findAll();
                        for (Transaction tran : transactions) 
                        {
                            monthlyExpense += tran.getAmount();
                        }
                        System.out.println(String.format("\n  Your total monthly expense is $%,6.2f\n", monthlyExpense));
                    } 
                    catch (IOException e) {
                        System.out.println("\n  Exception: " + e.getMessage());
                    }
                }
                else 
                {
                    System.out.println("  Invalid selection.\n");
                }

                showMenu = false; // Stop showing menu after revealing once; we prompt the user if they wish to continue and show the menu again based on that input.
            } // end if
            System.out.print("  Continue? (y/n): ");
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
        } while (continuePrompt);
        scanner.close();
    } // end main

}
