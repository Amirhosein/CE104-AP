package Client.View;

import java.util.Scanner;

/**
 * @author Amir Iravanimanesh
 * @date 5/31/2021
 */
public class TerminalInput {
    private static final Scanner input = new Scanner(System.in);

    public static String getInput(){
        return input.nextLine();
    }
}
