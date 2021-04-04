import java.util.*;

public class Main {

    public static void mainMenu() {
        System.out.println("**NOTE: to go to previous Menu type \"back\" **\n");
        System.out.println("1.Sign up");
        System.out.println("2.Log in");
        System.out.println("3.System Admin");
        System.out.println("4.Exit");
    }

    public static void loginMenu() {
        System.out.println("**NOTE: to go to previous Menu type \"back\" **\n");
        System.out.println("1.Existing accounts");
        System.out.println("2.Add new account");
        System.out.println("3.Log out");
    }

    public static void accountMenu(){
        System.out.println("**NOTE: to go to previous Menu type \"back\" **\n");
        System.out.println("1.WithDrawal");
        System.out.println("2.Deposit");
        System.out.println("3.Transfer");
        System.out.println("4.Check balance");
        System.out.println("5.Back");
    }

    public static void systemAdminMenu() {
        System.out.println("**NOTE: to go to previous Menu type \"back\" **\n");
        System.out.println("1.Display users");
        System.out.println("2.Display accounts");
        System.out.println("3.Remove user");
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        Scanner input = new Scanner(System.in);
        String inputString;

        label:
        while (true) {
            mainMenu();
            inputString = input.nextLine();
            switch (inputString) {
                case "1": {
                    String firstName, lastName, id, password;
                    System.out.print("First name: ");
                    firstName = input.nextLine();
                    System.out.print("Last name: ");
                    lastName = input.nextLine();
                    System.out.print("ID: ");
                    id = input.nextLine();
                    System.out.print("Password: ");
                    password = input.nextLine();
                    User user = new User(firstName, lastName, id, password);
                    if (bankingSystem.register(user))
                        System.out.println("user created.");
                    else
                        System.out.println("user already exists.");

                    break;
                }
                case "2": {
                    String id, password;
                    System.out.print("ID: ");
                    id = input.nextLine();
                    System.out.print("Passwrod: ");
                    password = input.nextLine();
                    User user = bankingSystem.login(id, password);
                    if (user != null)
                        System.out.println("Logged in.");
                    else {
                        System.out.println("user doesn't exists or password is incorrect.");
                        continue;
                    }
                    while (true) {
                        loginMenu();
                        inputString = input.nextLine();
                        if (inputString.equals("1")) {
                            user.printAllAvailableAccounts();
                        } else if (inputString.equals("2")) {
                            System.out.print("Type: ");
                            inputString = input.nextLine();
                            Account account = new Account(user.getId(), user.getFirstName(), user.getLastName(), inputString, 0);
                            user.addAccount(account);
                            bankingSystem.addAccount(account);
                            System.out.println("New account opened.");
                        } else if (inputString.equals("3")) {
                            System.out.println("Logged out successfully.\n\n");
                            break;
                        }
                    }

                }
                case "4":
                    break label;
            }
        }

    }
}
