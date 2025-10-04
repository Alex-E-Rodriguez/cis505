/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_4.BowlingShopApp;

public class Shoe extends Product {
    // Instanced Variables
    private double size; // A private string data field that specifies the shoe size. Default empty string.

    /** 
     * Default constructor for the Shoe class.
     * @return returns an instance of Shoe with a shoe size of 0.
    */
    Shoe() 
    {
        size = 0.0d;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the current shoe size.
     * @return the shoe size as a double.
    */
    public double getSize() 
    {
        return size;
    } // end getSize

    /** 
     * Method with one argument, which is used as a mutator for the shoe size.
     * @param size double
    */
    public void setSize(double size)
    {
        this.size = size;
    } // end setSize

    /** 
     * Override method to output the current Shoe.
     * @return returns a String that reports the Product's details alongside the Shoe's size.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append(String.format("  Size: %.1f\n", size));
        return stringBuilder.toString();
    } // end toString
}
