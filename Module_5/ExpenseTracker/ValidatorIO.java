/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_5.ExpenseTracker;

import java.util.Scanner;

public class ValidatorIO {

    /** 
     * Static method with two arguments, which is used to validate and receive an integer from a user input based on a scanner and prompt.
     * @param Scanner sc
     * @param String prompt
     * @return the number the user typed, as an integer
    */
    public static int getInt(Scanner sc, String prompt) 
    {
        int input = 0; // Final output being tracked.
        boolean isValid = false; // Boolean that tracks whether the user's input is valid. 
        while(!isValid) 
        {
            System.out.print(prompt);  // Prompt the user.

            if (sc.hasNextInt()) // If the user has typed a number, interpret it as an integer.
            {
                input = sc.nextInt();
                isValid = true;
            }
            else 
            {
                System.out.println("\n  Error! Invalid integer value.\n"); // Otherwise, display an error.
            } // end if... else 
            sc.nextLine(); // Necessary to clear the input buffer.
        } // end while
        return input;
    } // end getInt

    /** 
     * Static method with two arguments, which is used to validate and receive a double from a user input based on a scanner and prompt.
     * @param Scanner sc
     * @param String prompt
     * @return the number the user typed, as a double
    */
    public static double getDouble(Scanner sc, String prompt) 
    {
        double input = 0.0d; // Final output being tracked.
        boolean isValid = false; // Boolean that tracks whether the user's input is valid. 
        while(!isValid) 
        {
            System.out.print(prompt); // Prompt the user.

            if (sc.hasNextDouble()) // If the user has typed a decimal, interpret it as a double.
            {
                input = sc.nextDouble();
                isValid = true;
            }
            else 
            {
                System.out.println("\n  Error! Invalid double value.\n"); // Otherwise, display an error.
            } // end if... else
            sc.nextLine(); // Necessary to clear the input buffer.
        } // end while
        return input;
    } // end getDouble
    
    /** 
     * Static method with two arguments, which is used to validate and receive a string from a user input based on a scanner and prompt.
     * @param Scanner sc
     * @param String prompt
     * @return the message the user typed, as a string
    */
    public static String getString(Scanner sc, String prompt) 
    {
        String input = ""; // Final output being tracked.
        boolean isValid = false; // Boolean that tracks whether the user's input is valid. 
        while(!isValid) 
        {
            System.out.print(prompt); // Prompt the user.

            if (sc.hasNextLine()) // If the user has typed a non-blank line, interpret the string.
            {
                input = sc.nextLine();
                isValid = true;
            }
            else 
            {
                System.out.println("\n  Error! Invalid string value.\n"); // Otherwise, display an error.
                sc.nextLine(); // Necessary to clear the input buffer.
            } // end if... else
        } // end while
        return input;
    } // end getString
    
} // end ValidatorIO