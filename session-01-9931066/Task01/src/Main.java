import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int a = input.nextInt();
        int b = input.nextInt();
        int temp;

        while (b != 0) {

            if (a < b) {
                temp = a;
                a = b;
                b = temp;
            }

            temp = b;
            b = a % b;
            a = temp;
        }
        if (a == 1)
            System.out.println("They are relatively prime");
        else
            System.out.println("They are not relatively prime");

    }
}