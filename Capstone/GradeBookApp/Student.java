/*
    Rodriguez, A. (2025). CIS 505 Intermediate Java Programming. Bellevue University.
*/

package Capstone.GradeBookApp;

public class Student {

    // Instanced Variables
    private String firstName;
    private String lastName;
    private String course;
    private String grade;

    /** 
     * Default constructor for the Student class.
     * @return returns an instance of Student with a blank name, course, and grade.
    */
    Student() 
    {
        this.firstName = "";
        this.lastName = "";
        this.course = "";
        this.grade = "";
    } // end constructor

    /** 
     * Overloaded constructor for the Student class with an included first name, last name, course, and grade.
     * @param firstName string
     * @param lastName string
     * @param course string
     * @param grade string
     * @return returns an instance of Student with a user-specified first name, last name, course, and grade as input strings.
    */
    Student(String firstName, String lastName, String course, String grade)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.course = course;
        this.grade = grade;
    } // end constructor

    /** 
     * Method with no arguments, which is used as an accessor for the student's first name.
     * @return the student's first name as a string.
    */
    public String getFirstName() 
    {
        return firstName;
    } // end getFirstName

    /** 
     * Method with one argument, which is used as a mutator for the student's first name.
     * @param firstName String
    */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    } // end setFirstName

    /** 
     * Method with no arguments, which is used as an accessor for the student's last name.
     * @return the student's last name as a string.
    */
    public String getLastName() 
    {
        return lastName;
    } // end getLastName

    /** 
     * Method with one argument, which is used as a mutator for the student's last name.
     * @param lastName String
    */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    } // end setLastName

    /** 
     * Method with no arguments, which is used as an accessor for the student's course.
     * @return the student's course as a string.
    */
    public String getCourse() 
    {
        return course;
    } // end getCourse

    /** 
     * Method with one argument, which is used as a mutator for the student's course.
     * @param course String
    */
    public void setCourse(String course)
    {
        this.course = course;
    } // end setCourse

    /** 
     * Method with no arguments, which is used as an accessor for the student's grade.
     * @return the student's grade as a string.
    */
    public String getGrade() 
    {
        return grade;
    } // end getGrade

    /** 
     * Method with one argument, which is used as a mutator for the student's grade.
     * @param grade String
    */
    public void setGrade(String grade)
    {
        this.grade = grade;
    } // end setGrade

    /** 
     * Method with one argument, which is used to test if a string grade is a valid value (A, B, C, D, or F)
     * @param grade String
     * @return the grade's validity as a boolean (true = valid, false = invalid)
    */
    public boolean gradeIsValid(String grade) 
    {
        return grade.equalsIgnoreCase("A") || grade.equalsIgnoreCase("B") || grade.equalsIgnoreCase("C") || grade.equalsIgnoreCase("D") || grade.equalsIgnoreCase("F");
    }
}
