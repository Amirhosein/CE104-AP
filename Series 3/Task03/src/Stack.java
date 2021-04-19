public class Stack {
    private int size;
    private int arr[];
    private int top;

    public Stack(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    public boolean isFull() {
        return (size - 1 == top);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int peek() {
        return arr[top];
    }

    public void push(int num) {

        if (!isFull())
            arr[++top] = num;

        else
            System.out.println("StackOverFlow");
    }

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
