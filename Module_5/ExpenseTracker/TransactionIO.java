/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_5.ExpenseTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    // Constant Variables
    private final static String FILE_NAME = "expenses.txt"; // The name of the file used for tracking expenses.
    public final static String PARAM_SEPARATOR = "‡"; // The dummy character written in the file to indicate the next parameter on a line of transactions. Note this follows regex, so be cautious on the string choice.
    // Static variables
    private static File file = new File(FILE_NAME); // The actual File for tracking expenses. Because all functions used for it are static, this must also be static (Java error 33554506 otherwise).

    /** 
     * Static method with one argument, which is to insert an array list of transactions into the expenses file.
     * @param ArrayList<Transaction> transactions
     * @return directly modifies the expenses.txt file with no method output.
    */
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException 
    {
        PrintWriter output = null; // Create a placeholder PrintWriter variable that can be used for writing to a file.

        if (file.exists()) 
        {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true)); // If the file already exists, append to it.
        }
        else 
        {
            output = new PrintWriter(FILE_NAME); // If the file does not exist, create a new file based on FILE_NAME.
        }

        // Iterate through every transaction in the ArrayList and write its date, description, and amount to the file.
        for (Transaction tran : transactions) 
        {
            // Each parameter for a transaction is separated by PARAM_SEPARATOR.
            output.print(tran.getDate() + PARAM_SEPARATOR);
            output.print(tran.getDescription() + PARAM_SEPARATOR);
            output.println(tran.getAmount()); // However, each transaction is separated by a newline character.
        } // end for

        output.close(); // Close the scanner to prevent memory leaks.
    }

    /** 
     * Static method with no arguments, which is to retrieve all expenses from the expenses.txt file.
     * @return An ArrayList of Transaction read from each line of the expenses.txt file. 
    */
    public static ArrayList<Transaction> findAll() throws IOException
    {
        Scanner input = new Scanner(file); // Create a scanner to read through the file line-by-line.
        ArrayList<Transaction> output = new ArrayList<>(); // Initialize the output arraylist. Size will increase based on transaction count.
        while (input.hasNext())
        {
            // While the file still has lines to read, create a blank transaction and fill in the details with what is written on that line. Each transaction is separated by a newline character.
            Transaction tran = new Transaction(); // Create a template transaction that we can modify based on file contents.
            String[] splitInput =  input.nextLine().split(PARAM_SEPARATOR); // Each parameter of a transaction is separated by PARAM_SEPARATOR.
            // Only change the value in the transaction if it can found. If the Transaction line is incomplete or improperly formatted, the program will continue without filling in the blanks.
            if (splitInput != null && splitInput.length > 0) { tran.setDate(splitInput[0]); } 
            if (splitInput != null && splitInput.length > 1) { tran.setDescription(splitInput[1]); }
            if (splitInput != null && splitInput.length > 2) { tran.setAmount(Double.parseDouble(splitInput[2])); } // Additional check needed for Double to ensure it is actually a number.
            output.add(tran); // Add the transaction to the list of transactions.
        } // end while
        input.close(); // Close the scanner to prevent memory leaks.
        return output; // Return the array list.
    }

}
