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

    private final static String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException 
    {
        PrintWriter output = null;

        if (file.exists()) 
        {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else 
        {
            output = new PrintWriter(FILE_NAME);
        }

        for (Transaction tran : transactions) 
        {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }

        output.close();
        
    }

    public static ArrayList<Transaction> findAll() throws IOException
    {
        Scanner input = new Scanner(file);
        ArrayList<Transaction> output = new ArrayList<>();
        while (input.hasNext())
        {
            Transaction tran = new Transaction();
            String[] splitInput =  input.nextLine().split(" ");
            if (splitInput != null && splitInput.length > 0) { tran.setDate(splitInput[0]); }
            if (splitInput != null && splitInput.length > 1) { tran.setDescription(splitInput[1]); }
            if (splitInput != null && splitInput.length > 2) { tran.setAmount(Double.parseDouble(splitInput[2])); }
            output.add(tran);
        }
        input.close();
        return output;
    }

}
