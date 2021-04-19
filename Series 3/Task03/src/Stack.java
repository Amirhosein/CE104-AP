/**
 * The type Stack.
 */
public class Stack {
    private int size;
    private int arr[];
    private int top;

    /**
     * Instantiates a new Stack.
     *
     * @param size the size
     */
    public Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    /**
     * Is full boolean.
     *
     * @return the boolean
     */
    public boolean isFull() {
        return (size - 1 == top);
    }

    /**
     * Is empty boolean.
     *
     * @return the boolean
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Peek int.
     *
     * @return the int
     */
    public int peek() {
        return arr[top];
    }

    /**
     * Push.
     *
     * @param num the num
     */
    public void push(int num) {

        if (!isFull())
            arr[++top] = num;

        else
            System.out.println("StackOverFlow");
    }

    /**
     * Pop int.
     *
     * @return the int
     */
    public int pop() {
        if (!isEmpty()) {
            int val = arr[top];
            top--;
            return val;
        } else {
            System.out.println("StackUnderFlow");
            return -1;
        }
    }
}
