package Client.View;


/**
 * @author Amir Iravanimanesh
 * @date 5/31/2021
 */
public class Menu {
    public static void mainMenu() {
        System.out.print("""
                Please enter host port:\040""");
    }

    public static void enterUsername(){
        System.out.print("Please enter your desired username: ");
    }

    public static void registerError() {
        System.out.println("Username already exists.");
    }

    public static void successfulRegister() {
        System.out.println("Registered Successfully.");
    }

}
