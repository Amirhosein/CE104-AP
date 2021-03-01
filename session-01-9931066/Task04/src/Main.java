public class Main {
    public static void myFunction(int i) {
        i++;
        System.out.println("The variable you passed was " + i);
    }

    public static void main(String[] args) {
        int i = 0;
        i = 25;
        myFunction(i);
        System.out.println("Hello World!");
    }
}