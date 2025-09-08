/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

public class RodriguezHelloWorld {

    /** 
     * Function prints the user's first and last name in reverse order.
     * @param nameFirst String
     * @param nameLast String
     * @return prints the formatted string to terminal.
     */
    private static void printName(String nameFirst, String nameLast) 
    {
        System.out.printf("Hello World from %2$s %1$s.", nameFirst, nameLast);
    } // end printName

    public static void main(String[] args)
    {
        printName("Alex","Rodriguez"); // Calls printName() with author's name ("Alex" and "Rodriguez")
    } // end main
} // end RodriguezHelloWorld