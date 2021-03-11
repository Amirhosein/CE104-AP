import java.util.*;

public class Q6 {
    static String  xoring(String a, String b, int n){
        String ans = "";

        // Loop to iterate over the
        // Binary Strings
        for (int i = 0; i < n; i++)
        {
            // If the Character matches
            if (a.charAt(i) == b.charAt(i))
                ans += "0";
            else
                ans += "1";
        }
        return ans;
    }

    public static void main(String[] args){
        String key = "";
        String voroodi = "";
        Scanner input = new Scanner(System.in);

        key = input.nextLine();
        voroodi = input.nextLine();

        for (int i = 0; i < voroodi.length(); i++) {
            String binary = String.format("%8s", Integer.toBinaryString((int)voroodi.charAt(i))).replace(' ', '0');
            String result = xoring(binary,key,8);
            System.out.print(result);
            if (i != voroodi.length() - 1)
                System.out.print(" ");
        }
    }
}
