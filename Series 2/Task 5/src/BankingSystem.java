import java.util.ArrayList;
import java.util.Iterator;

public class BankingSystem {
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Account> accounts = new ArrayList<>();


    public boolean register(User user) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser == user)
                return false;
        }

        addUser(user);
        return true;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean login(String id, String password) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser.getId().equals(id) && thisUser.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeUser(User user) {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            if (thisUser == user) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public void displayUsers() {
        Iterator<User> it = this.users.iterator();

        while (it.hasNext()) {
            User thisUser = it.next();
            thisUser.printUserData();
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
    }

    public void displayAccounts() {
        Iterator<Account> it = this.accounts.iterator();

        while (it.hasNext()) {
            Account thisAcc = it.next();
            thisAcc.printAccountData();
        }
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
