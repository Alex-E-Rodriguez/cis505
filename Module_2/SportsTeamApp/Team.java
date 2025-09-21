/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_2.SportsTeamApp;

public class Team {
    // Instanced Variables
    private String teamName; // A private string data field named teamName that specifies the teams name. Default empty string.
    private String[] players; // A private string array data field named players that specifies the players assigned to a team. Default size 20.
    private int playerCount; // A private int data field named playerCount that specifies the number of players on a team. Default 0.

    /** 
     * Function that adds a player to the list of players.
     * @param player String
     * @return no output, but the instanced array players and instanced count playerCount are modified with the added player string and +1 respectively.
    */
    public void addPlayer(String player)
    {
        if (this.playerCount >= this.players.length) 
        { 
            System.out.printf("\nCannot add %1$s; the team has already reached its player limit (%2$d)!", player, this.players.length); 
            return;
        }
        this.players[this.playerCount] = player;
        this.playerCount++;
    } // end addPlayer

    /** 
     * Method with no arguments, which is used as an accessor for the current list of player names.
     * @return the team's player names, as an array of strings.
    */
    public String[] getPlayers() 
    {
        return players;
    } // end getPlayers

    /** 
     * Method with no arguments, which is used as an accessor for the current player count.
     * @return the number of players on the team, as an integer. Should always be <= players.length.
    */
    public int getPlayerCount() 
    {
        return playerCount;
    } // end getPlayerCount

    /** 
     * Method with no arguments, which is used as an accessor for the current team name.
     * @return the team name as a string.
    */
    public String getTeamName() 
    {
        return teamName;
    } // end getTeamName

    
    /** 
     * Default constructor for the Team class.
     * @return returns an instance of Team with no name, an array of 20 players with no name (equivalent to no players), and a player count of 0. Use addPlayer() to add players.
    */
    Team() 
    {
        teamName = "";
        players = new String[20]; // Pre-allocate the player array to the maximum number of team members possible (20).
        playerCount = 0;
    } // end constructor

    /** 
     * Overloaded constructor for the Team class with an included team name.
     * @param teamName string
     * @return returns an instance of Team with its team name set to teamName, an array of 20 players with no name (equivalent to no players), and a player count of 0. Use addPlayer() to add players.
    */
    Team(String teamName) 
    {
        this.teamName = teamName; // this.teamName ensures we are modifying the instanced variable due to name shadowing.
        players = new String[20]; // Pre-allocate the player array to the maximum number of team members possible (20).
        playerCount = 0;
    } // end constructor


} // end Team
