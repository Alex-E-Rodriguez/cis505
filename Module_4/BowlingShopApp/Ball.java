/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_4.BowlingShopApp;

public class Ball extends Product {
    // Instanced Variables
    private String color; // A private string data field that specifies the ball's color. Default empty string.

    /** 
     * Default constructor for the Ball class.
     * @return returns an instance of Ball with a default color of empty string.
    */
    Ball() 
    {
        color = "";
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the ball's color.
     * @return the ball's color as a string.
    */
    public String getColor() 
    {
        return color;
    } // end getColor

    /** 
     * Method with one argument, which is used as a mutator for the ball's color.
     * @param color String
    */
    public void setColor(String color)
    {
        this.color = color;
    } // end setColor

    /** 
     * Override method to output the current Ball.
     * @return returns a String that reports the Product's details alongside the Ball's color.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(String.format("  Color: %1$s\n", color));
        return stringBuilder.toString();
    } // end toString
}
