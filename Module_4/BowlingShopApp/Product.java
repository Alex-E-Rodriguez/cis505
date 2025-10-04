/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_4.BowlingShopApp;

public class Product {
    // Instanced Variables
    private String code; // A private string data field that specifies the product's code. Default empty string.
    private String description; // A private string data field that specifies the product's description. Default empty string.
    private double price; // A private string data field that specifies the product's price. Default 0.
    
    /** 
     * Default constructor for the Product class.
     * @return returns an instance of Product with a default code and description of empty string and price of 0.
    */
    Product() 
    {
        code = "";
        description = "";
        price = 0.0d;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the product's code.
     * @return the product's code as a string.
    */
    public String getCode() 
    {
        return code;
    } // end getCode

    /** 
     * Method with one argument, which is used as a mutator for the product's code.
     * @param code String
    */
    public void setCode(String code) 
    {
        this.code = code;
    } // end setCode

    /** 
     * Method with no arguments, which is used as an accessor for the product's description.
     * @return the product's description as a string.
    */
    public String getDescription() 
    {
        return description;
    } // end getDescription
    
    /** 
     * Method with one argument, which is used as a mutator for the product's description.
     * @param description String
    */
    public void setDescription(String description) 
    {
        this.description = description;
    } // end setDescription

    /** 
     * Method with no arguments, which is used as an accessor for the product's price.
     * @return the product's price as a string.
    */
    public double getPrice() 
    {
        return price;
    } // end getPrice

    /** 
     * Method with one argument, which is used as a mutator for the product's price.
     * @param price String
    */
    public void setPrice(double price) 
    {
        this.price = Math.max(0.0d, price); // Price must be non-negative
    } // end setPrice

    /** 
     * Override method to output the current product details.
     * @return returns a String that reports the Product's code, description, and price.
    */
    @Override public String toString() 
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("  Product Code: %1$s\n",code));
        stringBuilder.append(String.format("  Description: %1$s\n",description));
        stringBuilder.append(String.format("  Price: $%,6.2f\n",price));
        return stringBuilder.toString();
    } // end toString
}
