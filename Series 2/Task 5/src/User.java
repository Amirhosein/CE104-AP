import java.util.ArrayList;
import java.util.Iterator;

public class User {
    private String firstName;
    private String lastName;
    private final String id;
    private String password;
    private ArrayList<Account> accountList = new ArrayList<>();

    public User(String firstName, String lastName, String id, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.password = password;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public void removeAccount(Account account) {
        Iterator<Account> it = this.accountList.iterator();

        while (it.hasNext()) {
            Account thisAcc = it.next();
            if (thisAcc == account) {
                it.remove();
                break;
            }
        }
    }

    public void deposit(Account account, int amount) {
        Transaction transaction = new Transaction(amount);
        account.addTransaction(transaction);
        account.updateBalance(amount);
    }

    public boolean withdrawal(Account account, int amount) {
        Transaction transaction = new Transaction(-1 * amount);

        if (!account.updateBalance(-1 * amount)) {
            return false;
        }

        account.addTransaction(transaction);

        return true;
    }

    public boolean transfer(Account srcAccount, Account destAccount, int amount) {
        Transaction transaction1 = new Transaction(amount);
        Transaction transaction2 = new Transaction(-1 * amount);

        if (!srcAccount.updateBalance(-1 * amount)) {
            return false;
        }

        destAccount.updateBalance(amount);

        srcAccount.addTransaction(transaction2);
        destAccount.addTransaction(transaction1);
        return true;
    }

    public void checkBalance(Account account) {
        System.out.println(account.getBalance());
    }

    public boolean printAllAvailableAccounts() {
        Iterator<Account> it = this.accountList.iterator();
        int index = 1;
        if (!it.hasNext())
            return false;
        while (it.hasNext()) {
            Account thisAcc = it.next();
            System.out.print("Account " + index + ": ");
            thisAcc.printAccountData();
            index++;
        }
        return true;
    }

    public void printUserData() {
        System.out.println(this.firstName + ", " + this.lastName + ", " + this.id);
    }

    public Account accIndex(int index) {
        Iterator<Account> it = this.accountList.iterator();
        index -= 1;
        int i;
        Account thisAcc = it.next();
        for (i = 0; i < index && it.hasNext(); i++)
            thisAcc = it.next();

        if (!it.hasNext() && i != index)
            return null;

        return thisAcc;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Account> getAccountList() {
        return accountList;
    }
}
