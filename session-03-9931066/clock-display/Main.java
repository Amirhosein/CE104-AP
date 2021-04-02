import java.util.*;

public class Main {
    public static void menu() {
        System.out.print("1. Time tick\n2. Print Clock\n3. Set clock\n4. Exit\n");
    }

    public static void main(String[] args) {
        int choose = 0;
        int hour, minute, second;
        ClockDisplay result = new ClockDisplay();
        Scanner input = new Scanner(System.in);

        System.out.println("Press 1 for manual time set and 2 for time 00:00:00");
        choose = input.nextInt();

        if (choose == 1) {
            System.out.println("Please enter Hour, minute, second line by line:");
            hour = input.nextInt();
            minute = input.nextInt();
            second = input.nextInt();
            result = new ClockDisplay(hour, minute, second);
        } else if (choose == 2) {
            result = new ClockDisplay();
        }

        while (true) {
            menu();
            choose = input.nextInt();

            if (choose == 1) {
                result.timeTick();
            } else if (choose == 2) {
                System.out.println(result.getTime());
            } else if (choose == 3) {
                System.out.println("Please enter Hour, minute, second line by line:");
                hour = input.nextInt();
                minute = input.nextInt();
                second = input.nextInt();
                result.setTime(hour, minute, second);
            } else {
                break;
            }
        }

    }
}
