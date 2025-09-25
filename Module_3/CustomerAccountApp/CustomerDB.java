package Module_3.CustomerAccountApp;

public class CustomerDB {

    /** 
     * Static method with one argument, which is used to find a customer of a specified id. Note that id can be null.
     * @param Integer id
     * @return the Customer class of the specified id, if it can be found (default Customer otherwise)
    */
    public static Customer getCustomer(Integer id)
    {
        // Search the database for a specific customer, and return it if the ID matches the ID we are searching for.
        if (id == 1007) 
        {
            return new Customer("Marcus Brut", "1700 Iron Lane", "Gateway", "92976"); 
        }
        else if (id == 1008) 
        {
            return new Customer("Walt Whitman", "3828 Piermont Drive NE", "Albuquerque" , "87111"); 
        }
        else if (id == 1009) 
        {
            return new Customer("Charley McRoberts", "1607 San Cristobal Road SW", "Albuquerque", "87104"); 
        }

        // If the ID is not in our database, return a default customer.
        return new Customer();
    } // end getCustomer
}
