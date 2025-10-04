/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_4.BowlingShopApp;

import java.util.Scanner;

public class TestBowlingShopApp {
    /** 
     * The following application displays an assortment of products available for purchase based on a user selected menu.
     * The user can type "b", "a", or "s" to display bowling balls, bags, or shoes, and type "x" to exit.
     * These product listings include the product code, description, price, and any unique features (i.e. color, type, size respectively).
    */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in); // Create a scanner for the user input.
        boolean continuePrompt = true; // Boolean that tracks whether or not the user wants to keep looking at products. Set to true for the first iteration so they respond at least once.

        System.out.println("Welcome to the Bowling Shop\n\n");
        do 
        {
            System.out.println("  MENU OPTIONS");
            System.out.println("    1. <b> Bowling Balls");
            System.out.println("    2. <a> Bowling Bags");
            System.out.println("    3. <s> Bowling Shoes");
            System.out.println("    4. <x> To exit");
            System.out.print("\n  Please choose an option: ");
            String userInput = scanner.next(); // Obtain the user input.
            userInput = userInput.trim().toLowerCase(); // Sanitize the user input.
            // If a product code is entered, display a list of that product.
            if (userInput.equalsIgnoreCase("b") || userInput.equalsIgnoreCase("a") || userInput.equalsIgnoreCase("s")) 
            {
                System.out.println("\n  --Product Listing--\n");
                GenericQueue<Product> products = ProductDB.getProducts(userInput); // get the list of products according to the code.
                while (products.size() > 0) 
                {
                    System.out.println(products.dequeue().toString());
                }
            }
            // If the user wishes to exit, exit the program.
            else if (userInput.equalsIgnoreCase("x")) 
            {
                System.out.println("\n  End of line...");
                continuePrompt = false;
            }
            // Otherwise, display an error message.
            else 
            {
                System.out.println("  Invalid selection. Please try again.\n");
            }
        } while (continuePrompt); // end do... while
    } // end main

} // end TestBowlingShopApp
