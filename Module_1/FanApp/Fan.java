/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Module_1.FanApp;

public class Fan {

    /** 
     * The following constant variables represent different speed states the Fan can have.
     * These could be represented as a enum in the future.
    */
    final static int STOPPED = 0;
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;

    // Instanced Variables
    private boolean fanToggle; // Indicates if the fan is on or off.
    private int fanSpeed; // The fan's speed, represented as an integer state corresponding to STOPPED (0), SLOW (1), MEDIUM (2), or FAST (3).
    private double fanRadius; // The fan's radius, expressed as a double-precision floating-point number.
    private String fanColor; // The fan's color, expressed as a string. Will always be lowercase.

    /** 
     * Method with no arguments, which is used as an accessor for the fan's current on/off state.
     * @return the fan's current on/off state, fanToggle, as a boolean
    */
    public boolean getFanToggle() {
        return fanToggle;
    }

    /** 
     * Method with one argument, which is used as a mutator for the fan's current on/off state.
     * @param newToggle boolean
    */
    public void setFanToggle(boolean newToggle) {
        fanToggle = newToggle;
    }

    /** 
     * Method with no arguments, which is used as an accessor for the fan's current speed state.
     * @return the fan's current speed, fanSpeed, as an int state corresponding to STOPPED (0), SLOW (1), MEDIUM (2), or FAST (3).
    */
    public int getFanSpeed() {
        return fanSpeed;
    }

    /** 
     * Method with one argument, which is used as a mutator for the fan's current speed state.
     * @param newSpeed int
    */
    public void setFanSpeed(int newSpeed) {
        /** 
         * Though it would preferred to use a byte type, the assignment calls for int. Nonetheless, we can still sanitize the input.
         * Only the following int states are valid: STOPPED (0), SLOW (1), MEDIUM (2), or FAST (3).
        */
        fanSpeed = Math.clamp(newSpeed, STOPPED, FAST);
    }

    /** 
     * Method with no arguments, which is used as an accessor for the fan's current radius.
     * @return the fan's current radius, fanRadius, as a double
    */
    public double getFanRadius() {
        return fanRadius;
    }

    /** 
     * Method with one argument, which is used as a mutator for the fan's current radius.
     * @param newRadius double
    */
    public void setFanRadius(double newRadius) {
        // The radius should never be negative.
        fanRadius = Math.abs(newRadius);
    }

    /** 
     * Method with no arguments, which is used as an accessor for the fan's current color.
     * @return the fan's current color, fanColor, as a String
    */
    public String getFanColor() {
        return fanColor;
    }

    /** 
     * Method with one argument, which is used as a mutator for the fan's current color.
     * @param newColor String
    */
    public void setFanColor(String newColor) {
        // The color will always be lowercase.
        fanColor = newColor.toLowerCase();
    }

    /** 
     * Default constructor for the Fan class.
     * @return returns an instance of Fan that is off, with a speed of 0 (stopped), a radius of 6, and colored white.
    */
    Fan() {
        fanToggle = false;
        fanSpeed = STOPPED;
        fanRadius = 6.0f;
        fanColor = "white";
    }

    /** 
     * Overloaded constructor for the Fan class for all potential instanced data fields.
     * @param inToggle boolean
     * @param inSpeed int
     * @param inRadius double
     * @param inColor String
     * @return returns an instance of Fan with its on/off state, speed, radius, and color equal to sanitized versions of their respective inputs.
    */
    Fan(boolean inToggle, int inSpeed, double inRadius, String inColor) {
        fanToggle = inToggle;
        fanSpeed = Math.clamp(inSpeed, STOPPED, FAST); // Ensure that only valid values are permitted for the speed setting.
        fanRadius = Math.abs(inRadius); // Ensure that the radius is non-negative.
        fanColor = inColor.toLowerCase(); // Ensure we have consistency across strings (all lowercase) to prevent erratic conditional reads in future behavior.
    }

    /** 
     * Override method to output the current status of a given Fan.
     * @return returns a String that reports if the fan is on or off, its current radius and color, and, if it is on, its current speed.
    */
    @Override public String toString() 
    {
        if (fanToggle) {
            return String.format("The fan is on, with speed set to %1$d, with a radius of %2$.2f, and is colored %3$s!", fanSpeed, fanRadius, fanColor);
        }
        // Because we have an early return, the following below will only run if it is false (i.e. the fan is off)
        return String.format("The fan has a radius of %1$.2f and is colored %2$s, but the fan is off!", fanRadius, fanColor);        
    }
} // end Fan
