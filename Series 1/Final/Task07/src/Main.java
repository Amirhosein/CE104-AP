import java.util.Scanner;

public class Main {
    public static int additional(String str1, String str2) {
        int count = 0;
        int str1i = 0, str2i = 0;
        for (int i = 0; i < str2.length(); i++, str1i++, str2i++) {
            if (str1.length() == str1i) {
                count++;
            }
            else if (str1.charAt(str1i) != str2.charAt(str2i)) {
                count++;
                str1i--;
            }
        }

        return count;
    }

    public static int differential(String str1, String str2) {
        int count = 0;
        int str1i = 0, str2i = 0;
        for (int i = 0; i < str1.length(); i++, str1i++, str2i++) {
            if (str2.length() == str2i) {
                count++;
            }
            else if (str1.charAt(str1i) != str2.charAt(str2i)) {
                count++;
                str2i--;
            }
        }

        return count;
    }

    public static int replace(String str1, String str2) {
        char letter1 = 0;
        char letter2 = 0;

        int count = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                if (!(letter1 == str1.charAt(i) && letter2 == str2.charAt(i))) {
                    letter1 = str1.charAt(i);
                    letter2 = str2.charAt(i);
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        int result;

        if (str1.length() == str2.length() + 1) {
            result = differential(str1, str2);
        }
        else if (str1.length() == str2.length() - 1) {
            result = additional(str1, str2);
        }
        else if (str1.length() == str2.length()) {
            result = replace(str1, str2);
        }
        else {
            result = -1;
        }

        if (result == 1) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}
