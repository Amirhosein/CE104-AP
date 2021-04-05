import java.util.ArrayList;
import java.util.UUID;

public class Account {
    private final UUID serial = UUID.randomUUID();
    private String id;
    private String firstName;
    private String lastName;
    private String type;
    private long balance;
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Account(String id, String firstName, String lastName, String type, long balance) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.type = type;
        this.balance = balance;
    }

    public boolean updateBalance(int amount) {
        if (balance + amount < 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (Transaction transaction : this.transactions) {
            System.out.println("\n-----------------");
            transaction.print();
            System.out.println("\n-----------------");
        }
    }

    public void printAccountData() {
        System.out.print(serial + ", " + id + ", " + firstName + ", " + lastName + ", " + type + ", " + balance + "\n");
    }

    public long getBalance() {
        return balance;
    }

    public String getSerial() {
        return serial.toString();
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getType() {
        return type;
    }
}
