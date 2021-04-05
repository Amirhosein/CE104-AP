import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();


    public BankingSystem() {
    }

    public boolean register(User user) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser.getId().equals(user.getId()))
                return false;
        }

        addUser(user);
        return true;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User login(String id, String password) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser.getId().equals(id) && thisUser.getPassword().equals(password)) {
                return thisUser;
            }
        }
        return null;
    }

    public void removeUser(User user) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser == user) {
                it.remove();
            }
        }
    }

    public void displayUsers() {
        Iterator<User> it = this.users.iterator();
        int index = 1;

        while (it.hasNext()) {
            User thisUser = it.next();
            System.out.print("User " + index + ":");
            thisUser.printUserData();
            index++;
        }
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        Iterator<Account> it = this.accounts.iterator();

        while (it.hasNext()) {
            Account thisAcc = it.next();
            if (thisAcc == account) {
                it.remove();
                break;
            }
        }
        Iterator<User> userIterator = this.users.iterator();

        while (userIterator.hasNext()) {
            User thisUser = userIterator.next();
            if (thisUser.getId().equals(account.getId())) {
                Iterator<Account> target = thisUser.getAccountList().iterator();
                while (target.hasNext()) {
                    Account thisAcc = target.next();
                    if (thisAcc == account) {
                        target.remove();
                        break;
                    }
                }
                break;
            }
        }
    }

    public void displayAccounts() {
        Iterator<Account> it = this.accounts.iterator();
        int index = 1;

        while (it.hasNext()) {
            Account thisAcc = it.next();
            System.out.print("Account " + index + ": ");
            thisAcc.printAccountData();
            index++;
        }
    }

    public User findUser(String id) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (id.equals(thisUser.getId())) {
                return thisUser;
            }
        }

        return null;

    }

    public Account findAccount(String serial) {
        Iterator<Account> it = this.accounts.iterator();

        while (it.hasNext()) {
            Account thisAcc = it.next();
            if (serial.equals(thisAcc.getSerial())) {
                return thisAcc;
            }
        }
        return null;
    }


}
