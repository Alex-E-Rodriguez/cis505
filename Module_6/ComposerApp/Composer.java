/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_6.ComposerApp;

public class Composer {
    // Instanced variables
    private int id;
    private String name;
    private String genre;

    /** 
     * Default constructor for the Composer class.
     * @return returns an instance of Composer with the current id, a blank name, and a blank genre.
    */
    Composer() 
    {
        id = 0;
        name = "";
        genre = "";
    } // end constructor

    /** 
     * Overloaded constructor for the Composer class.
     * @param int id
     * @param String name
     * @param String genre
     * @return returns an instance of Composer with the specified id, name, and genre.
    */
    Composer(int id, String name, String genre) 
    {
        this.id = id;
        this.name = name;
        this.genre = genre;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the composer ID.
     * @return the ID as an integer.
    */
    public int getId() 
    {
        return id;
    } // end getId

    /** 
     * Method with one argument, which is used as a mutator for the composer ID.
     * @param id int
    */
    public void setId(int id)
    {
        this.id = id;
    } // end setId

    /** 
     * Method with no arguments, which is used as an accessor for the composer name.
     * @return the name as a string.
    */
    public String getName() 
    {
        return name;
    } // end getName

    /** 
     * Method with one argument, which is used as a mutator for the composer name.
     * @param name String
    */
    public void setName(String name)
    {
        this.name = name;
    } // end setName
    
    /** 
     * Method with no arguments, which is used as an accessor for the composer genre.
     * @return the genre as a string.
    */
    public String getGenre() 
    {
        return genre;
    } // end getGenre

    /** 
     * Method with one argument, which is used as a mutator for the composer genre.
     * @param name String
    */
    public void setGenre(String genre)
    {
        this.genre = genre;
    } // end setGenre

    /** 
     * Override method to output the current Composer.
     * @return returns a String that reports the Composer's ID, name, and genre.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("  Id: %1$d\n", id));
        stringBuilder.append(String.format("  Name: %1$s\n", name));
        stringBuilder.append(String.format("  Genre: %1$s\n",genre));
        return stringBuilder.toString();
    } // end toString

}
