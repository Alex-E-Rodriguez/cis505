/*
    Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
    Comprehensive Version (12th ed.). Pearson Education, Inc.
    Modified by R. Krasso 2021
    Additional modifications by A. Rodriguez 2025
*/

package Module_2.SportsTeamApp;

import java.util.Scanner;

public class TestSportsTeamApp {

  public static void main(String[] args)
  {
    /** 
     * The following application allows the user to create as many Teams as they wish.
     * Teams are composed of up to 20 players, and each player has their own name.
     * A console print of the the team they created is provided at the end.
     * The application will continue to prompt the user until they confirm they want to exit.
    */

    Scanner scanner = new Scanner (System.in); // Create a scanner for the user input.

    boolean continuePrompt = true; // Boolean that tracks whether or not the user wants to keep making teams. Set to true for the first iteration so they make at least one team.

    System.out.println("--- Sports Team App ---");

    while (continuePrompt) {
      System.out.println("\nEnter team name: ");  
      String teamName = scanner.next(); // Receive user input from the next line.
      System.out.println("\nEnter player names: \n  (hint: use commas for multiple players; no spaces): ");
      String[] playerNames = scanner.next().split(","); // Interpret the user's input based on no-space commas and placed into an array storing the player names.
      
      Team team = new Team(teamName); // Create a new Team object with the user's team name input as the team name.
      for (String player : playerNames) 
      {
        team.addPlayer(player); // Iterate through every team name the player has entered and add it to the newly team.
      } // end for

      System.out.println("\n--Team Summary--");
      System.out.printf("Number of players in team: %1$d", team.getPlayerCount()); // Output the details of the team the user created, starting with the team name.
      
      StringBuilder stringBuilder = new StringBuilder(); // Because the team name is composed of an array of strings, we need to concatenate it with comma separation. StringBuilder() provides a safe means of doing so.
      String[] getPlayers = team.getPlayers(); // Get the players from the team we just created.
      for (int i = 0; i < team.getPlayerCount(); i++)
      {
        if (i > 0) 
        {
          stringBuilder.append(','); // Add a comma separation if this is the 2nd player or beyond.
        }
        stringBuilder.append(getPlayers[i]); // Append the string with the player name.
      } // end for
      
      System.out.printf("\nPlayers on team: %1$s", stringBuilder.toString()); // Output the player names on the team.

      System.out.println("\n\nContinue? (y/n): ");
      String confirm = scanner.next(); // Check if the user wishes to create more teams.
      if (confirm.trim().toLowerCase().compareTo("y") == 0) // If the user types "Y" or "y", repeat the loop.
      { 
        continuePrompt = true; 
      }
      else // Otherwise, terminate the program.
      { 
        continuePrompt = false; 
      }
    } // end while
    
  } // end main

} // end TestSportsTeamApp
