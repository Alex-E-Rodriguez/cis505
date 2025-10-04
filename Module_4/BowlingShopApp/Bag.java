/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_4.BowlingShopApp;

public class Bag extends Product {
    // Instanced Variables
    private String type; // A private string data field that specifies the ball's color. Default empty string.

    /** 
     * Default constructor for the Bag class.
     * @return returns an instance of Bag with a default number of balls it can hold.
    */
    Bag() 
    {
        type = "";
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the current number of balls the bag can hold.
     * @return the number of balls the bag can hold as a string.
    */
    public String getType() 
    {
        return type;
    } // end getType

    /** 
     * Method with one argument, which is used as a mutator for the number of bags the ball can hold.
     * @param type String
    */
    public void setType(String type)
    {
        this.type = type;
    } // end setType

    /** 
     * Override method to output the current Bag.
     * @return returns a String that reports the Product's details alongside the Bag's type.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(String.format("  Type: %1$s\n", type));
        return stringBuilder.toString();
    } // end toString
}
