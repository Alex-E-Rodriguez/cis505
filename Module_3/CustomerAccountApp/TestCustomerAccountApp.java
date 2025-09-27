package Module_3.CustomerAccountApp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TestCustomerAccountApp {
    /** 
     * The following application is a customer account app. 
     * If the user enters a specific customer number, they can deposit, withdraw, and the view balance of that customer's account.
     * The user may perform as many actions as they wish on that specific customer, if the customer exists.
    */

    // do... while
    public static void main(String[] args)
    {
        /** 
         * The following application allows the user to create as many Teams as they wish.
         * Teams are composed of up to 20 players, and each player has their own name.
         * A console print of the the team they created is provided at the end.
         * The application will continue to prompt the user until they confirm they want to exit.
        */

        Scanner scanner = new Scanner (System.in); // Create a scanner for the user input.

        boolean continuePrompt = true; // Boolean that tracks whether or not the user wants to continue. Set to true for the first iteration so they make at least one team.
        boolean continueInnerInput = true; // Boolean that tracks user input for inner loops (e.g. when prompting for numbers)

        System.out.println("  Welcome to the Customer Account App\n");
        Integer id = 0;
        do {
            continueInnerInput = true; // Continuously prompt the user for a valid ID
            System.out.println("\n  Enter a customer ID: \n     ex: 1007, 1008, 1009>: ");  
            try {
                id = scanner.nextInt(); // Parse the user's input for the ID into an Integer (nullable)
                continueInnerInput = false;
            }
            catch (InputMismatchException e) { // If the input is not a number, it is invalid. Inform the user and prompt them to try again.
                System.out.println("\n  Error:  Invalid Option");
                scanner.next(); // Clear the input buffer
            } // end try... catch
        } while(continueInnerInput); // end do... while
        
        Customer customer = CustomerDB.getCustomer(id); // Create a Customer class based on the interpreted Integer id we received from the user
        Account account = new Account(); // Create a new Account for the Customer

        do {
            account.displayMenu(); // Display the account menu prompt
            String user_input = scanner.next(); // Receive user input
            
            if (user_input.trim().toLowerCase().compareTo("d") == 0) // If the user types "D" or "d", go to the deposit menu.
            { 
                Double amt = -1.0d; // Declare temporary variable for specified amount (declared early for error handling purposes)
                do {
                    continueInnerInput = true; // Continuously prompt the user for a valid deposit amount
                    System.out.println("  Enter deposit amount: ");
                    try {
                        amt = scanner.nextDouble(); // Parse the user's input for the amount into a Double (nullable)
                        if (amt < 0) // If the input is negative, it is invalid. Inform the user and prompt them try to again. 
                        {
                            System.out.println("\n  Error:  Invalid Option\n");
                        }
                        else // Otherwise, deposit the amount specified and exit the inner loop
                        {
                            account.deposit(amt);
                            continueInnerInput = false;
                        }
                    }
                    catch (InputMismatchException e) { // If the input is not a number, it is invalid. Inform the user and prompt them to try again.
                        System.out.println("\n  Error:  Invalid Option\n");
                        scanner.next(); // Clear the input buffer
                    } // end try... catch
                } while (continueInnerInput); // end do... while
            }
            else if (user_input.trim().toLowerCase().compareTo("w") == 0) // If the user types "W" or "w", go to the withdraw menu.
            { 
                Double amt = -1.0d; // Declare temporary variable for specified amount (declared early for error handling purposes)
                do {
                    continueInnerInput = true; // Continuously prompt the user for a valid withdrawal amount
                    System.out.println("  Enter withdraw amount: ");
                    try {
                        amt = scanner.nextDouble(); // Parse the user's input for the amount into a Double (nullable)
                        if (amt < 0) // If the input is negative, it is invalid. Inform the user and prompt them try to again. 
                        {
                            System.out.println("\n  Error:  Invalid Option\n");
                        }
                        else // Otherwise, deposit the amount specified and exit the inner loop
                        {
                            account.withdraw(amt);
                            continueInnerInput = false;
                        }
                    }
                    catch (InputMismatchException e) { // If the input is not a number, it is invalid. Inform the user and prompt them to try again.
                        System.out.println("\n  Error:  Invalid Option\n");
                        scanner.next(); // Clear the input buffer
                    } // end try... catch
                } while (continueInnerInput); // end do... while
            }
            else if (user_input.trim().toLowerCase().compareTo("b") == 0) // If the user types "B" or "b", display the current balance.
            { 
                System.out.printf("\n  Account balance: $%1$,6.2f", account.getBalance());
            }
            else // Otherwise, display an error message.
            { 
                System.out.println("\n  Error: Invalid Option");
            }

            System.out.println("\n  Continue? (y/n): ");
            user_input = scanner.next();
            if (user_input.trim().toLowerCase().compareTo("y") == 0) // If the user types "Y" or "y", loop the menus.
            { 
                continuePrompt = true; 
            }
            else if (user_input.trim().toLowerCase().compareTo("n") == 0) // If the user types "N" or "N", output the account + customer details and exit.
            { 
                continuePrompt = false; 
            }
        }
        while (continuePrompt); // end do... while

        System.out.printf("\n  %1$s", customer.toString()); // Output the customer information
        System.out.printf("\n\n  Balance as of %1$s is $%2$,6.2f", account.getTransactionDate(), account.getBalance()); // Output the account balance and transaction date
        System.out.println("\n\n  End of line..."); // Indicate the program's end

        scanner.close(); // Close the scanner.
        
    } // end main
} // end TestCustomerAccountApp
