/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_6.ComposerApp;

import java.util.List;
import java.util.Scanner;

public class TestComposerApp {
    /*
     * The following application allows the user to create, manage, and search through a list of composers.
     * The user can type "1", "2", "3", or "4" to view composers, find a composer by their ID, add a composer, or exit the program.
     * These composers include an id, name, and genre of music.
    */
    public static void main(String[] args)
    {
        MemComposerDao memComposerDao = new MemComposerDao(); // Create a member composer data access object for the user. 
        Scanner scanner = new Scanner (System.in); // Create a scanner for the user input.
        boolean continuePrompt = true; // Boolean that tracks whether or not the main menu should be shown. Will always be true on first run.

        System.out.println("  Welcome to the Composer App");
        do 
        {
            System.out.println("\n  MENU OPTIONS");
            System.out.println("    1. View Composers");
            System.out.println("    2. Find Composer");
            System.out.println("    3. Add Composer");
            System.out.println("    4. Exit");
            int input = ValidatorIO.getInt(scanner, "\n  Please choose an option: ");
            if (input == 1) // View Composers
            {
                List<Composer> composers = memComposerDao.findAll(); // Find the list of composers in memory.
                if (composers.size() > 0) // If there is more than one composer, display the composers.
                {
                    System.out.println("\n  --DISPLAYING COMPOSERS--");
                    for (Composer c : composers) 
                    {
                        System.out.println(c.toString());
                    }
                }
                else // Otherwise, display an error message. 
                {
                    System.out.println("\n  No composers found.");
                }
            }
            else if (input == 2) // Find Composer
            {
                int id = ValidatorIO.getInt(scanner, "\n  Please enter the composer's ID: "); // Prompt the user for an ID to search the list of composers by.
                Composer c = memComposerDao.findBy(id); // Search for the list of composers.
                if (c != null) // If the composer exists, print out their details.
                {
                    System.out.println("\n  --DISPLAYING COMPOSER--");
                    System.out.println(c.toString());
                }
                else // Otherwise, display an error message.
                {
                    System.out.println(String.format("\n  No composer with id %1$d found.", id));
                }
            }
            else if (input == 3) // Add Composer
            {
                Composer c = new Composer(); // Create a template composer for the user to modify.
                // Prompt the user for each setting for the new composer, modifying the template accordingly.
                c.setId(ValidatorIO.getInt(scanner, "  Please enter the new composer's ID: "));
                c.setName(ValidatorIO.getString(scanner, "  Please enter the new composer's name: "));
                c.setGenre(ValidatorIO.getString(scanner, "  Please enter the new composer's genre: "));
                // Insert the new composer into the list.
                memComposerDao.insert(c);
            } 
            else if (input == 4) // Exit
            {
                continuePrompt = false; // End the do... while loop of menu prompts.
            }
            else 
            {
                System.out.println("\n  Invalid input. Please type a number between 1 and 4.");
            }
        } while (continuePrompt); // end do... while
        scanner.close(); // Close the scanner to prevent memory leaks.
    } // end main

}
