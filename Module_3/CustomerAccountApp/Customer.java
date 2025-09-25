package Module_3.CustomerAccountApp;

public class Customer {

    // Instanced Variables
    private String name; // Customer's name. Default empty string.
    private String address; // Customer's address. Default empty string.
    private String city; // Customer's city. Default empty string.
    private String zip; // Customer's zip. Default empty string.

    /** 
     * Default constructor for the Customer class.
     * @return returns an instance of Customer with no name, address, city, or zip code.
    */
    Customer() 
    {
        name = "";
        address = "";
        city = "";
        zip = "";
    } // end constructor

    /** 
     * Overloaded constructor for the Customer class with an included name, address, city, and zip code.
     * @param name string
     * @param address string
     * @param city string
     * @param zip string
     * @return returns an instance of Customer with a user-specified name, address, city, and zip code as input strings.
    */
    Customer(String name, String address, String city, String zip)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the customer's current name.
     * @return the customer's current name as a string
    */
    public String getName() 
    {
        return name;
    } // end getName

    /** 
     * Method with no arguments, which is used as an accessor for the customer's current address.
     * @return the customer's current name as a address
    */
    public String getAddress() 
    {
        return address;
    } // end getAddress

    /** 
     * Method with no arguments, which is used as an accessor for the customer's current city.
     * @return the customer's current name as a city
    */
    public String getCity() 
    {
        return city;
    } // end getCity

    /** 
     * Method with no arguments, which is used as an accessor for the customer's current zip.
     * @return the customer's current name as a zip
    */
    public String getZip() 
    {
        return zip;
    } // end getZip

    /** 
     * Override method to output the current Customer.
     * @return returns a String that reports the Customer's name, address, city, and zip code.
    */
    @Override public String toString() 
    {
        return String.format("--Customer Details--\n  Name:%1$s\n  Address:%2$s\n  City:%3$s\n  Zip:%4$s", name, address, city, zip);        
    } // end toString
}
