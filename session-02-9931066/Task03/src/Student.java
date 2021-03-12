public class Student{
    private String firstName;

    private String lastName;

    private String ID;

    private int grade;


    public Student( String fName, String lName, String sID){
        firstName = fName;
        lastName = lName;
        ID = sID;
        grade = 0;
    }


    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String fName){
        firstName = fName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lName){
        lastName = lName;
    }

    public String getID(){
        return ID;
    }

    public void setID(String sID){
        ID = sID;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int Grade){
        grade = Grade;
    }

    public void print(){
        System.out.println("Name: " + firstName + " " + lastName + "\n" + "Student ID: " + ID + "\n" + "Grade: " + grade + "\n\n");
    }
}

