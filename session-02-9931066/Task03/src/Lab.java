/**
 * A class definition for lab
 */
public class Lab {
    private Student[] students;
    private int avg;
    private String day;
    private int capacity;
    private int currentSize;

    /**
     * initialize instance
     * @param cap int
     * @param d String
     */
    public Lab(int cap, String d) {
        capacity = cap;
        students = new Student[cap];
        day = d;
    }

    /**
     * enroll new student to lab
     * @param std Student
     */
    public void enrollStudent(Student std) {
        if (currentSize < capacity) {
            students[currentSize] = std;
            currentSize++;
        } else {
            System.out.println("Lab is full!!!");
        }
    }

    /**
     * Print all students and the lab average
     */
    public void print() {
        for (Student student: students) {
            student.print();
        }
        System.out.println("Average: " + getAvg() + "\n");
    }

    /**
     * get all students
     * @return students Student[]
     */
    public Student[] getStudents() {
        return students;
    }

    /**
     * set students list
     * @param students Student[]
     */
    public void setStudents(Student[] students) {
        this.students = students;
    }

    /**
     * get lab average
     * @return avg int
     */
    public int getAvg() {
        return avg;
    }

    /**
     * Calculate the lab average grade
     */
    public void calculateAvg() {
        int sum = 0;
        for (int i = 0; i < currentSize; i++) {
            sum += students[i].getGrade();
        }
        avg = sum / currentSize;
    }

    /**
     * get lab day
     * @return day String
     */
    public String getDay() {
        return day;
    }

    /**
     * set lab day
     * @param day String
     */
    public void setDay(String day) {
        this.day = day;
    }

    /**
     * get capacity
     * @return capacity int
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * set lab capacity
     * @param capacity int
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}