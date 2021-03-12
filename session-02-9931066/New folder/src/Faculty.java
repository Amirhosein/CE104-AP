/**
 *
 *
 */
public class Faculty {
    private Lab[] labs;
    private int capacity;
    private int currentSize;
    private int avg;

    public Faculty(int cap) {
        capacity = cap;
        labs = new Lab[cap];
    }

    public void addLabs(Lab lab) {
        if (currentSize < capacity) {
            labs[currentSize] = lab;
            currentSize++;
        } else {
            System.out.println("Faculty is full!!!");
        }
    }

    public void printAll() {
        for (int i = 0; i < currentSize; i++) {
            labs[i].calculateAvg();
            System.out.println("Lab " + (i + 1) + ":");
            labs[i].print();
        }
    }

    public void printSingle(int expectedLab) {
        labs[expectedLab].calculateAvg();
        System.out.println("Lab " + (expectedLab) + ":");
        labs[expectedLab - 1].print();
    }

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

    public int getAvg() {
        return avg;
    }
}
