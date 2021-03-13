/**
 * A class definition for faculty
 *
 * @author Amirhossein
 */
public class Faculty {
    private Lab[] labs;
    private int capacity;
    private int currentSize;
    private int avg;

    /**
     * initialize instance
     *
     * @param cap int
     */
    public Faculty(int cap) {
        capacity = cap;
        labs = new Lab[cap];
    }

    /**
     * add new lab to faculty
     *
     * @param lab Student
     */
    public void addLabs(Lab lab) {
        if (currentSize < capacity) {
            labs[currentSize] = lab;
            currentSize++;
        } else {
            System.out.println("Faculty is full!!!");
        }
    }

    /**
     * Print all labs and the lab average
     */
    public void printAll() {
        for (int i = 0; i < currentSize; i++) {
            labs[i].calculateAvg();
            System.out.println("Lab " + (i + 1) + ":");
            labs[i].print();
        }
    }

    /**
     * Print just single specific lab
     */
    public void printSingle(int expectedLab) {
        labs[expectedLab].calculateAvg();
        System.out.println("Lab " + (expectedLab) + ":");
        labs[expectedLab - 1].print();
    }

    /**
     * Calculate the faculty average grade
     */
    public void calculateAvg() {
        int sum = 0;
        int tempSize = 0;
        for (int i = 0; i < currentSize; i++) {
            labs[i].calculateAvg();
            sum += labs[i].getAvg() * labs[i].getCapacity();
            tempSize += labs[i].getCapacity();
        }
        avg = sum / tempSize;
    }

    /**
     * get faculty average
     *
     * @return avg int
     */
    public int getAvg() {
        return avg;
    }
}
