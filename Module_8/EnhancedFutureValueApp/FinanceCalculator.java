package Module_8.EnhancedFutureValueApp;

public class FinanceCalculator {
    private static int MONTHS_IN_YEAR = 12;
    
    /** 
     * Static method with three arguments, which is used to calculate the future value based on a set monthly payment and rate over a set number of years.
     * @param double monthlyPayment
     * @param double rate
     * @param int years
     * @return futureValue as a double
    */
    public static double calculateFutureValue(double monthlyPayment, double rate, int years) 
    {
        int months = years * MONTHS_IN_YEAR; // Calculate the number of months passed
        double interestRate = (1 + (rate / 100.0d)); // Calculate the annual interest rate, with +1 to ensure it is never below 100%
        double presentValue = monthlyPayment * months; // Calculate the present value based on the monthly payment times the number of months passed
        double futureValue = presentValue * (Math.pow(interestRate, months)); // Calculate the future value based on the present value times to interest rate to the power of the months passed
        return futureValue; // Return the future value
    } // end calculateFutureValue
}
