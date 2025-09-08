/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_1.FanApp;

public class TestFanApp {
    /** 
     * The following application creates and outputs the status of two unique fans:
     * The first, a default fan, is off, with a speed of 0 (stopped), a radius of 6, and is colored white.
     * The second, a customized fan, is on, with a speed of 2 (medium), a radius of 5.5, and is colored red.
    */
    public static void main(String[] args)
    {
        Fan defaultFan = new Fan(); // Creates a Fan with default settings.
        Fan customFan = new Fan(true, Fan.MEDIUM, 5.5f, "Red"); // Creates a Fan that is on, has a speed of MEDIUM, a radius of 6, and is colored red.
        System.out.println(defaultFan.toString()); // Output the details of our default fan.
        System.out.println(customFan.toString()); // Output the details of the fan with specifically defined parameters.
    }
}
