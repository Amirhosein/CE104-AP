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

    public static void accountMenu() {
        System.out.println("**NOTE: to go to previous Menu type \"back\" **\n");
        System.out.println("1.Withdrawal");
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
        User sysadmin = new User("admin", "admin","sysadmin", "1234");

        Scanner input = new Scanner(System.in);
        String inputString;

        label:
        while (true) {
            mainMenu();
            inputString = input.nextLine();
            if ("1".equals(inputString)) {
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
            } else if ("2".equals(inputString)) {
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
                        if (user.printAllAvailableAccounts()) {
                            int intInput;
                            intInput = input.nextInt();
                            Account account = user.accIndex(intInput);
                            if (account == null) {
                                System.out.println("Out of index.");
                                continue;
                            }
                            input.nextLine();
                            while (true) {
                                accountMenu();
                                inputString = input.nextLine();
                                if (inputString.equals("1")) {
                                    System.out.print("Value: ");
                                    intInput = input.nextInt();
                                    input.nextLine();
                                    if (user.withdrawal(account, intInput)) {
                                        System.out.println("Completed.");
                                    } else
                                        System.out.println("Not enough money.");

                                } else if (inputString.equals("2")) {
                                    System.out.print("Value: ");
                                    intInput = input.nextInt();
                                    input.nextLine();
                                    user.deposit(account, intInput);
                                    System.out.println("Completed.");
                                } else if (inputString.equals("3")) {
                                    System.out.print("dest serial: ");
                                    inputString = input.nextLine();
                                    System.out.print("amount: ");
                                    intInput = input.nextInt();
                                    input.nextLine();
                                    Account destAccount = bankingSystem.findAccount(inputString);
                                    if (destAccount == null) {
                                        System.out.println("Destination account doesn’t exist or there is not enough money\n" +
                                                "in your account.");
                                        continue;
                                    }
                                    if(user.transfer(account, destAccount, intInput)){
                                        System.out.println("Completed.");
                                    }
                                    else
                                        System.out.println("Destination account doesn’t exist or there is not enough money\n" +
                                                "in your account.");
                                } else if (inputString.equals("4")){
                                    System.out.println("Available balance: " + account.getBalance());
                                } else if (inputString.equals("5")){
                                    System.out.println("Logged out of account.");
                                    break;
                                }
                            }
                        } else
                            System.out.println("You haven't created any account yet.");
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
            } else if ("3".equals(inputString)){

            }
            else if ("4".equals(inputString)) {
                break;
            }
        }

    }
}
