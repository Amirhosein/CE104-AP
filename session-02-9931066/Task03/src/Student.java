/**
 * A class definition for student
 *
 * @author Amirhossein
 */
public class Student {
    private String firstName;

    private String lastName;

    private String ID;

    private int grade;

    /**
     * Create a new student with a given name and ID number. *
     *
     * @param fName first name of students
     * @param lName last name of students
     * @param sID   ID of students
     */
    public Student(String fName, String lName, String sID) {
        firstName = fName;
        lastName = lName;
        ID = sID;
        grade = 0;
    }

    /**
     * get student's first name
     *
     * @return firstName string
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param fName set first name of student
     */
    public void setFirstName(String fName) {
        firstName = fName;
    }

    /**
     * get student's last name
     *
     * @return lastName string
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lName set last name of student
     */
    public void setLastName(String lName) {
        lastName = lName;
    }

    /**
     * get student's ID
     *
     * @return ID string
     */
    public String getID() {
        return ID;
    }

    /**
     * @param sID set ID of student
     */
    public void setID(String sID) {
        ID = sID;
    }

    /**
     * get student's grade
     *
     * @return grade int
     */
    public int getGrade() {
        return grade;
    }

    /**
     * @param Grade set grade of student
     */
    public void setGrade(int Grade) {
        grade = Grade;
    }

    /**
     * print all information of a student.
     */
    public void print() {
        System.out.println("Name: " + firstName + " " + lastName + "\n" + "Student ID: " + ID + "\n" + "Grade: " + grade + "\n\n");
    }
}

